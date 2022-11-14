package ru.mpei.prob.model;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import ru.mpei.prob.model.CIMProfile.ExportMethods;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.AssociationSetter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CIMObjectsExport {
	private String directoryToSave;
	private String baseURI = "http://iec.ch/TC57/2013/CIM-schema-cim16#";
	private String ntiURI = "http://nti.mpei.ru/#";
	private String rdfXmlHead;
	private String rdfXmlTail;
	private ExportMethods exportMethods;
	private HashMap<String,String> iecClassesPathMap;
	private Set<String> exportedObjects;

	public CIMObjectsExport() {

	}

	/**
	 * Exporting all object.
	 */
	public InputStream export(Collection<Object> objectsMap){

		this.rdfXmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<rdf:RDF xmlns:cim=\"" + this.baseURI + "\" xmlns:nti=\"" + this.ntiURI + "\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n";
		this.rdfXmlTail = "</rdf:RDF>";

		exportMethods = new ExportMethods(this.baseURI);

        for (Object object: objectsMap){
            exportMethods.selectAndApplyExportMethod(object);
        }

		InputStream stream = new ByteArrayInputStream((this.rdfXmlHead+exportMethods.getRdfXmlBody()+this.rdfXmlTail).getBytes(StandardCharsets.UTF_8));

		return stream;
    }

    /**
     * Exporting one object and its tree leafs (other objects).
	 */
    public InputStream export(Object object){
		this.rdfXmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<rdf:RDF xmlns:cim=\"" + this.baseURI + "\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n";
		this.rdfXmlTail = "</rdf:RDF>";

		exportMethods = new ExportMethods(this.baseURI);

		exportedObjects = new HashSet<>();

		// получение полных путей к классам IEC
		this.getFullPathToIECClasses();

		// хождение по дереву и формирование RDF ресурсов для найденных объектов
		this.goDeepAtTree(object);

		InputStream stream = null;
		stream = new ByteArrayInputStream((this.rdfXmlHead+exportMethods.getRdfXmlBody()+this.rdfXmlTail).getBytes(StandardCharsets.UTF_8));

		return stream;
	}

	private void goDeepAtTree(Object object){
		// формирование RDF-ресурса для корневого объекта
		exportMethods.selectAndApplyExportMethod(object);
		exportedObjects.add(((IdentifiedObject)object).getMRID());

		Class aClass = null;
		try {
			aClass = Class.forName(this.iecClassesPathMap.get(((IdentifiedObject) object).getClassName()));
			Method[] methods = aClass.getMethods();
			for (Method md : methods) {
				if (md.isAnnotationPresent(AssociationSetter.class)) {
					Method setter = md;
					Method getter = aClass.getMethod(("get"+setter.getName().substring(3)));
					String cardinality = md.getAnnotation(AssociationSetter.class).cardinality();
					if (cardinality.equals("one")){
						// формирование ресурса для одиночного дерева (дальше не идем)
						if (getter.invoke(object) != null) {
							if (!exportedObjects.contains(((IdentifiedObject) object).getMRID())){
								exportMethods.selectAndApplyExportMethod(getter.invoke(object));
								exportedObjects.add(((IdentifiedObject)object).getMRID());
							}
						}
					} else {
						if (getter.invoke(object) != null) {
							for (Object childObject: ((Collection<Object>) getter.invoke(object))){
								if (!exportedObjects.contains(((IdentifiedObject) childObject).getMRID())){
									this.goDeepAtTree(childObject);
								}
							}
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getFullPathToIECClasses(){
		this.iecClassesPathMap = new HashMap<>();
		Reflections reflections = new Reflections(CIMObjectsImport.class.getPackage().getName(), new SubTypesScanner(false));
		Set<Class<?>> subTypesOf = reflections.getSubTypesOf(Object.class);
		subTypesOf.forEach(el -> iecClassesPathMap.put(el.getSimpleName(), el.getName()));

		return this.iecClassesPathMap;
	}

	private HashMap<String,String> findIECClasses(HashMap<String,String> iecClassesPathMap, File packagePath, String fullPath, boolean[] isIECPackagesFind){
		File[] list = packagePath.listFiles();
		if (packagePath.getName().equals("main") && !isIECPackagesFind[0]) isIECPackagesFind[0] = true;
		if (packagePath.getName().equals("java") && isIECPackagesFind[0]) isIECPackagesFind[1] = true;
		if (packagePath.getName().equals("IEC61968") && isIECPackagesFind[1]) isIECPackagesFind[2] = true;
		if (packagePath.getName().equals("IEC61970") && isIECPackagesFind[1]) isIECPackagesFind[3] = true;

		if (packagePath.list() != null){
			if (isIECPackagesFind[1]) fullPath += (packagePath.getName()) + ".";
			for (File childPackagePath: packagePath.listFiles()){
				iecClassesPathMap = this.findIECClasses(iecClassesPathMap, childPackagePath,fullPath, isIECPackagesFind);
			}
		} else if ((isIECPackagesFind[2] || isIECPackagesFind [3]) && (fullPath.split("java.").length == 2)) {
			iecClassesPathMap.put(packagePath.getName().substring(0, packagePath.getName().length() - 5), (fullPath.split("java.")[1] + packagePath.getName().substring(0, packagePath.getName().length() - 5)));
		}
		return  iecClassesPathMap;
	}


    public void setDirectoryToSave(String directoryToSave){
    	this.directoryToSave = directoryToSave;
	}
	public void setBaseURI(String baseURI){
    	this.baseURI = baseURI;
	}
}
