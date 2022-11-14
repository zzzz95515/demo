package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A manually operated or motor operated mechanical switching device used 
 * for changing the connections in a circuit, or for isolating a circuit or 
 * equipment from a source of power. It is required to open or close circuits 
 * when negligible current is broken or made. 
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "disconnector")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Disconnector extends Switch {


	public Disconnector(){

	}

}