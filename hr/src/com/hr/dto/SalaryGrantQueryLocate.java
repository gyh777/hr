package com.hr.dto;

public class SalaryGrantQueryLocate {

	private String salaryGrantId;
	private String textfield;
	private String startTime;
	
	private String endTime;
	
	
	public String getSalaryGrantId() {
		return salaryGrantId;
	}
	public void setSalaryGrantId(String salaryGrantId) {
		this.salaryGrantId = salaryGrantId;
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
				
				this.startTime = (startTime+" 00:00:00");

			}else{
				this.startTime = ("0000-00-00 00:00:00");
			}
		
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		
		
			if(endTime!=null&&endTime!=""){
				this.endTime = (endTime+" 23:59:59");
				
			}else{
				this.endTime = ("0000-00-00 00:00:00");
			}
		
	}
	
	

}
