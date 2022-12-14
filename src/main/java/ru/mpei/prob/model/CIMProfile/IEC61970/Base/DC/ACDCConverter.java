package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.Terminal;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * A unit with valves for three phases, together with unit control equipment, 
 * essential protective and switching devices, DC storage capacitors, phase 
 * reactors and auxiliaries, if any, used for conversion.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "acdcconverter")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ACDCConverter extends ConductingEquipment {
	/**
	 * Base apparent power of the converter pole.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="baseS_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="baseS_unit")),
		@AttributeOverride(name="value", column=@Column(name="baseS_value")),
	})
	private ApparentPower baseS;
	/**
	 * Converter DC current, also called Id. Converter state variable, result 
	 * from power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="idc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="idc_unit")),
		@AttributeOverride(name="value", column=@Column(name="idc_value")),
	})
	private CurrentFlow idc;
	/**
	 * Active power loss in pole at no power transfer. Converter configuration 
	 * data used in power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="idleLoss_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="idleLoss_unit")),
		@AttributeOverride(name="value", column=@Column(name="idleLoss_value")),
	})
	private ActivePower idleLoss;
	/**
	 * The maximum voltage on the DC side at which the converter should operate. 
	 * Converter configuration data used in power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="maxUdc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="maxUdc_unit")),
		@AttributeOverride(name="value", column=@Column(name="maxUdc_value")),
	})
	private Voltage maxUdc;
	/**
	 * Min allowed converter DC voltage. Converter configuration data used in 
	 * power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="minUdc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="minUdc_unit")),
		@AttributeOverride(name="value", column=@Column(name="minUdc_value")),
	})
	private Voltage minUdc;
	/**
	 * The nominal voltage on the DC side at which the converter is designed to 
	 * operate. Converter configuration data used in power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="nomUdc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="nomUdc_unit")),
		@AttributeOverride(name="value", column=@Column(name="nomUdc_value")),
	})
	private Voltage nomUdc;
	/**
	 * Number of valves in the converter. Used in loss calculations.
	 */
	@Column(name="numberOfValves", nullable = true)
	private Integer numberOfValves;
	/**
	 * Active power at the point of common coupling. Load sign convention is used, 
	 * i.e. positive sign means flow out from a node.Starting value for a steady 
	 * state solution in the case a simplified power flow model is used.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="p_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="p_unit")),
		@AttributeOverride(name="value", column=@Column(name="p_value")),
	})
	private ActivePower p;
	/**
	 * The active power loss at a DC Pole = idleLoss + switchingLoss*|Idc| + resitiveLoss*Idc^2For 
	 * lossless operation Pdc=PacFor rectifier operation with losses Pdc=Pac-lossPFor 
	 * inverter operation with losses Pdc=Pac+lossPConverter state variable used 
	 * in power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="poleLossP_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="poleLossP_unit")),
		@AttributeOverride(name="value", column=@Column(name="poleLossP_value")),
	})
	private ActivePower poleLossP;
	/**
	 * Reactive power at the point of common coupling. Load sign convention is 
	 * used, i.e. positive sign means flow out from a node.Starting value for 
	 * a steady state solution in the case a simplified power flow model is used.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="q_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="q_unit")),
		@AttributeOverride(name="value", column=@Column(name="q_value")),
	})
	private ReactivePower q;
	/**
	 * Rated converter DC voltage, also called UdN. Converter configuration data 
	 * used in power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="ratedUdc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="ratedUdc_unit")),
		@AttributeOverride(name="value", column=@Column(name="ratedUdc_value")),
	})
	private Voltage ratedUdc;
	/**
	 * Converter configuration data used in power flow. Refer to poleLossP.
	 */
	@Column(name="resistiveLoss", nullable = true)
	private Float resistiveLoss;
	/**
	 * Switching losses, relative to the base apparent power 'baseS'.Refer to 
	 * poleLossP.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="switchingLoss_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="switchingLoss_unit")),
		@AttributeOverride(name="value", column=@Column(name="switchingLoss_value")),
	})
	private PU switchingLoss;
	/**
	 * Real power injection target in AC grid, at point of common coupling.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="targetPpcc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="targetPpcc_unit")),
		@AttributeOverride(name="value", column=@Column(name="targetPpcc_value")),
	})
	private ActivePower targetPpcc;
	/**
	 * Target value for DC voltage magnitude.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="targetUdc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="targetUdc_unit")),
		@AttributeOverride(name="value", column=@Column(name="targetUdc_value")),
	})
	private Voltage targetUdc;
	/**
	 * Converter voltage, the voltage at the AC side of the bridge. Converter 
	 * state variable, result from power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="uc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="uc_unit")),
		@AttributeOverride(name="value", column=@Column(name="uc_value")),
	})
	private Voltage uc;
	/**
	 * Converter voltage at the DC side, also called Ud. Converter state variable, 
	 * result from power flow.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="udc_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="udc_unit")),
		@AttributeOverride(name="value", column=@Column(name="udc_value")),
	})
	private Voltage udc;
	/**
	 * Valve threshold voltage. Forward voltage drop when the valve is conducting. 
	 * Used in loss calculations, i.e. the switchLoss depend on numberOfValves 
	 * * valveU0.
	 */
	@AttributeOverrides({
		@AttributeOverride(name="multiplier", column=@Column(name="valveU0_multiplier")),
		@AttributeOverride(name="unit", column=@Column(name="valveU0_unit")),
		@AttributeOverride(name="value", column=@Column(name="valveU0_value")),
	})
	private Voltage valveU0;

	/**
	 * All converters' DC sides linked to this point of common coupling terminal.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pccterminal_mrid")
	@JoinColumn(name = "pccterminal_projectid")
	@JoinColumn(name = "pccterminal_synthesizedschemenumber")
	@JoinColumn(name = "pccterminal_schemascenarionumber")
	private Terminal PccTerminal;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "DCConductingEquipment")
	private List<ACDCConverterDCTerminal> DCTerminals;

	public ApparentPower getBaseS(){
		return this.baseS;
	}

	@FieldSetter(fieldName = "ACDCConverter.baseS", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setBaseS(ApparentPower baseS){
		this.baseS = baseS;
	}

	public CurrentFlow getIdc(){
		return this.idc;
	}

	@FieldSetter(fieldName = "ACDCConverter.idc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setIdc(CurrentFlow idc){
		this.idc = idc;
	}

	public ActivePower getIdleLoss(){
		return this.idleLoss;
	}

	@FieldSetter(fieldName = "ACDCConverter.idleLoss", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setIdleLoss(ActivePower idleLoss){
		this.idleLoss = idleLoss;
	}

	public Voltage getMaxUdc(){
		return this.maxUdc;
	}

	@FieldSetter(fieldName = "ACDCConverter.maxUdc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setMaxUdc(Voltage maxUdc){
		this.maxUdc = maxUdc;
	}

	public Voltage getMinUdc(){
		return this.minUdc;
	}

	@FieldSetter(fieldName = "ACDCConverter.minUdc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setMinUdc(Voltage minUdc){
		this.minUdc = minUdc;
	}

	public Voltage getNomUdc(){
		return this.nomUdc;
	}

	@FieldSetter(fieldName = "ACDCConverter.nomUdc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setNomUdc(Voltage nomUdc){
		this.nomUdc = nomUdc;
	}

	public Integer getNumberOfValves(){
		return this.numberOfValves;
	}

	@FieldSetter(fieldName = "ACDCConverter.numberOfValves", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setNumberOfValves(Integer numberOfValves){
		this.numberOfValves = numberOfValves;
	}

	public ActivePower getP(){
		return this.p;
	}

	@FieldSetter(fieldName = "ACDCConverter.p", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setP(ActivePower p){
		this.p = p;
	}

	public ActivePower getPoleLossP(){
		return this.poleLossP;
	}

	@FieldSetter(fieldName = "ACDCConverter.poleLossP", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setPoleLossP(ActivePower poleLossP){
		this.poleLossP = poleLossP;
	}

	public ReactivePower getQ(){
		return this.q;
	}

	@FieldSetter(fieldName = "ACDCConverter.q", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setQ(ReactivePower q){
		this.q = q;
	}

	public Voltage getRatedUdc(){
		return this.ratedUdc;
	}

	@FieldSetter(fieldName = "ACDCConverter.ratedUdc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setRatedUdc(Voltage ratedUdc){
		this.ratedUdc = ratedUdc;
	}

	public Float getResistiveLoss(){
		return this.resistiveLoss;
	}

	@FieldSetter(fieldName = "ACDCConverter.resistiveLoss", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
	public void setResistiveLoss(Float resistiveLoss){
		this.resistiveLoss = resistiveLoss;
	}

	public PU getSwitchingLoss(){
		return this.switchingLoss;
	}

	@FieldSetter(fieldName = "ACDCConverter.switchingLoss", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setSwitchingLoss(PU switchingLoss){
		this.switchingLoss = switchingLoss;
	}

	public ActivePower getTargetPpcc(){
		return this.targetPpcc;
	}

	@FieldSetter(fieldName = "ACDCConverter.targetPpcc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setTargetPpcc(ActivePower targetPpcc){
		this.targetPpcc = targetPpcc;
	}

	public Voltage getTargetUdc(){
		return this.targetUdc;
	}

	@FieldSetter(fieldName = "ACDCConverter.targetUdc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setTargetUdc(Voltage targetUdc){
		this.targetUdc = targetUdc;
	}

	public Voltage getUc(){
		return this.uc;
	}

	@FieldSetter(fieldName = "ACDCConverter.uc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setUc(Voltage uc){
		this.uc = uc;
	}

	public Voltage getUdc(){
		return this.udc;
	}

	@FieldSetter(fieldName = "ACDCConverter.udc", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setUdc(Voltage udc){
		this.udc = udc;
	}

	public Voltage getValveU0(){
		return this.valveU0;
	}

	@FieldSetter(fieldName = "ACDCConverter.valveU0", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "none")
	public void setValveU0(Voltage valveU0){
		this.valveU0 = valveU0;
	}

	public Terminal getPccTerminal(){
		return this.PccTerminal;
	}

	@AssociationSetter(fieldName = "ACDCConverter.PccTerminal", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.Terminal", cardinality = "one")
	public void setPccTerminal(Terminal PccTerminal){
		this.PccTerminal = PccTerminal;
	}

	@JsonIgnore
	public List<ACDCConverterDCTerminal> getDCTerminals(){
		return this.DCTerminals;
	}

	@AssociationSetter(fieldName = "ACDCConverter.DCTerminals", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.ACDCConverterDCTerminal", cardinality = "many")
	public void setDCTerminals(List<ACDCConverterDCTerminal> DCTerminals){
		this.DCTerminals = DCTerminals;
	}

	public ACDCConverter(){

	}

}
