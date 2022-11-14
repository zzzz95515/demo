package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CurrentFlow;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * A conductor, or group of conductors, with negligible impedance, that serve 
 * to connect other conducting equipment within a single substation. Voltage 
 * measurements are typically obtained from VoltageTransformers that are connected 
 * to busbar sections. A bus bar section may have many physical terminals 
 * but for analysis is modelled with exactly one logical terminal.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "busbarsection")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusbarSection extends Connector {
	/**
	 * Maximum allowable peak short-circuit current of busbar (Ipmax in the IEC 
	 * 60909-0). Mechanical limit of the busbar in the substation itself. Used 
	 * for short circuit data exchange according to IEC 60909
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="ipMax_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="ipMax_unit")),
		@AttributeOverride(name="value", column=@Column(name="ipMax_value")),
	})
	private CurrentFlow ipMax;


	public CurrentFlow getIpMax(){
		return this.ipMax;
	}

	@FieldSetter(fieldName = "BusbarSection.ipMax", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setIpMax(CurrentFlow ipMax){
		this.ipMax = ipMax;
	}

	public BusbarSection(){

	}

}
