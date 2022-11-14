package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project_price", schema = "library")
public class ProjectPrice extends CapexOpex {

    @Enumerated(EnumType.STRING)
    @Column(name = "buildingType") @Setter @Getter
    private BuildingType buildingType;

}
