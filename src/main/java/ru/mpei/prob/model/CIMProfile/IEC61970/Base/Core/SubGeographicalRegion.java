package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC.DCLine;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.Line;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A subset of a geographical region of a power system network model.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "subgeographicalregion")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubGeographicalRegion extends IdentifiedObject {

	/**
	 * All sub-geograhpical regions within this geographical region.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_mrid")
	@JoinColumn(name = "region_projectid")
	@JoinColumn(name = "region_synthesizedschemenumber")
	@JoinColumn(name = "region_schemascenarionumber")
	private GeographicalRegion Region;
	/**
	 * The sub-geographical region of the line.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Region")
	private List<Line> Lines;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Region")
	private List<Substation> Substations;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Region")
	private List<DCLine> DCLines;

	public GeographicalRegion getRegion(){
		return this.Region;
	}

	@AssociationSetter(fieldName = "SubGeographicalRegion.Region", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.GeographicalRegion", cardinality = "one")
	public void setRegion(GeographicalRegion Region){
		this.Region = Region;
	}

	@JsonIgnore
	public List<Line> getLines(){
		return this.Lines;
	}

	@AssociationSetter(fieldName = "SubGeographicalRegion.Lines", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.Line", cardinality = "many")
	public void setLines(List<Line> Lines){
		this.Lines = Lines;
	}

	@JsonIgnore
	public List<Substation> getSubstations(){
		return this.Substations;
	}

	@AssociationSetter(fieldName = "SubGeographicalRegion.Substations", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.Substation", cardinality = "many")
	public void setSubstations(List<Substation> Substations){
		this.Substations = Substations;
	}

	@JsonIgnore
	public List<DCLine> getDCLines(){
		return this.DCLines;
	}

	@AssociationSetter(fieldName = "SubGeographicalRegion.DCLines", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.DCLine", cardinality = "many")
	public void setDCLines(List<DCLine> DCLines){
		this.DCLines = DCLines;
	}

	public SubGeographicalRegion(){

	}

}
