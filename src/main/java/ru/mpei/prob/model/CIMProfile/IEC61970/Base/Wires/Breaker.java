package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.Seconds;
import ru.mpei.prob.model.CIMProfile.NTI.BreakerType;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * A mechanical switching device capable of making, carrying, and breaking 
 * currents under normal circuit conditions and also making, carrying for 
 * a specified time, and breaking currents under specified abnormal circuit 
 * conditions e.g.  those of short circuit.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "breaker")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Breaker extends ProtectedSwitch {
	/**
	 * The transition time from open to close.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="inTransitTime_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="inTransitTime_unit")),
		@AttributeOverride(name="value", column=@Column(name="inTransitTime_value")),
	})
	private Seconds inTransitTime;
	/**
	 * Наружняя или внутреняя установка
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private BreakerType type;


	public Seconds getInTransitTime(){
		return this.inTransitTime;
	}

	@FieldSetter(fieldName = "Breaker.inTransitTime", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setInTransitTime(Seconds inTransitTime){
		this.inTransitTime = inTransitTime;
	}

	public BreakerType getType(){
		return this.type;
	}

	@FieldSetter(fieldName = "Breaker.type", fieldTypeStereotype = "Enumeration", fieldStereotype = "nti")
	public void setType(BreakerType type){
		this.type = type;
	}

	public Breaker(){

	}

}
