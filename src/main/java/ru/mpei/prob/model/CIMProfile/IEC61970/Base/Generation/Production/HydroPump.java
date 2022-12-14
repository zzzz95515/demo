package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Generation.Production;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.Equipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.ActivePower;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.VolumeFlowRate;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.RotatingMachine;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * A synchronous motor-driven pump, typically associated with a pumped storage 
 * plant.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:52 MSK 2020
 */

@Entity
@Table(name = "hydropump")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HydroPump extends Equipment {
	/**
	 * The pumping discharge under maximum head conditions, usually at full gate.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="pumpDischAtMaxHead_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="pumpDischAtMaxHead_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="pumpDischAtMaxHead_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="pumpDischAtMaxHead_unit")),
		@AttributeOverride(name="value", column=@Column(name="pumpDischAtMaxHead_value")),
	})
	private VolumeFlowRate pumpDischAtMaxHead;
	/**
	 * The pumping discharge under minimum head conditions, usually at full gate.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="pumpDischAtMinHead_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="pumpDischAtMinHead_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="pumpDischAtMinHead_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="pumpDischAtMinHead_unit")),
		@AttributeOverride(name="value", column=@Column(name="pumpDischAtMinHead_value")),
	})
	private VolumeFlowRate pumpDischAtMinHead;
	/**
	 * The pumping power under maximum head conditions, usually at full gate.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="pumpPowerAtMaxHead_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="pumpPowerAtMaxHead_unit")),
		@AttributeOverride(name="value", column=@Column(name="pumpPowerAtMaxHead_value")),
	})
	private ActivePower pumpPowerAtMaxHead;
	/**
	 * The pumping power under minimum head conditions, usually at full gate.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="pumpPowerAtMinHead_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="pumpPowerAtMinHead_unit")),
		@AttributeOverride(name="value", column=@Column(name="pumpPowerAtMinHead_value")),
	})
	private ActivePower pumpPowerAtMinHead;

	/**
	 * The hydro pump may be a member of a pumped storage plant or a pump for 
	 * distributing water.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hydropowerplant_mrid")
	@JoinColumn(name = "hydropowerplant_projectid")
	@JoinColumn(name = "hydropowerplant_synthesizedschemenumber")
	@JoinColumn(name = "hydropowerplant_schemascenarionumber")
	private HydroPowerPlant HydroPowerPlant;
	/**
	 * The synchronous machine drives the turbine which moves the water from a 
	 * low elevation to a higher elevation. The direction of machine rotation 
	 * for pumping may or may not be the same as for generating.
	 */
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "HydroPump")
	private RotatingMachine RotatingMachine;

	public VolumeFlowRate getPumpDischAtMaxHead(){
		return this.pumpDischAtMaxHead;
	}

	@FieldSetter(fieldName = "HydroPump.pumpDischAtMaxHead", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPumpDischAtMaxHead(VolumeFlowRate pumpDischAtMaxHead){
		this.pumpDischAtMaxHead = pumpDischAtMaxHead;
	}

	public VolumeFlowRate getPumpDischAtMinHead(){
		return this.pumpDischAtMinHead;
	}

	@FieldSetter(fieldName = "HydroPump.pumpDischAtMinHead", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPumpDischAtMinHead(VolumeFlowRate pumpDischAtMinHead){
		this.pumpDischAtMinHead = pumpDischAtMinHead;
	}

	public ActivePower getPumpPowerAtMaxHead(){
		return this.pumpPowerAtMaxHead;
	}

	@FieldSetter(fieldName = "HydroPump.pumpPowerAtMaxHead", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPumpPowerAtMaxHead(ActivePower pumpPowerAtMaxHead){
		this.pumpPowerAtMaxHead = pumpPowerAtMaxHead;
	}

	public ActivePower getPumpPowerAtMinHead(){
		return this.pumpPowerAtMinHead;
	}

	@FieldSetter(fieldName = "HydroPump.pumpPowerAtMinHead", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPumpPowerAtMinHead(ActivePower pumpPowerAtMinHead){
		this.pumpPowerAtMinHead = pumpPowerAtMinHead;
	}

	public HydroPowerPlant getHydroPowerPlant(){
		return this.HydroPowerPlant;
	}

	@AssociationSetter(fieldName = "HydroPump.HydroPowerPlant", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Generation.Production.HydroPowerPlant", cardinality = "one")
	public void setHydroPowerPlant(HydroPowerPlant HydroPowerPlant){
		this.HydroPowerPlant = HydroPowerPlant;
	}

	@JsonIgnore
	public RotatingMachine getRotatingMachine(){
		return this.RotatingMachine;
	}

	@AssociationSetter(fieldName = "HydroPump.RotatingMachine", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.RotatingMachine", cardinality = "one")
	public void setRotatingMachine(RotatingMachine RotatingMachine){
		this.RotatingMachine = RotatingMachine;
	}

	public HydroPump(){

	}

}
