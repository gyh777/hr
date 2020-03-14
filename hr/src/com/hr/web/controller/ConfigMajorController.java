package com.hr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.service.ConfigMajorService;

@Controller
@RequestMapping("/configMajor")
public class ConfigMajorController {
	@Autowired
	ConfigMajorService configMajorServiceImpl;
	
	@RequestMapping("/toDelete")
	public String toDelete(int makId) {
		configMajorServiceImpl.deleteConfigMajor(makId);
		return "main";
	}
	
}
