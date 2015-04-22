package com.chinasoft.fsing.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DBHelp {
	/*private final String DIRVER="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://127.0.0.1:3306/";
	private final String DBNAME="5sing";
	private final String USER="root";
	private final String PASS="1";*/
	private Connection conn;
	private Statement stat;
	private PreparedStatement prep;
	//构造方法
	public DBHelp(){
		//step1 step2
/*		try {
			Class.forName(DIRVER);
			conn=DriverManager.getConnection(URL+DBNAME,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
/*		try {
			Context initcontext=new InitialContext();
			Context envContext=(Context)initcontext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/book");
			conn=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	//数据库连接池	
		DataSourceProvider provider=DataSourceProvider.getInstance();
		BasicDataSource dataSource =provider.getBasicDataSource();
		try {
			this.conn=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//增 删 改
	public int update(String sql) throws SQLException{
		//step3  step4
		stat=conn.createStatement();
		int temp=stat.executeUpdate(sql);
		return temp;
	}
	//预处理
	public int update(String sql,Object ... arr) throws SQLException{
		//step3  step4
		prep=conn.prepareStatement(sql);
		//给问号赋值
		for(int i=0;i<arr.length;i++){
			prep.setObject(i+1, arr[i]);
		}
		int temp=prep.executeUpdate();
		return temp;
	}
	
	
	//查
	public ResultSet query(String sql) throws SQLException{
		//step3  step4
		stat=conn.createStatement();
		ResultSet rs=stat.executeQuery(sql);
		return rs;
	}
	public ResultSet query(String sql,Object ... arr) throws SQLException{
		//step3  step4
		prep=conn.prepareStatement(sql);
		//给问号赋值
		for(int i=0;i<arr.length;i++){
			prep.setObject(i+1, arr[i]);
		}
		//System.out.println(prep);
		return prep.executeQuery();
	}
	
	//关闭
	public void closeAll() throws SQLException{
		if(stat!=null && !stat.isClosed()) stat.close();
		if(prep!=null && !prep.isClosed()) prep.close();
		if(conn!=null && !conn.isClosed()) conn.close();
	}

}
