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
//		map.put("firstKindName", "集团");
//		map.put("secondKindName", "生物科技有限公司");
//		map.put("thirdKindName", "药店");
//		map.put("humanMajorName", "项目经理");
//		map.put("humanMajorKindName","软件开发");
//		map.put("str_startTime","2000-09-02");
//		map.put("str_endTime","2011-02-06");
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("applicationContext.xml");
//		HumanFileDigService service = (HumanFileDigService)context.getBean("humanFileDigServiceImpl");
//         List<HumanFileDig> list =       service.queryByMapCondition(map);
//	System.out.println(list.get(0).getHuman_id());
	
	//测试倒数第一个方法
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keywords", "项目经理");
	
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HumanFileDigService service = (HumanFileDigService)context.getBean("humanFileDigServiceImpl");
         List<HumanFileDig> list =       service.queryByKeyCondition(map);
	     System.out.println(list.get(0).getHuman_id());
	}

}
