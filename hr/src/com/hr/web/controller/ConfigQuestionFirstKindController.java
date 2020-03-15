package com.hr.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.ConfigQuestionFirstKind;
import com.hr.service.ConfigQuestionFirstKindService;
import com.hr.util.UUIDHelper;

@Controller
@RequestMapping("/configQuestionFirstKind")
public class ConfigQuestionFirstKindController {
	@Autowired
	ConfigQuestionFirstKindService configQuestionFirstKindServiceImpl;
	
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<ConfigQuestionFirstKind> list = configQuestionFirstKindServiceImpl.listConfigQuestionFirstKind();
		request.setAttribute("configQuestionFirstKindList", list);
		return "question_first_kind";
	}
	
	@RequestMapping("/getAllForTwo")
	public String getAllForTwo(HttpServletRequest request){
		List<ConfigQuestionFirstKind> list = configQuestionFirstKindServiceImpl.listConfigQuestionFirstKind();
		request.setAttribute("configQuestionFirstKindList", list);
		return "question_second_kind_rigister";
	}
	
	@RequestMapping("/getByQfkIdForUpdate")
	public String getByQfkId(String qfkId, HttpServletRequest request){
		ConfigQuestionFirstKind configQuestionFirstKind = configQuestionFirstKindServiceImpl.getConfigQuestionFirstKind(qfkId);
		request.setAttribute("changeConfigQuestionFirstKind", configQuestionFirstKind);
		return "question_first_kind_change";
	}
	
	@RequestMapping("/getByQfkIdForRemove")
	public String getByQfkIdForRemove(String qfkId, HttpServletRequest request){
		ConfigQuestionFirstKind configQuestionFirstKind = configQuestionFirstKindServiceImpl.getConfigQuestionFirstKind(qfkId);
		request.setAttribute("deleteConfigQuestionFirstKind", configQuestionFirstKind);
		return "question_first_kind_delete";
	}
	
	@RequestMapping("/save")
	public String save(ConfigQuestionFirstKind configQuestionFirstKind){
		configQuestionFirstKind.setQfk_id(UUIDHelper.getUUID());
		configQuestionFirstKindServiceImpl.save(configQuestionFirstKind);
		return "question_first_kind_rigister_success";
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
		return "forward:/configQuestionFirstKind/getAll";
	}

}
