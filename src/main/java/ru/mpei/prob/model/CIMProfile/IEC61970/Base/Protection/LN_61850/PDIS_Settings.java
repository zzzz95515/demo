package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.LN_61850;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "pdis_settings")
@JsonInclude(JsonInclude.Include.NON_NULL)
// surrogate inheritance
public class PDIS_Settings extends IdentifiedObject{

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "PDIS_Settings")
	private PDIS PDIS;

	@JsonIgnore
	public PDIS getPDIS(){
		return this.PDIS;
	}

	@AssociationSetter(fieldName = "PDIS_Settings.PDIS", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Protection.LN_61850.PDIS", cardinality = "one")
	public void setPDIS(PDIS PDIS){
		this.PDIS = PDIS;
	}

	public PDIS_Settings(){

	}

}
