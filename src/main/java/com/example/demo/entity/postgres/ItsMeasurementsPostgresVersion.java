package com.example.demo.entity.postgres;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItsMeasurementsPostgresVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date measurmentDate;

    private Double measuredValue;

    private Long equipmentId;

    public Date getMeasurmentDate() {
        return measurmentDate;
    }

    public void setMeasurmentDate(Date measurmentDate) {
        this.measurmentDate = measurmentDate;
    }

    public Double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
