package com.hr.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.dto.ConfigQuestionDto;
import com.hr.dto.EngageExamDetailsDto;
import com.hr.dto.EngageExamDto;
import com.hr.pojo.ConfigMajor;
import com.hr.pojo.ConfigMajorKind;
import com.hr.pojo.ConfigQuestionSecondKind;
import com.hr.pojo.EngageExam;
import com.hr.pojo.EngageExamDetails;
import com.hr.pojo.EngageInterview;
import com.hr.pojo.EngageResume;
import com.hr.pojo.EngageSubjects;
import com.hr.service.ConfigMajorKindService;
import com.hr.service.ConfigMajorService;
import com.hr.service.ConfigQuestionSecondKindService;
import com.hr.service.EngageExamDetailsService;
import com.hr.service.EngageExamService;
import com.hr.service.EngageInterviewService;
import com.hr.service.EngageResumeService;
import com.hr.service.EngageSubjectsService;
import com.hr.util.ExamNumberHelper;

@Controller
@RequestMapping("/engageExam")
public class EngageExamController {
	@Autowired
	EngageExamService engageExamServiceImpl;
	@Autowired
	ConfigMajorService configMajorServiceImpl;
	@Autowired
	ConfigQuestionSecondKindService configQuestionSecondKindServiceImpl;
	@Autowired
	EngageSubjectsService engageSubjectsServiceImpl;
	@Autowired
	EngageExamDetailsService engageExamDetailsServiceImpl;
	@Autowired
	EngageResumeService engageResumeServiceImpl;
	@Autowired
	EngageInterviewService engageInterviewServiceImpl;
	@Autowired
	ConfigMajorKindService configMajorKindServiceImpl;
	
	@RequestMapping("/selectAllForQuestionTest")
	public String configMajorServiceImpl(HttpServletRequest request){
		List<ConfigMajor> list = configMajorServiceImpl.selectAllConfigMajor();
		List<EngageExamDto> resList = new ArrayList<>();
		for (ConfigMajor configMajor : list) {
			EngageExamDto engageExamDto = new EngageExamDto();
			engageExamDto.setConfigMajor(configMajor);
			int count = engageExamServiceImpl.getCount(configMajor.getMajor_kind_id(), configMajor.getMajor_id());
			engageExamDto.setCount(count);
			resList.add(engageExamDto);
		}
		
		request.setAttribute("engageExamDtoList", resList);
		
		return "question_test_list";
	}
	
	@RequestMapping("/createExam")
	public String createExam(HttpServletRequest request){
		String major_name = null;
		try {
			major_name = new String(request.getParameter("major_name").getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ConfigMajor configMajor = configMajorServiceImpl.getByMajorName(major_name);
		List<ConfigQuestionSecondKind> list = configQuestionSecondKindServiceImpl.list();
		List<ConfigQuestionDto> resList = new ArrayList<>();
		for (ConfigQuestionSecondKind c : list) {
			ConfigQuestionDto configQuestionDto = new ConfigQuestionDto();
			int count = engageSubjectsServiceImpl.getCount(c.getFirst_kind_id(), c.getSecond_kind_id());
			configQuestionDto.setConfigQuestionSecondKind(c);
			configQuestionDto.setCount(count);
			resList.add(configQuestionDto);
		}
		request.setAttribute("configMajor", configMajor);
		request.setAttribute("resList", resList);
		return "question_test_register";
	}
	
	@RequestMapping("/save")
	public String save(EngageExam engageExam, EngageExamDetailsDto engageExamDetailsDto, HttpServletRequest request){
		String  exam_number = ExamNumberHelper.getExamNumber();
		engageExam.setExam_number(exam_number);
		engageExam.setRegist_time(new Date());
		engageExamServiceImpl.save(engageExam);
		
		//答题详细表
		for (EngageExamDetails engageExamDetails : engageExamDetailsDto.getList()) {
			engageExamDetails.setExam_number(exam_number);
			engageExam.setLimite_time(engageExam.getLimite_time());
			engageExamDetailsServiceImpl.save(engageExamDetails);
		}
		
		//[${s.index}]
		//跳答题页面
		return "forward:/engageExam/selectAllForQuestionTest";
	}
	
	//left.jsp考试答题点入后到此方法
	@RequestMapping("/answerQuestion")
	public String answerQuestion(HttpServletRequest request){
		List<ConfigMajorKind> configMajorKindList = configMajorKindServiceImpl.selectAllConfigMajorKind();
		request.setAttribute("ConfigMajorKindList", configMajorKindList);
		
		List<ConfigMajor> list = configMajorServiceImpl.selectAllConfigMajor();
		request.setAttribute("configMajorList", list);
		return "question_test_locate";
	}
	
	//创建套卷
	@RequestMapping("/find")
	public String find(String human_major_kind_id, String human_major_id, String human_name, String human_idcard, HttpServletRequest request){
		List<EngageResume> list = engageResumeServiceImpl.listForQuestion(human_major_kind_id, human_major_id,
				human_name, human_idcard);
		Random r = new Random();
		if(list != null && list.size() == 1 && list.get(0) != null && list.get(0).getRes_id() > 0){
			Map<Integer, EngageSubjects> result = new HashMap<>();
			int flag = 1;
			//简历
			EngageResume engageResume = list.get(0);
			request.setAttribute("engageResume", engageResume);
			//面试结果
			EngageInterview engageInterview = engageInterviewServiceImpl.getByResumeId(engageResume.getRes_id());
			request.setAttribute("engageInterview", engageInterview);
			//拿到所有套卷
			List<EngageExam>  engageExamList = engageExamServiceImpl.listByMajorId(engageResume.getHuman_major_kind_id(), engageResume.getHuman_major_id());
			System.out.println(engageExamList.size());
			if(engageExamList != null && engageExamList.size() > 0){
				int number = r.nextInt(engageExamList.size());
				//随机获取一套套卷
				EngageExam engageExam = engageExamList.get(number);
				request.setAttribute("engageExam", engageExam);
				//获取本套卷每种类型考题数目
				List<EngageExamDetails> engageExamDetailsList = engageExamDetailsServiceImpl.listByExamNumber(engageExam.getExam_number());
				//获取题目
				for (EngageExamDetails e : engageExamDetailsList) {
					//查询所有该类别题目
					List<EngageSubjects> engageSubjectsList =  engageSubjectsServiceImpl.listByKindId(e.getFirst_kind_id(), e.getSecond_kind_id());
					//使用for循环随机获取题目并放入HashMap中
					for (int i = 0; i < e.getQuestion_amount(); i++) {
						if(engageSubjectsList.size() > 0){
							int n = r.nextInt(engageSubjectsList.size());
							result.put(flag, engageSubjectsList.get(n));
							engageSubjectsList.remove(n);
						}
					}
				}
				request.getSession().setAttribute("question", result);
				
				return "question_test_answer";
			}
		}
		return "forward:/engageExam/answerQuestion";
	}
}