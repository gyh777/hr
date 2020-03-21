package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.mapper.SalaryGrantMapper;
import com.hr.pojo.SalaryGrant;
import com.hr.service.SalaryGrantService;
import com.hr.web.controller.requestparamtype.SalaryGrantAndDetails;

@Service
public class SalaryGrantServiceImpl implements SalaryGrantService{

	@Autowired
	SalaryGrantMapper salaryGrantMapper;
	
	@Override
	public Boolean save(SalaryGrantAndDetails salaryGrantAndDetails) {
		salaryGrantAndDetails.setCheckStatus((short) 0);
		salaryGrantMapper.insert(salaryGrantAndDetails);
		return null;
	}
	
	
	public SalaryGrant queryBySgrId(String sgrId){
		SalaryGrant salaryGrant = salaryGrantMapper.selectBySgrId(sgrId);
		return salaryGrant;
		
	}
	
	public List<SalaryGrant> queryCheckAll(){
		List<SalaryGrant> list = salaryGrantMapper.selectCheckAll();
		return list;
		
	}

	public Boolean checkChange(String checker,String checkTime,String sgrId){
		int a = salaryGrantMapper.ckeckUpdate(sgrId,"1",checker, checkTime);
			if(a>-1){
				return true;
			}
		return false;
		
	}
	
	public String queryNextId(){
		return salaryGrantMapper.selectNextId();
	}
}
