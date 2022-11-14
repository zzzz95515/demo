package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aclinesegment_price", schema = "library")
public abstract class ACLineSegmentPrice extends CapexOpex {

    /**
     * Сечение проводов, мм^2
     */
    @Column(name="cross_sectional_area") @Setter @Getter
    private Float crossSectionalArea;

}
