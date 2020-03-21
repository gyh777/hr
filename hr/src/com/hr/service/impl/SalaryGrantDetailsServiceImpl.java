package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.SalaryGrantDetailsMapper;
import com.hr.pojo.SalaryGrantDetails;
import com.hr.service.SalaryGrantDetailsService;

@Service
public class SalaryGrantDetailsServiceImpl implements SalaryGrantDetailsService{

	@Autowired 
	SalaryGrantDetailsMapper salaryGrantDetailsMapper;
	
	@Override
	public Boolean save(List<SalaryGrantDetails> list) {
		Boolean flag = true;
		for (SalaryGrantDetails salaryGrantDetails : list) {
			int i = salaryGrantDetailsMapper.insert(salaryGrantDetails);
			if(i<0){
				flag = false;
			}
		}
		return flag;
	}

}
