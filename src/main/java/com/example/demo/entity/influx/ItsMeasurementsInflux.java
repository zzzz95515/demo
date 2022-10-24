package com.example.demo.entity.influx;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.sql.Time;
import java.time.Instant;

@Measurement(name = "its_table")
public class ItsMeasurementsInflux {
    @Column(name = "time")
    private Instant time;

    @Column(name = "its")
    private Double its;

    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "plan_id")
    private Long planId;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
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

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}
