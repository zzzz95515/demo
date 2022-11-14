package ru.mpei.prob.model.Library.Tables.Reliability;

import lombok.Getter;
import lombok.Setter;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.ApparentPower;

import javax.persistence.*;

@Entity
@Table(name = "BreakerReliability", schema = "library")
public class BreakerReliability extends Reliability {
    @Setter
    @Getter
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="ratedS_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="ratedS_unit")),
            @AttributeOverride(name="value", column=@Column(name="ratedS_value")),
    })
    private ApparentPower ratedS;
}
