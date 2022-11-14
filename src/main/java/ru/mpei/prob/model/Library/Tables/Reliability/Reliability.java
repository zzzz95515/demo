package ru.mpei.prob.model.Library.Tables.Reliability;

import lombok.Getter;
import lombok.Setter;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Voltage;

import javax.persistence.*;

@Entity
@Table(name = "reliability", schema = "library")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Reliability {
    @Id
    @Setter
    @Getter
    private Integer id;

    /**
     * Параметр потока отказов
     */
    @Setter
    @Getter
    @Column(name="failureFlow", nullable = true)
    private Float failureFlow;

    /**
     * Время восстановления, час.
     */
    @Setter
    @Getter
    @Column(name="recoveryTime", nullable = true)
    private Float recoveryTime;

    /**
     * Частота плановых отключений
     */
    @Setter
    @Getter
    @Column(name="plannedRepairNumber", nullable = true)
    private Float plannedRepairNumber;

    /**
     * Продолжительность плановых отключений, час.
     */
    @Setter
    @Getter
    @Column(name="plannedRepairTime", nullable = true)
    private Float plannedRepairTime;

    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="ratedVoltage_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="ratedVoltage_unit")),
            @AttributeOverride(name="value", column=@Column(name="ratedVoltage_value")),
    })
    @Setter
    @Getter
    private Voltage ratedVoltage;
}
