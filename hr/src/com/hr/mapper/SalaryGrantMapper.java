package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.dto.SalaryGrantQueryLocate;
import com.hr.dto.SalaryStandardQueryLocate;
import com.hr.pojo.Bonus;
import com.hr.pojo.SalaryGrant;
import com.hr.pojo.SalaryStandard;
import com.hr.web.controller.requestparamtype.SalaryGrantAndDetails;

public interface SalaryGrantMapper {
	public String selectNextId();
	public int insert(SalaryGrantAndDetails salaryGrantAndDetails);
	public List<SalaryGrant> selectCheckAll();
	public List<SalaryGrant> selectQueryAll();
	public SalaryGrant selectBySgrId(String sgrId);
	public List<SalaryGrant> selectByConditionQuery(SalaryGrantQueryLocate salaryGrantQueryLocate);
	public int checkUpdate(@Param(value="sgrId")String sgrId,@Param(value="checkStatus")String checkStatus,@Param(value="checker")String checker,@Param(value="checkTime")String checkTime);
	
}
