package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.SalaryGrant;
import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryGrantAndDetails;

public interface SalaryGrantMapper {
	
	public int insert(SalaryGrantAndDetails salaryGrantAndDetails);
	public List<SalaryGrant> selectCheckAll();
	public SalaryGrant selectBySgrId(String sgrId);
	public int ckeckUpdate(String sgrId,String checkStatus,String checker,String checkTime);
}
