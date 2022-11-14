package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Voltage;

import javax.persistence.*;

@Entity
@Table(name = "capex_opex", schema = "library")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CapexOpex {
    @Id
    @Setter
    @Getter
    private Integer id;

    @Column(name="price", nullable = true) @Setter @Getter
    private Integer price;

    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="ratedVoltage_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="ratedVoltage_unit")),
            @AttributeOverride(name="value", column=@Column(name="ratedVoltage_value")),
    }) @Setter @Getter
    private Voltage ratedVoltage;
}
