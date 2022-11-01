package com.example.demo.entity.postgres;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProbabilityEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private EquipmentEnt equipment;

    private LocalDateTime dateTime;

    private double predProb;

    public EquipmentEnt getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEnt equipment) {
        this.equipment = equipment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime predDate) {
        this.dateTime = predDate;
    }

    public double getPredProb() {
        return predProb;
    }

    public void setPredProb(double predProb) {
        this.predProb = predProb;
    }

    @Override
    public String toString() {
        return "ProbabilityEnt{" +
                "equipment=" + equipment +
                ", predDate=" + dateTime +
                ", predProb=" + predProb +
                '}';
    }

    public ProbabilityEnt(EquipmentEnt equipment, LocalDateTime predDate, double predProb) {
        this.equipment = equipment;
        this.dateTime = predDate;
        this.predProb = predProb;
    }

    public ProbabilityEnt() {
    }
}
