package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "production_unit_configuration", schema = "power", catalog = "")
public class ProductionUnitConfiguration {
    private int id;
    private String workshopUnit;
    private String className;
    private String collectionPoint;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "workshop_unit")
    public String getWorkshopUnit() {
        return workshopUnit;
    }

    public void setWorkshopUnit(String workshopUnit) {
        this.workshopUnit = workshopUnit;
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
    @Column(name = "collection_point")
    public String getCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(String collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionUnitConfiguration that = (ProductionUnitConfiguration) o;
        return id == that.id &&
                Objects.equals(workshopUnit, that.workshopUnit) &&
                Objects.equals(className, that.className) &&
                Objects.equals(collectionPoint, that.collectionPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workshopUnit, className, collectionPoint);
    }
}
