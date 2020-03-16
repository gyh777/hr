package com.hr.web.controller;

import java.util.Date;
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
	
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<EngageSubjects> list = engageSubjectsServiceImpl.listAll();
		request.setAttribute("engageSubjectsList", list);
		return "question_query_list_all";
	}
	
	@RequestMapping("/getBySubId")
	public String getBySubId(String sub_id, HttpServletRequest request){
		EngageSubjects engageSubjects = engageSubjectsServiceImpl.getBySubId(sub_id);
		request.setAttribute("engageSubjects", engageSubjects);
		return "question_update";
	}
	
	@RequestMapping("/getBySubIdForDelete")
	public String getBySubIdForDelete(String sub_id, HttpServletRequest request){
		request.setAttribute("sub_id", sub_id);
		return "question_delete";
	}
	
	@RequestMapping("/save")
	public String save(EngageSubjects engageSubjects){
		engageSubjects.setSub_id(UUIDHelper.getUUID());
		engageSubjectsServiceImpl.save(engageSubjects);
		return "question_register_success";
	}
	
	@RequestMapping("/update")
	public String update(EngageSubjects engageSubjects){
		engageSubjectsServiceImpl.update(engageSubjects);
		return "forward:/engageSubjects/getAll";
	}
	
	@RequestMapping("/find")
	public String find(String firstKindName, String keyWord, String start, String end, HttpServletRequest request){
		List<EngageSubjects> list = engageSubjectsServiceImpl.listEngageSubjects(firstKindName, keyWord, start, end);
		request.setAttribute("engageSubjectsFindList", list);
		return "question_query_list";
	}
	
	@RequestMapping("/remove")
	public String remove(String sub_id){
		engageSubjectsServiceImpl.delete(sub_id);
		return "forward:/engageSubjects/getAll";
	}
	
}