package com.hr.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.MajorChange;
import com.hr.service.HumanFileService;
import com.hr.service.MajorChangeService;
import com.hr.service.SalaryStandardService;
import com.hr.web.controller.requestparamtype.HumanFileSomeValue;
import com.hr.web.controller.requestparamtype.SalaryStandardIdAndName;

@Controller
@RequestMapping("/majorChange")
public class MajorChangeController {
	@Autowired
	HumanFileService humanFileServiceImpl;
	@Autowired
	SalaryStandardService salaryStandardServiceImpl;
	@Autowired
	MajorChangeService majorChangeServiceImpl;
	
	//定义两个转换类
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(value="/toSelectNormalHumanFile")
	@ResponseBody
	public ModelAndView toSelectNormalHumanFile(){
		List<HumanFileSomeValue> list = 
				humanFileServiceImpl.queryNormalHumanFileSomeValue();
		JSONArray json = JSONArray.fromObject(list);
		ModelAndView mav =new ModelAndView();
		mav.setViewName("major_change_register");
		mav.addObject("humanFileList", json);
		return mav;
	}
	
	@RequestMapping(value="/toSelectSalaryStandard")
	@ResponseBody
	public List<SalaryStandardIdAndName> toSelectSalaryStandard(){
		List<SalaryStandardIdAndName> list = 
				salaryStandardServiceImpl.selectIdAndName();
		
		return list;
	}
	
	@RequestMapping(value="/toInsertAll")
	@ResponseBody
	public int insertAllMajorChange(@RequestParam String mch_file_number,
			@RequestParam String first_kind_id,@RequestParam String first_kind_name,
			@RequestParam String second_kind_id,@RequestParam String second_kind_name,
			@RequestParam String third_kind_id,@RequestParam String third_kind_name,
			@RequestParam String human_major_kind_id,@RequestParam String human_major_kind_name,
			@RequestParam String human_major_id,@RequestParam String human_major_name,
			@RequestParam String new_first_kind_id,@RequestParam String new_first_kind_name,
			@RequestParam String new_second_kind_id,@RequestParam String new_second_kind_name,
			@RequestParam String new_third_kind_id,@RequestParam String new_third_kind_name,
			@RequestParam String new_major_kind_id,@RequestParam String new_major_kind_name,
			@RequestParam String new_major_id,@RequestParam String new_major_name,
			@RequestParam String human_id,@RequestParam String human_name,
			@RequestParam String salary_standard_id,@RequestParam String salary_standard_name,
			@RequestParam String salary_sum,@RequestParam String new_salary_standard_id,
			@RequestParam String new_salary_standard_name,@RequestParam String new_salary_sum,
			@RequestParam String change_reason,@RequestParam String register,
			@RequestParam String time,@RequestParam String check_status,
			@RequestParam String huf_id){
		MajorChange mc = new MajorChange();
		mc.setMch_file_number(mch_file_number);
		mc.setFirst_kind_id(new_first_kind_id);
		mc.setFirst_kind_name(new_first_kind_name);
		mc.setSecond_kind_id(new_second_kind_id);
		mc.setSecond_kind_name(new_second_kind_name);
		mc.setThird_kind_id(new_third_kind_id);
		mc.setThird_kind_name(new_third_kind_name);
		mc.setMajor_kind_id(human_major_kind_id);
		mc.setMajor_kind_name(human_major_kind_name);
		mc.setMajor_id(human_major_id);
		mc.setMajor_name(human_major_name);
		mc.setNew_first_kind_id(new_first_kind_id);
		mc.setNew_first_kind_name(new_first_kind_name);
		mc.setNew_second_kind_id(new_second_kind_id);
		mc.setNew_second_kind_name(new_second_kind_name);
		mc.setNew_third_kind_id(new_third_kind_id);
		mc.setNew_third_kind_name(new_third_kind_name);
		mc.setNew_major_kind_name(new_major_kind_name);
		mc.setNew_major_kind_name(new_major_kind_name);
		mc.setNew_major_name(new_major_name);
		mc.setNew_major_name(new_major_name);
		mc.setHuman_name(human_name);
		mc.setHuman_name(human_name);
		mc.setSalary_standard_id(salary_standard_id);
		mc.setSalary_standard_name(salary_standard_name);
		mc.setSalary_sum(Double.valueOf(salary_sum));
		mc.setNew_salary_standard_id(new_salary_standard_id);
		mc.setNew_salary_standard_name(new_salary_standard_name);
		mc.setNew_salary_sum(Double.valueOf(new_salary_sum));
		mc.setChange_reason(change_reason);
		mc.setRegister(register);
		mc.setCheck_status(Short.valueOf(check_status));
		try {
			mc.setRegist_time(sdf.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b = majorChangeServiceImpl.addMajorChange(mc);
		
		//0为成功，1为职员档案状态更改失败，2为调动失败
		if(b==true){
			boolean b2 = humanFileServiceImpl.updateHumanFileStatus(huf_id,"9");
			if(b2==true){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 2;
		}
	}
	
}
