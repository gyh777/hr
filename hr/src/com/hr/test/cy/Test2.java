package com.hr.test.cy;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.HumanFileDig;
import com.hr.service.HumanFileDigService;
import com.hr.service.impl.HumanFileDigServiceImpl;

public class Test2 {

	public static void main(String[] args) {
		
		
		//测试倒数第二个方法
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("firstKindName", "sss");
//		map.put("secondKindName", "sss");
//		map.put("thirdKindName", "sss");
//		map.put("humanMajorName", "sss");
//		map.put("humanMajorKindName","sss");
//		map.put("str_startTime","2000-09-02");
//		map.put("str_endTime","2010-02-06");
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("applicationContext.xml");
//		HumanFileDigService service = (HumanFileDigService)context.getBean("humanFileDigServiceImpl");
//         List<HumanFileDig> list =       service.queryByMapCondition(map);
	
	
	//测试倒数第二个方法
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keywords", "sss");
	
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HumanFileDigService service = (HumanFileDigService)context.getBean("humanFileDigServiceImpl");
         List<HumanFileDig> list =       service.queryByKeyCondition(map);
	
	}

}
