package ru.mpei.prob.model.Library;

import lombok.Setter;
import org.apache.commons.io.IOUtils;
import ru.mpei.prob.repository.IdimRepository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ImportMethods {

    @Setter
    private IdimRepository repository;

    public List<Object> load(InputStream stream, String className){
        List<Object> objectList = null;
        String file;
        CommaSeparatedValues csv;
        try {
            file = IOUtils.toString(stream, StandardCharsets.UTF_8);
            csv =  CsvReader.read(file, 1);
            objectList = ObjectReader.read(csv,className);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }

//    public void addAdditionalInfoToObjects(Map<String, Object> objectMap){
//        IdentifiedObject io;
//        for (Object obj: objectMap.values()){
//            io = (IdentifiedObject) obj;
//
//            if ((io.getClassName().equals(CimClassName.ACLineSegment))){
//                this.addAdditionalInfoToACLineSegment(io);
//            }
//            else if ((io.getClassName().equals(CimClassName.PowerTransformer))){
//                this.addAdditionalInfoToPowerTransformer(io);
//            }
//            else if ((io.getClassName().equals(CimClassName.Breaker))){
//                this.addAdditionalInfoToBreaker(io);
//            }
//            else if ((io.getClassName().equals(CimClassName.Substation))){
//                this.addAdditionalInfoToSubstation(io);
//            }
//        }
//    }

//    private void addAdditionalInfoToACLineSegment(IdentifiedObject io){
//        ACLineSegment acls = (ACLineSegment) io;
//        Voltage ratedVoltage;
//        if (acls.getBrand()!=null){
//            ACLineSegment aclsLibrary = repository.getACLineSegmetFromLibraryByName(acls.getBrand());
//
//            acls.setLongPermissibleCurrent(aclsLibrary.getLongPermissibleCurrent());
//            acls.setPriceAdditionalValue(aclsLibrary.getPriceAdditionalValue());
//            //acls.setB0ch(aclsLibrary.getB0ch());
//            //acls.setBch(aclsLibrary.getBch());
////            acls.setG0ch(aclsLibrary.getG0ch());
////            acls.setGch(aclsLibrary.getGch());
//            acls.setR0PerLength(aclsLibrary.getR0PerLength());
//            acls.setRPerLength(aclsLibrary.getRPerLength());
//            acls.setL0PerLength(aclsLibrary.getL0PerLength());
//            acls.setLPerLength(aclsLibrary.getLPerLength());
//            acls.setCrossSectionalArea(aclsLibrary.getCrossSectionalArea());
//            acls.setMaxPermissibleVoltage(aclsLibrary.getMaxPermissibleVoltage());
//            acls.setConstructionLength(aclsLibrary.getConstructionLength());
//
//            ratedVoltage = new Voltage();
//            ratedVoltage.setValue(acls.getBaseVoltage().getNominalVoltage().getValue());
//            ratedVoltage.setMultiplier(UnitMultiplier.k);
//            ratedVoltage.setUnit(UnitSymbol.V);
//            acls.setFactorOper(1f);
//            acls.setFactorTech(1f);
//
//            if (aclsLibrary.getType().equals(ACLineSegmentType.overheadLine)){
//                OverheadLinePrice overheadLinePrice = new OverheadLinePrice();
//                acls.setType(ACLineSegmentType.overheadLine);
//                overheadLinePrice.setRatedVoltage(ratedVoltage);
//                overheadLinePrice.setCrossSectionalArea(aclsLibrary.getCrossSectionalArea().floatValue());
//
//                Integer price = repository.findPrice(overheadLinePrice);
//                acls.setPriceBase(price.floatValue());
//
//                acls.setPriceOper(0.02f);
//                acls.setPriceTech(0.003f);
//            }
//            if (acls.getType().equals(ACLineSegmentType.cableLine)){
//                CableLinePrice cableLinePrice = new CableLinePrice();
//                acls.setType(ACLineSegmentType.cableLine);
//                cableLinePrice.setRatedVoltage(ratedVoltage);
//                cableLinePrice.setCrossSectionalArea(aclsLibrary.getCrossSectionalArea().floatValue());
//
//                Integer price = repository.findPrice(cableLinePrice);
//                acls.setPriceBase(price.floatValue());
//                acls.setPriceCollector(aclsLibrary.getPriceCollector());
//                acls.setPriceSwitchPoint(aclsLibrary.getPriceSwitchPoint());
//                acls.setSwitchPointsNumber(aclsLibrary.getSwitchPointsNumber());
//            }
//
//            if (acls.getBaseVoltage().getNominalVoltage().getValue()<=11){
//                acls.setPriceOper(0.004f);
//                acls.setPriceTech(0.004f);
//            }
//            else{
//                acls.setPriceOper(0.02f);
//                acls.setPriceTech(0.003f);
//            }
//        }
//    }
//
//    private void addAdditionalInfoToPowerTransformer(IdentifiedObject io){
//        PowerTransformer pt = (PowerTransformer) io;
//        Voltage ratedVoltage;
//        ApparentPower ratedS;
//        if (pt.getBrand()!=null){
//            PowerTransformer ptLibrary = repository.getPowerTransformerFromLibraryByName(pt.getBrand());
//
//            TransformerCellPrice transformerCellPrice = new TransformerCellPrice();
//            LandPrice landPrice = new LandPrice();
//            ProjectPrice projectPrice = new ProjectPrice();
//
//            ratedS = new ApparentPower();
//
//            ratedVoltage = new Voltage();
//            ratedVoltage.setMultiplier(UnitMultiplier.k);
//            ratedVoltage.setUnit(UnitSymbol.V);
//            for (PowerTransformerEnd pte : pt.getPowerTransformerEnd()){
//                if (pte.getEndNumber()==1){
//                    ratedVoltage.setValue(pte.getRatedU().getValue());
//                    ratedS.setValue(pte.getRatedS().getValue());
//                    break;
//                }
//            }
//
//            transformerCellPrice.setRatedVoltage(ratedVoltage);
//            transformerCellPrice.setRatedS(ratedS);
//
//            landPrice.setRatedVoltage(ratedVoltage);
//            landPrice.setBuildingType(BuildingType.transformerCell);
//
//            projectPrice.setRatedVoltage(ratedVoltage);
//
//            Integer price1 = repository.findPrice(transformerCellPrice);
//            Float price2 = repository.findPriceLand(landPrice);
//            Integer price3 = repository.findPriceProject(projectPrice);
//
//            pt.setPriceBase(price1+price2+price3);
//            pt.setType(ptLibrary.getType());
//
//            pt.setFactorTech(1f);
//            pt.setPriceTech(0.059f);
//        }
//    }
//
//    private void addAdditionalInfoToBreaker(IdentifiedObject io){
//        Breaker br = (Breaker) io;
//        Voltage ratedVoltage;
//        if (br.getBrand()!=null){
//            Breaker brLibrary = repository.getBreakerFromLibraryByName(br.getBrand());
//
//            BreakerCellPrice breakerCellPrice = new BreakerCellPrice();
//            LandPrice landPrice = new LandPrice();
//            ProjectPrice projectPrice = new ProjectPrice();
//
//            ratedVoltage = new Voltage();
//            ratedVoltage.setValue(br.getBaseVoltage().getNominalVoltage().getValue());
//            ratedVoltage.setMultiplier(UnitMultiplier.k);
//            ratedVoltage.setUnit(UnitSymbol.V);
//
//            breakerCellPrice.setRatedVoltage(ratedVoltage);
//            breakerCellPrice.setRatedCurrent( brLibrary.getRatedCurrent());
//
//            landPrice.setRatedVoltage(ratedVoltage);
//            landPrice.setBuildingType(
//                    (brLibrary.getType().toString().equals("outDoor")) ?
//                            BuildingType.outdoorCircuitBreakerCell :
//                            BuildingType.indoorCircuitBreakerCell);
//
//            projectPrice.setRatedVoltage(ratedVoltage);
//            projectPrice.setBuildingType(BuildingType.circuitBreakerCell);
//
//            Integer price1 = repository.findPrice(breakerCellPrice);
//            Float price2 = repository.findPriceLand(landPrice);
//            Integer price3 = repository.findPriceProject(projectPrice);
//
//            br.setPriceBase(price1+price2+price3);
//            br.setType(brLibrary.getType());
//            br.setRatedCurrent(brLibrary.getRatedCurrent());
//
//            br.setFactorTech(1f);
//            br.setPriceTech(0.059f);
//        }
//    }
//
//    private void addAdditionalInfoToSubstation(IdentifiedObject io){
//        Substation subs = (Substation) io;
//        LandPrice landPriceBuilding = new LandPrice();
//        LandPrice landPriceOther = new LandPrice();
//        Voltage ratedVoltage;
//
//        List <VoltageLevel> voltageLevels = subs.getVoltageLevels();
//        List<Equipment> substationEquipments = subs.getEquipments();
//
//        ratedVoltage = new Voltage();
//        float maxVoltage = 0f;
//        for (VoltageLevel vlevel : voltageLevels){
//            if (vlevel.getBaseVoltage().getNominalVoltage().getValue() > maxVoltage){
//                maxVoltage = vlevel.getBaseVoltage().getNominalVoltage().getValue();
//            }
//        }
//        ratedVoltage.setValue(maxVoltage);
//        ratedVoltage.setMultiplier(UnitMultiplier.k);
//        ratedVoltage.setUnit(UnitSymbol.V);
//
//        landPriceBuilding.setRatedVoltage(ratedVoltage);
//        landPriceBuilding.setBuildingType(BuildingType.building);
//        landPriceOther.setRatedVoltage(ratedVoltage);
//        landPriceOther.setBuildingType(BuildingType.otherCosts);
//
//        Float price1 = repository.findPriceSubstation(landPriceBuilding);
//        Float price2 = repository.findPriceSubstation(landPriceOther);
//        subs.setPriceBase(price1+price2);
//
//        if (substationEquipments != null){
//            for (Equipment eq : substationEquipments){
//                if (eq instanceof PowerTransformer){
//                    if (ratedVoltage.getValue() >=35){
//                        subs.setType(SubstationType.transformerAndDistributionSubstation);
//                    }
//                    else {
//                        subs.setType(SubstationType.transformerSubstation);
//                    }
//                    break;
//                }
//                else{
//                    subs.setType(SubstationType.distributionSubstation);
//                }
//            }
//        }
//    }
}
