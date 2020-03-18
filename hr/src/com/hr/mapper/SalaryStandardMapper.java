package com.hr.mapper;

import java.util.List;

import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;

public interface SalaryStandardMapper {
	
	public int insert(SalaryStandard ss);
	
	public int ckeckUpdate(String checkStatus,String checker,String checkTime,String checkComment);
	
	public int changeUpdate(SalaryStandardDetailsList salaryStandardDetailsList);
	
	public List<SalaryStandard> selectAll();
	
	public List<SalaryStandard> selectCheckAll();
	
	public List<SalaryStandard> selectChangeAll();
	
	public SalaryStandard selectBySsdId(String ssdId);
	
}
