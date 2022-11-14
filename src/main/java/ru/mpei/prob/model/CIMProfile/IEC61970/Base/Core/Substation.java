package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC.DCConverterUnit;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.EnergyConsumer;
import ru.mpei.prob.model.CIMProfile.NTI.SubstationType;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "substation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Substation extends EquipmentContainer {
	/**
	 * Тип ПС: ТП (transformerSubstation), РП (distributionSubstation) , РТП (transformerAndDistributionSubstation)
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private SubstationType type;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Substation")
	private List<Bay> Bays;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_mrid")
	@JoinColumn(name = "region_projectid")
	@JoinColumn(name = "region_synthesizedschemenumber")
	@JoinColumn(name = "region_schemascenarionumber")
	private SubGeographicalRegion Region;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Substation")
	private List<DCConverterUnit> DCConverterUnit;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Substation")
	private List<VoltageLevel> VoltageLevels;
	/**
	 * Потребители, которые подключены к подстанции
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "SubstationFeedingFrom")
	private List<EnergyConsumer> ConsumersFeedingTo;

	public SubstationType getType(){
		return this.type;
	}

	@FieldSetter(fieldName = "Substation.type", fieldTypeStereotype = "Enumeration", fieldStereotype = "nti")
	public void setType(SubstationType type){
		this.type = type;
	}

	@JsonIgnore
	public List<Bay> getBays(){
		return this.Bays;
	}

	@AssociationSetter(fieldName = "Substation.Bays", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.Bay", cardinality = "many")
	public void setBays(List<Bay> Bays){
		this.Bays = Bays;
	}

	public SubGeographicalRegion getRegion(){
		return this.Region;
	}

	@AssociationSetter(fieldName = "Substation.Region", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.SubGeographicalRegion", cardinality = "one")
	public void setRegion(SubGeographicalRegion Region){
		this.Region = Region;
	}

	@JsonIgnore
	public List<DCConverterUnit> getDCConverterUnit(){
		return this.DCConverterUnit;
	}

	@AssociationSetter(fieldName = "Substation.DCConverterUnit", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.DCConverterUnit", cardinality = "many")
	public void setDCConverterUnit(List<DCConverterUnit> DCConverterUnit){
		this.DCConverterUnit = DCConverterUnit;
	}

	@JsonIgnore
	public List<VoltageLevel> getVoltageLevels(){
		return this.VoltageLevels;
	}

	@AssociationSetter(fieldName = "Substation.VoltageLevels", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.VoltageLevel", cardinality = "many")
	public void setVoltageLevels(List<VoltageLevel> VoltageLevels){
		this.VoltageLevels = VoltageLevels;
	}

	@JsonIgnore
	public List<EnergyConsumer> getConsumersFeedingTo(){
		return this.ConsumersFeedingTo;
	}

	@AssociationSetter(fieldName = "Substation.ConsumersFeedingTo", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.EnergyConsumer", cardinality = "many")
	public void setConsumersFeedingTo(List<EnergyConsumer> ConsumersFeedingTo){
		this.ConsumersFeedingTo = ConsumersFeedingTo;
	}

	public Substation(){

	}

}
