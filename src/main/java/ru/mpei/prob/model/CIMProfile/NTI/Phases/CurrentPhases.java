package ru.mpei.prob.model.CIMProfile.NTI.Phases;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.AngleDegrees;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CurrentFlow;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Фазы токов
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentPhases {
	/**
	 * Фаза А
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="a_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="a_unit")),
		@AttributeOverride(name="value", column=@Column(name="a_value")),
	})
	private CurrentFlow a;
	/**
	 * Угол тока фазы А
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="angleA_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="angleA_unit")),
		@AttributeOverride(name="value", column=@Column(name="angleA_value")),
	})
	private AngleDegrees angleA;
	/**
	 * Угол тока фазы B
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="angleB_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="angleB_unit")),
		@AttributeOverride(name="value", column=@Column(name="angleB_value")),
	})
	private AngleDegrees angleB;
	/**
	 * Угол тока фазы C
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="angleC_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="angleC_unit")),
		@AttributeOverride(name="value", column=@Column(name="angleC_value")),
	})
	private AngleDegrees angleC;
	/**
	 * Фаза В
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="b_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="b_unit")),
		@AttributeOverride(name="value", column=@Column(name="b_value")),
	})
	private CurrentFlow b;
	/**
	 * Фаза С
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="c_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="c_unit")),
		@AttributeOverride(name="value", column=@Column(name="c_value")),
	})
	private CurrentFlow c;


	public CurrentFlow getA(){
		return this.a;
	}

	@FieldSetter(fieldName = "CurrentPhases.a", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setA(CurrentFlow a){
		this.a = a;
	}

	public AngleDegrees getAngleA(){
		return this.angleA;
	}

	@FieldSetter(fieldName = "CurrentPhases.angleA", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setAngleA(AngleDegrees angleA){
		this.angleA = angleA;
	}

	public AngleDegrees getAngleB(){
		return this.angleB;
	}

	@FieldSetter(fieldName = "CurrentPhases.angleB", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setAngleB(AngleDegrees angleB){
		this.angleB = angleB;
	}

	public AngleDegrees getAngleC(){
		return this.angleC;
	}

	@FieldSetter(fieldName = "CurrentPhases.angleC", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setAngleC(AngleDegrees angleC){
		this.angleC = angleC;
	}

	public CurrentFlow getB(){
		return this.b;
	}

	@FieldSetter(fieldName = "CurrentPhases.b", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setB(CurrentFlow b){
		this.b = b;
	}

	public CurrentFlow getC(){
		return this.c;
	}

	@FieldSetter(fieldName = "CurrentPhases.c", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setC(CurrentFlow c){
		this.c = c;
	}

	public CurrentPhases(){

	}

}
