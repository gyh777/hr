package com.hr.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		engageResume.setRegist_time(new Date());
		engageResume.setTest_check_time(new Date());
		engageResume.setCheck_time(new Date());
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
	

	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor cust = new CustomDateEditor(sdf,true);
	    bin.registerCustomEditor(Date.class,cust);
	}
	
}
