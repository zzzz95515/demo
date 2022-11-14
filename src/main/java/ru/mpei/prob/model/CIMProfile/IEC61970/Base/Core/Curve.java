package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.UnitMultiplier;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.UnitSymbol;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A multi-purpose curve or functional relationship between an independent 
 * variable (X-axis) and dependent (Y-axis) variables. 
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "curve")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Curve extends IdentifiedObject {
	/**
	 * The style or shape of the curve.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "curveStyle")
	private CurveStyle curveStyle;
	/**
	 * Multiplier for X-axis.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "xMultiplier")
	private UnitMultiplier xMultiplier;
	/**
	 * The X-axis units of measure.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "xUnit")
	private UnitSymbol xUnit;
	/**
	 * Multiplier for Y1-axis.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "y1Multiplier")
	private UnitMultiplier y1Multiplier;
	/**
	 * The Y1-axis units of measure.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "y1Unit")
	private UnitSymbol y1Unit;
	/**
	 * Multiplier for Y2-axis.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "y2Multiplier")
	private UnitMultiplier y2Multiplier;
	/**
	 * The Y2-axis units of measure.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "y2Unit")
	private UnitSymbol y2Unit;
	/**
	 * Multiplier for Y3-axis.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "y3Multiplier")
	private UnitMultiplier y3Multiplier;
	/**
	 * The Y3-axis units of measure.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "y3Unit")
	private UnitSymbol y3Unit;

	/**
	 * The curve of  this curve data point.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Curve")
	private List<CurveData> CurveDatas;

	public CurveStyle getCurveStyle(){
		return this.curveStyle;
	}

	@FieldSetter(fieldName = "Curve.curveStyle", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setCurveStyle(CurveStyle curveStyle){
		this.curveStyle = curveStyle;
	}

	public UnitMultiplier getXMultiplier(){
		return this.xMultiplier;
	}

	@FieldSetter(fieldName = "Curve.xMultiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setXMultiplier(UnitMultiplier xMultiplier){
		this.xMultiplier = xMultiplier;
	}

	public UnitSymbol getXUnit(){
		return this.xUnit;
	}

	@FieldSetter(fieldName = "Curve.xUnit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setXUnit(UnitSymbol xUnit){
		this.xUnit = xUnit;
	}

	public UnitMultiplier getY1Multiplier(){
		return this.y1Multiplier;
	}

	@FieldSetter(fieldName = "Curve.y1Multiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setY1Multiplier(UnitMultiplier y1Multiplier){
		this.y1Multiplier = y1Multiplier;
	}

	public UnitSymbol getY1Unit(){
		return this.y1Unit;
	}

	@FieldSetter(fieldName = "Curve.y1Unit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setY1Unit(UnitSymbol y1Unit){
		this.y1Unit = y1Unit;
	}

	public UnitMultiplier getY2Multiplier(){
		return this.y2Multiplier;
	}

	@FieldSetter(fieldName = "Curve.y2Multiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setY2Multiplier(UnitMultiplier y2Multiplier){
		this.y2Multiplier = y2Multiplier;
	}

	public UnitSymbol getY2Unit(){
		return this.y2Unit;
	}

	@FieldSetter(fieldName = "Curve.y2Unit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setY2Unit(UnitSymbol y2Unit){
		this.y2Unit = y2Unit;
	}

	public UnitMultiplier getY3Multiplier(){
		return this.y3Multiplier;
	}

	@FieldSetter(fieldName = "Curve.y3Multiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setY3Multiplier(UnitMultiplier y3Multiplier){
		this.y3Multiplier = y3Multiplier;
	}

	public UnitSymbol getY3Unit(){
		return this.y3Unit;
	}

	@FieldSetter(fieldName = "Curve.y3Unit", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setY3Unit(UnitSymbol y3Unit){
		this.y3Unit = y3Unit;
	}

	@JsonIgnore
	public List<CurveData> getCurveDatas(){
		return this.CurveDatas;
	}

	@AssociationSetter(fieldName = "Curve.CurveDatas", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.CurveData", cardinality = "many")
	public void setCurveDatas(List<CurveData> CurveDatas){
		this.CurveDatas = CurveDatas;
	}

	public Curve(){

	}

}
