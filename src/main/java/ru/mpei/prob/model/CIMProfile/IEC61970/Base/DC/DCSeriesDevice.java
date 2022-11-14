package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Inductance;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Resistance;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Voltage;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * A series device within the DC system, typically a reactor used for filtering 
 * or smoothing.  Needed for transient and short circuit studies.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:51 MSK 2020
 */

@Entity
@Table(name = "dcseriesdevice")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DCSeriesDevice extends DCConductingEquipment {
	/**
	 * Inductance of the device.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="inductance_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="inductance_unit")),
		@AttributeOverride(name="value", column=@Column(name="inductance_value")),
	})
	private Inductance inductance;
	/**
	 * Rated DC device voltage. Converter configuration data used in power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="ratedUdc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="ratedUdc_unit")),
		@AttributeOverride(name="value", column=@Column(name="ratedUdc_value")),
	})
	private Voltage ratedUdc;
	/**
	 * Resistance of the DC device.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="resistance_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="resistance_unit")),
		@AttributeOverride(name="value", column=@Column(name="resistance_value")),
	})
	private Resistance resistance;


	public Inductance getInductance(){
		return this.inductance;
	}

	@FieldSetter(fieldName = "DCSeriesDevice.inductance", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setInductance(Inductance inductance){
		this.inductance = inductance;
	}

	public Voltage getRatedUdc(){
		return this.ratedUdc;
	}

	@FieldSetter(fieldName = "DCSeriesDevice.ratedUdc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setRatedUdc(Voltage ratedUdc){
		this.ratedUdc = ratedUdc;
	}

	public Resistance getResistance(){
		return this.resistance;
	}

	@FieldSetter(fieldName = "DCSeriesDevice.resistance", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setResistance(Resistance resistance){
		this.resistance = resistance;
	}

	public DCSeriesDevice(){

	}

}