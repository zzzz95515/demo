package com.example.demo.entity.postgres;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PredictedProbMeas {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "equipment_id")
  private EquipmentEnt equipment;

  private LocalDate predDate;

  private Double probability;

  private Integer planNumber;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EquipmentEnt getEquipment() {
    return equipment;
  }

  public void setEquipment(EquipmentEnt equipment) {
    this.equipment = equipment;
  }

  public LocalDate getPredDate() {
    return predDate;
  }

  public void setPredDate(LocalDate predDate) {
    this.predDate = predDate;
  }

  public Double getProbability() {
    return probability;
  }

  public void setProbability(Double its) {
    this.probability = its;
  }

  public Integer getPlanNumber() {
    return planNumber;
  }

  public void setPlanNumber(Integer planNumber) {
    this.planNumber = planNumber;
  }
}
