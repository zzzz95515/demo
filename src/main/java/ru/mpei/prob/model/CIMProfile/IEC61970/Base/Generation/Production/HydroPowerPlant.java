package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Generation.Production;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.PowerSystemResource;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A hydro power station which can generate or pump. When generating, the 
 * generator turbines receive water from an upper reservoir. When pumping, 
 * the pumps receive their water from a lower reservoir.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:52 MSK 2020
 */

@Entity
@Table(name = "hydropowerplant")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HydroPowerPlant extends PowerSystemResource {
	/**
	 * Water travel delay from tailbay to next downstream hydro power station.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="dischargeTravelDelay_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="dischargeTravelDelay_unit")),
		@AttributeOverride(name="value", column=@Column(name="dischargeTravelDelay_value")),
	})
	private Seconds dischargeTravelDelay;
	/**
	 * The hydro plant's generating rating active power for rated head conditions.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="genRatedP_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="genRatedP_unit")),
		@AttributeOverride(name="value", column=@Column(name="genRatedP_value")),
	})
	private ActivePower genRatedP;
	/**
	 * The type of hydro power plant water storage.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "hydroPlantStorageType")
	private HydroPlantStorageKind hydroPlantStorageType;
	/**
	 * Type and configuration of hydro plant penstock(s).
	 */
	@Column(name="penstockType", nullable = true)
	private String penstockType;
	/**
	 * Total plant discharge capacity.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="plantDischargeCapacity_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="plantDischargeCapacity_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="plantDischargeCapacity_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="plantDischargeCapacity_unit")),
		@AttributeOverride(name="value", column=@Column(name="plantDischargeCapacity_value")),
	})
	private VolumeFlowRate plantDischargeCapacity;
	/**
	 * The plant's rated gross head.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="plantRatedHead_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="plantRatedHead_unit")),
		@AttributeOverride(name="value", column=@Column(name="plantRatedHead_value")),
	})
	private Length plantRatedHead;
	/**
	 * The hydro plant's pumping rating active power for rated head conditions.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="pumpRatedP_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="pumpRatedP_unit")),
		@AttributeOverride(name="value", column=@Column(name="pumpRatedP_value")),
	})
	private ActivePower pumpRatedP;
	/**
	 * A code describing the type (or absence) of surge tank that is associated 
	 * with the hydro power plant.
	 */
	@Column(name="surgeTankCode", nullable = true)
	private String surgeTankCode;
	/**
	 * The level at which the surge tank spills.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="surgeTankCrestLevel_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="surgeTankCrestLevel_unit")),
		@AttributeOverride(name="value", column=@Column(name="surgeTankCrestLevel_value")),
	})
	private WaterLevel surgeTankCrestLevel;

	/**
	 * The hydro generating unit belongs to a hydro power plant.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "HydroPowerPlant")
	private List<HydroGeneratingUnit> HydroGeneratingUnits;
	/**
	 * The hydro pump may be a member of a pumped storage plant or a pump for 
	 * distributing water.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "HydroPowerPlant")
	private List<HydroPump> HydroPumps;

	public Seconds getDischargeTravelDelay(){
		return this.dischargeTravelDelay;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.dischargeTravelDelay", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setDischargeTravelDelay(Seconds dischargeTravelDelay){
		this.dischargeTravelDelay = dischargeTravelDelay;
	}

	public ActivePower getGenRatedP(){
		return this.genRatedP;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.genRatedP", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setGenRatedP(ActivePower genRatedP){
		this.genRatedP = genRatedP;
	}

	public HydroPlantStorageKind getHydroPlantStorageType(){
		return this.hydroPlantStorageType;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.hydroPlantStorageType", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setHydroPlantStorageType(HydroPlantStorageKind hydroPlantStorageType){
		this.hydroPlantStorageType = hydroPlantStorageType;
	}

	public String getPenstockType(){
		return this.penstockType;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.penstockType", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setPenstockType(String penstockType){
		this.penstockType = penstockType;
	}

	public VolumeFlowRate getPlantDischargeCapacity(){
		return this.plantDischargeCapacity;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.plantDischargeCapacity", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPlantDischargeCapacity(VolumeFlowRate plantDischargeCapacity){
		this.plantDischargeCapacity = plantDischargeCapacity;
	}

	public Length getPlantRatedHead(){
		return this.plantRatedHead;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.plantRatedHead", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPlantRatedHead(Length plantRatedHead){
		this.plantRatedHead = plantRatedHead;
	}

	public ActivePower getPumpRatedP(){
		return this.pumpRatedP;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.pumpRatedP", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPumpRatedP(ActivePower pumpRatedP){
		this.pumpRatedP = pumpRatedP;
	}

	public String getSurgeTankCode(){
		return this.surgeTankCode;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.surgeTankCode", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setSurgeTankCode(String surgeTankCode){
		this.surgeTankCode = surgeTankCode;
	}

	public WaterLevel getSurgeTankCrestLevel(){
		return this.surgeTankCrestLevel;
	}

	@FieldSetter(fieldName = "HydroPowerPlant.surgeTankCrestLevel", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setSurgeTankCrestLevel(WaterLevel surgeTankCrestLevel){
		this.surgeTankCrestLevel = surgeTankCrestLevel;
	}

	@JsonIgnore
	public List<HydroGeneratingUnit> getHydroGeneratingUnits(){
		return this.HydroGeneratingUnits;
	}

	@AssociationSetter(fieldName = "HydroPowerPlant.HydroGeneratingUnits", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Generation.Production.HydroGeneratingUnit", cardinality = "many")
	public void setHydroGeneratingUnits(List<HydroGeneratingUnit> HydroGeneratingUnits){
		this.HydroGeneratingUnits = HydroGeneratingUnits;
	}

	@JsonIgnore
	public List<HydroPump> getHydroPumps(){
		return this.HydroPumps;
	}

	@AssociationSetter(fieldName = "HydroPowerPlant.HydroPumps", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Generation.Production.HydroPump", cardinality = "many")
	public void setHydroPumps(List<HydroPump> HydroPumps){
		this.HydroPumps = HydroPumps;
	}

	public HydroPowerPlant(){

	}

}
