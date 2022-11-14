package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults.LineFault;
import ru.mpei.prob.model.CIMProfile.NTI.ACLineSegmentType;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A wire or combination of wires, with consistent electrical characteristics, 
 * building a single electrical system, used to carry alternating current 
 * between points in the power system.For symmetrical, transposed 3ph lines, 
 * it is sufficient to use  attributes of the line segment, which describe 
 * impedances and admittances for the entire length of the segment.  Additionally 
 * impedances can be computed by using length and associated per length impedances.The 
 * BaseVoltage at the two ends of ACLineSegments in a Line shall have the 
 * same BaseVoltage.nominalVoltage. However, boundary lines  may have slightly 
 * different BaseVoltage.nominalVoltages and  variation is allowed. Larger 
 * voltage difference in general requires use of an equivalent branch.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "aclinesegment")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ACLineSegment extends Conductor {
	/**
	 * Zero sequence shunt (charging) susceptance, uniformly distributed, of the 
	 * entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="b0ch_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="b0ch_unit")),
		@AttributeOverride(name="value", column=@Column(name="b0ch_value")),
	})
	private Susceptance b0ch;
	/**
	 * Positive sequence shunt (charging) susceptance, uniformly distributed, 
	 * of the entire line section.  This value represents the full charging over 
	 * the full length of the line.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="bch_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="bch_unit")),
		@AttributeOverride(name="value", column=@Column(name="bch_value")),
	})
	private Susceptance bch;
	/**
	 * Удельная емкость по нулевой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="c0PerLength_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="c0PerLength_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="c0PerLength_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="c0PerLength_unit")),
		@AttributeOverride(name="value", column=@Column(name="c0PerLength_value")),
	})
	private CapacitancePerLength c0PerLength;
	/**
	 * Удельный емкостной ток КЛ, А/км
	 */
	@Column(name="capacityCurrent", nullable = true)
	private Float capacityCurrent;
	/**
	 * Коэффициент для учета усложняющих условий строительства ЛЭП
	 */
	@Column(name="complicationFactor", nullable = true)
	private Float complicationFactor;
	/**
	 * Строительная длина провода, км
	 */
	@Column(name="constructionLength", nullable = true)
	private Float constructionLength;
	/**
	 * Удельная емкость по прямой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="cPerLength_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="cPerLength_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="cPerLength_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="cPerLength_unit")),
		@AttributeOverride(name="value", column=@Column(name="cPerLength_value")),
	})
	private CapacitancePerLength cPerLength;
	/**
	 * Сечение проводника, мм^2
	 */
	@Column(name="crossSectionalArea", nullable = true)
	private Float crossSectionalArea;
	/**
	 * Коэф., учитывающий сложность оперативных работ обслуживаемого объекта 
	 */
	@Column(name="factorOper", nullable = true)
	private Float factorOper;
	/**
	 * Коэф., учитывающий сложность технических работ обслуживаемого объекта 
	 */
	@Column(name="factorTech", nullable = true)
	private Float factorTech;
	/**
	 * Zero sequence shunt (charging) conductance, uniformly distributed, of the 
	 * entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="g0ch_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="g0ch_unit")),
		@AttributeOverride(name="value", column=@Column(name="g0ch_value")),
	})
	private Conductance g0ch;
	/**
	 * Positive sequence shunt (charging) conductance, uniformly distributed, 
	 * of the entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="gch_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="gch_unit")),
		@AttributeOverride(name="value", column=@Column(name="gch_value")),
	})
	private Conductance gch;
	/**
	 * Удельная индуктивность по нулевой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="l0PerLength_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="l0PerLength_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="l0PerLength_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="l0PerLength_unit")),
		@AttributeOverride(name="value", column=@Column(name="l0PerLength_value")),
	})
	private InductancePerLength l0PerLength;
	/**
	 * Длительно допустимый ток нагрузки, А
	 */
	@Column(name="longPermissibleCurrent", nullable = true)
	private Float longPermissibleCurrent;
	/**
	 * Удельная индуктивность по прямой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="lPerLength_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="lPerLength_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="lPerLength_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="lPerLength_unit")),
		@AttributeOverride(name="value", column=@Column(name="lPerLength_value")),
	})
	private InductancePerLength lPerLength;
	/**
	 * Максимально допустимое рабочее напряжение, кВ
	 */
	@Column(name="maxPermissibleVoltage", nullable = true)
	private Float maxPermissibleVoltage;
	/**
	 * Количество лет
	 */
	@Column(name="period", nullable = true)
	private Integer period;
	/**
	 * Затраты, сопутствующие строительству
	 */
	@Column(name="priceAdditionalValue", nullable = true)
	private Float priceAdditionalValue;
	/**
	 * Базисный показатель стиомости ВЛ, тыс. руб/км
	 */
	@Column(name="priceBase", nullable = true)
	private Float priceBase;
	/**
	 * Стоимость коллектора (только для КЛ)
	 */
	@Column(name="priceCollector", nullable = true)
	private Float priceCollector;
	/**
	 * Удельная стоимость оперативынх работ за км/год
	 */
	@Column(name="priceOper", nullable = true)
	private Float priceOper;
	/**
	 * Стоимость переключающего пункта (только для КЛ)
	 */
	@Column(name="priceSwitchPoint", nullable = true)
	private Float priceSwitchPoint;
	/**
	 * Удельная стоимость технических работ за км/год
	 */
	@Column(name="priceTech", nullable = true)
	private Float priceTech;
	/**
	 * Positive sequence series resistance of the entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r_unit")),
		@AttributeOverride(name="value", column=@Column(name="r_value")),
	})
	private Resistance r;
	/**
	 * Zero sequence series resistance of the entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r0_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r0_unit")),
		@AttributeOverride(name="value", column=@Column(name="r0_value")),
	})
	private Resistance r0;
	/**
	 * Удельное активное сопротивление по нулевой последовательности
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="r0PerLength_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="r0PerLength_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="r0PerLength_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r0PerLength_unit")),
		@AttributeOverride(name="value", column=@Column(name="r0PerLength_value")),
	})
	private ResistancePerLength r0PerLength;
	/**
	 * Удельное активное сопротивление
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="rPerLength_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="rPerLength_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="rPerLength_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="rPerLength_unit")),
		@AttributeOverride(name="value", column=@Column(name="rPerLength_value")),
	})
	private ResistancePerLength rPerLength;
	/**
	 * Maximum permitted temperature at the end of SC for the calculation of minimum 
	 * short-circuit currents. Used for short circuit data exchange according 
	 * to IEC 60909
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="shortCircuitEndTemperature_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="shortCircuitEndTemperature_unit")),
		@AttributeOverride(name="value", column=@Column(name="shortCircuitEndTemperature_value")),
	})
	private Temperature shortCircuitEndTemperature;
	/**
	 * Количество переключающих пунктов (только для КЛ)
	 */
	@Column(name="switchPointsNumber", nullable = true)
	private Integer switchPointsNumber;
	/**
	 * Тип ЛЭП: ВЛ или КЛ
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ACLineSegmentType type;
	/**
	 * Positive sequence series reactance of the entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x_unit")),
		@AttributeOverride(name="value", column=@Column(name="x_value")),
	})
	private Reactance x;
	/**
	 * Zero sequence series reactance of the entire line section.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x0_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x0_unit")),
		@AttributeOverride(name="value", column=@Column(name="x0_value")),
	})
	private Reactance x0;

	/**
	 * The line segment of this line fault.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "ACLineSegment")
	private List<LineFault> LineFaults;

	public Susceptance getB0ch(){
		return this.b0ch;
	}

	@FieldSetter(fieldName = "ACLineSegment.b0ch", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setB0ch(Susceptance b0ch){
		this.b0ch = b0ch;
	}

	public Susceptance getBch(){
		return this.bch;
	}

	@FieldSetter(fieldName = "ACLineSegment.bch", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setBch(Susceptance bch){
		this.bch = bch;
	}

	public CapacitancePerLength getC0PerLength(){
		return this.c0PerLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.c0PerLength", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setC0PerLength(CapacitancePerLength c0PerLength){
		this.c0PerLength = c0PerLength;
	}

	public Float getCapacityCurrent(){
		return this.capacityCurrent;
	}

	@FieldSetter(fieldName = "ACLineSegment.capacityCurrent", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setCapacityCurrent(Float capacityCurrent){
		this.capacityCurrent = capacityCurrent;
	}

	public Float getComplicationFactor(){
		return this.complicationFactor;
	}

	@FieldSetter(fieldName = "ACLineSegment.complicationFactor", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setComplicationFactor(Float complicationFactor){
		this.complicationFactor = complicationFactor;
	}

	public Float getConstructionLength(){
		return this.constructionLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.constructionLength", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setConstructionLength(Float constructionLength){
		this.constructionLength = constructionLength;
	}

	public CapacitancePerLength getCPerLength(){
		return this.cPerLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.cPerLength", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setCPerLength(CapacitancePerLength cPerLength){
		this.cPerLength = cPerLength;
	}

	public Float getCrossSectionalArea(){
		return this.crossSectionalArea;
	}

	@FieldSetter(fieldName = "ACLineSegment.crossSectionalArea", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setCrossSectionalArea(Float crossSectionalArea){
		this.crossSectionalArea = crossSectionalArea;
	}

	public Float getFactorOper(){
		return this.factorOper;
	}

	@FieldSetter(fieldName = "ACLineSegment.factorOper", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setFactorOper(Float factorOper){
		this.factorOper = factorOper;
	}

	public Float getFactorTech(){
		return this.factorTech;
	}

	@FieldSetter(fieldName = "ACLineSegment.factorTech", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setFactorTech(Float factorTech){
		this.factorTech = factorTech;
	}

	public Conductance getG0ch(){
		return this.g0ch;
	}

	@FieldSetter(fieldName = "ACLineSegment.g0ch", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setG0ch(Conductance g0ch){
		this.g0ch = g0ch;
	}

	public Conductance getGch(){
		return this.gch;
	}

	@FieldSetter(fieldName = "ACLineSegment.gch", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setGch(Conductance gch){
		this.gch = gch;
	}

	public InductancePerLength getL0PerLength(){
		return this.l0PerLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.l0PerLength", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setL0PerLength(InductancePerLength l0PerLength){
		this.l0PerLength = l0PerLength;
	}

	public Float getLongPermissibleCurrent(){
		return this.longPermissibleCurrent;
	}

	@FieldSetter(fieldName = "ACLineSegment.longPermissibleCurrent", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setLongPermissibleCurrent(Float longPermissibleCurrent){
		this.longPermissibleCurrent = longPermissibleCurrent;
	}

	public InductancePerLength getLPerLength(){
		return this.lPerLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.lPerLength", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setLPerLength(InductancePerLength lPerLength){
		this.lPerLength = lPerLength;
	}

	public Float getMaxPermissibleVoltage(){
		return this.maxPermissibleVoltage;
	}

	@FieldSetter(fieldName = "ACLineSegment.maxPermissibleVoltage", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setMaxPermissibleVoltage(Float maxPermissibleVoltage){
		this.maxPermissibleVoltage = maxPermissibleVoltage;
	}

	public Integer getPeriod(){
		return this.period;
	}

	@FieldSetter(fieldName = "ACLineSegment.period", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPeriod(Integer period){
		this.period = period;
	}

	public Float getPriceAdditionalValue(){
		return this.priceAdditionalValue;
	}

	@FieldSetter(fieldName = "ACLineSegment.priceAdditionalValue", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceAdditionalValue(Float priceAdditionalValue){
		this.priceAdditionalValue = priceAdditionalValue;
	}

	public Float getPriceBase(){
		return this.priceBase;
	}

	@FieldSetter(fieldName = "ACLineSegment.priceBase", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceBase(Float priceBase){
		this.priceBase = priceBase;
	}

	public Float getPriceCollector(){
		return this.priceCollector;
	}

	@FieldSetter(fieldName = "ACLineSegment.priceCollector", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceCollector(Float priceCollector){
		this.priceCollector = priceCollector;
	}

	public Float getPriceOper(){
		return this.priceOper;
	}

	@FieldSetter(fieldName = "ACLineSegment.priceOper", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceOper(Float priceOper){
		this.priceOper = priceOper;
	}

	public Float getPriceSwitchPoint(){
		return this.priceSwitchPoint;
	}

	@FieldSetter(fieldName = "ACLineSegment.priceSwitchPoint", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceSwitchPoint(Float priceSwitchPoint){
		this.priceSwitchPoint = priceSwitchPoint;
	}

	public Float getPriceTech(){
		return this.priceTech;
	}

	@FieldSetter(fieldName = "ACLineSegment.priceTech", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceTech(Float priceTech){
		this.priceTech = priceTech;
	}

	public Resistance getR(){
		return this.r;
	}

	@FieldSetter(fieldName = "ACLineSegment.r", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR(Resistance r){
		this.r = r;
	}

	public Resistance getR0(){
		return this.r0;
	}

	@FieldSetter(fieldName = "ACLineSegment.r0", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR0(Resistance r0){
		this.r0 = r0;
	}

	public ResistancePerLength getR0PerLength(){
		return this.r0PerLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.r0PerLength", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setR0PerLength(ResistancePerLength r0PerLength){
		this.r0PerLength = r0PerLength;
	}

	public ResistancePerLength getRPerLength(){
		return this.rPerLength;
	}

	@FieldSetter(fieldName = "ACLineSegment.rPerLength", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setRPerLength(ResistancePerLength rPerLength){
		this.rPerLength = rPerLength;
	}

	public Temperature getShortCircuitEndTemperature(){
		return this.shortCircuitEndTemperature;
	}

	@FieldSetter(fieldName = "ACLineSegment.shortCircuitEndTemperature", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setShortCircuitEndTemperature(Temperature shortCircuitEndTemperature){
		this.shortCircuitEndTemperature = shortCircuitEndTemperature;
	}

	public Integer getSwitchPointsNumber(){
		return this.switchPointsNumber;
	}

	@FieldSetter(fieldName = "ACLineSegment.switchPointsNumber", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setSwitchPointsNumber(Integer switchPointsNumber){
		this.switchPointsNumber = switchPointsNumber;
	}

	public ACLineSegmentType getType(){
		return this.type;
	}

	@FieldSetter(fieldName = "ACLineSegment.type", fieldTypeStereotype = "Enumeration", fieldStereotype = "nti")
	public void setType(ACLineSegmentType type){
		this.type = type;
	}

	public Reactance getX(){
		return this.x;
	}

	@FieldSetter(fieldName = "ACLineSegment.x", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX(Reactance x){
		this.x = x;
	}

	public Reactance getX0(){
		return this.x0;
	}

	@FieldSetter(fieldName = "ACLineSegment.x0", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX0(Reactance x0){
		this.x0 = x0;
	}

	@JsonIgnore
	public List<LineFault> getLineFaults(){
		return this.LineFaults;
	}

	@AssociationSetter(fieldName = "ACLineSegment.LineFaults", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Faults.LineFault", cardinality = "many")
	public void setLineFaults(List<LineFault> LineFaults){
		this.LineFaults = LineFaults;
	}

	public ACLineSegment(){

	}

}
