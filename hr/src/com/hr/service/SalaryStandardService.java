package com.hr.service;

import java.util.List;

import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;

public interface SalaryStandardService {

	public Boolean save(SalaryStandardDetailsList ssdl);
	public List<SalaryStandard> queryAll();
	public SalaryStandardDetailsList queryBySsdId(String ssdId);
}
