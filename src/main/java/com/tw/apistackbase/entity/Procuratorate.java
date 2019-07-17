package com.tw.apistackbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,length = 50,unique = true)
    private String name;

    public Procuratorate() {
    }

    public Procuratorate(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
