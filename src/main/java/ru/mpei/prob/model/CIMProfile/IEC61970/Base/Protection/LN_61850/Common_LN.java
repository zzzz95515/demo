package ru.mpei.prob.model.CIMProfile.IEC61970.Base.Protection.LN_61850;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.PowerSystemResource;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.ProtectedSwitch;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "common_ln")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Common_LN extends PowerSystemResource {

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "LN_Base")
	private List<ProtectedSwitch> ProtectedSwitches;

	@JsonIgnore
	public List<ProtectedSwitch> getProtectedSwitches(){
		return this.ProtectedSwitches;
	}

	@AssociationSetter(fieldName = "Common_LN.ProtectedSwitches", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.ProtectedSwitch", cardinality = "many")
	public void setProtectedSwitches(List<ProtectedSwitch> ProtectedSwitches){
		this.ProtectedSwitches = ProtectedSwitches;
	}

	public Common_LN(){

	}

}
