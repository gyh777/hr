package com.hr.test.cy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigFileFirstKind;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.pojo.HumanFile;
import com.hr.pojo.HumanFileDig;
import com.hr.service.BonusService;
import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigFileSecondKindService;
import com.hr.service.HumanFileDigService;
import com.hr.service.HumanFileService;

public class Test {
  public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
//		ConfigFileSecondKindService service = (ConfigFileSecondKindService)context.getBean("configFileSecondKindServiceImpl");
//		List<ConfigFileSecondKind> list = service.queryAllConfigFileSecondKind();
//		System.out.println(list.size());
		
//		List<ConfigFileSecondKind> list = service.queryAllConfigFileSecondKind();
//
//				System.out.println(list.size());
		
//		ConfigFileFirstKindService service = (ConfigFileFirstKindService)context.getBean("configFileFirstKindServiceImpl");
//		System.out.println(cffk);
//		List<ConfigFileFirstKind> list = service.queryAllConfigFileFirstKind();
//		System.out.println(list.size());
//		ConfigFileFirstKind cffk = new ConfigFileFirstKind();
//		ConfigFileFirstKind cffk =   service.queryConfigFileFirstKindById("03");
//		service.removeConfigFileFirstKind("03");
//		System.out.println(cffk);
//		ConfigFileSecondKind cf = service.queryConfigFileSecondKindById("06");
//		System.out.println(cf.getSecond_kind_name());
		
		
		
//		short s = 1;
//		ConfigFileSecondKind cffk =   new ConfigFileSecondKind();
//		cffk.setFsk_id(s);
//		cffk.setSecond_kind_id("02");
//		cffk.setSecond_kind_name("分部");
//		cffk.setFirst_kind_id("02");
//		cffk.setFirst_kind_name("集团");
//		cffk.setSecond_kind_salary_id("002");
//		cffk.setSecond_kind_sale_id("045");
//		service.addConfigFileSecondKind(cffk);
		
		
//		HumanFileService service = (HumanFileService)context.getBean("humanFileServiceImpl");
//		HumanFile hf = new HumanFile();
//		hf.setHuman_name("sss");
//		Short age = 20;
//		hf.setHuman_age(age);
//		service.addHumanFile(hf);
//		List<HumanFile> list= service.queryAllHumanFile();
//		System.out.println(list.size());
		
		HumanFileDigService service = (HumanFileDigService)context.getBean("humanFileDigServiceImpl");
//		HumanFileDig hf = service.queryHumanFileDigByHfd_id(0)  ;
//		System.out.println(hf);
		HumanFileDig hf = new HumanFileDig();
		hf.setHuman_name("sss");
		Short age = 20;
		hf.setHuman_age(age);
		service.addHumanFileDig(hf);
		List<HumanFileDig> list= service.queryAllHumanFileDig();
		System.out.println(list.size());
  }
}
