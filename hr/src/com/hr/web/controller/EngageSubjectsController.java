package com.hr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.EngageSubjects;
import com.hr.service.EngageSubjectsService;

@Controller
@RequestMapping("/engageSubjects")
public class EngageSubjectsController {
	@Autowired
	EngageSubjectsService engageSubjectsServiceImpl;
	
	@RequestMapping("save")
	public String save(EngageSubjects engageSubjects){
		engageSubjectsServiceImpl.save(engageSubjects);
		return "";
	}
	
	@RequestMapping("update")
	public String update(EngageSubjects engageSubjects){
		engageSubjectsServiceImpl.update
		(engageSubjects);
		return "";
	}
	
	@RequestMapping("find")
	public String find(String firstKindName, String keyWord, String start, String end){
		engageSubjectsServiceImpl.listEngageSubjects(firstKindName, keyWord, start, end);
		return "";
	}
	
}
