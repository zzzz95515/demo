package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.ProtectionEquipment;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.AssociationSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "protection_table", schema = "library")
public class ProtectionLibrary {

    @Id
    @Setter
    @Getter
    private Integer id;

    @Setter @Getter
    @Column(name="vendor", nullable = true)
    private String vendor;

    @Setter @Getter
    @Column(name="name", nullable = true)
    private String name;

    @Setter @Getter
    @Enumerated(EnumType.STRING)
    @Column(name="protection_type", nullable = true)
    private ProtectionType protectionType;

    @Setter @Getter
    @Column(name="step", nullable = true)
    private Integer step;

    @Lob
    @Setter @Getter
    @Type(type = "org.hibernate.type.TextType")
    @Column(name="script", nullable = true)
    private String script;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "ProtectionLibrary")
    private List<ProtectionEquipment> ProtectionEquipments;

    @JsonIgnore
    public List<ProtectionEquipment> getProtectionEquipments(){
        return this.ProtectionEquipments;
    }

    @AssociationSetter(fieldName = "ProtectionLibrary.ProtectionEquipments", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection", cardinality = "many")
    public void setProtectionEquipments(List<ProtectionEquipment> protectionEquipments){
        this.ProtectionEquipments = protectionEquipments;
    }

}
