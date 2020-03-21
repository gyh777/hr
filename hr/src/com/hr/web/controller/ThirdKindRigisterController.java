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
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.ConfigFileFirstKind;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.pojo.ConfigFileThirdKind;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileThirdKindService;
import com.hr.service.ConfigMajorService;

@Controller
@RequestMapping("/thirdkindrigister")
public class ThirdKindRigisterController {
	@Autowired
	ConfigFileThirdKindService configFileThirdKindServiceImpl;
	
	@RequestMapping("/addrigister")
	public ModelAndView addRigister(@RequestParam String firstKindId,@RequestParam String firstKindName,@RequestParam String secondKindId,@RequestParam String secondKindName,@RequestParam String thirdKindId,@RequestParam String thirdKindName,@RequestParam String thirdKindIsRetail
			,@RequestParam String thirdKindSaleId){
		ConfigFileThirdKind  configFileThirdKind = new ConfigFileThirdKind();
		configFileThirdKind.setFirst_kind_id(firstKindId);
		configFileThirdKind.setFirst_kind_name(firstKindName);
		configFileThirdKind.setSecond_kind_id(secondKindId);
		configFileThirdKind.setSecond_kind_name(secondKindName);
		configFileThirdKind.setThird_kind_is_retail(thirdKindIsRetail);
		configFileThirdKind.setThird_kind_sale_id(thirdKindSaleId);
		configFileThirdKindServiceImpl.addConfigFileThirdKind(configFileThirdKind);
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("third_kind_register_success");
	    return mav;
	}

	@RequestMapping("/changerigister")
	public ModelAndView changeRigister(@RequestParam String thirdKindId){
		ConfigFileThirdKind  fileThirdKind = configFileThirdKindServiceImpl.queryConfigFileThirdKindById(thirdKindId);
		ModelAndView mav  = new ModelAndView();
		mav.addObject("fileThirdKind",fileThirdKind);
		mav.setViewName("second_kind_change");
		return mav;
	}
	
	@RequestMapping("/changerigisterTwo")
	public ModelAndView changeRigisterTwo(@RequestParam String thirdKindId,@RequestParam String firstKindId,@RequestParam String firstKindName,@RequestParam String secondKindId,@RequestParam String secondKindName,@RequestParam String thirdKindName, @RequestParam String thirdKindIsRetail,@RequestParam String thirdKindSaleId){
		
		ConfigFileThirdKind  fileThirdKind = configFileThirdKindServiceImpl.queryConfigFileThirdKindById(thirdKindId);
		fileThirdKind.setThird_kind_id(thirdKindId);
		fileThirdKind.setThird_kind_name(thirdKindName);
		fileThirdKind.setThird_kind_is_retail(thirdKindIsRetail);
		fileThirdKind.setThird_kind_sale_id(thirdKindSaleId);
		configFileThirdKindServiceImpl.updateConfigFileThirdKind(fileThirdKind);
		ModelAndView mav  = new ModelAndView();

		mav.setViewName("third_kind_change_success");
		return mav;
//		return null;
	}
	
	//查二级机构所有
	@RequestMapping("/loadthirdkind")
	public ModelAndView loadSecondKind(){
		ConfigFileThirdKind u=new ConfigFileThirdKind();
		
		  u.setPagebegin(2);
		  u.setPagesize(3);
		  List<ConfigFileThirdKind> thirdList =configFileThirdKindServiceImpl.queryAllThirdByPage(u);
        System.out.println(thirdList.size()+"======");
		ModelAndView mav  = new ModelAndView();
        mav.addObject("thirdList", thirdList);
        mav.addObject("pageNo", u.getPageid());
        mav.addObject("pageSize", u.getPagesize());
		mav.setViewName("third_kind");
		return mav;
	}
	
	
	
	
	@RequestMapping("/deleterigister")
	public String deleteRigister(@RequestParam String thirdKindId){
		configFileThirdKindServiceImpl.removeConfigFileThirdKind(thirdKindId);
		return "third_kind_delete_success";
	}
}
