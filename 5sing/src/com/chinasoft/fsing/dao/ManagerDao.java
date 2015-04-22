package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Manager;

public class ManagerDao {
	private DBHelp hp;

	public ManagerDao() {
	}
	//管理员登陆
	public Manager login(String mname,String mpass){
		Manager manager=null;
		hp=new DBHelp();
		String sql="select * from manager where mname=? and mpass=? and mflag=1";
		try {
			ResultSet rs=hp.query(sql, mname,mpass);
			if(rs.next()){
				manager=new Manager(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return manager;
	}
	/*管理员修改*/
	public int updateManager(Manager manager){
		int temp=-1;
		hp=new DBHelp();
		String sql="update manager set mphone=?,memail=?,mpower=?,mflag=? where mid=?";
		try {
			temp=hp.update(sql,manager.getMphone(),manager.getMemail(),manager.getMpower(),manager.getMflag(),manager.getMid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	//查看是否存在(添加前)
	public int isHave(String mname){
		int temp=-1;
		hp=new DBHelp();
		String sql="select count(*) from manager where mname=?";
		try {
			ResultSet rs=hp.query(sql, mname);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	/*添加管理员*/
	public int addManager(Manager manager){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into manager(mname,mpass,mphone,memail) values(?,?,?,?)";
		try {
			temp=hp.update(sql, manager.getMname(),manager.getMpass(),manager.getMphone(),manager.getMemail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}

}
