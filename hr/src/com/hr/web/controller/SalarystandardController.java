package com.hr.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.service.impl.SalaryStandardServiceImpl;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;

@Controller
@RequestMapping("/salarystandard")
public class SalarystandardController {
	
	@Autowired
	SalaryStandardServiceImpl salaryStandardServiceImpl;
	
	@RequestMapping("/register")
	public String register(@ModelAttribute SalaryStandardDetailsList salaryStandardDetails){
		Boolean bl = salaryStandardServiceImpl.save(salaryStandardDetails);
		if(bl){
			return "salarystandard_register_success";
		}
		return null;
	}
}
