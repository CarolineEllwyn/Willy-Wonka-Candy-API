package com.caroline.willywonka.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sun.istack.NotNull;
import org.aspectj.lang.annotation.RequiredTypes;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotNull
    private String name;
    @Column
    private String type;
    @Column
    private double weightPerUnit;
    @Column
    private double costPerUnit;

    @ManyToMany(mappedBy = "candies")
    public List<Factory> factories;

    @JsonGetter("factories")
    public List<String> factoriesGetter() {
        if (factories != null) {
            return factories.stream()
                    .map(factory -> {
                        return "/api/v1/factories/" + factory.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeightPerUnit() {
        return weightPerUnit;
    }

    public void setWeightPerUnit(double weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }
}



