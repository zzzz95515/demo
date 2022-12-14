package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Common type for per-length electrical catalogues describing line parameters.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "perlengthlineparameter")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerLengthLineParameter extends IdentifiedObject {


	public PerLengthLineParameter(){

	}

}
