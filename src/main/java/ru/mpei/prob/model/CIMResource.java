package ru.mpei.prob.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CIMResource {
    private String name;
    private HashMap<String, ArrayList<String>> valuesHashMap;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, ArrayList<String>> getValuesHashMap() {
        return this.valuesHashMap;
    }

    public void setValuesHashMap(HashMap<String, ArrayList<String>> valuesHashMap) {
        this.valuesHashMap = valuesHashMap;
    }

    public CIMResource() {

    }

}
