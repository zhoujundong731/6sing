package com.chinasoft.fsing.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	//��ȡʱ��
	public static String getTime(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	//��ȡlong���͵�ʱ��
	public static long getLongTime(Date date){
		return date.getTime();
	}

}
