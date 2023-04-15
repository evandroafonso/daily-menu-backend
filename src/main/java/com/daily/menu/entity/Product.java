package com.daily.menu.entity;

import com.daily.menu.entity.baseEntity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product extends BaseEntity {

    @NotNull
    private String name;

    private String feature;

    @NotNull
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
