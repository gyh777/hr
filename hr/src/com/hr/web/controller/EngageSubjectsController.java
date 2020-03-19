package com.hr.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.ConfigQuestionSecondKind;
import com.hr.pojo.EngageSubjects;
import com.hr.service.ConfigQuestionSecondKindService;
import com.hr.service.EngageSubjectsService;
import com.hr.service.impl.ConfigQuestionSecondKindServiceImpl;
import com.hr.util.UUIDHelper;


@Controller
@RequestMapping("/engageSubjects")
public class EngageSubjectsController {
	@Autowired
	EngageSubjectsService engageSubjectsServiceImpl;
	@Autowired
	ConfigQuestionSecondKindService configQuestionSecondKindServiceImpl;
	
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
	public String save(String qfkId, EngageSubjects engageSubjects){
		ConfigQuestionSecondKind c = configQuestionSecondKindServiceImpl.getByQfkId(qfkId);
		if(c == null){
			engageSubjects.setFirst_kind_id(c.getFirst_kind_id());
			engageSubjects.setFirst_kind_name(c.getFirst_kind_name());
			engageSubjects.setSecond_kind_id(c.getSecond_kind_id());
			engageSubjects.setSecond_kind_name(c.getSecond_kind_name());
		}
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