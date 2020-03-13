package com.hr.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigFileFirstKind;
import com.hr.service.BonusService;
import com.hr.service.ConfigFileFirstKindService;

public class Test {
  public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		ConfigFileFirstKindService service = (ConfigFileFirstKindService)context.getBean("configFileFirstKindServiceImpl");
		List<ConfigFileFirstKind> list = service.queryAllConfigFileFirstKind();
		System.out.println(list.size());
}
}
