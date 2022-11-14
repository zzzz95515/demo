package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "land_price", schema = "library")
public class LandPrice extends CapexOpex {


    @Enumerated(EnumType.STRING)
    @Column(name = "buildingType") @Setter @Getter
    private BuildingType buildingType;


    @Column(name="price_standart", nullable = true) @Setter @Getter
    private Float priceStandart;


    @Column(name="square", nullable = true) @Setter @Getter
    private Float square;



}
