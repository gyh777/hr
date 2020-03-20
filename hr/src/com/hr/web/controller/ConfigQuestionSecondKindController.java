package com.hr.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.ConfigQuestionFirstKind;
import com.hr.pojo.ConfigQuestionSecondKind;
import com.hr.pojo.EngageSubjects;
import com.hr.service.ConfigQuestionFirstKindService;
import com.hr.service.ConfigQuestionSecondKindService;
import com.hr.util.UUIDHelper;

@Controller
@RequestMapping("/configQuestionSecondKind")
public class ConfigQuestionSecondKindController {
	@Autowired
	ConfigQuestionSecondKindService configQuestionSecondKindServiceImpl;
	@Autowired
	ConfigQuestionFirstKindService configQuestionFirstKindServiceImpl;
	
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<ConfigQuestionSecondKind> list = configQuestionSecondKindServiceImpl.list();
		request.setAttribute("configQuestionSecondKindList", list);
		return "question_second_kind";
	}
	
	@RequestMapping("/getByQfkIdForUpdate")
	public String getByQfkId(String qskId, HttpServletRequest request){
		ConfigQuestionSecondKind configQuestionSecondKind = configQuestionSecondKindServiceImpl.getByQfkId(qskId);
		request.setAttribute("changeConfigQuestionSecondKind", configQuestionSecondKind);
		return "question_second_kind_change";
	}
	
	@RequestMapping("/getByQfkIdForRemove")
	public String getByQfkIdForRemove(String qskId, HttpServletRequest request){
		ConfigQuestionSecondKind configQuestionSecondKind = configQuestionSecondKindServiceImpl.getByQfkId(qskId);
		request.setAttribute("deleteConfigQuestionSecondKind", configQuestionSecondKind);
		return "question_second_kind_delete";
	}
	
	@RequestMapping("/save")
	public String save(ConfigQuestionSecondKind configQuestionSecondKind){
		configQuestionSecondKind.setQsk_id(UUIDHelper.getUUID());
		ConfigQuestionFirstKind configQuestionFirstKind = configQuestionFirstKindServiceImpl.getByFirstKindId(configQuestionSecondKind.getFirst_kind_id());
		configQuestionSecondKind.setFirst_kind_name(configQuestionFirstKind.getFirst_kind_name());
		configQuestionSecondKindServiceImpl.save(configQuestionSecondKind);
		return "question_second_kind_rigister_success";
	}
	
	@RequestMapping("/update")
	public String update(ConfigQuestionSecondKind configQuestionSecondKind) throws UnsupportedEncodingException{
		//有编码问题
		configQuestionSecondKindServiceImpl.update(configQuestionSecondKind);
		return "forward:/configQuestionSecondKind/getAll";
	}
	
	@RequestMapping("/remove")
	public String remove(String qskId){
		configQuestionSecondKindServiceImpl.remove(qskId);
		return "forward:/configQuestionSecondKind/getAll";
	}
	
	@RequestMapping("/getAllForQuestionQuery")
	public String getAllForQuestionQuery(HttpServletRequest request){
		List<ConfigQuestionSecondKind> list = configQuestionSecondKindServiceImpl.list();
		request.setAttribute("configQuestionSecondKindList", list);
		return "question_query_locate";
	}
	
	@RequestMapping("/getAllForQuestion")
	public String getAllForQuestion(HttpServletRequest request){
		List<ConfigQuestionSecondKind> list = configQuestionSecondKindServiceImpl.list();
		request.setAttribute("configQuestionSecondKindList", list);
		return "forward:/engageSubjects/getAll";
	}
	
}
