package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CapacitancePerLength;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.InductancePerLength;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.ResistancePerLength;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.PerLengthLineParameter;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "perlengthdclineparameter")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerLengthDCLineParameter extends PerLengthLineParameter {
	/**
	 * Capacitance per unit of length of the DC line segment; significant for 
	 * cables only.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="capacitance_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="capacitance_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="capacitance_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="capacitance_unit")),
		@AttributeOverride(name="value", column=@Column(name="capacitance_value")),
	})
	private CapacitancePerLength capacitance;
	/**
	 * Inductance per unit of length of the DC line segment.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="inductance_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="inductance_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="inductance_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="inductance_unit")),
		@AttributeOverride(name="value", column=@Column(name="inductance_value")),
	})
	private InductancePerLength inductance;
	/**
	 * Resistance per length of the DC line segment.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="denominatorMultiplier", column=@Column(name="resistance_denominatorMultiplier")),
		@AttributeOverride(name="denominatorUnit", column=@Column(name="resistance_denominatorUnit")),
		@AttributeOverride(name="multiplier", column=@Column(name="resistance_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="resistance_unit")),
		@AttributeOverride(name="value", column=@Column(name="resistance_value")),
	})
	private ResistancePerLength resistance;

	/**
	 * Set of per-length parameters for this line segment.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "PerLengthParameter")
	private List<DCLineSegment> DCLineSegments;

	public CapacitancePerLength getCapacitance(){
		return this.capacitance;
	}

	@FieldSetter(fieldName = "PerLengthDCLineParameter.capacitance", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setCapacitance(CapacitancePerLength capacitance){
		this.capacitance = capacitance;
	}

	public InductancePerLength getInductance(){
		return this.inductance;
	}

	@FieldSetter(fieldName = "PerLengthDCLineParameter.inductance", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setInductance(InductancePerLength inductance){
		this.inductance = inductance;
	}

	public ResistancePerLength getResistance(){
		return this.resistance;
	}

	@FieldSetter(fieldName = "PerLengthDCLineParameter.resistance", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setResistance(ResistancePerLength resistance){
		this.resistance = resistance;
	}

	@JsonIgnore
	public List<DCLineSegment> getDCLineSegments(){
		return this.DCLineSegments;
	}

	@AssociationSetter(fieldName = "PerLengthDCLineParameter.DCLineSegments", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.DCLineSegment", cardinality = "many")
	public void setDCLineSegments(List<DCLineSegment> DCLineSegments){
		this.DCLineSegments = DCLineSegments;
	}

	public PerLengthDCLineParameter(){

	}

}
