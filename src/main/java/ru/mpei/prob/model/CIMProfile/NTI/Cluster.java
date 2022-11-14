package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.BaseVoltage;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "cluster")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cluster extends IdentifiedObject {

	/**
	 * Максимальное базовое напряжение среди элементов в кластере
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maxbasevoltage_mrid")
	@JoinColumn(name = "maxbasevoltage_projectid")
	@JoinColumn(name = "maxbasevoltage_synthesizedschemenumber")
	@JoinColumn(name = "maxbasevoltage_schemascenarionumber")
	private BaseVoltage MaxBaseVoltage;

	public BaseVoltage getMaxBaseVoltage(){
		return this.MaxBaseVoltage;
	}

	@AssociationSetter(fieldName = "Cluster.MaxBaseVoltage", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Core.BaseVoltage", cardinality = "one")
	public void setMaxBaseVoltage(BaseVoltage MaxBaseVoltage){
		this.MaxBaseVoltage = MaxBaseVoltage;
	}

	public Cluster(){

	}

}
