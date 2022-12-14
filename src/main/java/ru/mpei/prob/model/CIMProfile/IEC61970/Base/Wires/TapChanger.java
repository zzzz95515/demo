package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.PowerSystemResource;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Seconds;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Voltage;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.StateVariables.SvTapStep;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * Mechanism for changing transformer winding tap positions.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:56 MSK 2020
 */

@Entity
@Table(name = "tapchanger")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TapChanger extends PowerSystemResource {
	/**
	 * Specifies the regulation status of the equipment.  True is regulating, 
	 * false is not regulating.
	 */
	@Column(name="controlEnabled", nullable = true)
	private Boolean controlEnabled;
	/**
	 * Highest possible tap step position, advance from neutral.The attribute 
	 * shall be greater than lowStep.
	 */
	@Column(name="highStep", nullable = true)
	private Integer highStep;
	/**
	 * For an LTC, the delay for initial tap changer operation (first step change)
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="initialDelay_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="initialDelay_unit")),
		@AttributeOverride(name="value", column=@Column(name="initialDelay_value")),
	})
	private Seconds initialDelay;
	/**
	 * Lowest possible tap step position, retard from neutral
	 */
	@Column(name="lowStep", nullable = true)
	private Integer lowStep;
	/**
	 * Specifies whether or not a TapChanger has load tap changing capabilities.
	 */
	@Column(name="ltcFlag", nullable = true)
	private Boolean ltcFlag;
	/**
	 * The neutral tap step position for this winding.The attribute shall be equal 
	 * or greater than lowStep and equal or less than highStep.
	 */
	@Column(name="neutralStep", nullable = true)
	private Integer neutralStep;
	/**
	 * Voltage at which the winding operates at the neutral tap setting.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="neutralU_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="neutralU_unit")),
		@AttributeOverride(name="value", column=@Column(name="neutralU_value")),
	})
	private Voltage neutralU;
	/**
	 * The tap step position used in "normal" network operation for this winding. 
	 * For a "Fixed" tap changer indicates the current physical tap setting.The 
	 * attribute shall be equal or greater than lowStep and equal or less than 
	 * highStep.
	 */
	@Column(name="normalStep", nullable = true)
	private Integer normalStep;
	/**
	 * Tap changer position.Starting step for a steady state solution. Non integer 
	 * values are allowed to support continuous tap variables. The reasons for 
	 * continuous value are to support study cases where no discrete tap changers 
	 * has yet been designed, a solutions where a narrow voltage band force the 
	 * tap step to oscillate or accommodate for a continuous solution as input.The 
	 * attribute shall be equal or greater than lowStep and equal or less than 
	 * highStep.
	 */
	@Column(name="step", nullable = true)
	private Float step;
	/**
	 * For an LTC, the delay for subsequent tap changer operation (second and 
	 * later step changes)
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="subsequentDelay_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="subsequentDelay_unit")),
		@AttributeOverride(name="value", column=@Column(name="subsequentDelay_value")),
	})
	private Seconds subsequentDelay;

	/**
	 * The tap changer associated with the tap step state.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "svtapstep_mrid")
	@JoinColumn(name = "svtapstep_projectid")
	@JoinColumn(name = "svtapstep_synthesizedschemenumber")
	@JoinColumn(name = "svtapstep_schemascenarionumber")
	private SvTapStep SvTapStep;
	/**
	 * The tap changers that participates in this regulating tap control scheme.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tapchangercontrol_mrid")
	@JoinColumn(name = "tapchangercontrol_projectid")
	@JoinColumn(name = "tapchangercontrol_synthesizedschemenumber")
	@JoinColumn(name = "tapchangercontrol_schemascenarionumber")
	private TapChangerControl TapChangerControl;

	public Boolean getControlEnabled(){
		return this.controlEnabled;
	}

	@FieldSetter(fieldName = "TapChanger.controlEnabled", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setControlEnabled(Boolean controlEnabled){
		this.controlEnabled = controlEnabled;
	}

	public Integer getHighStep(){
		return this.highStep;
	}

	@FieldSetter(fieldName = "TapChanger.highStep", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setHighStep(Integer highStep){
		this.highStep = highStep;
	}

	public Seconds getInitialDelay(){
		return this.initialDelay;
	}

	@FieldSetter(fieldName = "TapChanger.initialDelay", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setInitialDelay(Seconds initialDelay){
		this.initialDelay = initialDelay;
	}

	public Integer getLowStep(){
		return this.lowStep;
	}

	@FieldSetter(fieldName = "TapChanger.lowStep", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setLowStep(Integer lowStep){
		this.lowStep = lowStep;
	}

	public Boolean getLtcFlag(){
		return this.ltcFlag;
	}

	@FieldSetter(fieldName = "TapChanger.ltcFlag", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setLtcFlag(Boolean ltcFlag){
		this.ltcFlag = ltcFlag;
	}

	public Integer getNeutralStep(){
		return this.neutralStep;
	}

	@FieldSetter(fieldName = "TapChanger.neutralStep", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setNeutralStep(Integer neutralStep){
		this.neutralStep = neutralStep;
	}

	public Voltage getNeutralU(){
		return this.neutralU;
	}

	@FieldSetter(fieldName = "TapChanger.neutralU", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNeutralU(Voltage neutralU){
		this.neutralU = neutralU;
	}

	public Integer getNormalStep(){
		return this.normalStep;
	}

	@FieldSetter(fieldName = "TapChanger.normalStep", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setNormalStep(Integer normalStep){
		this.normalStep = normalStep;
	}

	public Float getStep(){
		return this.step;
	}

	@FieldSetter(fieldName = "TapChanger.step", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setStep(Float step){
		this.step = step;
	}

	public Seconds getSubsequentDelay(){
		return this.subsequentDelay;
	}

	@FieldSetter(fieldName = "TapChanger.subsequentDelay", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setSubsequentDelay(Seconds subsequentDelay){
		this.subsequentDelay = subsequentDelay;
	}

	public SvTapStep getSvTapStep(){
		return this.SvTapStep;
	}

	@AssociationSetter(fieldName = "TapChanger.SvTapStep", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.StateVariables.SvTapStep", cardinality = "one")
	public void setSvTapStep(SvTapStep SvTapStep){
		this.SvTapStep = SvTapStep;
	}

	public TapChangerControl getTapChangerControl(){
		return this.TapChangerControl;
	}

	@AssociationSetter(fieldName = "TapChanger.TapChangerControl", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.TapChangerControl", cardinality = "one")
	public void setTapChangerControl(TapChangerControl TapChangerControl){
		this.TapChangerControl = TapChangerControl;
	}

	public TapChanger(){

	}

}
