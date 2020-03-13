package com.hr.pojo;

public class EngageExamDetails {
    private Short exdId;

    private String examNumber;

    private String firstKindId;

    private String firstKindName;

    private String secondKindId;

    private String secondKindName;

    private Short questionAmount;

    public Short getExdId() {
        return exdId;
    }

    public void setExdId(Short exdId) {
        this.exdId = exdId;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber == null ? null : examNumber.trim();
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

    public String getSecondKindId() {
        return secondKindId;
    }

    public void setSecondKindId(String secondKindId) {
        this.secondKindId = secondKindId == null ? null : secondKindId.trim();
    }

    public String getSecondKindName() {
        return secondKindName;
    }

    public void setSecondKindName(String secondKindName) {
        this.secondKindName = secondKindName == null ? null : secondKindName.trim();
    }

    public Short getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(Short questionAmount) {
        this.questionAmount = questionAmount;
    }
}