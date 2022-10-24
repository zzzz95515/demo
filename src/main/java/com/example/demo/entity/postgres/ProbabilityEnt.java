package com.example.demo.entity.postgres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProbabilityEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private EquipmentEnt equipment;

    private Date predDate;

    private double predProb;

    public EquipmentEnt getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEnt equipment) {
        this.equipment = equipment;
    }

    public Date getPredDate() {
        return predDate;
    }

    public void setPredDate(Date predDate) {
        this.predDate = predDate;
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
                ", predDate=" + predDate +
                ", predProb=" + predProb +
                '}';
    }

    public ProbabilityEnt(EquipmentEnt equipment, Date predDate, double predProb) {
        this.equipment = equipment;
        this.predDate = predDate;
        this.predProb = predProb;
    }

    public ProbabilityEnt() {
    }
}
