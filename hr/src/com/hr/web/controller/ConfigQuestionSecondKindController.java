package com.hr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.service.ConfigQuestionSecondKindService;

@Controller
@RequestMapping("/configQuestionSecondKind")
public class ConfigQuestionSecondKindController {
	@Autowired
	ConfigQuestionSecondKindService configQuestionSecondKindServiceImpl;
	
	
}
