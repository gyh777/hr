package com.hr.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.dto.ConfigQuestionDto;
import com.hr.dto.EngageExamDetailsDto;
import com.hr.dto.EngageExamDto;
import com.hr.pojo.ConfigMajor;
import com.hr.pojo.ConfigQuestionSecondKind;
import com.hr.pojo.EngageExam;
import com.hr.pojo.EngageExamDetails;
import com.hr.service.ConfigMajorService;
import com.hr.service.ConfigQuestionSecondKindService;
import com.hr.service.EngageExamDetailsService;
import com.hr.service.EngageExamService;
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
}