package ru.mpei.prob.model.Library;

import java.util.*;

public class CsvReader {
    public static CommaSeparatedValues read(String file, int rowWithColumnsNames) throws Exception {
        CommaSeparatedValues csv = null;
        List<List<String>> records = new ArrayList<>();
        Map<String,Integer> headMap = new HashMap<>();
        int rowCounter = 0;
        int columnCounter = 0;
        String delimeter = ";";

        if (file.split("\r\n")[0].split(delimeter).length==1){
            delimeter = ",";
        }

        for (String line: file.split("\r\n")){
            if (rowCounter == rowWithColumnsNames){
                for(String name: line.split(delimeter)){
                    headMap.put(name,columnCounter);
                    columnCounter++;
                }
            }
            if (rowCounter > rowWithColumnsNames) {
                records.add(Arrays.asList(line.split(delimeter)));
            }
            rowCounter++;
        }
        csv = new CommaSeparatedValues();
        csv.setHeadMap(headMap);
        csv.setRecords(records);

        return csv;
    }
}
