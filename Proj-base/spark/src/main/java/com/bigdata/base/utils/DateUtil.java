package com.bigdata.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getDate() {
		return getDate("yyMMdd");
	}
	
	public static String getDate(String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(new Date());
	}
}
