package com.hr.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.dto.AnswerDetailsDto;
import com.hr.dto.EngageAnswerDetailsDto;
import com.hr.pojo.EngageAnswer;
import com.hr.pojo.EngageAnswerDetails;
import com.hr.pojo.EngageResume;
import com.hr.pojo.EngageSubjects;
import com.hr.service.EngageAnswerDetailsService;
import com.hr.service.EngageAnswerService;
import com.hr.service.EngageResumeService;
import com.hr.util.ExamNumberHelper;

@Controller
@RequestMapping("/engageAnswer")
public class EngageAnswerController {
	@Autowired
	EngageAnswerService engageAnswerServiceImpl;
	@Autowired
	EngageAnswerDetailsService engageAnswerDetailsServiceImpl;
	@Autowired
	EngageResumeService engageResumeServiceImpl;
	
	//考试完成后调用
	@RequestMapping("/save")
	public String save(EngageAnswer engageAnswer, EngageAnswerDetailsDto map, HttpSession session){
		//答案编号
		String number = ExamNumberHelper.getExamNumber();
		engageAnswer.setAnswer_number(number);
		engageAnswer.setTest_time(new Date());
		Map<Integer, EngageSubjects> question = (Map<Integer, EngageSubjects>) session.getAttribute("question");
		if(question != null){
			//统分
			double total = 0d;
			List<EngageAnswerDetails> list = map.getMap();
			for (int i = 0; i < question.size(); i++) {
				EngageSubjects engageSubjects = question.get(i+1);
				EngageAnswerDetails engageAnswerDetails = list.get(i);
				engageAnswerDetails.setAnswer_number(number);
				engageAnswerDetails.setSubject_id(engageSubjects.getSub_id());
				if(engageSubjects.getCorrect_key().equalsIgnoreCase(engageAnswerDetails.getAnswer())){
					total += 10;
				}
				engageAnswerDetailsServiceImpl.save(engageAnswerDetails);
			}
			engageAnswer.setTotal_point(total);
			engageAnswerServiceImpl.save(engageAnswer);
			
			//更改简历表
			EngageResume engageResume = engageResumeServiceImpl.getByResId(engageAnswer.getResume_id());
			engageResume.setInterview_status(5);
			int amount = engageResume.getTest_amount() + 1;
			engageResume.setTest_amount(amount);
			double total_points = 0.0;
			if(engageResume.getTotal_points() == null){
				total_points = total;
			}else{
				total_points = total + engageResume.getTotal_points();
			}
			engageResume.setTotal_points(total_points/amount);
			engageResumeServiceImpl.update(engageResume);
			
			return "question_test_answer_success";
		}else{
			session.setAttribute("msg", "考试出错，请重新考试！");
		}
		return "error";
	}
	
	//成绩查询筛选
	@RequestMapping("/find")
	public String find(String human_idcard, String keyWord, String start, String end, HttpServletRequest request){
		List<EngageAnswer> list = engageAnswerServiceImpl.find(human_idcard, keyWord, start, end);
		request.setAttribute("EngageAnswerList", list);
		return "question_test_result_list";
	}
	
	@RequestMapping("getByAnsId")
	public String getByAnsId(int ans_id, HttpServletRequest request){
		EngageAnswer engageAnswer = engageAnswerServiceImpl.getByAnsId(ans_id);
		request.setAttribute("engageAnswer", engageAnswer);
		
		List<AnswerDetailsDto> list = engageAnswerDetailsServiceImpl.listByAnswerNumberMap(engageAnswer.getAnswer_number());
		request.setAttribute("answerDetailsDtoList", list);
		
		return "question_test_result";
	}
	
	@RequestMapping("getByAnsIdForCheck")
	public String getByAnsIdForCheck(int ans_id, HttpServletRequest request){
		EngageAnswer engageAnswer = engageAnswerServiceImpl.getByAnsId(ans_id);
		
		EngageResume engageResume = engageResumeServiceImpl.getByResId(engageAnswer.getResume_id());
		request.setAttribute("engageResume", engageResume);
		
		return "question_test_check";
	}
	
	//成绩查询筛选审核
	@RequestMapping("updateForTestCheck")
	public String updateForTestCheck(int res_id, String test_checker, String pass_checkComment,String status, HttpServletRequest request){
		EngageResume engageResume = engageResumeServiceImpl.getByResId(res_id);
		engageResume.setTest_checker(test_checker);
		engageResume.setTest_check_time(new Date());
		engageResume.setPass_checkComment(pass_checkComment);
		
		//建议面试处理
		if("1".equals(status)){
			engageResume.setInterview_status(2);
		}
		//建议笔试
		if("2".equals(status)){
			engageResume.setInterview_status(4);
		}
		//建议录用
		if("3".equals(status)){
			engageResume.setInterview_status(6);
		}
		//删除简历
		if("4".equals(status)){
			engageResume.setInterview_status(3);
		}
		if(engageResumeServiceImpl.update(engageResume)){
			return "question_test_result_locate";
		}else{
			request.setAttribute("msg", "筛选出现错误！");
			return "error";
		}
	}
	
}
