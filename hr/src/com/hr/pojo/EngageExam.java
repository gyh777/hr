package com.hr.pojo;

import java.util.Date;

public class EngageExam {
    private Short exaId;

    private String examNumber;

    private String majorKindId;

    private String majorKindName;

    private String majorId;

    private String majorName;

    private String register;

    private Date registTime;

    private Short limiteTime;

    public Short getExaId() {
        return exaId;
    }

    public void setExaId(Short exaId) {
        this.exaId = exaId;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber == null ? null : examNumber.trim();
    }

    public String getMajorKindId() {
        return majorKindId;
    }

    public void setMajorKindId(String majorKindId) {
        this.majorKindId = majorKindId == null ? null : majorKindId.trim();
    }

    public String getMajorKindName() {
        return majorKindName;
    }

    public void setMajorKindName(String majorKindName) {
        this.majorKindName = majorKindName == null ? null : majorKindName.trim();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Short getLimiteTime() {
        return limiteTime;
    }

    public void setLimiteTime(Short limiteTime) {
        this.limiteTime = limiteTime;
    }
}