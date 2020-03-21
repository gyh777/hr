package com.hr.web.interceptor;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.ConfigFileThirdKind;
import com.hr.service.ConfigFileThirdKindService;

public class Test {
  public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		ConfigFileThirdKindService service = (ConfigFileThirdKindService)context.getBean("configFileThirdKindServiceImpl");
	  ConfigFileThirdKind u=new ConfigFileThirdKind();
	  u.setPagebegin(2);
	  u.setPagesize(3);
	  System.out.println("-u.getCount()------"+u.getCount());
	  List<ConfigFileThirdKind> l=service.queryAllThirdByPage(u);
	  System.out.println(l.size());
	  System.out.println("-u.getCount()------"+u.getCount());
}
}
