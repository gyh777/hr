package com.hr.pojo;

public class ConfigMajorKind {
    private Short mfkId;

    private String majorKindId;

    private String majorKindName;

    public Short getMfkId() {
        return mfkId;
    }

    public void setMfkId(Short mfkId) {
        this.mfkId = mfkId;
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
}