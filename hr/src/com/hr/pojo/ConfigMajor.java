package com.hr.pojo;

public class ConfigMajor {
    private Short makId;

    private String majorKindId;

    private String majorKindName;

    private String majorId;

    private String majorName;

    private Short testAmount;

    public Short getMakId() {
        return makId;
    }

    public void setMakId(Short makId) {
        this.makId = makId;
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

    public Short getTestAmount() {
        return testAmount;
    }

    public void setTestAmount(Short testAmount) {
        this.testAmount = testAmount;
    }
}