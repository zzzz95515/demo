package ru.mpei.prob.entity.influx;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Measurement(name = "prob_table")
public class ProbabilityMaesInflux {
    @Column(name = "time")
    private Instant time;

    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "probability")
    private Double probability;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
