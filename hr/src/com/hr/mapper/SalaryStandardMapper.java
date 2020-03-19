package com.hr.mapper;

import java.util.List;

import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

public interface SalaryStandardMapper {
	
	public int insert(SalaryStandard ss);
	
	public int ckeckUpdate(String checkStatus,String checker,String checkTime,String checkComment);
	
	public int changeUpdate(SalaryStandardDetailsList salaryStandardDetailsList);
	
	public List<SalaryStandard> selectAll();
	
	public List<SalaryStandard> selectCheckAll();
	
	public List<SalaryStandard> selectChangeAll();
	
	public List<SalaryStandard> selectQueryAll();
	
	public List<SalaryStandardIdAndName> selectIdAndName();
	
	public SalaryStandard selectBySsdId(String ssdId);
	
	public String selectIdByName(String name);
	
}
