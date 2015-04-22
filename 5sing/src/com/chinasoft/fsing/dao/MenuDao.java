package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Manager;
import com.chinasoft.fsing.vo.Menu;
import com.chinasoft.fsing.vo.User;

public class MenuDao {
	
	private DBHelp hp;
	//显示主菜单（用户）
	public List<Menu> showAll(User user){
		List<Menu> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="select * from menu where mdisplay=1 and mpower=? order by morder";
		try {
			ResultSet rs=hp.query(sql, user.getUpower());
			while(rs.next()){
				list.add(new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
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
		return list;
	}
	//显示菜单（管理员）
	public List<Menu> showAll(Manager manager){
		List<Menu> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="select * from menu where mdisplay=1 and mpower=? order by morder";
		try {
			ResultSet rs=hp.query(sql, manager.getMpower());
			while(rs.next()){
				list.add(new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
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
		return list;
	}

}
