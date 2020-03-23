package com.hr.service;

import java.util.List;

import com.hr.pojo.SalaryGrant;
import com.hr.web.controller.requestparamtype.SalaryGrantAndDetails;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

public interface SalaryGrantService {

	public Boolean save(SalaryGrantAndDetails salaryGrantAndDetails);
}
