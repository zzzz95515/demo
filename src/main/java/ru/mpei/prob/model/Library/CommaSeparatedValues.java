package ru.mpei.prob.model.Library;

import java.util.List;
import java.util.Map;

/**
 * Класс представляющий считанный csv файл.
 */
public class CommaSeparatedValues {
    private Map<String,Integer> headMap;
    private List<List<String>> records;

    public String getCell(String columnName, Integer rowIndex) throws Exception {
        String cell=null;
        if (headMap.get(columnName)==null){
            throw new Exception("Имя столбца \""+columnName+"\" отсутствует в csv");
        }
        cell = records.get(rowIndex).get(headMap.get(columnName));
        return cell;
    }

    public Map<String,Integer> getHeadMap(){
        return this.headMap;
    }

    public void setHeadMap(Map<String,Integer> headMap) throws Exception {
        if (headMap.size()==0) throw new Exception("headMap не должен быть пустым");
        this.headMap=headMap;
    }
    public void setRecords(List<List<String>> records) throws Exception {
        if (headMap==null) throw new Exception("Сначала установите headMap");
        if (records.get(0)==null) throw new Exception("Записи пусты");
        int counter=0;
        for (List<String> row: records){
            if (row.size() != headMap.size()){
                throw new Exception("В файле количество столбцов ("+row.size()+") в строке "+counter+" не совпадает с шапкой ("+headMap.size()+")");
            }
            counter++;
        }
        this.records=records;
    }

    public Integer size(){
        return records.size();
    }
}
