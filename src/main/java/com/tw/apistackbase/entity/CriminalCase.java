package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CriminalCase {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String caseName;
    @Column(nullable = false)
    private long incidentTime;
    @OneToOne(cascade=CascadeType.ALL)
    private CaseDetail caseDetail;

    public CriminalCase() {
    }

    public CriminalCase(String caseName, long incidentTime) {
        this.caseName = caseName;
        this.incidentTime = incidentTime;
    }

    public CriminalCase(String caseName, long incidentTime, CaseDetail caseDetail) {
        this.caseName = caseName;
        this.incidentTime = incidentTime;
        this.caseDetail = caseDetail;
    }

    public CaseDetail getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(CaseDetail caseDetail) {
        this.caseDetail = caseDetail;
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
