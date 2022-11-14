package ru.mpei.prob.model.CIMProfile.IEC61968.Common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61968.Assets.Asset;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.PowerSystemResource;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * The place, scene, or point of something where someone or something has 
 * been, is, and/or will be at a given moment in time. It can be defined with 
 * one or more postition points (coordinates) in a given coordinate system.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "location")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location extends IdentifiedObject {
	/**
	 * (if applicable) Direction that allows field crews to quickly find a given 
	 * asset. For a given location, such as a street address, this is the relative 
	 * direction in which to find the asset. For example, a streetlight may be 
	 * located at the 'NW' (northwest) corner of the customer's site, or a usage 
	 * point may be located on the second floor of an apartment building.
	 */
	@Column(name="direction", nullable = true)
	private String direction;
	/**
	 * Electronic address.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "electronicaddress_mrid")
	@JoinColumn(name = "electronicaddress_projectid")
	@JoinColumn(name = "electronicaddress_synthesizedschemenumber")
	@JoinColumn(name = "electronicaddress_schemascenarionumber")
	private ElectronicAddress electronicAddress;
	/**
	 * (if applicable) Reference to geographical information source, often external 
	 * to the utility.
	 */
	@Column(name="geoInfoReference", nullable = true)
	private String geoInfoReference;
	/**
	 * Main address of the location.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mainaddress_mrid")
	@JoinColumn(name = "mainaddress_projectid")
	@JoinColumn(name = "mainaddress_synthesizedschemenumber")
	@JoinColumn(name = "mainaddress_schemascenarionumber")
	private StreetAddress mainAddress;
	/**
	 * Phone number.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone1_mrid")
	@JoinColumn(name = "phone1_projectid")
	@JoinColumn(name = "phone1_synthesizedschemenumber")
	@JoinColumn(name = "phone1_schemascenarionumber")
	private TelephoneNumber phone1;
	/**
	 * Additional phone number.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone2_mrid")
	@JoinColumn(name = "phone2_projectid")
	@JoinColumn(name = "phone2_synthesizedschemenumber")
	@JoinColumn(name = "phone2_schemascenarionumber")
	private TelephoneNumber phone2;
	/**
	 * Secondary address of the location. For example, PO Box address may have 
	 * different ZIP code than that in the 'mainAddress'.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "secondaryaddress_mrid")
	@JoinColumn(name = "secondaryaddress_projectid")
	@JoinColumn(name = "secondaryaddress_synthesizedschemenumber")
	@JoinColumn(name = "secondaryaddress_schemascenarionumber")
	private StreetAddress secondaryAddress;
	/**
	 * Status of this location.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_mrid")
	@JoinColumn(name = "status_projectid")
	@JoinColumn(name = "status_synthesizedschemenumber")
	@JoinColumn(name = "status_schemascenarionumber")
	private Status status;
	/**
	 * Classification by utility's corporate standards and practices, relative 
	 * to the location itself (e.g., geographical, functional accounting, etc., 
	 * not a given property that happens to exist at that location).
	 */
	@Column(name="type", nullable = true)
	private String type;

	/**
	 * Location of this asset.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Location")
	private List<Asset> Assets;
	/**
	 * All locations described with position points in this coordinate system.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coordinatesystem_mrid")
	@JoinColumn(name = "coordinatesystem_projectid")
	@JoinColumn(name = "coordinatesystem_synthesizedschemenumber")
	@JoinColumn(name = "coordinatesystem_schemascenarionumber")
	private CoordinateSystem CoordinateSystem;
	/**
	 * Location of this power system resource.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Location")
	private List<PowerSystemResource> PowerSystemResources;

	public String getDirection(){
		return this.direction;
	}

	@FieldSetter(fieldName = "Location.direction", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setDirection(String direction){
		this.direction = direction;
	}

	public ElectronicAddress getElectronicAddress(){
		return this.electronicAddress;
	}

	@CompoundFieldSetter(fieldName = "Location.electronicAddress", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.ElectronicAddress")
	public void setElectronicAddress(ElectronicAddress electronicAddress){
		this.electronicAddress = electronicAddress;
	}

	public String getGeoInfoReference(){
		return this.geoInfoReference;
	}

	@FieldSetter(fieldName = "Location.geoInfoReference", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setGeoInfoReference(String geoInfoReference){
		this.geoInfoReference = geoInfoReference;
	}

	public StreetAddress getMainAddress(){
		return this.mainAddress;
	}

	@CompoundFieldSetter(fieldName = "Location.mainAddress", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.StreetAddress")
	public void setMainAddress(StreetAddress mainAddress){
		this.mainAddress = mainAddress;
	}

	public TelephoneNumber getPhone1(){
		return this.phone1;
	}

	@CompoundFieldSetter(fieldName = "Location.phone1", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.TelephoneNumber")
	public void setPhone1(TelephoneNumber phone1){
		this.phone1 = phone1;
	}

	public TelephoneNumber getPhone2(){
		return this.phone2;
	}

	@CompoundFieldSetter(fieldName = "Location.phone2", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.TelephoneNumber")
	public void setPhone2(TelephoneNumber phone2){
		this.phone2 = phone2;
	}

	public StreetAddress getSecondaryAddress(){
		return this.secondaryAddress;
	}

	@CompoundFieldSetter(fieldName = "Location.secondaryAddress", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.StreetAddress")
	public void setSecondaryAddress(StreetAddress secondaryAddress){
		this.secondaryAddress = secondaryAddress;
	}

	public Status getStatus(){
		return this.status;
	}

	@CompoundFieldSetter(fieldName = "Location.status", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.Status")
	public void setStatus(Status status){
		this.status = status;
	}

	public String getType(){
		return this.type;
	}

	@FieldSetter(fieldName = "Location.type", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setType(String type){
		this.type = type;
	}

	@JsonIgnore
	public List<Asset> getAssets(){
		return this.Assets;
	}

	@AssociationSetter(fieldName = "Location.Assets", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Assets.Asset", cardinality = "many")
	public void setAssets(List<Asset> Assets){
		this.Assets = Assets;
	}

	public CoordinateSystem getCoordinateSystem(){
		return this.CoordinateSystem;
	}

	@AssociationSetter(fieldName = "Location.CoordinateSystem", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.CoordinateSystem", cardinality = "one")
	public void setCoordinateSystem(CoordinateSystem CoordinateSystem){
		this.CoordinateSystem = CoordinateSystem;
	}

	@JsonIgnore
	public List<PowerSystemResource> getPowerSystemResources(){
		return this.PowerSystemResources;
	}

	@AssociationSetter(fieldName = "Location.PowerSystemResources", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.PowerSystemResource", cardinality = "many")
	public void setPowerSystemResources(List<PowerSystemResource> PowerSystemResources){
		this.PowerSystemResources = PowerSystemResources;
	}

	public Location(){

	}

}