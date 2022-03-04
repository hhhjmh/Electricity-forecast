package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shift_configuration", schema = "power", catalog = "")
public class ShiftConfiguration {
    private int id;
    private String companyName;
    private String className;
    private String teamName;
    private String startHour;
    private String endHour;
    private String cycle;

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
    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "team_name")
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Basic
    @Column(name = "start_hour")
    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    @Basic
    @Column(name = "end_hour")
    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    @Basic
    @Column(name = "cycle")
    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftConfiguration that = (ShiftConfiguration) o;
        return id == that.id &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(className, that.className) &&
                Objects.equals(teamName, that.teamName) &&
                Objects.equals(startHour, that.startHour) &&
                Objects.equals(endHour, that.endHour) &&
                Objects.equals(cycle, that.cycle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, className, teamName, startHour, endHour, cycle);
    }
}
