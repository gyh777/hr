package com.hr.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.dto.SecondkindAndListDto;
import com.hr.dto.ThirdkindAndListDto;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.pojo.ConfigFileThirdKind;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigMajorService;

@Controller
@RequestMapping("/secondkindrigister")
public class SecondKindRigisterController {
	@Autowired
	ConfigFileSecondKindService configFileSecondKindServiceImpl;
	
	@RequestMapping("/addrigister")
	public ModelAndView addRigister(@RequestParam String firstKindId,@RequestParam String firstKindName,@RequestParam String secondKindId,@RequestParam String secondKindName,@RequestParam String secondKindSalaryId
			,@RequestParam String secondKindSaleId){
		ConfigFileSecondKind  configFileSecondKind = new ConfigFileSecondKind();
		configFileSecondKind.setFirst_kind_id(firstKindId);
		configFileSecondKind.setFirst_kind_name(firstKindName);
		configFileSecondKind.setSecond_kind_id(secondKindId);
		configFileSecondKind.setSecond_kind_name(secondKindName);
		configFileSecondKind.setSecond_salary_id(secondKindSalaryId);
		configFileSecondKind.setSecond_sale_id(secondKindSaleId);
		configFileSecondKindServiceImpl.addConfigFileSecondKind(configFileSecondKind);
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("second_kind_register_success");
	    return mav;
	}

	@RequestMapping("/changerigister")
	public ModelAndView changeRigister(@RequestParam String secondKindId){
		ConfigFileSecondKind  fileSecondKind = configFileSecondKindServiceImpl.queryConfigFileSecondKindById(secondKindId);
		ModelAndView mav  = new ModelAndView();
		mav.addObject("fileSecondKind",fileSecondKind);
		mav.setViewName("second_kind_change");
		return mav;
	}
	
	@RequestMapping("/changerigisterTwo")
	public ModelAndView changeRigisterTwo(@RequestParam String secondKindId,@RequestParam String secondKindName,@RequestParam String secondSalaryId,@RequestParam String secondSaleId){
		
		ConfigFileSecondKind  fileSecondKind = configFileSecondKindServiceImpl.queryConfigFileSecondKindById(secondKindId);
		fileSecondKind.setSecond_kind_id(secondKindId);
		fileSecondKind.setSecond_kind_name(secondKindName);
		fileSecondKind.setSecond_salary_id(secondSalaryId);
		fileSecondKind.setSecond_sale_id(secondSaleId);
		configFileSecondKindServiceImpl.updateConfigFileSecondKind(fileSecondKind);
		ModelAndView mav  = new ModelAndView();

		mav.setViewName("second_kind_change_success");
		return mav;
//		return null;
	}
	
	//查二级机构所有
	@RequestMapping("/loadsecondkind")
	public ModelAndView loadSecondKind(){
		ConfigFileSecondKind u=new ConfigFileSecondKind();
		u.setPagebegin(0);
		  u.setPagesize(3);
		  u.setPageid(1);
		  List<ConfigFileSecondKind> secondList =configFileSecondKindServiceImpl.queryAllSecondByPage(u);
		 System.out.println(secondList+"=======");
		  List<ConfigFileSecondKind> list =configFileSecondKindServiceImpl.queryAllConfigFileSecondKind();
		
		  int pageSum = list.size()%u.getPagesize()==0?list.size()/u.getPagesize():list.size()/u.getPagesize()+1;
		  list = null;
		  ModelAndView mav  = new ModelAndView();
      mav.addObject("secondList", secondList);
      mav.addObject("pageNo", u.getPageid());
      mav.addObject("pageSize", u.getPagesize());
      mav.addObject("pageSum", pageSum);
		mav.setViewName("second_kind");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/ajax")
	public SecondkindAndListDto ajaxPage(String pageSize,String pageNo){
		int pagesize = Integer.parseInt(pageSize);
//		System.out.println(pagesize+"=======");
		int pageno = Integer.parseInt(pageNo);
		
		int begin = (pageno-1)*pagesize;
		
		ConfigFileSecondKind u=new ConfigFileSecondKind();
		  u.setPagebegin(begin);
		  u.setPagesize(pagesize);
		  u.setPageid(pageno);
		  List<ConfigFileSecondKind> secondList =configFileSecondKindServiceImpl.queryAllSecondByPage(u);
		System.out.println(secondList.size()+"=======数据的数量");
		   SecondkindAndListDto dto = new SecondkindAndListDto();
		dto.setConfigFileSecondKind(u);
		dto.setList(secondList);
		return dto;
	}
	
	
	
	@RequestMapping("/deleterigister")
	public String deleteRigister(@RequestParam String secondKindId){
		configFileSecondKindServiceImpl.removeConfigFileSecondKind(secondKindId);
		return "second_kind_delete_success";
	}
}
