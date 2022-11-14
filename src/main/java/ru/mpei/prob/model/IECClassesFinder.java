package ru.mpei.prob.model;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashMap;
import java.util.Set;
@Slf4j
public class IECClassesFinder {
    public HashMap<String, String> getFullPathToIECClasses() {
        HashMap<String, String> iecClassesPathMap = new HashMap<>();
        Reflections reflections = new Reflections(CIMObjectsImport.class.getPackage().getName(), new SubTypesScanner(false));
        Set<Class<?>> subTypesOf = reflections.getSubTypesOf(Object.class);
        subTypesOf.forEach(el -> iecClassesPathMap.put(el.getSimpleName(), el.getName()));
        log.info("Пути к классам CIM получены");
        return iecClassesPathMap;
    }
}
