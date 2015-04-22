package com.chinasoft.fsing.dbutil;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

/**
 * Application Lifecycle Listener implementation class DataSourceListenner
 *
 */
public class DataSourceListenner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DataSourceListenner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @SuppressWarnings("static-access")
	public void contextInitialized(ServletContextEvent arg0) {
        try {
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			BasicDataSource basicDataSource=(BasicDataSource)envContext.lookup("jdbc/6sing");
			DataSourceProvider provider = DataSourceProvider.getInstance();
			provider.setBasicDataSource(basicDataSource);
			System.out.println("数据库连接池初始化成功。。。。。。。");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	DataSourceProvider provider = DataSourceProvider.getInstance();
    	@SuppressWarnings("static-access")
		BasicDataSource basicDataSource = provider.getBasicDataSource();
    	try {
			basicDataSource.close();
			System.out.println("DBCP数据池连接关闭!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
}
