package com.hr.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.ltw.LTWWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.EngageMajorRelease;
import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileThirdKindService;
import com.hr.service.ConfigMajorKindService;
import com.hr.service.ConfigMajorService;
import com.hr.service.EngageMajorReleaseService;
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
	@Autowired
	EngageMajorReleaseService engageMajorReleaseServiceImpl;
	
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
			@RequestParam("firstName") String firstName) {
		List<TwoStringValue> list = 
				configFileSecondKindServiceImpl.queryIdAndNameByFirstKindName(firstName);
		
		return list;
	}
	
	@RequestMapping("/selectThirdKindIdAndName")
	@ResponseBody
	public List<TwoStringValue> selectThirdKindIdAndName(
			@RequestParam("firstName") String firstName,
			@RequestParam("secondName") String secondName) {
		List<TwoStringValue> list = 
				configFileThirdKindServiceImpl.queryKindIdAndName(firstName, secondName);
		
		return list;
	}
	
	@RequestMapping("/selectAllMajorIdAndName")
	@ResponseBody
	public List<TwoStringValue> selectAllMajorIdAndName(
			@RequestParam("firstName") String firstName) {
		List<TwoStringValue> list = 
				configMajorServiceImpl.selectAllConfigMajorIdAndName(firstName);
		
		return list;
	}
	
	@RequestMapping("/addEngageMajorRelease")
	@ResponseBody
	public boolean addEngageMajorRelease(@RequestParam String engageType
			,@RequestParam String firstKindId,@RequestParam String firstKindName
			,@RequestParam String secondKindId,@RequestParam String secondKindName
			,@RequestParam String thirdKindId,@RequestParam String thirdKindName
			,@RequestParam String majorKindId,@RequestParam String majorKindName
			,@RequestParam String majorId,@RequestParam String majorName
			,@RequestParam String humanAmount,@RequestParam String deadline
			,@RequestParam String register,@RequestParam String registTime
			,@RequestParam String majorDescribe,@RequestParam String engageRequired) {
		//定义两个转换类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		EngageMajorRelease emr = new EngageMajorRelease();
		emr.setFirst_kind_id(firstKindId);
		emr.setFirst_kind_name(firstKindName);
		emr.setSecond_kind_id(secondKindId);
		emr.setSecond_kind_name(secondKindName);
		emr.setThird_kind_id(thirdKindId);
		emr.setThird_kind_name(thirdKindName);
		emr.setEngage_type(engageType);
		emr.setMajor_kind_id(majorKindId);
		emr.setMajor_kind_name(majorKindName);
		emr.setMajor_id(majorId);
		emr.setMajor_name(majorName);
		emr.setHuman_amount(Short.parseShort(humanAmount));
		emr.setChanger("");
		emr.setChange_time(null);
		try {
			emr.setDeadline(sdf.parse(deadline));
			emr.setRegist_time(sdfs.parse(registTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emr.setRegister(register);
		emr.setMajor_describe(majorDescribe);
		emr.setEngage_required(engageRequired);
		
		//插入
		boolean b = engageMajorReleaseServiceImpl.addEngageMajorRelease(emr);
		return b;
	}
	
}
