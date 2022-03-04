package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shift_system_electricity_assessment", schema = "power", catalog = "")
public class ShiftSystemElectricityAssessmentEntity {
    private int id;
    private String companyName;
    private String magnification;
    private String rate;
    private String initialIndication;
    private String endIndication;
    private String percentage;
    private String electricity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "magnification")
    public String getMagnification() {
        return magnification;
    }

    public void setMagnification(String magnification) {
        this.magnification = magnification;
    }

    @Basic
    @Column(name = "rate")
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "initial_indication")
    public String getInitialIndication() {
        return initialIndication;
    }

    public void setInitialIndication(String initialIndication) {
        this.initialIndication = initialIndication;
    }

    @Basic
    @Column(name = "end_indication")
    public String getEndIndication() {
        return endIndication;
    }

    public void setEndIndication(String endIndication) {
        this.endIndication = endIndication;
    }

    @Basic
    @Column(name = "percentage")
    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Basic
    @Column(name = "electricity")
    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftSystemElectricityAssessmentEntity that = (ShiftSystemElectricityAssessmentEntity) o;
        return id == that.id &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(magnification, that.magnification) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(initialIndication, that.initialIndication) &&
                Objects.equals(endIndication, that.endIndication) &&
                Objects.equals(percentage, that.percentage) &&
                Objects.equals(electricity, that.electricity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, magnification, rate, initialIndication, endIndication, percentage, electricity);
    }
}
