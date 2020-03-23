package com.hr.web.controller;

import java.text.ParseException;
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

import com.hr.pojo.ConfigMajor;
import com.hr.pojo.ConfigMajorKind;
import com.hr.pojo.EngageResume;
import com.hr.pojo.HumanFile;
import com.hr.service.ConfigMajorKindService;
import com.hr.service.ConfigMajorService;
import com.hr.service.EngageResumeService;
import com.hr.service.HumanFileService;

@Controller
@RequestMapping("/engageResume")
public class EngageResumeController {
	@Autowired
	EngageResumeService engageResumeServiceImpl;
	@Autowired
	ConfigMajorService configMajorServiceImpl;
	@Autowired
	ConfigMajorKindService configMajorKindService;
	@Autowired
	HumanFileService humanFileServiceImpl;
	
	@RequestMapping("/getAll")
	public String getAll(){
		engageResumeServiceImpl.listAll();
		return null;
	}
	
	@RequestMapping("/getByResIdForUpdate")
	public String getByResIdFoeUpdate(int res_id, HttpServletRequest request){
		EngageResume engageResume = engageResumeServiceImpl.getByResId(res_id);
		request.setAttribute("engageResumeForUpdate", engageResume);
		
		List<ConfigMajorKind> list = configMajorKindService.selectAllConfigMajorKind();
		request.setAttribute("configMajorKindList", list);
		List<ConfigMajor> list2 = configMajorServiceImpl.selectAllConfigMajor();
		request.setAttribute("configMajorList", list2);
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
		ConfigMajor configMajor = configMajorServiceImpl.getByMajorName(engageResume.getHuman_major_name());
		if(configMajor != null){
			engageResume.setHuman_major_kind_id(configMajor.getMajor_kind_id());;
			engageResume.setHuman_major_kind_name(configMajor.getMajor_kind_name());
			engageResume.setHuman_major_id(configMajor.getMajor_id());
			engageResume.setHuman_major_name(configMajor.getMajor_name());	
		}
		
		engageResume.setRegist_time(new Date());
		engageResume.setCheck_time(new Date());
		engageResume.setTest_check_time(new Date());
		engageResume.setPass_regist_time(new Date());
		engageResume.setPass_check_time(new Date());
		
		engageResume.setRegister("register");
		engageResume.setInterview_status(0);
		engageResumeServiceImpl.save(engageResume);
		return "forward:/configMajor/selectAllForEngage";
	}
	
	@RequestMapping("/update")
	public String update(EngageResume engageResume, HttpServletRequest request){
		engageResume.setChecker("checker");
		engageResume.setCheck_time(new Date());
		
		engageResume.setTest_check_time(new Date());
		engageResume.setPass_regist_time(new Date());
		engageResume.setPass_check_time(new Date());
		
		ConfigMajor configMajor = configMajorServiceImpl.getByMajorName(engageResume.getHuman_major_name());
		engageResume.setHuman_major_kind_id(configMajor.getMajor_kind_id());
		engageResume.setHuman_major_kind_name(configMajor.getMajor_kind_name());
		engageResume.setHuman_major_id(configMajor.getMajor_id());
		engageResume.setHuman_major_name(configMajor.getMajor_name());
		
		int status = engageResume.getInterview_status();
		if(status == 0){
			engageResume.setInterview_status(1);
		}
		
		engageResumeServiceImpl.update(engageResume);
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
	
	@RequestMapping("/pass")
	public String pass(HttpServletRequest request){	
		List<EngageResume> list = engageResumeServiceImpl.listByInterview(6);
		request.setAttribute("engageResumeList", list);
		return "pass";
	}
	
	@RequestMapping("/passCheck")
	public String passCheck(HttpServletRequest request){	
		List<EngageResume> list = engageResumeServiceImpl.listByInterview(6);
		request.setAttribute("engageResumeList", list);
		return "passCheck";
	}
	
	@RequestMapping("/employment")
	public String employment(int res_id, HttpServletRequest request){
		EngageResume engageResume = engageResumeServiceImpl.getByResId(res_id);
		engageResume.setInterview_status(7);
		engageResume.setPass_checker("checker");
		engageResume.setPass_check_time(new Date());
		engageResumeServiceImpl.update(engageResume);
		
		//创建员工档案
		HumanFile humanFile = new HumanFile();
		humanFile.setHuman_id("");
		humanFile.setFirst_kind_id("");
		humanFile.setFirst_kind_name("");
		humanFile.setSecond_kind_id("");
		humanFile.setSecond_kind_name("");
		humanFile.setThird_kind_id("");
		humanFile.setThird_kind_name("");
		humanFile.setHuman_name(engageResume.getHuman_name());
		humanFile.setHuman_address(engageResume.getHuman_address());
		humanFile.setHuman_major_id(engageResume.getHuman_major_id());
		humanFile.setHuman_major_name(engageResume.getHuman_major_name());
		humanFile.setHuman_major_kind_id(engageResume.getHuman_major_kind_id());
		humanFile.setHuman_major_kind_name(engageResume.getHuman_major_kind_name());
		humanFile.setHuman_telephone(engageResume.getHuman_telephone());
		humanFile.setHuman_mobilephone(engageResume.getHuman_mobilephone());
		humanFile.setHuman_email(engageResume.getHuman_email());
		humanFile.setHuman_hobby(engageResume.getHuman_hobby());
		humanFile.setHuman_speciality(engageResume.getHuman_specility());
		humanFile.setHuman_sex(engageResume.getHuman_sex());
		humanFile.setHuman_race(engageResume.getHuman_race());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        try {
			Date date = simpleDateFormat.parse(engageResume.getHuman_birthday());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			humanFile.setHuman_birthday(sqlDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		humanFile.setHuman_birthplace(engageResume.getHuman_birthplace());
		Short x = Short.valueOf(String.valueOf(engageResume.getHuman_age()));
		humanFile.setHuman_age(x);
		humanFile.setHuman_educated_degree(engageResume.getHuman_educated_degree());
		Short y = Short.valueOf(String.valueOf(engageResume.getHuman_educated_years()));
		humanFile.setHuman_educated_years(y);
		humanFile.setHuman_educated_major(engageResume.getHuman_educated_major());
		humanFile.setHuman_id_card(engageResume.getHuman_idcard());
		
//		humanFileServiceImpl.addHumanFile(humanFile);
		
		return "forward:/engageResume/passCheck";
	}
	
	@RequestMapping("/passFind")
	public String passFind(HttpServletRequest request){
		List<EngageResume> list = engageResumeServiceImpl.listByInterview(7);
		request.setAttribute("engageResumeList", list);
		
		return "passFind";
	}

//	@InitBinder
//	public void initBinder(ServletRequestDataBinder bin){
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    CustomDateEditor cust = new CustomDateEditor(sdf,true);
//	    bin.registerCustomEditor(Date.class,cust);
//	}
	
}
