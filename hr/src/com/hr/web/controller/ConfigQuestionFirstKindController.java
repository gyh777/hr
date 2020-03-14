package com.hr.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.ConfigQuestionFirstKind;
import com.hr.service.ConfigQuestionFirstKindService;

@Controller
@RequestMapping("/configQuestionFirstKind")
public class ConfigQuestionFirstKindController {
	@Autowired
	ConfigQuestionFirstKindService configQuestionFirstKindServiceImpl;
	
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<ConfigQuestionFirstKind> list = configQuestionFirstKindServiceImpl.listConfigQuestionFirstKind();
		request.setAttribute("configQuestionFirstKindList", list);
		return "jsp/question_first_kind";
	}
	
	@RequestMapping("/getByQfkIdForUpdate")
	public String getByQfkId(String qfkId, HttpServletRequest request){
		ConfigQuestionFirstKind configQuestionFirstKind = configQuestionFirstKindServiceImpl.getConfigQuestionFirstKind(qfkId);
		request.setAttribute("changeConfigQuestionFirstKind", configQuestionFirstKind);
		return "jsp/question_first_kind_change";
	}
	
	@RequestMapping("/save")
	public String save(ConfigQuestionFirstKind configQuestionFirstKind){
		configQuestionFirstKindServiceImpl.save(configQuestionFirstKind);
		return null;
	}
	
	@RequestMapping("/update")
	public String update(ConfigQuestionFirstKind configQuestionFirstKind) throws UnsupportedEncodingException{
//		有编码问题
//		System.out.println(configQuestionFirstKind.getQfk_id()+"==="+configQuestionFirstKind.getFirst_kind_name());
		configQuestionFirstKindServiceImpl.update(configQuestionFirstKind);
		return "forward:/configQuestionFirstKind/getAll";
	}
	
	@RequestMapping("/remove")
	public String remove(String qfkId){
		configQuestionFirstKindServiceImpl.remove(qfkId);
		return null;
	}

}
