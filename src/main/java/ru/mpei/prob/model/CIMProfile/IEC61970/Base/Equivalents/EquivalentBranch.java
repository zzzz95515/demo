package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Equivalents;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Reactance;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Resistance;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * The class represents equivalent branches.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:51 MSK 2020
 */

@Entity
@Table(name = "equivalentbranch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquivalentBranch extends EquivalentEquipment {
	/**
	 * Negative sequence series resistance from terminal sequence  1 to terminal 
	 * sequence 2. Used for short circuit data exchange according to IEC 60909EquivalentBranch 
	 * is a result of network reduction prior to the data exchange 
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="negativeR12_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="negativeR12_unit")),
		@AttributeOverride(name="value", column=@Column(name="negativeR12_value")),
	})
	private Resistance negativeR12;
	/**
	 * Negative sequence series resistance from terminal sequence 2 to terminal 
	 * sequence 1. Used for short circuit data exchange according to IEC 60909EquivalentBranch 
	 * is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="negativeR21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="negativeR21_unit")),
		@AttributeOverride(name="value", column=@Column(name="negativeR21_value")),
	})
	private Resistance negativeR21;
	/**
	 * Negative sequence series reactance from terminal sequence  1 to terminal 
	 * sequence 2. Used for short circuit data exchange according to IEC 60909Usage 
	 * : EquivalentBranch is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="negativeX12_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="negativeX12_unit")),
		@AttributeOverride(name="value", column=@Column(name="negativeX12_value")),
	})
	private Reactance negativeX12;
	/**
	 * Negative sequence series reactance from terminal sequence 2 to terminal 
	 * sequence 1. Used for short circuit data exchange according to IEC 60909.Usage: 
	 * EquivalentBranch is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="negativeX21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="negativeX21_unit")),
		@AttributeOverride(name="value", column=@Column(name="negativeX21_value")),
	})
	private Reactance negativeX21;
	/**
	 * Positive sequence series resistance from terminal sequence  1 to terminal 
	 * sequence 2 . Used for short circuit data exchange according to IEC 60909. 
	 * EquivalentBranch is a result of network reduction prior to the data exchange. 
	 * 
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="positiveR12_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="positiveR12_unit")),
		@AttributeOverride(name="value", column=@Column(name="positiveR12_value")),
	})
	private Resistance positiveR12;
	/**
	 * Positive sequence series resistance from terminal sequence 2 to terminal 
	 * sequence 1. Used for short circuit data exchange according to IEC 60909EquivalentBranch 
	 * is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="positiveR21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="positiveR21_unit")),
		@AttributeOverride(name="value", column=@Column(name="positiveR21_value")),
	})
	private Resistance positiveR21;
	/**
	 * Positive sequence series reactance from terminal sequence  1 to terminal 
	 * sequence 2. Used for short circuit data exchange according to IEC 60909Usage 
	 * : EquivalentBranch is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="positiveX12_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="positiveX12_unit")),
		@AttributeOverride(name="value", column=@Column(name="positiveX12_value")),
	})
	private Reactance positiveX12;
	/**
	 * Positive sequence series reactance from terminal sequence 2 to terminal 
	 * sequence 1. Used for short circuit data exchange according to IEC 60909Usage 
	 * : EquivalentBranch is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="positiveX21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="positiveX21_unit")),
		@AttributeOverride(name="value", column=@Column(name="positiveX21_value")),
	})
	private Reactance positiveX21;
	/**
	 * Positive sequence series resistance of the reduced branch.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r_unit")),
		@AttributeOverride(name="value", column=@Column(name="r_value")),
	})
	private Resistance r;
	/**
	 * Resistance from terminal sequence 2 to terminal sequence 1 .Used for steady 
	 * state power flow. This attribute is optional and represent unbalanced network 
	 * such as off-nominal phase shifter. If only EquivalentBranch.r is given, 
	 * then EquivalentBranch.r21 is assumed equal to EquivalentBranch.r.Usage 
	 * rule : EquivalentBranch is a result of network reduction prior to the data 
	 * exchange.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r21_unit")),
		@AttributeOverride(name="value", column=@Column(name="r21_value")),
	})
	private Resistance r21;
	/**
	 * Positive sequence series reactance of the reduced branch.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x_unit")),
		@AttributeOverride(name="value", column=@Column(name="x_value")),
	})
	private Reactance x;
	/**
	 * Reactance from terminal sequence 2 to terminal sequence 1 .Used for steady 
	 * state power flow. This attribute is optional and represent unbalanced network 
	 * such as off-nominal phase shifter. If only EquivalentBranch.x is given, 
	 * then EquivalentBranch.x21 is assumed equal to EquivalentBranch.x.Usage 
	 * rule : EquivalentBranch is a result of network reduction prior to the data 
	 * exchange.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x21_unit")),
		@AttributeOverride(name="value", column=@Column(name="x21_value")),
	})
	private Reactance x21;
	/**
	 * Zero sequence series resistance from terminal sequence  1 to terminal sequence 
	 * 2. Used for short circuit data exchange according to IEC 60909EquivalentBranch 
	 * is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="zeroR12_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="zeroR12_unit")),
		@AttributeOverride(name="value", column=@Column(name="zeroR12_value")),
	})
	private Resistance zeroR12;
	/**
	 * Zero sequence series resistance from terminal sequence  2 to terminal sequence 
	 * 1. Used for short circuit data exchange according to IEC 60909Usage : EquivalentBranch 
	 * is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="zeroR21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="zeroR21_unit")),
		@AttributeOverride(name="value", column=@Column(name="zeroR21_value")),
	})
	private Resistance zeroR21;
	/**
	 * Zero sequence series reactance from terminal sequence  1 to terminal sequence 
	 * 2. Used for short circuit data exchange according to IEC 60909Usage : EquivalentBranch 
	 * is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="zeroX12_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="zeroX12_unit")),
		@AttributeOverride(name="value", column=@Column(name="zeroX12_value")),
	})
	private Reactance zeroX12;
	/**
	 * Zero sequence series reactance from terminal sequence 2 to terminal sequence 
	 * 1. Used for short circuit data exchange according to IEC 60909Usage : EquivalentBranch 
	 * is a result of network reduction prior to the data exchange
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="zeroX21_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="zeroX21_unit")),
		@AttributeOverride(name="value", column=@Column(name="zeroX21_value")),
	})
	private Reactance zeroX21;


	public Resistance getNegativeR12(){
		return this.negativeR12;
	}

	@FieldSetter(fieldName = "EquivalentBranch.negativeR12", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNegativeR12(Resistance negativeR12){
		this.negativeR12 = negativeR12;
	}

	public Resistance getNegativeR21(){
		return this.negativeR21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.negativeR21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNegativeR21(Resistance negativeR21){
		this.negativeR21 = negativeR21;
	}

	public Reactance getNegativeX12(){
		return this.negativeX12;
	}

	@FieldSetter(fieldName = "EquivalentBranch.negativeX12", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNegativeX12(Reactance negativeX12){
		this.negativeX12 = negativeX12;
	}

	public Reactance getNegativeX21(){
		return this.negativeX21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.negativeX21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNegativeX21(Reactance negativeX21){
		this.negativeX21 = negativeX21;
	}

	public Resistance getPositiveR12(){
		return this.positiveR12;
	}

	@FieldSetter(fieldName = "EquivalentBranch.positiveR12", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPositiveR12(Resistance positiveR12){
		this.positiveR12 = positiveR12;
	}

	public Resistance getPositiveR21(){
		return this.positiveR21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.positiveR21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPositiveR21(Resistance positiveR21){
		this.positiveR21 = positiveR21;
	}

	public Reactance getPositiveX12(){
		return this.positiveX12;
	}

	@FieldSetter(fieldName = "EquivalentBranch.positiveX12", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPositiveX12(Reactance positiveX12){
		this.positiveX12 = positiveX12;
	}

	public Reactance getPositiveX21(){
		return this.positiveX21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.positiveX21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPositiveX21(Reactance positiveX21){
		this.positiveX21 = positiveX21;
	}

	public Resistance getR(){
		return this.r;
	}

	@FieldSetter(fieldName = "EquivalentBranch.r", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR(Resistance r){
		this.r = r;
	}

	public Resistance getR21(){
		return this.r21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.r21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR21(Resistance r21){
		this.r21 = r21;
	}

	public Reactance getX(){
		return this.x;
	}

	@FieldSetter(fieldName = "EquivalentBranch.x", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX(Reactance x){
		this.x = x;
	}

	public Reactance getX21(){
		return this.x21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.x21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX21(Reactance x21){
		this.x21 = x21;
	}

	public Resistance getZeroR12(){
		return this.zeroR12;
	}

	@FieldSetter(fieldName = "EquivalentBranch.zeroR12", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setZeroR12(Resistance zeroR12){
		this.zeroR12 = zeroR12;
	}

	public Resistance getZeroR21(){
		return this.zeroR21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.zeroR21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setZeroR21(Resistance zeroR21){
		this.zeroR21 = zeroR21;
	}

	public Reactance getZeroX12(){
		return this.zeroX12;
	}

	@FieldSetter(fieldName = "EquivalentBranch.zeroX12", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setZeroX12(Reactance zeroX12){
		this.zeroX12 = zeroX12;
	}

	public Reactance getZeroX21(){
		return this.zeroX21;
	}

	@FieldSetter(fieldName = "EquivalentBranch.zeroX21", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setZeroX21(Reactance zeroX21){
		this.zeroX21 = zeroX21;
	}

	public EquivalentBranch(){

	}

}
