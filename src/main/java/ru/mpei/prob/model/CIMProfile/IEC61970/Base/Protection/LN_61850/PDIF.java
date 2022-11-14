package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.LN_61850;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pdif")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PDIF extends Common_LN {


	public PDIF(){

	}

}
