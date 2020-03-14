package com.hr.pojo;

import java.util.Date;

public class EngageAnswer {
    private Short ansId;

    private String answerNumber;

    private String examNumber;

    private Short resumeId;

    private Short interviewId;

    private String humanName;

    private String humanIdcard;

    private String majorKindId;

    private String majorKindName;

    private String majorId;

    private String majorName;

    private Date testTime;

    private String useTime;

    private Double totalPoint;

    public Short getAnsId() {
        return ansId;
    }

    public void setAnsId(Short ansId) {
        this.ansId = ansId;
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber == null ? null : answerNumber.trim();
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber == null ? null : examNumber.trim();
    }

    public Short getResumeId() {
        return resumeId;
    }

    public void setResumeId(Short resumeId) {
        this.resumeId = resumeId;
    }

    public Short getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Short interviewId) {
        this.interviewId = interviewId;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName == null ? null : humanName.trim();
    }

    public String getHumanIdcard() {
        return humanIdcard;
    }

    public void setHumanIdcard(String humanIdcard) {
        this.humanIdcard = humanIdcard == null ? null : humanIdcard.trim();
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

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime == null ? null : useTime.trim();
    }

    public Double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Double totalPoint) {
        this.totalPoint = totalPoint;
    }
}