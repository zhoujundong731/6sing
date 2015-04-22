package com.chinasoft.fsing.biz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.util.DateUtil;

public class Text {
	private static Date date=new Date();
	
	
	public static void main(String[] args) {
		long a=DateUtil.getLongTime(date);

	}
}
