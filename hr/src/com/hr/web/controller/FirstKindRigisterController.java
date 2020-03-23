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
		int pageNo=1;   //当前页码
        int pageSize=5;   //页面大小
        //获取当前页数据
        List<ConfigFileFirstKind> firstList = configFileFirstKindServiceImpl.getAllFirstByPage(pageNo,pageSize);
        
		ModelAndView mav  = new ModelAndView();
        mav.addObject("firstList", firstList);
        mav.addObject("pageNo", pageNo);
        mav.addObject("pageSize", pageSize);
		mav.setViewName("first_kind");
		return mav;
	}
	
	@RequestMapping("/deleterigister")
	public String deleteRigister(@RequestParam String firstKindId){
		configFileFirstKindServiceImpl.removeConfigFileFirstKind(firstKindId);
		return "first_kind_delete_success";
	}
}
