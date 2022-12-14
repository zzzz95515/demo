package ru.mpei.prob.model.CIMProfile.NTI.EnergyStorageSystems;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.Equipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CurrentFlow;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Voltage;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * Ячейка аккумуляторной батареи
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "batterybankcell")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatteryBankCell extends Equipment {
	/**
	 * Емкость АКБ, А*ч
	 */
	@Column(name="capacity", nullable = true)
	private Float capacity;
	/**
	 * Плотность вещества электролита, грамм / см^3
	 */
	@Column(name="electroliteDensity", nullable = true)
	private Float electroliteDensity;
	/**
	 * Максимальный ток заряда
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="maxChargingCurrent_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="maxChargingCurrent_unit")),
		@AttributeOverride(name="value", column=@Column(name="maxChargingCurrent_value")),
	})
	private CurrentFlow maxChargingCurrent;
	/**
	 * Максимальный ток разряда
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="maxDischargingCurrent_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="maxDischargingCurrent_unit")),
		@AttributeOverride(name="value", column=@Column(name="maxDischargingCurrent_value")),
	})
	private CurrentFlow maxDischargingCurrent;
	/**
	 * Максимальное рабочее напряжение
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="maxWorkingVoltage_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="maxWorkingVoltage_unit")),
		@AttributeOverride(name="value", column=@Column(name="maxWorkingVoltage_value")),
	})
	private Voltage maxWorkingVoltage;
	/**
	 * Минимальное рабочее напряжение
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="minWorkingVoltage_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="minWorkingVoltage_unit")),
		@AttributeOverride(name="value", column=@Column(name="minWorkingVoltage_value")),
	})
	private Voltage minWorkingVoltage;
	/**
	 * Прочие затраты
	 */
	@Column(name="priceAdditional", nullable = true)
	private Float priceAdditional;
	/**
	 * Кап.затраты на помещение
	 */
	@Column(name="priceLocation", nullable = true)
	private Float priceLocation;
	/**
	 * Стандартный ток заряда
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="ratedChargingCurrent_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="ratedChargingCurrent_unit")),
		@AttributeOverride(name="value", column=@Column(name="ratedChargingCurrent_value")),
	})
	private CurrentFlow ratedChargingCurrent;
	/**
	 * Стандартный ток разряда
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="ratedDischargingCurrent_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="ratedDischargingCurrent_unit")),
		@AttributeOverride(name="value", column=@Column(name="ratedDischargingCurrent_value")),
	})
	private CurrentFlow ratedDischargingCurrent;
	/**
	 * Номинальное напряжение
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="ratedVoltage_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="ratedVoltage_unit")),
		@AttributeOverride(name="value", column=@Column(name="ratedVoltage_value")),
	})
	private Voltage ratedVoltage;


	public Float getCapacity(){
		return this.capacity;
	}

	@FieldSetter(fieldName = "BatteryBankCell.capacity", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setCapacity(Float capacity){
		this.capacity = capacity;
	}

	public Float getElectroliteDensity(){
		return this.electroliteDensity;
	}

	@FieldSetter(fieldName = "BatteryBankCell.electroliteDensity", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setElectroliteDensity(Float electroliteDensity){
		this.electroliteDensity = electroliteDensity;
	}

	public CurrentFlow getMaxChargingCurrent(){
		return this.maxChargingCurrent;
	}

	@FieldSetter(fieldName = "BatteryBankCell.maxChargingCurrent", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setMaxChargingCurrent(CurrentFlow maxChargingCurrent){
		this.maxChargingCurrent = maxChargingCurrent;
	}

	public CurrentFlow getMaxDischargingCurrent(){
		return this.maxDischargingCurrent;
	}

	@FieldSetter(fieldName = "BatteryBankCell.maxDischargingCurrent", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setMaxDischargingCurrent(CurrentFlow maxDischargingCurrent){
		this.maxDischargingCurrent = maxDischargingCurrent;
	}

	public Voltage getMaxWorkingVoltage(){
		return this.maxWorkingVoltage;
	}

	@FieldSetter(fieldName = "BatteryBankCell.maxWorkingVoltage", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setMaxWorkingVoltage(Voltage maxWorkingVoltage){
		this.maxWorkingVoltage = maxWorkingVoltage;
	}

	public Voltage getMinWorkingVoltage(){
		return this.minWorkingVoltage;
	}

	@FieldSetter(fieldName = "BatteryBankCell.minWorkingVoltage", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setMinWorkingVoltage(Voltage minWorkingVoltage){
		this.minWorkingVoltage = minWorkingVoltage;
	}

	public Float getPriceAdditional(){
		return this.priceAdditional;
	}

	@FieldSetter(fieldName = "BatteryBankCell.priceAdditional", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceAdditional(Float priceAdditional){
		this.priceAdditional = priceAdditional;
	}

	public Float getPriceLocation(){
		return this.priceLocation;
	}

	@FieldSetter(fieldName = "BatteryBankCell.priceLocation", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setPriceLocation(Float priceLocation){
		this.priceLocation = priceLocation;
	}

	public CurrentFlow getRatedChargingCurrent(){
		return this.ratedChargingCurrent;
	}

	@FieldSetter(fieldName = "BatteryBankCell.ratedChargingCurrent", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setRatedChargingCurrent(CurrentFlow ratedChargingCurrent){
		this.ratedChargingCurrent = ratedChargingCurrent;
	}

	public CurrentFlow getRatedDischargingCurrent(){
		return this.ratedDischargingCurrent;
	}

	@FieldSetter(fieldName = "BatteryBankCell.ratedDischargingCurrent", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setRatedDischargingCurrent(CurrentFlow ratedDischargingCurrent){
		this.ratedDischargingCurrent = ratedDischargingCurrent;
	}

	public Voltage getRatedVoltage(){
		return this.ratedVoltage;
	}

	@FieldSetter(fieldName = "BatteryBankCell.ratedVoltage", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
	public void setRatedVoltage(Voltage ratedVoltage){
		this.ratedVoltage = ratedVoltage;
	}

	public BatteryBankCell(){

	}

}
