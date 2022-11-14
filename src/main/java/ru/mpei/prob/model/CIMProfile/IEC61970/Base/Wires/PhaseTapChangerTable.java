package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * Describes a tabular curve for how the phase angle difference and impedance 
 * varies with the tap step.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "phasetapchangertable")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhaseTapChangerTable extends IdentifiedObject {

	/**
	 * The phase tap changer table for this phase tap changer.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "PhaseTapChangerTable")
	private List<PhaseTapChangerTabular> PhaseTapChangerTabular;
	/**
	 * The table of this point.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "PhaseTapChangerTable")
	private List<PhaseTapChangerTablePoint> PhaseTapChangerTablePoint;

	@JsonIgnore
	public List<PhaseTapChangerTabular> getPhaseTapChangerTabular(){
		return this.PhaseTapChangerTabular;
	}

	@AssociationSetter(fieldName = "PhaseTapChangerTable.PhaseTapChangerTabular", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.PhaseTapChangerTabular", cardinality = "many")
	public void setPhaseTapChangerTabular(List<PhaseTapChangerTabular> PhaseTapChangerTabular){
		this.PhaseTapChangerTabular = PhaseTapChangerTabular;
	}

	@JsonIgnore
	public List<PhaseTapChangerTablePoint> getPhaseTapChangerTablePoint(){
		return this.PhaseTapChangerTablePoint;
	}

	@AssociationSetter(fieldName = "PhaseTapChangerTable.PhaseTapChangerTablePoint", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.PhaseTapChangerTablePoint", cardinality = "many")
	public void setPhaseTapChangerTablePoint(List<PhaseTapChangerTablePoint> PhaseTapChangerTablePoint){
		this.PhaseTapChangerTablePoint = PhaseTapChangerTablePoint;
	}

	public PhaseTapChangerTable(){

	}

}
