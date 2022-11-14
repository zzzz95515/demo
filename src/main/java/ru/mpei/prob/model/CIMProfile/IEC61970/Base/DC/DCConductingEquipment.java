package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.Equipment;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * The parts of the DC power system that are designed to carry current or 
 * that are conductively connected through DC terminals.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "dcconductingequipment")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DCConductingEquipment extends Equipment {

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "DCConductingEquipment")
	private List<DCTerminal> DCTerminals;

	@JsonIgnore
	public List<DCTerminal> getDCTerminals(){
		return this.DCTerminals;
	}

	@AssociationSetter(fieldName = "DCConductingEquipment.DCTerminals", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.DCTerminal", cardinality = "many")
	public void setDCTerminals(List<DCTerminal> DCTerminals){
		this.DCTerminals = DCTerminals;
	}

	public DCConductingEquipment(){

	}

}
