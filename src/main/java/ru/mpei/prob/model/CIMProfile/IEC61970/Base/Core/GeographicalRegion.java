package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A geographical region of a power system network model.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "geographicalregion")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicalRegion extends IdentifiedObject {

	/**
	 * The geographical region to which this sub-geographical region is within.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Region")
	private List<SubGeographicalRegion> Regions;

	@JsonIgnore
	public List<SubGeographicalRegion> getRegions(){
		return this.Regions;
	}

	@AssociationSetter(fieldName = "GeographicalRegion.Regions", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.SubGeographicalRegion", cardinality = "many")
	public void setRegions(List<SubGeographicalRegion> Regions){
		this.Regions = Regions;
	}

	public GeographicalRegion(){

	}

}