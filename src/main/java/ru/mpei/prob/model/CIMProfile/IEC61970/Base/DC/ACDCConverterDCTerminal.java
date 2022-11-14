package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "acdcconverterdcterminal")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ACDCConverterDCTerminal extends DCBaseTerminal {
	/**
	 * Represents the normal network polarity condition.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "polarity")
	private DCPolarityKind polarity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dcconductingequipment_mrid")
	@JoinColumn(name = "dcconductingequipment_projectid")
	@JoinColumn(name = "dcconductingequipment_synthesizedschemenumber")
	@JoinColumn(name = "dcconductingequipment_schemascenarionumber")
	private ACDCConverter DCConductingEquipment;

	public DCPolarityKind getPolarity(){
		return this.polarity;
	}

	@FieldSetter(fieldName = "ACDCConverterDCTerminal.polarity", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setPolarity(DCPolarityKind polarity){
		this.polarity = polarity;
	}

	public ACDCConverter getDCConductingEquipment(){
		return this.DCConductingEquipment;
	}

	@AssociationSetter(fieldName = "ACDCConverterDCTerminal.DCConductingEquipment", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.ACDCConverter", cardinality = "one")
	public void setDCConductingEquipment(ACDCConverter DCConductingEquipment){
		this.DCConductingEquipment = DCConductingEquipment;
	}

	public ACDCConverterDCTerminal(){

	}

}
