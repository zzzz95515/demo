package ru.mpei.prob.model.CIMProfile.IEC61968.Common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * Coordinate reference system.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "coordinatesystem")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoordinateSystem extends IdentifiedObject {
	/**
	 * A Uniform Resource Name (URN) for the coordinate reference system (crs) 
	 * used to define 'Location.PositionPoints'.An example would be the European 
	 * Petroleum Survey Group (EPSG) code for a coordinate reference system, defined 
	 * in URN under the Open Geospatial Consortium (OGC) namespace as: urn:ogc:def:uom:EPSG::XXXX, 
	 * where XXXX is an EPSG code (a full list of codes can be found at the EPSG 
	 * Registry web site http://www.epsg-registry.org/). To define the coordinate 
	 * system as being WGS84 (latitude, longitude) using an EPSG OGC, this attribute 
	 * would be urn:ogc:def:uom:EPSG::4236.A profile should limit this code to 
	 * a set of allowed URNs agreed to by all sending and receiving parties.
	 */
	@Column(name="crsUrn", nullable = true)
	private String crsUrn;

	/**
	 * Coordinate system used to describe position points of this location.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "CoordinateSystem")
	private List<Location> Locations;

	public String getCrsUrn(){
		return this.crsUrn;
	}

	@FieldSetter(fieldName = "CoordinateSystem.crsUrn", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setCrsUrn(String crsUrn){
		this.crsUrn = crsUrn;
	}

	@JsonIgnore
	public List<Location> getLocations(){
		return this.Locations;
	}

	@AssociationSetter(fieldName = "CoordinateSystem.Locations", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.Location", cardinality = "many")
	public void setLocations(List<Location> Locations){
		this.Locations = Locations;
	}

	public CoordinateSystem(){

	}

}
