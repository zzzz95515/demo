package ru.mpei.prob.entity.postgres;


import javax.persistence.*;

@Entity
public class AlphaParamsEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private EquipmentEnt equipment;

    private Double p1;

    private Double p2;

    private Double p3;
    private Double alpha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public EquipmentEnt getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEnt equipment) {
        this.equipment = equipment;
    }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public Double getP2() {
        return p2;
    }

    public void setP2(Double p2) {
        this.p2 = p2;
    }

    public Double getP3() {
        return p3;
    }

    public void setP3(Double p3) {
        this.p3 = p3;
    }

    @Override
    public String toString() {
        return "AlphaParamsEnt{" +
                "equipment=" + equipment +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }

    public AlphaParamsEnt() {
    }

    public AlphaParamsEnt(EquipmentEnt equipment, Double p1, Double p2, Double p3) {
        this.equipment = equipment;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
}
