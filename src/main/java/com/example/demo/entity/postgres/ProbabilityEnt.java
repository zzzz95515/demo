package com.example.demo.entity.postgres;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ProbabilityEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private EquipmentEnt equipment;

    private LocalDate dateTime;

    private double predProb;

    public EquipmentEnt getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEnt equipment) {
        this.equipment = equipment;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate predDate) {
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

    public ProbabilityEnt(EquipmentEnt equipment, LocalDate predDate, double predProb) {
        this.equipment = equipment;
        this.dateTime = predDate;
        this.predProb = predProb;
    }

    public ProbabilityEnt() {
    }
}
