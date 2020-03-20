package com.hr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.SalaryStandardDetailsMapper;
import com.hr.mapper.SalaryStandardMapper;
import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;
import com.hr.service.SalaryStandardService;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

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
		ss.setChangeStatus((short) 0);
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
				
				int result1 = salaryStandardDetailsMapper.insert(salaryStandardDetails);
				if(result1<0){
					return false;
				}
			}
			return true;
		}
			
		return false;
		
		
		
	}

	public Boolean changeAdopt(SalaryStandardDetailsList ssdl) {
		
		int i = salaryStandardMapper.changeUpdate(ssdl);
		
		ArrayList<SalaryStandardDetails> array = (ArrayList<SalaryStandardDetails>) ssdl.getSalaryStandardDetails();
		for (SalaryStandardDetails salaryStandardDetails : array) {
			salaryStandardDetails.setStandardName(ssdl.getStandardName());
			salaryStandardDetails.setStandardId(ssdl.getStandardId());
			
			int result1 = salaryStandardDetailsMapper.changeUpdate(salaryStandardDetails);
			if(result1<0){
				return false;
			}
		
		}
		return true;
	}
	
	public Boolean checkChange(String ssdId,String checker,String checkTime,String checkComment){
		int a = salaryStandardMapper.ckeckUpdate(ssdId,"1",checker, checkTime, checkComment);
			if(a>-1){
				return true;
			}
		return false;
		
	}
	
	public List<SalaryStandard> queryAll(){
		ArrayList<SalaryStandard> list = (ArrayList<SalaryStandard>) salaryStandardMapper.selectAll();
		return list;
	}
	
	public List<SalaryStandard> queryCheckAll(){
		ArrayList<SalaryStandard> list = (ArrayList<SalaryStandard>) salaryStandardMapper.selectCheckAll();
		return list;
	}
	
	
	public List<SalaryStandard> queryChangeAll(){
		ArrayList<SalaryStandard> list = (ArrayList<SalaryStandard>) salaryStandardMapper.selectChangeAll();
		return list;
	}
	
//	public List<SalaryStandard> queryQueryAll(){
//		ArrayList<SalaryStandard> list = (ArrayList<SalaryStandard>) salaryStandardMapper.selectQueryAll();
//		return list;
//	}

	@Override
	public SalaryStandardDetailsList queryBySsdId(String ssdId) {
		SalaryStandardDetailsList ssdl = new SalaryStandardDetailsList();
		SalaryStandard salaryStandard = salaryStandardMapper.selectBySsdId(ssdId);
//		ssdl.setChangeStatus(salaryStandard.getChangeStatus().toString());
		String standardId = salaryStandard.getStandardId();
		ssdl.setCheckStatus(salaryStandard.getCheckStatus().toString());
		ssdl.setCheckTime(salaryStandard.getCheckTime());
		ssdl.setDesigner(salaryStandard.getDesigner());
		ssdl.setRegister(salaryStandard.getRegister());
		ssdl.setRegistTime(salaryStandard.getRegistTime());
		ssdl.setSalarySum(salaryStandard.getSalarySum());
		ssdl.setSsdId(salaryStandard.getSsdId());
		ssdl.setStandardId(standardId);
		ssdl.setStandardName(salaryStandard.getStandardName());
		
		ArrayList<SalaryStandardDetails> salaryStandardDetails = (ArrayList<SalaryStandardDetails>) salaryStandardDetailsMapper.selectByStandardId(standardId);
		
		ssdl.setSalaryStandardDetails(salaryStandardDetails);
		return ssdl;
	}

	@Override
	public String queryIdByName(String ssdId) {
		String standardName = salaryStandardMapper.selectIdByName(ssdId);
		return standardName;
	}
	
	
	public List<SalaryStandardIdAndName> queryIdAndName() {
		List<SalaryStandardIdAndName> standardIdAndName = salaryStandardMapper.selectIdAndName();
		return standardIdAndName;
	}
	
	public SalaryStandardIdAndName queryIdAndNameOne(String ssdId) {
		SalaryStandardIdAndName standardIdAndName = salaryStandardMapper.selectIdAndNameOne(ssdId);
		return standardIdAndName;
	}
}
