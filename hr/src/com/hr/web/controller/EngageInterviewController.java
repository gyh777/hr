package com.hr.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.pojo.EngageInterview;
import com.hr.pojo.EngageResume;
import com.hr.service.EngageInterviewService;
import com.hr.service.EngageResumeService;

@Controller
@RequestMapping("/engageInterview")
public class EngageInterviewController {
	@Autowired
	EngageInterviewService engageInterviewServiceImpl;
	@Autowired
	EngageResumeService engageResumeServiceImpl;
	
	@RequestMapping("/findForEffective")
	public String findForEffective(String human_major_kind_id, String human_major_id, String keyWord, String start, String end, HttpServletRequest request){
		List<EngageResume> list = engageResumeServiceImpl.listFindForEffective(human_major_kind_id, human_major_id, keyWord, start, end);
		request.setAttribute("engageResumeFindForEffectiveList", list);
		return "engage_interview_query_list";
	}
	
	@RequestMapping("getByResIdForInterview")
	public String getByResIdForInterview(int res_id, HttpServletRequest request){
		EngageResume engageResume = engageResumeServiceImpl.getByResId(res_id);
		request.setAttribute("getByResIdForInterview", engageResume);
		EngageInterview engageInterview = engageInterviewServiceImpl.getByResumeId(engageResume.getRes_id());
		if(engageInterview != null && engageInterview.getEin_id() != 0){
			request.setAttribute("engageInterview", engageInterview);
		}else{
			EngageInterview engageInterview2 = new EngageInterview();
			engageInterview2.setInterview_amount(1);
			engageInterview2.setRegiste_time(new Date());
			request.setAttribute("engageInterview", engageInterview2);
		}
		return "engage_interview_change";
	}
	
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<EngageInterview> list = engageInterviewServiceImpl.listAll();
		request.setAttribute("engageInterviewList", list);
		return "engage_interview_query_screen_list";
	}
	
	@RequestMapping("/getForResult")
	public String getForResult(HttpServletRequest request){
		List<EngageInterview> list = engageInterviewServiceImpl.listForResult();
		request.setAttribute("engageInterviewList", list);
		return "engage_interview_query_screen_list";
	}
	
	@RequestMapping("/getByEinId")
	public String get(int ein_id,HttpServletRequest request){
		EngageInterview engageInterview = engageInterviewServiceImpl.getByEinId(ein_id);
		request.setAttribute("engageInterview", engageInterview);
		EngageResume engageResume = engageResumeServiceImpl.getByResId(engageInterview.getResume_id());
		request.setAttribute("getByResIdForInterview", engageResume);
		return "engage_interview_screen_change";
	}
	
	@RequestMapping("/save")
	public String save(EngageInterview engageInterview, HttpServletRequest request){
		engageInterview.setRegiste_time(new Date());
		engageInterview.setCheck_time(new Date());
		engageInterview.setResult("0");
		engageInterviewServiceImpl.save(engageInterview);
		return "forward:/configMajor/selectAllForEngage?choose=3";
	}
	
	@RequestMapping("/update")
	public String update(EngageInterview engageInterview){
		engageInterviewServiceImpl.update(engageInterview);
		return "";
	}
	
	@RequestMapping("/updateForResult")
	public String updateForRecomandation(String result, String pass_checker, String pass_checkComment, int ein_id){
		EngageInterview engageInterview = engageInterviewServiceImpl.getByEinId(ein_id);
		engageInterview.setResult(result);
		int amount = engageInterview.getInterview_amount() + 1;
		engageInterview.setInterview_amount(amount);
		engageInterviewServiceImpl.update(engageInterview);
		
		EngageResume engageResume = engageResumeServiceImpl.getByResId(engageInterview.getResume_id());
		engageResume.setPass_checker(pass_checker);
		engageResume.setPass_checkComment(pass_checkComment);
		engageResumeServiceImpl.update(engageResume);
		return "forward:/engageInterview/getForResult";
	}
	
	@RequestMapping("/remove")
	public String remove(int ein_id){
		engageInterviewServiceImpl.remove(ein_id);
		return "";
	}
}
