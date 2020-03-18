package com.hr.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ltw.LTWWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileThirdKindService;
import com.hr.service.ConfigMajorKindService;
import com.hr.service.ConfigMajorService;
import com.hr.util.CharacterEncodingHelper;
import com.hr.web.controller.requestparamtype.TwoStringValue;

@Controller
@RequestMapping("/engageMajorRelease")
public class EngageMajorReleaseController {
	@Autowired
	ConfigFileFirstKindService configFileFirstKindServiceImpl;
	@Autowired
	ConfigFileSecondKindService configFileSecondKindServiceImpl;
	@Autowired
	ConfigFileThirdKindService configFileThirdKindServiceImpl;
	@Autowired
	ConfigMajorService configMajorServiceImpl;
	@Autowired
	ConfigMajorKindService configMajorKindServiceImpl;
	
	@RequestMapping("/loadFirstKindAndMajorKind")
	public ModelAndView selectIdByName(String major_name) {
		//获得所有的初始值
		List<TwoStringValue> firstValue = 
				configFileFirstKindServiceImpl.queryConfigFileFirstKindIdAndName();
		List<TwoStringValue> majorKindValue = 
				configMajorKindServiceImpl.selectAllConfigMajorKindIdAndName();
		//放入map集合
		Map<String, List<TwoStringValue>> map = new HashMap<>();
		map.put("firstValue", firstValue);
		map.put("majorKindValue", majorKindValue);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("engage_major_release_register");
		mav.addObject("firstKindAndMajorKind", map);
		return mav;
	}
	
	@RequestMapping("/selectSecondKindIdAndName")
	@ResponseBody
	public List<TwoStringValue> selectConfigMajorIdAndName(
			@RequestParam("firstName") String first_kind_name) {
		first_kind_name = CharacterEncodingHelper.getChinese(first_kind_name);
		List<TwoStringValue> list = 
				configFileSecondKindServiceImpl.queryIdAndNameByFirstKindName(first_kind_name);
		Map<String ,List<TwoStringValue>> map = new HashMap<>();
		map.put("secondKindIdAndName", list);
		
		return list;
	}
	
}
