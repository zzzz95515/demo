package ru.mpei.prob.model;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.impl.SimpleBNode;
import org.eclipse.rdf4j.model.impl.SimpleIRI;
import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.rio.ParserConfig;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.BasicParserSettings;
import org.eclipse.rdf4j.rio.helpers.ParseErrorLogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Парсит RDF.xml документ в триплеты.
 * Создает два HashMap: resourceHashMap, instancesHashMap. *
 *
 * @author Nukhulov (nukhulovsm@yandex.ru)
 * @version 0.1
 * @since 17-04-2020
 */
@Slf4j
public class RDFParser {

    String filePath = null;
    // словарь, в котром key - mRID (идентификатор); value - ресурс (объект, отражающий child-элементы корня RDF.xml)
    HashMap<String, CIMResource> resourcesHashMap;
    // словарь, в котором key - имя класса, которое встречается в RDF.xml; value - list, содержащий mRID объектов,
    // встречающихся в документе
    HashMap<String, ArrayList<String>> instancesHashMap;

    private String projectId;
    private String baseURI;
    private InputStream usedStream;
    private String ntiURI = "http://nti.mpei.ru/#";

    // цвета для логирования
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    // конструктор для инициализации базовых параметров
    public RDFParser(InputStream usedStream, String projectId, String baseURI) {
        this.usedStream = usedStream;
        this.baseURI = baseURI;
        this.projectId = projectId;
    }
//    public RDFParser(String filePath, String baseURI) {
//        this.filePath = filePath;
//        this.baseURI = baseURI;
//    }


    public HashMap<String, CIMResource> getResourcesHashMap() {
        return this.resourcesHashMap;
    }

    public HashMap<String, ArrayList<String>> getInstancesHashMap() {
        return this.instancesHashMap;
    }

    /**
     * Метод вызывается для создания и заполнения resourceHashMap и instancesHashMap.
     * Для парсинга используется библиотека rdf4j.
     * Заполнение происходит перебором триплетов (subject-predicate-object),
     * которые встречаются в RDF.xml файле.
     *
     * @return Nothing.
     */
    public void parseRDFXML() {
        try {
            this.resourcesHashMap = new HashMap<>();
            this.instancesHashMap = new HashMap<>();
            // пространство имен ресурса, например cim:http://iec.ch/TC57/2013/CIM-schema-cim16#
            String resourceNamespace = null;
            String resourceID = null;
            CIMResource cimResource = null;
            ArrayList<String> valuesList = null;
            // словарь, в котором key - имя поля ресурса; value - list с одним значением поля или значениями,
            // если таких полей несколько
            HashMap<String, ArrayList<String>> valuesHashMap = null;

            InputStream in = null;
            if (filePath != null) {
                in = new FileInputStream(this.filePath);
                System.out.println(ANSI_GREEN + "Файл \"" + this.filePath + "\" загружен" + ANSI_RESET);
            } else {
                in = usedStream;
                log.info("Файл c projectID=\"" + this.projectId + "\"  загружен");
            }

            ParserConfig parserConfig = new ParserConfig();
            parserConfig.set(BasicParserSettings.VERIFY_URI_SYNTAX, false);
            Model model = Rio.parse(in, baseURI, RDFFormat.RDFXML, parserConfig, SimpleValueFactory.getInstance(), new ParseErrorLogger());

            // перебор триплетов модели
            for (Statement statement : model) {
                // установление resourceID
                if (statement.getSubject().getClass().equals(SimpleIRI.class)) {
                    resourceID = ((SimpleIRI) statement.getSubject()).getLocalName();
                    // toUpperCase т.к. ссылки у других объектов на этот в upper case
                    resourceID = resourceID.toUpperCase();
                }
                if (statement.getSubject().getClass().equals(SimpleBNode.class)) {
                    resourceID = ((SimpleBNode) statement.getSubject()).getID();
                }

                // проверка выявляет дочерний элемент корневого элемента rdf:RDF
                if (statement.getPredicate().getNamespace().equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#") && statement.getPredicate().getLocalName().equals("type")) {
                    if (statement.getSubject().getClass().equals(SimpleIRI.class)) {
                        resourceNamespace = ((SimpleIRI) statement.getSubject()).getNamespace();
                    } else if (statement.getSubject().getClass().equals(SimpleBNode.class)) {
                        resourceNamespace = baseURI;
                    }
                    if (resourceNamespace != null && (resourceNamespace.equals(baseURI))) {
                        cimResource = new CIMResource();
                        // установление имени класса ресурса
                        cimResource.setName(((SimpleIRI) statement.getObject()).getLocalName());
                        valuesHashMap = new HashMap<>();
                        valuesHashMap.put("IdentifiedObject.projectID", new ArrayList<>());
                        valuesHashMap.get("IdentifiedObject.projectID").add(this.projectId);
                        // установка поля className
                        valuesHashMap.put("IdentifiedObject.className", new ArrayList<>());
                        valuesHashMap.get("IdentifiedObject.className").add(((SimpleIRI) statement.getObject()).getLocalName());
                        // установка поля mRID еще раз (для тех объектов, у которых он не прописан в RDF.xml)
                        valuesHashMap.put("IdentifiedObject.mRID", new ArrayList<>());
                        valuesHashMap.get("IdentifiedObject.mRID").add(resourceID.substring(1));
                        // если в instancesHashMap нет ключа, соответствующего имени класса элемента -
                        // добавляем такой ключ и добавляем mRID к list (list также создаем),
                        // инача просто добавляем mRID к list
                        if (this.instancesHashMap.get(((SimpleIRI) statement.getObject()).getLocalName()) == null) {
                            this.instancesHashMap.put(((SimpleIRI) statement.getObject()).getLocalName(), new ArrayList<>());
                            this.instancesHashMap.get(((SimpleIRI) statement.getObject()).getLocalName()).add(resourceID);
                        } else {
                            this.instancesHashMap.get(((SimpleIRI) statement.getObject()).getLocalName()).add(resourceID);
                        }
                        // добавление ресурса в CIM ресурс
                        cimResource.setValuesHashMap(valuesHashMap);

                        this.resourcesHashMap.put(resourceID, cimResource);
                    }
                    // обработка полей найденного дочернего элемента rdf:RDF
                } else {
                    // проверка выявляет: соответствует ли поле объекта профилю CIM
                    if ((statement.getPredicate().getNamespace().equals(baseURI) || statement.getPredicate().getNamespace().equals(ntiURI))
//                            || statement.getPredicate().getLocalName().equals("ConnectivityNode.rastrV") // считываются только те атрибуты из nti стереотипа, которые указаны здесь
//                            || statement.getPredicate().getLocalName().equals("ConnectivityNode.nodeType")
//                            || statement.getPredicate().getLocalName().equals("ConnectivityNode.initialVoltage"))
                            && !statement.getPredicate().getLocalName().equals("IdentifiedObject.projectID")
                            && !statement.getPredicate().getLocalName().equals("IdentifiedObject.mRID")) {
                        valuesHashMap = this.resourcesHashMap.get(resourceID).getValuesHashMap();
                        valuesList = valuesHashMap.get(statement.getPredicate().getLocalName());
                        if (valuesList == null) {
                            valuesList = new ArrayList<>();
                            valuesHashMap.put(statement.getPredicate().getLocalName(), valuesList);
                        }
                        if (statement.getObject().getClass().equals(SimpleLiteral.class)) {
                            valuesList.add(statement.getObject().stringValue());
                        } else if (statement.getObject().getClass().equals(SimpleIRI.class)) {
                            valuesList.add(((SimpleIRI) statement.getObject()).getLocalName());
                        } else if (statement.getObject().getClass().equals(SimpleBNode.class)) {
                            valuesList.add(((SimpleBNode) statement.getObject()).getID());
                        }
                    }
                }
            }
            log.info("Все триплеты проанализированы. Объекты cim-метакласса созданы");
        } catch (FileNotFoundException e) {
            log.error("Файл c projectID=\"" + this.projectId + "\" не найден");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("Не удалось разобрать RDFXML файл");
            e.printStackTrace();
        }
    }
}
