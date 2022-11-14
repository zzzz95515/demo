package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * Describes a curve for how the voltage magnitude and impedance varies with 
 * the tap step. 
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "ratiotapchangertable")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatioTapChangerTable extends IdentifiedObject {

	/**
	 * The tap ratio table for this ratio  tap changer.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "RatioTapChangerTable")
	private List<RatioTapChanger> RatioTapChanger;
	/**
	 * Table of this point.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "RatioTapChangerTable")
	private List<RatioTapChangerTablePoint> RatioTapChangerTablePoint;

	@JsonIgnore
	public List<RatioTapChanger> getRatioTapChanger(){
		return this.RatioTapChanger;
	}

	@AssociationSetter(fieldName = "RatioTapChangerTable.RatioTapChanger", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.RatioTapChanger", cardinality = "many")
	public void setRatioTapChanger(List<RatioTapChanger> RatioTapChanger){
		this.RatioTapChanger = RatioTapChanger;
	}

	@JsonIgnore
	public List<RatioTapChangerTablePoint> getRatioTapChangerTablePoint(){
		return this.RatioTapChangerTablePoint;
	}

	@AssociationSetter(fieldName = "RatioTapChangerTable.RatioTapChangerTablePoint", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.RatioTapChangerTablePoint", cardinality = "many")
	public void setRatioTapChangerTablePoint(List<RatioTapChangerTablePoint> RatioTapChangerTablePoint){
		this.RatioTapChangerTablePoint = RatioTapChangerTablePoint;
	}

	public RatioTapChangerTable(){

	}

}
