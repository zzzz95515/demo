package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * Multi-purpose data points for defining a curve.  The use of this generic 
 * class is discouraged if a more specific class  can be used to specify the 
 * x and y axis values along with their specific data types.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "curvedata")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class CurveData extends IdentifiedObject{
	/**
	 * The data value of the X-axis variable,  depending on the X-axis units.
	 */
	@Column(name="xvalue", nullable = true)
	private Float xvalue;
	/**
	 * The data value of the  first Y-axis variable, depending on the Y-axis units.
	 */
	@Column(name="y1value", nullable = true)
	private Float y1value;
	/**
	 * The data value of the second Y-axis variable (if present), depending on 
	 * the Y-axis units.
	 */
	@Column(name="y2value", nullable = true)
	private Float y2value;
	/**
	 * The data value of the third Y-axis variable (if present), depending on 
	 * the Y-axis units.
	 */
	@Column(name="y3value", nullable = true)
	private Float y3value;

	/**
	 * The point data values that define this curve.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curve_mrid")
	@JoinColumn(name = "curve_projectid")
	@JoinColumn(name = "curve_synthesizedschemenumber")
	@JoinColumn(name = "curve_schemascenarionumber")
	private Curve Curve;

	public Float getXvalue(){
		return this.xvalue;
	}

	@FieldSetter(fieldName = "CurveData.xvalue", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setXvalue(Float xvalue){
		this.xvalue = xvalue;
	}

	public Float getY1value(){
		return this.y1value;
	}

	@FieldSetter(fieldName = "CurveData.y1value", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setY1value(Float y1value){
		this.y1value = y1value;
	}

	public Float getY2value(){
		return this.y2value;
	}

	@FieldSetter(fieldName = "CurveData.y2value", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setY2value(Float y2value){
		this.y2value = y2value;
	}

	public Float getY3value(){
		return this.y3value;
	}

	@FieldSetter(fieldName = "CurveData.y3value", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setY3value(Float y3value){
		this.y3value = y3value;
	}

	public Curve getCurve(){
		return this.Curve;
	}

	@AssociationSetter(fieldName = "CurveData.Curve", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.Curve", cardinality = "one")
	public void setCurve(Curve Curve){
		this.Curve = Curve;
	}

	public CurveData(){

	}

}
