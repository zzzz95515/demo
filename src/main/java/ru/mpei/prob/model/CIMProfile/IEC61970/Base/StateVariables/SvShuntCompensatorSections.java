package ru.mpei.prob.model.CIMProfile.IEC61970.Base.StateVariables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.ShuntCompensator;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

/**
 * State variable for the number of sections in service for a shunt compensator.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "svshuntcompensatorsections")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SvShuntCompensatorSections extends StateVariable {
	/**
	 * The number of sections in service as a continous variable. To get integer 
	 * value scale with ShuntCompensator.bPerSection.
	 */
	@Column(name="sections", nullable = true)
	private Float sections;

	/**
	 * The state for the number of shunt compensator sections in service.
	 */
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "SvShuntCompensatorSections")
	private ShuntCompensator ShuntCompensator;

	public Float getSections(){
		return this.sections;
	}

	@FieldSetter(fieldName = "SvShuntCompensatorSections.sections", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setSections(Float sections){
		this.sections = sections;
	}

	@JsonIgnore
	public ShuntCompensator getShuntCompensator(){
		return this.ShuntCompensator;
	}

	@AssociationSetter(fieldName = "SvShuntCompensatorSections.ShuntCompensator", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.ShuntCompensator", cardinality = "one")
	public void setShuntCompensator(ShuntCompensator ShuntCompensator){
		this.ShuntCompensator = ShuntCompensator;
	}

	public SvShuntCompensatorSections(){

	}

}
