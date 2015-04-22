package com.zhou.hibernateLog;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HibernateLog {
	public Logger get(Class clazz){
		Logger log=null;
		PropertyConfigurator.configure("hibernateLog.properties");
		log = Logger.getLogger(clazz);
		return log;
	}
}
