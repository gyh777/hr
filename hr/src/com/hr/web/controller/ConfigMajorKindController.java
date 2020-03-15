package com.hr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.ConfigMajorKind;
import com.hr.service.ConfigMajorKindService;
import com.hr.util.CharacterEncodingHelper;

@Controller
@RequestMapping("/configMajorKind")
public class ConfigMajorKindController {
	@Autowired
	ConfigMajorKindService configMajorKindServiceImpl;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="/toDelete")
	@ResponseBody
	public String toDelete(@RequestParam("major_kind_name")String major_kind_name){
		major_kind_name = CharacterEncodingHelper.getChinese(major_kind_name);
		boolean b = configMajorKindServiceImpl.deleteConfigMajorKind(major_kind_name);
		return String.valueOf(b);
	}
	
	@RequestMapping("/selectAll")
	public ModelAndView selectAll() {
		List<ConfigMajorKind> list = configMajorKindServiceImpl.selectAllConfigMajorKind();
		mav.setViewName("major_kind");
		mav.addObject("majorKindList",list);
		return mav;
	}
	
}
