package com.hr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.pojo.SalaryGrant;
import com.hr.service.impl.SalaryGrantServiceImpl;
import com.hr.service.impl.SalaryStandardServiceImpl;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

@Controller
@RequestMapping("/salarygrant")
public class SalarygrantController {
	
	@Autowired
	SalaryGrantServiceImpl salaryGrantServiceImpl;
	@Autowired
	SalaryStandardServiceImpl salaryStandardServiceImpl;
	
	@RequestMapping("/register")
	public String register(@ModelAttribute SalaryGrant salaryGrant){
		
		Boolean bl = salaryGrantServiceImpl.save(salaryGrant);
		if(bl){
//			return "salarystandard_register_success";
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/standardIdAndName")
	public List<SalaryStandardIdAndName> standardIdAndName(){
		System.out.println("11");
		List<SalaryStandardIdAndName> idAndName = salaryStandardServiceImpl.selectIdAndName();
		return idAndName;
		
	}
}
