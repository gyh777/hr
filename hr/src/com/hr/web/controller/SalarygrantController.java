package com.hr.web.controller;


import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.pojo.SalaryGrant;
import com.hr.service.impl.HumanFileServiceImpl;
import com.hr.service.impl.SalaryGrantServiceImpl;
import com.hr.service.impl.SalaryStandardServiceImpl;
import com.hr.web.controller.requestparamtype.HunanFileHumanIdAndName;
import com.hr.web.controller.requestparamtype.SalaryStandardDetailsList;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

@Controller
@RequestMapping("/salarygrant")
public class SalarygrantController {
	
	@Autowired
	SalaryGrantServiceImpl salaryGrantServiceImpl;
	@Autowired
	SalaryStandardServiceImpl salaryStandardServiceImpl;
	@Autowired
	HumanFileServiceImpl humanFileServiceImpl;
	
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
		List<SalaryStandardIdAndName> idAndName = salaryStandardServiceImpl.queryIdAndName();
		return idAndName;
		
	}
	
	@ResponseBody
	@RequestMapping("/humanIdAndName")
	public List<HunanFileHumanIdAndName> humanIdAndName(String firstKindId,String secondKindId,String thirdKindId){
		List<HunanFileHumanIdAndName> list = humanFileServiceImpl.queryHumanFileByKindId(firstKindId, secondKindId, thirdKindId);
	return list;
	}
	
	@RequestMapping("/check")
	public String check(@RequestParam String sgrId,@RequestParam String ssdId,Model m){
		SalaryGrant salaryGrant = salaryGrantServiceImpl.queryBySgrId(sgrId);
		m.addAttribute("check", salaryGrant);
		SalaryStandardIdAndName salaryStandardIdAndName = salaryStandardServiceImpl.queryIdAndNameOne(ssdId);
		m.addAttribute("standard", salaryStandardIdAndName);
		return "salarygrant_check";
	}
	
	@RequestMapping(value="/checkList")
	public String checkList(HttpServletRequest request){
		System.out.println(111);
		ArrayList<SalaryGrant> list = (ArrayList<SalaryGrant>) salaryGrantServiceImpl.queryCheckAll();
//		JSONArray ja = JSONArray.fromObject(list);
		request.setAttribute("list", list);
		return "salarygrant_check_list";
	}
	
	@RequestMapping(value="/checkAdopt")
	public String checkAdopt(@RequestParam String checker,@RequestParam String checkTime,@RequestParam String sgrId){
		Boolean b = salaryGrantServiceImpl.checkChange(checker, checkTime, sgrId);
		if(b){
			return "";
		}
		return null;
	}
	
}
