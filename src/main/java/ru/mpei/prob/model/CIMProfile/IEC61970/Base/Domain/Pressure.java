package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Pressure in Pascal.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:51 MSK 2020
 */

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pressure {
	@Enumerated(EnumType.STRING)
	@Column(name = "multiplier")
	private UnitMultiplier multiplier;
	@Enumerated(EnumType.STRING)
	@Column(name = "unit")
	private UnitSymbol unit;
	@Column(name="value", nullable = true)
	private Float value;


	public UnitMultiplier getMultiplier(){
		return this.multiplier;
	}

	@FieldSetter(fieldName = "Pressure.multiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setMultiplier(UnitMultiplier multiplier){
		this.multiplier = multiplier;
	}

	public UnitSymbol getUnit(){
		return this.unit;
	}

	@FieldSetter(fieldName = "Pressure.unit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setUnit(UnitSymbol unit){
		this.unit = unit;
	}

	public Float getValue(){
		return this.value;
	}

	@FieldSetter(fieldName = "Pressure.value", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setValue(Float value){
		this.value = value;
	}

	public Pressure(){

	}

}
