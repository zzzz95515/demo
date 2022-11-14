package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.BusNameMarker;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.TopologicalNode;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A reporting group is used for various ad-hoc groupings used for reporting.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "reportinggroup")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportingGroup extends IdentifiedObject {

	/**
	 * The reporting group to which the topological node belongs.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "ReportingGroup")
	private List<TopologicalNode> TopologicalNode;
	/**
	 * The reporting group to which this bus name marker belongs.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "ReportingGroup")
	private List<BusNameMarker> BusNameMarker;

	@JsonIgnore
	public List<TopologicalNode> getTopologicalNode(){
		return this.TopologicalNode;
	}

	@AssociationSetter(fieldName = "ReportingGroup.TopologicalNode", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Topology.TopologicalNode", cardinality = "many")
	public void setTopologicalNode(List<TopologicalNode> TopologicalNode){
		this.TopologicalNode = TopologicalNode;
	}

	@JsonIgnore
	public List<BusNameMarker> getBusNameMarker(){
		return this.BusNameMarker;
	}

	@AssociationSetter(fieldName = "ReportingGroup.BusNameMarker", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Topology.BusNameMarker", cardinality = "many")
	public void setBusNameMarker(List<BusNameMarker> BusNameMarker){
		this.BusNameMarker = BusNameMarker;
	}

	public ReportingGroup(){

	}

}
