package ru.mpei.prob.model;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.prob.model.CIMProfile.NTI.CimClassName;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.AssociationSetter;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.CompoundFieldSetter;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.FieldSetter;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class CIMObjectsImport {

    private HashMap<String,CIMResource> resourcesMap;
    private HashMap<String, ArrayList<String>> instancesMap;
    private HashMap<String,String> iecClassesDirectoriesMap;
    private HashMap<String,Object> importedObjectsMap = new HashMap<>();

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_GREEN = "\u001B[32m";

    public CIMObjectsImport(){
    }

    // stream на входе
    public Map<String, Object> importObjects(InputStream stream, String projectId, String baseURI) {
        RDFParser parser = new RDFParser(stream, projectId, baseURI);
        importedObjectsMap.clear();
        return parseModel(parser);
    }

//    // файл на входе
//    public Map<String, Object> importObjects(String filePath, String baseURI){
//        //парсинг xml файла в триплеты
//        RDFParser parser = new RDFParser(filePath, baseURI);
//        return parseModel(parser);
//    }

    private <T> Map<String, Object> parseModel(RDFParser parser){

        parser.parseRDFXML();
        // key - mrid; value - resource
        this.resourcesMap = parser.getResourcesHashMap();
        // key - class name; value - mrid
        this.instancesMap = parser.getInstancesHashMap();

        //получение полных путей к классам профиля CIM
        //TODO выбросить ошибку, если не найдет папки
        IECClassesFinder finder = new IECClassesFinder();
        if (iecClassesDirectoriesMap == null) iecClassesDirectoriesMap = finder.getFullPathToIECClasses();

        //перебор по наименованиям классов, встречающихся в CIMRDF.xml
        for (String instanceClassName: this.instancesMap.keySet()){
            //перебор по rdfID классов, встречающихся в CIMRDF.xml
            for (String rdfID: this.instancesMap.get(instanceClassName)){
                //если в словаре созданных объектов нет объекта с ключем rdfID
                //а также, если данный класс есть в профиле CIM (папки IEC61970, IEC61968)
                if (!this.importedObjectsMap.containsKey(rdfID) &&
                        this.iecClassesDirectoriesMap.containsKey(instanceClassName)){
                    //создаем объект класса instanceClassName
                    CIMResource resource = this.resourcesMap.get(rdfID);

                    try {
                        Class Clazz = Class.forName(this.iecClassesDirectoriesMap.get(instanceClassName));
                        T obj = (T) Clazz.newInstance();
                        obj = this.fillObjectFields(obj,rdfID,Clazz);
                        this.importedObjectsMap.put(rdfID,obj);
                    } catch (ClassNotFoundException e){
                        log.error(ANSI_RED+"Не удалось создать метакласс "+instanceClassName+ANSI_RESET);
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        log.error(ANSI_RED+"Не удалось создать метакласс "+instanceClassName+ANSI_RESET);
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        log.error(ANSI_RED+"Не удалось создать метакласс "+instanceClassName+ANSI_RESET);
                        e.printStackTrace();
                    }
                }
            }
        }
        for (String rdfID: this.importedObjectsMap.keySet()){
            fillObjectAssociationFields(rdfID);
        }

        return importedObjectsMap;
    }

    private <T> T fillObjectFields(T obj, String rdfID, Class CLazz) {
        Method[] methods = CLazz.getMethods();
        CIMResource resource;
        ArrayList<String> fieldValues;
        resource = this.resourcesMap.get(rdfID);
        for (Method md : methods) {
            //заполнение полей класса
            if (md.isAnnotationPresent(FieldSetter.class)) {
                fieldValues = resource.getValuesHashMap().get(md.getAnnotation(FieldSetter.class).fieldName());
                if (fieldValues != null && fieldValues.size() == 1) {
                    Object fieldValue = null;
                    Class fieldType;
                    try {
                        fieldType = Class.forName(md.getParameterTypes()[0].getName());
                        if (md.getAnnotation(FieldSetter.class).fieldTypeStereotype().equals("CIMDatatype")){
                            fieldValue = fieldType.newInstance();
                            Method[] fieldTypeMethods = fieldType.getMethods();
                            for (Method fieldMd: fieldTypeMethods){
                                if (fieldMd.getName().equals("setValue")){
                                    if (fieldMd.getParameterTypes()[0].getName().equals("java.lang.Float")){
                                        fieldMd.invoke(fieldValue,Float.parseFloat(fieldValues.get(0)));
                                    } else if (fieldMd.getParameterTypes()[0].getName().equals("java.lang.Integer")){
                                        fieldMd.invoke(fieldValue,Integer.parseInt(fieldValues.get(0)));
                                    }
                                }
                            }
                        } else if (md.getAnnotation(FieldSetter.class).fieldTypeStereotype().equals("Primitive")){
                            if (md.getParameterTypes()[0].getName().equals("java.lang.String")) fieldValue = fieldValues.get(0);
                            if (md.getParameterTypes()[0].getName().equals("java.lang.Integer")) try { fieldValue = Integer.parseInt(fieldValues.get(0)); } catch (NumberFormatException nfe) {log.error("Не удалось преобразовать "+md.getAnnotation(FieldSetter.class).fieldName()+" = " + fieldValues.get(0) + " в тип Float");}
                            if (md.getParameterTypes()[0].getName().equals("java.lang.Float")) try { fieldValue = Float.parseFloat(fieldValues.get(0)); } catch (NumberFormatException nfe) {log.error("Не удалось преобразовать "+md.getAnnotation(FieldSetter.class).fieldName()+" = " + fieldValues.get(0) + " в тип Integer");}
                            if (md.getParameterTypes()[0].getName().equals("java.lang.Boolean")) {
                                if (fieldValues.get(0).equals("true") || fieldValues.get(0).equals("True")){
                                    fieldValue = Boolean.TRUE;
                                } else if (fieldValues.get(0).equals("false") || fieldValues.get(0).equals("False")){
                                    fieldValue = Boolean.FALSE;
                                } else { log.error("Не удалось преобразовать "+md.getAnnotation(FieldSetter.class).fieldName()+" = " + fieldValues.get(0) + " в тип Boolean");}
                            }
                            if (md.getParameterTypes()[0].getName().equals("java.util.Date")){
                                if (fieldValues.get(0).split("T").length == 2){
                                    try{fieldValue = new Date(Integer.parseInt(fieldValues.get(0).split("T")[0].split("-")[0])-1900,
                                            Integer.parseInt(fieldValues.get(0).split("T")[0].split("-")[1])-1,
                                            Integer.parseInt(fieldValues.get(0).split("T")[0].split("-")[2]),
                                            Integer.parseInt(fieldValues.get(0).split("T")[1].split(":")[0]),
                                            Integer.parseInt(fieldValues.get(0).split("T")[1].split(":")[1]));}
                                    catch (NumberFormatException nfe) {log.error("Не удалось преобразовать "+md.getAnnotation(FieldSetter.class).fieldName()+" = " + fieldValues.get(0) + " в тип Date(yyyy-mm-ddThh:mm)");}
                                } else {
                                    try{fieldValue = new Date(Integer.parseInt(fieldValues.get(0).split("-")[0])-1900,
                                            Integer.parseInt(fieldValues.get(0).split("-")[1])-1,
                                            Integer.parseInt(fieldValues.get(0).split("-")[2]));}
                                    catch (NumberFormatException nfe) {log.error("Не удалось преобразовать "+md.getAnnotation(FieldSetter.class).fieldName()+" = " + fieldValues.get(0) + " в тип Date (yyyy-mm-dd)");}
                                }
                            }
                            if (md.getParameterTypes()[0].getName().equals("java.util.List")) {
                                try {
                                    fieldValue = Arrays.stream(fieldValues.get(0).split(",")).map(Float::parseFloat).collect(Collectors.toList());
                                } catch (NumberFormatException e) {
                                    fieldValue = Arrays.asList(fieldValues.get(0).split(","));
                                }
                            }
                        } else if (md.getAnnotation(FieldSetter.class).fieldTypeStereotype().equals("Enumeration")) {
                            if (fieldType.equals(CimClassName.class)){
                                for (Field enumField: fieldType.getFields()){
                                    if (enumField.getName().equals(fieldValues.get(0))){
                                        fieldValue = enumField.get(obj);
                                    }
                                }
                            } else {
                                for (Field enumField: fieldType.getFields()){
                                    if (enumField.getName().equals(fieldValues.get(0).split("\\.")[1])){
                                        fieldValue = enumField.get(obj);
                                    }
                                }
                            }
                        }
                        md.invoke(obj, fieldValue);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }

    private void fillObjectAssociationFields(String rdfID) {
        CIMResource resource = this.resourcesMap.get(rdfID);
        try {
            Class Clazz = Class.forName(this.iecClassesDirectoriesMap.get(resource.getName()));
            Method[] methods = Clazz.getMethods();
            ArrayList<String> fieldValues;
            for (Method md: methods){
                //заполнение ассоциированных класса
                if (md.isAnnotationPresent(AssociationSetter.class)){
                    fieldValues = resource.getValuesHashMap().get(md.getAnnotation(AssociationSetter.class).fieldName());
                    if (fieldValues != null){
                        //связывание ассоциаций (parent)one2one(child) (parent)many2one(child)
                        //child/parent - весьма условное обозначение, child это поле класса parent
                        if (md.getAnnotation(AssociationSetter.class).cardinality().equals("one")){
                            bindingOne2One_Many2One(fieldValues, rdfID, md);
                        }
                        //связывание ассоциаций (parent)one2many(child) (parent)many2many(child)
                        //child/parent - весьма условное обозначение, child это поле класса parent
                        //если в RDF.xml у объекта одно поле дублируется с разными значениями
                        else if (md.getAnnotation(AssociationSetter.class).cardinality().equals("many")){
                            bindingOne2Many_Many2Many(fieldValues, rdfID, md);
                        }
                    }
                }
                // связывание поля Compound
                if (md.isAnnotationPresent(CompoundFieldSetter.class)){
                    fieldValues = resource.getValuesHashMap().get(md.getAnnotation(CompoundFieldSetter.class).fieldName());
                    if (fieldValues != null){
                        bindingCompoundField(fieldValues.get(0), rdfID, md);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            log.error("Не удалось создать метакласс "+resource.getName());
        }
    }

    private void bindingCompoundField(String compoundID, String parentID, Method setter){
        Object compound = this.importedObjectsMap.get(compoundID);
        Object parent = this.importedObjectsMap.get(parentID);
        try {
            setter.invoke(parent,compound);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void bindingOne2One_Many2One(ArrayList<String> parentIDs, String childID, Method childSetter){
        String parentID = parentIDs.get(0).toUpperCase();
        if (!parentID.startsWith("_")) {
            parentID = "_" + parentID;
        }
        if (this.importedObjectsMap.containsKey(parentID)) {
            // объект, у которого нет информации об ассоциации в RDF.xml файле
            Object parentObj = this.importedObjectsMap.get(parentID);
            // объект, у которого имеется информация об ассоциации в RDF.xml файле
            Object childObj = this.importedObjectsMap.get(childID);
            Class parentClass = parentObj.getClass();
            Class childClass = childObj.getClass();
            Method[] methods = parentClass.getMethods();
            Method getter = null;
            Method setter = null;
            String childAssociatedClassName = this.iecClassesDirectoriesMap.get(childSetter.getAnnotation(AssociationSetter.class).fieldName().split("\\.")[0]);
            for (Method md : methods) {
                if (md.isAnnotationPresent(AssociationSetter.class) && md.getAnnotation(AssociationSetter.class).assocType().equals(childAssociatedClassName)) {
                    setter = md;
                }
            }
            try {
                if (setter != null) {
                    getter = parentClass.getMethod(("get"+setter.getName().substring(3)));
                    // (parent)one2one(child)
                    if (setter.getAnnotation(AssociationSetter.class).cardinality().equals("one")) {
                        setter.invoke(parentObj, childObj);
                        // (parent)many2one(child)
                    } else if (setter.getAnnotation(AssociationSetter.class).cardinality().equals("many")) {
                        if (getter.invoke(parentObj) == null) {
                            setter.invoke(parentObj, new ArrayList<>());
                            ((List) getter.invoke(parentObj)).add(childObj);

                        } else {
                            ((List) getter.invoke(parentObj)).add(childObj);
                        }
                    }
                    // обратное связывание
                    childSetter.invoke(childObj, parentObj);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException | ClassCastException cce) {
                log.error(ANSI_RED + "Не удалось связать объект " + childID + " (" + childObj.getClass() + ") с объектом " + parentID + " (" + parentObj.getClass() + "): в профиле классы объектов не связаны");
            } catch (NoSuchMethodException e) {
                log.error("Не удалось найти геттер класса "+parentObj.getClass().getName());
                e.printStackTrace();
            }
        }
    }

    private void bindingOne2Many_Many2Many(ArrayList<String> parentIDs, String childID, Method childSetter){
        Object childObj = this.importedObjectsMap.get(childID);
        Class childClass = childObj.getClass();
        Method getter = null;
        Method setter = null ;
        String childAssociatedClassName = this.iecClassesDirectoriesMap.get(childSetter.getAnnotation(AssociationSetter.class).fieldName().split("\\.")[0]);
        for(String parentID : parentIDs){
            if (!parentID.startsWith("_")) parentID = "_" + parentID;
            if (this.importedObjectsMap.containsKey(parentID)) {
                Object parentObj = this.importedObjectsMap.get(parentID);
                Class parentClass = parentObj.getClass();
                Method[] methods = parentClass.getMethods();
                for (Method md: methods) {
                    if (md.isAnnotationPresent(AssociationSetter.class) && md.getAnnotation(AssociationSetter.class).assocType().equals(childAssociatedClassName)) {
                        setter = md;
                    }
                }
                try {
                    if (setter != null) {
                        getter = parentClass.getMethod(("get"+setter.getName().substring(3)));
                        // (parent)one2one(child)
                        if (setter.getAnnotation(AssociationSetter.class).cardinality().equals("one")) {
                            setter.invoke(parentObj, childObj);
                            // (parent)many2one(child)
                        } else if (setter.getAnnotation(AssociationSetter.class).cardinality().equals("many")) {
                            if (getter.invoke(parentObj) == null) {
                                setter.invoke(parentObj, new ArrayList<>());
                                ((List) getter.invoke(parentObj)).add(childObj);

                            } else {
                                ((List) getter.invoke(parentObj)).add(childObj);
                            }
                        }
                        // обратное связывание
                        Method childGetter = childClass.getMethod(("get"+childSetter.getName().substring(3)));
                        if (childGetter.invoke(childObj) == null) {
                            childSetter.invoke(childObj, new ArrayList<>());
                            ((List) childGetter.invoke(childObj)).add(parentObj);
                        } else {
                            ((List) childGetter.invoke(childObj)).add(parentObj);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException | ClassCastException cce) {
                    log.error("Не удалось связать объект " + childID + " (" + childObj.getClass() + ") с объектом " + parentID + " (" + parentObj.getClass() + "): в профиле классы объектов не связаны");
                } catch (NoSuchMethodException e) {
                    log.error("Не удалось найти геттер класса "+parentClass.getName());
                    e.printStackTrace();
                }
            }
        }
    }

//    private HashMap<String, String> getFullPathToIECClasses(){
//        HashMap<String,String> iecClassesPathMap = new HashMap<>();
//        File root = new File("./");
//        String fullPath = "";
//        boolean[] isIECPackagesFind = new boolean[4];
//        for (File child: root.listFiles()){
//            if (child.getName().equals("src")) {
//                iecClassesPathMap = this.findIECClasses(iecClassesPathMap, child, fullPath, isIECPackagesFind);
//            }
//        }
//        return iecClassesPathMap;
//    }
//
//    private HashMap<String,String> findIECClasses(HashMap<String,String> iecClassesPathMap, File packagePath, String fullPath, boolean[] isIECPackagesFind){
//        File[] list = packagePath.listFiles();
//        if (packagePath.getName().equals("main") && !isIECPackagesFind[0]) isIECPackagesFind[0] = true;
//        if (packagePath.getName().equals("java") && isIECPackagesFind[0]) isIECPackagesFind[1] = true;
//        if (packagePath.getName().equals("IEC61968") && isIECPackagesFind[1]) isIECPackagesFind[2] = true;
//        if (packagePath.getName().equals("IEC61970") && isIECPackagesFind[1]) isIECPackagesFind[3] = true;
//
//        if (packagePath.list() != null){
//            if (isIECPackagesFind[1]) fullPath += (packagePath.getName()) + ".";
//            for (File childPackagePath: packagePath.listFiles()){
//                iecClassesPathMap = this.findIECClasses(iecClassesPathMap, childPackagePath,fullPath, isIECPackagesFind);
//            }
//        } else if ((isIECPackagesFind[2] || isIECPackagesFind [3]) && (fullPath.split("java.").length == 2)) {
//            iecClassesPathMap.put(packagePath.getName().substring(0, packagePath.getName().length() - 5), (fullPath.split("java.")[1] + packagePath.getName().substring(0, packagePath.getName().length() - 5)));
//        }
//        return  iecClassesPathMap;
//    }

}
