package ru.mpei.prob.model;

import ru.mpei.prob.model.CIMProfile.IEC61968.Assets.Asset;
import ru.mpei.prob.model.CIMProfile.IEC61968.Common.CoordinateSystem;
import ru.mpei.prob.model.CIMProfile.IEC61968.Common.Location;
import ru.mpei.prob.model.CIMProfile.IEC61968.Common.OrganisationRole;
import ru.mpei.prob.model.CIMProfile.IEC61968.Customers.Customer;
import ru.mpei.prob.model.CIMProfile.IEC61968.Operations.Outage;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.AuxiliaryEquipment.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.DiagramLayout.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Equivalents.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults.EquipmentFault;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults.Fault;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults.FaultCauseType;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Faults.LineFault;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Generation.Production.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.LoadModel.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Meas.Limit;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Meas.LimitSet;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.CurrentRelay;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.DistanceRelay;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.LN_61850.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.RecloseSequence;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.StateVariables.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.BusNameMarker;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.DCTopologicalNode;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.TopologicalIsland;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Topology.TopologicalNode;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.*;
import ru.mpei.prob.model.CIMProfile.NTI.*;
import ru.mpei.prob.model.CIMProfile.NTI.EnergyStorageSystems.BatteryBankCell;
import ru.mpei.prob.model.CIMProfile.NTI.EnergyStorageSystems.BatteryEnergyStorageSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CloningFactoryImpl implements CloningFactory {

	private Map<String, IdentifiedObject> clonedObjects = new HashMap<>();
	private Integer synthesizedNumber;

	@Override
	public Collection<IdentifiedObject> clone(Collection<IdentifiedObject> initialObjects, Integer synthesizedNumber){
		clonedObjects.clear();
		this.synthesizedNumber = synthesizedNumber;

		for (IdentifiedObject io: initialObjects){
			switchCaseForCloningObjectWithFields(io);
		}
		for (IdentifiedObject io: initialObjects){
			switchCaseForAddingAssociations(io);
		}

		return clonedObjects.values();
	}

	private void switchCaseForCloningObjectWithFields(IdentifiedObject io){
		switch (io.getClassName()){
			case CapexOpexCalculationResult: this.cloneObjectWithFields((CapexOpexCalculationResult) io); break;
			case ChargeController: this.cloneObjectWithFields((ChargeController) io); break;
			case Cluster: this.cloneObjectWithFields((Cluster) io); break;
			case ConsumersCluster: this.cloneObjectWithFields((ConsumersCluster) io); break;
			case ConsumersVoltageCluster: this.cloneObjectWithFields((ConsumersVoltageCluster) io); break;
			case ScenarioPossibility: this.cloneObjectWithFields((ScenarioPossibility) io); break;
			case BatteryBankCell: this.cloneObjectWithFields((BatteryBankCell) io); break;
			case BatteryEnergyStorageSystem: this.cloneObjectWithFields((BatteryEnergyStorageSystem) io); break;
			case Asset: this.cloneObjectWithFields((Asset) io); break;
			case CoordinateSystem: this.cloneObjectWithFields((CoordinateSystem) io); break;
			case Location: this.cloneObjectWithFields((Location) io); break;
			case OrganisationRole: this.cloneObjectWithFields((OrganisationRole) io); break;
			case Customer: this.cloneObjectWithFields((Customer) io); break;
			case Outage: this.cloneObjectWithFields((Outage) io); break;
			case AuxiliaryEquipment: this.cloneObjectWithFields((AuxiliaryEquipment) io); break;
			case CurrentTransformer: this.cloneObjectWithFields((CurrentTransformer) io); break;
			case PotentialTransformer: this.cloneObjectWithFields((PotentialTransformer) io); break;
			case Sensor: this.cloneObjectWithFields((Sensor) io); break;
			case SurgeArrester: this.cloneObjectWithFields((SurgeArrester) io); break;
			case ACDCTerminal: this.cloneObjectWithFields((ACDCTerminal) io); break;
			case BaseVoltage: this.cloneObjectWithFields((BaseVoltage) io); break;
			case Bay: this.cloneObjectWithFields((Bay) io); break;
			case ConductingEquipment: this.cloneObjectWithFields((ConductingEquipment) io); break;
			case ConnectivityNode: this.cloneObjectWithFields((ConnectivityNode) io); break;
			case ConnectivityNodeContainer: this.cloneObjectWithFields((ConnectivityNodeContainer) io); break;
			case Curve: this.cloneObjectWithFields((Curve) io); break;
			case CurveData: this.cloneObjectWithFields((CurveData) io); break;
			case Equipment: this.cloneObjectWithFields((Equipment) io); break;
			case EquipmentContainer: this.cloneObjectWithFields((EquipmentContainer) io); break;
			case GeographicalRegion: this.cloneObjectWithFields((GeographicalRegion) io); break;
			case Name: this.cloneObjectWithFields((Name) io); break;
			case NameType: this.cloneObjectWithFields((NameType) io); break;
			case PowerSystemResource: this.cloneObjectWithFields((PowerSystemResource) io); break;
			case ReportingGroup: this.cloneObjectWithFields((ReportingGroup) io); break;
			case SubGeographicalRegion: this.cloneObjectWithFields((SubGeographicalRegion) io); break;
			case Substation: this.cloneObjectWithFields((Substation) io); break;
			case Terminal: this.cloneObjectWithFields((Terminal) io); break;
			case VoltageLevel: this.cloneObjectWithFields((VoltageLevel) io); break;
			case ACDCConverter: this.cloneObjectWithFields((ACDCConverter) io); break;
			case ACDCConverterDCTerminal: this.cloneObjectWithFields((ACDCConverterDCTerminal) io); break;
			case CsConverter: this.cloneObjectWithFields((CsConverter) io); break;
			case DCBaseTerminal: this.cloneObjectWithFields((DCBaseTerminal) io); break;
			case DCBreaker: this.cloneObjectWithFields((DCBreaker) io); break;
			case DCBusbar: this.cloneObjectWithFields((DCBusbar) io); break;
			case DCChopper: this.cloneObjectWithFields((DCChopper) io); break;
			case DCConductingEquipment: this.cloneObjectWithFields((DCConductingEquipment) io); break;
			case DCConverterUnit: this.cloneObjectWithFields((DCConverterUnit) io); break;
			case DCDisconnector: this.cloneObjectWithFields((DCDisconnector) io); break;
			case DCEquipmentContainer: this.cloneObjectWithFields((DCEquipmentContainer) io); break;
			case DCGround: this.cloneObjectWithFields((DCGround) io); break;
			case DCLine: this.cloneObjectWithFields((DCLine) io); break;
			case DCLineSegment: this.cloneObjectWithFields((DCLineSegment) io); break;
			case DCNode: this.cloneObjectWithFields((DCNode) io); break;
			case DCSeriesDevice: this.cloneObjectWithFields((DCSeriesDevice) io); break;
			case DCShunt: this.cloneObjectWithFields((DCShunt) io); break;
			case DCSwitch: this.cloneObjectWithFields((DCSwitch) io); break;
			case DCTerminal: this.cloneObjectWithFields((DCTerminal) io); break;
			case DCTopologicalIsland: this.cloneObjectWithFields((DCTopologicalIsland) io); break;
			case PerLengthDCLineParameter: this.cloneObjectWithFields((PerLengthDCLineParameter) io); break;
			case VsCapabilityCurve: this.cloneObjectWithFields((VsCapabilityCurve) io); break;
			case VsConverter: this.cloneObjectWithFields((VsConverter) io); break;
			case Diagram: this.cloneObjectWithFields((Diagram) io); break;
			case DiagramObject: this.cloneObjectWithFields((DiagramObject) io); break;
			case DiagramObjectGluePoint: this.cloneObjectWithFields((DiagramObjectGluePoint) io); break;
			case DiagramObjectPoint: this.cloneObjectWithFields((DiagramObjectPoint) io); break;
			case DiagramObjectStyle: this.cloneObjectWithFields((DiagramObjectStyle) io); break;
			case DiagramStyle: this.cloneObjectWithFields((DiagramStyle) io); break;
			case TextDiagramObject: this.cloneObjectWithFields((TextDiagramObject) io); break;
			case VisibilityLayer: this.cloneObjectWithFields((VisibilityLayer) io); break;
			case EquivalentBranch: this.cloneObjectWithFields((EquivalentBranch) io); break;
			case EquivalentEquipment: this.cloneObjectWithFields((EquivalentEquipment) io); break;
			case EquivalentInjection: this.cloneObjectWithFields((EquivalentInjection) io); break;
			case EquivalentNetwork: this.cloneObjectWithFields((EquivalentNetwork) io); break;
			case EquivalentShunt: this.cloneObjectWithFields((EquivalentShunt) io); break;
			case EquipmentFault: this.cloneObjectWithFields((EquipmentFault) io); break;
			case Fault: this.cloneObjectWithFields((Fault) io); break;
			case FaultCauseType: this.cloneObjectWithFields((FaultCauseType) io); break;
			case LineFault: this.cloneObjectWithFields((LineFault) io); break;
			case FossilFuel: this.cloneObjectWithFields((FossilFuel) io); break;
			case GeneratingUnit: this.cloneObjectWithFields((GeneratingUnit) io); break;
			case HydroGeneratingUnit: this.cloneObjectWithFields((HydroGeneratingUnit) io); break;
			case HydroPowerPlant: this.cloneObjectWithFields((HydroPowerPlant) io); break;
			case HydroPump: this.cloneObjectWithFields((HydroPump) io); break;
			case NuclearGeneratingUnit: this.cloneObjectWithFields((NuclearGeneratingUnit) io); break;
			case SolarGeneratingUnit: this.cloneObjectWithFields((SolarGeneratingUnit) io); break;
			case ThermalGeneratingUnit: this.cloneObjectWithFields((ThermalGeneratingUnit) io); break;
			case WindGeneratingUnit: this.cloneObjectWithFields((WindGeneratingUnit) io); break;
			case ConformLoad: this.cloneObjectWithFields((ConformLoad) io); break;
			case ConformLoadGroup: this.cloneObjectWithFields((ConformLoadGroup) io); break;
			case EnergyArea: this.cloneObjectWithFields((EnergyArea) io); break;
			case LoadGroup: this.cloneObjectWithFields((LoadGroup) io); break;
			case LoadResponseCharacteristic: this.cloneObjectWithFields((LoadResponseCharacteristic) io); break;
			case NonConformLoad: this.cloneObjectWithFields((NonConformLoad) io); break;
			case NonConformLoadGroup: this.cloneObjectWithFields((NonConformLoadGroup) io); break;
			case StationSupply: this.cloneObjectWithFields((StationSupply) io); break;
			case Limit: this.cloneObjectWithFields((Limit) io); break;
			case LimitSet: this.cloneObjectWithFields((LimitSet) io); break;
			case CurrentRelay: this.cloneObjectWithFields((CurrentRelay) io); break;
			case DistanceRelay: this.cloneObjectWithFields((DistanceRelay) io); break;
			case ProtectionEquipment: this.cloneObjectWithFields((ProtectionEquipment) io); break;
			case RecloseSequence: this.cloneObjectWithFields((RecloseSequence) io); break;
			case CILO: this.cloneObjectWithFields((CILO) io); break;
			case Common_LN: this.cloneObjectWithFields((Common_LN) io); break;
			case CSWI: this.cloneObjectWithFields((CSWI) io); break;
			case PDIF: this.cloneObjectWithFields((PDIF) io); break;
			case PDIS: this.cloneObjectWithFields((PDIS) io); break;
			case PDIS_Settings: this.cloneObjectWithFields((PDIS_Settings) io); break;
			case StateVariable: this.cloneObjectWithFields((StateVariable) io); break;
			case SvInjection: this.cloneObjectWithFields((SvInjection) io); break;
			case SvPowerFlow: this.cloneObjectWithFields((SvPowerFlow) io); break;
			case SvShuntCompensatorSections: this.cloneObjectWithFields((SvShuntCompensatorSections) io); break;
			case SvStatus: this.cloneObjectWithFields((SvStatus) io); break;
			case SvTapStep: this.cloneObjectWithFields((SvTapStep) io); break;
			case SvVoltage: this.cloneObjectWithFields((SvVoltage) io); break;
			case BusNameMarker: this.cloneObjectWithFields((BusNameMarker) io); break;
			case DCTopologicalNode: this.cloneObjectWithFields((DCTopologicalNode) io); break;
			case TopologicalIsland: this.cloneObjectWithFields((TopologicalIsland) io); break;
			case TopologicalNode: this.cloneObjectWithFields((TopologicalNode) io); break;
			case ACLineSegment: this.cloneObjectWithFields((ACLineSegment) io); break;
			case AsynchronousMachine: this.cloneObjectWithFields((AsynchronousMachine) io); break;
			case Breaker: this.cloneObjectWithFields((Breaker) io); break;
			case BusbarSection: this.cloneObjectWithFields((BusbarSection) io); break;
			case Conductor: this.cloneObjectWithFields((Conductor) io); break;
			case Connector: this.cloneObjectWithFields((Connector) io); break;
			case Disconnector: this.cloneObjectWithFields((Disconnector) io); break;
			case EarthFaultCompensator: this.cloneObjectWithFields((EarthFaultCompensator) io); break;
			case EnergyConsumer: this.cloneObjectWithFields((EnergyConsumer) io); break;
			case EnergySource: this.cloneObjectWithFields((EnergySource) io); break;
			case ExternalNetworkInjection: this.cloneObjectWithFields((ExternalNetworkInjection) io); break;
			case GroundDisconnector: this.cloneObjectWithFields((GroundDisconnector) io); break;
			case Junction: this.cloneObjectWithFields((Junction) io); break;
			case Line: this.cloneObjectWithFields((Line) io); break;
			case LinearShuntCompensator: this.cloneObjectWithFields((LinearShuntCompensator) io); break;
			case LoadBreakSwitch: this.cloneObjectWithFields((LoadBreakSwitch) io); break;
			case NonlinearShuntCompensator: this.cloneObjectWithFields((NonlinearShuntCompensator) io); break;
			case NonlinearShuntCompensatorPoint: this.cloneObjectWithFields((NonlinearShuntCompensatorPoint) io); break;
			case PerLengthLineParameter: this.cloneObjectWithFields((PerLengthLineParameter) io); break;
			case PetersenCoil: this.cloneObjectWithFields((PetersenCoil) io); break;
			case PhaseTapChanger: this.cloneObjectWithFields((PhaseTapChanger) io); break;
			case PhaseTapChangerAsymmetrical: this.cloneObjectWithFields((PhaseTapChangerAsymmetrical) io); break;
			case PhaseTapChangerLinear: this.cloneObjectWithFields((PhaseTapChangerLinear) io); break;
			case PhaseTapChangerNonLinear: this.cloneObjectWithFields((PhaseTapChangerNonLinear) io); break;
			case PhaseTapChangerSymmetrical: this.cloneObjectWithFields((PhaseTapChangerSymmetrical) io); break;
			case PhaseTapChangerTable: this.cloneObjectWithFields((PhaseTapChangerTable) io); break;
			case PhaseTapChangerTablePoint: this.cloneObjectWithFields((PhaseTapChangerTablePoint) io); break;
			case PhaseTapChangerTabular: this.cloneObjectWithFields((PhaseTapChangerTabular) io); break;
			case PowerTransformer: this.cloneObjectWithFields((PowerTransformer) io); break;
			case PowerTransformerEnd: this.cloneObjectWithFields((PowerTransformerEnd) io); break;
			case ProtectedSwitch: this.cloneObjectWithFields((ProtectedSwitch) io); break;
			case RatioTapChanger: this.cloneObjectWithFields((RatioTapChanger) io); break;
			case RatioTapChangerTable: this.cloneObjectWithFields((RatioTapChangerTable) io); break;
			case RatioTapChangerTablePoint: this.cloneObjectWithFields((RatioTapChangerTablePoint) io); break;
			case ReactiveCapabilityCurve: this.cloneObjectWithFields((ReactiveCapabilityCurve) io); break;
			case Recloser: this.cloneObjectWithFields((Recloser) io); break;
			case RegulatingCondEq: this.cloneObjectWithFields((RegulatingCondEq) io); break;
			case RegulatingControl: this.cloneObjectWithFields((RegulatingControl) io); break;
			case RotatingMachine: this.cloneObjectWithFields((RotatingMachine) io); break;
			case SeriesCompensator: this.cloneObjectWithFields((SeriesCompensator) io); break;
			case ShuntCompensator: this.cloneObjectWithFields((ShuntCompensator) io); break;
			case ShuntCompensatorPhase: this.cloneObjectWithFields((ShuntCompensatorPhase) io); break;
			case StaticVarCompensator: this.cloneObjectWithFields((StaticVarCompensator) io); break;
			case Switch: this.cloneObjectWithFields((Switch) io); break;
			case SynchronousMachine: this.cloneObjectWithFields((SynchronousMachine) io); break;
			case TapChanger: this.cloneObjectWithFields((TapChanger) io); break;
			case TapChangerControl: this.cloneObjectWithFields((TapChangerControl) io); break;
			case TapChangerTablePoint: this.cloneObjectWithFields((TapChangerTablePoint) io); break;
			case TransformerEnd: this.cloneObjectWithFields((TransformerEnd) io); break;
		}
	}

	private void switchCaseForAddingAssociations(IdentifiedObject io){
		switch (io.getClassName()){
			case CapexOpexCalculationResult: this.addAssociationsToClonedObject((CapexOpexCalculationResult) io); break;
			case ChargeController: this.addAssociationsToClonedObject((ChargeController) io); break;
			case Cluster: this.addAssociationsToClonedObject((Cluster) io); break;
			case ConsumersCluster: this.addAssociationsToClonedObject((ConsumersCluster) io); break;
			case ConsumersVoltageCluster: this.addAssociationsToClonedObject((ConsumersVoltageCluster) io); break;
			case ScenarioPossibility: this.addAssociationsToClonedObject((ScenarioPossibility) io); break;
			case BatteryBankCell: this.addAssociationsToClonedObject((BatteryBankCell) io); break;
			case BatteryEnergyStorageSystem: this.addAssociationsToClonedObject((BatteryEnergyStorageSystem) io); break;
			case Asset: this.addAssociationsToClonedObject((Asset) io); break;
			case CoordinateSystem: this.addAssociationsToClonedObject((CoordinateSystem) io); break;
			case Location: this.addAssociationsToClonedObject((Location) io); break;
			case OrganisationRole: this.addAssociationsToClonedObject((OrganisationRole) io); break;
			case Customer: this.addAssociationsToClonedObject((Customer) io); break;
			case Outage: this.addAssociationsToClonedObject((Outage) io); break;
			case AuxiliaryEquipment: this.addAssociationsToClonedObject((AuxiliaryEquipment) io); break;
			case CurrentTransformer: this.addAssociationsToClonedObject((CurrentTransformer) io); break;
			case PotentialTransformer: this.addAssociationsToClonedObject((PotentialTransformer) io); break;
			case Sensor: this.addAssociationsToClonedObject((Sensor) io); break;
			case SurgeArrester: this.addAssociationsToClonedObject((SurgeArrester) io); break;
			case ACDCTerminal: this.addAssociationsToClonedObject((ACDCTerminal) io); break;
			case BaseVoltage: this.addAssociationsToClonedObject((BaseVoltage) io); break;
			case Bay: this.addAssociationsToClonedObject((Bay) io); break;
			case ConductingEquipment: this.addAssociationsToClonedObject((ConductingEquipment) io); break;
			case ConnectivityNode: this.addAssociationsToClonedObject((ConnectivityNode) io); break;
			case ConnectivityNodeContainer: this.addAssociationsToClonedObject((ConnectivityNodeContainer) io); break;
			case Curve: this.addAssociationsToClonedObject((Curve) io); break;
			case CurveData: this.addAssociationsToClonedObject((CurveData) io); break;
			case Equipment: this.addAssociationsToClonedObject((Equipment) io); break;
			case EquipmentContainer: this.addAssociationsToClonedObject((EquipmentContainer) io); break;
			case GeographicalRegion: this.addAssociationsToClonedObject((GeographicalRegion) io); break;
			case Name: this.addAssociationsToClonedObject((Name) io); break;
			case NameType: this.addAssociationsToClonedObject((NameType) io); break;
			case PowerSystemResource: this.addAssociationsToClonedObject((PowerSystemResource) io); break;
			case ReportingGroup: this.addAssociationsToClonedObject((ReportingGroup) io); break;
			case SubGeographicalRegion: this.addAssociationsToClonedObject((SubGeographicalRegion) io); break;
			case Substation: this.addAssociationsToClonedObject((Substation) io); break;
			case Terminal: this.addAssociationsToClonedObject((Terminal) io); break;
			case VoltageLevel: this.addAssociationsToClonedObject((VoltageLevel) io); break;
			case ACDCConverter: this.addAssociationsToClonedObject((ACDCConverter) io); break;
			case ACDCConverterDCTerminal: this.addAssociationsToClonedObject((ACDCConverterDCTerminal) io); break;
			case CsConverter: this.addAssociationsToClonedObject((CsConverter) io); break;
			case DCBaseTerminal: this.addAssociationsToClonedObject((DCBaseTerminal) io); break;
			case DCBreaker: this.addAssociationsToClonedObject((DCBreaker) io); break;
			case DCBusbar: this.addAssociationsToClonedObject((DCBusbar) io); break;
			case DCChopper: this.addAssociationsToClonedObject((DCChopper) io); break;
			case DCConductingEquipment: this.addAssociationsToClonedObject((DCConductingEquipment) io); break;
			case DCConverterUnit: this.addAssociationsToClonedObject((DCConverterUnit) io); break;
			case DCDisconnector: this.addAssociationsToClonedObject((DCDisconnector) io); break;
			case DCEquipmentContainer: this.addAssociationsToClonedObject((DCEquipmentContainer) io); break;
			case DCGround: this.addAssociationsToClonedObject((DCGround) io); break;
			case DCLine: this.addAssociationsToClonedObject((DCLine) io); break;
			case DCLineSegment: this.addAssociationsToClonedObject((DCLineSegment) io); break;
			case DCNode: this.addAssociationsToClonedObject((DCNode) io); break;
			case DCSeriesDevice: this.addAssociationsToClonedObject((DCSeriesDevice) io); break;
			case DCShunt: this.addAssociationsToClonedObject((DCShunt) io); break;
			case DCSwitch: this.addAssociationsToClonedObject((DCSwitch) io); break;
			case DCTerminal: this.addAssociationsToClonedObject((DCTerminal) io); break;
			case DCTopologicalIsland: this.addAssociationsToClonedObject((DCTopologicalIsland) io); break;
			case PerLengthDCLineParameter: this.addAssociationsToClonedObject((PerLengthDCLineParameter) io); break;
			case VsCapabilityCurve: this.addAssociationsToClonedObject((VsCapabilityCurve) io); break;
			case VsConverter: this.addAssociationsToClonedObject((VsConverter) io); break;
			case Diagram: this.addAssociationsToClonedObject((Diagram) io); break;
			case DiagramObject: this.addAssociationsToClonedObject((DiagramObject) io); break;
			case DiagramObjectGluePoint: this.addAssociationsToClonedObject((DiagramObjectGluePoint) io); break;
			case DiagramObjectPoint: this.addAssociationsToClonedObject((DiagramObjectPoint) io); break;
			case DiagramObjectStyle: this.addAssociationsToClonedObject((DiagramObjectStyle) io); break;
			case DiagramStyle: this.addAssociationsToClonedObject((DiagramStyle) io); break;
			case TextDiagramObject: this.addAssociationsToClonedObject((TextDiagramObject) io); break;
			case VisibilityLayer: this.addAssociationsToClonedObject((VisibilityLayer) io); break;
			case EquivalentBranch: this.addAssociationsToClonedObject((EquivalentBranch) io); break;
			case EquivalentEquipment: this.addAssociationsToClonedObject((EquivalentEquipment) io); break;
			case EquivalentInjection: this.addAssociationsToClonedObject((EquivalentInjection) io); break;
			case EquivalentNetwork: this.addAssociationsToClonedObject((EquivalentNetwork) io); break;
			case EquivalentShunt: this.addAssociationsToClonedObject((EquivalentShunt) io); break;
			case EquipmentFault: this.addAssociationsToClonedObject((EquipmentFault) io); break;
			case Fault: this.addAssociationsToClonedObject((Fault) io); break;
			case FaultCauseType: this.addAssociationsToClonedObject((FaultCauseType) io); break;
			case LineFault: this.addAssociationsToClonedObject((LineFault) io); break;
			case FossilFuel: this.addAssociationsToClonedObject((FossilFuel) io); break;
			case GeneratingUnit: this.addAssociationsToClonedObject((GeneratingUnit) io); break;
			case HydroGeneratingUnit: this.addAssociationsToClonedObject((HydroGeneratingUnit) io); break;
			case HydroPowerPlant: this.addAssociationsToClonedObject((HydroPowerPlant) io); break;
			case HydroPump: this.addAssociationsToClonedObject((HydroPump) io); break;
			case NuclearGeneratingUnit: this.addAssociationsToClonedObject((NuclearGeneratingUnit) io); break;
			case SolarGeneratingUnit: this.addAssociationsToClonedObject((SolarGeneratingUnit) io); break;
			case ThermalGeneratingUnit: this.addAssociationsToClonedObject((ThermalGeneratingUnit) io); break;
			case WindGeneratingUnit: this.addAssociationsToClonedObject((WindGeneratingUnit) io); break;
			case ConformLoad: this.addAssociationsToClonedObject((ConformLoad) io); break;
			case ConformLoadGroup: this.addAssociationsToClonedObject((ConformLoadGroup) io); break;
			case EnergyArea: this.addAssociationsToClonedObject((EnergyArea) io); break;
			case LoadGroup: this.addAssociationsToClonedObject((LoadGroup) io); break;
			case LoadResponseCharacteristic: this.addAssociationsToClonedObject((LoadResponseCharacteristic) io); break;
			case NonConformLoad: this.addAssociationsToClonedObject((NonConformLoad) io); break;
			case NonConformLoadGroup: this.addAssociationsToClonedObject((NonConformLoadGroup) io); break;
			case StationSupply: this.addAssociationsToClonedObject((StationSupply) io); break;
			case Limit: this.addAssociationsToClonedObject((Limit) io); break;
			case LimitSet: this.addAssociationsToClonedObject((LimitSet) io); break;
			case CurrentRelay: this.addAssociationsToClonedObject((CurrentRelay) io); break;
			case DistanceRelay: this.addAssociationsToClonedObject((DistanceRelay) io); break;
			case ProtectionEquipment: this.addAssociationsToClonedObject((ProtectionEquipment) io); break;
			case RecloseSequence: this.addAssociationsToClonedObject((RecloseSequence) io); break;
			case CILO: this.addAssociationsToClonedObject((CILO) io); break;
			case Common_LN: this.addAssociationsToClonedObject((Common_LN) io); break;
			case CSWI: this.addAssociationsToClonedObject((CSWI) io); break;
			case PDIF: this.addAssociationsToClonedObject((PDIF) io); break;
			case PDIS: this.addAssociationsToClonedObject((PDIS) io); break;
			case PDIS_Settings: this.addAssociationsToClonedObject((PDIS_Settings) io); break;
			case StateVariable: this.addAssociationsToClonedObject((StateVariable) io); break;
			case SvInjection: this.addAssociationsToClonedObject((SvInjection) io); break;
			case SvPowerFlow: this.addAssociationsToClonedObject((SvPowerFlow) io); break;
			case SvShuntCompensatorSections: this.addAssociationsToClonedObject((SvShuntCompensatorSections) io); break;
			case SvStatus: this.addAssociationsToClonedObject((SvStatus) io); break;
			case SvTapStep: this.addAssociationsToClonedObject((SvTapStep) io); break;
			case SvVoltage: this.addAssociationsToClonedObject((SvVoltage) io); break;
			case BusNameMarker: this.addAssociationsToClonedObject((BusNameMarker) io); break;
			case DCTopologicalNode: this.addAssociationsToClonedObject((DCTopologicalNode) io); break;
			case TopologicalIsland: this.addAssociationsToClonedObject((TopologicalIsland) io); break;
			case TopologicalNode: this.addAssociationsToClonedObject((TopologicalNode) io); break;
			case ACLineSegment: this.addAssociationsToClonedObject((ACLineSegment) io); break;
			case AsynchronousMachine: this.addAssociationsToClonedObject((AsynchronousMachine) io); break;
			case Breaker: this.addAssociationsToClonedObject((Breaker) io); break;
			case BusbarSection: this.addAssociationsToClonedObject((BusbarSection) io); break;
			case Conductor: this.addAssociationsToClonedObject((Conductor) io); break;
			case Connector: this.addAssociationsToClonedObject((Connector) io); break;
			case Disconnector: this.addAssociationsToClonedObject((Disconnector) io); break;
			case EarthFaultCompensator: this.addAssociationsToClonedObject((EarthFaultCompensator) io); break;
			case EnergyConsumer: this.addAssociationsToClonedObject((EnergyConsumer) io); break;
			case EnergySource: this.addAssociationsToClonedObject((EnergySource) io); break;
			case ExternalNetworkInjection: this.addAssociationsToClonedObject((ExternalNetworkInjection) io); break;
			case GroundDisconnector: this.addAssociationsToClonedObject((GroundDisconnector) io); break;
			case Junction: this.addAssociationsToClonedObject((Junction) io); break;
			case Line: this.addAssociationsToClonedObject((Line) io); break;
			case LinearShuntCompensator: this.addAssociationsToClonedObject((LinearShuntCompensator) io); break;
			case LoadBreakSwitch: this.addAssociationsToClonedObject((LoadBreakSwitch) io); break;
			case NonlinearShuntCompensator: this.addAssociationsToClonedObject((NonlinearShuntCompensator) io); break;
			case NonlinearShuntCompensatorPoint: this.addAssociationsToClonedObject((NonlinearShuntCompensatorPoint) io); break;
			case PerLengthLineParameter: this.addAssociationsToClonedObject((PerLengthLineParameter) io); break;
			case PetersenCoil: this.addAssociationsToClonedObject((PetersenCoil) io); break;
			case PhaseTapChanger: this.addAssociationsToClonedObject((PhaseTapChanger) io); break;
			case PhaseTapChangerAsymmetrical: this.addAssociationsToClonedObject((PhaseTapChangerAsymmetrical) io); break;
			case PhaseTapChangerLinear: this.addAssociationsToClonedObject((PhaseTapChangerLinear) io); break;
			case PhaseTapChangerNonLinear: this.addAssociationsToClonedObject((PhaseTapChangerNonLinear) io); break;
			case PhaseTapChangerSymmetrical: this.addAssociationsToClonedObject((PhaseTapChangerSymmetrical) io); break;
			case PhaseTapChangerTable: this.addAssociationsToClonedObject((PhaseTapChangerTable) io); break;
			case PhaseTapChangerTablePoint: this.addAssociationsToClonedObject((PhaseTapChangerTablePoint) io); break;
			case PhaseTapChangerTabular: this.addAssociationsToClonedObject((PhaseTapChangerTabular) io); break;
			case PowerTransformer: this.addAssociationsToClonedObject((PowerTransformer) io); break;
			case PowerTransformerEnd: this.addAssociationsToClonedObject((PowerTransformerEnd) io); break;
			case ProtectedSwitch: this.addAssociationsToClonedObject((ProtectedSwitch) io); break;
			case RatioTapChanger: this.addAssociationsToClonedObject((RatioTapChanger) io); break;
			case RatioTapChangerTable: this.addAssociationsToClonedObject((RatioTapChangerTable) io); break;
			case RatioTapChangerTablePoint: this.addAssociationsToClonedObject((RatioTapChangerTablePoint) io); break;
			case ReactiveCapabilityCurve: this.addAssociationsToClonedObject((ReactiveCapabilityCurve) io); break;
			case Recloser: this.addAssociationsToClonedObject((Recloser) io); break;
			case RegulatingCondEq: this.addAssociationsToClonedObject((RegulatingCondEq) io); break;
			case RegulatingControl: this.addAssociationsToClonedObject((RegulatingControl) io); break;
			case RotatingMachine: this.addAssociationsToClonedObject((RotatingMachine) io); break;
			case SeriesCompensator: this.addAssociationsToClonedObject((SeriesCompensator) io); break;
			case ShuntCompensator: this.addAssociationsToClonedObject((ShuntCompensator) io); break;
			case ShuntCompensatorPhase: this.addAssociationsToClonedObject((ShuntCompensatorPhase) io); break;
			case StaticVarCompensator: this.addAssociationsToClonedObject((StaticVarCompensator) io); break;
			case Switch: this.addAssociationsToClonedObject((Switch) io); break;
			case SynchronousMachine: this.addAssociationsToClonedObject((SynchronousMachine) io); break;
			case TapChanger: this.addAssociationsToClonedObject((TapChanger) io); break;
			case TapChangerControl: this.addAssociationsToClonedObject((TapChangerControl) io); break;
			case TapChangerTablePoint: this.addAssociationsToClonedObject((TapChangerTablePoint) io); break;
			case TransformerEnd: this.addAssociationsToClonedObject((TransformerEnd) io); break;
		}
	}
	private void cloneObjectWithFields(CapexOpexCalculationResult initialObject){
		CapexOpexCalculationResult clone = new CapexOpexCalculationResult();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCapex(initialObject.getCapex());
		clone.setOpex(initialObject.getOpex());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ChargeController initialObject){
		ChargeController clone = new ChargeController();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Cluster initialObject){
		Cluster clone = new Cluster();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConsumersCluster initialObject){
		ConsumersCluster clone = new ConsumersCluster();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConsumersVoltageCluster initialObject){
		ConsumersVoltageCluster clone = new ConsumersVoltageCluster();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ScenarioPossibility initialObject){
		ScenarioPossibility clone = new ScenarioPossibility();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setScenarioPossibility(initialObject.getScenarioPossibility());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(BatteryBankCell initialObject){
		BatteryBankCell clone = new BatteryBankCell();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCapacity(initialObject.getCapacity());
		clone.setElectroliteDensity(initialObject.getElectroliteDensity());
		clone.setMaxChargingCurrent(initialObject.getMaxChargingCurrent());
		clone.setMaxDischargingCurrent(initialObject.getMaxDischargingCurrent());
		clone.setMaxWorkingVoltage(initialObject.getMaxWorkingVoltage());
		clone.setMinWorkingVoltage(initialObject.getMinWorkingVoltage());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceLocation(initialObject.getPriceLocation());
		clone.setRatedChargingCurrent(initialObject.getRatedChargingCurrent());
		clone.setRatedDischargingCurrent(initialObject.getRatedDischargingCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(BatteryEnergyStorageSystem initialObject){
		BatteryEnergyStorageSystem clone = new BatteryEnergyStorageSystem();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCellsPerModuleNumber(initialObject.getCellsPerModuleNumber());
		clone.setMaxChargingCurrent(initialObject.getMaxChargingCurrent());
		clone.setMaxDischargingCurrent(initialObject.getMaxDischargingCurrent());
		clone.setMaxWorkingVoltage(initialObject.getMaxWorkingVoltage());
		clone.setMinWorkingVoltage(initialObject.getMinWorkingVoltage());
		clone.setModulesNumber(initialObject.getModulesNumber());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceLocation(initialObject.getPriceLocation());
		clone.setRatedChargingCurrent(initialObject.getRatedChargingCurrent());
		clone.setRatedDischargingCurrent(initialObject.getRatedDischargingCurrent());
		clone.setRatedP(initialObject.getRatedP());
		clone.setRatedStoredEnergy(initialObject.getRatedStoredEnergy());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Asset initialObject){
		Asset clone = new Asset();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAcceptanceTest(initialObject.getAcceptanceTest());
		clone.setCritical(initialObject.getCritical());
		clone.setElectronicAddress(initialObject.getElectronicAddress());
		clone.setInitialCondition(initialObject.getInitialCondition());
		clone.setInitialLossOfLife(initialObject.getInitialLossOfLife());
		clone.setLifecycle(initialObject.getLifecycle());
		clone.setLotNumber(initialObject.getLotNumber());
		clone.setPurchasePrice(initialObject.getPurchasePrice());
		clone.setSerialNumber(initialObject.getSerialNumber());
		clone.setStatus(initialObject.getStatus());
		clone.setType(initialObject.getType());
		clone.setUtcNumber(initialObject.getUtcNumber());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CoordinateSystem initialObject){
		CoordinateSystem clone = new CoordinateSystem();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCrsUrn(initialObject.getCrsUrn());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Location initialObject){
		Location clone = new Location();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDirection(initialObject.getDirection());
		clone.setElectronicAddress(initialObject.getElectronicAddress());
		clone.setGeoInfoReference(initialObject.getGeoInfoReference());
		clone.setMainAddress(initialObject.getMainAddress());
		clone.setPhone1(initialObject.getPhone1());
		clone.setPhone2(initialObject.getPhone2());
		clone.setSecondaryAddress(initialObject.getSecondaryAddress());
		clone.setStatus(initialObject.getStatus());
		clone.setType(initialObject.getType());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(OrganisationRole initialObject){
		OrganisationRole clone = new OrganisationRole();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Customer initialObject){
		Customer clone = new Customer();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setKind(initialObject.getKind());
		clone.setLocale(initialObject.getLocale());
		clone.setPriority(initialObject.getPriority());
		clone.setPucNumber(initialObject.getPucNumber());
		clone.setSpecialNeed(initialObject.getSpecialNeed());
		clone.setStatus(initialObject.getStatus());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Outage initialObject){
		Outage clone = new Outage();
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(AuxiliaryEquipment initialObject){
		AuxiliaryEquipment clone = new AuxiliaryEquipment();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CurrentTransformer initialObject){
		CurrentTransformer clone = new CurrentTransformer();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAccuracyClass(initialObject.getAccuracyClass());
		clone.setAccuracyLimit(initialObject.getAccuracyLimit());
		clone.setCoreBurden(initialObject.getCoreBurden());
		clone.setCtClass(initialObject.getCtClass());
		clone.setNominalRatio(initialObject.getNominalRatio());
		clone.setPrimaryRatedCurrent(initialObject.getPrimaryRatedCurrent());
		clone.setSecondaryRatedCurrent(initialObject.getSecondaryRatedCurrent());
		clone.setUsage(initialObject.getUsage());
		clone.setWindingConnectionType(initialObject.getWindingConnectionType());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PotentialTransformer initialObject){
		PotentialTransformer clone = new PotentialTransformer();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAccuracyClass(initialObject.getAccuracyClass());
		clone.setNominalRatio(initialObject.getNominalRatio());
		clone.setPrimaryRatedVoltage(initialObject.getPrimaryRatedVoltage());
		clone.setPtClass(initialObject.getPtClass());
		clone.setSecondaryRatedVoltage(initialObject.getSecondaryRatedVoltage());
		clone.setType(initialObject.getType());
		clone.setWindingConnectionType(initialObject.getWindingConnectionType());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Sensor initialObject){
		Sensor clone = new Sensor();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SurgeArrester initialObject){
		SurgeArrester clone = new SurgeArrester();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ACDCTerminal initialObject){
		ACDCTerminal clone = new ACDCTerminal();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setConnected(initialObject.getConnected());
		clone.setSequenceNumber(initialObject.getSequenceNumber());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(BaseVoltage initialObject){
		BaseVoltage clone = new BaseVoltage();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setNominalVoltage(initialObject.getNominalVoltage());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Bay initialObject){
		Bay clone = new Bay();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setBayEnergyMeasFlag(initialObject.getBayEnergyMeasFlag());
		clone.setBayPowerMeasFlag(initialObject.getBayPowerMeasFlag());
		clone.setBreakerConfiguration(initialObject.getBreakerConfiguration());
		clone.setBusBarConfiguration(initialObject.getBusBarConfiguration());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConductingEquipment initialObject){
		ConductingEquipment clone = new ConductingEquipment();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConnectivityNode initialObject){
		ConnectivityNode clone = new ConnectivityNode();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDeltaNomVoltage(initialObject.getDeltaNomVoltage());
		clone.setInitialVoltage(initialObject.getInitialVoltage());
		clone.setIsLowVoltage(initialObject.getIsLowVoltage());
		clone.setNodeType(initialObject.getNodeType());
		clone.setRastrV(initialObject.getRastrV());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConnectivityNodeContainer initialObject){
		ConnectivityNodeContainer clone = new ConnectivityNodeContainer();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Curve initialObject){
		Curve clone = new Curve();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCurveStyle(initialObject.getCurveStyle());
		clone.setXMultiplier(initialObject.getXMultiplier());
		clone.setXUnit(initialObject.getXUnit());
		clone.setY1Multiplier(initialObject.getY1Multiplier());
		clone.setY1Unit(initialObject.getY1Unit());
		clone.setY2Multiplier(initialObject.getY2Multiplier());
		clone.setY2Unit(initialObject.getY2Unit());
		clone.setY3Multiplier(initialObject.getY3Multiplier());
		clone.setY3Unit(initialObject.getY3Unit());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CurveData initialObject){
		CurveData clone = new CurveData();
		clone.setXvalue(initialObject.getXvalue());
		clone.setY1value(initialObject.getY1value());
		clone.setY2value(initialObject.getY2value());
		clone.setY3value(initialObject.getY3value());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Equipment initialObject){
		Equipment clone = new Equipment();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquipmentContainer initialObject){
		EquipmentContainer clone = new EquipmentContainer();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(GeographicalRegion initialObject){
		GeographicalRegion clone = new GeographicalRegion();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Name initialObject){
		Name clone = new Name();
		clone.setName(initialObject.getName());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(NameType initialObject){
		NameType clone = new NameType();
		clone.setDescription(initialObject.getDescription());
		clone.setName(initialObject.getName());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PowerSystemResource initialObject){
		PowerSystemResource clone = new PowerSystemResource();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ReportingGroup initialObject){
		ReportingGroup clone = new ReportingGroup();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SubGeographicalRegion initialObject){
		SubGeographicalRegion clone = new SubGeographicalRegion();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Substation initialObject){
		Substation clone = new Substation();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setType(initialObject.getType());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Terminal initialObject){
		Terminal clone = new Terminal();
		clone.setConnected(initialObject.getConnected());
		clone.setSequenceNumber(initialObject.getSequenceNumber());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setIsBelongingToEquivalent(initialObject.getIsBelongingToEquivalent());
		clone.setPhases(initialObject.getPhases());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(VoltageLevel initialObject){
		VoltageLevel clone = new VoltageLevel();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setHighVoltageLimit(initialObject.getHighVoltageLimit());
		clone.setLowVoltageLimit(initialObject.getLowVoltageLimit());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ACDCConverter initialObject){
		ACDCConverter clone = new ACDCConverter();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setBaseS(initialObject.getBaseS());
		clone.setIdc(initialObject.getIdc());
		clone.setIdleLoss(initialObject.getIdleLoss());
		clone.setMaxUdc(initialObject.getMaxUdc());
		clone.setMinUdc(initialObject.getMinUdc());
		clone.setNomUdc(initialObject.getNomUdc());
		clone.setNumberOfValves(initialObject.getNumberOfValves());
		clone.setP(initialObject.getP());
		clone.setPoleLossP(initialObject.getPoleLossP());
		clone.setQ(initialObject.getQ());
		clone.setRatedUdc(initialObject.getRatedUdc());
		clone.setResistiveLoss(initialObject.getResistiveLoss());
		clone.setSwitchingLoss(initialObject.getSwitchingLoss());
		clone.setTargetPpcc(initialObject.getTargetPpcc());
		clone.setTargetUdc(initialObject.getTargetUdc());
		clone.setUc(initialObject.getUc());
		clone.setUdc(initialObject.getUdc());
		clone.setValveU0(initialObject.getValveU0());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ACDCConverterDCTerminal initialObject){
		ACDCConverterDCTerminal clone = new ACDCConverterDCTerminal();
		clone.setConnected(initialObject.getConnected());
		clone.setSequenceNumber(initialObject.getSequenceNumber());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setPolarity(initialObject.getPolarity());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CsConverter initialObject){
		CsConverter clone = new CsConverter();
		clone.setBaseS(initialObject.getBaseS());
		clone.setIdc(initialObject.getIdc());
		clone.setIdleLoss(initialObject.getIdleLoss());
		clone.setMaxUdc(initialObject.getMaxUdc());
		clone.setMinUdc(initialObject.getMinUdc());
		clone.setNomUdc(initialObject.getNomUdc());
		clone.setNumberOfValves(initialObject.getNumberOfValves());
		clone.setP(initialObject.getP());
		clone.setPoleLossP(initialObject.getPoleLossP());
		clone.setQ(initialObject.getQ());
		clone.setRatedUdc(initialObject.getRatedUdc());
		clone.setResistiveLoss(initialObject.getResistiveLoss());
		clone.setSwitchingLoss(initialObject.getSwitchingLoss());
		clone.setTargetPpcc(initialObject.getTargetPpcc());
		clone.setTargetUdc(initialObject.getTargetUdc());
		clone.setUc(initialObject.getUc());
		clone.setUdc(initialObject.getUdc());
		clone.setValveU0(initialObject.getValveU0());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAlpha(initialObject.getAlpha());
		clone.setGamma(initialObject.getGamma());
		clone.setMaxAlpha(initialObject.getMaxAlpha());
		clone.setMaxGamma(initialObject.getMaxGamma());
		clone.setMaxIdc(initialObject.getMaxIdc());
		clone.setMinAlpha(initialObject.getMinAlpha());
		clone.setMinGamma(initialObject.getMinGamma());
		clone.setMinIdc(initialObject.getMinIdc());
		clone.setOperatingMode(initialObject.getOperatingMode());
		clone.setPPccControl(initialObject.getPPccControl());
		clone.setRatedIdc(initialObject.getRatedIdc());
		clone.setTargetAlpha(initialObject.getTargetAlpha());
		clone.setTargetGamma(initialObject.getTargetGamma());
		clone.setTargetIdc(initialObject.getTargetIdc());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCBaseTerminal initialObject){
		DCBaseTerminal clone = new DCBaseTerminal();
		clone.setConnected(initialObject.getConnected());
		clone.setSequenceNumber(initialObject.getSequenceNumber());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCBreaker initialObject){
		DCBreaker clone = new DCBreaker();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCBusbar initialObject){
		DCBusbar clone = new DCBusbar();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCChopper initialObject){
		DCChopper clone = new DCChopper();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCConductingEquipment initialObject){
		DCConductingEquipment clone = new DCConductingEquipment();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCConverterUnit initialObject){
		DCConverterUnit clone = new DCConverterUnit();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setOperationMode(initialObject.getOperationMode());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCDisconnector initialObject){
		DCDisconnector clone = new DCDisconnector();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCEquipmentContainer initialObject){
		DCEquipmentContainer clone = new DCEquipmentContainer();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCGround initialObject){
		DCGround clone = new DCGround();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCLine initialObject){
		DCLine clone = new DCLine();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCLineSegment initialObject){
		DCLineSegment clone = new DCLineSegment();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCapacitance(initialObject.getCapacitance());
		clone.setInductance(initialObject.getInductance());
		clone.setLength(initialObject.getLength());
		clone.setResistance(initialObject.getResistance());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCNode initialObject){
		DCNode clone = new DCNode();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCSeriesDevice initialObject){
		DCSeriesDevice clone = new DCSeriesDevice();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setInductance(initialObject.getInductance());
		clone.setRatedUdc(initialObject.getRatedUdc());
		clone.setResistance(initialObject.getResistance());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCShunt initialObject){
		DCShunt clone = new DCShunt();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCapacitance(initialObject.getCapacitance());
		clone.setRatedUdc(initialObject.getRatedUdc());
		clone.setResistance(initialObject.getResistance());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCSwitch initialObject){
		DCSwitch clone = new DCSwitch();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCTerminal initialObject){
		DCTerminal clone = new DCTerminal();
		clone.setConnected(initialObject.getConnected());
		clone.setSequenceNumber(initialObject.getSequenceNumber());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCTopologicalIsland initialObject){
		DCTopologicalIsland clone = new DCTopologicalIsland();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PerLengthDCLineParameter initialObject){
		PerLengthDCLineParameter clone = new PerLengthDCLineParameter();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCapacitance(initialObject.getCapacitance());
		clone.setInductance(initialObject.getInductance());
		clone.setResistance(initialObject.getResistance());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(VsCapabilityCurve initialObject){
		VsCapabilityCurve clone = new VsCapabilityCurve();
		clone.setCurveStyle(initialObject.getCurveStyle());
		clone.setXMultiplier(initialObject.getXMultiplier());
		clone.setXUnit(initialObject.getXUnit());
		clone.setY1Multiplier(initialObject.getY1Multiplier());
		clone.setY1Unit(initialObject.getY1Unit());
		clone.setY2Multiplier(initialObject.getY2Multiplier());
		clone.setY2Unit(initialObject.getY2Unit());
		clone.setY3Multiplier(initialObject.getY3Multiplier());
		clone.setY3Unit(initialObject.getY3Unit());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(VsConverter initialObject){
		VsConverter clone = new VsConverter();
		clone.setBaseS(initialObject.getBaseS());
		clone.setIdc(initialObject.getIdc());
		clone.setIdleLoss(initialObject.getIdleLoss());
		clone.setMaxUdc(initialObject.getMaxUdc());
		clone.setMinUdc(initialObject.getMinUdc());
		clone.setNomUdc(initialObject.getNomUdc());
		clone.setNumberOfValves(initialObject.getNumberOfValves());
		clone.setP(initialObject.getP());
		clone.setPoleLossP(initialObject.getPoleLossP());
		clone.setQ(initialObject.getQ());
		clone.setRatedUdc(initialObject.getRatedUdc());
		clone.setResistiveLoss(initialObject.getResistiveLoss());
		clone.setSwitchingLoss(initialObject.getSwitchingLoss());
		clone.setTargetPpcc(initialObject.getTargetPpcc());
		clone.setTargetUdc(initialObject.getTargetUdc());
		clone.setUc(initialObject.getUc());
		clone.setUdc(initialObject.getUdc());
		clone.setValveU0(initialObject.getValveU0());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDelta(initialObject.getDelta());
		clone.setDroop(initialObject.getDroop());
		clone.setDroopCompensation(initialObject.getDroopCompensation());
		clone.setMaxModulationIndex(initialObject.getMaxModulationIndex());
		clone.setMaxValveCurrent(initialObject.getMaxValveCurrent());
		clone.setPPccControl(initialObject.getPPccControl());
		clone.setQPccControl(initialObject.getQPccControl());
		clone.setQShare(initialObject.getQShare());
		clone.setTargetQpcc(initialObject.getTargetQpcc());
		clone.setTargetUpcc(initialObject.getTargetUpcc());
		clone.setUf(initialObject.getUf());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Diagram initialObject){
		Diagram clone = new Diagram();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setOrientation(initialObject.getOrientation());
		clone.setX1InitialView(initialObject.getX1InitialView());
		clone.setX2InitialView(initialObject.getX2InitialView());
		clone.setY1InitialView(initialObject.getY1InitialView());
		clone.setY2InitialView(initialObject.getY2InitialView());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DiagramObject initialObject){
		DiagramObject clone = new DiagramObject();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDrawingOrder(initialObject.getDrawingOrder());
		clone.setIsPolygon(initialObject.getIsPolygon());
		clone.setOffsetX(initialObject.getOffsetX());
		clone.setOffsetY(initialObject.getOffsetY());
		clone.setRotation(initialObject.getRotation());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DiagramObjectGluePoint initialObject){
		DiagramObjectGluePoint clone = new DiagramObjectGluePoint();
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DiagramObjectPoint initialObject){
		DiagramObjectPoint clone = new DiagramObjectPoint();
		clone.setSequenceNumber(initialObject.getSequenceNumber());
		clone.setXPosition(initialObject.getXPosition());
		clone.setYPosition(initialObject.getYPosition());
		clone.setZPosition(initialObject.getZPosition());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DiagramObjectStyle initialObject){
		DiagramObjectStyle clone = new DiagramObjectStyle();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DiagramStyle initialObject){
		DiagramStyle clone = new DiagramStyle();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TextDiagramObject initialObject){
		TextDiagramObject clone = new TextDiagramObject();
		clone.setDrawingOrder(initialObject.getDrawingOrder());
		clone.setIsPolygon(initialObject.getIsPolygon());
		clone.setOffsetX(initialObject.getOffsetX());
		clone.setOffsetY(initialObject.getOffsetY());
		clone.setRotation(initialObject.getRotation());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setText(initialObject.getText());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(VisibilityLayer initialObject){
		VisibilityLayer clone = new VisibilityLayer();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDrawingOrder(initialObject.getDrawingOrder());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquivalentBranch initialObject){
		EquivalentBranch clone = new EquivalentBranch();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setNegativeR12(initialObject.getNegativeR12());
		clone.setNegativeR21(initialObject.getNegativeR21());
		clone.setNegativeX12(initialObject.getNegativeX12());
		clone.setNegativeX21(initialObject.getNegativeX21());
		clone.setPositiveR12(initialObject.getPositiveR12());
		clone.setPositiveR21(initialObject.getPositiveR21());
		clone.setPositiveX12(initialObject.getPositiveX12());
		clone.setPositiveX21(initialObject.getPositiveX21());
		clone.setR(initialObject.getR());
		clone.setR21(initialObject.getR21());
		clone.setX(initialObject.getX());
		clone.setX21(initialObject.getX21());
		clone.setZeroR12(initialObject.getZeroR12());
		clone.setZeroR21(initialObject.getZeroR21());
		clone.setZeroX12(initialObject.getZeroX12());
		clone.setZeroX21(initialObject.getZeroX21());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquivalentEquipment initialObject){
		EquivalentEquipment clone = new EquivalentEquipment();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquivalentInjection initialObject){
		EquivalentInjection clone = new EquivalentInjection();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setMaxP(initialObject.getMaxP());
		clone.setMaxQ(initialObject.getMaxQ());
		clone.setMinP(initialObject.getMinP());
		clone.setMinQ(initialObject.getMinQ());
		clone.setP(initialObject.getP());
		clone.setQ(initialObject.getQ());
		clone.setR(initialObject.getR());
		clone.setR0(initialObject.getR0());
		clone.setR2(initialObject.getR2());
		clone.setRegulationCapability(initialObject.getRegulationCapability());
		clone.setRegulationStatus(initialObject.getRegulationStatus());
		clone.setRegulationTarget(initialObject.getRegulationTarget());
		clone.setX(initialObject.getX());
		clone.setX0(initialObject.getX0());
		clone.setX2(initialObject.getX2());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquivalentNetwork initialObject){
		EquivalentNetwork clone = new EquivalentNetwork();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquivalentShunt initialObject){
		EquivalentShunt clone = new EquivalentShunt();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setB(initialObject.getB());
		clone.setG(initialObject.getG());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EquipmentFault initialObject){
		EquipmentFault clone = new EquipmentFault();
		clone.setImpedance(initialObject.getImpedance());
		clone.setKind(initialObject.getKind());
		clone.setPhases(initialObject.getPhases());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCurrentAngle(initialObject.getCurrentAngle());
		clone.setCurrentValue(initialObject.getCurrentValue());
		clone.setRastrCurrentAngle(initialObject.getRastrCurrentAngle());
		clone.setRastrCurrentValue(initialObject.getRastrCurrentValue());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Fault initialObject){
		Fault clone = new Fault();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setImpedance(initialObject.getImpedance());
		clone.setKind(initialObject.getKind());
		clone.setPhases(initialObject.getPhases());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(FaultCauseType initialObject){
		FaultCauseType clone = new FaultCauseType();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(LineFault initialObject){
		LineFault clone = new LineFault();
		clone.setImpedance(initialObject.getImpedance());
		clone.setKind(initialObject.getKind());
		clone.setPhases(initialObject.getPhases());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setLengthFromTerminal1(initialObject.getLengthFromTerminal1());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(FossilFuel initialObject){
		FossilFuel clone = new FossilFuel();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setFossilFuelType(initialObject.getFossilFuelType());
		clone.setFuelCost(initialObject.getFuelCost());
		clone.setFuelDispatchCost(initialObject.getFuelDispatchCost());
		clone.setFuelEffFactor(initialObject.getFuelEffFactor());
		clone.setFuelHandlingCost(initialObject.getFuelHandlingCost());
		clone.setFuelHeatContent(initialObject.getFuelHeatContent());
		clone.setFuelMixture(initialObject.getFuelMixture());
		clone.setFuelSulfur(initialObject.getFuelSulfur());
		clone.setHighBreakpointP(initialObject.getHighBreakpointP());
		clone.setLowBreakpointP(initialObject.getLowBreakpointP());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(GeneratingUnit initialObject){
		GeneratingUnit clone = new GeneratingUnit();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAllocSpinResP(initialObject.getAllocSpinResP());
		clone.setAutoCntrlMarginP(initialObject.getAutoCntrlMarginP());
		clone.setBaseP(initialObject.getBaseP());
		clone.setControlDeadband(initialObject.getControlDeadband());
		clone.setControlPulseHigh(initialObject.getControlPulseHigh());
		clone.setControlPulseLow(initialObject.getControlPulseLow());
		clone.setControlResponseRate(initialObject.getControlResponseRate());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setGenControlMode(initialObject.getGenControlMode());
		clone.setGenControlSource(initialObject.getGenControlSource());
		clone.setGovernorMPL(initialObject.getGovernorMPL());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setHighControlLimit(initialObject.getHighControlLimit());
		clone.setInitialP(initialObject.getInitialP());
		clone.setLongPF(initialObject.getLongPF());
		clone.setLowControlLimit(initialObject.getLowControlLimit());
		clone.setLowerRampRate(initialObject.getLowerRampRate());
		clone.setMaxEconomicP(initialObject.getMaxEconomicP());
		clone.setMaximumAllowableSpinningReserve(initialObject.getMaximumAllowableSpinningReserve());
		clone.setMaxOperatingP(initialObject.getMaxOperatingP());
		clone.setMinEconomicP(initialObject.getMinEconomicP());
		clone.setMinimumOffTime(initialObject.getMinimumOffTime());
		clone.setMinOperatingP(initialObject.getMinOperatingP());
		clone.setModelDetail(initialObject.getModelDetail());
		clone.setNominalP(initialObject.getNominalP());
		clone.setNormalPF(initialObject.getNormalPF());
		clone.setPenaltyFactor(initialObject.getPenaltyFactor());
		clone.setRaiseRampRate(initialObject.getRaiseRampRate());
		clone.setRatedGrossMaxP(initialObject.getRatedGrossMaxP());
		clone.setRatedGrossMinP(initialObject.getRatedGrossMinP());
		clone.setRatedNetMaxP(initialObject.getRatedNetMaxP());
		clone.setShortPF(initialObject.getShortPF());
		clone.setStartupCost(initialObject.getStartupCost());
		clone.setStartupTime(initialObject.getStartupTime());
		clone.setTieLinePF(initialObject.getTieLinePF());
		clone.setTotalEfficiency(initialObject.getTotalEfficiency());
		clone.setVariableCost(initialObject.getVariableCost());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(HydroGeneratingUnit initialObject){
		HydroGeneratingUnit clone = new HydroGeneratingUnit();
		clone.setAllocSpinResP(initialObject.getAllocSpinResP());
		clone.setAutoCntrlMarginP(initialObject.getAutoCntrlMarginP());
		clone.setBaseP(initialObject.getBaseP());
		clone.setControlDeadband(initialObject.getControlDeadband());
		clone.setControlPulseHigh(initialObject.getControlPulseHigh());
		clone.setControlPulseLow(initialObject.getControlPulseLow());
		clone.setControlResponseRate(initialObject.getControlResponseRate());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setGenControlMode(initialObject.getGenControlMode());
		clone.setGenControlSource(initialObject.getGenControlSource());
		clone.setGovernorMPL(initialObject.getGovernorMPL());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setHighControlLimit(initialObject.getHighControlLimit());
		clone.setInitialP(initialObject.getInitialP());
		clone.setLongPF(initialObject.getLongPF());
		clone.setLowControlLimit(initialObject.getLowControlLimit());
		clone.setLowerRampRate(initialObject.getLowerRampRate());
		clone.setMaxEconomicP(initialObject.getMaxEconomicP());
		clone.setMaximumAllowableSpinningReserve(initialObject.getMaximumAllowableSpinningReserve());
		clone.setMaxOperatingP(initialObject.getMaxOperatingP());
		clone.setMinEconomicP(initialObject.getMinEconomicP());
		clone.setMinimumOffTime(initialObject.getMinimumOffTime());
		clone.setMinOperatingP(initialObject.getMinOperatingP());
		clone.setModelDetail(initialObject.getModelDetail());
		clone.setNominalP(initialObject.getNominalP());
		clone.setNormalPF(initialObject.getNormalPF());
		clone.setPenaltyFactor(initialObject.getPenaltyFactor());
		clone.setRaiseRampRate(initialObject.getRaiseRampRate());
		clone.setRatedGrossMaxP(initialObject.getRatedGrossMaxP());
		clone.setRatedGrossMinP(initialObject.getRatedGrossMinP());
		clone.setRatedNetMaxP(initialObject.getRatedNetMaxP());
		clone.setShortPF(initialObject.getShortPF());
		clone.setStartupCost(initialObject.getStartupCost());
		clone.setStartupTime(initialObject.getStartupTime());
		clone.setTieLinePF(initialObject.getTieLinePF());
		clone.setTotalEfficiency(initialObject.getTotalEfficiency());
		clone.setVariableCost(initialObject.getVariableCost());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setEnergyConversionCapability(initialObject.getEnergyConversionCapability());
		clone.setHydroUnitWaterCost(initialObject.getHydroUnitWaterCost());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(HydroPowerPlant initialObject){
		HydroPowerPlant clone = new HydroPowerPlant();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDischargeTravelDelay(initialObject.getDischargeTravelDelay());
		clone.setGenRatedP(initialObject.getGenRatedP());
		clone.setHydroPlantStorageType(initialObject.getHydroPlantStorageType());
		clone.setPenstockType(initialObject.getPenstockType());
		clone.setPlantDischargeCapacity(initialObject.getPlantDischargeCapacity());
		clone.setPlantRatedHead(initialObject.getPlantRatedHead());
		clone.setPumpRatedP(initialObject.getPumpRatedP());
		clone.setSurgeTankCode(initialObject.getSurgeTankCode());
		clone.setSurgeTankCrestLevel(initialObject.getSurgeTankCrestLevel());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(HydroPump initialObject){
		HydroPump clone = new HydroPump();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setPumpDischAtMaxHead(initialObject.getPumpDischAtMaxHead());
		clone.setPumpDischAtMinHead(initialObject.getPumpDischAtMinHead());
		clone.setPumpPowerAtMaxHead(initialObject.getPumpPowerAtMaxHead());
		clone.setPumpPowerAtMinHead(initialObject.getPumpPowerAtMinHead());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(NuclearGeneratingUnit initialObject){
		NuclearGeneratingUnit clone = new NuclearGeneratingUnit();
		clone.setAllocSpinResP(initialObject.getAllocSpinResP());
		clone.setAutoCntrlMarginP(initialObject.getAutoCntrlMarginP());
		clone.setBaseP(initialObject.getBaseP());
		clone.setControlDeadband(initialObject.getControlDeadband());
		clone.setControlPulseHigh(initialObject.getControlPulseHigh());
		clone.setControlPulseLow(initialObject.getControlPulseLow());
		clone.setControlResponseRate(initialObject.getControlResponseRate());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setGenControlMode(initialObject.getGenControlMode());
		clone.setGenControlSource(initialObject.getGenControlSource());
		clone.setGovernorMPL(initialObject.getGovernorMPL());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setHighControlLimit(initialObject.getHighControlLimit());
		clone.setInitialP(initialObject.getInitialP());
		clone.setLongPF(initialObject.getLongPF());
		clone.setLowControlLimit(initialObject.getLowControlLimit());
		clone.setLowerRampRate(initialObject.getLowerRampRate());
		clone.setMaxEconomicP(initialObject.getMaxEconomicP());
		clone.setMaximumAllowableSpinningReserve(initialObject.getMaximumAllowableSpinningReserve());
		clone.setMaxOperatingP(initialObject.getMaxOperatingP());
		clone.setMinEconomicP(initialObject.getMinEconomicP());
		clone.setMinimumOffTime(initialObject.getMinimumOffTime());
		clone.setMinOperatingP(initialObject.getMinOperatingP());
		clone.setModelDetail(initialObject.getModelDetail());
		clone.setNominalP(initialObject.getNominalP());
		clone.setNormalPF(initialObject.getNormalPF());
		clone.setPenaltyFactor(initialObject.getPenaltyFactor());
		clone.setRaiseRampRate(initialObject.getRaiseRampRate());
		clone.setRatedGrossMaxP(initialObject.getRatedGrossMaxP());
		clone.setRatedGrossMinP(initialObject.getRatedGrossMinP());
		clone.setRatedNetMaxP(initialObject.getRatedNetMaxP());
		clone.setShortPF(initialObject.getShortPF());
		clone.setStartupCost(initialObject.getStartupCost());
		clone.setStartupTime(initialObject.getStartupTime());
		clone.setTieLinePF(initialObject.getTieLinePF());
		clone.setTotalEfficiency(initialObject.getTotalEfficiency());
		clone.setVariableCost(initialObject.getVariableCost());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SolarGeneratingUnit initialObject){
		SolarGeneratingUnit clone = new SolarGeneratingUnit();
		clone.setAllocSpinResP(initialObject.getAllocSpinResP());
		clone.setAutoCntrlMarginP(initialObject.getAutoCntrlMarginP());
		clone.setBaseP(initialObject.getBaseP());
		clone.setControlDeadband(initialObject.getControlDeadband());
		clone.setControlPulseHigh(initialObject.getControlPulseHigh());
		clone.setControlPulseLow(initialObject.getControlPulseLow());
		clone.setControlResponseRate(initialObject.getControlResponseRate());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setGenControlMode(initialObject.getGenControlMode());
		clone.setGenControlSource(initialObject.getGenControlSource());
		clone.setGovernorMPL(initialObject.getGovernorMPL());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setHighControlLimit(initialObject.getHighControlLimit());
		clone.setInitialP(initialObject.getInitialP());
		clone.setLongPF(initialObject.getLongPF());
		clone.setLowControlLimit(initialObject.getLowControlLimit());
		clone.setLowerRampRate(initialObject.getLowerRampRate());
		clone.setMaxEconomicP(initialObject.getMaxEconomicP());
		clone.setMaximumAllowableSpinningReserve(initialObject.getMaximumAllowableSpinningReserve());
		clone.setMaxOperatingP(initialObject.getMaxOperatingP());
		clone.setMinEconomicP(initialObject.getMinEconomicP());
		clone.setMinimumOffTime(initialObject.getMinimumOffTime());
		clone.setMinOperatingP(initialObject.getMinOperatingP());
		clone.setModelDetail(initialObject.getModelDetail());
		clone.setNominalP(initialObject.getNominalP());
		clone.setNormalPF(initialObject.getNormalPF());
		clone.setPenaltyFactor(initialObject.getPenaltyFactor());
		clone.setRaiseRampRate(initialObject.getRaiseRampRate());
		clone.setRatedGrossMaxP(initialObject.getRatedGrossMaxP());
		clone.setRatedGrossMinP(initialObject.getRatedGrossMinP());
		clone.setRatedNetMaxP(initialObject.getRatedNetMaxP());
		clone.setShortPF(initialObject.getShortPF());
		clone.setStartupCost(initialObject.getStartupCost());
		clone.setStartupTime(initialObject.getStartupTime());
		clone.setTieLinePF(initialObject.getTieLinePF());
		clone.setTotalEfficiency(initialObject.getTotalEfficiency());
		clone.setVariableCost(initialObject.getVariableCost());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setPriceLocation(initialObject.getPriceLocation());
		clone.setPriceProject(initialObject.getPriceProject());
		clone.setPriceSunPanel(initialObject.getPriceSunPanel());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ThermalGeneratingUnit initialObject){
		ThermalGeneratingUnit clone = new ThermalGeneratingUnit();
		clone.setAllocSpinResP(initialObject.getAllocSpinResP());
		clone.setAutoCntrlMarginP(initialObject.getAutoCntrlMarginP());
		clone.setBaseP(initialObject.getBaseP());
		clone.setControlDeadband(initialObject.getControlDeadband());
		clone.setControlPulseHigh(initialObject.getControlPulseHigh());
		clone.setControlPulseLow(initialObject.getControlPulseLow());
		clone.setControlResponseRate(initialObject.getControlResponseRate());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setGenControlMode(initialObject.getGenControlMode());
		clone.setGenControlSource(initialObject.getGenControlSource());
		clone.setGovernorMPL(initialObject.getGovernorMPL());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setHighControlLimit(initialObject.getHighControlLimit());
		clone.setInitialP(initialObject.getInitialP());
		clone.setLongPF(initialObject.getLongPF());
		clone.setLowControlLimit(initialObject.getLowControlLimit());
		clone.setLowerRampRate(initialObject.getLowerRampRate());
		clone.setMaxEconomicP(initialObject.getMaxEconomicP());
		clone.setMaximumAllowableSpinningReserve(initialObject.getMaximumAllowableSpinningReserve());
		clone.setMaxOperatingP(initialObject.getMaxOperatingP());
		clone.setMinEconomicP(initialObject.getMinEconomicP());
		clone.setMinimumOffTime(initialObject.getMinimumOffTime());
		clone.setMinOperatingP(initialObject.getMinOperatingP());
		clone.setModelDetail(initialObject.getModelDetail());
		clone.setNominalP(initialObject.getNominalP());
		clone.setNormalPF(initialObject.getNormalPF());
		clone.setPenaltyFactor(initialObject.getPenaltyFactor());
		clone.setRaiseRampRate(initialObject.getRaiseRampRate());
		clone.setRatedGrossMaxP(initialObject.getRatedGrossMaxP());
		clone.setRatedGrossMinP(initialObject.getRatedGrossMinP());
		clone.setRatedNetMaxP(initialObject.getRatedNetMaxP());
		clone.setShortPF(initialObject.getShortPF());
		clone.setStartupCost(initialObject.getStartupCost());
		clone.setStartupTime(initialObject.getStartupTime());
		clone.setTieLinePF(initialObject.getTieLinePF());
		clone.setTotalEfficiency(initialObject.getTotalEfficiency());
		clone.setVariableCost(initialObject.getVariableCost());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setOMCost(initialObject.getOMCost());
		clone.setPriceBuilding(initialObject.getPriceBuilding());
		clone.setPriceProject(initialObject.getPriceProject());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(WindGeneratingUnit initialObject){
		WindGeneratingUnit clone = new WindGeneratingUnit();
		clone.setAllocSpinResP(initialObject.getAllocSpinResP());
		clone.setAutoCntrlMarginP(initialObject.getAutoCntrlMarginP());
		clone.setBaseP(initialObject.getBaseP());
		clone.setControlDeadband(initialObject.getControlDeadband());
		clone.setControlPulseHigh(initialObject.getControlPulseHigh());
		clone.setControlPulseLow(initialObject.getControlPulseLow());
		clone.setControlResponseRate(initialObject.getControlResponseRate());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setGenControlMode(initialObject.getGenControlMode());
		clone.setGenControlSource(initialObject.getGenControlSource());
		clone.setGovernorMPL(initialObject.getGovernorMPL());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setHighControlLimit(initialObject.getHighControlLimit());
		clone.setInitialP(initialObject.getInitialP());
		clone.setLongPF(initialObject.getLongPF());
		clone.setLowControlLimit(initialObject.getLowControlLimit());
		clone.setLowerRampRate(initialObject.getLowerRampRate());
		clone.setMaxEconomicP(initialObject.getMaxEconomicP());
		clone.setMaximumAllowableSpinningReserve(initialObject.getMaximumAllowableSpinningReserve());
		clone.setMaxOperatingP(initialObject.getMaxOperatingP());
		clone.setMinEconomicP(initialObject.getMinEconomicP());
		clone.setMinimumOffTime(initialObject.getMinimumOffTime());
		clone.setMinOperatingP(initialObject.getMinOperatingP());
		clone.setModelDetail(initialObject.getModelDetail());
		clone.setNominalP(initialObject.getNominalP());
		clone.setNormalPF(initialObject.getNormalPF());
		clone.setPenaltyFactor(initialObject.getPenaltyFactor());
		clone.setRaiseRampRate(initialObject.getRaiseRampRate());
		clone.setRatedGrossMaxP(initialObject.getRatedGrossMaxP());
		clone.setRatedGrossMinP(initialObject.getRatedGrossMinP());
		clone.setRatedNetMaxP(initialObject.getRatedNetMaxP());
		clone.setShortPF(initialObject.getShortPF());
		clone.setStartupCost(initialObject.getStartupCost());
		clone.setStartupTime(initialObject.getStartupTime());
		clone.setTieLinePF(initialObject.getTieLinePF());
		clone.setTotalEfficiency(initialObject.getTotalEfficiency());
		clone.setVariableCost(initialObject.getVariableCost());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setWindGenUnitType(initialObject.getWindGenUnitType());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConformLoad initialObject){
		ConformLoad clone = new ConformLoad();
		clone.setClusterLabel(initialObject.getClusterLabel());
		clone.setCustomerCount(initialObject.getCustomerCount());
		clone.setGrounded(initialObject.getGrounded());
		clone.setIsOutLier(initialObject.getIsOutLier());
		clone.setIsTransformerNeedToConnectToSubstation(initialObject.getIsTransformerNeedToConnectToSubstation());
		clone.setP(initialObject.getP());
		clone.setPfixed(initialObject.getPfixed());
		clone.setPfixedPct(initialObject.getPfixedPct());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setQ(initialObject.getQ());
		clone.setQfixed(initialObject.getQfixed());
		clone.setQfixedPct(initialObject.getQfixedPct());
		clone.setSubstationPreferredVoltage(initialObject.getSubstationPreferredVoltage());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setPMaxSummerLoad(initialObject.getPMaxSummerLoad());
		clone.setPMaxWinterLoad(initialObject.getPMaxWinterLoad());
		clone.setPMinSummerLoad(initialObject.getPMinSummerLoad());
		clone.setPMinWinterLoad(initialObject.getPMinWinterLoad());
		clone.setQMaxSummerLoad(initialObject.getQMaxSummerLoad());
		clone.setQMaxWinterLoad(initialObject.getQMaxWinterLoad());
		clone.setQMinSummerLoad(initialObject.getQMinSummerLoad());
		clone.setQMinWinterLoad(initialObject.getQMinWinterLoad());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ConformLoadGroup initialObject){
		ConformLoadGroup clone = new ConformLoadGroup();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EnergyArea initialObject){
		EnergyArea clone = new EnergyArea();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(LoadGroup initialObject){
		LoadGroup clone = new LoadGroup();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(LoadResponseCharacteristic initialObject){
		LoadResponseCharacteristic clone = new LoadResponseCharacteristic();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setExponentModel(initialObject.getExponentModel());
		clone.setPConstantCurrent(initialObject.getPConstantCurrent());
		clone.setPConstantImpedance(initialObject.getPConstantImpedance());
		clone.setPConstantPower(initialObject.getPConstantPower());
		clone.setPFrequencyExponent(initialObject.getPFrequencyExponent());
		clone.setPVoltageExponent(initialObject.getPVoltageExponent());
		clone.setQConstantCurrent(initialObject.getQConstantCurrent());
		clone.setQConstantImpedance(initialObject.getQConstantImpedance());
		clone.setQConstantPower(initialObject.getQConstantPower());
		clone.setQFrequencyExponent(initialObject.getQFrequencyExponent());
		clone.setQVoltageExponent(initialObject.getQVoltageExponent());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(NonConformLoad initialObject){
		NonConformLoad clone = new NonConformLoad();
		clone.setClusterLabel(initialObject.getClusterLabel());
		clone.setCustomerCount(initialObject.getCustomerCount());
		clone.setGrounded(initialObject.getGrounded());
		clone.setIsOutLier(initialObject.getIsOutLier());
		clone.setIsTransformerNeedToConnectToSubstation(initialObject.getIsTransformerNeedToConnectToSubstation());
		clone.setP(initialObject.getP());
		clone.setPfixed(initialObject.getPfixed());
		clone.setPfixedPct(initialObject.getPfixedPct());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setQ(initialObject.getQ());
		clone.setQfixed(initialObject.getQfixed());
		clone.setQfixedPct(initialObject.getQfixedPct());
		clone.setSubstationPreferredVoltage(initialObject.getSubstationPreferredVoltage());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(NonConformLoadGroup initialObject){
		NonConformLoadGroup clone = new NonConformLoadGroup();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(StationSupply initialObject){
		StationSupply clone = new StationSupply();
		clone.setClusterLabel(initialObject.getClusterLabel());
		clone.setCustomerCount(initialObject.getCustomerCount());
		clone.setGrounded(initialObject.getGrounded());
		clone.setIsOutLier(initialObject.getIsOutLier());
		clone.setIsTransformerNeedToConnectToSubstation(initialObject.getIsTransformerNeedToConnectToSubstation());
		clone.setP(initialObject.getP());
		clone.setPfixed(initialObject.getPfixed());
		clone.setPfixedPct(initialObject.getPfixedPct());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setQ(initialObject.getQ());
		clone.setQfixed(initialObject.getQfixed());
		clone.setQfixedPct(initialObject.getQfixedPct());
		clone.setSubstationPreferredVoltage(initialObject.getSubstationPreferredVoltage());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Limit initialObject){
		Limit clone = new Limit();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(LimitSet initialObject){
		LimitSet clone = new LimitSet();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setIsPercentageLimits(initialObject.getIsPercentageLimits());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DistanceRelay initialObject){
		DistanceRelay clone = new DistanceRelay();
		clone.setACLineSegmentForkOneScCurrentMin(initialObject.getACLineSegmentForkOneScCurrentMin());
		clone.setACLineSegmentForkTwoScCurrentMin(initialObject.getACLineSegmentForkTwoScCurrentMin());
		clone.setHighLimit(initialObject.getHighLimit());
		clone.setKoefOfcurrentDistributionForOnePhaseSCLine(initialObject.getKoefOfcurrentDistributionForOnePhaseSCLine());
		clone.setKoefOfcurrentDistributionForTwoPhaseSCLine(initialObject.getKoefOfcurrentDistributionForTwoPhaseSCLine());
		clone.setKoefOfcurrentDistributionForTwoPhaseSCTransformer(initialObject.getKoefOfcurrentDistributionForTwoPhaseSCTransformer());
		clone.setLowLimit(initialObject.getLowLimit());
		clone.setMaxLoadFlowCurrent(initialObject.getMaxLoadFlowCurrent());
		clone.setMaxSCCurrentPhaseInMainAreaForSensitivity(initialObject.getMaxSCCurrentPhaseInMainAreaForSensitivity());
		clone.setMaxScPhInMainArea(initialObject.getMaxScPhInMainArea());
		clone.setMaxScSeqInMainArea(initialObject.getMaxScSeqInMainArea());
		clone.setMaxVoltageFromBeginingOfMainArea(initialObject.getMaxVoltageFromBeginingOfMainArea());
		clone.setMinScPhInMainArea(initialObject.getMinScPhInMainArea());
		clone.setMinScSeqInMainArea(initialObject.getMinScSeqInMainArea());
		clone.setMinVoltageFromBeginingOfMainArea(initialObject.getMinVoltageFromBeginingOfMainArea());
		clone.setPowerDirectionFlag(initialObject.getPowerDirectionFlag());
		clone.setPowerTransformerForkHVThreeSCCurrentMax(initialObject.getPowerTransformerForkHVThreeSCCurrentMax());
		clone.setPowerTransformerForkHVTwoSCCurrentMin(initialObject.getPowerTransformerForkHVTwoSCCurrentMin());
		clone.setPowerTransformerForkLVThreeSCCurrentMax(initialObject.getPowerTransformerForkLVThreeSCCurrentMax());
		clone.setPowerTransformerForkLVTwoSCCurrentMin(initialObject.getPowerTransformerForkLVTwoSCCurrentMin());
		clone.setProtectionType(initialObject.getProtectionType());
		clone.setRelayDelayTime(initialObject.getRelayDelayTime());
		clone.setSensitivityKoef1(initialObject.getSensitivityKoef1());
		clone.setSensitivityKoef2(initialObject.getSensitivityKoef2());
		clone.setSensitivityKoef3(initialObject.getSensitivityKoef3());
		clone.setSensitivityKoef4(initialObject.getSensitivityKoef4());
		clone.setSensitivityKoef5(initialObject.getSensitivityKoef5());
		clone.setTripTimeOfAdjacentProtection(initialObject.getTripTimeOfAdjacentProtection());
		clone.setUnitMultiplier(initialObject.getUnitMultiplier());
		clone.setUnitSymbol(initialObject.getUnitSymbol());
		clone.setVendor(initialObject.getVendor());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setI0Set(initialObject.getI0Set());
		clone.setISetInsensetive(initialObject.getISetInsensetive());
		clone.setISetSensetive(initialObject.getISetSensetive());
		clone.setKSensetivityPG1(initialObject.getKSensetivityPG1());
		clone.setKSensetivityPG2(initialObject.getKSensetivityPG2());
		clone.setListKSensetivityPG3(initialObject.getListKSensetivityPG3());
		clone.setRCenterSet3(initialObject.getRCutOutSet3());
		clone.setRCutOutSet3(initialObject.getRCutOutSet3());
		clone.setRPGSet1(initialObject.getRPGSet1());
		clone.setRPGSet2(initialObject.getRPGSet2());
		clone.setRPPSet1(initialObject.getRPPSet1());
		clone.setRPPSet2(initialObject.getRPPSet2());
		clone.setTgAngDetuneSet3(initialObject.getTgAngDetuneSet3());
		clone.setTOpSet1(initialObject.getTOpSet1());
		clone.setTOpSet2(initialObject.getTOpSet2());
		clone.setTOpSet3(initialObject.getTOpSet3());
		clone.setUSetSensetive(initialObject.getUSetSensetive());
		clone.setXCenterSet3(initialObject.getXCenterSet3());
		clone.setXSet1(initialObject.getXSet1());
		clone.setXSet2(initialObject.getXSet2());
		clone.setZSet3(initialObject.getZSet3());
		clone.setСalculationSequence(initialObject.getСalculationSequence());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CurrentRelay initialObject){
		CurrentRelay clone = new CurrentRelay();
		clone.setACLineSegmentForkOneScCurrentMin(initialObject.getACLineSegmentForkOneScCurrentMin());
		clone.setACLineSegmentForkTwoScCurrentMin(initialObject.getACLineSegmentForkTwoScCurrentMin());
		clone.setHighLimit(initialObject.getHighLimit());
		clone.setKoefOfcurrentDistributionForOnePhaseSCLine(initialObject.getKoefOfcurrentDistributionForOnePhaseSCLine());
		clone.setKoefOfcurrentDistributionForTwoPhaseSCLine(initialObject.getKoefOfcurrentDistributionForTwoPhaseSCLine());
		clone.setKoefOfcurrentDistributionForTwoPhaseSCTransformer(initialObject.getKoefOfcurrentDistributionForTwoPhaseSCTransformer());
		clone.setLowLimit(initialObject.getLowLimit());
		clone.setMaxLoadFlowCurrent(initialObject.getMaxLoadFlowCurrent());
		clone.setMaxSCCurrentPhaseInMainAreaForSensitivity(initialObject.getMaxSCCurrentPhaseInMainAreaForSensitivity());
		clone.setMaxScPhInMainArea(initialObject.getMaxScPhInMainArea());
		clone.setMaxScSeqInMainArea(initialObject.getMaxScSeqInMainArea());
		clone.setMaxVoltageFromBeginingOfMainArea(initialObject.getMaxVoltageFromBeginingOfMainArea());
		clone.setMinScPhInMainArea(initialObject.getMinScPhInMainArea());
		clone.setMinScSeqInMainArea(initialObject.getMinScSeqInMainArea());
		clone.setMinVoltageFromBeginingOfMainArea(initialObject.getMinVoltageFromBeginingOfMainArea());
		clone.setPowerDirectionFlag(initialObject.getPowerDirectionFlag());
		clone.setPowerTransformerForkHVThreeSCCurrentMax(initialObject.getPowerTransformerForkHVThreeSCCurrentMax());
		clone.setPowerTransformerForkHVTwoSCCurrentMin(initialObject.getPowerTransformerForkHVTwoSCCurrentMin());
		clone.setPowerTransformerForkLVThreeSCCurrentMax(initialObject.getPowerTransformerForkLVThreeSCCurrentMax());
		clone.setPowerTransformerForkLVTwoSCCurrentMin(initialObject.getPowerTransformerForkLVTwoSCCurrentMin());
		clone.setProtectionType(initialObject.getProtectionType());
		clone.setRelayDelayTime(initialObject.getRelayDelayTime());
		clone.setSensitivityKoef1(initialObject.getSensitivityKoef1());
		clone.setSensitivityKoef2(initialObject.getSensitivityKoef2());
		clone.setSensitivityKoef3(initialObject.getSensitivityKoef3());
		clone.setSensitivityKoef4(initialObject.getSensitivityKoef4());
		clone.setSensitivityKoef5(initialObject.getSensitivityKoef5());
		clone.setTripTimeOfAdjacentProtection(initialObject.getTripTimeOfAdjacentProtection());
		clone.setUnitMultiplier(initialObject.getUnitMultiplier());
		clone.setUnitSymbol(initialObject.getUnitSymbol());
		clone.setVendor(initialObject.getVendor());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCurrentForCalculationNegSeqStep1(initialObject.getCurrentForCalculationNegSeqStep1());
		clone.setCurrentForCalculationNegSeqStep2(initialObject.getCurrentForCalculationNegSeqStep2());
		clone.setCurrentForCalculationNegSeqStep3(initialObject.getCurrentForCalculationNegSeqStep3());
		clone.setCurrentForCalculationPosSeqStep1(initialObject.getCurrentForCalculationPosSeqStep1());
		clone.setCurrentForCalculationPosSeqStep2(initialObject.getCurrentForCalculationPosSeqStep2());
		clone.setCurrentForCalculationPosSeqStep3(initialObject.getCurrentForCalculationPosSeqStep3());
		clone.setCurrentForCalculationZeroSeqStep1(initialObject.getCurrentForCalculationZeroSeqStep1());
		clone.setCurrentForCalculationZeroSeqStep2(initialObject.getCurrentForCalculationZeroSeqStep2());
		clone.setCurrentForCalculationZeroSeqStep3(initialObject.getCurrentForCalculationZeroSeqStep3());
		clone.setCurrentLimit1(initialObject.getCurrentLimit1());
		clone.setCurrentLimit2(initialObject.getCurrentLimit2());
		clone.setCurrentLimit3(initialObject.getCurrentLimit3());
		clone.setCurrentLimit4(initialObject.getCurrentLimit4());
		clone.setCurrentLimit5(initialObject.getCurrentLimit5());
		clone.setCurrentOfAdjacentProtectionStep1(initialObject.getCurrentOfAdjacentProtectionStep1());
		clone.setCurrentOfAdjacentProtectionStep2(initialObject.getCurrentOfAdjacentProtectionStep2());
		clone.setCurrentOfAdjacentProtectionStep3(initialObject.getCurrentOfAdjacentProtectionStep3());
		clone.setInverseTimeFlag(initialObject.getInverseTimeFlag());
		clone.setKoefOfcurrentDistributionForStep1(initialObject.getKoefOfcurrentDistributionForStep1());
		clone.setKoefOfcurrentDistributionForStep2(initialObject.getKoefOfcurrentDistributionForStep2());
		clone.setKoefOfcurrentDistributionForStep3(initialObject.getKoefOfcurrentDistributionForStep3());
		clone.setPowerTransformerForkNominalCurrent(initialObject.getPowerTransformerForkNominalCurrent());
		clone.setTimeDelay1(initialObject.getTimeDelay1());
		clone.setTimeDelay2(initialObject.getTimeDelay2());
		clone.setTimeDelay3(initialObject.getTimeDelay3());
		clone.setTimeDelay4(initialObject.getTimeDelay4());
		clone.setTimeDelay5(initialObject.getTimeDelay5());
		clone.setVoltageForCalculationNegSeqStep1(initialObject.getVoltageForCalculationNegSeqStep1());
		clone.setVoltageForCalculationNegSeqStep2(initialObject.getVoltageForCalculationNegSeqStep2());
		clone.setVoltageForCalculationNegSeqStep3(initialObject.getVoltageForCalculationNegSeqStep3());
		clone.setVoltageForCalculationPosSeqStep1(initialObject.getVoltageForCalculationPosSeqStep1());
		clone.setVoltageForCalculationPosSeqStep2(initialObject.getVoltageForCalculationPosSeqStep2());
		clone.setVoltageForCalculationPosSeqStep3(initialObject.getVoltageForCalculationPosSeqStep3());
		clone.setVoltageForCalculationZeroSeqStep1(initialObject.getVoltageForCalculationZeroSeqStep1());
		clone.setVoltageForCalculationZeroSeqStep2(initialObject.getVoltageForCalculationZeroSeqStep2());
		clone.setVoltageForCalculationZeroSeqStep3(initialObject.getVoltageForCalculationZeroSeqStep3());
		clone.setVoltageLimit1(initialObject.getVoltageLimit1());
		clone.setVoltageLimit2(initialObject.getVoltageLimit2());
		clone.setVoltageLimit3(initialObject.getVoltageLimit3());
		clone.setVoltageOfAdjacentProtectionStep1(initialObject.getVoltageOfAdjacentProtectionStep1());
		clone.setVoltageOfAdjacentProtectionStep2(initialObject.getVoltageOfAdjacentProtectionStep2());
		clone.setVoltageOfAdjacentProtectionStep3(initialObject.getVoltageOfAdjacentProtectionStep3());
		clone.setСalculationSequence(initialObject.getСalculationSequence());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ProtectionEquipment initialObject){
		ProtectionEquipment clone = new ProtectionEquipment();
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setACLineSegmentForkOneScCurrentMin(initialObject.getACLineSegmentForkOneScCurrentMin());
		clone.setACLineSegmentForkTwoScCurrentMin(initialObject.getACLineSegmentForkTwoScCurrentMin());
		clone.setHighLimit(initialObject.getHighLimit());
		clone.setKoefOfcurrentDistributionForOnePhaseSCLine(initialObject.getKoefOfcurrentDistributionForOnePhaseSCLine());
		clone.setKoefOfcurrentDistributionForTwoPhaseSCLine(initialObject.getKoefOfcurrentDistributionForTwoPhaseSCLine());
		clone.setKoefOfcurrentDistributionForTwoPhaseSCTransformer(initialObject.getKoefOfcurrentDistributionForTwoPhaseSCTransformer());
		clone.setLowLimit(initialObject.getLowLimit());
		clone.setMaxLoadFlowCurrent(initialObject.getMaxLoadFlowCurrent());
		clone.setMaxSCCurrentPhaseInMainAreaForSensitivity(initialObject.getMaxSCCurrentPhaseInMainAreaForSensitivity());
		clone.setMaxScPhInMainArea(initialObject.getMaxScPhInMainArea());
		clone.setMaxScSeqInMainArea(initialObject.getMaxScSeqInMainArea());
		clone.setMaxVoltageFromBeginingOfMainArea(initialObject.getMaxVoltageFromBeginingOfMainArea());
		clone.setMinScPhInMainArea(initialObject.getMinScPhInMainArea());
		clone.setMinScSeqInMainArea(initialObject.getMinScSeqInMainArea());
		clone.setMinVoltageFromBeginingOfMainArea(initialObject.getMinVoltageFromBeginingOfMainArea());
		clone.setPowerDirectionFlag(initialObject.getPowerDirectionFlag());
		clone.setPowerTransformerForkHVThreeSCCurrentMax(initialObject.getPowerTransformerForkHVThreeSCCurrentMax());
		clone.setPowerTransformerForkHVTwoSCCurrentMin(initialObject.getPowerTransformerForkHVTwoSCCurrentMin());
		clone.setPowerTransformerForkLVThreeSCCurrentMax(initialObject.getPowerTransformerForkLVThreeSCCurrentMax());
		clone.setPowerTransformerForkLVTwoSCCurrentMin(initialObject.getPowerTransformerForkLVTwoSCCurrentMin());
		clone.setProtectionType(initialObject.getProtectionType());
		clone.setRelayDelayTime(initialObject.getRelayDelayTime());
		clone.setSensitivityKoef1(initialObject.getSensitivityKoef1());
		clone.setSensitivityKoef2(initialObject.getSensitivityKoef2());
		clone.setSensitivityKoef3(initialObject.getSensitivityKoef3());
		clone.setSensitivityKoef4(initialObject.getSensitivityKoef4());
		clone.setSensitivityKoef5(initialObject.getSensitivityKoef5());
		clone.setTripTimeOfAdjacentProtection(initialObject.getTripTimeOfAdjacentProtection());
		clone.setUnitMultiplier(initialObject.getUnitMultiplier());
		clone.setUnitSymbol(initialObject.getUnitSymbol());
		clone.setVendor(initialObject.getVendor());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RecloseSequence initialObject){
		RecloseSequence clone = new RecloseSequence();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setRecloseDelay(initialObject.getRecloseDelay());
		clone.setRecloseStep(initialObject.getRecloseStep());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CILO initialObject){
		CILO clone = new CILO();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Common_LN initialObject){
		Common_LN clone = new Common_LN();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(CSWI initialObject){
		CSWI clone = new CSWI();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PDIF initialObject){
		PDIF clone = new PDIF();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PDIS initialObject){
		PDIS clone = new PDIS();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PDIS_Settings initialObject){
		PDIS_Settings clone = new PDIS_Settings();
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(StateVariable initialObject){
		StateVariable clone = new StateVariable();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SvInjection initialObject){
		SvInjection clone = new SvInjection();
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setMaxQ(initialObject.getMaxQ());
		clone.setMinQ(initialObject.getMinQ());
		clone.setPInjection(initialObject.getPInjection());
		clone.setPLoad(initialObject.getPLoad());
		clone.setQInjection(initialObject.getQInjection());
		clone.setQLoad(initialObject.getQLoad());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SvPowerFlow initialObject){
		SvPowerFlow clone = new SvPowerFlow();
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAngle(initialObject.getAngle());
		clone.setAngleNegativeSeq(initialObject.getAngleNegativeSeq());
		clone.setAnglePositiveSeq(initialObject.getAnglePositiveSeq());
		clone.setAngleZeroSeq(initialObject.getAngleZeroSeq());
		clone.setCurrent(initialObject.getCurrent());
		clone.setCurrentNegativeSeq(initialObject.getCurrentNegativeSeq());
		clone.setCurrentPositiveSeq(initialObject.getCurrentPositiveSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setP(initialObject.getP());
		clone.setQ(initialObject.getQ());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SvShuntCompensatorSections initialObject){
		SvShuntCompensatorSections clone = new SvShuntCompensatorSections();
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSections(initialObject.getSections());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SvStatus initialObject){
		SvStatus clone = new SvStatus();
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setInService(initialObject.getInService());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SvTapStep initialObject){
		SvTapStep clone = new SvTapStep();
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setPosition(initialObject.getPosition());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SvVoltage initialObject){
		SvVoltage clone = new SvVoltage();
		clone.setIsCalculated(initialObject.getIsCalculated());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAngle(initialObject.getAngle());
		clone.setV(initialObject.getV());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(BusNameMarker initialObject){
		BusNameMarker clone = new BusNameMarker();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setPriority(initialObject.getPriority());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(DCTopologicalNode initialObject){
		DCTopologicalNode clone = new DCTopologicalNode();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TopologicalIsland initialObject){
		TopologicalIsland clone = new TopologicalIsland();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setGroundSchemeBranchesNumber(initialObject.getGroundSchemeBranchesNumber());
		clone.setInternalNodesNumber(initialObject.getInternalNodesNumber());
		clone.setNormalSchemeBranchesNumber(initialObject.getNormalSchemeBranchesNumber());
		clone.setPosSeqSchemeBranchesNumber(initialObject.getPosSeqSchemeBranchesNumber());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TopologicalNode initialObject){
		TopologicalNode clone = new TopologicalNode();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setIsGenerativeNode(initialObject.getIsGenerativeNode());
		clone.setIsMaxVoltageNode(initialObject.getIsMaxVoltageNode());
		clone.setNodeType(initialObject.getNodeType());
		clone.setNormalSchemeNodeNumber(initialObject.getNormalSchemeNodeNumber());
		clone.setPInjection(initialObject.getPInjection());
		clone.setQInjection(initialObject.getQInjection());
		clone.setShuntB(initialObject.getShuntB());
		clone.setTotalB(initialObject.getTotalB());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ACLineSegment initialObject){
		ACLineSegment clone = new ACLineSegment();
		clone.setLength(initialObject.getLength());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setB0ch(initialObject.getB0ch());
		clone.setBch(initialObject.getBch());
		clone.setC0PerLength(initialObject.getC0PerLength());
		clone.setCapacityCurrent(initialObject.getCapacityCurrent());
		clone.setComplicationFactor(initialObject.getComplicationFactor());
		clone.setConstructionLength(initialObject.getConstructionLength());
		clone.setCPerLength(initialObject.getCPerLength());
		clone.setCrossSectionalArea(initialObject.getCrossSectionalArea());
		clone.setFactorOper(initialObject.getFactorOper());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setG0ch(initialObject.getG0ch());
		clone.setGch(initialObject.getGch());
		clone.setL0PerLength(initialObject.getL0PerLength());
		clone.setLongPermissibleCurrent(initialObject.getLongPermissibleCurrent());
		clone.setLPerLength(initialObject.getLPerLength());
		clone.setMaxPermissibleVoltage(initialObject.getMaxPermissibleVoltage());
		clone.setPeriod(initialObject.getPeriod());
		clone.setPriceAdditionalValue(initialObject.getPriceAdditionalValue());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceCollector(initialObject.getPriceCollector());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceSwitchPoint(initialObject.getPriceSwitchPoint());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setR(initialObject.getR());
		clone.setR0(initialObject.getR0());
		clone.setR0PerLength(initialObject.getR0PerLength());
		clone.setRPerLength(initialObject.getRPerLength());
		clone.setShortCircuitEndTemperature(initialObject.getShortCircuitEndTemperature());
		clone.setSwitchPointsNumber(initialObject.getSwitchPointsNumber());
		clone.setType(initialObject.getType());
		clone.setX(initialObject.getX());
		clone.setX0(initialObject.getX0());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(AsynchronousMachine initialObject){
		AsynchronousMachine clone = new AsynchronousMachine();
		clone.setConnectionKind(initialObject.getConnectionKind());
		clone.setP(initialObject.getP());
		clone.setQ(initialObject.getQ());
		clone.setRatedPowerFactor(initialObject.getRatedPowerFactor());
		clone.setRatedS(initialObject.getRatedS());
		clone.setRatedU(initialObject.getRatedU());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAsynchronousMachineType(initialObject.getAsynchronousMachineType());
		clone.setConverterFedDrive(initialObject.getConverterFedDrive());
		clone.setEfficiency(initialObject.getEfficiency());
		clone.setIaIrRatio(initialObject.getIaIrRatio());
		clone.setNominalFrequency(initialObject.getNominalFrequency());
		clone.setNominalSpeed(initialObject.getNominalSpeed());
		clone.setPolePairNumber(initialObject.getPolePairNumber());
		clone.setRatedMechanicalPower(initialObject.getRatedMechanicalPower());
		clone.setReversible(initialObject.getReversible());
		clone.setRr1(initialObject.getRr1());
		clone.setRr2(initialObject.getRr2());
		clone.setRxLockedRotorRatio(initialObject.getRxLockedRotorRatio());
		clone.setTpo(initialObject.getTpo());
		clone.setTppo(initialObject.getTppo());
		clone.setXlr1(initialObject.getXlr1());
		clone.setXlr2(initialObject.getXlr2());
		clone.setXm(initialObject.getXm());
		clone.setXp(initialObject.getXp());
		clone.setXpp(initialObject.getXpp());
		clone.setXs(initialObject.getXs());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Breaker initialObject){
		Breaker clone = new Breaker();
		clone.setBreakingCapacity(initialObject.getBreakingCapacity());
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setInTransitTime(initialObject.getInTransitTime());
		clone.setType(initialObject.getType());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(BusbarSection initialObject){
		BusbarSection clone = new BusbarSection();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setIpMax(initialObject.getIpMax());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Conductor initialObject){
		Conductor clone = new Conductor();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setLength(initialObject.getLength());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Connector initialObject){
		Connector clone = new Connector();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Disconnector initialObject){
		Disconnector clone = new Disconnector();
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EarthFaultCompensator initialObject){
		EarthFaultCompensator clone = new EarthFaultCompensator();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setR(initialObject.getR());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EnergyConsumer initialObject){
		EnergyConsumer clone = new EnergyConsumer();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setClusterLabel(initialObject.getClusterLabel());
		clone.setCustomerCount(initialObject.getCustomerCount());
		clone.setGrounded(initialObject.getGrounded());
		clone.setIsOutLier(initialObject.getIsOutLier());
		clone.setIsTransformerNeedToConnectToSubstation(initialObject.getIsTransformerNeedToConnectToSubstation());
		clone.setP(initialObject.getP());
		clone.setPfixed(initialObject.getPfixed());
		clone.setPfixedPct(initialObject.getPfixedPct());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setQ(initialObject.getQ());
		clone.setQfixed(initialObject.getQfixed());
		clone.setQfixedPct(initialObject.getQfixedPct());
		clone.setSubstationPreferredVoltage(initialObject.getSubstationPreferredVoltage());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(EnergySource initialObject){
		EnergySource clone = new EnergySource();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setActivePower(initialObject.getActivePower());
		clone.setNominalVoltage(initialObject.getNominalVoltage());
		clone.setR(initialObject.getR());
		clone.setR0(initialObject.getR0());
		clone.setReactivePower(initialObject.getReactivePower());
		clone.setRn(initialObject.getRn());
		clone.setVoltageAngle(initialObject.getVoltageAngle());
		clone.setVoltageMagnitude(initialObject.getVoltageMagnitude());
		clone.setX(initialObject.getX());
		clone.setX0(initialObject.getX0());
		clone.setXn(initialObject.getXn());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ExternalNetworkInjection initialObject){
		ExternalNetworkInjection clone = new ExternalNetworkInjection();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setGovernorSCD(initialObject.getGovernorSCD());
		clone.setIkSecond(initialObject.getIkSecond());
		clone.setMaxInitialSymShCCurrent(initialObject.getMaxInitialSymShCCurrent());
		clone.setMaxP(initialObject.getMaxP());
		clone.setMaxQ(initialObject.getMaxQ());
		clone.setMaxR0ToX0Ratio(initialObject.getMaxR0ToX0Ratio());
		clone.setMaxR1ToX1Ratio(initialObject.getMaxR1ToX1Ratio());
		clone.setMaxZ0ToZ1Ratio(initialObject.getMaxZ0ToZ1Ratio());
		clone.setMinInitialSymShCCurrent(initialObject.getMinInitialSymShCCurrent());
		clone.setMinP(initialObject.getMinP());
		clone.setMinQ(initialObject.getMinQ());
		clone.setMinR0ToX0Ratio(initialObject.getMinR0ToX0Ratio());
		clone.setMinR1ToX1Ratio(initialObject.getMinR1ToX1Ratio());
		clone.setMinZ0ToZ1Ratio(initialObject.getMinZ0ToZ1Ratio());
		clone.setP(initialObject.getP());
		clone.setQ(initialObject.getQ());
		clone.setReferencePriority(initialObject.getReferencePriority());
		clone.setVoltageFactor(initialObject.getVoltageFactor());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(GroundDisconnector initialObject){
		GroundDisconnector clone = new GroundDisconnector();
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Junction initialObject){
		Junction clone = new Junction();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Line initialObject){
		Line clone = new Line();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(LinearShuntCompensator initialObject){
		LinearShuntCompensator clone = new LinearShuntCompensator();
		clone.setAVRDelay(initialObject.getAVRDelay());
		clone.setGrounded(initialObject.getGrounded());
		clone.setMaximumSections(initialObject.getMaximumSections());
		clone.setNomU(initialObject.getNomU());
		clone.setNormalSections(initialObject.getNormalSections());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setSections(initialObject.getSections());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setVoltageSensitivity(initialObject.getVoltageSensitivity());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setB0PerSection(initialObject.getB0PerSection());
		clone.setBPerSection(initialObject.getBPerSection());
		clone.setG0PerSection(initialObject.getG0PerSection());
		clone.setGPerSection(initialObject.getGPerSection());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(LoadBreakSwitch initialObject){
		LoadBreakSwitch clone = new LoadBreakSwitch();
		clone.setBreakingCapacity(initialObject.getBreakingCapacity());
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(NonlinearShuntCompensator initialObject){
		NonlinearShuntCompensator clone = new NonlinearShuntCompensator();
		clone.setAVRDelay(initialObject.getAVRDelay());
		clone.setGrounded(initialObject.getGrounded());
		clone.setMaximumSections(initialObject.getMaximumSections());
		clone.setNomU(initialObject.getNomU());
		clone.setNormalSections(initialObject.getNormalSections());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setSections(initialObject.getSections());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setVoltageSensitivity(initialObject.getVoltageSensitivity());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(NonlinearShuntCompensatorPoint initialObject){
		NonlinearShuntCompensatorPoint clone = new NonlinearShuntCompensatorPoint();
		clone.setB(initialObject.getB());
		clone.setB0(initialObject.getB0());
		clone.setG(initialObject.getG());
		clone.setG0(initialObject.getG0());
		clone.setSectionNumber(initialObject.getSectionNumber());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PerLengthLineParameter initialObject){
		PerLengthLineParameter clone = new PerLengthLineParameter();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PetersenCoil initialObject){
		PetersenCoil clone = new PetersenCoil();
		clone.setR(initialObject.getR());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setMode(initialObject.getMode());
		clone.setNominalU(initialObject.getNominalU());
		clone.setOffsetCurrent(initialObject.getOffsetCurrent());
		clone.setPositionCurrent(initialObject.getPositionCurrent());
		clone.setXGroundMax(initialObject.getXGroundMax());
		clone.setXGroundMin(initialObject.getXGroundMin());
		clone.setXGroundNominal(initialObject.getXGroundNominal());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChanger initialObject){
		PhaseTapChanger clone = new PhaseTapChanger();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerAsymmetrical initialObject){
		PhaseTapChangerAsymmetrical clone = new PhaseTapChangerAsymmetrical();
		clone.setVoltageStepIncrement(initialObject.getVoltageStepIncrement());
		clone.setXMax(initialObject.getXMax());
		clone.setXMin(initialObject.getXMin());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setWindingConnectionAngle(initialObject.getWindingConnectionAngle());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerLinear initialObject){
		PhaseTapChangerLinear clone = new PhaseTapChangerLinear();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setStepPhaseShiftIncrement(initialObject.getStepPhaseShiftIncrement());
		clone.setXMax(initialObject.getXMax());
		clone.setXMin(initialObject.getXMin());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerNonLinear initialObject){
		PhaseTapChangerNonLinear clone = new PhaseTapChangerNonLinear();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setVoltageStepIncrement(initialObject.getVoltageStepIncrement());
		clone.setXMax(initialObject.getXMax());
		clone.setXMin(initialObject.getXMin());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerSymmetrical initialObject){
		PhaseTapChangerSymmetrical clone = new PhaseTapChangerSymmetrical();
		clone.setVoltageStepIncrement(initialObject.getVoltageStepIncrement());
		clone.setXMax(initialObject.getXMax());
		clone.setXMin(initialObject.getXMin());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerTable initialObject){
		PhaseTapChangerTable clone = new PhaseTapChangerTable();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerTablePoint initialObject){
		PhaseTapChangerTablePoint clone = new PhaseTapChangerTablePoint();
		clone.setB(initialObject.getB());
		clone.setG(initialObject.getG());
		clone.setR(initialObject.getR());
		clone.setRatio(initialObject.getRatio());
		clone.setStep(initialObject.getStep());
		clone.setX(initialObject.getX());
		clone.setAngle(initialObject.getAngle());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PhaseTapChangerTabular initialObject){
		PhaseTapChangerTabular clone = new PhaseTapChangerTabular();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PowerTransformer initialObject){
		PowerTransformer clone = new PowerTransformer();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setBeforeShCircuitHighestOperatingCurrent(initialObject.getBeforeShCircuitHighestOperatingCurrent());
		clone.setBeforeShCircuitHighestOperatingVoltage(initialObject.getBeforeShCircuitHighestOperatingVoltage());
		clone.setBeforeShortCircuitAnglePf(initialObject.getBeforeShortCircuitAnglePf());
		clone.setHighSideMinOperatingU(initialObject.getHighSideMinOperatingU());
		clone.setIdleCurrent(initialObject.getIdleCurrent());
		clone.setIdlePower(initialObject.getIdlePower());
		clone.setIsPartOfGeneratorUnit(initialObject.getIsPartOfGeneratorUnit());
		clone.setOperationalValuesConsidered(initialObject.getOperationalValuesConsidered());
		clone.setPK_HighLow(initialObject.getPK_HighLow());
		clone.setPK_HighMiddle(initialObject.getPK_HighMiddle());
		clone.setPK_MiddleLow(initialObject.getPK_MiddleLow());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedHighVoltage(initialObject.getRatedHighVoltage());
		clone.setRatedLowVoltage(initialObject.getRatedLowVoltage());
		clone.setRatedMiddleVoltage(initialObject.getRatedMiddleVoltage());
		clone.setRatedS(initialObject.getRatedS());
		clone.setType(initialObject.getType());
		clone.setUK_HighLow(initialObject.getUK_HighLow());
		clone.setUK_HighLow_max(initialObject.getUK_HighLow_max());
		clone.setUK_HighLow_min(initialObject.getUK_HighLow_min());
		clone.setUK_HighMiddle(initialObject.getUK_HighMiddle());
		clone.setUK_HighMiddle_max(initialObject.getUK_HighMiddle_max());
		clone.setUK_HighMiddle_min(initialObject.getUK_HighMiddle_min());
		clone.setUK_MiddleLow(initialObject.getUK_MiddleLow());
		clone.setUK_MiddleLow_max(initialObject.getUK_MiddleLow_max());
		clone.setUK_MiddleLow_min(initialObject.getUK_MiddleLow_min());
		clone.setVectorGroup(initialObject.getVectorGroup());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(PowerTransformerEnd initialObject){
		PowerTransformerEnd clone = new PowerTransformerEnd();
		clone.setBmagSat(initialObject.getBmagSat());
		clone.setEndNumber(initialObject.getEndNumber());
		clone.setGrounded(initialObject.getGrounded());
		clone.setMagBaseU(initialObject.getMagBaseU());
		clone.setMagSatFlux(initialObject.getMagSatFlux());
		clone.setRground(initialObject.getRground());
		clone.setXground(initialObject.getXground());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setB(initialObject.getB());
		clone.setB0(initialObject.getB0());
		clone.setConnectionKind(initialObject.getConnectionKind());
		clone.setG(initialObject.getG());
		clone.setG0(initialObject.getG0());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setInternalNodeID(initialObject.getInternalNodeID());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setPhaseAngleClock(initialObject.getPhaseAngleClock());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setR(initialObject.getR());
		clone.setR0(initialObject.getR0());
		clone.setRatedS(initialObject.getRatedS());
		clone.setRatedU(initialObject.getRatedU());
		clone.setX(initialObject.getX());
		clone.setX0(initialObject.getX0());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ProtectedSwitch initialObject){
		ProtectedSwitch clone = new ProtectedSwitch();
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setBreakingCapacity(initialObject.getBreakingCapacity());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RatioTapChanger initialObject){
		RatioTapChanger clone = new RatioTapChanger();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setStepVoltageIncrement(initialObject.getStepVoltageIncrement());
		clone.setTculControlMode(initialObject.getTculControlMode());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RatioTapChangerTable initialObject){
		RatioTapChangerTable clone = new RatioTapChangerTable();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RatioTapChangerTablePoint initialObject){
		RatioTapChangerTablePoint clone = new RatioTapChangerTablePoint();
		clone.setB(initialObject.getB());
		clone.setG(initialObject.getG());
		clone.setR(initialObject.getR());
		clone.setRatio(initialObject.getRatio());
		clone.setStep(initialObject.getStep());
		clone.setX(initialObject.getX());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ReactiveCapabilityCurve initialObject){
		ReactiveCapabilityCurve clone = new ReactiveCapabilityCurve();
		clone.setCurveStyle(initialObject.getCurveStyle());
		clone.setXMultiplier(initialObject.getXMultiplier());
		clone.setXUnit(initialObject.getXUnit());
		clone.setY1Multiplier(initialObject.getY1Multiplier());
		clone.setY1Unit(initialObject.getY1Unit());
		clone.setY2Multiplier(initialObject.getY2Multiplier());
		clone.setY2Unit(initialObject.getY2Unit());
		clone.setY3Multiplier(initialObject.getY3Multiplier());
		clone.setY3Unit(initialObject.getY3Unit());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCoolantTemperature(initialObject.getCoolantTemperature());
		clone.setHydrogenPressure(initialObject.getHydrogenPressure());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Recloser initialObject){
		Recloser clone = new Recloser();
		clone.setBreakingCapacity(initialObject.getBreakingCapacity());
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RegulatingCondEq initialObject){
		RegulatingCondEq clone = new RegulatingCondEq();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RegulatingControl initialObject){
		RegulatingControl clone = new RegulatingControl();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setDiscrete(initialObject.getDiscrete());
		clone.setEnabled(initialObject.getEnabled());
		clone.setMode(initialObject.getMode());
		clone.setMonitoredPhase(initialObject.getMonitoredPhase());
		clone.setTargetDeadband(initialObject.getTargetDeadband());
		clone.setTargetValue(initialObject.getTargetValue());
		clone.setTargetValueUnitMultiplier(initialObject.getTargetValueUnitMultiplier());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(RotatingMachine initialObject){
		RotatingMachine clone = new RotatingMachine();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setConnectionKind(initialObject.getConnectionKind());
		clone.setP(initialObject.getP());
		clone.setQ(initialObject.getQ());
		clone.setRatedPowerFactor(initialObject.getRatedPowerFactor());
		clone.setRatedS(initialObject.getRatedS());
		clone.setRatedU(initialObject.getRatedU());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SeriesCompensator initialObject){
		SeriesCompensator clone = new SeriesCompensator();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setR(initialObject.getR());
		clone.setR0(initialObject.getR0());
		clone.setVaristorPresent(initialObject.getVaristorPresent());
		clone.setVaristorRatedCurrent(initialObject.getVaristorRatedCurrent());
		clone.setVaristorVoltageThreshold(initialObject.getVaristorVoltageThreshold());
		clone.setX(initialObject.getX());
		clone.setX0(initialObject.getX0());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ShuntCompensator initialObject){
		ShuntCompensator clone = new ShuntCompensator();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAVRDelay(initialObject.getAVRDelay());
		clone.setGrounded(initialObject.getGrounded());
		clone.setMaximumSections(initialObject.getMaximumSections());
		clone.setNomU(initialObject.getNomU());
		clone.setNormalSections(initialObject.getNormalSections());
		clone.setPhaseConnection(initialObject.getPhaseConnection());
		clone.setSections(initialObject.getSections());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setVoltageSensitivity(initialObject.getVoltageSensitivity());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(ShuntCompensatorPhase initialObject){
		ShuntCompensatorPhase clone = new ShuntCompensatorPhase();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setMaximumSections(initialObject.getMaximumSections());
		clone.setNormalSections(initialObject.getNormalSections());
		clone.setPhase(initialObject.getPhase());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(StaticVarCompensator initialObject){
		StaticVarCompensator clone = new StaticVarCompensator();
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setCapacitiveRating(initialObject.getCapacitiveRating());
		clone.setInductiveRating(initialObject.getInductiveRating());
		clone.setQ(initialObject.getQ());
		clone.setSlope(initialObject.getSlope());
		clone.setSVCControlMode(initialObject.getSVCControlMode());
		clone.setVoltageSetPoint(initialObject.getVoltageSetPoint());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(Switch initialObject){
		Switch clone = new Switch();
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setNormalOpen(initialObject.getNormalOpen());
		clone.setOpen(initialObject.getOpen());
		clone.setRatedCurrent(initialObject.getRatedCurrent());
		clone.setRatedVoltage(initialObject.getRatedVoltage());
		clone.setRetained(initialObject.getRetained());
		clone.setSwitchOnCount(initialObject.getSwitchOnCount());
		clone.setSwitchOnDate(initialObject.getSwitchOnDate());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(SynchronousMachine initialObject){
		SynchronousMachine clone = new SynchronousMachine();
		clone.setConnectionKind(initialObject.getConnectionKind());
		clone.setP(initialObject.getP());
		clone.setQ(initialObject.getQ());
		clone.setRatedPowerFactor(initialObject.getRatedPowerFactor());
		clone.setRatedS(initialObject.getRatedS());
		clone.setRatedU(initialObject.getRatedU());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setCurrentNegSeq(initialObject.getCurrentNegSeq());
		clone.setCurrentZeroSeq(initialObject.getCurrentZeroSeq());
		clone.setGroundFaultSchemeBranchID(initialObject.getGroundFaultSchemeBranchID());
		clone.setIsEquipmentAvailableForOptimization(initialObject.getIsEquipmentAvailableForOptimization());
		clone.setNormalSchemeBranchID(initialObject.getNormalSchemeBranchID());
		clone.setNormalSchemeNodeID(initialObject.getNormalSchemeNodeID());
		clone.setPosSeqSchemeBranchID(initialObject.getPosSeqSchemeBranchID());
		clone.setAggregate(initialObject.getAggregate());
		clone.setFailureFlow(initialObject.getFailureFlow());
		clone.setNormallyInService(initialObject.getNormallyInService());
		clone.setRecoveryTime(initialObject.getRecoveryTime());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setAVRToManualLag(initialObject.getAVRToManualLag());
		clone.setAVRToManualLead(initialObject.getAVRToManualLead());
		clone.setBaseQ(initialObject.getBaseQ());
		clone.setCondenserP(initialObject.getCondenserP());
		clone.setCoolantCondition(initialObject.getCoolantCondition());
		clone.setCoolantType(initialObject.getCoolantType());
		clone.setEarthing(initialObject.getEarthing());
		clone.setEarthingStarPointR(initialObject.getEarthingStarPointR());
		clone.setEarthingStarPointX(initialObject.getEarthingStarPointX());
		clone.setIkk(initialObject.getIkk());
		clone.setManualToAVR(initialObject.getManualToAVR());
		clone.setMaxQ(initialObject.getMaxQ());
		clone.setMaxU(initialObject.getMaxU());
		clone.setMinQ(initialObject.getMinQ());
		clone.setMinU(initialObject.getMinU());
		clone.setMu(initialObject.getMu());
		clone.setOperatingMode(initialObject.getOperatingMode());
		clone.setQPercent(initialObject.getQPercent());
		clone.setR(initialObject.getR());
		clone.setR0(initialObject.getR0());
		clone.setR2(initialObject.getR2());
		clone.setReferencePriority(initialObject.getReferencePriority());
		clone.setSatDirectSubtransX(initialObject.getSatDirectSubtransX());
		clone.setSatDirectSyncX(initialObject.getSatDirectSyncX());
		clone.setSatDirectTransX(initialObject.getSatDirectTransX());
		clone.setShortCircuitRotorType(initialObject.getShortCircuitRotorType());
		clone.setType(initialObject.getType());
		clone.setVoltageRegulationRange(initialObject.getVoltageRegulationRange());
		clone.setX0(initialObject.getX0());
		clone.setX2(initialObject.getX2());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TapChanger initialObject){
		TapChanger clone = new TapChanger();
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setControlEnabled(initialObject.getControlEnabled());
		clone.setHighStep(initialObject.getHighStep());
		clone.setInitialDelay(initialObject.getInitialDelay());
		clone.setLowStep(initialObject.getLowStep());
		clone.setLtcFlag(initialObject.getLtcFlag());
		clone.setNeutralStep(initialObject.getNeutralStep());
		clone.setNeutralU(initialObject.getNeutralU());
		clone.setNormalStep(initialObject.getNormalStep());
		clone.setStep(initialObject.getStep());
		clone.setSubsequentDelay(initialObject.getSubsequentDelay());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TapChangerControl initialObject){
		TapChangerControl clone = new TapChangerControl();
		clone.setDiscrete(initialObject.getDiscrete());
		clone.setEnabled(initialObject.getEnabled());
		clone.setMode(initialObject.getMode());
		clone.setMonitoredPhase(initialObject.getMonitoredPhase());
		clone.setTargetDeadband(initialObject.getTargetDeadband());
		clone.setTargetValue(initialObject.getTargetValue());
		clone.setTargetValueUnitMultiplier(initialObject.getTargetValueUnitMultiplier());
		clone.setBrand(initialObject.getBrand());
		clone.setBuildingSquare(initialObject.getBuildingSquare());
		clone.setCapex(initialObject.getCapex());
		clone.setFactorTech(initialObject.getFactorTech());
		clone.setIsHighSideAvailable(initialObject.getIsHighSideAvailable());
		clone.setIsLowSideAvailable(initialObject.getIsLowSideAvailable());
		clone.setIsOverLoaded(initialObject.getIsOverLoaded());
		clone.setLatitude(initialObject.getLatitude());
		clone.setLongitude(initialObject.getLongitude());
		clone.setOpex(initialObject.getOpex());
		clone.setPriceAdditional(initialObject.getPriceAdditional());
		clone.setPriceBase(initialObject.getPriceBase());
		clone.setPriceOper(initialObject.getPriceOper());
		clone.setPriceTech(initialObject.getPriceTech());
		clone.setProjectPrice(initialObject.getProjectPrice());
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setLimitVoltage(initialObject.getLimitVoltage());
		clone.setLineDropCompensation(initialObject.getLineDropCompensation());
		clone.setLineDropR(initialObject.getLineDropR());
		clone.setLineDropX(initialObject.getLineDropX());
		clone.setReverseLineDropR(initialObject.getReverseLineDropR());
		clone.setReverseLineDropX(initialObject.getReverseLineDropX());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TapChangerTablePoint initialObject){
		TapChangerTablePoint clone = new TapChangerTablePoint();
		clone.setB(initialObject.getB());
		clone.setG(initialObject.getG());
		clone.setR(initialObject.getR());
		clone.setRatio(initialObject.getRatio());
		clone.setStep(initialObject.getStep());
		clone.setX(initialObject.getX());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void cloneObjectWithFields(TransformerEnd initialObject){
		TransformerEnd clone = new TransformerEnd();
		clone.setAliasName(initialObject.getAliasName());
		clone.setClassName(initialObject.getClassName());
		clone.setDescription(initialObject.getDescription());
		clone.setMRID(initialObject.getMRID());
		clone.setName(initialObject.getName());
		clone.setProjectID(initialObject.getProjectID());
		clone.setRpnCondition(initialObject.getRpnCondition());
		clone.setSchemaScenarioNumber(initialObject.getSchemaScenarioNumber());
		clone.setSchemeType(initialObject.getSchemeType());
		clone.setSeasonType(initialObject.getSeasonType());
		clone.setSubtaskNumber(initialObject.getSubtaskNumber());
		clone.setWasObjectSynthesized(initialObject.getWasObjectSynthesized());
		clone.setBmagSat(initialObject.getBmagSat());
		clone.setEndNumber(initialObject.getEndNumber());
		clone.setGrounded(initialObject.getGrounded());
		clone.setMagBaseU(initialObject.getMagBaseU());
		clone.setMagSatFlux(initialObject.getMagSatFlux());
		clone.setRground(initialObject.getRground());
		clone.setXground(initialObject.getXground());
		clone.setSynthesizedSchemeNumber(synthesizedNumber);
		clonedObjects.put(clone.getMRID(), clone);
	}
	private void addAssociationsToClonedObject(CapexOpexCalculationResult initialObject){
		CapexOpexCalculationResult clone = (CapexOpexCalculationResult) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ChargeController initialObject){
		ChargeController clone = (ChargeController) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Cluster initialObject){
		Cluster clone = (Cluster) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getMaxBaseVoltage() != null) clone.setMaxBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getMaxBaseVoltage().getMRID()));
	}
	private void addAssociationsToClonedObject(ConsumersCluster initialObject){
		ConsumersCluster clone = (ConsumersCluster) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getMaxBaseVoltage() != null) clone.setMaxBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getMaxBaseVoltage().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConsumersVoltageClusters().size() != 0){
			clone.setConsumersVoltageClusters(new ArrayList<>());
			initialObject.getConsumersVoltageClusters().forEach(o -> clone.getConsumersVoltageClusters().add((ConsumersVoltageCluster) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEnergyConsumers().size() != 0){
			clone.setEnergyConsumers(new ArrayList<>());
			initialObject.getEnergyConsumers().forEach(o -> clone.getEnergyConsumers().add((EnergyConsumer) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ConsumersVoltageCluster initialObject){
		ConsumersVoltageCluster clone = (ConsumersVoltageCluster) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getMaxBaseVoltage() != null) clone.setMaxBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getMaxBaseVoltage().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConsumersCluster() != null) clone.setConsumersCluster((ConsumersCluster) clonedObjects.get(initialObject.getConsumersCluster().getMRID()));
		if (initialObject.getEnergyConsumers().size() != 0){
			clone.setEnergyConsumers(new ArrayList<>());
			initialObject.getEnergyConsumers().forEach(o -> clone.getEnergyConsumers().add((EnergyConsumer) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ScenarioPossibility initialObject){
		ScenarioPossibility clone = (ScenarioPossibility) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(BatteryBankCell initialObject){
		BatteryBankCell clone = (BatteryBankCell) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(BatteryEnergyStorageSystem initialObject){
		BatteryEnergyStorageSystem clone = (BatteryEnergyStorageSystem) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Asset initialObject){
		Asset clone = (Asset) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getPowerSystemResources().size() != 0){
			clone.setPowerSystemResources(new ArrayList<>());
			initialObject.getPowerSystemResources().forEach(o -> clone.getPowerSystemResources().add((PowerSystemResource) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(CoordinateSystem initialObject){
		CoordinateSystem clone = (CoordinateSystem) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLocations().size() != 0){
			clone.setLocations(new ArrayList<>());
			initialObject.getLocations().forEach(o -> clone.getLocations().add((Location) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Location initialObject){
		Location clone = (Location) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets().size() != 0){
			clone.setAssets(new ArrayList<>());
			initialObject.getAssets().forEach(o -> clone.getAssets().add((Asset) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCoordinateSystem() != null) clone.setCoordinateSystem((CoordinateSystem) clonedObjects.get(initialObject.getCoordinateSystem().getMRID()));
		if (initialObject.getPowerSystemResources().size() != 0){
			clone.setPowerSystemResources(new ArrayList<>());
			initialObject.getPowerSystemResources().forEach(o -> clone.getPowerSystemResources().add((PowerSystemResource) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(OrganisationRole initialObject){
		OrganisationRole clone = (OrganisationRole) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Customer initialObject){
		Customer clone = (Customer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Outage initialObject){
		Outage clone = (Outage) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(AuxiliaryEquipment initialObject){
		AuxiliaryEquipment clone = (AuxiliaryEquipment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
	}
	private void addAssociationsToClonedObject(CurrentTransformer initialObject){
		CurrentTransformer clone = (CurrentTransformer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getProtectionEquipment() != null) clone.setProtectionEquipment((ProtectionEquipment) clonedObjects.get(initialObject.getProtectionEquipment().getMRID()));
	}
	private void addAssociationsToClonedObject(PotentialTransformer initialObject){
		PotentialTransformer clone = (PotentialTransformer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getProtectionEquipment() != null) clone.setProtectionEquipment((ProtectionEquipment) clonedObjects.get(initialObject.getProtectionEquipment().getMRID()));
	}
	private void addAssociationsToClonedObject(Sensor initialObject){
		Sensor clone = (Sensor) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(SurgeArrester initialObject){
		SurgeArrester clone = (SurgeArrester) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ACDCTerminal initialObject){
		ACDCTerminal clone = (ACDCTerminal) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBusNameMarker() != null) clone.setBusNameMarker((BusNameMarker) clonedObjects.get(initialObject.getBusNameMarker().getMRID()));
	}
	private void addAssociationsToClonedObject(BaseVoltage initialObject){
		BaseVoltage clone = (BaseVoltage) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCluster().size() != 0){
			clone.setCluster(new ArrayList<>());
			initialObject.getCluster().forEach(o -> clone.getCluster().add((Cluster) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConductingEquipment().size() != 0){
			clone.setConductingEquipment(new ArrayList<>());
			initialObject.getConductingEquipment().forEach(o -> clone.getConductingEquipment().add((ConductingEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTransformerEnds().size() != 0){
			clone.setTransformerEnds(new ArrayList<>());
			initialObject.getTransformerEnds().forEach(o -> clone.getTransformerEnds().add((TransformerEnd) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getVoltageLevel().size() != 0){
			clone.setVoltageLevel(new ArrayList<>());
			initialObject.getVoltageLevel().forEach(o -> clone.getVoltageLevel().add((VoltageLevel) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Bay initialObject){
		Bay clone = (Bay) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSubstation() != null) clone.setSubstation((Substation) clonedObjects.get(initialObject.getSubstation().getMRID()));
		if (initialObject.getVoltageLevel() != null) clone.setVoltageLevel((VoltageLevel) clonedObjects.get(initialObject.getVoltageLevel().getMRID()));
	}
	private void addAssociationsToClonedObject(ConductingEquipment initialObject){
		ConductingEquipment clone = (ConductingEquipment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
	}
	private void addAssociationsToClonedObject(ConnectivityNode initialObject){
		ConnectivityNode clone = (ConnectivityNode) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode() != null) clone.setTopologicalNode((TopologicalNode) clonedObjects.get(initialObject.getTopologicalNode().getMRID()));
		if (initialObject.getConnectivityNodeContainer() != null) clone.setConnectivityNodeContainer((ConnectivityNodeContainer) clonedObjects.get(initialObject.getConnectivityNodeContainer().getMRID()));
		if (initialObject.getProtectionEquipmentsForMaxVoltage().size() != 0){
			clone.setProtectionEquipmentsForMaxVoltage(new ArrayList<>());
			initialObject.getProtectionEquipmentsForMaxVoltage().forEach(o -> clone.getProtectionEquipmentsForMaxVoltage().add((ProtectionEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ConnectivityNodeContainer initialObject){
		ConnectivityNodeContainer clone = (ConnectivityNodeContainer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Curve initialObject){
		Curve clone = (Curve) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCurveDatas().size() != 0){
			clone.setCurveDatas(new ArrayList<>());
			initialObject.getCurveDatas().forEach(o -> clone.getCurveDatas().add((CurveData) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(CurveData initialObject){
		CurveData clone = (CurveData) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCurve() != null) clone.setCurve((Curve) clonedObjects.get(initialObject.getCurve().getMRID()));
	}
	private void addAssociationsToClonedObject(Equipment initialObject){
		Equipment clone = (Equipment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
	}
	private void addAssociationsToClonedObject(EquipmentContainer initialObject){
		EquipmentContainer clone = (EquipmentContainer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(GeographicalRegion initialObject){
		GeographicalRegion clone = (GeographicalRegion) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegions().size() != 0){
			clone.setRegions(new ArrayList<>());
			initialObject.getRegions().forEach(o -> clone.getRegions().add((SubGeographicalRegion) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Name initialObject){
		Name clone = (Name) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getIdentifiedObject() != null) clone.setIdentifiedObject((IdentifiedObject) clonedObjects.get(initialObject.getIdentifiedObject().getMRID()));
		if (initialObject.getNameType() != null) clone.setNameType((NameType) clonedObjects.get(initialObject.getNameType().getMRID()));
	}
	private void addAssociationsToClonedObject(NameType initialObject){
		NameType clone = (NameType) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PowerSystemResource initialObject){
		PowerSystemResource clone = (PowerSystemResource) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
	}
	private void addAssociationsToClonedObject(ReportingGroup initialObject){
		ReportingGroup clone = (ReportingGroup) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBusNameMarker().size() != 0){
			clone.setBusNameMarker(new ArrayList<>());
			initialObject.getBusNameMarker().forEach(o -> clone.getBusNameMarker().add((BusNameMarker) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(SubGeographicalRegion initialObject){
		SubGeographicalRegion clone = (SubGeographicalRegion) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegion() != null) clone.setRegion((GeographicalRegion) clonedObjects.get(initialObject.getRegion().getMRID()));
		if (initialObject.getLines().size() != 0){
			clone.setLines(new ArrayList<>());
			initialObject.getLines().forEach(o -> clone.getLines().add((Line) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSubstations().size() != 0){
			clone.setSubstations(new ArrayList<>());
			initialObject.getSubstations().forEach(o -> clone.getSubstations().add((Substation) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCLines().size() != 0){
			clone.setDCLines(new ArrayList<>());
			initialObject.getDCLines().forEach(o -> clone.getDCLines().add((DCLine) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Substation initialObject){
		Substation clone = (Substation) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBays().size() != 0){
			clone.setBays(new ArrayList<>());
			initialObject.getBays().forEach(o -> clone.getBays().add((Bay) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegion() != null) clone.setRegion((SubGeographicalRegion) clonedObjects.get(initialObject.getRegion().getMRID()));
		if (initialObject.getDCConverterUnit().size() != 0){
			clone.setDCConverterUnit(new ArrayList<>());
			initialObject.getDCConverterUnit().forEach(o -> clone.getDCConverterUnit().add((DCConverterUnit) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getVoltageLevels().size() != 0){
			clone.setVoltageLevels(new ArrayList<>());
			initialObject.getVoltageLevels().forEach(o -> clone.getVoltageLevels().add((VoltageLevel) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConsumersFeedingTo().size() != 0){
			clone.setConsumersFeedingTo(new ArrayList<>());
			initialObject.getConsumersFeedingTo().forEach(o -> clone.getConsumersFeedingTo().add((EnergyConsumer) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Terminal initialObject){
		Terminal clone = (Terminal) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBusNameMarker() != null) clone.setBusNameMarker((BusNameMarker) clonedObjects.get(initialObject.getBusNameMarker().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAuxiliaryEquipment().size() != 0){
			clone.setAuxiliaryEquipment(new ArrayList<>());
			initialObject.getAuxiliaryEquipment().forEach(o -> clone.getAuxiliaryEquipment().add((AuxiliaryEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConductingEquipment() != null) clone.setConductingEquipment((ConductingEquipment) clonedObjects.get(initialObject.getConductingEquipment().getMRID()));
		if (initialObject.getConnectivityNode() != null) clone.setConnectivityNode((ConnectivityNode) clonedObjects.get(initialObject.getConnectivityNode().getMRID()));
		if (initialObject.getTopologicalNode() != null) clone.setTopologicalNode((TopologicalNode) clonedObjects.get(initialObject.getTopologicalNode().getMRID()));
		if (initialObject.getProtectionsForDefineFaultType().size() != 0){
			clone.setProtectionsForDefineFaultType(new ArrayList<>());
			initialObject.getProtectionsForDefineFaultType().forEach(o -> clone.getProtectionsForDefineFaultType().add((ProtectionEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTransformerEnd().size() != 0){
			clone.setTransformerEnd(new ArrayList<>());
			initialObject.getTransformerEnd().forEach(o -> clone.getTransformerEnd().add((TransformerEnd) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConverterDCSides().size() != 0){
			clone.setConverterDCSides(new ArrayList<>());
			initialObject.getConverterDCSides().forEach(o -> clone.getConverterDCSides().add((ACDCConverter) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getResultPowerFlow().size() != 0){
			clone.setResultPowerFlow(new ArrayList<>());
			initialObject.getResultPowerFlow().forEach(o -> clone.getResultPowerFlow().add((SvPowerFlow) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvPowerFlow() != null) clone.setSvPowerFlow((SvPowerFlow) clonedObjects.get(initialObject.getSvPowerFlow().getMRID()));
		if (initialObject.getProtectionlForMaxLoadFlowCurrent().size() != 0){
			clone.setProtectionlForMaxLoadFlowCurrent(new ArrayList<>());
			initialObject.getProtectionlForMaxLoadFlowCurrent().forEach(o -> clone.getProtectionlForMaxLoadFlowCurrent().add((ProtectionEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentFaults().size() != 0){
			clone.setEquipmentFaults(new ArrayList<>());
			initialObject.getEquipmentFaults().forEach(o -> clone.getEquipmentFaults().add((EquipmentFault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getProtectionsForScCurrentInMainArea().size() != 0){
			clone.setProtectionsForScCurrentInMainArea(new ArrayList<>());
			initialObject.getProtectionsForScCurrentInMainArea().forEach(o -> clone.getProtectionsForScCurrentInMainArea().add((ProtectionEquipment) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(VoltageLevel initialObject){
		VoltageLevel clone = (VoltageLevel) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getBays().size() != 0){
			clone.setBays(new ArrayList<>());
			initialObject.getBays().forEach(o -> clone.getBays().add((Bay) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSubstation() != null) clone.setSubstation((Substation) clonedObjects.get(initialObject.getSubstation().getMRID()));
	}
	private void addAssociationsToClonedObject(ACDCConverter initialObject){
		ACDCConverter clone = (ACDCConverter) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPccTerminal() != null) clone.setPccTerminal((Terminal) clonedObjects.get(initialObject.getPccTerminal().getMRID()));
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((ACDCConverterDCTerminal) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ACDCConverterDCTerminal initialObject){
		ACDCConverterDCTerminal clone = (ACDCConverterDCTerminal) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTopologicalNode() != null) clone.setDCTopologicalNode((DCTopologicalNode) clonedObjects.get(initialObject.getDCTopologicalNode().getMRID()));
		if (initialObject.getDCNode() != null) clone.setDCNode((DCNode) clonedObjects.get(initialObject.getDCNode().getMRID()));
		if (initialObject.getBusNameMarker() != null) clone.setBusNameMarker((BusNameMarker) clonedObjects.get(initialObject.getBusNameMarker().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCConductingEquipment() != null) clone.setDCConductingEquipment((ACDCConverter) clonedObjects.get(initialObject.getDCConductingEquipment().getMRID()));
	}
	private void addAssociationsToClonedObject(CsConverter initialObject){
		CsConverter clone = (CsConverter) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getPccTerminal() != null) clone.setPccTerminal((Terminal) clonedObjects.get(initialObject.getPccTerminal().getMRID()));
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((ACDCConverterDCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCBaseTerminal initialObject){
		DCBaseTerminal clone = (DCBaseTerminal) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBusNameMarker() != null) clone.setBusNameMarker((BusNameMarker) clonedObjects.get(initialObject.getBusNameMarker().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCTopologicalNode() != null) clone.setDCTopologicalNode((DCTopologicalNode) clonedObjects.get(initialObject.getDCTopologicalNode().getMRID()));
		if (initialObject.getDCNode() != null) clone.setDCNode((DCNode) clonedObjects.get(initialObject.getDCNode().getMRID()));
	}
	private void addAssociationsToClonedObject(DCBreaker initialObject){
		DCBreaker clone = (DCBreaker) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCBusbar initialObject){
		DCBusbar clone = (DCBusbar) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCChopper initialObject){
		DCChopper clone = (DCChopper) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCConductingEquipment initialObject){
		DCConductingEquipment clone = (DCConductingEquipment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCConverterUnit initialObject){
		DCConverterUnit clone = (DCConverterUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCNodes().size() != 0){
			clone.setDCNodes(new ArrayList<>());
			initialObject.getDCNodes().forEach(o -> clone.getDCNodes().add((DCNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSubstation() != null) clone.setSubstation((Substation) clonedObjects.get(initialObject.getSubstation().getMRID()));
	}
	private void addAssociationsToClonedObject(DCDisconnector initialObject){
		DCDisconnector clone = (DCDisconnector) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCEquipmentContainer initialObject){
		DCEquipmentContainer clone = (DCEquipmentContainer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCNodes().size() != 0){
			clone.setDCNodes(new ArrayList<>());
			initialObject.getDCNodes().forEach(o -> clone.getDCNodes().add((DCNode) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCGround initialObject){
		DCGround clone = (DCGround) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCLine initialObject){
		DCLine clone = (DCLine) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCNodes().size() != 0){
			clone.setDCNodes(new ArrayList<>());
			initialObject.getDCNodes().forEach(o -> clone.getDCNodes().add((DCNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegion() != null) clone.setRegion((SubGeographicalRegion) clonedObjects.get(initialObject.getRegion().getMRID()));
	}
	private void addAssociationsToClonedObject(DCLineSegment initialObject){
		DCLineSegment clone = (DCLineSegment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPerLengthParameter() != null) clone.setPerLengthParameter((PerLengthDCLineParameter) clonedObjects.get(initialObject.getPerLengthParameter().getMRID()));
	}
	private void addAssociationsToClonedObject(DCNode initialObject){
		DCNode clone = (DCNode) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCBaseTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCEquipmentContainer() != null) clone.setDCEquipmentContainer((DCEquipmentContainer) clonedObjects.get(initialObject.getDCEquipmentContainer().getMRID()));
	}
	private void addAssociationsToClonedObject(DCSeriesDevice initialObject){
		DCSeriesDevice clone = (DCSeriesDevice) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCShunt initialObject){
		DCShunt clone = (DCShunt) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCSwitch initialObject){
		DCSwitch clone = (DCSwitch) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DCTerminal initialObject){
		DCTerminal clone = (DCTerminal) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDCTopologicalNode() != null) clone.setDCTopologicalNode((DCTopologicalNode) clonedObjects.get(initialObject.getDCTopologicalNode().getMRID()));
		if (initialObject.getDCNode() != null) clone.setDCNode((DCNode) clonedObjects.get(initialObject.getDCNode().getMRID()));
		if (initialObject.getBusNameMarker() != null) clone.setBusNameMarker((BusNameMarker) clonedObjects.get(initialObject.getBusNameMarker().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCConductingEquipment() != null) clone.setDCConductingEquipment((DCConductingEquipment) clonedObjects.get(initialObject.getDCConductingEquipment().getMRID()));
	}
	private void addAssociationsToClonedObject(DCTopologicalIsland initialObject){
		DCTopologicalIsland clone = (DCTopologicalIsland) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCTopologicalNodes().size() != 0){
			clone.setDCTopologicalNodes(new ArrayList<>());
			initialObject.getDCTopologicalNodes().forEach(o -> clone.getDCTopologicalNodes().add((DCTopologicalNode) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PerLengthDCLineParameter initialObject){
		PerLengthDCLineParameter clone = (PerLengthDCLineParameter) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCLineSegments().size() != 0){
			clone.setDCLineSegments(new ArrayList<>());
			initialObject.getDCLineSegments().forEach(o -> clone.getDCLineSegments().add((DCLineSegment) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(VsCapabilityCurve initialObject){
		VsCapabilityCurve clone = (VsCapabilityCurve) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCurveDatas().size() != 0){
			clone.setCurveDatas(new ArrayList<>());
			initialObject.getCurveDatas().forEach(o -> clone.getCurveDatas().add((CurveData) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getVsConverterDCSides().size() != 0){
			clone.setVsConverterDCSides(new ArrayList<>());
			initialObject.getVsConverterDCSides().forEach(o -> clone.getVsConverterDCSides().add((VsConverter) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(VsConverter initialObject){
		VsConverter clone = (VsConverter) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getPccTerminal() != null) clone.setPccTerminal((Terminal) clonedObjects.get(initialObject.getPccTerminal().getMRID()));
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((ACDCConverterDCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCapabilityCurve() != null) clone.setCapabilityCurve((VsCapabilityCurve) clonedObjects.get(initialObject.getCapabilityCurve().getMRID()));
	}
	private void addAssociationsToClonedObject(Diagram initialObject){
		Diagram clone = (Diagram) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramStyle() != null) clone.setDiagramStyle((DiagramStyle) clonedObjects.get(initialObject.getDiagramStyle().getMRID()));
		if (initialObject.getDiagramElements().size() != 0){
			clone.setDiagramElements(new ArrayList<>());
			initialObject.getDiagramElements().forEach(o -> clone.getDiagramElements().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DiagramObject initialObject){
		DiagramObject clone = (DiagramObject) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getIdentifiedObject() != null) clone.setIdentifiedObject((IdentifiedObject) clonedObjects.get(initialObject.getIdentifiedObject().getMRID()));
		if (initialObject.getDiagram() != null) clone.setDiagram((Diagram) clonedObjects.get(initialObject.getDiagram().getMRID()));
		if (initialObject.getDiagramObjectPoints().size() != 0){
			clone.setDiagramObjectPoints(new ArrayList<>());
			initialObject.getDiagramObjectPoints().forEach(o -> clone.getDiagramObjectPoints().add((DiagramObjectPoint) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramObjectStyle() != null) clone.setDiagramObjectStyle((DiagramObjectStyle) clonedObjects.get(initialObject.getDiagramObjectStyle().getMRID()));
	}
	private void addAssociationsToClonedObject(DiagramObjectGluePoint initialObject){
		DiagramObjectGluePoint clone = (DiagramObjectGluePoint) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjectPoints().size() != 0){
			clone.setDiagramObjectPoints(new ArrayList<>());
			initialObject.getDiagramObjectPoints().forEach(o -> clone.getDiagramObjectPoints().add((DiagramObjectPoint) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DiagramObjectPoint initialObject){
		DiagramObjectPoint clone = (DiagramObjectPoint) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObject() != null) clone.setDiagramObject((DiagramObject) clonedObjects.get(initialObject.getDiagramObject().getMRID()));
		if (initialObject.getDiagramObjectGluePoint() != null) clone.setDiagramObjectGluePoint((DiagramObjectGluePoint) clonedObjects.get(initialObject.getDiagramObjectGluePoint().getMRID()));
	}
	private void addAssociationsToClonedObject(DiagramObjectStyle initialObject){
		DiagramObjectStyle clone = (DiagramObjectStyle) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getStyledObjects().size() != 0){
			clone.setStyledObjects(new ArrayList<>());
			initialObject.getStyledObjects().forEach(o -> clone.getStyledObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DiagramStyle initialObject){
		DiagramStyle clone = (DiagramStyle) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagram().size() != 0){
			clone.setDiagram(new ArrayList<>());
			initialObject.getDiagram().forEach(o -> clone.getDiagram().add((Diagram) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(TextDiagramObject initialObject){
		TextDiagramObject clone = (TextDiagramObject) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getIdentifiedObject() != null) clone.setIdentifiedObject((IdentifiedObject) clonedObjects.get(initialObject.getIdentifiedObject().getMRID()));
		if (initialObject.getDiagram() != null) clone.setDiagram((Diagram) clonedObjects.get(initialObject.getDiagram().getMRID()));
		if (initialObject.getDiagramObjectPoints().size() != 0){
			clone.setDiagramObjectPoints(new ArrayList<>());
			initialObject.getDiagramObjectPoints().forEach(o -> clone.getDiagramObjectPoints().add((DiagramObjectPoint) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramObjectStyle() != null) clone.setDiagramObjectStyle((DiagramObjectStyle) clonedObjects.get(initialObject.getDiagramObjectStyle().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(VisibilityLayer initialObject){
		VisibilityLayer clone = (VisibilityLayer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EquivalentBranch initialObject){
		EquivalentBranch clone = (EquivalentBranch) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquivalentNetwork() != null) clone.setEquivalentNetwork((EquivalentNetwork) clonedObjects.get(initialObject.getEquivalentNetwork().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EquivalentEquipment initialObject){
		EquivalentEquipment clone = (EquivalentEquipment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquivalentNetwork() != null) clone.setEquivalentNetwork((EquivalentNetwork) clonedObjects.get(initialObject.getEquivalentNetwork().getMRID()));
	}
	private void addAssociationsToClonedObject(EquivalentInjection initialObject){
		EquivalentInjection clone = (EquivalentInjection) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquivalentNetwork() != null) clone.setEquivalentNetwork((EquivalentNetwork) clonedObjects.get(initialObject.getEquivalentNetwork().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getReactiveCapabilityCurve() != null) clone.setReactiveCapabilityCurve((ReactiveCapabilityCurve) clonedObjects.get(initialObject.getReactiveCapabilityCurve().getMRID()));
	}
	private void addAssociationsToClonedObject(EquivalentNetwork initialObject){
		EquivalentNetwork clone = (EquivalentNetwork) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquivalentEquipments().size() != 0){
			clone.setEquivalentEquipments(new ArrayList<>());
			initialObject.getEquivalentEquipments().forEach(o -> clone.getEquivalentEquipments().add((EquivalentEquipment) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EquivalentShunt initialObject){
		EquivalentShunt clone = (EquivalentShunt) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquivalentNetwork() != null) clone.setEquivalentNetwork((EquivalentNetwork) clonedObjects.get(initialObject.getEquivalentNetwork().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EquipmentFault initialObject){
		EquipmentFault clone = (EquipmentFault) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getOutage() != null) clone.setOutage((Outage) clonedObjects.get(initialObject.getOutage().getMRID()));
		if (initialObject.getFaultyEquipment() != null) clone.setFaultyEquipment((Equipment) clonedObjects.get(initialObject.getFaultyEquipment().getMRID()));
		if (initialObject.getCalculatedSvVoltages().size() != 0){
			clone.setCalculatedSvVoltages(new ArrayList<>());
			initialObject.getCalculatedSvVoltages().forEach(o -> clone.getCalculatedSvVoltages().add((SvVoltage) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCalculatedSvPowerFlows().size() != 0){
			clone.setCalculatedSvPowerFlows(new ArrayList<>());
			initialObject.getCalculatedSvPowerFlows().forEach(o -> clone.getCalculatedSvPowerFlows().add((SvPowerFlow) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getSvPowerFlows().size() != 0){
			clone.setSvPowerFlows(new ArrayList<>());
			initialObject.getSvPowerFlows().forEach(o -> clone.getSvPowerFlows().add((SvPowerFlow) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvVoltages().size() != 0){
			clone.setSvVoltages(new ArrayList<>());
			initialObject.getSvVoltages().forEach(o -> clone.getSvVoltages().add((SvVoltage) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Fault initialObject){
		Fault clone = (Fault) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getOutage() != null) clone.setOutage((Outage) clonedObjects.get(initialObject.getOutage().getMRID()));
		if (initialObject.getFaultyEquipment() != null) clone.setFaultyEquipment((Equipment) clonedObjects.get(initialObject.getFaultyEquipment().getMRID()));
		if (initialObject.getCalculatedSvVoltages().size() != 0){
			clone.setCalculatedSvVoltages(new ArrayList<>());
			initialObject.getCalculatedSvVoltages().forEach(o -> clone.getCalculatedSvVoltages().add((SvVoltage) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCalculatedSvPowerFlows().size() != 0){
			clone.setCalculatedSvPowerFlows(new ArrayList<>());
			initialObject.getCalculatedSvPowerFlows().forEach(o -> clone.getCalculatedSvPowerFlows().add((SvPowerFlow) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(FaultCauseType initialObject){
		FaultCauseType clone = (FaultCauseType) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(LineFault initialObject){
		LineFault clone = (LineFault) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getOutage() != null) clone.setOutage((Outage) clonedObjects.get(initialObject.getOutage().getMRID()));
		if (initialObject.getFaultyEquipment() != null) clone.setFaultyEquipment((Equipment) clonedObjects.get(initialObject.getFaultyEquipment().getMRID()));
		if (initialObject.getCalculatedSvVoltages().size() != 0){
			clone.setCalculatedSvVoltages(new ArrayList<>());
			initialObject.getCalculatedSvVoltages().forEach(o -> clone.getCalculatedSvVoltages().add((SvVoltage) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCalculatedSvPowerFlows().size() != 0){
			clone.setCalculatedSvPowerFlows(new ArrayList<>());
			initialObject.getCalculatedSvPowerFlows().forEach(o -> clone.getCalculatedSvPowerFlows().add((SvPowerFlow) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getACLineSegment() != null) clone.setACLineSegment((ACLineSegment) clonedObjects.get(initialObject.getACLineSegment().getMRID()));
	}
	private void addAssociationsToClonedObject(FossilFuel initialObject){
		FossilFuel clone = (FossilFuel) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getThermalGeneratingUnit() != null) clone.setThermalGeneratingUnit((ThermalGeneratingUnit) clonedObjects.get(initialObject.getThermalGeneratingUnit().getMRID()));
	}
	private void addAssociationsToClonedObject(GeneratingUnit initialObject){
		GeneratingUnit clone = (GeneratingUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRotatingMachine().size() != 0){
			clone.setRotatingMachine(new ArrayList<>());
			initialObject.getRotatingMachine().forEach(o -> clone.getRotatingMachine().add((RotatingMachine) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(HydroGeneratingUnit initialObject){
		HydroGeneratingUnit clone = (HydroGeneratingUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRotatingMachine().size() != 0){
			clone.setRotatingMachine(new ArrayList<>());
			initialObject.getRotatingMachine().forEach(o -> clone.getRotatingMachine().add((RotatingMachine) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getHydroPowerPlant() != null) clone.setHydroPowerPlant((HydroPowerPlant) clonedObjects.get(initialObject.getHydroPowerPlant().getMRID()));
	}
	private void addAssociationsToClonedObject(HydroPowerPlant initialObject){
		HydroPowerPlant clone = (HydroPowerPlant) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getHydroGeneratingUnits().size() != 0){
			clone.setHydroGeneratingUnits(new ArrayList<>());
			initialObject.getHydroGeneratingUnits().forEach(o -> clone.getHydroGeneratingUnits().add((HydroGeneratingUnit) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getHydroPumps().size() != 0){
			clone.setHydroPumps(new ArrayList<>());
			initialObject.getHydroPumps().forEach(o -> clone.getHydroPumps().add((HydroPump) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(HydroPump initialObject){
		HydroPump clone = (HydroPump) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getHydroPowerPlant() != null) clone.setHydroPowerPlant((HydroPowerPlant) clonedObjects.get(initialObject.getHydroPowerPlant().getMRID()));
		if (initialObject.getRotatingMachine() != null) clone.setRotatingMachine((RotatingMachine) clonedObjects.get(initialObject.getRotatingMachine().getMRID()));
	}
	private void addAssociationsToClonedObject(NuclearGeneratingUnit initialObject){
		NuclearGeneratingUnit clone = (NuclearGeneratingUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRotatingMachine().size() != 0){
			clone.setRotatingMachine(new ArrayList<>());
			initialObject.getRotatingMachine().forEach(o -> clone.getRotatingMachine().add((RotatingMachine) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(SolarGeneratingUnit initialObject){
		SolarGeneratingUnit clone = (SolarGeneratingUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRotatingMachine().size() != 0){
			clone.setRotatingMachine(new ArrayList<>());
			initialObject.getRotatingMachine().forEach(o -> clone.getRotatingMachine().add((RotatingMachine) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ThermalGeneratingUnit initialObject){
		ThermalGeneratingUnit clone = (ThermalGeneratingUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRotatingMachine().size() != 0){
			clone.setRotatingMachine(new ArrayList<>());
			initialObject.getRotatingMachine().forEach(o -> clone.getRotatingMachine().add((RotatingMachine) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFossilFuels().size() != 0){
			clone.setFossilFuels(new ArrayList<>());
			initialObject.getFossilFuels().forEach(o -> clone.getFossilFuels().add((FossilFuel) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(WindGeneratingUnit initialObject){
		WindGeneratingUnit clone = (WindGeneratingUnit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRotatingMachine().size() != 0){
			clone.setRotatingMachine(new ArrayList<>());
			initialObject.getRotatingMachine().forEach(o -> clone.getRotatingMachine().add((RotatingMachine) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ConformLoad initialObject){
		ConformLoad clone = (ConformLoad) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCluster() != null) clone.setCluster((ConsumersCluster) clonedObjects.get(initialObject.getCluster().getMRID()));
		if (initialObject.getVoltageCluster() != null) clone.setVoltageCluster((ConsumersVoltageCluster) clonedObjects.get(initialObject.getVoltageCluster().getMRID()));
		if (initialObject.getSubstationFeedingFrom() != null) clone.setSubstationFeedingFrom((Substation) clonedObjects.get(initialObject.getSubstationFeedingFrom().getMRID()));
		if (initialObject.getLoadResponse() != null) clone.setLoadResponse((LoadResponseCharacteristic) clonedObjects.get(initialObject.getLoadResponse().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLoadGroup() != null) clone.setLoadGroup((ConformLoadGroup) clonedObjects.get(initialObject.getLoadGroup().getMRID()));
	}
	private void addAssociationsToClonedObject(ConformLoadGroup initialObject){
		ConformLoadGroup clone = (ConformLoadGroup) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEnergyConsumers().size() != 0){
			clone.setEnergyConsumers(new ArrayList<>());
			initialObject.getEnergyConsumers().forEach(o -> clone.getEnergyConsumers().add((ConformLoad) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EnergyArea initialObject){
		EnergyArea clone = (EnergyArea) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(LoadGroup initialObject){
		LoadGroup clone = (LoadGroup) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(LoadResponseCharacteristic initialObject){
		LoadResponseCharacteristic clone = (LoadResponseCharacteristic) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEnergyConsumer().size() != 0){
			clone.setEnergyConsumer(new ArrayList<>());
			initialObject.getEnergyConsumer().forEach(o -> clone.getEnergyConsumer().add((EnergyConsumer) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(NonConformLoad initialObject){
		NonConformLoad clone = (NonConformLoad) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCluster() != null) clone.setCluster((ConsumersCluster) clonedObjects.get(initialObject.getCluster().getMRID()));
		if (initialObject.getVoltageCluster() != null) clone.setVoltageCluster((ConsumersVoltageCluster) clonedObjects.get(initialObject.getVoltageCluster().getMRID()));
		if (initialObject.getSubstationFeedingFrom() != null) clone.setSubstationFeedingFrom((Substation) clonedObjects.get(initialObject.getSubstationFeedingFrom().getMRID()));
		if (initialObject.getLoadResponse() != null) clone.setLoadResponse((LoadResponseCharacteristic) clonedObjects.get(initialObject.getLoadResponse().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLoadGroup() != null) clone.setLoadGroup((NonConformLoadGroup) clonedObjects.get(initialObject.getLoadGroup().getMRID()));
	}
	private void addAssociationsToClonedObject(NonConformLoadGroup initialObject){
		NonConformLoadGroup clone = (NonConformLoadGroup) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEnergyConsumers().size() != 0){
			clone.setEnergyConsumers(new ArrayList<>());
			initialObject.getEnergyConsumers().forEach(o -> clone.getEnergyConsumers().add((NonConformLoad) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(StationSupply initialObject){
		StationSupply clone = (StationSupply) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCluster() != null) clone.setCluster((ConsumersCluster) clonedObjects.get(initialObject.getCluster().getMRID()));
		if (initialObject.getVoltageCluster() != null) clone.setVoltageCluster((ConsumersVoltageCluster) clonedObjects.get(initialObject.getVoltageCluster().getMRID()));
		if (initialObject.getSubstationFeedingFrom() != null) clone.setSubstationFeedingFrom((Substation) clonedObjects.get(initialObject.getSubstationFeedingFrom().getMRID()));
		if (initialObject.getLoadResponse() != null) clone.setLoadResponse((LoadResponseCharacteristic) clonedObjects.get(initialObject.getLoadResponse().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Limit initialObject){
		Limit clone = (Limit) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(LimitSet initialObject){
		LimitSet clone = (LimitSet) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(DistanceRelay initialObject){
		DistanceRelay clone = (DistanceRelay) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCurrentTransformers().size() != 0){
			clone.setCurrentTransformers(new ArrayList<>());
			initialObject.getCurrentTransformers().forEach(o -> clone.getCurrentTransformers().add((CurrentTransformer) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPotentialTransformer().size() != 0){
			clone.setPotentialTransformer(new ArrayList<>());
			initialObject.getPotentialTransformer().forEach(o -> clone.getPotentialTransformer().add((PotentialTransformer) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodeForMaxVoltage() != null) clone.setConnectivityNodeForMaxVoltage((ConnectivityNode) clonedObjects.get(initialObject.getConnectivityNodeForMaxVoltage().getMRID()));
		if (initialObject.getTerminalInTheEndOfProtectedObject() != null) clone.setTerminalInTheEndOfProtectedObject((Terminal) clonedObjects.get(initialObject.getTerminalInTheEndOfProtectedObject().getMRID()));
		if (initialObject.getterminalForMaxLoadFlowCurrent() != null) clone.setterminalForMaxLoadFlowCurrent((Terminal) clonedObjects.get(initialObject.getterminalForMaxLoadFlowCurrent().getMRID()));
		if (initialObject.getTerminalForScCurrentInMainArea() != null) clone.setTerminalForScCurrentInMainArea((Terminal) clonedObjects.get(initialObject.getTerminalForScCurrentInMainArea().getMRID()));
		if (initialObject.getProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel() != null) clone.setProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel((ProtectionEquipment) clonedObjects.get(initialObject.getProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel().getMRID()));
		if (initialObject.getAdjacentProtectionEquipmentForSecondLevel() != null) clone.setAdjacentProtectionEquipmentForSecondLevel((ProtectionEquipment) clonedObjects.get(initialObject.getAdjacentProtectionEquipmentForSecondLevel().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(CurrentRelay initialObject){
		CurrentRelay clone = (CurrentRelay) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCurrentTransformers().size() != 0){
			clone.setCurrentTransformers(new ArrayList<>());
			initialObject.getCurrentTransformers().forEach(o -> clone.getCurrentTransformers().add((CurrentTransformer) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPotentialTransformer().size() != 0){
			clone.setPotentialTransformer(new ArrayList<>());
			initialObject.getPotentialTransformer().forEach(o -> clone.getPotentialTransformer().add((PotentialTransformer) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodeForMaxVoltage() != null) clone.setConnectivityNodeForMaxVoltage((ConnectivityNode) clonedObjects.get(initialObject.getConnectivityNodeForMaxVoltage().getMRID()));
		if (initialObject.getTerminalInTheEndOfProtectedObject() != null) clone.setTerminalInTheEndOfProtectedObject((Terminal) clonedObjects.get(initialObject.getTerminalInTheEndOfProtectedObject().getMRID()));
		if (initialObject.getterminalForMaxLoadFlowCurrent() != null) clone.setterminalForMaxLoadFlowCurrent((Terminal) clonedObjects.get(initialObject.getterminalForMaxLoadFlowCurrent().getMRID()));
		if (initialObject.getTerminalForScCurrentInMainArea() != null) clone.setTerminalForScCurrentInMainArea((Terminal) clonedObjects.get(initialObject.getTerminalForScCurrentInMainArea().getMRID()));
		if (initialObject.getProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel() != null) clone.setProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel((ProtectionEquipment) clonedObjects.get(initialObject.getProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel().getMRID()));
		if (initialObject.getAdjacentProtectionEquipmentForSecondLevel() != null) clone.setAdjacentProtectionEquipmentForSecondLevel((ProtectionEquipment) clonedObjects.get(initialObject.getAdjacentProtectionEquipmentForSecondLevel().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ProtectionEquipment initialObject){
		ProtectionEquipment clone = (ProtectionEquipment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCurrentTransformers().size() != 0){
			clone.setCurrentTransformers(new ArrayList<>());
			initialObject.getCurrentTransformers().forEach(o -> clone.getCurrentTransformers().add((CurrentTransformer) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPotentialTransformer().size() != 0){
			clone.setPotentialTransformer(new ArrayList<>());
			initialObject.getPotentialTransformer().forEach(o -> clone.getPotentialTransformer().add((PotentialTransformer) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodeForMaxVoltage() != null) clone.setConnectivityNodeForMaxVoltage((ConnectivityNode) clonedObjects.get(initialObject.getConnectivityNodeForMaxVoltage().getMRID()));
		if (initialObject.getTerminalInTheEndOfProtectedObject() != null) clone.setTerminalInTheEndOfProtectedObject((Terminal) clonedObjects.get(initialObject.getTerminalInTheEndOfProtectedObject().getMRID()));
		if (initialObject.getterminalForMaxLoadFlowCurrent() != null) clone.setterminalForMaxLoadFlowCurrent((Terminal) clonedObjects.get(initialObject.getterminalForMaxLoadFlowCurrent().getMRID()));
		if (initialObject.getTerminalForScCurrentInMainArea() != null) clone.setTerminalForScCurrentInMainArea((Terminal) clonedObjects.get(initialObject.getTerminalForScCurrentInMainArea().getMRID()));
		if (initialObject.getProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel() != null) clone.setProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel((ProtectionEquipment) clonedObjects.get(initialObject.getProtectionEquipmentForWichThisProtectionIsProtectionEquipmentSecondLevel().getMRID()));
		if (initialObject.getAdjacentProtectionEquipmentForSecondLevel() != null) clone.setAdjacentProtectionEquipmentForSecondLevel((ProtectionEquipment) clonedObjects.get(initialObject.getAdjacentProtectionEquipmentForSecondLevel().getMRID()));
	}
	private void addAssociationsToClonedObject(RecloseSequence initialObject){
		RecloseSequence clone = (RecloseSequence) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getProtectedSwitch() != null) clone.setProtectedSwitch((ProtectedSwitch) clonedObjects.get(initialObject.getProtectedSwitch().getMRID()));
	}
	private void addAssociationsToClonedObject(CILO initialObject){
		CILO clone = (CILO) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getProtectedSwitches().size() != 0){
			clone.setProtectedSwitches(new ArrayList<>());
			initialObject.getProtectedSwitches().forEach(o -> clone.getProtectedSwitches().add((ProtectedSwitch) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Common_LN initialObject){
		Common_LN clone = (Common_LN) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getProtectedSwitches().size() != 0){
			clone.setProtectedSwitches(new ArrayList<>());
			initialObject.getProtectedSwitches().forEach(o -> clone.getProtectedSwitches().add((ProtectedSwitch) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(CSWI initialObject){
		CSWI clone = (CSWI) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getProtectedSwitches().size() != 0){
			clone.setProtectedSwitches(new ArrayList<>());
			initialObject.getProtectedSwitches().forEach(o -> clone.getProtectedSwitches().add((ProtectedSwitch) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PDIF initialObject){
		PDIF clone = (PDIF) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getProtectedSwitches().size() != 0){
			clone.setProtectedSwitches(new ArrayList<>());
			initialObject.getProtectedSwitches().forEach(o -> clone.getProtectedSwitches().add((ProtectedSwitch) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PDIS initialObject){
		PDIS clone = (PDIS) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getProtectedSwitches().size() != 0){
			clone.setProtectedSwitches(new ArrayList<>());
			initialObject.getProtectedSwitches().forEach(o -> clone.getProtectedSwitches().add((ProtectedSwitch) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPDIS_Settings() != null) clone.setPDIS_Settings((PDIS_Settings) clonedObjects.get(initialObject.getPDIS_Settings().getMRID()));
	}
	private void addAssociationsToClonedObject(PDIS_Settings initialObject){
		PDIS_Settings clone = (PDIS_Settings) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getPDIS() != null) clone.setPDIS((PDIS) clonedObjects.get(initialObject.getPDIS().getMRID()));
	}
	private void addAssociationsToClonedObject(StateVariable initialObject){
		StateVariable clone = (StateVariable) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(SvInjection initialObject){
		SvInjection clone = (SvInjection) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode() != null) clone.setTopologicalNode((TopologicalNode) clonedObjects.get(initialObject.getTopologicalNode().getMRID()));
	}
	private void addAssociationsToClonedObject(SvPowerFlow initialObject){
		SvPowerFlow clone = (SvPowerFlow) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTerminalForResult() != null) clone.setTerminalForResult((Terminal) clonedObjects.get(initialObject.getTerminalForResult().getMRID()));
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getEquipmentFault() != null) clone.setEquipmentFault((EquipmentFault) clonedObjects.get(initialObject.getEquipmentFault().getMRID()));
		if (initialObject.getFault() != null) clone.setFault((Fault) clonedObjects.get(initialObject.getFault().getMRID()));
	}
	private void addAssociationsToClonedObject(SvShuntCompensatorSections initialObject){
		SvShuntCompensatorSections clone = (SvShuntCompensatorSections) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getShuntCompensator() != null) clone.setShuntCompensator((ShuntCompensator) clonedObjects.get(initialObject.getShuntCompensator().getMRID()));
	}
	private void addAssociationsToClonedObject(SvStatus initialObject){
		SvStatus clone = (SvStatus) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConductingEquipment() != null) clone.setConductingEquipment((ConductingEquipment) clonedObjects.get(initialObject.getConductingEquipment().getMRID()));
	}
	private void addAssociationsToClonedObject(SvTapStep initialObject){
		SvTapStep clone = (SvTapStep) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTapChanger() != null) clone.setTapChanger((TapChanger) clonedObjects.get(initialObject.getTapChanger().getMRID()));
	}
	private void addAssociationsToClonedObject(SvVoltage initialObject){
		SvVoltage clone = (SvVoltage) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentFault() != null) clone.setEquipmentFault((EquipmentFault) clonedObjects.get(initialObject.getEquipmentFault().getMRID()));
		if (initialObject.getFault() != null) clone.setFault((Fault) clonedObjects.get(initialObject.getFault().getMRID()));
		if (initialObject.getTopologicalNodeForResult() != null) clone.setTopologicalNodeForResult((TopologicalNode) clonedObjects.get(initialObject.getTopologicalNodeForResult().getMRID()));
		if (initialObject.getTopologicalNode() != null) clone.setTopologicalNode((TopologicalNode) clonedObjects.get(initialObject.getTopologicalNode().getMRID()));
	}
	private void addAssociationsToClonedObject(BusNameMarker initialObject){
		BusNameMarker clone = (BusNameMarker) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTerminal().size() != 0){
			clone.setTerminal(new ArrayList<>());
			initialObject.getTerminal().forEach(o -> clone.getTerminal().add((ACDCTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getReportingGroup() != null) clone.setReportingGroup((ReportingGroup) clonedObjects.get(initialObject.getReportingGroup().getMRID()));
	}
	private void addAssociationsToClonedObject(DCTopologicalNode initialObject){
		DCTopologicalNode clone = (DCTopologicalNode) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCTerminals().size() != 0){
			clone.setDCTerminals(new ArrayList<>());
			initialObject.getDCTerminals().forEach(o -> clone.getDCTerminals().add((DCBaseTerminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDCTopologicalIsland() != null) clone.setDCTopologicalIsland((DCTopologicalIsland) clonedObjects.get(initialObject.getDCTopologicalIsland().getMRID()));
	}
	private void addAssociationsToClonedObject(TopologicalIsland initialObject){
		TopologicalIsland clone = (TopologicalIsland) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalEquipments().size() != 0){
			clone.setTopologicalEquipments(new ArrayList<>());
			initialObject.getTopologicalEquipments().forEach(o -> clone.getTopologicalEquipments().add((ConductingEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getInternalNodesEquipments().size() != 0){
			clone.setInternalNodesEquipments(new ArrayList<>());
			initialObject.getInternalNodesEquipments().forEach(o -> clone.getInternalNodesEquipments().add((ConductingEquipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAngleRefTopologicalNode() != null) clone.setAngleRefTopologicalNode((TopologicalNode) clonedObjects.get(initialObject.getAngleRefTopologicalNode().getMRID()));
		if (initialObject.getTopologicalNodes().size() != 0){
			clone.setTopologicalNodes(new ArrayList<>());
			initialObject.getTopologicalNodes().forEach(o -> clone.getTopologicalNodes().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(TopologicalNode initialObject){
		TopologicalNode clone = (TopologicalNode) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodeContainer() != null) clone.setConnectivityNodeContainer((ConnectivityNodeContainer) clonedObjects.get(initialObject.getConnectivityNodeContainer().getMRID()));
		if (initialObject.getReportingGroup() != null) clone.setReportingGroup((ReportingGroup) clonedObjects.get(initialObject.getReportingGroup().getMRID()));
		if (initialObject.getTerminal().size() != 0){
			clone.setTerminal(new ArrayList<>());
			initialObject.getTerminal().forEach(o -> clone.getTerminal().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvInjection() != null) clone.setSvInjection((SvInjection) clonedObjects.get(initialObject.getSvInjection().getMRID()));
		if (initialObject.getResultVoltage().size() != 0){
			clone.setResultVoltage(new ArrayList<>());
			initialObject.getResultVoltage().forEach(o -> clone.getResultVoltage().add((SvVoltage) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvVoltage() != null) clone.setSvVoltage((SvVoltage) clonedObjects.get(initialObject.getSvVoltage().getMRID()));
		if (initialObject.getAngleRefTopologicalIsland() != null) clone.setAngleRefTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getAngleRefTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
	}
	private void addAssociationsToClonedObject(ACLineSegment initialObject){
		ACLineSegment clone = (ACLineSegment) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLineFaults().size() != 0){
			clone.setLineFaults(new ArrayList<>());
			initialObject.getLineFaults().forEach(o -> clone.getLineFaults().add((LineFault) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(AsynchronousMachine initialObject){
		AsynchronousMachine clone = (AsynchronousMachine) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getGeneratingUnit() != null) clone.setGeneratingUnit((GeneratingUnit) clonedObjects.get(initialObject.getGeneratingUnit().getMRID()));
		if (initialObject.getHydroPump() != null) clone.setHydroPump((HydroPump) clonedObjects.get(initialObject.getHydroPump().getMRID()));
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Breaker initialObject){
		Breaker clone = (Breaker) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRecloseSequences().size() != 0){
			clone.setRecloseSequences(new ArrayList<>());
			initialObject.getRecloseSequences().forEach(o -> clone.getRecloseSequences().add((RecloseSequence) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLN_Base() != null) clone.setLN_Base((Common_LN) clonedObjects.get(initialObject.getLN_Base().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(BusbarSection initialObject){
		BusbarSection clone = (BusbarSection) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Conductor initialObject){
		Conductor clone = (Conductor) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Connector initialObject){
		Connector clone = (Connector) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Disconnector initialObject){
		Disconnector clone = (Disconnector) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EarthFaultCompensator initialObject){
		EarthFaultCompensator clone = (EarthFaultCompensator) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(EnergyConsumer initialObject){
		EnergyConsumer clone = (EnergyConsumer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getCluster() != null) clone.setCluster((ConsumersCluster) clonedObjects.get(initialObject.getCluster().getMRID()));
		if (initialObject.getVoltageCluster() != null) clone.setVoltageCluster((ConsumersVoltageCluster) clonedObjects.get(initialObject.getVoltageCluster().getMRID()));
		if (initialObject.getSubstationFeedingFrom() != null) clone.setSubstationFeedingFrom((Substation) clonedObjects.get(initialObject.getSubstationFeedingFrom().getMRID()));
		if (initialObject.getLoadResponse() != null) clone.setLoadResponse((LoadResponseCharacteristic) clonedObjects.get(initialObject.getLoadResponse().getMRID()));
	}
	private void addAssociationsToClonedObject(EnergySource initialObject){
		EnergySource clone = (EnergySource) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ExternalNetworkInjection initialObject){
		ExternalNetworkInjection clone = (ExternalNetworkInjection) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(GroundDisconnector initialObject){
		GroundDisconnector clone = (GroundDisconnector) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Junction initialObject){
		Junction clone = (Junction) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Line initialObject){
		Line clone = (Line) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getEquipments().size() != 0){
			clone.setEquipments(new ArrayList<>());
			initialObject.getEquipments().forEach(o -> clone.getEquipments().add((Equipment) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getConnectivityNodes().size() != 0){
			clone.setConnectivityNodes(new ArrayList<>());
			initialObject.getConnectivityNodes().forEach(o -> clone.getConnectivityNodes().add((ConnectivityNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTopologicalNode().size() != 0){
			clone.setTopologicalNode(new ArrayList<>());
			initialObject.getTopologicalNode().forEach(o -> clone.getTopologicalNode().add((TopologicalNode) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegion() != null) clone.setRegion((SubGeographicalRegion) clonedObjects.get(initialObject.getRegion().getMRID()));
	}
	private void addAssociationsToClonedObject(LinearShuntCompensator initialObject){
		LinearShuntCompensator clone = (LinearShuntCompensator) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getSvShuntCompensatorSections() != null) clone.setSvShuntCompensatorSections((SvShuntCompensatorSections) clonedObjects.get(initialObject.getSvShuntCompensatorSections().getMRID()));
		if (initialObject.getShuntCompensatorPhase().size() != 0){
			clone.setShuntCompensatorPhase(new ArrayList<>());
			initialObject.getShuntCompensatorPhase().forEach(o -> clone.getShuntCompensatorPhase().add((ShuntCompensatorPhase) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(LoadBreakSwitch initialObject){
		LoadBreakSwitch clone = (LoadBreakSwitch) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRecloseSequences().size() != 0){
			clone.setRecloseSequences(new ArrayList<>());
			initialObject.getRecloseSequences().forEach(o -> clone.getRecloseSequences().add((RecloseSequence) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLN_Base() != null) clone.setLN_Base((Common_LN) clonedObjects.get(initialObject.getLN_Base().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(NonlinearShuntCompensator initialObject){
		NonlinearShuntCompensator clone = (NonlinearShuntCompensator) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getSvShuntCompensatorSections() != null) clone.setSvShuntCompensatorSections((SvShuntCompensatorSections) clonedObjects.get(initialObject.getSvShuntCompensatorSections().getMRID()));
		if (initialObject.getShuntCompensatorPhase().size() != 0){
			clone.setShuntCompensatorPhase(new ArrayList<>());
			initialObject.getShuntCompensatorPhase().forEach(o -> clone.getShuntCompensatorPhase().add((ShuntCompensatorPhase) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNonlinearShuntCompensatorPoints().size() != 0){
			clone.setNonlinearShuntCompensatorPoints(new ArrayList<>());
			initialObject.getNonlinearShuntCompensatorPoints().forEach(o -> clone.getNonlinearShuntCompensatorPoints().add((NonlinearShuntCompensatorPoint) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(NonlinearShuntCompensatorPoint initialObject){
		NonlinearShuntCompensatorPoint clone = (NonlinearShuntCompensatorPoint) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getNonlinearShuntCompensator() != null) clone.setNonlinearShuntCompensator((NonlinearShuntCompensator) clonedObjects.get(initialObject.getNonlinearShuntCompensator().getMRID()));
	}
	private void addAssociationsToClonedObject(PerLengthLineParameter initialObject){
		PerLengthLineParameter clone = (PerLengthLineParameter) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PetersenCoil initialObject){
		PetersenCoil clone = (PetersenCoil) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PhaseTapChanger initialObject){
		PhaseTapChanger clone = (PhaseTapChanger) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
	}
	private void addAssociationsToClonedObject(PhaseTapChangerAsymmetrical initialObject){
		PhaseTapChangerAsymmetrical clone = (PhaseTapChangerAsymmetrical) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PhaseTapChangerLinear initialObject){
		PhaseTapChangerLinear clone = (PhaseTapChangerLinear) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PhaseTapChangerNonLinear initialObject){
		PhaseTapChangerNonLinear clone = (PhaseTapChangerNonLinear) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PhaseTapChangerSymmetrical initialObject){
		PhaseTapChangerSymmetrical clone = (PhaseTapChangerSymmetrical) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PhaseTapChangerTable initialObject){
		PhaseTapChangerTable clone = (PhaseTapChangerTable) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPhaseTapChangerTabular().size() != 0){
			clone.setPhaseTapChangerTabular(new ArrayList<>());
			initialObject.getPhaseTapChangerTabular().forEach(o -> clone.getPhaseTapChangerTabular().add((PhaseTapChangerTabular) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPhaseTapChangerTablePoint().size() != 0){
			clone.setPhaseTapChangerTablePoint(new ArrayList<>());
			initialObject.getPhaseTapChangerTablePoint().forEach(o -> clone.getPhaseTapChangerTablePoint().add((PhaseTapChangerTablePoint) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PhaseTapChangerTablePoint initialObject){
		PhaseTapChangerTablePoint clone = (PhaseTapChangerTablePoint) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getPhaseTapChangerTable() != null) clone.setPhaseTapChangerTable((PhaseTapChangerTable) clonedObjects.get(initialObject.getPhaseTapChangerTable().getMRID()));
	}
	private void addAssociationsToClonedObject(PhaseTapChangerTabular initialObject){
		PhaseTapChangerTabular clone = (PhaseTapChangerTabular) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPhaseTapChangerTable() != null) clone.setPhaseTapChangerTable((PhaseTapChangerTable) clonedObjects.get(initialObject.getPhaseTapChangerTable().getMRID()));
	}
	private void addAssociationsToClonedObject(PowerTransformer initialObject){
		PowerTransformer clone = (PowerTransformer) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPowerTransformerEnd().size() != 0){
			clone.setPowerTransformerEnd(new ArrayList<>());
			initialObject.getPowerTransformerEnd().forEach(o -> clone.getPowerTransformerEnd().add((PowerTransformerEnd) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(PowerTransformerEnd initialObject){
		PowerTransformerEnd clone = (PowerTransformerEnd) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getPhaseTapChanger() != null) clone.setPhaseTapChanger((PhaseTapChanger) clonedObjects.get(initialObject.getPhaseTapChanger().getMRID()));
		if (initialObject.getRatioTapChanger() != null) clone.setRatioTapChanger((RatioTapChanger) clonedObjects.get(initialObject.getRatioTapChanger().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getPowerTransformer() != null) clone.setPowerTransformer((PowerTransformer) clonedObjects.get(initialObject.getPowerTransformer().getMRID()));
	}
	private void addAssociationsToClonedObject(ProtectedSwitch initialObject){
		ProtectedSwitch clone = (ProtectedSwitch) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRecloseSequences().size() != 0){
			clone.setRecloseSequences(new ArrayList<>());
			initialObject.getRecloseSequences().forEach(o -> clone.getRecloseSequences().add((RecloseSequence) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLN_Base() != null) clone.setLN_Base((Common_LN) clonedObjects.get(initialObject.getLN_Base().getMRID()));
	}
	private void addAssociationsToClonedObject(RatioTapChanger initialObject){
		RatioTapChanger clone = (RatioTapChanger) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRatioTapChangerTable() != null) clone.setRatioTapChangerTable((RatioTapChangerTable) clonedObjects.get(initialObject.getRatioTapChangerTable().getMRID()));
		if (initialObject.getTransformerEnd() != null) clone.setTransformerEnd((TransformerEnd) clonedObjects.get(initialObject.getTransformerEnd().getMRID()));
	}
	private void addAssociationsToClonedObject(RatioTapChangerTable initialObject){
		RatioTapChangerTable clone = (RatioTapChangerTable) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRatioTapChanger().size() != 0){
			clone.setRatioTapChanger(new ArrayList<>());
			initialObject.getRatioTapChanger().forEach(o -> clone.getRatioTapChanger().add((RatioTapChanger) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRatioTapChangerTablePoint().size() != 0){
			clone.setRatioTapChangerTablePoint(new ArrayList<>());
			initialObject.getRatioTapChangerTablePoint().forEach(o -> clone.getRatioTapChangerTablePoint().add((RatioTapChangerTablePoint) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(RatioTapChangerTablePoint initialObject){
		RatioTapChangerTablePoint clone = (RatioTapChangerTablePoint) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRatioTapChangerTable() != null) clone.setRatioTapChangerTable((RatioTapChangerTable) clonedObjects.get(initialObject.getRatioTapChangerTable().getMRID()));
	}
	private void addAssociationsToClonedObject(ReactiveCapabilityCurve initialObject){
		ReactiveCapabilityCurve clone = (ReactiveCapabilityCurve) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getCurveDatas().size() != 0){
			clone.setCurveDatas(new ArrayList<>());
			initialObject.getCurveDatas().forEach(o -> clone.getCurveDatas().add((CurveData) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquivalentInjection().size() != 0){
			clone.setEquivalentInjection(new ArrayList<>());
			initialObject.getEquivalentInjection().forEach(o -> clone.getEquivalentInjection().add((EquivalentInjection) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Recloser initialObject){
		Recloser clone = (Recloser) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRecloseSequences().size() != 0){
			clone.setRecloseSequences(new ArrayList<>());
			initialObject.getRecloseSequences().forEach(o -> clone.getRecloseSequences().add((RecloseSequence) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getLN_Base() != null) clone.setLN_Base((Common_LN) clonedObjects.get(initialObject.getLN_Base().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(RegulatingCondEq initialObject){
		RegulatingCondEq clone = (RegulatingCondEq) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
	}
	private void addAssociationsToClonedObject(RegulatingControl initialObject){
		RegulatingControl clone = (RegulatingControl) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getRegulatingCondEq().size() != 0){
			clone.setRegulatingCondEq(new ArrayList<>());
			initialObject.getRegulatingCondEq().forEach(o -> clone.getRegulatingCondEq().add((RegulatingCondEq) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(RotatingMachine initialObject){
		RotatingMachine clone = (RotatingMachine) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getGeneratingUnit() != null) clone.setGeneratingUnit((GeneratingUnit) clonedObjects.get(initialObject.getGeneratingUnit().getMRID()));
		if (initialObject.getHydroPump() != null) clone.setHydroPump((HydroPump) clonedObjects.get(initialObject.getHydroPump().getMRID()));
	}
	private void addAssociationsToClonedObject(SeriesCompensator initialObject){
		SeriesCompensator clone = (SeriesCompensator) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ShuntCompensator initialObject){
		ShuntCompensator clone = (ShuntCompensator) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvShuntCompensatorSections() != null) clone.setSvShuntCompensatorSections((SvShuntCompensatorSections) clonedObjects.get(initialObject.getSvShuntCompensatorSections().getMRID()));
		if (initialObject.getShuntCompensatorPhase().size() != 0){
			clone.setShuntCompensatorPhase(new ArrayList<>());
			initialObject.getShuntCompensatorPhase().forEach(o -> clone.getShuntCompensatorPhase().add((ShuntCompensatorPhase) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(ShuntCompensatorPhase initialObject){
		ShuntCompensatorPhase clone = (ShuntCompensatorPhase) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getShuntCompensator() != null) clone.setShuntCompensator((ShuntCompensator) clonedObjects.get(initialObject.getShuntCompensator().getMRID()));
	}
	private void addAssociationsToClonedObject(StaticVarCompensator initialObject){
		StaticVarCompensator clone = (StaticVarCompensator) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(Switch initialObject){
		Switch clone = (Switch) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(SynchronousMachine initialObject){
		SynchronousMachine clone = (SynchronousMachine) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getGeneratingUnit() != null) clone.setGeneratingUnit((GeneratingUnit) clonedObjects.get(initialObject.getGeneratingUnit().getMRID()));
		if (initialObject.getHydroPump() != null) clone.setHydroPump((HydroPump) clonedObjects.get(initialObject.getHydroPump().getMRID()));
		if (initialObject.getRegulatingControl() != null) clone.setRegulatingControl((RegulatingControl) clonedObjects.get(initialObject.getRegulatingControl().getMRID()));
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTopologicalIsland() != null) clone.setTopologicalIsland((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIsland().getMRID()));
		if (initialObject.getTopologicalIslandHavingInrernalNodes() != null) clone.setTopologicalIslandHavingInrernalNodes((TopologicalIsland) clonedObjects.get(initialObject.getTopologicalIslandHavingInrernalNodes().getMRID()));
		if (initialObject.getTerminals().size() != 0){
			clone.setTerminals(new ArrayList<>());
			initialObject.getTerminals().forEach(o -> clone.getTerminals().add((Terminal) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvStatus() != null) clone.setSvStatus((SvStatus) clonedObjects.get(initialObject.getSvStatus().getMRID()));
		if (initialObject.getFaults().size() != 0){
			clone.setFaults(new ArrayList<>());
			initialObject.getFaults().forEach(o -> clone.getFaults().add((Fault) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getEquipmentContainer() != null) clone.setEquipmentContainer((EquipmentContainer) clonedObjects.get(initialObject.getEquipmentContainer().getMRID()));
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(TapChanger initialObject){
		TapChanger clone = (TapChanger) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getSvTapStep() != null) clone.setSvTapStep((SvTapStep) clonedObjects.get(initialObject.getSvTapStep().getMRID()));
		if (initialObject.getTapChangerControl() != null) clone.setTapChangerControl((TapChangerControl) clonedObjects.get(initialObject.getTapChangerControl().getMRID()));
	}
	private void addAssociationsToClonedObject(TapChangerControl initialObject){
		TapChangerControl clone = (TapChangerControl) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getRegulatingCondEq().size() != 0){
			clone.setRegulatingCondEq(new ArrayList<>());
			initialObject.getRegulatingCondEq().forEach(o -> clone.getRegulatingCondEq().add((RegulatingCondEq) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getAssets() != null) clone.setAssets((Asset) clonedObjects.get(initialObject.getAssets().getMRID()));
		if (initialObject.getLocation() != null) clone.setLocation((Location) clonedObjects.get(initialObject.getLocation().getMRID()));
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getTapChanger().size() != 0){
			clone.setTapChanger(new ArrayList<>());
			initialObject.getTapChanger().forEach(o -> clone.getTapChanger().add((TapChanger) clonedObjects.get(o.getMRID())));
		}
	}
	private void addAssociationsToClonedObject(TapChangerTablePoint initialObject){
		TapChangerTablePoint clone = (TapChangerTablePoint) clonedObjects.get(initialObject.getMRID());
	}
	private void addAssociationsToClonedObject(TransformerEnd initialObject){
		TransformerEnd clone = (TransformerEnd) clonedObjects.get(initialObject.getMRID());
		if (initialObject.getDiagramObjects().size() != 0){
			clone.setDiagramObjects(new ArrayList<>());
			initialObject.getDiagramObjects().forEach(o -> clone.getDiagramObjects().add((DiagramObject) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getNames().size() != 0){
			clone.setNames(new ArrayList<>());
			initialObject.getNames().forEach(o -> clone.getNames().add((Name) clonedObjects.get(o.getMRID())));
		}
		if (initialObject.getBaseVoltage() != null) clone.setBaseVoltage((BaseVoltage) clonedObjects.get(initialObject.getBaseVoltage().getMRID()));
		if (initialObject.getTerminal() != null) clone.setTerminal((Terminal) clonedObjects.get(initialObject.getTerminal().getMRID()));
		if (initialObject.getPhaseTapChanger() != null) clone.setPhaseTapChanger((PhaseTapChanger) clonedObjects.get(initialObject.getPhaseTapChanger().getMRID()));
		if (initialObject.getRatioTapChanger() != null) clone.setRatioTapChanger((RatioTapChanger) clonedObjects.get(initialObject.getRatioTapChanger().getMRID()));
	}
}
