package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.PerCent;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "tapchangertablepoint")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class TapChangerTablePoint extends IdentifiedObject{
	/**
	 * The magnetizing branch susceptance deviation in percent of nominal value. 
	 * The actual susceptance is calculated as follows:calculated magnetizing 
	 * susceptance = b(nominal) * (1 + b(from this class)/100).   The b(nominal) 
	 * is defined as the static magnetizing susceptance on the associated power 
	 * transformer end or ends.  This model assumes the star impedance (pi model) 
	 * form.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="b_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="b_unit")),
		@AttributeOverride(name="value", column=@Column(name="b_value")),
	})
	private PerCent b;
	/**
	 * The magnetizing branch conductance deviation in percent of nominal value. 
	 * The actual conductance is calculated as follows:calculated magnetizing 
	 * conductance = g(nominal) * (1 + g(from this class)/100).   The g(nominal) 
	 * is defined as the static magnetizing conductance on the associated power 
	 * transformer end or ends.  This model assumes the star impedance (pi model) 
	 * form.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="g_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="g_unit")),
		@AttributeOverride(name="value", column=@Column(name="g_value")),
	})
	private PerCent g;
	/**
	 * The resistance deviation in percent of nominal value. The actual reactance 
	 * is calculated as follows:calculated resistance = r(nominal) * (1 + r(from 
	 * this class)/100).   The r(nominal) is defined as the static resistance 
	 * on the associated power transformer end or ends.  This model assumes the 
	 * star impedance (pi model) form.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="r_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="r_unit")),
		@AttributeOverride(name="value", column=@Column(name="r_value")),
	})
	private PerCent r;
	/**
	 * The voltage ratio in per unit. Hence this is a value close to one.
	 */
	@Column(name="ratio", nullable = true)
	private Float ratio;
	/**
	 * The tap step.
	 */
	@Column(name="step", nullable = true)
	private Integer step;
	/**
	 * The series reactance deviation in percent of nominal value. The actual 
	 * reactance is calculated as follows:calculated reactance = x(nominal) * 
	 * (1 + x(from this class)/100).   The x(nominal) is defined as the static 
	 * series reactance on the associated power transformer end or ends.  This 
	 * model assumes the star impedance (pi model) form.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="x_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="x_unit")),
		@AttributeOverride(name="value", column=@Column(name="x_value")),
	})
	private PerCent x;


	public PerCent getB(){
		return this.b;
	}

	@FieldSetter(fieldName = "TapChangerTablePoint.b", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setB(PerCent b){
		this.b = b;
	}

	public PerCent getG(){
		return this.g;
	}

	@FieldSetter(fieldName = "TapChangerTablePoint.g", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setG(PerCent g){
		this.g = g;
	}

	public PerCent getR(){
		return this.r;
	}

	@FieldSetter(fieldName = "TapChangerTablePoint.r", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setR(PerCent r){
		this.r = r;
	}

	public Float getRatio(){
		return this.ratio;
	}

	@FieldSetter(fieldName = "TapChangerTablePoint.ratio", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setRatio(Float ratio){
		this.ratio = ratio;
	}

	public Integer getStep(){
		return this.step;
	}

	@FieldSetter(fieldName = "TapChangerTablePoint.step", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setStep(Integer step){
		this.step = step;
	}

	public PerCent getX(){
		return this.x;
	}

	@FieldSetter(fieldName = "TapChangerTablePoint.x", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setX(PerCent x){
		this.x = x;
	}

	public TapChangerTablePoint(){

	}

}
