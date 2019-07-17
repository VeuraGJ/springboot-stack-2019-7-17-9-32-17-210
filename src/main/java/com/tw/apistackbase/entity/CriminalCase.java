package com.tw.apistackbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class CriminalCase {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String caseName;
    @Column(nullable = false)
    private long incidentTime;

    public CriminalCase() {
    }

    public CriminalCase(String caseName, long incidentTime) {
        this.caseName = caseName;
        this.incidentTime = incidentTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public long getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(long incidentTime) {
        this.incidentTime = incidentTime;
    }
}
