package ru.mpei.prob.model.CIMProfile.NTI.Sequences;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.AngleDegrees;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CurrentFlow;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Последовательности токов
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentSequences {
	/**
	 * Угол тока нулевой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="angNeg_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="angNeg_unit")),
		@AttributeOverride(name="value", column=@Column(name="angNeg_value")),
	})
	private AngleDegrees angNeg;
	/**
	 * Угол тока прямой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="angPo_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="angPo_unit")),
		@AttributeOverride(name="value", column=@Column(name="angPo_value")),
	})
	private AngleDegrees angPo;
	/**
	 * Угол тока нулевой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="angZero_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="angZero_unit")),
		@AttributeOverride(name="value", column=@Column(name="angZero_value")),
	})
	private AngleDegrees angZero;
	/**
	 * Обратная последовательность
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="neg_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="neg_unit")),
		@AttributeOverride(name="value", column=@Column(name="neg_value")),
	})
	private CurrentFlow neg;
	/**
	 * Прямая последовательность
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="pos_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="pos_unit")),
		@AttributeOverride(name="value", column=@Column(name="pos_value")),
	})
	private CurrentFlow pos;
	/**
	 * Нулевая последовательность
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="zero_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="zero_unit")),
		@AttributeOverride(name="value", column=@Column(name="zero_value")),
	})
	private CurrentFlow zero;


	public AngleDegrees getAngNeg(){
		return this.angNeg;
	}

	@FieldSetter(fieldName = "CurrentSequences.angNeg", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setAngNeg(AngleDegrees angNeg){
		this.angNeg = angNeg;
	}

	public AngleDegrees getAngPo(){
		return this.angPo;
	}

	@FieldSetter(fieldName = "CurrentSequences.angPo", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setAngPo(AngleDegrees angPo){
		this.angPo = angPo;
	}

	public AngleDegrees getAngZero(){
		return this.angZero;
	}

	@FieldSetter(fieldName = "CurrentSequences.angZero", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setAngZero(AngleDegrees angZero){
		this.angZero = angZero;
	}

	public CurrentFlow getNeg(){
		return this.neg;
	}

	@FieldSetter(fieldName = "CurrentSequences.neg", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setNeg(CurrentFlow neg){
		this.neg = neg;
	}

	public CurrentFlow getPos(){
		return this.pos;
	}

	@FieldSetter(fieldName = "CurrentSequences.pos", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setPos(CurrentFlow pos){
		this.pos = pos;
	}

	public CurrentFlow getZero(){
		return this.zero;
	}

	@FieldSetter(fieldName = "CurrentSequences.zero", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setZero(CurrentFlow zero){
		this.zero = zero;
	}

	public CurrentSequences(){

	}

}