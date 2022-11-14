package ru.mpei.prob.model.CIMProfile.NTI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Wires.EnergyConsumer;
import ru.mpei.prob.model.CIMProfile.ResourceAnnotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumerscluster")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumersCluster extends Cluster {

	/**
	 * Кластеры потребителей, объединенных по одному номинальному напряжению внутри 
	 * кластера потребителей, объедиенных по географической близости
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "ConsumersCluster")
	private List<ConsumersVoltageCluster> ConsumersVoltageClusters;
	/**
	 * Потребители, составляющие данный кластер
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "Cluster")
	private List<EnergyConsumer> EnergyConsumers;

	@JsonIgnore
	public List<ConsumersVoltageCluster> getConsumersVoltageClusters(){
		return this.ConsumersVoltageClusters;
	}

	@AssociationSetter(fieldName = "ConsumersCluster.ConsumersVoltageClusters", assocType = "ru.mpei.ltdb.model.CIMProfile.NTI.ConsumersVoltageCluster", cardinality = "many")
	public void setConsumersVoltageClusters(List<ConsumersVoltageCluster> ConsumersVoltageClusters){
		this.ConsumersVoltageClusters = ConsumersVoltageClusters;
	}

	@JsonIgnore
	public List<EnergyConsumer> getEnergyConsumers(){
		return this.EnergyConsumers;
	}

	@AssociationSetter(fieldName = "ConsumersCluster.EnergyConsumers", assocType = "ru.mpei.ltdb.model.CIMProfile.IEC61970.Base.Wires.EnergyConsumer", cardinality = "many")
	public void setEnergyConsumers(List<EnergyConsumer> EnergyConsumers){
		this.EnergyConsumers = EnergyConsumers;
	}

	public ConsumersCluster(){

	}

}
