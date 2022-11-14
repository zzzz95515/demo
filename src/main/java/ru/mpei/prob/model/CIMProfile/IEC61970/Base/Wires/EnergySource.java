package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * A generic equivalent for an energy supplier on a transmission or distribution 
 * voltage level.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "energysource")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnergySource extends ConductingEquipment {
	/**
	 * High voltage source active injection. Load sign convention is used, i.e. 
	 * positive sign means flow out from a node.Starting value for steady state 
	 * solutions.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="activePower_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="activePower_unit")),
		@AttributeOverride(name="value", column=@Column(name="activePower_value")),
	})
	private ActivePower activePower;
	/**
	 * Phase-to-phase nominal voltage.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="nominalVoltage_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="nominalVoltage_unit")),
		@AttributeOverride(name="value", column=@Column(name="nominalVoltage_value")),
	})
	private Voltage nominalVoltage;
	/**
	 * Positive sequence Thevenin resistance.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r_unit")),
		@AttributeOverride(name="value", column=@Column(name="r_value")),
	})
	private Resistance r;
	/**
	 * Zero sequence Thevenin resistance.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r0_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r0_unit")),
		@AttributeOverride(name="value", column=@Column(name="r0_value")),
	})
	private Resistance r0;
	/**
	 * High voltage source reactive injection. Load sign convention is used, i.e. 
	 * positive sign means flow out from a node.Starting value for steady state 
	 * solutions.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="reactivePower_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="reactivePower_unit")),
		@AttributeOverride(name="value", column=@Column(name="reactivePower_value")),
	})
	private ReactivePower reactivePower;
	/**
	 * Negative sequence Thevenin resistance.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="rn_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="rn_unit")),
		@AttributeOverride(name="value", column=@Column(name="rn_value")),
	})
	private Resistance rn;
	/**
	 * Phase angle of a-phase open circuit.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="voltageAngle_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="voltageAngle_unit")),
		@AttributeOverride(name="value", column=@Column(name="voltageAngle_value")),
	})
	private AngleRadians voltageAngle;
	/**
	 * Phase-to-phase open circuit voltage magnitude.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="voltageMagnitude_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="voltageMagnitude_unit")),
		@AttributeOverride(name="value", column=@Column(name="voltageMagnitude_value")),
	})
	private Voltage voltageMagnitude;
	/**
	 * Positive sequence Thevenin reactance.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x_unit")),
		@AttributeOverride(name="value", column=@Column(name="x_value")),
	})
	private Reactance x;
	/**
	 * Zero sequence Thevenin reactance.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x0_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x0_unit")),
		@AttributeOverride(name="value", column=@Column(name="x0_value")),
	})
	private Reactance x0;
	/**
	 * Negative sequence Thevenin reactance.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="xn_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="xn_unit")),
		@AttributeOverride(name="value", column=@Column(name="xn_value")),
	})
	private Reactance xn;


	public ActivePower getActivePower(){
		return this.activePower;
	}

	@FieldSetter(fieldName = "EnergySource.activePower", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setActivePower(ActivePower activePower){
		this.activePower = activePower;
	}

	public Voltage getNominalVoltage(){
		return this.nominalVoltage;
	}

	@FieldSetter(fieldName = "EnergySource.nominalVoltage", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNominalVoltage(Voltage nominalVoltage){
		this.nominalVoltage = nominalVoltage;
	}

	public Resistance getR(){
		return this.r;
	}

	@FieldSetter(fieldName = "EnergySource.r", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR(Resistance r){
		this.r = r;
	}

	public Resistance getR0(){
		return this.r0;
	}

	@FieldSetter(fieldName = "EnergySource.r0", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR0(Resistance r0){
		this.r0 = r0;
	}

	public ReactivePower getReactivePower(){
		return this.reactivePower;
	}

	@FieldSetter(fieldName = "EnergySource.reactivePower", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setReactivePower(ReactivePower reactivePower){
		this.reactivePower = reactivePower;
	}

	public Resistance getRn(){
		return this.rn;
	}

	@FieldSetter(fieldName = "EnergySource.rn", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setRn(Resistance rn){
		this.rn = rn;
	}

	public AngleRadians getVoltageAngle(){
		return this.voltageAngle;
	}

	@FieldSetter(fieldName = "EnergySource.voltageAngle", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setVoltageAngle(AngleRadians voltageAngle){
		this.voltageAngle = voltageAngle;
	}

	public Voltage getVoltageMagnitude(){
		return this.voltageMagnitude;
	}

	@FieldSetter(fieldName = "EnergySource.voltageMagnitude", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setVoltageMagnitude(Voltage voltageMagnitude){
		this.voltageMagnitude = voltageMagnitude;
	}

	public Reactance getX(){
		return this.x;
	}

	@FieldSetter(fieldName = "EnergySource.x", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX(Reactance x){
		this.x = x;
	}

	public Reactance getX0(){
		return this.x0;
	}

	@FieldSetter(fieldName = "EnergySource.x0", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX0(Reactance x0){
		this.x0 = x0;
	}

	public Reactance getXn(){
		return this.xn;
	}

	@FieldSetter(fieldName = "EnergySource.xn", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setXn(Reactance xn){
		this.xn = xn;
	}

	public EnergySource(){

	}

}