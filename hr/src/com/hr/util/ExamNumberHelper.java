package com.hr.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExamNumberHelper {
	public static String getExamNumber(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA);
		return simpleDateFormat.format(new Date());
	}
	
	public static String getDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss", Locale.CHINA);
		return simpleDateFormat.format(new Date());
	}
}
