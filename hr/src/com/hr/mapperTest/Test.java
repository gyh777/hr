package com.hr.mapperTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.pojo.Bonus;
import com.hr.service.BonusService;

public class Test {
  public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/hr/applicationContext.xml");
		BonusService service = (BonusService)context.getBean("bonusService");
//		Student student = new Student();
//		student.setSid(8);
//		student.setSname("肖艳文");
//		student.setSex("男");
//		student.setScore(77);
//		service.addStudent(student);
		List<Bonus> list = service.selectAllBonus();
//		for (Bonus bonus : list) {
//			System.out.println(bonus);
//		}
		System.out.println(list.size());
}
}
