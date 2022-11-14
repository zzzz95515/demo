package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cable_line_price", schema = "library")
public class CableLinePrice extends ACLineSegmentPrice {

    @Setter @Getter
    @Column(name="cableNumPerTrench")
    private Integer cableNumPerTrench;

    @Setter @Getter
    @Column(name="phaseNumPerCable")
    private Integer phaseNumPerCable;

}
