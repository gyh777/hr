package com.hr.pojo;

public class ConfigFileFirstKind {
    private Short ffkId;

    private String firstKindId;

    private String firstKindName;

    public Short getFfkId() {
        return ffkId;
    }

    public void setFfkId(Short ffkId) {
        this.ffkId = ffkId;
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

	
