package ru.mpei.prob.model.Library.Tables.CapexOpex;

import lombok.Getter;
import lombok.Setter;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.ApparentPower;

import javax.persistence.*;

@Entity
@Table(name = "transformer_cell_price", schema = "library")
public class TransformerCellPrice extends CapexOpex {


    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="ratedS_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="ratedS_unit")),
            @AttributeOverride(name="value", column=@Column(name="ratedS_value")),
    }) @Setter @Getter
    private ApparentPower ratedS;


}
