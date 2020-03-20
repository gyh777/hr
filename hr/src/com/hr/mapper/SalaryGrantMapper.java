package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.SalaryGrant;
import com.hr.pojo.SalaryStandard;

public interface SalaryGrantMapper {
	
	public int insert(SalaryGrant salaryGrant);
	public List<SalaryGrant> selectCheckAll();
	public SalaryGrant selectBySgrId(String sgrId);
	public int ckeckUpdate(String sgrId,String checkStatus,String checker,String checkTime);
}
