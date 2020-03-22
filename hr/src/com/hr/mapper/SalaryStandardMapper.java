package com.hr.mapper;

import java.util.Date;
import java.util.List;

import com.hr.dto.SalaryStandardQueryLocate;
import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

public interface SalaryStandardMapper {
	
	public int insert(SalaryStandardDetailsList ssdl);
	
	public int ckeckUpdate(String ssdId,String checkStatus,String checker,String checkTime,String checkComment);
	
	public int changeUpdate(SalaryStandardDetailsList salaryStandardDetailsList);
	
	public List<SalaryStandard> selectAll();
	
	public List<SalaryStandard> selectCheckAll();
	
	public List<SalaryStandard> selectChangeAll();
	
	public List<SalaryStandard> selectQueryAll();
	
	public List<SalaryStandardIdAndName> selectIdAndName();
	
	public SalaryStandardIdAndName selectIdAndNameOne(String ssdId);
	
	public SalaryStandard selectBySsdId(String ssdId);
	
	public String selectIdByName(String name);
	
	public String selectNextId();
	
	public List<SalaryStandard> selectByCondition(SalaryStandardQueryLocate salaryStandardQueryLocate);
	
}
