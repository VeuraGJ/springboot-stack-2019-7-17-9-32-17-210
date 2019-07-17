package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CaseDetail {
    @Id
    @GeneratedValue
    private long caseDetailId;
    @Column(nullable = false)
    private String subjectiveDescription;
    @Column(nullable = false)
    private String objectiveDescription;
    @OneToOne
    private CriminalCase criminalCase;

    public CaseDetail() {

    }

    public CaseDetail(String subjectiveDescription, String objectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
        this.objectiveDescription = objectiveDescription;
    }

    public CaseDetail(String subjectiveDescription, String objectiveDescription, CriminalCase criminalCase) {
        this.subjectiveDescription = subjectiveDescription;
        this.objectiveDescription = objectiveDescription;
        this.criminalCase = criminalCase;
    }

    public long getCaseDetailId() {
        return caseDetailId;
    }

    public void setCaseDetailId(long caseDetailId) {
        this.caseDetailId = caseDetailId;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }
}
