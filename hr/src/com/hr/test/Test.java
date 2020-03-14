package com.hr.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.service.BonusService;
import com.hr.service.ConfigFileSecondKindService;

public class Test {
  public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
//		ConfigFileSecondKindService service = (ConfigFileSecondKindService)context.getBean("configFileSecondKindServiceImpl");
//		List<ConfigFileSecondKind> list = service.queryAllConfigFileSecondKind();
//		System.out.println(list.size());
		
		ConfigFileSecondKindService service = (ConfigFileSecondKindService)context.getBean("configFileSecondKindServiceImpl");
		List<ConfigFileSecondKind> list = service.queryAllConfigFileSecondKind();
		System.out.println(list.size());
}
}
