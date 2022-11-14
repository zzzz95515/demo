package ru.mpei.prob.entity.postgres;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ItsMeasurementsPostgresVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate measurmentDate;

    private Double its;

    private String equipmentId;

    public LocalDate getMeasurmentDate() {
        return measurmentDate;
    }

    public void setMeasurmentDate(LocalDate measurmentDate) {
        this.measurmentDate = measurmentDate;
    }

    public Double getIts() {
        return its;
    }


    public void setIts(Double its) {
        this.its = its;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}
