package com.hr.mapper;

import java.util.List;

import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;

public interface SalaryStandardDetailsMapper {
	public int insert(SalaryStandardDetails ssd);
	public int changeUpdate(SalaryStandardDetails ssd);
	public List<SalaryStandardDetails> selectBySsdId(String ssdId);
}
