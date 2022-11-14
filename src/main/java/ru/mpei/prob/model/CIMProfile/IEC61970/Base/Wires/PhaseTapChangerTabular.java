package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "phasetapchangertabular")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhaseTapChangerTabular extends PhaseTapChanger {

	/**
	 * The phase tap changers to which this phase tap table applies.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phasetapchangertable_mrid")
	@JoinColumn(name = "phasetapchangertable_projectid")
	@JoinColumn(name = "phasetapchangertable_synthesizedschemenumber")
	@JoinColumn(name = "phasetapchangertable_schemascenarionumber")
	private PhaseTapChangerTable PhaseTapChangerTable;

	public PhaseTapChangerTable getPhaseTapChangerTable(){
		return this.PhaseTapChangerTable;
	}

	@AssociationSetter(fieldName = "PhaseTapChangerTabular.PhaseTapChangerTable", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.PhaseTapChangerTable", cardinality = "one")
	public void setPhaseTapChangerTable(PhaseTapChangerTable PhaseTapChangerTable){
		this.PhaseTapChangerTable = PhaseTapChangerTable;
	}

	public PhaseTapChangerTabular(){

	}

}
