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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Prosecutor> prosecutors;
    public Procuratorate() {
    }

    public Procuratorate(String name) {
        this.name = name;
    }

    public Procuratorate(String name, List<Prosecutor> prosecutors) {
        this.name = name;
        this.prosecutors = prosecutors;
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

    public List<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(List<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }
}
