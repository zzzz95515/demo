package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Equivalents.EquivalentEquipment;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.FieldSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equivalentwindmachine")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquivalentWindMachine extends EquivalentEquipment {

    /**
     * Nominal power, kW
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="nnom_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="nnom_unit")),
            @AttributeOverride(name="value", column=@Column(name="nnom_value")),
    })
    private Float Nnom;

    /**
     * Wind wheel speed, rad/sec
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="speed_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="speed_unit")),
            @AttributeOverride(name="value", column=@Column(name="speed_value")),
    })
    private Float speed;

    /**
     * Momentum of wind wheel, N*m
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="mww_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="mww_unit")),
            @AttributeOverride(name="value", column=@Column(name="mww_value")),
    })
    private Float Mww;

    /**
     * Wind wheel speed, round per minute
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="n_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="n_unit")),
            @AttributeOverride(name="value", column=@Column(name="n_value")),
    })
    private Float n;

    /**
     * Nominal momentum of wind wheel, N*m
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="mnom_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="mnom_unit")),
            @AttributeOverride(name="value", column=@Column(name="mnom_value")),
    })
    private Float Mnom;

    /**
     * Nominal power of wind wheel, kW
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="nww_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="nww_unit")),
            @AttributeOverride(name="value", column=@Column(name="nww_value")),
    })
    private Float Nww;

    /**
     * Propeller efficiency, p.u.
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="efficiency_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="efficiency_unit")),
            @AttributeOverride(name="value", column=@Column(name="efficiency_value")),
    })
    private Float efficiency;

    /**
     * Radius of wind wheel, meters
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="r_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="r_unit")),
            @AttributeOverride(name="value", column=@Column(name="r_value")),
    })
    private Float R;

    /**
     * Aerodynamic moment of wind wheel, p.u.
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="m_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="m_unit")),
            @AttributeOverride(name="value", column=@Column(name="m_value")),
    })
    private Float m;

    /**
     * Angle of rotation of wind wheel, degree
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="angle_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="angle_unit")),
            @AttributeOverride(name="value", column=@Column(name="angle_value")),
    })
    private Float angle;

    /**
     * Active power, kW
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="p_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="p_unit")),
            @AttributeOverride(name="value", column=@Column(name="p_value")),
    })
    private Float currentP;

    /**
     * Reactive power, kVar
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="q_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="q_unit")),
            @AttributeOverride(name="value", column=@Column(name="q_value")),
    })
    private Float currentQ;

    /**
     * Power factor, p.u.
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="powerFactor_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="powerFactor_unit")),
            @AttributeOverride(name="value", column=@Column(name="powerFactor_value")),
    })
    private Float powerFactor;

    /**
     * Nominal current, kA
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="inom_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="inom_unit")),
            @AttributeOverride(name="value", column=@Column(name="inom_value")),
    })
    private Float Inom;

    /**
     * Wind Machine Type according IEC 61400-27
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "windMachineType")
    private WindMachineType windMachineType;

    /**
     * Power characteristic (energy)
     */
    @ElementCollection
    private List<Float> powerList;

    /**
     * Power characteristic (wind)
     */
    @ElementCollection
    private List<Float> windList;


    public Float getPowerFactor() {
        return powerFactor;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.powerFactor", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setPowerFactor(Float powerFactor) {
        this.powerFactor = powerFactor;
    }

    public List<Float> getPowerList() {
        return powerList;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.powerList", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
    public void setPowerList(List<Float> powerList) {
        this.powerList = powerList;
    }

    public Float getNnom() {
        return Nnom;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.Nnom", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setNnom(Float nnom) {
        Nnom = nnom;
    }

    public Float getSpeed() {
        return speed;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.speed", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getMww() {
        return Mww;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.Mww", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setMww(Float mww) {
        Mww = mww;
    }

    public Float getN() {
        return n;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.n", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setN(Float n) {
        this.n = n;
    }

    public Float getMnom() {
        return Mnom;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.Mnom", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setMnom(Float mnom) {
        Mnom = mnom;
    }

    public Float getNww() {
        return Nww;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.Nww", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setNww(Float nww) {
        Nww = nww;
    }

    public Float getEfficiency() {
        return efficiency;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.efficiency", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setEfficiency(Float efficiency) {
        this.efficiency = efficiency;
    }

    public Float getR() {
        return R;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.R", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setR(Float r) {
        R = r;
    }

    public Float getM() {
        return m;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.m", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setM(Float m) {
        this.m = m;
    }

    public Float getAngle() {
        return angle;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.angle", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setAngle(Float angle) {
        this.angle = angle;
    }

    public Float getCurrentP() {
        return currentP;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.P", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setCurrentP(Float currentP) {
        this.currentP = currentP;
    }

    public Float getCurrentQ() {
        return currentQ;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.Q", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setCurrentQ(Float currentQ) {
        this.currentQ = currentQ;
    }

    public List<Float> getWindList() {
        return windList;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.windList", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
    public void setWindList(List<Float> windList) {
        this.windList = windList;
    }

    public Float getInom() {
        return Inom;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.Inom", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setInom(Float inom) {
        Inom = inom;
    }

    public WindMachineType getWindMachineType() {
        return windMachineType;
    }

    @FieldSetter(fieldName = "EquivalentWindMachine.windMachineType", fieldTypeStereotype = "Enumeration", fieldStereotype = "nti")
    public void setWindMachineType(WindMachineType windMachineType) {
        this.windMachineType = windMachineType;
    }
}
