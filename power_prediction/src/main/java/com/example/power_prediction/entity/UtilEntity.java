package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "util", schema = "power", catalog = "")
public class UtilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String variableAttributeName;
    private String variableAttributeNum;
    private Integer state;
    private Integer dataTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "variableAttributeName")
    public String getVariableAttributeName() {
        return variableAttributeName;
    }

    public void setVariableAttributeName(String variableAttributeName) {
        this.variableAttributeName = variableAttributeName;
    }

    @Basic
    @Column(name = "variableAttributeNum")
    public String getVariableAttributeNum() {
        return variableAttributeNum;
    }

    public void setVariableAttributeNum(String variableAttributeNum) {
        this.variableAttributeNum = variableAttributeNum;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "dataTime")
    public Integer getDataTime() {
        return dataTime;
    }

    public void setDataTime(Integer dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilEntity that = (UtilEntity) o;
        return id == that.id &&
                Objects.equals(variableAttributeName, that.variableAttributeName) &&
                Objects.equals(variableAttributeNum, that.variableAttributeNum) &&
                Objects.equals(state, that.state) &&
                Objects.equals(dataTime, that.dataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, variableAttributeName, variableAttributeNum, state, dataTime);
    }
}
