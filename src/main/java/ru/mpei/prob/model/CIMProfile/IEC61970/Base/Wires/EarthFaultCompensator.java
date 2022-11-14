package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Resistance;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * A conducting equipment used to represent a connection to ground which is 
 * typically used to compensate earth faults..   An earth fault compensator 
 * device modeled with a single terminal implies a second terminal solidly 
 * connected to ground.  If two terminals are modeled, the ground is not assumed 
 * and normal connection rules apply.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "earthfaultcompensator")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EarthFaultCompensator extends ConductingEquipment {
	/**
	 * Nominal resistance of device.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r_unit")),
		@AttributeOverride(name="value", column=@Column(name="r_value")),
	})
	private Resistance r;


	public Resistance getR(){
		return this.r;
	}

	@FieldSetter(fieldName = "EarthFaultCompensator.r", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR(Resistance r){
		this.r = r;
	}

	public EarthFaultCompensator(){

	}

}
