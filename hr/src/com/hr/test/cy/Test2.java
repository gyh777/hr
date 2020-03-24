package com.hr.test.cy;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.HumanFile;
import com.hr.pojo.HumanFileDig;
import com.hr.service.HumanFileDigService;
import com.hr.service.HumanFileService;
import com.hr.service.impl.HumanFileDigServiceImpl;

public class Test2 {

	public static void main(String[] args) {
		
		
		//测试倒数第二个方法
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("firstKindName", "集团");
		map.put("secondKindName", "软件公司");
		map.put("thirdKindName", "外包组");
		map.put("humanMajorName", "销售");
		map.put("humanMajorKindName","区域经理");
		map.put("str_startTime","2000-09-02");
		map.put("str_endTime","2011-02-06");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HumanFileService service = (HumanFileService)context.getBean("humanFileServiceImpl");
         List<HumanFile> list =       service.queryByMapCondition(map);
	   System.out.println(list.size());
	//测试倒数第一个方法
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("keywords", "项目经理");
//	
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("applicationContext.xml");
//		HumanFileService service = (HumanFileService)context.getBean("humanFileServiceImpl");
//         List<HumanFileDig> list =       service.queryByKeyCondition(map);
//	     System.out.println(list.get(0).getHuman_id());
//	
		
//		HumanFile human = service.queryHumanFileByHuf_id(7);
//		human.setHuman_file_status((short) 0);
//		service.updateHumanFile(human);
		
//		HumanFile hf = service.queryHumanFileByName("嘻嘻嘻");
//		hf.setHuman_file_status((byte) 0);
//		service.updateHumanFile(hf);
		
//		List<HumanFile> humans = service.queryFileByCheckstatus((short) 0);
//	    System.out.println(humans.size());
	}

}
