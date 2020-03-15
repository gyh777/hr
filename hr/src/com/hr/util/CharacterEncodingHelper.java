package com.hr.util;

import java.io.UnsupportedEncodingException;

public class CharacterEncodingHelper {
	public static String getChinese(String str){
		byte[] bytes;
		try {
			bytes = str.getBytes("ISO-8859-1");
			str = new String(bytes,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
