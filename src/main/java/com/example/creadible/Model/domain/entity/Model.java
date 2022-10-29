package com.example.creadible.Model.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;
    private boolean isLearned;
    private int gender;
    private int age;
    private int married;
    private int dependents;
    private int education;
    private int selfEmployed;
    private int businessType;
    private int applicantIncome;
    private int applicantWorkPeriod;
    private float coapplicantIncome;
    private float creditHistory;
    private int creditAmount;
    private int propertyArea;
    private int propertyType;
    private int creditRate;
    private int loanAmount;
    private int loanTerm;

    @Builder
    public Model(boolean isLearned, int gender, int age, int married, int dependents, int education, int selfEmployed, int businessType, int applicantIncome, int applicantWorkPeriod, float coapplicantIncome, float creditHistory, int creditAmount, int propertyArea, int propertyType, int creditRate, int loanAmount, int loanTerm) {
        this.isLearned = isLearned;
        this.gender = gender;
        this.age = age;
        this.married = married;
        this.dependents = dependents;
        this.education = education;
        this.selfEmployed = selfEmployed;
        this.businessType = businessType;
        this.applicantIncome = applicantIncome;
        this.applicantWorkPeriod = applicantWorkPeriod;
        this.coapplicantIncome = coapplicantIncome;
        this.creditHistory = creditHistory;
        this.creditAmount = creditAmount;
        this.propertyArea = propertyArea;
        this.propertyType = propertyType;
        this.creditRate = creditRate;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
    }
}
