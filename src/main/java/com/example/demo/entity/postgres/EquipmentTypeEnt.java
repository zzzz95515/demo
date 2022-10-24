package com.example.demo.entity.postgres;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EquipmentTypeEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipmentType;

    private Double betta;

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Double getBetta() {
        return betta;
    }

    public void setBetta(Double betta) {
        this.betta = betta;
    }

    @Override
    public String toString() {
        return "EquipmentTypeEnt{" +
                "equipmentType='" + equipmentType + '\'' +
                ", betta=" + betta +
                '}';
    }
}
