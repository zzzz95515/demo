package ru.mpei.prob.model.CIMProfile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class CompositeKey implements Serializable {
    @Getter @Setter
    private String mRID;

    @Setter @Getter
    private String projectID;

    @Setter @Getter
    private Integer synthesizedSchemeNumber = 0;

    @Setter @Getter
    private Integer schemaScenarioNumber = 0;
}
