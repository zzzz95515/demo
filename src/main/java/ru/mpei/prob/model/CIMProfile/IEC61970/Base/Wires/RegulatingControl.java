package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.PhaseCode;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.PowerSystemResource;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.UnitMultiplier;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * Specifies a set of equipment that works together to control a power system 
 * quantity such as voltage or flow. Remote bus voltage control is possible 
 * by specifying the controlled terminal located at some place remote from 
 * the controlling equipment.In case multiple equipment, possibly of different 
 * types, control same terminal there must be only one RegulatingControl at 
 * that terminal. The most specific subtype of RegulatingControl shall be 
 * used in case such equipment participate in the control, e.g. TapChangerControl 
 * for tap changers.For flow control  load sign convention is used, i.e. positive 
 * sign means flow out from a TopologicalNode (bus) into the conducting equipment.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "regulatingcontrol")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegulatingControl extends PowerSystemResource {
	/**
	 * The regulation is performed in a discrete mode. This applies to equipment 
	 * with discrete controls, e.g. tap changers and shunt compensators.
	 */
	@Column(name="discrete", nullable = true)
	private Boolean discrete;
	/**
	 * The flag tells if regulation is enabled.
	 */
	@Column(name="enabled", nullable = true)
	private Boolean enabled;
	/**
	 * The regulating control mode presently available.  This specification allows 
	 * for determining the kind of regulation without need for obtaining the units 
	 * from a schedule.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "mode")
	private RegulatingControlModeKind mode;
	/**
	 * Phase voltage controlling this regulator, measured at regulator location.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "monitoredPhase")
	private PhaseCode monitoredPhase;
	/**
	 * This is a deadband used with discrete control to avoid excessive update 
	 * of controls like tap changers and shunt compensator banks while regulating.The 
	 * units of those appropriate for the mode.
	 */
	@Column(name="targetDeadband", nullable = true)
	private Float targetDeadband;
	/**
	 * The target value specified for case input.   This value can be used for 
	 * the target value without the use of schedules. The value has the units 
	 * appropriate to the mode attribute.
	 */
	@Column(name="targetValue", nullable = true)
	private Float targetValue;
	/**
	 * Specify the multiplier for used for the targetValue.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "targetValueUnitMultiplier")
	private UnitMultiplier targetValueUnitMultiplier;

	/**
	 * The regulating control scheme in which this equipment participates.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "RegulatingControl")
	private List<RegulatingCondEq> RegulatingCondEq;

	public Boolean getDiscrete(){
		return this.discrete;
	}

	@FieldSetter(fieldName = "RegulatingControl.discrete", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setDiscrete(Boolean discrete){
		this.discrete = discrete;
	}

	public Boolean getEnabled(){
		return this.enabled;
	}

	@FieldSetter(fieldName = "RegulatingControl.enabled", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setEnabled(Boolean enabled){
		this.enabled = enabled;
	}

	public RegulatingControlModeKind getMode(){
		return this.mode;
	}

	@FieldSetter(fieldName = "RegulatingControl.mode", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setMode(RegulatingControlModeKind mode){
		this.mode = mode;
	}

	public PhaseCode getMonitoredPhase(){
		return this.monitoredPhase;
	}

	@FieldSetter(fieldName = "RegulatingControl.monitoredPhase", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setMonitoredPhase(PhaseCode monitoredPhase){
		this.monitoredPhase = monitoredPhase;
	}

	public Float getTargetDeadband(){
		return this.targetDeadband;
	}

	@FieldSetter(fieldName = "RegulatingControl.targetDeadband", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setTargetDeadband(Float targetDeadband){
		this.targetDeadband = targetDeadband;
	}

	public Float getTargetValue(){
		return this.targetValue;
	}

	@FieldSetter(fieldName = "RegulatingControl.targetValue", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setTargetValue(Float targetValue){
		this.targetValue = targetValue;
	}

	public UnitMultiplier getTargetValueUnitMultiplier(){
		return this.targetValueUnitMultiplier;
	}

	@FieldSetter(fieldName = "RegulatingControl.targetValueUnitMultiplier", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setTargetValueUnitMultiplier(UnitMultiplier targetValueUnitMultiplier){
		this.targetValueUnitMultiplier = targetValueUnitMultiplier;
	}

	@JsonIgnore
	public List<RegulatingCondEq> getRegulatingCondEq(){
		return this.RegulatingCondEq;
	}

	@AssociationSetter(fieldName = "RegulatingControl.RegulatingCondEq", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.RegulatingCondEq", cardinality = "many")
	public void setRegulatingCondEq(List<RegulatingCondEq> RegulatingCondEq){
		this.RegulatingCondEq = RegulatingCondEq;
	}

	public RegulatingControl(){

	}

}
