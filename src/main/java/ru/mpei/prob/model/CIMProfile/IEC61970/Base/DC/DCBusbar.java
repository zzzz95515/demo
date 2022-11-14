package ru.mpei.prob.model.CIMProfile.IEC61970.Base.DC;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A busbar within a DC system.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:50 MSK 2020
 */

@Entity
@Table(name = "dcbusbar")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DCBusbar extends DCConductingEquipment {


	public DCBusbar(){

	}

}
