package com.hr.test.gyh;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.mapper.EngageSubjectsMapper;
import com.hr.pojo.EngageSubjects;

public class Test {
	/**
	 * 
	 * 试题登记的两级联动
	 * 
	 */
	
	
	ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	
	@org.junit.Test
	public void test01(){
		EngageSubjectsMapper engageSubjectsMapper = applicationContext.getBean(EngageSubjectsMapper.class);
		EngageSubjects engageSubjects = new EngageSubjects();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//		Date dt;
//		try {
//			dt = sdf.parse("2009-07-16T19:20");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Date date = new Date();
//		engageSubjects.setSubId("aaa");
//		int res = engageSubjectsMapper.insert(engageSubjects);
//		System.out.println(res);
		
//		List<EngageSubjects> list = engageSubjectsMapper.select();
//		System.out.println(list.size());
	}
}
