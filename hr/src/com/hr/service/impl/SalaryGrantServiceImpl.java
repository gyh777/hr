package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.dto.SalaryGrantQueryLocate;
import com.hr.dto.SalaryStandardQueryLocate;
import com.hr.mapper.SalaryGrantMapper;
import com.hr.pojo.SalaryGrant;
import com.hr.pojo.SalaryStandard;
import com.hr.service.SalaryGrantService;
import com.hr.web.controller.requestparamtype.SalaryGrantAndDetails;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

@Service
public class SalaryGrantServiceImpl implements SalaryGrantService{

	@Autowired
	SalaryGrantMapper salaryGrantMapper;
	
	@Override
	public Boolean save(SalaryGrantAndDetails salaryGrantAndDetails) {
		salaryGrantAndDetails.setCheckStatus((short) 0);
		int i = salaryGrantMapper.insert(salaryGrantAndDetails);
		if(i<0){
			return false;
		}
		return true;
	}
	
	
	public SalaryGrant queryBySgrId(String sgrId){
		SalaryGrant salaryGrant = salaryGrantMapper.selectBySgrId(sgrId);
		return salaryGrant;
		
	}
	
	public List<SalaryGrant> queryCheckAll(){
		List<SalaryGrant> list = salaryGrantMapper.selectCheckAll();
		return list;
		
	}
	
	public List<SalaryGrant> queryQueryAll(){
		List<SalaryGrant> list = salaryGrantMapper.selectQueryAll();
		return list;
		
	}

	public Boolean checkChange(String checker,String checkTime,String sgrId){
		System.out.println(sgrId+"---"+checker);
		int a = salaryGrantMapper.checkUpdate(sgrId,"1",checker, checkTime);
			if(a>-1){
				return true;
			}
		return false;
		
	}
	
	public String queryNextId(){
		return salaryGrantMapper.selectNextId();
	}
	
	public List<SalaryGrant> queryByConditionQuery(SalaryGrantQueryLocate salaryGrantQueryLocate) {
		List<SalaryGrant> list = salaryGrantMapper.selectByConditionQuery(salaryGrantQueryLocate);	
		return list;
	}
}
