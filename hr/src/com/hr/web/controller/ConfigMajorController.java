package com.hr.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.ConfigMajor;
import com.hr.service.ConfigMajorService;
import com.hr.util.CharacterEncodingHelper;

@Controller
@RequestMapping("/configMajor")
public class ConfigMajorController {
	@Autowired
	ConfigMajorService configMajorServiceImpl;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="/toDelete")
	@ResponseBody
	public String toDelete(@RequestParam("major_name")String major_name){
		major_name = CharacterEncodingHelper.getChinese(major_name);
		boolean b = configMajorServiceImpl.deleteConfigMajor(major_name);
		return String.valueOf(b);
	}
	
	@RequestMapping("/selectAll")
	public ModelAndView selectAll() {
		List<ConfigMajor> list = configMajorServiceImpl.selectAllConfigMajor();
		mav.setViewName("major");
		mav.addObject("majorList",list);
		return mav;
	}
	
}
