package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.EnergyConsumer;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumersvoltagecluster")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumersVoltageCluster extends Cluster {

	/**
	 * Кластер потребителей, объединенных по географической близости
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumerscluster_mrid")
	@JoinColumn(name = "consumerscluster_projectid")
	@JoinColumn(name = "consumerscluster_synthesizedschemenumber")
	@JoinColumn(name = "consumerscluster_schemascenarionumber")
	private ConsumersCluster ConsumersCluster;
	/**
	 * Потребители, составляющие данный кластер
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "VoltageCluster")
	private List<EnergyConsumer> EnergyConsumers;

	public ConsumersCluster getConsumersCluster(){
		return this.ConsumersCluster;
	}

	@AssociationSetter(fieldName = "ConsumersVoltageCluster.ConsumersCluster", assocType = "ru.mpei.ltdb.model.CIMProfile.NTI.ConsumersCluster", cardinality = "one")
	public void setConsumersCluster(ConsumersCluster ConsumersCluster){
		this.ConsumersCluster = ConsumersCluster;
	}

	@JsonIgnore
	public List<EnergyConsumer> getEnergyConsumers(){
		return this.EnergyConsumers;
	}

	@AssociationSetter(fieldName = "ConsumersVoltageCluster.EnergyConsumers", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.EnergyConsumer", cardinality = "many")
	public void setEnergyConsumers(List<EnergyConsumer> EnergyConsumers){
		this.EnergyConsumers = EnergyConsumers;
	}

	public ConsumersVoltageCluster(){

	}

}
