package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Domain.*;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.FieldSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distancerelay")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistanceRelay extends ProtectionEquipment {
    /**
     * вторичное реактивное сопротивление,
     * определяющее верхнюю границу характеристики
     * срабатывания комплектов
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="xSet1_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="xSet1_unit")),
            @AttributeOverride(name="value", column=@Column(name="xSet1_value")),
    })
    private Reactance xSet1;

    public Reactance getXSet1(){
        return this.xSet1;
    }

    @FieldSetter(fieldName = "DistanceRelay.xSet1", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setXSet1(Reactance xSet1){
        this.xSet1 = xSet1;
    }

    /**
     * вторичное активное сопротивление,
     * определяющее правую границу характеристики
     * срабатывания комплекта от междуфазных КЗ
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="rPPSet1_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="rPPSet1_unit")),
            @AttributeOverride(name="value", column=@Column(name="rPPSet1_value")),
    })
    private Resistance rPPSet1;

    public Resistance getRPPSet1(){
        return this.rPPSet1;
    }

    @FieldSetter(fieldName = "DistanceRelay.rPPSet1", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setRPPSet1(Resistance rPPSet1){
        this.rPPSet1 = rPPSet1;
    }

    /**
     * выдержка времени срабатывания первой ступени ДЗ
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="tOpSet1_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="tOpSet1_unit")),
            @AttributeOverride(name="value", column=@Column(name="tOpSet1_value")),
    })
    private Seconds tOpSet1;

    public Seconds getTOpSet1(){
        return this.tOpSet1;
    }

    @FieldSetter(fieldName = "DistanceRelay.tOpSet1", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setTOpSet1(Seconds tOpSet1){
        this.tOpSet1 = tOpSet1;
    }

    /**
     * вторичное реактивное сопротивление,
     * определяющее верхнюю границу характеристики
     * срабатывания комплектов
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="xSet2_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="xSet2_unit")),
            @AttributeOverride(name="value", column=@Column(name="xSet2_value")),
    })
    private Reactance xSet2;

    public Reactance getXSet2(){
        return this.xSet2;
    }

    @FieldSetter(fieldName = "DistanceRelay.xSet2", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setXSet2(Reactance xSet2) {
        this.xSet2 = xSet2;
    }

    /**
     * вторичное активное сопротивление,
     * определяющее правую границу характеристики
     * срабатывания комплекта от междуфазных КЗ
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="rPPSet2_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="rPPSet2_unit")),
            @AttributeOverride(name="value", column=@Column(name="rPPSet2_value")),
    })
    private Resistance rPPSet2;

    public Resistance getRPPSet2(){
        return this.rPPSet2;
    }

    @FieldSetter(fieldName = "DistanceRelay.rPPSet2", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setRPPSet2(Resistance rPPSet2){
        this.rPPSet2 = rPPSet2;
    }

    /**
     * вторичное активное сопротивление,
     * определяющее правую границу характеристики
     * срабатывания комплекта от двойных замыканий
     * на землю
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="rPGSet1_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="rPGSet1_unit")),
            @AttributeOverride(name="value", column=@Column(name="rPGSet1_value")),
    })
    private Resistance rPGSet1;

    public Resistance getRPGSet1(){
        return this.rPGSet1;
    }

    @FieldSetter(fieldName = "DistanceRelay.rPGSet1", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setRPGSet1(Resistance rPGSet1){
        this.rPGSet1 = rPGSet1;
    }

    /**
     * вторичное активное сопротивление,
     * определяющее правую границу характеристики
     * срабатывания комплекта от двойных замыканий
     * на землю
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="rPGSet2_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="rPGSet2_unit")),
            @AttributeOverride(name="value", column=@Column(name="rPGSet2_value")),
    })
    private Resistance rPGSet2;

    public Resistance getRPGSet2(){
        return this.rPGSet2;
    }

    @FieldSetter(fieldName = "DistanceRelay.rPGSet2", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setRPGSet2(Resistance rPGSet2){
        this.rPGSet2 = rPGSet2;
    }

    /**
     * выдержка времени срабатывания второй ступени ДЗ
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="tOpSet2_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="tOpSet2_unit")),
            @AttributeOverride(name="value", column=@Column(name="tOpSet2_value")),
    })
    private Seconds tOpSet2;

    public Seconds getTOpSet2(){
        return this.tOpSet2;
    }

    @FieldSetter(fieldName = "DistanceRelay.tOpSet2", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setTOpSet2(Seconds tOpSet2){
        this.tOpSet2 = tOpSet2;
    }

    /**
     * тангенс угла выреза характеристики срабатывания для отстройки от нагрузки
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="tgAngDetuneSet3_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="tgAngDetuneSet3_unit")),
            @AttributeOverride(name="value", column=@Column(name="tgAngDetuneSet3_value")),
    })
    private Float tgAngDetuneSet3;

    public Float getTgAngDetuneSet3(){
        return this.tgAngDetuneSet3;
    }

    @FieldSetter(fieldName = "DistanceRelay.tgAngDetuneSet3", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setTgAngDetuneSet3(Float tgAngDetuneSet3){
        this.tgAngDetuneSet3 = tgAngDetuneSet3;
    }

    /**
     * коэффициент чувствительности на однофазные КЗ первой ступени
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="kSensetivityPG1_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="kSensetivityPG1_unit")),
            @AttributeOverride(name="value", column=@Column(name="kSensetivityPG1_value")),
    })
    private Float kSensetivityPG1;

    public Float getKSensetivityPG1(){
        return this.kSensetivityPG1;
    }

    @FieldSetter(fieldName = "DistanceRelay.kSensetivityPG1", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setKSensetivityPG1(Float kSensetivityPG1){
        this.kSensetivityPG1 = kSensetivityPG1;
    }

    /**
     * коэффициент чувствительности на однофазные КЗ второй ступени
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="kSensetivityPG2_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="kSensetivityPG2_unit")),
            @AttributeOverride(name="value", column=@Column(name="kSensetivityPG2_value")),
    })
    private Float kSensetivityPG2;

    public Float getKSensetivityPG2(){
        return this.kSensetivityPG2;
    }

    @FieldSetter(fieldName = "DistanceRelay.kSensetivityPG2", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setKSensetivityPG2(Float kSensetivityPG2){
        this.kSensetivityPG2 = kSensetivityPG2;
    }

    /**
     * активное сопротивление выреза характеристики срабатывания для отстройки от нагрузки
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="rCutOutSet3_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="rCutOutSet3_unit")),
            @AttributeOverride(name="value", column=@Column(name="rCutOutSet3_value")),
    })
    private Resistance rCutOutSet3;

    public Resistance getRCutOutSet3(){
        return this.rCutOutSet3;
    }

    @FieldSetter(fieldName = "DistanceRelay.rCutOutSet3", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setRCutOutSet3(Resistance rPGSet2){
        this.rCutOutSet3 = rCutOutSet3;
    }

    /**
     * Коэффициент чувствительности третьей ступени ДЗ
     */
    @ElementCollection
    private List<Float> listKSensetivityPG3;

    public List<Float> getListKSensetivityPG3(){
        return this.listKSensetivityPG3;
    }

    @FieldSetter(fieldName = "ProtectionEquipment.listKSensetivityPG3", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setListKSensetivityPG3(List<Float> listKSensetivityPG3){
        this.listKSensetivityPG3 = listKSensetivityPG3;
    }

    /**
     * расчет координаты центра характеристики
     * срабатывания ступени по оси вторичного реактивного
     * сопротивления
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="xCenterSet3_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="xCenterSet3_unit")),
            @AttributeOverride(name="value", column=@Column(name="xCenterSet3_value")),
    })
    private Reactance xCenterSet3;

    public Reactance getXCenterSet3(){
        return this.xCenterSet3;
    }

    @FieldSetter(fieldName = "DistanceRelay.xCenterSet3", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setXCenterSet3(Reactance xCenterSet3){
        this.xCenterSet3 = xCenterSet3;
    }

    /**
     * расчет координаты центра характеристики
     * срабатывания ступени по оси вторичного активного
     * сопротивления
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="rCenterSet3_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="rCenterSet3_unit")),
            @AttributeOverride(name="value", column=@Column(name="rCenterSet3_value")),
    })
    private Resistance rCenterSet3;

    public Resistance getКCenterSet3(){
        return this.rCenterSet3;
    }

    @FieldSetter(fieldName = "DistanceRelay.rCenterSet3", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setRCenterSet3(Resistance rCenterSet3){
        this.rCenterSet3 = rCenterSet3;
    }

    /**
     радиус характеристики срабатывания
     ступени во вторичных величинах
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="zSet3_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="zSet3_unit")),
            @AttributeOverride(name="value", column=@Column(name="zSet3_value")),
    })
    private Float zSet3;

    public Float getZSet3(){
        return this.zSet3;
    }

    @FieldSetter(fieldName = "DistanceRelay.zSet3", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setZSet3(Float zSet3){
        this.zSet3 = zSet3;
    }

    /**
     * выдержка времени срабатывания третьей ступени ДЗ
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="tOpSet3_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="tOpSet3_unit")),
            @AttributeOverride(name="value", column=@Column(name="tOpSet3_value")),
    })
    private Seconds tOpSet3;

    public Seconds getTOpSet3(){
        return this.tOpSet3;
    }

    @FieldSetter(fieldName = "DistanceRelay.tOpSet3", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setTOpSet3(Seconds tOpSet3){
        this.tOpSet3 = tOpSet3;
    }

    /**
     * ток срабатывания реле пускового органа по току (грубого)
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="iSetInsensetive_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="iSetInsensetive_unit")),
            @AttributeOverride(name="value", column=@Column(name="iSetInsensetive_value")),
    })
    private CurrentFlow iSetInsensetive;

    public CurrentFlow getISetInsensetive(){
        return this.iSetInsensetive;
    }

    @FieldSetter(fieldName = "CurrentRelay.iSetInsensetive", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setISetInsensetive(CurrentFlow iSetInsensetive){
        this.iSetInsensetive = iSetInsensetive;
    }

    /**
     * ток срабатывания реле пускового органа по току (чувствительного)
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="iSetSensetive_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="iSetSensetive_unit")),
            @AttributeOverride(name="value", column=@Column(name="iSetSensetive_value")),
    })
    private CurrentFlow iSetSensetive;

    public CurrentFlow getISetSensetive(){
        return this.iSetSensetive;
    }

    @FieldSetter(fieldName = "CurrentRelay.iSetSensetive", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setISetSensetive(CurrentFlow iSetSensetive){
        this.iSetSensetive = iSetSensetive;
    }

    /**
     * напряжение срабатывания реле
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="uSetSensetive_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="uSetSensetive_unit")),
            @AttributeOverride(name="value", column=@Column(name="uSetSensetive_value")),
    })
    private Voltage uSetSensetive;

    public Voltage getUSetSensetive(){
        return this.uSetSensetive;
    }

    @FieldSetter(fieldName = "CurrentRelay.uSetSensetive", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setUSetSensetive(Voltage uSetSensetive){
        this.uSetSensetive = uSetSensetive;
    }

    /**
     * ток срабатывания реле
     */
    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="i0Set_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="i0Set_unit")),
            @AttributeOverride(name="value", column=@Column(name="i0Set_value")),
    })
    private CurrentFlow i0Set;

    public CurrentFlow getI0Set(){
        return this.i0Set;
    }

    @FieldSetter(fieldName = "CurrentRelay.i0Set", fieldTypeStereotype = "CIMDatatype", fieldStereotype = "nti")
    public void setI0Set(CurrentFlow i0Set){
        this.i0Set = i0Set;
    }

    public DistanceRelay(){

    }
}
