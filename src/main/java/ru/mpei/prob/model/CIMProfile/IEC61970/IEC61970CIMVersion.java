package ru.mpei.prob.model.CIMProfile.IEC61970;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * This is the IEC 61970 CIM version number assigned to this UML model.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "iec61970cimversion")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class IEC61970CIMVersion extends IdentifiedObject{
	/**
	 * Form is YYYY-MM-DD for example for January 5, 2009 it is 2009-01-05.
	 */
	@Column(name="date", nullable = true)
	private Date date = new Date(2014,03,05);
	/**
	 * Form is IEC61970CIMXXvYY where XX is the major CIM package version and 
	 * the YY is the minor version. For example IEC61970CIM13v18.
	 */
	@Column(name="version", nullable = true)
	private String version = "IEC61970CIM16v27";


	public Date getDate(){
		return this.date;
	}

	public String getVersion(){
		return this.version;
	}

	public IEC61970CIMVersion(){

	}

}
