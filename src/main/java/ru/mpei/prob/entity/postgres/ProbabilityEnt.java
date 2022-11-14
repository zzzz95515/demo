package ru.mpei.prob.entity.postgres;

import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ProbabilityEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ConductingEquipment equipment;

    private LocalDate dateTime;

    private double predProb;

    public ConductingEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(ConductingEquipment equipment) {
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

    public ProbabilityEnt(ConductingEquipment equipment, LocalDate predDate, double predProb) {
        this.equipment = equipment;
        this.dateTime = predDate;
        this.predProb = predProb;
    }

    public ProbabilityEnt() {
    }
}
