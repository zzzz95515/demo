package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.AngleDegrees;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * Describes the tap model for an asymmetrical phase shifting transformer 
 * in which the difference voltage vector adds to the primary side voltage. 
 * The angle between the primary side voltage and the difference voltage is 
 * named the winding connection angle. The phase shift depends on both the 
 * difference voltage magnitude and the winding connection angle.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "phasetapchangerasymmetrical")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhaseTapChangerAsymmetrical extends PhaseTapChangerNonLinear {
	/**
	 * The phase angle between the in-phase winding and the out-of -phase winding 
	 * used for creating phase shift. The out-of-phase winding produces what is 
	 * known as the difference voltage.  Setting this angle to 90 degrees is not 
	 * the same as a symmemtrical transformer.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="windingConnectionAngle_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="windingConnectionAngle_unit")),
		@AttributeOverride(name="value", column=@Column(name="windingConnectionAngle_value")),
	})
	private AngleDegrees windingConnectionAngle;


	public AngleDegrees getWindingConnectionAngle(){
		return this.windingConnectionAngle;
	}

	@FieldSetter(fieldName = "PhaseTapChangerAsymmetrical.windingConnectionAngle", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setWindingConnectionAngle(AngleDegrees windingConnectionAngle){
		this.windingConnectionAngle = windingConnectionAngle;
	}

	public PhaseTapChangerAsymmetrical(){

	}

}
