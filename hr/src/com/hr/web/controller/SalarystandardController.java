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

import com.hr.pojo.EngageSubjects;
import com.hr.pojo.SalaryStandard;
import com.hr.pojo.SalaryStandardDetails;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;

@Controller
@RequestMapping("/salarystandard")
public class SalarystandardController {
	
	@RequestMapping("/register")
	public String register(@ModelAttribute SalaryStandardDetailsList salaryStandardDetails){
		System.out.println(salaryStandardDetails);
		System.out.println(salaryStandardDetails.getSalaryStandardDetails().get(1).getItemName());
		System.out.println();
		return "salarystandard_register_success";
	}
}
