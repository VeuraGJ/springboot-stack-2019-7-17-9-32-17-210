package com.tw.apistackbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prosecutor {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;

    public Prosecutor() {
    }

    public Prosecutor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
