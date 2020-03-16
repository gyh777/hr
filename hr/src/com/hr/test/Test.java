package com.hr.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigFileFirstKind;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.service.BonusService;
import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigFileSecondKindService;

public class Test {
  public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
//		ConfigFileSecondKindService service = (ConfigFileSecondKindService)context.getBean("configFileSecondKindServiceImpl");
//		List<ConfigFileSecondKind> list = service.queryAllConfigFileSecondKind();
//		System.out.println(list.size());
		
//		List<ConfigFileSecondKind> list = service.queryAllConfigFileSecondKind();
//		System.out.println(list.size());
		ConfigFileFirstKindService service = (ConfigFileFirstKindService)context.getBean("configFileFirstKindServiceImpl");
//		System.out.println(cffk);
//		List<ConfigFileFirstKind> list = service.queryAllConfigFileFirstKind();
//		System.out.println(list.size());
//		ConfigFileFirstKind cffk = new ConfigFileFirstKind();
		ConfigFileFirstKind cffk =   service.queryConfigFileFirstKindById("03");
//		service.removeConfigFileFirstKind("03");
//		System.out.println(cffk);
//		short s = 1;
//		cffk.setFfk_id(s);
		cffk.setFirst_kind_id("03");
		cffk.setFirst_kind_name("总部");
		cffk.setFirst_kind_salary_id("002");
		cffk.setFirst_kind_sale_id("045");
		service.updateConfigFileFirstKind(cffk);
  }
}
