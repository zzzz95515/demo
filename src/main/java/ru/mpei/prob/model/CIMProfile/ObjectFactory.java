package ru.mpei.prob.model.CIMProfile;

import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;

public class ObjectFactory {

    public static Voltage createVoltage(String value){
        Voltage o = new Voltage();
        o.setMultiplier(UnitMultiplier.k);
        o.setUnit(UnitSymbol.V);
        o.setValue(Float.parseFloat(value.replace(",",".")));
        return o;
    }
    public static Voltage createVoltage(String value, UnitMultiplier multiplier){
        Voltage o = new Voltage();
        o.setMultiplier(multiplier);
        o.setUnit(UnitSymbol.V);
        o.setValue(Float.parseFloat(value.replace(",",".")));
        return o;
    }

    public static ApparentPower createApparentPower(String value){
        ApparentPower o = new ApparentPower();
        o.setMultiplier(UnitMultiplier.M);
        o.setUnit(UnitSymbol.VA);
        o.setValue(Float.parseFloat(value.replace(",",".")));
        return o;
    }

    public static ActivePower createActivePower(String value, UnitMultiplier multiplier){
        ActivePower o = new ActivePower();
        o.setMultiplier(multiplier);
        o.setUnit(UnitSymbol.W);
        o.setValue(Float.parseFloat(value.replace(",",".")));
        return o;
    }

    public static CurrentFlow createCurrentFlow(String value){
        CurrentFlow o = new CurrentFlow();
        o.setMultiplier(UnitMultiplier.none);
        o.setUnit(UnitSymbol.A);
        o.setValue(Float.parseFloat(value.replace(",",".")));
        return o;
    }

    public static PerCent createPerCent(String value){
        PerCent o = new PerCent();
        o.setMultiplier(UnitMultiplier.none);
        o.setUnit(UnitSymbol.none);
        o.setValue(Float.parseFloat(value.replace(",",".")));
        return o;
    }

    public static Resistance createResistance(float value){
        Resistance o = new Resistance();
        o.setMultiplier(UnitMultiplier.none);
        o.setUnit(UnitSymbol.ohm);
        o.setValue(value);
        return o;
    }

    public static Reactance createReactance(float value){
        Reactance o = new Reactance();
        o.setMultiplier(UnitMultiplier.none);
        o.setUnit(UnitSymbol.ohm);
        o.setValue(value);
        return o;
    }

    public static Susceptance createSusceptance(float value){
        Susceptance o = new Susceptance();
        o.setMultiplier(UnitMultiplier.none);
        o.setUnit(UnitSymbol.S);
        o.setValue(value);
        return o;
    }

    public static ResistancePerLength createResistancePerLength(String value){
        if (value.equals("0")){
            return null;
        } else {
            ResistancePerLength rpl = new ResistancePerLength();
            rpl.setDenominatorMultiplier(UnitMultiplier.k);
            rpl.setDenominatorUnit(UnitSymbol.m);
            rpl.setMultiplier(UnitMultiplier.none);
            rpl.setUnit(UnitSymbol.ohm);
            rpl.setValue(Float.parseFloat(value.replace(",",".")));
            return rpl;
        }
    }
    public static InductancePerLength createInductancePerLength(String value){
        if (value.equals("0")){
            return null;
        } else {
            InductancePerLength lpl = new InductancePerLength();
            lpl.setDenominatorMultiplier(UnitMultiplier.k);
            lpl.setDenominatorUnit(UnitSymbol.m);
            lpl.setMultiplier(UnitMultiplier.m);
            lpl.setUnit(UnitSymbol.H);
            lpl.setValue(Float.parseFloat(value.replace(",",".")));
            return lpl;
        }
    }
    public static CapacitancePerLength createCapacitancePerLength(String value){
        if (value.equals("0")){
            return null;
        } else {
            CapacitancePerLength cpl = new CapacitancePerLength();
            cpl.setDenominatorMultiplier(UnitMultiplier.k);
            cpl.setDenominatorUnit(UnitSymbol.m);
            cpl.setMultiplier(UnitMultiplier.micro);
            cpl.setUnit(UnitSymbol.F);
            cpl.setValue(Float.parseFloat(value.replace(",",".")));
            return cpl;
        }
    }

}
