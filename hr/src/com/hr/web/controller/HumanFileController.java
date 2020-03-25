package com.hr.web.controller;  

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hr.pojo.ConfigFileFirstKind;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.pojo.HumanFile;
import com.hr.pojo.HumanFileDig;
import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.ConfigFileThirdKindService;
import com.hr.service.ConfigMajorKindService;
import com.hr.service.ConfigMajorService;
import com.hr.service.HumanFileDigService;
import com.hr.service.HumanFileService;
import com.hr.service.SalaryStandardService;
import com.hr.web.controller.requestparamtype.TwoStringValue;

@Controller
@RequestMapping("/humanfile")
public class HumanFileController {
	@Autowired
    HumanFileService humanFileServiceImpl;
	
	@Autowired
    HumanFileDigService humanFileDigServiceImpl;
	
	@Autowired
	ConfigFileFirstKindService configFileFirstKindServiceImpl;
	
	@Autowired
	ConfigFileSecondKindService configFileSecondKindServiceImpl;
	
	@Autowired
	ConfigFileThirdKindService configFileThirdKindServiceImpl;
	
	@Autowired
	ConfigMajorKindService configMajorKindServiceImpl;
	
	@Autowired
	ConfigMajorService configMajorServicesImpl;
	
	@Autowired
	SalaryStandardService salaryStandardServiceImpl;
	
	
	@RequestMapping("/humanRigister")
	public ModelAndView addHumanRigister(@RequestParam String firstKindName,@RequestParam String secondKindName,@RequestParam String thirdKindName,@RequestParam String humanMajorKindName,@RequestParam String humanMajorName
			,@RequestParam String humanProDesignation,@RequestParam String humanName,@RequestParam String humanSex,@RequestParam String humanEmail,@RequestParam String humanTelephone,@RequestParam String humanQq,@RequestParam String humanMobilephone,@RequestParam String humanAddress,
			@RequestParam String humanPostcode,@RequestParam String humanNationality,@RequestParam String humanBirthplace,@RequestParam String str_humanBirthday,@RequestParam String humanRace,@RequestParam String humanReligion,@RequestParam String humanParty,
			@RequestParam String humanIdCard,@RequestParam String humanSocietySecurityId,@RequestParam String humanAge,@RequestParam String humanEducatedDegree,@RequestParam String humanEducatedYears,@RequestParam String humanEducatedMajor,@RequestParam String salaryStandardName,@RequestParam String humanBank,
			@RequestParam String humanAccount,@RequestParam String register,@RequestParam String remark,@RequestParam String str_registTime,@RequestParam String humanSpeciality,@RequestParam String humanHobby,@RequestParam String humanHistroyRecords,@RequestParam String humanFamilyMembership){
	    HumanFile hf = new HumanFile();
	    //获得一级机构
	    String[] first = splitStr(firstKindName);
	    hf.setFirst_kind_id(first[0]);
	    hf.setFirst_kind_name(first[1]);
	    //获得二级机构
	    String[] second = splitStr(secondKindName);
	    hf.setSecond_kind_id(second[0]);
	    hf.setSecond_kind_name(second[3]);
	    //获得三级机构
	    String[] third = splitStr(thirdKindName);
	    hf.setThird_kind_id(third[0]);
	    hf.setThird_kind_name(third[1]);
	    
	    //获得职位分类 humanMajorKindName
	    String[] majorKind = splitStr(humanMajorKindName);
	    hf.setHuman_major_kind_id(majorKind[0]);
	    hf.setHuman_major_kind_name(majorKind[1]);
	    
	    //获得职位名称  hunmaMajorName
	    String[] major = splitStr(humanMajorName);
	    hf.setHuman_major_id(major[0]);
	    hf.setHuman_major_name(major[1]);
	    
	    //获得标准薪酬  salaryStandardName
	    String[] salary = splitStr(salaryStandardName);
	    hf.setSalary_standard_id(salary[0]);
	    hf.setSalary_standard_name(salary[1]);
	    
	   
	    hf.setHuman_pro_designation(humanProDesignation);
	    hf.setHuman_name(humanName);
	    hf.setHuman_sex("男");
	    hf.setHuman_email(humanEmail);
	    hf.setHuman_telephone(humanTelephone);
	    hf.setHuman_qq(humanQq);
	    hf.setHuman_mobilephone(humanMobilephone);
	    hf.setHuman_address(humanAddress);
	    hf.setHuman_postcode(humanPostcode);
	    hf.setHuman_nationality(humanNationality);
	    hf.setHuman_birthplace(humanBirthplace);
	    Date date;
	    Date regist_time;
		try {
			regist_time = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str_registTime).getTime());
			date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str_humanBirthday).getTime());
			hf.setHuman_birthday(date);
			hf.setRegist_time(regist_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		hf.setHuman_race(humanRace);
		hf.setHuman_religion("佛教");
		hf.setHuman_party(humanParty);
		hf.setHuman_id_card(humanIdCard);
		int h_age = Integer.parseInt(humanAge);
		Short age = (short) h_age;
		hf.setHuman_age(age);
		hf.setHuman_educated_degree("本科");
		int h_year = Integer.parseInt(humanEducatedYears);
		hf.setHuman_educated_years((short) 20);
		hf.setHuman_educated_major("软件工程");
		hf.setHuman_bank(humanBank);
		hf.setHuman_account(humanAccount);
		hf.setRegister(register);
		hf.setRemark(remark);
		hf.setHuman_speciality("游泳");
		hf.setHuman_hobby("登山");
		hf.setHuman_history_records(humanHistroyRecords);
		hf.setHuman_family_membership(humanFamilyMembership);
		Byte human_file_status = 0;
		hf.setHuman_file_status(human_file_status);
		hf.setCheck_status((short) 0);
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("human_registing");
	    humanFileServiceImpl.addHumanFile(hf);
	    return mav;
	}
	
	public String[] splitStr(String str){
		String[] strs = str.split("/");
		return strs;
	}
	
	@RequestMapping("checkList")
	public ModelAndView checkRigister(){
		List<HumanFile> humans = humanFileServiceImpl.queryFileByCheckstatus((short) 0);
		ModelAndView mav = new ModelAndView();
		mav.addObject("humans", humans);
	    mav.setViewName("check_list");
	    return mav;
	}
	

	
	
	
	@RequestMapping("checkHuman")
	public ModelAndView checkHuman(@RequestParam String huf_id){
		int hufid = Integer.parseInt(huf_id);
		HumanFile human = humanFileServiceImpl.queryHumanFileByHuf_id(hufid);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("human", human);
	    mav.setViewName("human_check");
	    return mav;
	}
	
	@RequestMapping("checkagree")
	public ModelAndView checkAgree(@RequestParam String firstKindName,@RequestParam String secondKindName,@RequestParam String thirdKindName,@RequestParam String humanMajorKindName,@RequestParam String humanMajorName
			,@RequestParam String humanProDesignation,@RequestParam String humanName,@RequestParam String humanSex,@RequestParam String humanEmail,@RequestParam String humanTelephone,@RequestParam String humanQq,@RequestParam String humanMobilephone,@RequestParam String humanAddress,
			@RequestParam String humanPostcode,@RequestParam String humanNationality,@RequestParam String humanBirthplace,@RequestParam String str_humanBirthday,@RequestParam String humanRace,@RequestParam String humanReligion,@RequestParam String humanParty,
			@RequestParam String humanIdCard,@RequestParam String humanSocietySecurityId,@RequestParam String humanAge,@RequestParam String humanEducatedDegree,@RequestParam String humanEducatedYears,@RequestParam String humanEducatedMajor,@RequestParam String salaryStandardName,@RequestParam String humanBank,
			@RequestParam String humanAccount,@RequestParam String remark,@RequestParam String humanSpeciality,@RequestParam String humanHobby,@RequestParam String humanHistroyRecords,@RequestParam String humanFamilyMembership,@RequestParam String checker){
		
		    HumanFileDig hf = new HumanFileDig();
		    HumanFile human = humanFileServiceImpl.queryHumanFileByName(humanName);
		    //获得一级机构
		    hf.setFirst_kind_id(configFileFirstKindServiceImpl.queryIdByName(firstKindName));
		    hf.setFirst_kind_name(firstKindName);
		    //获得二级机构
		    hf.setSecond_kind_id(configFileSecondKindServiceImpl.queryIdByName(secondKindName));
		    hf.setSecond_kind_name(secondKindName);
		    //获得三级机构
		    hf.setThird_kind_id(configFileThirdKindServiceImpl.queryIdByName(thirdKindName));
		    hf.setThird_kind_name(thirdKindName);
		    
		    //获得职位分类 humanMajorKindName
		    hf.setHuman_major_kind_id(configMajorKindServiceImpl.selectConfigMajorKindIdByName(humanMajorKindName));
		    hf.setHuman_major_kind_name(humanMajorKindName);
		    
		    //获得职位名称  hunmaMajorName
		    hf.setHuman_major_id(configMajorServicesImpl.selectConfigMajorIdByName(humanMajorName));
		    hf.setHuman_major_name(humanMajorName);
		    
		    //获得标准薪酬  salaryStandardName
		    hf.setSalary_standard_id(salaryStandardServiceImpl.queryIdByName(salaryStandardName));
		    hf.setSalary_standard_name(salaryStandardName);
		    
		   
		    hf.setHuman_pro_designation(humanProDesignation);
		    hf.setHuman_name(humanName);
		    hf.setHuman_sex(humanSex);
		    hf.setHuman_email(humanEmail);
		    hf.setHuman_telephone(humanTelephone);
		    hf.setHuman_qq(humanQq);
		    hf.setHuman_mobilephone(humanMobilephone);
		    hf.setHuman_address(humanAddress);
		    hf.setHuman_postcode(humanPostcode);
		    hf.setHuman_nationality(humanNationality);
		    hf.setHuman_birthplace(humanBirthplace);
		    Date date;
			try {
				date =new Date( new SimpleDateFormat("yyyy-MM-dd").parse("2000-06-03").getTime());
				hf.setHuman_birthday(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			hf.setHuman_race(humanRace);
			hf.setHuman_religion(humanReligion);
			hf.setHuman_party(humanParty);
			hf.setHuman_id_card(humanIdCard);
			int h_age = Integer.parseInt(humanAge);
			Short age = (short) h_age;
			hf.setHuman_age(age);
			hf.setHuman_educated_degree(humanEducatedDegree);
			int h_year = Integer.parseInt(humanEducatedYears);
			Short year = (short) h_year;
			hf.setHuman_educated_years(year);
			hf.setHuman_educated_major(humanEducatedMajor);
			hf.setHuman_bank(humanBank);
			hf.setHuman_account(humanAccount);
			hf.setRemark(remark);
			hf.setHuman_speciality(humanSpeciality);
			hf.setHuman_hobby(humanHobby);
			hf.setHuman_history_records(humanHistroyRecords);
			hf.setHuman_family_membership(humanFamilyMembership);
			hf.setDemand_salary_sum(2000.00);
			hf.setFile_chang_amount(human.getFile_chang_amount());
			hf.setBonus_amount(human.getBonus_amount());
			hf.setSalary_sum(human.getSalary_sum());
			hf.setPaid_salary_sum(human.getPaid_salary_sum());
			hf.setTraining_amount(human.getTraining_amount());
			hf.setAttachment_name(human.getAttachment_name());
			Date time = new Date(new java.util.Date().getTime());
			hf.setChange_time(time);
			hf.setCheck_time(time);
			hf.setCheck_status((short)1);
		
			hf.setChecker(checker);
			hf.setChanger(checker);
			hf.setRegist_time(human.getRegist_time());
			hf.setRegister(human.getRegister());
			humanFileDigServiceImpl.addHumanFileDig(hf);
			HumanFile huf  = new HumanFile();
			huf.setHuman_name(humanName);
			huf.setCheck_status((short) 1);
			humanFileServiceImpl.updateStatus(huf);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("human_check_success");
		return mav;
	}
	
	@RequestMapping("locatePage")
	public ModelAndView selectByLocatePage(@RequestParam String firstKindName,@RequestParam String secondKindName,@RequestParam String thirdKindName,
			@RequestParam String humanMajorKindName,@RequestParam String humanMajorName,@RequestParam String str_startTime,@RequestParam String str_endTime){
		HashMap<String, String> map = new HashMap<String, String>();
		String[] str = splitStr(secondKindName);
	
		map.put("firstKindName", firstKindName);
		map.put("secondKindName", str[1]);
		map.put("thirdKindName", thirdKindName);
		map.put("humanMajorName", humanMajorName);
		map.put("humanMajorKindName",humanMajorKindName);
		map.put("str_startTime",str_startTime);
		map.put("str_endTime",str_endTime);
		ModelAndView mav = new ModelAndView();
		List<HumanFile> human = humanFileServiceImpl.queryByMapCondition(map);
		mav.addObject("human", human);
		mav.setViewName("query_list");
		return mav;
	}
	
	@RequestMapping("keywordsPage")
	public ModelAndView selectByKeywordsPage(@RequestParam String keywords){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keywords", keywords);
        List<HumanFile> human =  humanFileServiceImpl.queryByKeyCondition(map);
        System.out.println(human.size());
        ModelAndView mav = new ModelAndView();
        mav.addObject("human", human);
        mav.setViewName("query_list");
        return mav;
	}
	
	@RequestMapping("deletelist")
	public ModelAndView deleteList(){
		List<HumanFile> humans = humanFileServiceImpl.queryAllHumanFile();
		ModelAndView mav = new ModelAndView();
		mav.addObject("humans", humans);
	    mav.setViewName("delete_locate");
	    return mav;
	}
	
	@RequestMapping("deleteHuman")
	public ModelAndView deleteHuman(@RequestParam String huf_id){
		HumanFile hf = new HumanFile();
		int id = Integer.parseInt(huf_id);
		hf.setHuf_id((short) id);
		hf.setHuman_file_status((byte) 1);
		humanFileServiceImpl.updateHumanFile(hf);
		HumanFileDig hfd = new HumanFileDig();
	    //获得一级机构
	    hfd.setFirst_kind_id(hf.getFirst_kind_id());
	    hfd.setFirst_kind_name(hf.getFirst_kind_name());
	    //获得二级机构
	    hfd.setSecond_kind_id(hf.getSecond_kind_id());
	    hfd.setSecond_kind_name(hf.getSecond_kind_name());
	    //获得三级机构
	    hfd.setThird_kind_id(hf.getThird_kind_id());
	    hfd.setThird_kind_name(hf.getThird_kind_name());
	    
	    //获得职位分类 humanMajorKindName
	    hfd.setHuman_major_kind_id(hf.getHuman_major_kind_id());
	    hfd.setHuman_major_kind_name(hf.getHuman_major_kind_name());
	    
	    //获得职位名称  hunmaMajorName
	    hfd.setHuman_major_id(hf.getHuman_major_id());
	    hfd.setHuman_major_name(hf.getHuman_major_name());
	    
	    //获得标准薪酬  salaryStandardName
	    hfd.setSalary_standard_id(hf.getSalary_standard_id());
	    hfd.setSalary_standard_name(hf.getSalary_standard_name());
	    
	   hfd.setHuman_birthday(hf.getHuman_birthday());
	    hfd.setHuman_pro_designation(hf.getHuman_pro_designation());
	    hfd.setHuman_name(hf.getHuman_name());
	    hfd.setHuman_sex(hf.getHuman_sex());
	    hfd.setHuman_email(hf.getHuman_email());
	    hfd.setHuman_telephone(hf.getHuman_telephone());
	    hfd.setHuman_qq(hf.getHuman_qq());
	    hfd.setHuman_mobilephone(hf.getHuman_mobilephone());
	    hfd.setHuman_address(hf.getHuman_address());
	    hfd.setHuman_postcode(hf.getHuman_postcode());
	    hfd.setHuman_nationality(hf.getHuman_nationality());
	    hfd.setHuman_birthplace(hf.getHuman_birthplace());
			hfd.setHuman_birthday(hf.getHuman_birthday());
		hfd.setHuman_race(hf.getHuman_race());
		hfd.setHuman_religion(hf.getHuman_religion());
		hfd.setHuman_party(hf.getHuman_religion());
		hfd.setHuman_id_card(hf.getHuman_id_card());
		
		hfd.setHuman_age(hf.getHuman_age());
		hfd.setHuman_educated_degree(hf.getHuman_educated_degree());
		hfd.setHuman_educated_years(hf.getHuman_educated_years());
		hfd.setHuman_educated_major(hf.getHuman_educated_major());
		hfd.setHuman_bank(hf.getHuman_bank());
		hfd.setHuman_account(hf.getHuman_account());
		hfd.setRemark(hf.getRemark());
		hfd.setHuman_speciality(hf.getHuman_speciality());
		hfd.setHuman_hobby(hf.getHuman_hobby());
		hfd.setHuman_history_records(hf.getHuman_history_records());
		hfd.setHuman_family_membership(hf.getHuman_family_membership());
		hfd.setHuman_file_status((short) 1);
		Date time = new Date(new java.util.Date().getTime());
		hf.setChange_time(time);
		hf.setCheck_time(time);
		hf.setCheck_status((short)1);
		humanFileDigServiceImpl.addHumanFileDig(hfd);
		ModelAndView mav = new ModelAndView();
        mav.setViewName("delete_human_success");
        return mav;
	}
	
	@RequestMapping("changeLocate")
	public ModelAndView changeLocate(@RequestParam String firstKindName,@RequestParam String secondKindName,@RequestParam String thirdKindName,
			@RequestParam String humanMajorKindName,@RequestParam String humanMajorName,@RequestParam String str_startTime,@RequestParam String str_endTime){
		HashMap<String, String> map = new HashMap<String, String>();
		String[] str = splitStr(secondKindName);
	
		map.put("firstKindName", firstKindName);
		map.put("secondKindName", str[1]);
		map.put("thirdKindName", thirdKindName);
		map.put("humanMajorName", humanMajorName);
		map.put("humanMajorKindName",humanMajorKindName);
		map.put("str_startTime",str_startTime);
		map.put("str_endTime",str_endTime);
		ModelAndView mav = new ModelAndView();
		List<HumanFile> human = humanFileServiceImpl.queryByMapCondition(map);
		mav.addObject("human", human);
		mav.setViewName("change_list");
		return mav;
	}
	
	@RequestMapping("changeHuman")
	public ModelAndView changeHuman(@RequestParam String huf_id){
		int hufid = Integer.parseInt(huf_id);
		HumanFile human = humanFileServiceImpl.queryHumanFileByHuf_id(hufid);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("human", human);
	    mav.setViewName("change_human");
	    return mav;
	}
	
	
	@RequestMapping("changeHumanTwo")
	public ModelAndView changeHumanTwo(@RequestParam String firstKindName,@RequestParam String secondKindName,@RequestParam String thirdKindName,@RequestParam String humanMajorKindName,@RequestParam String humanMajorName
			,@RequestParam String humanProDesignation,@RequestParam String humanName,@RequestParam String humanSex,@RequestParam String humanEmail,@RequestParam String humanTelephone,@RequestParam String humanQq,@RequestParam String humanMobilephone,@RequestParam String humanAddress,
			@RequestParam String humanPostcode,@RequestParam String humanNationality,@RequestParam String humanBirthplace,@RequestParam String str_humanBirthday,@RequestParam String humanRace,@RequestParam String humanReligion,@RequestParam String humanParty,
			@RequestParam String humanIdCard,@RequestParam String humanSocietySecurityId,@RequestParam String humanAge,@RequestParam String humanEducatedDegree,@RequestParam String humanEducatedYears,@RequestParam String humanEducatedMajor,@RequestParam String salaryStandardName,@RequestParam String humanBank,
			@RequestParam String humanAccount,@RequestParam String remark,@RequestParam String humanSpeciality,@RequestParam String humanHobby,@RequestParam String humanHistroyRecords,@RequestParam String humanFamilyMembership,@RequestParam String checker){
		    HumanFileDig hf = new HumanFileDig();
		    HumanFile human = humanFileServiceImpl.queryHumanFileByName(humanName);
		    //获得一级机构
		    hf.setFirst_kind_id(configFileFirstKindServiceImpl.queryIdByName(firstKindName));
		    hf.setFirst_kind_name(firstKindName);
		    //获得二级机构
		    hf.setSecond_kind_id(configFileSecondKindServiceImpl.queryIdByName(secondKindName));
		    hf.setSecond_kind_name(secondKindName);
		    //获得三级机构
		    hf.setThird_kind_id(configFileThirdKindServiceImpl.queryIdByName(thirdKindName));
		    hf.setThird_kind_name(thirdKindName);
		    
		    //获得职位分类 humanMajorKindName
		    hf.setHuman_major_kind_id(configMajorKindServiceImpl.selectConfigMajorKindIdByName(humanMajorKindName));
		    hf.setHuman_major_kind_name(humanMajorKindName);
		    
		    //获得职位名称  hunmaMajorName
		    hf.setHuman_major_id(configMajorServicesImpl.selectConfigMajorIdByName(humanMajorName));
		    hf.setHuman_major_name(humanMajorName);
		    
		    //获得标准薪酬  salaryStandardName
		    hf.setSalary_standard_id(salaryStandardServiceImpl.queryIdByName(salaryStandardName));
		    hf.setSalary_standard_name(salaryStandardName);
		    
		   
		    hf.setHuman_pro_designation(humanProDesignation);
		    hf.setHuman_name(humanName);
		    hf.setHuman_sex(humanSex);
		    hf.setHuman_email(humanEmail);
		    hf.setHuman_telephone(humanTelephone);
		    hf.setHuman_qq(humanQq);
		    hf.setHuman_mobilephone(humanMobilephone);
		    hf.setHuman_address(humanAddress);
		    hf.setHuman_postcode(humanPostcode);
		    hf.setHuman_nationality(humanNationality);
		    hf.setHuman_birthplace(humanBirthplace);
		    Date date;
			try {
				date =new Date( new SimpleDateFormat("yyyy-MM-dd").parse("2000-06-03").getTime());
				hf.setHuman_birthday(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			hf.setHuman_race(humanRace);
			hf.setHuman_religion(humanReligion);
			hf.setHuman_party(humanParty);
			hf.setHuman_id_card(humanIdCard);
			int h_age = Integer.parseInt(humanAge);
			Short age = (short) h_age;
			hf.setHuman_age(age);
			hf.setHuman_educated_degree(humanEducatedDegree);
			int h_year = Integer.parseInt(humanEducatedYears);
			Short year = (short) h_year;
			hf.setHuman_educated_years(year);
			hf.setHuman_educated_major(humanEducatedMajor);
			hf.setHuman_bank(humanBank);
			hf.setHuman_account(humanAccount);
			hf.setRemark(remark);
			hf.setHuman_speciality(humanSpeciality);
			hf.setHuman_hobby(humanHobby);
			hf.setHuman_history_records(humanHistroyRecords);
			hf.setHuman_family_membership(humanFamilyMembership);
			hf.setDemand_salary_sum(2000.00);
			hf.setFile_chang_amount(human.getFile_chang_amount());
			hf.setBonus_amount(human.getBonus_amount());
			hf.setSalary_sum(human.getSalary_sum());
			hf.setPaid_salary_sum(human.getPaid_salary_sum());
			hf.setTraining_amount(human.getTraining_amount());
			hf.setAttachment_name(human.getAttachment_name());
			Date time = new Date(new java.util.Date().getTime());
			hf.setChange_time(time);
			hf.setCheck_time(time);
			hf.setCheck_status((short)1);
		
			hf.setChecker(checker);
			hf.setChanger(checker);
			hf.setRegist_time(human.getRegist_time());
			hf.setRegister(human.getRegister());
			humanFileDigServiceImpl.addHumanFileDig(hf);
			HumanFile huf  = new HumanFile();
			huf.setHuf_id(human.getHuf_id());
			huf.setHuman_name(hf.getHuman_name());
			huf.setCheck_status(hf.getCheck_status());
			//获得一级机构
		    huf.setFirst_kind_id(hf.getFirst_kind_id());
		    huf.setFirst_kind_name(hf.getFirst_kind_name());
		    //获得二级机构
		    huf.setSecond_kind_id(hf.getSecond_kind_id());
		    huf.setSecond_kind_name(hf.getSecond_kind_name());
		    //获得三级机构
		    huf.setThird_kind_id(hf.getThird_kind_id());
		    huf.setThird_kind_name(hf.getThird_kind_name());
		    
		    //获得职位分类 humanMajorKindName
		    huf.setHuman_major_kind_id(hf.getHuman_major_kind_id());
		    huf.setHuman_major_kind_name(hf.getHuman_major_kind_name());
		    
		    //获得职位名称  hunmaMajorName
		    huf.setHuman_major_id(hf.getHuman_major_id());
		    huf.setHuman_major_name(hf.getHuman_major_name());
		    
		    //获得标准薪酬  salaryStandardName
		    huf.setSalary_standard_id(hf.getSalary_standard_id());
		    huf.setSalary_standard_name(hf.getSalary_standard_name());
		    
		   
		    huf.setHuman_pro_designation(humanProDesignation);
		    huf.setHuman_name(humanName);
		    huf.setHuman_sex(humanSex);
		    huf.setHuman_email(humanEmail);
		    huf.setHuman_telephone(humanTelephone);
		    huf.setHuman_qq(humanQq);
		    huf.setHuman_mobilephone(humanMobilephone);
		    huf.setHuman_address(humanAddress);
		    huf.setHuman_postcode(humanPostcode);
		    huf.setHuman_nationality(humanNationality);
		    huf.setHuman_birthplace(humanBirthplace);
				huf.setHuman_birthday(hf.getHuman_birthday());
			huf.setHuman_race(humanRace);
			huf.setHuman_religion(humanReligion);
			huf.setHuman_party(humanParty);
			huf.setHuman_id_card(humanIdCard);
			huf.setHuman_age(hf.getHuman_age());
			huf.setHuman_educated_degree(humanEducatedDegree);
			huf.setHuman_educated_years(hf.getHuman_educated_years());
			huf.setHuman_educated_major(humanEducatedMajor);
			huf.setHuman_bank(humanBank);
			huf.setHuman_account(humanAccount);
			huf.setRemark(remark);
			huf.setHuman_speciality(humanSpeciality);
			huf.setHuman_hobby(humanHobby);
			huf.setHuman_history_records(humanHistroyRecords);
			huf.setHuman_family_membership(humanFamilyMembership);
			huf.setDemand_salary_sum(2000.00);
			huf.setFile_chang_amount(human.getFile_chang_amount());
			huf.setBonus_amount(human.getBonus_amount());
			huf.setSalary_sum(human.getSalary_sum());
			huf.setPaid_salary_sum(human.getPaid_salary_sum());
			huf.setTraining_amount(human.getTraining_amount());
			huf.setAttachment_name(human.getAttachment_name());
			huf.setChange_time(time);
			huf.setCheck_time(time);
			huf.setCheck_status((short)1);
			huf.setChecker(checker);
			huf.setChanger(checker);
			huf.setRegist_time(human.getRegist_time());
			huf.setRegister(human.getRegister());
			humanFileServiceImpl.updateHumanFile(huf);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("change_human_success");
		return mav;
	}
	
	
	@RequestMapping("keywordsChange")
	public ModelAndView KeywordsChange(@RequestParam String keywords){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keywords", keywords);
        List<HumanFile> human =  humanFileServiceImpl.queryByMapCondition(map);
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("human", human);
        mav.setViewName("change_list");
        return mav;
	}
	

	
	@RequestMapping("recoveryHuman")
	public ModelAndView recoveryHumanfile(){
		List<HumanFile> humans = humanFileServiceImpl.queryAllHumanFileByStatus(1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("humans", humans);
		mav.setViewName("recovery_locate");
		return mav;
	}
	
	@RequestMapping("recoveryHumantwo")
	public ModelAndView recoveryHumantwo(@RequestParam String huf_id){
	   HumanFile hf = humanFileServiceImpl.queryHumanFileByHuf_id(Integer.parseInt(huf_id));
		hf.setHuman_file_status((byte) 0);
		humanFileServiceImpl.updateHumanFile(hf);
		HumanFileDig hfd = new HumanFileDig();
	    //获得一级机构
	    hfd.setFirst_kind_id(hf.getFirst_kind_id());
	    hfd.setFirst_kind_name(hf.getFirst_kind_name());
	    //获得二级机构
	    hfd.setSecond_kind_id(hf.getSecond_kind_id());
	    hfd.setSecond_kind_name(hf.getSecond_kind_name());
	    //获得三级机构
	    hfd.setThird_kind_id(hf.getThird_kind_id());
	    hfd.setThird_kind_name(hf.getThird_kind_name());
	    
	    //获得职位分类 humanMajorKindName
	    hfd.setHuman_major_kind_id(hf.getHuman_major_kind_id());
	    hfd.setHuman_major_kind_name(hf.getHuman_major_kind_name());
	    
	    //获得职位名称  hunmaMajorName
	    hfd.setHuman_major_id(hf.getHuman_major_id());
	    hfd.setHuman_major_name(hf.getHuman_major_name());
	    
	    //获得标准薪酬  salaryStandardName
	    hfd.setSalary_standard_id(hf.getSalary_standard_id());
	    hfd.setSalary_standard_name(hf.getSalary_standard_name());
	    
	   hfd.setHuman_birthday(hf.getHuman_birthday());
	    hfd.setHuman_pro_designation(hf.getHuman_pro_designation());
	    hfd.setHuman_name(hf.getHuman_name());
	    hfd.setHuman_sex(hf.getHuman_sex());
	    hfd.setHuman_email(hf.getHuman_email());
	    hfd.setHuman_telephone(hf.getHuman_telephone());
	    hfd.setHuman_qq(hf.getHuman_qq());
	    hfd.setHuman_mobilephone(hf.getHuman_mobilephone());
	    hfd.setHuman_address(hf.getHuman_address());
	    hfd.setHuman_postcode(hf.getHuman_postcode());
	    hfd.setHuman_nationality(hf.getHuman_nationality());
	    hfd.setHuman_birthplace(hf.getHuman_birthplace());
			hfd.setHuman_birthday(hf.getHuman_birthday());
		hfd.setHuman_race(hf.getHuman_race());
		hfd.setHuman_religion(hf.getHuman_religion());
		hfd.setHuman_party(hf.getHuman_religion());
		hfd.setHuman_id_card(hf.getHuman_id_card());
		
		hfd.setHuman_age(hf.getHuman_age());
		hfd.setHuman_educated_degree(hf.getHuman_educated_degree());
		hfd.setHuman_educated_years(hf.getHuman_educated_years());
		hfd.setHuman_educated_major(hf.getHuman_educated_major());
		hfd.setHuman_bank(hf.getHuman_bank());
		hfd.setHuman_account(hf.getHuman_account());
		hfd.setRemark(hf.getRemark());
		hfd.setHuman_speciality(hf.getHuman_speciality());
		hfd.setHuman_hobby(hf.getHuman_hobby());
		hfd.setHuman_history_records(hf.getHuman_history_records());
		hfd.setHuman_family_membership(hf.getHuman_family_membership());
		hfd.setHuman_file_status((short) 0);
		humanFileDigServiceImpl.addHumanFileDig(hfd);
		Date time = new Date(new java.util.Date().getTime());
		hf.setChange_time(time);
		hf.setCheck_time(time);
		hf.setCheck_status((short)1);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recovery_success");
		return mav;
	}
	
	@RequestMapping("deleteForever")
	public ModelAndView deleteForever(){
		List<HumanFile> humans = humanFileServiceImpl.queryAllHumanFileByStatus(1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("humans", humans);
		mav.setViewName("delete_forever");
		return mav;
	}
	
	@RequestMapping("deleteForevertwo")
	public ModelAndView deleteForevertwo(@RequestParam String human_name){
		humanFileServiceImpl.removeHumanFile(human_name);
		HumanFile hf = humanFileServiceImpl.queryHumanFileByName(human_name);
		HumanFileDig hfd = new HumanFileDig();
	    //获得一级机构
	    hfd.setFirst_kind_id(hf.getFirst_kind_id());
	    hfd.setFirst_kind_name(hf.getFirst_kind_name());
	    //获得二级机构
	    hfd.setSecond_kind_id(hf.getSecond_kind_id());
	    hfd.setSecond_kind_name(hf.getSecond_kind_name());
	    //获得三级机构
	    hfd.setThird_kind_id(hf.getThird_kind_id());
	    hfd.setThird_kind_name(hf.getThird_kind_name());
	    
	    //获得职位分类 humanMajorKindName
	    hfd.setHuman_major_kind_id(hf.getHuman_major_kind_id());
	    hfd.setHuman_major_kind_name(hf.getHuman_major_kind_name());
	    
	    //获得职位名称  hunmaMajorName
	    hfd.setHuman_major_id(hf.getHuman_major_id());
	    hfd.setHuman_major_name(hf.getHuman_major_name());
	    
	    //获得标准薪酬  salaryStandardName
	    hfd.setSalary_standard_id(hf.getSalary_standard_id());
	    hfd.setSalary_standard_name(hf.getSalary_standard_name());
	    
	   hfd.setHuman_birthday(hf.getHuman_birthday());
	    hfd.setHuman_pro_designation(hf.getHuman_pro_designation());
	    hfd.setHuman_name(hf.getHuman_name());
	    hfd.setHuman_sex(hf.getHuman_sex());
	    hfd.setHuman_email(hf.getHuman_email());
	    hfd.setHuman_telephone(hf.getHuman_telephone());
	    hfd.setHuman_qq(hf.getHuman_qq());
	    hfd.setHuman_mobilephone(hf.getHuman_mobilephone());
	    hfd.setHuman_address(hf.getHuman_address());
	    hfd.setHuman_postcode(hf.getHuman_postcode());
	    hfd.setHuman_nationality(hf.getHuman_nationality());
	    hfd.setHuman_birthplace(hf.getHuman_birthplace());
			hfd.setHuman_birthday(hf.getHuman_birthday());
		hfd.setHuman_race(hf.getHuman_race());
		hfd.setHuman_religion(hf.getHuman_religion());
		hfd.setHuman_party(hf.getHuman_religion());
		hfd.setHuman_id_card(hf.getHuman_id_card());
		
		hfd.setHuman_age(hf.getHuman_age());
		hfd.setHuman_educated_degree(hf.getHuman_educated_degree());
		hfd.setHuman_educated_years(hf.getHuman_educated_years());
		hfd.setHuman_educated_major(hf.getHuman_educated_major());
		hfd.setHuman_bank(hf.getHuman_bank());
		hfd.setHuman_account(hf.getHuman_account());
		hfd.setRemark(hf.getRemark());
		hfd.setHuman_speciality(hf.getHuman_speciality());
		hfd.setHuman_hobby(hf.getHuman_hobby());
		hfd.setHuman_history_records(hf.getHuman_history_records());
		hfd.setHuman_family_membership(hf.getHuman_family_membership());
		hfd.setHuman_file_status((short) 0);
		humanFileDigServiceImpl.addHumanFileDig(hfd);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("delete_forever_success");
		return mav;
	}
}
