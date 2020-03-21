package com.hr.pojo;

import java.io.Serializable;


public class SalaryGrant  implements Serializable{
    private Short sgrId;

    private String salaryGrantId;

    private String salaryStandardId;

    private String first_kind_id;

    private String firstKindName;

    private String second_kind_id;

    private String secondKindName;

    private String third_kind_id;

    private String thirdKindName;

    private Short humanAmount;

    private String salaryStandardSum;

    private String salaryPaidSum;

    private String register;

    private String registTime;

    private String checker;

    private String checkTime;

    private Short checkStatus;

    public Short getSgrId() {
        return sgrId;
    }

    public void setSgrId(Short sgrId) {
        this.sgrId = sgrId;
    }

    public String getSalaryGrantId() {
        return salaryGrantId;
    }

    public void setSalaryGrantId(String salaryGrantId) {
        this.salaryGrantId = salaryGrantId == null ? null : salaryGrantId.trim();
    }

    public String getSalaryStandardId() {
        return salaryStandardId;
    }

    public void setSalaryStandardId(String salaryStandardId) {
        this.salaryStandardId = salaryStandardId == null ? null : salaryStandardId.trim();
    }

    
    public String getFirstKindName() {
        return firstKindName;
    }

    public void setFirstKindName(String firstKindName) {
        this.firstKindName = firstKindName == null ? null : firstKindName.trim();
    }

    

    public String getFirst_kind_id() {
		return first_kind_id;
	}

	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}

	public String getSecond_kind_id() {
		return second_kind_id;
	}

	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}

	public String getThird_kind_id() {
		return third_kind_id;
	}

	public void setThird_kind_id(String third_kind_id) {
		this.third_kind_id = third_kind_id;
	}

	public String getSecondKindName() {
        return secondKindName;
    }

    public void setSecondKindName(String secondKindName) {
        this.secondKindName = secondKindName == null ? null : secondKindName.trim();
    }

    

    public String getThirdKindName() {
        return thirdKindName;
    }

    public void setThirdKindName(String thirdKindName) {
        this.thirdKindName = thirdKindName == null ? null : thirdKindName.trim();
    }

    public Short getHumanAmount() {
        return humanAmount;
    }

    public void setHumanAmount(Short humanAmount) {
        this.humanAmount = humanAmount;
    }

    public String getSalaryStandardSum() {
        return salaryStandardSum;
    }

    public void setSalaryStandardSum(String salaryStandardSum) {
        this.salaryStandardSum = salaryStandardSum;
    }

    public String getSalaryPaidSum() {
        return salaryPaidSum;
    }

    public void setSalaryPaidSum(String salaryPaidSum) {
        this.salaryPaidSum = salaryPaidSum;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }
}