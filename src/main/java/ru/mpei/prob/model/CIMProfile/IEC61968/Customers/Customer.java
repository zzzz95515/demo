package ru.mpei.prob.model.CIMProfile.IEC61968.Customers;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61968.Common.OrganisationRole;
import ru.mpei.prob.model.CIMProfile.IEC61968.Common.Priority;
import ru.mpei.prob.model.CIMProfile.IEC61968.Common.Status;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * Organisation receiving services from service supplier.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends OrganisationRole {
	/**
	 * Kind of customer.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "kind")
	private CustomerKind kind;
	/**
	 * Locale designating language to use in communications with this customer.
	 */
	@Column(name="locale", nullable = true)
	private String locale;
	/**
	 * Priority of the customer.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "priority_mrid")
	@JoinColumn(name = "priority_projectid")
	@JoinColumn(name = "priority_synthesizedschemenumber")
	@JoinColumn(name = "priority_schemascenarionumber")
	private Priority priority;
	/**
	 * (if applicable) Public utilities commission (PUC) identification number.
	 */
	@Column(name="pucNumber", nullable = true)
	private String pucNumber;
	/**
	 * True if customer organisation has special service needs such as life support, 
	 * hospitals, etc.
	 */
	@Column(name="specialNeed", nullable = true)
	private String specialNeed;
	/**
	 * Status of this customer.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_mrid")
	@JoinColumn(name = "status_projectid")
	@JoinColumn(name = "status_synthesizedschemenumber")
	@JoinColumn(name = "status_schemascenarionumber")
	private Status status;


	public CustomerKind getKind(){
		return this.kind;
	}

	@FieldSetter(fieldName = "Customer.kind", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setKind(CustomerKind kind){
		this.kind = kind;
	}

	public String getLocale(){
		return this.locale;
	}

	@FieldSetter(fieldName = "Customer.locale", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setLocale(String locale){
		this.locale = locale;
	}

	public Priority getPriority(){
		return this.priority;
	}

	@CompoundFieldSetter(fieldName = "Customer.priority", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.Priority")
	public void setPriority(Priority priority){
		this.priority = priority;
	}

	public String getPucNumber(){
		return this.pucNumber;
	}

	@FieldSetter(fieldName = "Customer.pucNumber", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setPucNumber(String pucNumber){
		this.pucNumber = pucNumber;
	}

	public String getSpecialNeed(){
		return this.specialNeed;
	}

	@FieldSetter(fieldName = "Customer.specialNeed", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setSpecialNeed(String specialNeed){
		this.specialNeed = specialNeed;
	}

	public Status getStatus(){
		return this.status;
	}

	@CompoundFieldSetter(fieldName = "Customer.status", fieldType = "ru.mpei.ltdb.model.CIMProfile.IEC61968.Common.Status")
	public void setStatus(Status status){
		this.status = status;
	}

	public Customer(){

	}

}