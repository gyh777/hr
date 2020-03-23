package com.hr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dto.SalaryStandardQueryLocate;
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

		ssdl.setChangeStatus((short) 0);
		ssdl.setCheckStatus((short) 0);
		
		int result = salaryStandardMapper.insert(ssdl);
		
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
		System.out.println(ssdl.getSsdId());
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
		System.out.println(ssdId);
		SalaryStandardDetailsList ssdl = new SalaryStandardDetailsList();
		SalaryStandard salaryStandard = salaryStandardMapper.selectBySsdId(ssdId);
		if(salaryStandard!=null){
//			ssdl.setChangeStatus(salaryStandard.getChangeStatus().toString());
			String standardId = salaryStandard.getStandardId();
			ssdl.setCheckStatus(salaryStandard.getCheckStatus());
//			ssdl.setCheckTime(salaryStandard.getCheckTime().toString());
			ssdl.setDesigner(salaryStandard.getDesigner());
			ssdl.setRegister(salaryStandard.getRegister());
			ssdl.setRegistTime(salaryStandard.getRegistTime());
			ssdl.setSalarySum(salaryStandard.getSalarySum());
			ssdl.setSsdId(salaryStandard.getSsdId());
			ssdl.setStandardId(standardId);
			ssdl.setStandardName(salaryStandard.getStandardName());
			
			ArrayList<SalaryStandardDetails> salaryStandardDetails = (ArrayList<SalaryStandardDetails>) salaryStandardDetailsMapper.selectByStandardId(standardId);
			
			ssdl.setSalaryStandardDetails(salaryStandardDetails);
		}

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
	
	public String queryNextId(){
		return salaryStandardMapper.selectNextId();
	}

	@Override
	public List<SalaryStandard> queryByConditionQuery(SalaryStandardQueryLocate salaryStandardQueryLocate) {
		List<SalaryStandard> list = salaryStandardMapper.selectByConditionQuery(salaryStandardQueryLocate);	
		return list;
	}
	
	
	public List<SalaryStandard> queryByConditionChange(SalaryStandardQueryLocate salaryStandardQueryLocate) {
		List<SalaryStandard> list = salaryStandardMapper.selectByConditionChange(salaryStandardQueryLocate);	
		return list;
	}

	@Override
	public List<SalaryStandardIdAndName> selectIdAndName() {
		// TODO Auto-generated method stub
		return salaryStandardMapper.selectIdAndName();
	}
}
