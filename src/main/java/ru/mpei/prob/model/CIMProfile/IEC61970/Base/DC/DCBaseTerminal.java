package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ACDCTerminal;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.DCTopologicalNode;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "dcbaseterminal")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DCBaseTerminal extends ACDCTerminal {

	/**
	 * See association end TopologicalNode.Terminal.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dctopologicalnode_mrid")
	@JoinColumn(name = "dctopologicalnode_projectid")
	@JoinColumn(name = "dctopologicalnode_synthesizedschemenumber")
	@JoinColumn(name = "dctopologicalnode_schemascenarionumber")
	private DCTopologicalNode DCTopologicalNode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dcnode_mrid")
	@JoinColumn(name = "dcnode_projectid")
	@JoinColumn(name = "dcnode_synthesizedschemenumber")
	@JoinColumn(name = "dcnode_schemascenarionumber")
	private DCNode DCNode;

	public DCTopologicalNode getDCTopologicalNode(){
		return this.DCTopologicalNode;
	}

	@AssociationSetter(fieldName = "DCBaseTerminal.DCTopologicalNode", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Topology.DCTopologicalNode", cardinality = "one")
	public void setDCTopologicalNode(DCTopologicalNode DCTopologicalNode){
		this.DCTopologicalNode = DCTopologicalNode;
	}

	public DCNode getDCNode(){
		return this.DCNode;
	}

	@AssociationSetter(fieldName = "DCBaseTerminal.DCNode", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.DCNode", cardinality = "one")
	public void setDCNode(DCNode DCNode){
		this.DCNode = DCNode;
	}

	public DCBaseTerminal(){

	}

}
