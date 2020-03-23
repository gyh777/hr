package com.hr.web.controller.requestparamtype;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;

import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;

public class SalaryStandardDetailsList {
	
	DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

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
	
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date registTime;
	
	private String checker;
	
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date checkTime;
	
	private String changer;
	
	private short changeStatus;
	
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date changeTime;
	
	private short checkStatus;
	

	public short getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(short checkStatus) {
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

	public short getChangeStatus() {
		return changeStatus;
	}

	public void setChangeStatus(short changeStatus) {
		this.changeStatus = changeStatus;
	}

	
	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
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


	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		try {
			
			this.registTime = format.parse(registTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		try {
			this.checkTime = format.parse(checkTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		try {
			this.changeTime = format.parse(changeTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
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
