package com.hr.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.EngageSubjects;
import com.hr.service.EngageSubjectsService;
import com.hr.util.UUIDHelper;


@Controller
@RequestMapping("/engageSubjects")
public class EngageSubjectsController {
	@Autowired
	EngageSubjectsService engageSubjectsServiceImpl;
	
	@RequestMapping("/save")
	public String save(EngageSubjects engageSubjects){
		engageSubjects.setSub_id(UUIDHelper.getUUID());
		engageSubjectsServiceImpl.save(engageSubjects);
		return "question_register_success";
	}
	
	@RequestMapping("/update")
	public String update(EngageSubjects engageSubjects){
		engageSubjectsServiceImpl.update(engageSubjects);
		return "";
	}
	
	@RequestMapping("/find")
	public String find(String firstKindName, String keyWord, String start, String end, HttpServletRequest request){
		System.out.println(firstKindName+"=="+keyWord+"=="+start+"=="+end);
		List<EngageSubjects> list = engageSubjectsServiceImpl.listEngageSubjects(firstKindName, keyWord, start, end);
		request.setAttribute("engageSubjectsFindList", list);
		return "question_query_list";
	}
	
}