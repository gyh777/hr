package com.hr.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.SalaryStandardDetailsMapper;
import com.hr.mapper.SalaryStandardMapper;
import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;
import com.hr.service.SalaryStandardService;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;

@Service
public class SalaryStandardServiceImpl implements SalaryStandardService{

	@Autowired
	SalaryStandardDetailsMapper salaryStandardDetailsMapper;
	@Autowired
	SalaryStandardMapper salaryStandardMapper;
	
	@Override
	public Boolean save(SalaryStandardDetailsList ssdl) {
		
//		ssdId;standardId;standardName;designer;register;checker;changer;
//	    registTime;checkTime;changeTime;salarySum;checkStatus;changeStatus;
		
		SalaryStandard ss = new SalaryStandard();
//		ss.setChanger();
//		ss.setChangeStatus(0);
//		ss.setChangeTime(changeTime);
//		ss.setChecker(checker);
		ss.setChangeStatus((short) 0);
		ss.setCheckStatus((short) 0);
		ss.setCheckTime(ssdl.getCheckTime());
		ss.setDesigner(ssdl.getDesigner());
		ss.setRegister(ssdl.getRegister());
		ss.setRegistTime(ssdl.getRegistTime());
		ss.setSalarySum(ssdl.getSalarySum());
		ss.setSsdId(ssdl.getSsdId());
		ss.setStandardId(ssdl.getStandardId());
		ss.setStandardName(ssdl.getStandardName());
		
		int result = salaryStandardMapper.insert(ss);
		
		if(result>-1){
			ArrayList<SalaryStandardDetails> array = (ArrayList<SalaryStandardDetails>) ssdl.getSalaryStandardDetails();
			for (SalaryStandardDetails salaryStandardDetails : array) {
				salaryStandardDetails.setStandardName(ssdl.getStandardName());
				salaryStandardDetails.setStandardId(ssdl.getStandardId());
				salaryStandardDetails.setSalary(ssdl.getSalarySum());
				int result1 = salaryStandardDetailsMapper.insert(salaryStandardDetails);
				if(result1<0){
					return false;
				}
			}
			return true;
		}
			
		return false;
		
		
		
	}

}
