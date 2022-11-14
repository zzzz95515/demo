package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "overhead_line_price", schema = "library")
public class OverheadLinePrice extends ACLineSegmentPrice {

    /**
     * Характеристика промежуточных опор
     */
    @Column(name="power_line_support_type", nullable = true) @Setter @Getter
    private Integer powerLineSupportType;

    /**
     * Проводов в фазе
     */
    @Column(name="conductors_num_per_phase", nullable = true) @Setter @Getter
    private Integer conductorsNumPerPhase;

    /**
     * Количество цепей на опоре
     */
    @Column(name="line_num_per_support", nullable = true) @Setter @Getter
    private Integer lineNumPerSupport;

    /**
     * Количество цепей на опоре
     */
    @Column(name="power_line_support_material", nullable = true) @Setter @Getter
    private Integer powerLineSupportMaterial;


}
