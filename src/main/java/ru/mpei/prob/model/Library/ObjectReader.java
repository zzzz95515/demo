package ru.mpei.prob.model.Library;

import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.*;
import ru.mpei.prob.model.CIMProfile.NTI.ACLineSegmentType;
import ru.mpei.prob.model.CIMProfile.NTI.BreakerType;
import ru.mpei.prob.model.CIMProfile.NTI.CimClassName;
import ru.mpei.prob.model.CIMProfile.NTI.EnergyStorageSystems.BatteryBankCell;
import ru.mpei.prob.model.CIMProfile.ObjectFactory;
import ru.mpei.prob.model.Library.Tables.CapexOpex.*;
import ru.mpei.prob.model.Library.Tables.Reliability.ACLineSegmentReliability;
import ru.mpei.prob.model.Library.Tables.Reliability.BreakerReliability;
import ru.mpei.prob.model.Library.Tables.Reliability.PowerTransformerReliability;
import ru.mpei.prob.model.Library.Tables.Reliability.Reliability;

import java.util.ArrayList;
import java.util.List;

public class ObjectReader {

    public static List<Object> read (CommaSeparatedValues csv, String className){
        List<Object> objects = null;

        switch (className.toLowerCase()) {
            case "aclinesegment":
                objects = ObjectReader.readACLineSegment(csv);
                break;
            case "powertransformer":
                objects = ObjectReader.readPowerTransformer(csv);
                break;
            case "breaker":
                objects = ObjectReader.readBreaker(csv);
                break;
            case "overheadlineprice":
                objects = ObjectReader.readOverheadLinePrice(csv);
                break;
            case "cablelineprice":
                objects = ObjectReader.readCableLinePrice(csv);
                break;
            case "landprice":
                objects = ObjectReader.readLandPrice(csv);
                break;
            case "projectprice":
                objects = ObjectReader.readProjectPrice(csv);
                break;
            case "transformercellprice":
                objects = ObjectReader.readTransformerCellPrice(csv);
                break;
            case "breakercellprice":
                objects = ObjectReader.readBreakerCellPrice(csv);
                break;
            case "aclinesegmentreliability":
                objects = ObjectReader.readACLineSegmentReliability(csv);
                break;
            case "breakerreliability":
                objects = ObjectReader.readBreakerReliability(csv);
                break;
            case "powertransformerreliability":
                objects = ObjectReader.readPowerTransformerReliability(csv);
                break;
            case "batterybankcell":
                objects = ObjectReader.readBatteryBankCell(csv);
                break;
            default:
                throw new IllegalStateException("Unexpected table name: " + className.toLowerCase());
        }

        return objects;
    }

    private static List<Object> readBatteryBankCell(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        BatteryBankCell bbc;
        for(int index=0; index < csv.size(); index++){
            bbc = new BatteryBankCell();
            bbc.setClassName(CimClassName.BatteryBankCell);
            bbc.setProjectID("LIBRARY");
            objects.add(bbc);
            try {
                bbc.setMRID(csv.getCell("id",index));
                bbc.setBrand(csv.getCell("brand",index));
                bbc.setName(csv.getCell("name",index));
                bbc.setCapacity(Float.parseFloat(csv.getCell("capacity",index)));
                bbc.setRatedVoltage(ObjectFactory.createVoltage(csv.getCell("ratedVoltage",index), UnitMultiplier.none));
                bbc.setMaxWorkingVoltage(ObjectFactory.createVoltage(csv.getCell("maxWorkingVoltage",index), UnitMultiplier.none));
                bbc.setMinWorkingVoltage(ObjectFactory.createVoltage(csv.getCell("minWorkingVoltage",index), UnitMultiplier.none));
                bbc.setRatedChargingCurrent(ObjectFactory.createCurrentFlow(csv.getCell("ratedChargingCurrent",index)));
                bbc.setRatedDischargingCurrent(ObjectFactory.createCurrentFlow(csv.getCell("ratedDischargingCurrent",index)));
                bbc.setMaxChargingCurrent(ObjectFactory.createCurrentFlow(csv.getCell("maxChargingCurrent",index)));
                bbc.setMaxDischargingCurrent(ObjectFactory.createCurrentFlow(csv.getCell("maxDischargingCurrent",index)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readPowerTransformerReliability(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        PowerTransformerReliability ptr;
        for(int index=0; index < csv.size(); index++){
            ptr = new PowerTransformerReliability();
            objects.add(ptr);
            try {
                ptr.setRatedS(ObjectFactory.createApparentPower(csv.getCell("ratedS",index)));
                ObjectReader.readReliabilityObject(ptr, csv, index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readBreakerReliability(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        BreakerReliability br;
        for(int index=0; index < csv.size(); index++){
            br = new BreakerReliability();
            objects.add(br);
            try {
                br.setRatedS(ObjectFactory.createApparentPower(csv.getCell("ratedS",index)));
                ObjectReader.readReliabilityObject(br, csv, index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readACLineSegmentReliability(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        ACLineSegmentReliability aclsr;
        for(int index=0; index < csv.size(); index++){
            aclsr = new ACLineSegmentReliability();
            objects.add(aclsr);
            try {
                if (csv.getCell("type",index).equals("КЛ")){
                    aclsr.setType(ACLineSegmentType.cableLine);
                } else {
                    aclsr.setType(ACLineSegmentType.overheadLine);
                }
                aclsr.setLineNumPerSupport(Integer.parseInt(csv.getCell("lineNumPerSupport",index)));
                ObjectReader.readReliabilityObject(aclsr, csv, index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static void readReliabilityObject(Reliability reliabilityObject, CommaSeparatedValues csv, int index){
        try {
            reliabilityObject.setId(Integer.parseInt(csv.getCell("id",index)));
            reliabilityObject.setFailureFlow(Float.parseFloat(csv.getCell("failureFlow",index)));
            reliabilityObject.setRecoveryTime(Float.parseFloat(csv.getCell("recoveryTime",index)));
            reliabilityObject.setPlannedRepairNumber(Float.parseFloat(csv.getCell("plannedRepairNumber",index)));
            reliabilityObject.setPlannedRepairTime(Float.parseFloat(csv.getCell("plannedRepairTime",index)));
            reliabilityObject.setRatedVoltage(ObjectFactory.createVoltage(csv.getCell("ratedVoltage",index)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static List<Object> readACLineSegment(CommaSeparatedValues csv) {
        List<Object> objects = new ArrayList<>();
        ACLineSegment acls;

        for(int index=0; index < csv.size(); index++){
            acls = new ACLineSegment();
            acls.setClassName(CimClassName.ACLineSegment);
            acls.setProjectID("LIBRARY");
            acls.setMRID("acls_" + index);
            try {
                acls.setBrand(csv.getCell("wireBrand",index));
                if (csv.getCell("type",index).equals("КЛ")){
                    acls.setType(ACLineSegmentType.cableLine);
                } else {
                    acls.setType(ACLineSegmentType.overheadLine);
                }
//                Susceptance bch = new Susceptance(); Susceptance b0ch = new Susceptance();
//                Conductance gch = new Conductance(); Conductance g0ch = new Conductance();
//                Resistance r = new Resistance(); Resistance r0 = new Resistance();
//                Reactance x = new Reactance(); Reactance x0 = new Reactance();

                ResistancePerLength rpl; ResistancePerLength r0pl;
                InductancePerLength lpl; InductancePerLength l0pl;
                CapacitancePerLength cpl; CapacitancePerLength c0pl;

//                b0ch.setValue((csv.getCell("b0ch",index).isEmpty()) ? null : Float.parseFloat(csv.getCell("b0ch",index)));
//                bch.setValue((csv.getCell("bch",index).isEmpty()) ? null : Float.parseFloat(csv.getCell("bch",index)));
//                g0ch.setValue((csv.getCell("g0ch",index).isEmpty()) ? null : Float.parseFloat(csv.getCell("g0ch",index)));
//                gch.setValue((csv.getCell("gch",index).isEmpty()) ? null : Float.parseFloat(csv.getCell("gch",index)));
                rpl = ObjectFactory.createResistancePerLength(csv.getCell("rPerLength",index));
                r0pl = ObjectFactory.createResistancePerLength(csv.getCell("r0PerLength",index));
                lpl = ObjectFactory.createInductancePerLength(csv.getCell("lPerLength",index));
                l0pl = ObjectFactory.createInductancePerLength(csv.getCell("l0PerLength",index));
                cpl = ObjectFactory.createCapacitancePerLength(csv.getCell("cPerLength",index));
                c0pl = ObjectFactory.createCapacitancePerLength(csv.getCell("c0PerLength",index));

                acls.setCrossSectionalArea((csv.getCell("crossSectionalArea",index).equals("0")) ? null : Float.parseFloat(csv.getCell("crossSectionalArea",index)));
                acls.setConstructionLength((csv.getCell("constructionLength",index).equals("0")) ? null : Float.parseFloat(csv.getCell("constructionLength",index)));
                acls.setMaxPermissibleVoltage((csv.getCell("maxPermissibleVoltage",index).equals("0")) ? null : Float.parseFloat(csv.getCell("maxPermissibleVoltage",index)));
                acls.setLongPermissibleCurrent((csv.getCell("longPermissibleCurrent",index).equals("0")) ? null : Float.parseFloat(csv.getCell("longPermissibleCurrent",index)));
                acls.setComplicationFactor((csv.getCell("complicationFactor",index).equals("0")) ? null : Float.parseFloat(csv.getCell("complicationFactor",index)));
                acls.setPriceAdditionalValue((csv.getCell("priceAdditionalValue",index).equals("0")) ? null : Float.parseFloat(csv.getCell("priceAdditionalValue",index)));
                acls.setPriceCollector((csv.getCell("priceCollector",index).equals("0")) ? null : Float.parseFloat(csv.getCell("priceCollector",index)));
                acls.setSwitchPointsNumber((csv.getCell("switchPointsNumber",index).equals("0")) ? null : Integer.parseInt(csv.getCell("switchPointsNumber",index)));
                acls.setPriceBase(Float.parseFloat(csv.getCell("priceBase",index)));
//                acls.setB0ch(b0ch); acls.setBch(bch);
//                acls.setG0ch(g0ch); acls.setGch(gch);
                acls.setRPerLength(rpl); acls.setR0PerLength(r0pl);
                acls.setLPerLength(lpl); acls.setL0PerLength(l0pl);
                acls.setCPerLength(cpl); acls.setC0PerLength(c0pl);

                objects.add(acls);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return objects;
    }

    private static List<Object> readOverheadLinePrice(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        OverheadLinePrice olp;
        Voltage ratedVoltage;
        for(int index=0; index < csv.size(); index++){
            olp = new OverheadLinePrice();
            try {
                olp.setId(Integer.parseInt(csv.getCell("id",index)));
                ratedVoltage = new Voltage(); ratedVoltage.setMultiplier(UnitMultiplier.k); ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("baseU",index)));
                olp.setRatedVoltage(ratedVoltage);
                olp.setPowerLineSupportType(Integer.parseInt(csv.getCell("powerLineSupportType",index)));
                olp.setConductorsNumPerPhase(Integer.parseInt(csv.getCell("conductorsNumPerPhase",index)));
                olp.setCrossSectionalArea(Float.parseFloat(csv.getCell("crossSectionalArea",index)));
                olp.setLineNumPerSupport(Integer.parseInt(csv.getCell("lineNumPerSupport",index)));
                olp.setPowerLineSupportMaterial(Integer.parseInt(csv.getCell("powerLineSupportMaterial",index)));
                olp.setPrice(Integer.parseInt(csv.getCell("price",index)));
                objects.add(olp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readCableLinePrice(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        CableLinePrice clp;
        Voltage ratedVoltage;
        for(int index=0; index < csv.size(); index++){
            clp = new CableLinePrice();
            try {
                clp.setId(Integer.parseInt(csv.getCell("id",index)));
                ratedVoltage = new Voltage(); ratedVoltage.setMultiplier(UnitMultiplier.k); ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("baseU",index)));
                clp.setRatedVoltage(ratedVoltage);
                clp.setCrossSectionalArea(Float.parseFloat(csv.getCell("crossSectionalArea",index)));
                clp.setPrice(Integer.parseInt(csv.getCell("price",index)));
                clp.setCableNumPerTrench(Integer.parseInt(csv.getCell("cableNumPerTrench",index)));
                clp.setPhaseNumPerCable(Integer.parseInt(csv.getCell("phaseNumPerCable",index)));
                objects.add(clp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readPowerTransformer(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        PowerTransformer pt;
        for(int index=0; index < csv.size(); index++){
            pt = new PowerTransformer();
            pt.setClassName(CimClassName.PowerTransformer);
            pt.setProjectID("LIBRARY");
            pt.setMRID("pt_" + index);
            try {
                pt.setBrand(csv.getCell("brand",index));
                pt.setIdlePower(ObjectFactory.createActivePower(csv.getCell("idlePower",index), UnitMultiplier.k));
                pt.setIdleCurrent(ObjectFactory.createPerCent(csv.getCell("idleCurrent",index)));
                pt.setUK_HighLow(ObjectFactory.createPerCent(csv.getCell("uK_HighLow",index)));
                pt.setPK_HighLow(ObjectFactory.createActivePower(csv.getCell("pK_HighLow",index), UnitMultiplier.k));
                pt.setRatedCurrent(ObjectFactory.createCurrentFlow(csv.getCell("ratedCurrentFromHighSide",index)));
                pt.setRatedS(ObjectFactory.createApparentPower(csv.getCell("ratedS",index)));

                PowerTransformerEnd pteHV = new PowerTransformerEnd();
                pteHV.setClassName(CimClassName.PowerTransformerEnd);
                pteHV.setProjectID("LIBRARY");
                pteHV.setMRID("pteHV_" + index);
                pteHV.setEndNumber(1);
                pteHV.setRatedS(ObjectFactory.createApparentPower(csv.getCell("ratedS",index)));
                pteHV.setRatedU(ObjectFactory.createVoltage(csv.getCell("ratedHighVoltage",index)));

                PowerTransformerEnd pteLV = new PowerTransformerEnd();
                pteLV.setClassName(CimClassName.PowerTransformerEnd);
                pteLV.setProjectID("LIBRARY");
                pteLV.setMRID("pteLV_" + index);
                pteLV.setRatedU(ObjectFactory.createVoltage(csv.getCell("ratedLowVoltage",index)));

                pt.setPowerTransformerEnd(new ArrayList<>());
                pt.getPowerTransformerEnd().add(pteHV);
                pt.getPowerTransformerEnd().add(pteLV);
                pteHV.setPowerTransformer(pt);
                pteLV.setPowerTransformer(pt);

                pt.setRatedHighVoltage(pteHV.getRatedU());
                pt.setRatedLowVoltage(pteLV.getRatedU());

                PowerTransformerEnd pteMV;

                switch (csv.getCell("type", index)) {
                    case "TwoWinding":
                        pt.setType(PowerTransformerType.TwoWinding);
                        float xT = ObjectReader.calculateXt(pt.getUK_HighLow().getValue(), pteHV);
                        float rT = ObjectReader.calculateRt(pt.getPK_HighLow().getValue(), pteHV);
                        float bT = ObjectReader.calculateBt(pt, pteHV);
                        pteHV.setR(ObjectFactory.createResistance(rT));
                        pteHV.setR0(pteHV.getR());
                        pteHV.setX(ObjectFactory.createReactance(xT));
                        pteHV.setX0(pteHV.getX());
                        pteHV.setB(ObjectFactory.createSusceptance(bT));
                        pteHV.setB0(pteHV.getB());

                        pteLV.setEndNumber(2);
                        break;
                    case "TwoWindingSplitted":
                        pt.setType(PowerTransformerType.TwoWindingSplitted);
                        break;
                    case "ThreeWinding":
                        pt.setType(PowerTransformerType.ThreeWinding);
                        break;
                    case "AutoTransformer":
                        pt.setType(PowerTransformerType.AutoTransformer);
                        break;
                    case "AutoTransformerSinglePhase":
                        pt.setType(PowerTransformerType.AutoTransformerSinglePhase);
                        break;
                }
                if (csv.getCell("type",index).equals("ThreeWinding")
                        || csv.getCell("type",index).equals("AutoTransformer")
                        || csv.getCell("type",index).equals("AutoTransformerSinglePhase")) {

                    pt.setType(PowerTransformerType.ThreeWinding);

                    pteMV = new PowerTransformerEnd();
                    pteMV.setProjectID("LIBRARY");
                    pteMV.setMRID("pteMV_" + index);
                    pteMV.setClassName(CimClassName.PowerTransformerEnd);
                    pteMV.setRatedU(ObjectFactory.createVoltage(csv.getCell("ratedMiddleVoltage", index)));

                    pt.setUK_HighMiddle(ObjectFactory.createPerCent(csv.getCell("uK_HighMiddle", index)));
                    pt.setUK_MiddleLow(ObjectFactory.createPerCent(csv.getCell("uK_MiddleLow", index)));
                    pt.setPK_HighMiddle(ObjectFactory.createActivePower(csv.getCell("uK_HighMiddle", index), UnitMultiplier.k));
                    pt.setPK_MiddleLow(ObjectFactory.createActivePower(csv.getCell("uK_MiddleLow", index), UnitMultiplier.k));

                    pt.getPowerTransformerEnd().add(pteMV);
                    pteMV.setPowerTransformer(pt);

                    pteMV.setEndNumber(2);
                    pteLV.setEndNumber(3);

                    pt.setRatedMiddleVoltage(pteMV.getRatedU());
                    /* расчет сопротивлений трансформатора с тремя сторонами */
                    {
                        float uK_H = 0.5f * (
                                + pt.getUK_HighMiddle().getValue()
                                + pt.getUK_HighLow().getValue()
                                - pt.getUK_MiddleLow().getValue());
                        float uK_M = 0.5f * (
                                + pt.getUK_HighMiddle().getValue()
                                - pt.getUK_HighLow().getValue()
                                + pt.getUK_MiddleLow().getValue());
                        float uK_L = 0.5f * (
                                - pt.getUK_HighMiddle().getValue()
                                + pt.getUK_HighLow().getValue()
                                + pt.getUK_MiddleLow().getValue());

                        float pK_H = 0.5f * (
                                + pt.getPK_HighMiddle().getValue()
                                + pt.getPK_HighLow().getValue()
                                - pt.getPK_MiddleLow().getValue());
                        float pK_M = 0.5f * (
                                + pt.getPK_HighMiddle().getValue()
                                - pt.getPK_HighLow().getValue()
                                + pt.getPK_MiddleLow().getValue());
                        float pK_L = 0.5f * (
                                - pt.getPK_HighMiddle().getValue()
                                + pt.getPK_HighLow().getValue()
                                + pt.getPK_MiddleLow().getValue());

                        float bT = ObjectReader.calculateBt(pt, pteHV);

                        float x_H = ObjectReader.calculateXt(uK_H, pteHV);
                        float x_M = ObjectReader.calculateXt(uK_M, pteHV);
                        float x_L = ObjectReader.calculateXt(uK_L, pteHV);
                        float r_H = ObjectReader.calculateRt(pK_H, pteHV);
                        float r_M = ObjectReader.calculateRt(pK_M, pteHV);
                        float r_L = ObjectReader.calculateRt(pK_L, pteHV);

                        pteHV.setX(ObjectFactory.createReactance(x_H));
                        pteHV.setX0(pteHV.getX());
                        pteMV.setX(ObjectFactory.createReactance(x_M));
                        pteMV.setX0(pteMV.getX());
                        pteLV.setX(ObjectFactory.createReactance(x_L));
                        pteLV.setX0(pteLV.getX());

                        pteHV.setR(ObjectFactory.createResistance(r_H));
                        pteHV.setR0(pteHV.getR());
                        pteMV.setR(ObjectFactory.createResistance(r_M));
                        pteMV.setR0(pteMV.getR());
                        pteLV.setR(ObjectFactory.createResistance(r_L));
                        pteLV.setR0(pteLV.getR());

                        pteHV.setB(ObjectFactory.createSusceptance(bT));
                        pteHV.setB0(pteHV.getB());
                        pteMV.setB(ObjectFactory.createSusceptance(bT));
                        pteMV.setB0(pteMV.getB());
                        pteLV.setB(ObjectFactory.createSusceptance(bT));
                        pteLV.setB0(pteLV.getB());
                    }

                }
                objects.add(pt);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readBreaker(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        Breaker br;
        CurrentFlow ratedCurrent;
        Voltage ratedVoltage;
        for(int index=0; index < csv.size(); index++){
            br = new Breaker();
            br.setClassName(CimClassName.Breaker);
            br.setProjectID("LIBRARY");
            br.setMRID("br_" + index);
            try {
                br.setBrand(csv.getCell("breakerBrand",index));

                ratedCurrent = new CurrentFlow();
                ratedCurrent.setMultiplier(UnitMultiplier.none);
                ratedCurrent.setUnit(UnitSymbol.A);
                ratedCurrent.setValue(Float.parseFloat(csv.getCell("ratedCurrent",index)));
                br.setRatedCurrent(ratedCurrent);
                ratedVoltage = new Voltage();
                ratedVoltage.setMultiplier(UnitMultiplier.k);
                ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("ratedVoltage",index)));

                if (csv.getCell("type",index).equals("outDoor")){
                    br.setType(BreakerType.outDoor);
                }
                if (csv.getCell("type",index).equals("inDoor")){
                    br.setType(BreakerType.inDoor);
                }
                objects.add(br);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readLandPrice(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        LandPrice lp;
        Voltage ratedVoltage;
        for(int index=0; index < csv.size(); index++){
            lp = new LandPrice();
            try {
                lp.setId(Integer.parseInt(csv.getCell("id",index)));
                ratedVoltage = new Voltage();
                ratedVoltage.setMultiplier(UnitMultiplier.k);
                ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("ratedVoltage",index)));
                lp.setRatedVoltage(ratedVoltage);
                lp.setPriceStandart(Float.parseFloat(csv.getCell("priceStandard",index)));
                lp.setSquare(Float.parseFloat(csv.getCell("square",index)));

                if (csv.getCell("buildingType",index).equals("outdoorCircuitBreakerCell")){
                    lp.setBuildingType(BuildingType.outdoorCircuitBreakerCell);
                }
                if (csv.getCell("buildingType",index).equals("indoorCircuitBreakerCell")){
                    lp.setBuildingType(BuildingType.indoorCircuitBreakerCell);
                }
                if (csv.getCell("buildingType",index).equals("transformerCell")){
                    lp.setBuildingType(BuildingType.transformerCell);
                }
                if (csv.getCell("buildingType",index).equals("building")){
                    lp.setBuildingType(BuildingType.building);
                }
                if (csv.getCell("buildingType",index).equals("otherCosts")){
                    lp.setBuildingType(BuildingType.otherCosts);
                }

                objects.add(lp);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readProjectPrice(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        ProjectPrice pp;
        Voltage ratedVoltage;
        for(int index=0; index < csv.size(); index++){
            pp = new ProjectPrice();
            try {
                pp.setId(Integer.parseInt(csv.getCell("id",index)));
                ratedVoltage = new Voltage();
                ratedVoltage.setMultiplier(UnitMultiplier.k);
                ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("ratedVoltage",index)));
                pp.setRatedVoltage(ratedVoltage);
                pp.setPrice(Integer.parseInt(csv.getCell("price",index)));

                if (csv.getCell("type",index).equals("circuitBreakerCell")){
                    pp.setBuildingType(BuildingType.circuitBreakerCell);
                }
                if (csv.getCell("type",index).equals("transformerCell")){
                    pp.setBuildingType(BuildingType.transformerCell);
                }

                objects.add(pp);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readTransformerCellPrice(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        TransformerCellPrice tcp;
        Voltage ratedVoltage;
        ApparentPower ratedS;
        for(int index=0; index < csv.size(); index++){
            tcp = new TransformerCellPrice();
            try {
                tcp.setId(Integer.parseInt(csv.getCell("id",index)));

                ratedVoltage = new Voltage();
                ratedVoltage.setMultiplier(UnitMultiplier.k);
                ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("ratedVoltage",index)));
                tcp.setRatedVoltage(ratedVoltage);

                ratedS = new ApparentPower();
                ratedS.setMultiplier(UnitMultiplier.M);
                ratedS.setUnit(UnitSymbol.VA);
                ratedS.setValue(Float.parseFloat(csv.getCell("ratedS",index)));
                tcp.setRatedS(ratedS);

                tcp.setPrice(Integer.parseInt(csv.getCell("price",index)));

                objects.add(tcp);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static List<Object> readBreakerCellPrice(CommaSeparatedValues csv){
        List<Object> objects = new ArrayList<>();
        BreakerCellPrice bcp;
        Voltage ratedVoltage;
        CurrentFlow ratedCurrent;
        for(int index=0; index < csv.size(); index++){
            bcp = new BreakerCellPrice();
            try {
                bcp.setId(Integer.parseInt(csv.getCell("id",index)));

                ratedVoltage = new Voltage();
                ratedVoltage.setMultiplier(UnitMultiplier.k);
                ratedVoltage.setUnit(UnitSymbol.V);
                ratedVoltage.setValue(Float.parseFloat(csv.getCell("ratedVoltage",index)));
                bcp.setRatedVoltage(ratedVoltage);

                ratedCurrent = new CurrentFlow();
                ratedCurrent.setMultiplier(UnitMultiplier.none);
                ratedCurrent.setUnit(UnitSymbol.A);
                ratedCurrent.setValue(Float.parseFloat(csv.getCell("ratedCurrent",index)));
                bcp.setRatedCurrent(ratedCurrent);

                bcp.setPrice(Integer.parseInt(csv.getCell("price",index)));

                objects.add(bcp);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    private static float calculateXt(float uK, PowerTransformerEnd pte){
        return (uK
                * pte.getRatedU().getValue()
                * pte.getRatedU().getValue() * 0.01f)
                / pte.getRatedS().getValue();
    }

    private static float calculateRt(float pK, PowerTransformerEnd pte){
        return (pK
                * pte.getRatedU().getValue()
                * pte.getRatedU().getValue() * 0.001f)
                / (pte.getRatedS().getValue() * pte.getRatedS().getValue());
    }

    private static float calculateBt(PowerTransformer pt, PowerTransformerEnd pte){
        return (pt.getIdleCurrent().getValue()
                * pte.getRatedS().getValue() * 0.01f)
                / (pte.getRatedU().getValue()
                * pte.getRatedU().getValue());
    }

}
