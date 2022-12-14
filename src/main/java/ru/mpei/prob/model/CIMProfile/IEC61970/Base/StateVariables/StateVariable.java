package ru.mpei.prob.model.CIMProfile.IEC61970.Base.StateVariables;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * An abstract class for state variables.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "statevariable")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateVariable extends IdentifiedObject {
	/**
	 * Рассчитано ли значение или является начальным (из исходных данных)
	 */
	@Column(name="isCalculated", nullable = true)
	private Boolean isCalculated;


	public Boolean getIsCalculated(){
		return this.isCalculated;
	}

	@FieldSetter(fieldName = "StateVariable.isCalculated", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setIsCalculated(Boolean isCalculated){
		this.isCalculated = isCalculated;
	}

	public StateVariable(){

	}

}
