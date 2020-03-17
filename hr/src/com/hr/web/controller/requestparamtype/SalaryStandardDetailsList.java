package com.hr.web.controller.requestparamtype;

import java.util.ArrayList;
import java.util.List;

import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;

public class SalaryStandardDetailsList {

	private List<SalaryStandardDetails> salaryStandardDetails = new ArrayList<SalaryStandardDetails>();

	private SalaryStandard salaryStandard ;
	
	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SalaryStandard getSalaryStandard() {
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard) {
		this.salaryStandard = salaryStandard;
	}

	public List<SalaryStandardDetails> getSalaryStandardDetails() {
		return salaryStandardDetails;
	}

	public void setSalaryStandardDetails(
			List<SalaryStandardDetails> salaryStandardDetails) {
		this.salaryStandardDetails = salaryStandardDetails;
	}

	@Override
	public String toString() {
		return "SalaryStandardDetailsList [salaryStandardDetails="
				+ salaryStandardDetails + ", salaryStandard=" + salaryStandard
				+ ", remark=" + remark + "]";
	}

	
	
}
