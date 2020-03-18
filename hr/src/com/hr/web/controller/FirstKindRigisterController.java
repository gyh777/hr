package com.hr.web.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.ConfigFileFirstKind;
import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigMajorService;
import com.hr.web.controller.requestparamtype.TwoStringValue;

@Controller
@RequestMapping("/firstkindrigister")
public class FirstKindRigisterController {
	@Autowired
	ConfigFileFirstKindService configFileFirstKindServiceImpl;
	
	@RequestMapping("/addrigister")
	public String addRigister(@RequestParam String firstKindId,@RequestParam String firstKindName,@RequestParam String firstKindSalaryId
			,@RequestParam String firstKindSaleId){
		
		ConfigFileFirstKind  configFileFirstKind = new ConfigFileFirstKind();
		configFileFirstKind.setFirst_kind_id(firstKindId);
		configFileFirstKind.setFirst_kind_name(firstKindName);
		configFileFirstKind.setFirst_kind_salary_id(firstKindSalaryId);
		configFileFirstKind.setFirst_kind_sale_id(firstKindSaleId);
		configFileFirstKindServiceImpl.addConfigFileFirstKind(configFileFirstKind);
	    return "first_kind_rigister_success";
	}

	@RequestMapping("/changerigister")
	public ModelAndView changeRigister(@RequestParam String firstKindId,Model model){
		ConfigFileFirstKind  fileFirstKind = configFileFirstKindServiceImpl.queryConfigFileFirstKindById(firstKindId);
		ModelAndView mav  = new ModelAndView();
		mav.addObject("fileFirstKind",fileFirstKind);
		mav.setViewName("first_kind_change");
		return mav;
	}
	
	@RequestMapping("/changerigisterTwo")
	public ModelAndView changeRigisterTwo(@RequestParam String firstKindId,@RequestParam String firstKindSaleId,@RequestParam String firstKindName,@RequestParam String firstKindSalaryId,Model model){
		ConfigFileFirstKind  fileFirstKind = configFileFirstKindServiceImpl.queryConfigFileFirstKindById(firstKindId);
		fileFirstKind.setFirst_kind_id(firstKindId);
		fileFirstKind.setFirst_kind_name(firstKindName);
		fileFirstKind.setFirst_kind_salary_id(firstKindSalaryId);
		fileFirstKind.setFirst_kind_sale_id(firstKindSaleId);
		configFileFirstKindServiceImpl.updateConfigFileFirstKind(fileFirstKind);
		ModelAndView mav  = new ModelAndView();

		mav.setViewName("first_kind_change_success");
		return mav;
//		return null;
	}
	
	//查一级机构所有
	@RequestMapping("/loadfirstkind")
	public ModelAndView loadFirstKind(){
		List<ConfigFileFirstKind> map = configFileFirstKindServiceImpl.queryAllConfigFileFirstKind();
		ModelAndView mav  = new ModelAndView();
        mav.addObject("firstMap", map);
		mav.setViewName("first_kind");
		return mav;
	}
	
	
	//查一级机构的名称和id
	@RequestMapping("/loadFirstKindIdAndName")
	public ModelAndView loadFirstKindIdAndName(){
		List<TwoStringValue> list = configFileFirstKindServiceImpl.queryConfigFileFirstKindIdAndName();
		ModelAndView mav  = new ModelAndView();
		Iterator<TwoStringValue> iterator = list.iterator();
		while(iterator.hasNext()){
			TwoStringValue stringValue = iterator.next();
			System.out.println(stringValue.getFirst()+stringValue.getSecond());
		}
		System.out.println("loadFirstKindIdAndName");
        mav.addObject("idAndName", list);
		return mav;
	}
	
	
	
	
	@RequestMapping("/deleterigister")
	public String deleteRigister(@RequestParam String firstKindId){
		configFileFirstKindServiceImpl.removeConfigFileFirstKind(firstKindId);
		return "first_kind_delete_success";
	}
}
