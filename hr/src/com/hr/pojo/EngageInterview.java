package com.hr.pojo;

import java.util.Date;

public class EngageInterview {
    private Short einId;

    private String humanName;

    private Short interviewAmount;

    private String humanMajorKindId;

    private String humanMajorKindName;

    private String humanMajorId;

    private String humanMajorName;

    private String imageDegree;

    private String nativeLanguageDegree;

    private String foreignLanguageDegree;

    private String responseSpeedDegree;

    private String eqDegree;

    private String iqDegree;

    private String multiQualityDegree;

    private String register;

    private String checker;

    private Date registeTime;

    private Date checkTime;

    private Short resumeId;

    private String result;

    private Short interviewStatus;

    private Short checkStatus;

    public Short getEinId() {
        return einId;
    }

    public void setEinId(Short einId) {
        this.einId = einId;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName == null ? null : humanName.trim();
    }

    public Short getInterviewAmount() {
        return interviewAmount;
    }

    public void setInterviewAmount(Short interviewAmount) {
        this.interviewAmount = interviewAmount;
    }

    public String getHumanMajorKindId() {
        return humanMajorKindId;
    }

    public void setHumanMajorKindId(String humanMajorKindId) {
        this.humanMajorKindId = humanMajorKindId == null ? null : humanMajorKindId.trim();
    }

    public String getHumanMajorKindName() {
        return humanMajorKindName;
    }

    public void setHumanMajorKindName(String humanMajorKindName) {
        this.humanMajorKindName = humanMajorKindName == null ? null : humanMajorKindName.trim();
    }

    public String getHumanMajorId() {
        return humanMajorId;
    }

    public void setHumanMajorId(String humanMajorId) {
        this.humanMajorId = humanMajorId == null ? null : humanMajorId.trim();
    }

    public String getHumanMajorName() {
        return humanMajorName;
    }

    public void setHumanMajorName(String humanMajorName) {
        this.humanMajorName = humanMajorName == null ? null : humanMajorName.trim();
    }

    public String getImageDegree() {
        return imageDegree;
    }

    public void setImageDegree(String imageDegree) {
        this.imageDegree = imageDegree == null ? null : imageDegree.trim();
    }

    public String getNativeLanguageDegree() {
        return nativeLanguageDegree;
    }

    public void setNativeLanguageDegree(String nativeLanguageDegree) {
        this.nativeLanguageDegree = nativeLanguageDegree == null ? null : nativeLanguageDegree.trim();
    }

    public String getForeignLanguageDegree() {
        return foreignLanguageDegree;
    }

    public void setForeignLanguageDegree(String foreignLanguageDegree) {
        this.foreignLanguageDegree = foreignLanguageDegree == null ? null : foreignLanguageDegree.trim();
    }

    public String getResponseSpeedDegree() {
        return responseSpeedDegree;
    }

    public void setResponseSpeedDegree(String responseSpeedDegree) {
        this.responseSpeedDegree = responseSpeedDegree == null ? null : responseSpeedDegree.trim();
    }

    public String getEqDegree() {
        return eqDegree;
    }

    public void setEqDegree(String eqDegree) {
        this.eqDegree = eqDegree == null ? null : eqDegree.trim();
    }

    public String getIqDegree() {
        return iqDegree;
    }

    public void setIqDegree(String iqDegree) {
        this.iqDegree = iqDegree == null ? null : iqDegree.trim();
    }

    public String getMultiQualityDegree() {
        return multiQualityDegree;
    }

    public void setMultiQualityDegree(String multiQualityDegree) {
        this.multiQualityDegree = multiQualityDegree == null ? null : multiQualityDegree.trim();
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public Date getRegisteTime() {
        return registeTime;
    }

    public void setRegisteTime(Date registeTime) {
        this.registeTime = registeTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Short getResumeId() {
        return resumeId;
    }

    public void setResumeId(Short resumeId) {
        this.resumeId = resumeId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Short getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(Short interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }
}