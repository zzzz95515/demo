package ru.mpei.prob.model.CIMProfile.IEC61968.Common;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Town details, in the context of address.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "towndetail")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class TownDetail extends IdentifiedObject{
	/**
	 * Town code.
	 */
	@Column(name="code", nullable = true)
	private String code;
	/**
	 * Name of the country.
	 */
	@Column(name="country", nullable = true)
	private String country;
	/**
	 * Town name.
	 */
	@Column(name="name", nullable = true)
	private String name;
	/**
	 * Town section. For example, it is common for there to be 36 sections per 
	 * township.
	 */
	@Column(name="section", nullable = true)
	private String section;
	/**
	 * Name of the state or province.
	 */
	@Column(name="stateOrProvince", nullable = true)
	private String stateOrProvince;


	public String getCode(){
		return this.code;
	}

	@FieldSetter(fieldName = "TownDetail.code", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setCode(String code){
		this.code = code;
	}

	public String getCountry(){
		return this.country;
	}

	@FieldSetter(fieldName = "TownDetail.country", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setCountry(String country){
		this.country = country;
	}

	public String getName(){
		return this.name;
	}

	@FieldSetter(fieldName = "TownDetail.name", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setName(String name){
		this.name = name;
	}

	public String getSection(){
		return this.section;
	}

	@FieldSetter(fieldName = "TownDetail.section", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setSection(String section){
		this.section = section;
	}

	public String getStateOrProvince(){
		return this.stateOrProvince;
	}

	@FieldSetter(fieldName = "TownDetail.stateOrProvince", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setStateOrProvince(String stateOrProvince){
		this.stateOrProvince = stateOrProvince;
	}

	public TownDetail(){

	}

}
