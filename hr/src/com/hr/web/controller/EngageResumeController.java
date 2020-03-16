package com.hr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.EngageResume;
import com.hr.service.EngageResumeService;

@Controller
@RequestMapping("engageResume")
public class EngageResumeController {
	@Autowired
	EngageResumeService engageResumeServiceImpl;
	
	@RequestMapping("getAll")
	public String getAll(){
		engageResumeServiceImpl.listAll();
		return null;
	}
	
	@RequestMapping("getResId")
	public String getResId(int res_id){
		engageResumeServiceImpl.getByResId(res_id);
		return null;
	}
	
	@RequestMapping("save")
	public String save(EngageResume engageResume){
		engageResumeServiceImpl.save(engageResume);
		return null;
	}
	
	@RequestMapping("update")
	public String update(EngageResume engageResume){
		engageResumeServiceImpl.update(engageResume);
		return null;
	}
	
	@RequestMapping("remove")
	public String remove(int res_id){
		engageResumeServiceImpl.remove(res_id);
		return null;
	}
}
