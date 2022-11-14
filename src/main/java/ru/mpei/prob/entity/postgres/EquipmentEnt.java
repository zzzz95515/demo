package ru.mpei.prob.entity.postgres;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EquipmentEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EquipmentTypeEnt equipType;

    private String mrid;

    private LocalDate lastFixionDate;

    public EquipmentTypeEnt getEquipType() {
        return equipType;
    }

    public void setEquipType(EquipmentTypeEnt equipType) {
        this.equipType = equipType;
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }

    public LocalDate getLastFixionDate() {
        return lastFixionDate;
    }

    public void setLastFixionDate(LocalDate lastFixionDate) {
        this.lastFixionDate = lastFixionDate;
    }

    @Override
    public String toString() {
        return "EquipmentEnt{" +
                "equipType=" + equipType +
                ", mrid='" + mrid + '\'' +
                ", lastFixionDate=" + lastFixionDate +
                '}';
    }

    public EquipmentEnt(EquipmentTypeEnt equipType, String mrid, LocalDate lastFixionDate) {
        this.equipType = equipType;
        this.mrid = mrid;
        this.lastFixionDate = lastFixionDate;
    }

    public EquipmentEnt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
