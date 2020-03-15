package com.hr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.ConfigPublicChar;
import com.hr.service.ConfigPublicCharService;
import com.hr.util.CharacterEncodingHelper;

@Controller
@RequestMapping("/configPublicChar")
public class ConfigPublicCharController {
	@Autowired
	ConfigPublicCharService configPublicCharServiceImpl;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="/toDelete")
	@ResponseBody
	public String toDelete(@RequestParam("delete_kind")String delete_kind,
								@RequestParam("delete_name")String delete_name){
		delete_kind = CharacterEncodingHelper.getChinese(delete_kind);
		delete_name = CharacterEncodingHelper.getChinese(delete_name);
		boolean b = configPublicCharServiceImpl.deleteConfigPublicChar(delete_kind,delete_name);
		return String.valueOf(b);
	}
	
	@RequestMapping("/selectAll")
	public ModelAndView selectAll() {
		List<ConfigPublicChar> list = configPublicCharServiceImpl.selectAllConfigPublicChar();
		mav.setViewName("public_char");
		mav.addObject("publicCharList",list);
		return mav;
	}
	
	@RequestMapping("/selectTheSameAttribute")
	public ModelAndView selectTheSameAttribute(String attribute_kind) {
		attribute_kind = CharacterEncodingHelper.getChinese(attribute_kind);
		List<String> list = configPublicCharServiceImpl.selectTheSameAttribute(attribute_kind);
		mav.setViewName("profession_design");
		mav.addObject("AttributeList",list);
		return mav;
	}
	
}
