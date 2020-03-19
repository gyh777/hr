package com.hr.web.controller.requestparamtype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;

public class SalaryStandardDetailsList {

	private List<SalaryStandardDetails> salaryStandardDetails = new ArrayList<SalaryStandardDetails>();
	
//	private SalaryStandard ss;
	
	private short ssdId;
	
	private String remark;
	
	private String checkComment;
	
	private String standardId;
	
	private String standardName;
	
	private String salarySum;
	
	private String designer;
	
	private String register;
	
	private String registTime;
	
	private String checker;
	
	private String checkTime;
	
	private String changer;
	
	private String changeStatus;
	
	private String changeTime;
	
	private String checkStatus;
	

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckComment() {
		return checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

	public short getSsdId() {
		return ssdId;
	}

	public void setSsdId(short ssdId) {
		this.ssdId = ssdId;
	}

	public String getChanger() {
		return changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}

	public String getChangeStatus() {
		return changeStatus;
	}

	public void setChangeStatus(String changeStatus) {
		this.changeStatus = changeStatus;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getStandardId() {
		return standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getSalarySum() {
		return salarySum;
	}

	public void setSalarySum(String salarySum) {
		this.salarySum = salarySum;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SalaryStandardDetails> getSalaryStandardDetails() {
		return salaryStandardDetails;
	}

	public void setSalaryStandardDetails(
			List<SalaryStandardDetails> salaryStandardDetails) {
		this.salaryStandardDetails = salaryStandardDetails;
	}

//	public SalaryStandard getSs() {
//		return ss;
//	}
//
//	public void setSs(SalaryStandard ss) {
//		this.ss = ss;
//	}

	@Override
	public String toString() {
		return "SalaryStandardDetailsList [salaryStandardDetails="
				+ salaryStandardDetails + ", remark=" + remark
				+ ", standardId=" + standardId + ", standardName="
				+ standardName + ", salarySum=" + salarySum + ", designer="
				+ designer + ", register=" + register + ", registTime="
				+ registTime + "]";
	}

	
	
	
	
	
	
}
