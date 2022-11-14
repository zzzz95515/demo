package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Reactance;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Resistance;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * Impedance description for the fault.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:52 MSK 2020
 */

@Entity
@Table(name = "faultimpedance")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class FaultImpedance extends IdentifiedObject{
	/**
	 * The resistance of the fault between phases and ground.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="rGround_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="rGround_unit")),
		@AttributeOverride(name="value", column=@Column(name="rGround_value")),
	})
	private Resistance rGround;
	/**
	 * The resistance of the fault between phases.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="rLineToLine_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="rLineToLine_unit")),
		@AttributeOverride(name="value", column=@Column(name="rLineToLine_value")),
	})
	private Resistance rLineToLine;
	/**
	 * The reactance of the fault between phases and ground.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="xGround_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="xGround_unit")),
		@AttributeOverride(name="value", column=@Column(name="xGround_value")),
	})
	private Reactance xGround;
	/**
	 * The reactance of the fault between phases.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="xLineToLine_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="xLineToLine_unit")),
		@AttributeOverride(name="value", column=@Column(name="xLineToLine_value")),
	})
	private Reactance xLineToLine;


	public Resistance getRGround(){
		return this.rGround;
	}

	@FieldSetter(fieldName = "FaultImpedance.rGround", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setRGround(Resistance rGround){
		this.rGround = rGround;
	}

	public Resistance getRLineToLine(){
		return this.rLineToLine;
	}

	@FieldSetter(fieldName = "FaultImpedance.rLineToLine", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setRLineToLine(Resistance rLineToLine){
		this.rLineToLine = rLineToLine;
	}

	public Reactance getXGround(){
		return this.xGround;
	}

	@FieldSetter(fieldName = "FaultImpedance.xGround", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setXGround(Reactance xGround){
		this.xGround = xGround;
	}

	public Reactance getXLineToLine(){
		return this.xLineToLine;
	}

	@FieldSetter(fieldName = "FaultImpedance.xLineToLine", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setXLineToLine(Reactance xLineToLine){
		this.xLineToLine = xLineToLine;
	}

	public FaultImpedance(){

	}

}
