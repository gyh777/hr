package com.hr.web.controller;

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
	public String getAll(){
		configQuestionFirstKindServiceImpl.listConfigQuestionFirstKind();
		return null;
	}
	
	@RequestMapping("/getByQfkId")
	public String getByQfkId(String qfkId){
		configQuestionFirstKindServiceImpl.getConfigQuestionFirstKind(qfkId);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(ConfigQuestionFirstKind configQuestionFirstKind){
		configQuestionFirstKindServiceImpl.save(configQuestionFirstKind);
		return null;
	}
	
	@RequestMapping("/update")
	public String update(ConfigQuestionFirstKind configQuestionFirstKind){
		configQuestionFirstKindServiceImpl.update(configQuestionFirstKind);
		return null;
	}
	
	@RequestMapping("/remove")
	public String remove(String qfkId){
		configQuestionFirstKindServiceImpl.remove(qfkId);
		return null;
	}

}
