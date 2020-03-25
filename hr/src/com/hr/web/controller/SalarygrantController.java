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

import com.hr.dto.SalaryGrantQueryLocate;
import com.hr.dto.SalaryStandardQueryLocate;
import com.hr.pojo.SalaryGrant;
import com.hr.pojo.SalaryGrantDetails;
import com.hr.pojo.SalaryStandard;
import com.hr.service.impl.HumanFileServiceImpl;
import com.hr.service.impl.SalaryGrantDetailsServiceImpl;
import com.hr.service.impl.SalaryGrantServiceImpl;
import com.hr.service.impl.SalaryStandardServiceImpl;
import com.hr.web.controller.requestparamtype.HunanFileHumanIdAndName;
import com.hr.web.controller.requestparamtype.SalaryGrantAndDetails;
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
	@Autowired
	SalaryGrantDetailsServiceImpl salaryGrantDetailsServiceImpl;
	
	@RequestMapping("/register")
	public String register(@ModelAttribute SalaryGrantAndDetails salaryGrantAndDetails){
		
		Boolean bl = salaryGrantServiceImpl.save(salaryGrantAndDetails);
		List<SalaryGrantDetails> list = salaryGrantAndDetails.getSalaryGrantDetails();
		if(list!=null){
			
			for (SalaryGrantDetails salaryGrantDetails : list) {
				salaryGrantDetails.setSalaryGrantId(salaryGrantAndDetails.getSalaryGrantId());
			}
			salaryGrantDetailsServiceImpl.save(list);
		}
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
		System.out.println("---");
		List<HunanFileHumanIdAndName> list = humanFileServiceImpl.queryHumanFileByKindId(firstKindId, secondKindId, thirdKindId);
		return list;
	}
	
	@RequestMapping("/check")
	public String check(@RequestParam String sgrId,@RequestParam String ssdId,Model m){
		SalaryGrant salaryGrant = salaryGrantServiceImpl.queryBySgrId(sgrId);
		m.addAttribute("check", salaryGrant);
		List<SalaryGrantDetails> list = salaryGrantDetailsServiceImpl.queryBySgrId(sgrId);
		m.addAttribute("human", list);
		
		SalaryStandardIdAndName salaryStandardIdAndName = salaryStandardServiceImpl.queryIdAndNameOne(ssdId);
		m.addAttribute("standard", salaryStandardIdAndName);
		return "salarygrant_check";
	}
	
	@RequestMapping(value="/checkList")
	public String checkList(HttpServletRequest request){
		
		ArrayList<SalaryGrant> list = (ArrayList<SalaryGrant>) salaryGrantServiceImpl.queryCheckAll();
//		JSONArray ja = JSONArray.fromObject(list);
		request.setAttribute("list", list);
		return "salarygrant_check_list";
	}
	
	@RequestMapping(value="/checkAdopt")
	public String checkAdopt(@RequestParam String checker,@RequestParam String checkTime,@RequestParam String sgrId){
		System.out.println(checker+"-"+checkTime+"-"+sgrId);
		Boolean b = salaryGrantServiceImpl.checkChange(checker, checkTime, sgrId);
		if(b){
			return "";
		}
		return null;
	}
	
	@RequestMapping("/query")
	public String query(@RequestParam String sgrId,@RequestParam String ssdId,Model m){
		SalaryGrant salaryGrant = salaryGrantServiceImpl.queryBySgrId(sgrId);
		m.addAttribute("check", salaryGrant);
		List<SalaryGrantDetails> list = salaryGrantDetailsServiceImpl.queryBySgrId(sgrId);
		m.addAttribute("human", list);
		
		SalaryStandardIdAndName salaryStandardIdAndName = salaryStandardServiceImpl.queryIdAndNameOne(ssdId);
		m.addAttribute("standard", salaryStandardIdAndName);
		return "salarygrant_query";
	}
	
	@RequestMapping(value="/queryList")
	public String queryList(HttpServletRequest request,SalaryGrantQueryLocate salaryGrantQueryLocate){
		ArrayList<SalaryGrant> list = (ArrayList<SalaryGrant>) salaryGrantServiceImpl.queryByConditionQuery(salaryGrantQueryLocate);
//		JSONArray ja = JSONArray.fromObject(list);
		
		request.setAttribute("list", list);
		return "salarygrant_query_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/nextId")
	public String nextId(){		
		return salaryGrantServiceImpl.queryNextId();		
	}
	
}
