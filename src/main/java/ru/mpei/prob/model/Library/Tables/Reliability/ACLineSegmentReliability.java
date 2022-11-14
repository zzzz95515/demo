package ru.mpei.prob.model.Library.Tables.Reliability;

import lombok.Getter;
import lombok.Setter;
import ru.mpei.prob.model.CIMProfile.NTI.ACLineSegmentType;

import javax.persistence.*;

@Entity
@Table(name = "ACLineSegmentReliability", schema = "library")
public class ACLineSegmentReliability extends Reliability {

    /**
     * Материал опор
     */
    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "powerLineSupportMaterial")
    private PowerLineSupportMaterial powerLineSupportMaterial;

    /**
     * Количество цепей на опоре
     */
    @Setter
    @Getter
    @Column(name = "lineNumPerSupport")
    private Integer lineNumPerSupport;

    /**
     * Тип ЛЭП: ВЛ или КЛ
     */
    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ACLineSegmentType type;

}
