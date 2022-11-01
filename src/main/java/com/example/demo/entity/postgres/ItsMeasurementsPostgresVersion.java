package com.example.demo.entity.postgres;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class ItsMeasurementsPostgresVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime measurmentDate;

    private Double its;

    private Long equipmentId;

    public LocalDateTime getMeasurmentDate() {
        return measurmentDate;
    }

    public void setMeasurmentDate(LocalDateTime measurmentDate) {
        this.measurmentDate = measurmentDate;
    }

    public Double getIts() {
        return its;
    }


    public void setIts(Double its) {
        this.its = its;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
