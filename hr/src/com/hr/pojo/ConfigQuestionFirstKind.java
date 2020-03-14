package com.hr.pojo;

public class ConfigQuestionFirstKind {
    private String qfkId;

    private String firstKindId;

    private String firstKindName;

    public String getQfkId() {
        return qfkId;
    }

    public void setQfkId(String qfkId) {
        this.qfkId = qfkId;
    }

    public String getFirstKindId() {
        return firstKindId;
    }

    public void setFirstKindId(String firstKindId) {
        this.firstKindId = firstKindId == null ? null : firstKindId.trim();
    }

    public String getFirstKindName() {
        return firstKindName;
    }

    public void setFirstKindName(String firstKindName) {
        this.firstKindName = firstKindName == null ? null : firstKindName.trim();
    }
}