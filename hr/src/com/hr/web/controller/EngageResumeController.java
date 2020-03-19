package com.hr.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.pojo.EngageResume;
import com.hr.service.EngageResumeService;

@Controller
@RequestMapping("/engageResume")
public class EngageResumeController {
	@Autowired
	EngageResumeService engageResumeServiceImpl;
	
	@RequestMapping("/getAll")
	public String getAll(){
		engageResumeServiceImpl.listAll();
		return null;
	}
	
	@RequestMapping("/getByResIdFoeUpdate")
	public String getByResIdFoeUpdate(int res_id, HttpServletRequest request){
		EngageResume engageResume = engageResumeServiceImpl.getByResId(res_id);
		request.setAttribute("engageResumeForUpdate", engageResume);
		return "engage_resume_change";
	}
	
	@RequestMapping("/getByResIdForDelete")
	public String getByResIdForDelete(int res_id, HttpServletRequest request){
		EngageResume engageResume = engageResumeServiceImpl.getByResId(res_id);
		request.setAttribute("engageResumeForDelete", engageResume);
		return "engage_resume_update";
	}
	
	@RequestMapping("/save")
	public String save(EngageResume engageResume){
		engageResume.setRegist_time(new Date());
		engageResume.setTest_check_time(new Date());
		engageResume.setCheck_time(new Date());
		engageResume.setInterview_status((short) 0);
		engageResumeServiceImpl.save(engageResume);
		return "forward:configMajor/selectAllForEngage";
	}
	
	@RequestMapping("/update")
	public String update(EngageResume engageResume, HttpServletRequest request){
		engageResumeServiceImpl.update(engageResume);
		Short s = engageResume.getPass_check_status();
		System.out.println(s);
		return "forward:/configMajor/selectAllForEngage?choose=1";
	}
	
	@RequestMapping("/remove")
	public String remove(int res_id){
		engageResumeServiceImpl.remove(res_id);
		return null;
	}
	
	@RequestMapping("/find")
	public String find(String human_major_kind_id, String human_major_id, String keyWord, String start, String end, HttpServletRequest request){
		List<EngageResume> list = engageResumeServiceImpl.listFind(human_major_kind_id, human_major_id, keyWord, start, end);
		request.setAttribute("engageResumeFindList", list);
		return "engage_resume_query_list";
	}
	
	@RequestMapping("/findForEffective")
	public String findForEffective(String human_major_kind_id, String human_major_id, String keyWord, String start, String end, HttpServletRequest request){	
		List<EngageResume> list = engageResumeServiceImpl.listFindForEffective(human_major_kind_id, human_major_id, keyWord, start, end);
		request.setAttribute("engageResumeFindForEffectiveList", list);
		return "engage_resume_query_effective_list";
	}

//	@InitBinder
//	public void initBinder(ServletRequestDataBinder bin){
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    CustomDateEditor cust = new CustomDateEditor(sdf,true);
//	    bin.registerCustomEditor(Date.class,cust);
//	}
	
}
