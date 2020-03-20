package com.hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.SalaryGrantMapper;
import com.hr.pojo.SalaryGrant;
import com.hr.service.SalaryGrantService;

@Service
public class SalaryGrantServiceImpl implements SalaryGrantService{

	@Autowired
	SalaryGrantMapper salaryGrantMapper;
	
	@Override
	public Boolean save(SalaryGrant salaryGrant) {
		salaryGrantMapper.insert(salaryGrant);
		return null;
	}

}
