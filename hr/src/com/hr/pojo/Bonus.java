package com.hr.pojo;

import java.util.Date;

public class Bonus {
    private Short bonId;

    private String majorKindId;

    private String majorKindName;

    private String majorId;

    private String majorName;

    private String humanId;

    private String humanName;

    private String bonusItem;

    private Double bonusWorth;

    private String bonusDegree;

    private String register;

    private String checker;

    private Date registTime;

    private Date checkTime;

    private Short checkStatus;

    private String remark;

    public Short getBonId() {
        return bonId;
    }

    public void setBonId(Short bonId) {
        this.bonId = bonId;
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

    public String getBonusItem() {
        return bonusItem;
    }

    public void setBonusItem(String bonusItem) {
        this.bonusItem = bonusItem == null ? null : bonusItem.trim();
    }

    public Double getBonusWorth() {
        return bonusWorth;
    }

    public void setBonusWorth(Double bonusWorth) {
        this.bonusWorth = bonusWorth;
    }

    public String getBonusDegree() {
        return bonusDegree;
    }

    public void setBonusDegree(String bonusDegree) {
        this.bonusDegree = bonusDegree == null ? null : bonusDegree.trim();
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

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}