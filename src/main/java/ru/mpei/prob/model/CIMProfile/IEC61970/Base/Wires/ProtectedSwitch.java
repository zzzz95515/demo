package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.CurrentFlow;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.LN_61850.Common_LN;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.RecloseSequence;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A ProtectedSwitch is a switching device that can be operated by ProtectionEquipment.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "protectedswitch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProtectedSwitch extends Switch {
	/**
	 * The maximum fault current a breaking device can break safely under prescribed 
	 * conditions of use.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="breakingCapacity_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="breakingCapacity_unit")),
		@AttributeOverride(name="value", column=@Column(name="breakingCapacity_value")),
	})
	private CurrentFlow breakingCapacity;

	/**
	 * Protected switches operated by this ProtectionEquipment.
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "operatedbyprotectionequipment_mrid")
	@JoinColumn(name = "operatedbyprotectionequipment_projectid")
	@JoinColumn(name = "operatedbyprotectionequipment_synthesizedschemenumber")
	@JoinColumn(name = "operatedbyprotectionequipment_schemascenarionumber")
	private List<ProtectionEquipment> OperatedByProtectionEquipment;
	/**
	 * A breaker may have zero or more automatic reclosures after a trip occurs.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "ProtectedSwitch")
	private List<RecloseSequence> RecloseSequences;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ln_base_mrid")
	@JoinColumn(name = "ln_base_projectid")
	@JoinColumn(name = "ln_base_synthesizedschemenumber")
	@JoinColumn(name = "ln_base_schemascenarionumber")
	private Common_LN LN_Base;

	public CurrentFlow getBreakingCapacity(){
		return this.breakingCapacity;
	}

	@FieldSetter(fieldName = "ProtectedSwitch.breakingCapacity", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setBreakingCapacity(CurrentFlow breakingCapacity){
		this.breakingCapacity = breakingCapacity;
	}

	public List<ProtectionEquipment> getOperatedByProtectionEquipment(){
		return this.OperatedByProtectionEquipment;
	}

	@AssociationSetter(fieldName = "ProtectedSwitch.OperatedByProtectionEquipment", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setOperatedByProtectionEquipment(List<ProtectionEquipment> OperatedByProtectionEquipment){
		this.OperatedByProtectionEquipment = OperatedByProtectionEquipment;
	}

	@JsonIgnore
	public List<RecloseSequence> getRecloseSequences(){
		return this.RecloseSequences;
	}

	@AssociationSetter(fieldName = "ProtectedSwitch.RecloseSequences", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.RecloseSequence", cardinality = "many")
	public void setRecloseSequences(List<RecloseSequence> RecloseSequences){
		this.RecloseSequences = RecloseSequences;
	}

	public Common_LN getLN_Base(){
		return this.LN_Base;
	}

	@AssociationSetter(fieldName = "ProtectedSwitch.LN_Base", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.LN_61850.Common_LN", cardinality = "one")
	public void setLN_Base(Common_LN LN_Base){
		this.LN_Base = LN_Base;
	}

	public ProtectedSwitch(){

	}

}