package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CurrentFlow;

import javax.persistence.*;

@Entity
@Table(name = "breaker_cell_price", schema = "library")
public class BreakerCellPrice extends CapexOpex {

    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="ratedCurrent_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="ratedCurrent_unit")),
            @AttributeOverride(name="value", column=@Column(name="ratedCurrent_value")),
    }) @Setter @Getter
    private CurrentFlow ratedCurrent;

}
