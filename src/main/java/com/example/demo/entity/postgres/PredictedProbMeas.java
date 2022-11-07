package com.example.demo.entity.postgres;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PredictedProbMeas {
  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "equipment_id")
  private EquipmentEnt equipment;

  private LocalDate date;

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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
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
