package com.hr.service;

import java.util.Date;
import java.util.List;

import com.hr.dto.SalaryStandardQueryLocate;
import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

public interface SalaryStandardService {

	public Boolean save(SalaryStandardDetailsList ssdl);
	public List<SalaryStandard> queryAll();
	public SalaryStandardDetailsList queryBySsdId(String ssdId);
	public String queryIdByName(String ssdId);
	public List<SalaryStandard> queryByConditionQuery(SalaryStandardQueryLocate salaryStandardQueryLocate);
	public List<SalaryStandardIdAndName> selectIdAndName();
}
