package com.hr.mapper;

import java.util.List;

import com.hr.pojo.SalaryStandard;

public interface SalaryStandardMapper {
	
	public int insert(SalaryStandard ss);
	
	public List<SalaryStandard> selectAll();
	
	public SalaryStandard selectBySsdId(String ssdId);
	
}
