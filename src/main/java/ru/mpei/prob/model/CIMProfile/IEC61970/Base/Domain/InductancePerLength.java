package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Inductance per unit of length.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:51 MSK 2020
 */

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InductancePerLength {
	@Enumerated(EnumType.STRING)
	@Column(name = "denominatorMultiplier")
	private UnitMultiplier denominatorMultiplier;
	@Enumerated(EnumType.STRING)
	@Column(name = "denominatorUnit")
	private UnitSymbol denominatorUnit;
	@Enumerated(EnumType.STRING)
	@Column(name = "multiplier")
	private UnitMultiplier multiplier;
	@Enumerated(EnumType.STRING)
	@Column(name = "unit")
	private UnitSymbol unit;
	@Column(name="value", nullable = true)
	private Float value;


	public UnitMultiplier getDenominatorMultiplier(){
		return this.denominatorMultiplier;
	}

	@FieldSetter(fieldName = "InductancePerLength.denominatorMultiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setDenominatorMultiplier(UnitMultiplier denominatorMultiplier){
		this.denominatorMultiplier = denominatorMultiplier;
	}

	public UnitSymbol getDenominatorUnit(){
		return this.denominatorUnit;
	}

	@FieldSetter(fieldName = "InductancePerLength.denominatorUnit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setDenominatorUnit(UnitSymbol denominatorUnit){
		this.denominatorUnit = denominatorUnit;
	}

	public UnitMultiplier getMultiplier(){
		return this.multiplier;
	}

	@FieldSetter(fieldName = "InductancePerLength.multiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setMultiplier(UnitMultiplier multiplier){
		this.multiplier = multiplier;
	}

	public UnitSymbol getUnit(){
		return this.unit;
	}

	@FieldSetter(fieldName = "InductancePerLength.unit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setUnit(UnitSymbol unit){
		this.unit = unit;
	}

	public Float getValue(){
		return this.value;
	}

	@FieldSetter(fieldName = "InductancePerLength.value", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setValue(Float value){
		this.value = value;
	}

	public InductancePerLength(){

	}

}