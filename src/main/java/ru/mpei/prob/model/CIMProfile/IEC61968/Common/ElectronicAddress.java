package ru.mpei.prob.model.CIMProfile.IEC61968.Common;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Electronic address information.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "electronicaddress")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class ElectronicAddress extends IdentifiedObject{
	/**
	 * Primary email address.
	 */
	@Column(name="email1", nullable = true)
	private String email1;
	/**
	 * Alternate email address.
	 */
	@Column(name="email2", nullable = true)
	private String email2;
	/**
	 * Address on local area network.
	 */
	@Column(name="lan", nullable = true)
	private String lan;
	/**
	 * MAC (Media Access Control) address.
	 */
	@Column(name="mac", nullable = true)
	private String mac;
	/**
	 * Password needed to log in.
	 */
	@Column(name="password", nullable = true)
	private String password;
	/**
	 * Radio address.
	 */
	@Column(name="radio", nullable = true)
	private String radio;
	/**
	 * User ID needed to log in, which can be for an individual person, an organisation, 
	 * a location, etc.
	 */
	@Column(name="userID", nullable = true)
	private String userID;
	/**
	 * World wide web address.
	 */
	@Column(name="web", nullable = true)
	private String web;


	public String getEmail1(){
		return this.email1;
	}

	@FieldSetter(fieldName = "ElectronicAddress.email1", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setEmail1(String email1){
		this.email1 = email1;
	}

	public String getEmail2(){
		return this.email2;
	}

	@FieldSetter(fieldName = "ElectronicAddress.email2", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setEmail2(String email2){
		this.email2 = email2;
	}

	public String getLan(){
		return this.lan;
	}

	@FieldSetter(fieldName = "ElectronicAddress.lan", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setLan(String lan){
		this.lan = lan;
	}

	public String getMac(){
		return this.mac;
	}

	@FieldSetter(fieldName = "ElectronicAddress.mac", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setMac(String mac){
		this.mac = mac;
	}

	public String getPassword(){
		return this.password;
	}

	@FieldSetter(fieldName = "ElectronicAddress.password", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setPassword(String password){
		this.password = password;
	}

	public String getRadio(){
		return this.radio;
	}

	@FieldSetter(fieldName = "ElectronicAddress.radio", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setRadio(String radio){
		this.radio = radio;
	}

	public String getUserID(){
		return this.userID;
	}

	@FieldSetter(fieldName = "ElectronicAddress.userID", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setUserID(String userID){
		this.userID = userID;
	}

	public String getWeb(){
		return this.web;
	}

	@FieldSetter(fieldName = "ElectronicAddress.web", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setWeb(String web){
		this.web = web;
	}

	public ElectronicAddress(){

	}

}