package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Equivalents.EquivalentEquipment;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.FieldSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equivalentsolarpanel")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquivalentSolarPanel extends EquivalentEquipment {

    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="currentPower_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="currentPower_unit")),
            @AttributeOverride(name="value", column=@Column(name="currentPower_value")),
    })
    private Float currentPower;

    @AttributeOverrides({
            @AttributeOverride(name="multiplier", column=@Column(name="currentIsc_multiplier")),
            @AttributeOverride(name="unit", column=@Column(name="currentIsc_unit")),
            @AttributeOverride(name="value", column=@Column(name="currentIsc_value")),
    })
    private Float currentIsc;

    /**
     * Nominal power of SP, kW
     */
    @ElementCollection
    private List<Float> snom;

    /**
     * List of illumination corresponding to certain power, W/m^2
     */
    @ElementCollection
    private List<Float> illuminationList;

    /**
     * Short circuit current, Amperes
     */
    @ElementCollection
    private List<Float> isc;

    public List<Float> getSnom() {
        return snom;
    }

    @FieldSetter(fieldName = "EquivalentSolarPanel.snom", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
    public void setSnom(List<Float> snom) {
        this.snom = snom;
    }

    public List<Float> getIlluminationList() {
        return illuminationList;
    }

    @FieldSetter(fieldName = "EquivalentSolarPanel.illuminationList", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
    public void setIlluminationList(List<Float> illuminationList) {
        this.illuminationList = illuminationList;
    }

    public List<Float> getIsc() {
        return isc;
    }

    @FieldSetter(fieldName = "EquivalentSolarPanel.isc", fieldTypeStereotype = "Primitive", fieldStereotype = "none")
    public void setIsc(List<Float> isc) {
        this.isc = isc;
    }

    public Float getCurrentPower() {
        return currentPower;
    }

    @FieldSetter(fieldName = "EquivalentSolarPanel.currentPower", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setCurrentPower(Float currentPower) {
        this.currentPower = currentPower;
    }

    public Float getCurrentIsc() {
        return currentIsc;
    }

    @FieldSetter(fieldName = "EquivalentSolarPanel.currentIsc", fieldTypeStereotype = "Primitive", fieldStereotype = "nti")
    public void setCurrentIsc(Float currentIsc) {
        this.currentIsc = currentIsc;
    }
}
