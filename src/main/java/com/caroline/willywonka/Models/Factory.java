package com.caroline.willywonka.Models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String size;

    //One to one relationship in database
    @OneToOne
    @JoinColumn(name = "oompaloompa_id")
    private OompaLoompa oompaLoompa;

    //Many to many relationship in database
    @ManyToMany
    @JoinTable(
            name = "candy_factory",
            joinColumns = {@JoinColumn(name = "factory_id")},
            inverseJoinColumns = {@JoinColumn(name = "candy_id")}
    )
    public List<Candy> candies;


    @JsonGetter("candies")
    public List<String> candies() {
        return candies.stream()
                .map(candy -> {
                    return "/api/v1/candies/" + candy.getId();
                }).collect(Collectors.toList());
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
