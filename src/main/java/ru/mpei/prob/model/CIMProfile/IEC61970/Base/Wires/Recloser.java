package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Pole-mounted fault interrupter with built-in phase and ground relays, current 
 * transformer (CT), and supplemental controls.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:55 MSK 2020
 */

@Entity
@Table(name = "recloser")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recloser extends ProtectedSwitch {


	public Recloser(){

	}

}
