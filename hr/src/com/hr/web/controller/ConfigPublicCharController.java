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
	public String toDelete(@RequestParam("delete_name")String delete_name){
		delete_name = CharacterEncodingHelper.getChinese(delete_name);
		String[] str = delete_name.split("and");
		String attribute_kind = str[0];
		String attribute_name = str[1];
		System.out.println(attribute_kind);
		System.out.println(attribute_name);
		boolean b = configPublicCharServiceImpl.deleteConfigPublicChar(attribute_kind,attribute_name);
		return String.valueOf(b);
	}
	
	@RequestMapping("/selectAll")
	public ModelAndView selectAll() {
		List<ConfigPublicChar> list = configPublicCharServiceImpl.selectAllConfigPublicChar();
		System.out.println(list.size());
		mav.setViewName("public_char");
		mav.addObject("publicCharList",list);
		return mav;
	}
	
}
