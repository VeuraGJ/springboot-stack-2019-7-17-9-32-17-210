package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,length = 50,unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "procuratorate",fetch = FetchType.LAZY)
    private List<CriminalCase> criminalCases;
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

    public List<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public void setCriminalCases(List<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
    }
}
