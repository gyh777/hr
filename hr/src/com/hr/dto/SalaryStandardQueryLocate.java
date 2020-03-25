package com.hr.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryStandardQueryLocate {

//	DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String standardId;
	private String textfield;
	private String startTime;
	
	private String endTime;
	
	public String getStandardId() {
		return standardId;
	}
	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		
			if(startTime!=null&&startTime!=""){
				
				this.startTime = (startTime+" 00:00:01");

			}else{
				this.startTime = ("2000-01-01 01:01:01");
			}
		
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		
		
			if(endTime!=null&&endTime!=""){
				this.endTime = (endTime+" 23:59:59");
				
			}else{
				this.endTime = ("5000-12-15 23:59:59");
			}
		
	}
	@Override
	public String toString() {
		return "SalaryStandardQueryLocate [standardId=" + standardId
				+ ", textfield=" + textfield + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
}
