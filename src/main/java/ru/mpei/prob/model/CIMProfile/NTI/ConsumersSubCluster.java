package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;

@Entity
@Table(name = "consumerssubcluster")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumersSubCluster extends Cluster {

	/**
	 * Кластер потребителей, объединенных по номинальному напряжению
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voltagecluster_mrid")
	@JoinColumn(name = "voltagecluster_projectid")
	@JoinColumn(name = "voltagecluster_synthesizedschemenumber")
	@JoinColumn(name = "voltagecluster_schemascenarionumber")
	private ConsumersVoltageCluster VoltageCluster;

	public ConsumersVoltageCluster getVoltageCluster(){
		return this.VoltageCluster;
	}

	@AssociationSetter(fieldName = "ConsumersSubCluster.VoltageCluster", assocType = "ru.mpei.ltdb.model.CIMProfile.NTI.ConsumersVoltageCluster", cardinality = "one")
	public void setVoltageCluster(ConsumersVoltageCluster VoltageCluster){
		this.VoltageCluster = VoltageCluster;
	}

	public ConsumersSubCluster(){

	}

}
