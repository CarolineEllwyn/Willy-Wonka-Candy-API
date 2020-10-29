package com.caroline.willywonka.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class OompaLoompa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column(name = "date_of_birth")
    private Date dob;
    @Column
    private String Address;



    @JsonIgnore
    @OneToOne(mappedBy = "oompaloompa")
    private Factory factory;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Factory getFactory() { return factory; }

    public void setFactory(Factory factory) { this.factory = factory; }

}
