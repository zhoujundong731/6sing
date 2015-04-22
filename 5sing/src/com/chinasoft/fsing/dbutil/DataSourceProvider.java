package com.chinasoft.fsing.dbutil;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DataSourceProvider {
	private static DataSourceProvider instance;
	private static BasicDataSource basicDataSource;
	private DataSourceProvider(){
		
	}
	public static DataSourceProvider getInstance() {
		if(instance == null){
			return new DataSourceProvider();
		}else{
		return instance;
		}
	}
	public static BasicDataSource getBasicDataSource() {
		return basicDataSource;
	}
	public static void setBasicDataSource(BasicDataSource basicDataSource) {
		DataSourceProvider.basicDataSource = basicDataSource;
	}

	

}
