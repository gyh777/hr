package com.hr.pojo;

import java.io.Serializable;

public class SalaryGrantDetails  implements Serializable{
    private Short grdId;

    private String salaryGrantId;

    private String humanId;

    private String humanName;

    private Double bounsSum;

    private Double saleSum;

    private Double deductSum;

    private Double salaryStandardSum;

    private Double salaryPaidSum;

    public Short getGrdId() {
        return grdId;
    }

    public void setGrdId(Short grdId) {
        this.grdId = grdId;
    }

    public String getSalaryGrantId() {
        return salaryGrantId;
    }

    public void setSalaryGrantId(String salaryGrantId) {
        this.salaryGrantId = salaryGrantId == null ? null : salaryGrantId.trim();
    }

    public String getHumanId() {
        return humanId;
    }

    public void setHumanId(String humanId) {
        this.humanId = humanId == null ? null : humanId.trim();
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName == null ? null : humanName.trim();
    }

    public Double getBounsSum() {
        return bounsSum;
    }

    public void setBounsSum(Double bounsSum) {
        this.bounsSum = bounsSum;
    }

    public Double getSaleSum() {
        return saleSum;
    }

    public void setSaleSum(Double saleSum) {
        this.saleSum = saleSum;
    }

    public Double getDeductSum() {
        return deductSum;
    }

    public void setDeductSum(Double deductSum) {
        this.deductSum = deductSum;
    }

    public Double getSalaryStandardSum() {
        return salaryStandardSum;
    }

    public void setSalaryStandardSum(Double salaryStandardSum) {
        this.salaryStandardSum = salaryStandardSum;
    }

    public Double getSalaryPaidSum() {
        return salaryPaidSum;
    }

    public void setSalaryPaidSum(Double salaryPaidSum) {
        this.salaryPaidSum = salaryPaidSum;
    }
}