package com.chinasoft.fsing.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	//获取时间
	public static String getTime(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	//获取long类型的时间
	public static long getLongTime(Date date){
		return date.getTime();
	}

}
