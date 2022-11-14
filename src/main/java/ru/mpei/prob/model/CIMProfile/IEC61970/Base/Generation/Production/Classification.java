package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Generation.Production;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.UnitMultiplier;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.UnitSymbol;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Classification of level.  Specify as 1..n, with 1 being the most detailed, 
 * highest priority, etc as described on the attribue using this data type.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:52 MSK 2020
 */

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Classification {
	@Enumerated(EnumType.STRING)
	@Column(name = "multiplier")
	private UnitMultiplier multiplier;
	@Enumerated(EnumType.STRING)
	@Column(name = "unit")
	private UnitSymbol unit;
	@Column(name="value", nullable = true)
	private Integer value;


	public UnitMultiplier getMultiplier(){
		return this.multiplier;
	}

	@FieldSetter(fieldName = "Classification.multiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setMultiplier(UnitMultiplier multiplier){
		this.multiplier = multiplier;
	}

	public UnitSymbol getUnit(){
		return this.unit;
	}

	@FieldSetter(fieldName = "Classification.unit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setUnit(UnitSymbol unit){
		this.unit = unit;
	}

	public Integer getValue(){
		return this.value;
	}

	@FieldSetter(fieldName = "Classification.value", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setValue(Integer value){
		this.value = value;
	}

	public Classification(){

	}

}