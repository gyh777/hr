package com.hr.pojo;

public class ConfigPublicChar {
    private Short pbcId;

    private String attributeKind;

    private String attributeName;

    public Short getPbcId() {
        return pbcId;
    }

    public void setPbcId(Short pbcId) {
        this.pbcId = pbcId;
    }

    public String getAttributeKind() {
        return attributeKind;
    }

    public void setAttributeKind(String attributeKind) {
        this.attributeKind = attributeKind == null ? null : attributeKind.trim();
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }
}