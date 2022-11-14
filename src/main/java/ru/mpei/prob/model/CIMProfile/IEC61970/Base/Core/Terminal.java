package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.AuxiliaryEquipment.AuxiliaryEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC.ACDCConverter;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults.EquipmentFault;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.StateVariables.SvPowerFlow;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.TopologicalNode;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.TransformerEnd;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

/**
 * An AC electrical connection point to a piece of conducting equipment. Terminals 
 * are connected at physical connection points called connectivity nodes.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "terminal")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Terminal extends ACDCTerminal {
	/**
	 * Принадлежит ли терминал эквиваленту
	 */
	@Column(name="isBelongingToEquivalent", nullable = true)
	private Boolean isBelongingToEquivalent;
	/**
	 * Represents the normal network phasing condition.If the attribute is missing 
	 * three phases (ABC or ABCN) shall be assumed.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "phases")
	private PhaseCode phases;

	/**
	 * The Terminal at the equipment where the AuxiliaryEquipment is attached.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Terminal")
	private List<AuxiliaryEquipment> AuxiliaryEquipment;
	/**
	 * Conducting equipment have terminals that may be connected to other conducting 
	 * equipment terminals via connectivity nodes or topological nodes.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conductingequipment_mrid")
	@JoinColumn(name = "conductingequipment_projectid")
	@JoinColumn(name = "conductingequipment_synthesizedschemenumber")
	@JoinColumn(name = "conductingequipment_schemascenarionumber")
	private ConductingEquipment ConductingEquipment;
	/**
	 * Terminals interconnected with zero impedance at a this connectivity node. 
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "connectivitynode_mrid")
	@JoinColumn(name = "connectivitynode_projectid")
	@JoinColumn(name = "connectivitynode_synthesizedschemenumber")
	@JoinColumn(name = "connectivitynode_schemascenarionumber")
	private ConnectivityNode ConnectivityNode;
	/**
	 * The terminals associated with the topological node.   This can be used 
	 * as an alternative to the connectivity node path to terminal, thus making 
	 * it unneccesary to model connectivity nodes in some cases.   Note that if 
	 * connectivity nodes are in the model, this association would probably not 
	 * be used as an input specification.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topologicalnode_mrid")
	@JoinColumn(name = "topologicalnode_projectid")
	@JoinColumn(name = "topologicalnode_synthesizedschemenumber")
	@JoinColumn(name = "topologicalnode_schemascenarionumber")
	private TopologicalNode TopologicalNode;
	/**
	 * Терминал в конце защищаемого объекта (для определения вида КЗ)
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "TerminalInTheEndOfProtectedObject")
	private List<ProtectionEquipment> ProtectionsForDefineFaultType;
	/**
	 * Terminal of the power transformer to which this transformer end belongs.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Terminal")
	private List<TransformerEnd> TransformerEnd;
	/**
	 * Point of common coupling terminal for this converter DC side. It is typically 
	 * the terminal on the power transformer (or switch) closest to the AC network. 
	 * The power flow measurement must be the sum of all flows into the transformer.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "PccTerminal")
	private List<ACDCConverter> ConverterDCSides;
	/**
	 * Значения потока мощности и тока через оборудование, являющиеся результатом 
	 * расчета режимов
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "TerminalForResult")
	private List<SvPowerFlow> ResultPowerFlow;
	/**
	 * The terminal associated with the power flow state variable.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "svpowerflow_mrid")
	@JoinColumn(name = "svpowerflow_projectid")
	@JoinColumn(name = "svpowerflow_synthesizedschemenumber")
	@JoinColumn(name = "svpowerflow_schemascenarionumber")
	private SvPowerFlow SvPowerFlow;
	/**
	 * Список терминалов смежных трансформаторов со стороны НН
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "peforpowertransformerforklv_mrid")
	@JoinColumn(name = "peforpowertransformerforklv_projectid")
	@JoinColumn(name = "peforpowertransformerforklv_synthesizedschemenumber")
	@JoinColumn(name = "peforpowertransformerforklv_schemascenarionumber")
	private List<ProtectionEquipment> PeForPowerTransformerForkLV;
	/**
	 * Терминал для выбора максимального нагрузочного тока
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "terminalForMaxLoadFlowCurrent")
	private List<ProtectionEquipment> ProtectionlForMaxLoadFlowCurrent;
	/**
	 * The terminal connecting to the bus to which the fault is applied.
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Terminal")
	private List<EquipmentFault> EquipmentFaults;
	/**
	 * Список терминалов смежных трансформаторов со стороны ВН
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "peforpowertransformerforkhv_mrid")
	@JoinColumn(name = "peforpowertransformerforkhv_projectid")
	@JoinColumn(name = "peforpowertransformerforkhv_synthesizedschemenumber")
	@JoinColumn(name = "peforpowertransformerforkhv_schemascenarionumber")
	private List<ProtectionEquipment> PeForPowerTransformerForkHV;
	/**
	 * Терминал в месте установки защиты для выбора токов через защиту при разных 
	 * видах КЗ в конце защищаемого объекта
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "TerminalForScCurrentInMainArea")
	private List<ProtectionEquipment> ProtectionsForScCurrentInMainArea;
	/**
	 * Список терминалов смежных линий
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "peforaclinesegmentfork_mrid")
	@JoinColumn(name = "peforaclinesegmentfork_projectid")
	@JoinColumn(name = "peforaclinesegmentfork_synthesizedschemenumber")
	@JoinColumn(name = "peforaclinesegmentfork_schemascenarionumber")
	private List<ProtectionEquipment> PeForACLineSegmentFork;

	public Boolean getIsBelongingToEquivalent(){
		return this.isBelongingToEquivalent;
	}

	@FieldSetter(fieldName = "Terminal.isBelongingToEquivalent", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
	public void setIsBelongingToEquivalent(Boolean isBelongingToEquivalent){
		this.isBelongingToEquivalent = isBelongingToEquivalent;
	}

	public PhaseCode getPhases(){
		return this.phases;
	}

	@FieldSetter(fieldName = "Terminal.phases", fieldTypeStereotype = "Enumeration", fieldStereotype = "none")
	public void setPhases(PhaseCode phases){
		this.phases = phases;
	}

	@JsonIgnore
	public List<AuxiliaryEquipment> getAuxiliaryEquipment(){
		return this.AuxiliaryEquipment;
	}

	@AssociationSetter(fieldName = "Terminal.AuxiliaryEquipment", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.AuxiliaryEquipment.AuxiliaryEquipment", cardinality = "many")
	public void setAuxiliaryEquipment(List<AuxiliaryEquipment> AuxiliaryEquipment){
		this.AuxiliaryEquipment = AuxiliaryEquipment;
	}

	public ConductingEquipment getConductingEquipment(){
		return this.ConductingEquipment;
	}

	@AssociationSetter(fieldName = "Terminal.ConductingEquipment", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment", cardinality = "one")
	public void setConductingEquipment(ConductingEquipment ConductingEquipment){
		this.ConductingEquipment = ConductingEquipment;
	}

	public ConnectivityNode getConnectivityNode(){
		return this.ConnectivityNode;
	}

	@AssociationSetter(fieldName = "Terminal.ConnectivityNode", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.ConnectivityNode", cardinality = "one")
	public void setConnectivityNode(ConnectivityNode ConnectivityNode){
		this.ConnectivityNode = ConnectivityNode;
	}

	public TopologicalNode getTopologicalNode(){
		return this.TopologicalNode;
	}

	@AssociationSetter(fieldName = "Terminal.TopologicalNode", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Topology.TopologicalNode", cardinality = "one")
	public void setTopologicalNode(TopologicalNode TopologicalNode){
		this.TopologicalNode = TopologicalNode;
	}

	@JsonIgnore
	public List<ProtectionEquipment> getProtectionsForDefineFaultType(){
		return this.ProtectionsForDefineFaultType;
	}

	@AssociationSetter(fieldName = "Terminal.ProtectionsForDefineFaultType", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setProtectionsForDefineFaultType(List<ProtectionEquipment> ProtectionsForDefineFaultType){
		this.ProtectionsForDefineFaultType = ProtectionsForDefineFaultType;
	}

	@JsonIgnore
	public List<TransformerEnd> getTransformerEnd(){
		return this.TransformerEnd;
	}

	@AssociationSetter(fieldName = "Terminal.TransformerEnd", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.TransformerEnd", cardinality = "many")
	public void setTransformerEnd(List<TransformerEnd> TransformerEnd){
		this.TransformerEnd = TransformerEnd;
	}

	@JsonIgnore
	public List<ACDCConverter> getConverterDCSides(){
		return this.ConverterDCSides;
	}

	@AssociationSetter(fieldName = "Terminal.ConverterDCSides", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.DC.ACDCConverter", cardinality = "many")
	public void setConverterDCSides(List<ACDCConverter> ConverterDCSides){
		this.ConverterDCSides = ConverterDCSides;
	}

	@JsonIgnore
	public List<SvPowerFlow> getResultPowerFlow(){
		return this.ResultPowerFlow;
	}

	@AssociationSetter(fieldName = "Terminal.ResultPowerFlow", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.StateVariables.SvPowerFlow", cardinality = "many")
	public void setResultPowerFlow(List<SvPowerFlow> ResultPowerFlow){
		this.ResultPowerFlow = ResultPowerFlow;
	}

	public SvPowerFlow getSvPowerFlow(){
		return this.SvPowerFlow;
	}

	@AssociationSetter(fieldName = "Terminal.SvPowerFlow", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.StateVariables.SvPowerFlow", cardinality = "one")
	public void setSvPowerFlow(SvPowerFlow SvPowerFlow){
		this.SvPowerFlow = SvPowerFlow;
	}

	public List<ProtectionEquipment> getPeForPowerTransformerForkLV(){
		return this.PeForPowerTransformerForkLV;
	}

	@AssociationSetter(fieldName = "Terminal.PeForPowerTransformerForkLV", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setPeForPowerTransformerForkLV(List<ProtectionEquipment> PeForPowerTransformerForkLV){
		this.PeForPowerTransformerForkLV = PeForPowerTransformerForkLV;
	}

	@JsonIgnore
	public List<ProtectionEquipment> getProtectionlForMaxLoadFlowCurrent(){
		return this.ProtectionlForMaxLoadFlowCurrent;
	}

	@AssociationSetter(fieldName = "Terminal.ProtectionlForMaxLoadFlowCurrent", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setProtectionlForMaxLoadFlowCurrent(List<ProtectionEquipment> ProtectionlForMaxLoadFlowCurrent){
		this.ProtectionlForMaxLoadFlowCurrent = ProtectionlForMaxLoadFlowCurrent;
	}

	@JsonIgnore
	public List<EquipmentFault> getEquipmentFaults(){
		return this.EquipmentFaults;
	}

	@AssociationSetter(fieldName = "Terminal.EquipmentFaults", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Faults.EquipmentFault", cardinality = "many")
	public void setEquipmentFaults(List<EquipmentFault> EquipmentFaults){
		this.EquipmentFaults = EquipmentFaults;
	}

	public List<ProtectionEquipment> getPeForPowerTransformerForkHV(){
		return this.PeForPowerTransformerForkHV;
	}

	@AssociationSetter(fieldName = "Terminal.PeForPowerTransformerForkHV", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setPeForPowerTransformerForkHV(List<ProtectionEquipment> PeForPowerTransformerForkHV){
		this.PeForPowerTransformerForkHV = PeForPowerTransformerForkHV;
	}

	@JsonIgnore
	public List<ProtectionEquipment> getProtectionsForScCurrentInMainArea(){
		return this.ProtectionsForScCurrentInMainArea;
	}

	@AssociationSetter(fieldName = "Terminal.ProtectionsForScCurrentInMainArea", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setProtectionsForScCurrentInMainArea(List<ProtectionEquipment> ProtectionsForScCurrentInMainArea){
		this.ProtectionsForScCurrentInMainArea = ProtectionsForScCurrentInMainArea;
	}

	public List<ProtectionEquipment> getPeForACLineSegmentFork(){
		return this.PeForACLineSegmentFork;
	}

	@AssociationSetter(fieldName = "Terminal.PeForACLineSegmentFork", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment", cardinality = "many")
	public void setPeForACLineSegmentFork(List<ProtectionEquipment> PeForACLineSegmentFork){
		this.PeForACLineSegmentFork = PeForACLineSegmentFork;
	}

	public Terminal(){

	}

}
