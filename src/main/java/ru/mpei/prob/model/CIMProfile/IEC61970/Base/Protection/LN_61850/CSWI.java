package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.LN_61850;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Класс управления переключениями.
 * Generated by "JavaBeansGenerator" project.
 * @author Said Nukhulov  (nukhulovsm@yandex.ru)
 * @created Sat Dec 05 15:18:54 MSK 2020
 */

@Entity
@Table(name = "cswi")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CSWI extends Common_LN {


	public CSWI(){

	}

}
