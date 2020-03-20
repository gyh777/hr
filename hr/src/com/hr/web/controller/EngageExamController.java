package com.hr.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.ConfigMajor;
import com.hr.service.ConfigMajorService;

@Controller
@RequestMapping("/engageExam")
public class EngageExamController {

	@Autowired
	ConfigMajorService configMajorServiceImpl;
	
	@RequestMapping("/selectAllForQuestionTest")
	public String selectAllForQuestionTest(HttpServletRequest request){
		List<ConfigMajor> list = configMajorServiceImpl.selectAllConfigMajor();
		request.setAttribute("engageResumeFindList", list);
		
		return "question_test_list";
	}
}
