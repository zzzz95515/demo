package ru.mpei.prob.repositories.influx;

import ru.mpei.prob.entity.influx.ItsMeasurementsInflux;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;

import java.util.Date;
import java.util.List;


public class ItsMeasRepo {

    public ItsMeasurementsInflux getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(Long equipmentId, Date fixionDate, Long planVersion, InfluxDB influxDB){
        QueryResult queryResult=influxDB.query(new Query("Select * from its_table Where equipment_id = "+ String.valueOf(equipmentId)+" AND time <= " + fixionDate.getTime()+" AND plan_id=" + planVersion +"  Limit 1 Order by time DESC","test_db"));
        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        List<ItsMeasurementsInflux> resultList = resultMapper.toPOJO(queryResult,ItsMeasurementsInflux.class);
        return resultList.get(0);

    };


    public ItsMeasurementsInflux getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(Long equipmentId, Date fixionDate, Long planVersion, InfluxDB influxDB){
        QueryResult queryResult=influxDB.query(new Query("Select * from its_table Where equipment_id = "+ String.valueOf(equipmentId)+" AND time >= " + fixionDate.getTime()+" AND plan_id=" + planVersion +"  Limit 1 Order by time ASC","test_db"));
        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        List<ItsMeasurementsInflux> resultList = resultMapper.toPOJO(queryResult,ItsMeasurementsInflux.class);
        return resultList.get(0);
    }

    public ItsMeasurementsInflux getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(Long equipmentId, Date fixionDate, Long planVersion, InfluxDB influxDB){
        QueryResult queryResult=influxDB.query(new Query("Select * from its_table Where equipment_id = "+ String.valueOf(equipmentId)+" AND time >= " + fixionDate.getTime()+" AND plan_id=" + planVersion +"  Limit 1 Order by time DESC","test_db"));
        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        List<ItsMeasurementsInflux> resultList = resultMapper.toPOJO(queryResult,ItsMeasurementsInflux.class);
        return resultList.get(0);
    }
}
