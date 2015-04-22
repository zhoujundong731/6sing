package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Menu;
import com.chinasoft.fsing.vo.SubMenu;

public class SubMenuDao {
	private DBHelp hp;

	public SubMenuDao() {
		super();
	}
	
	//ÏÔÊ¾×Ó²Ëµ¥
	public List<SubMenu> showAllSub(Menu menu){
		List<SubMenu> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="select * from submenu where sudisplay=1 and mid=? order by suorder";
		try {
			ResultSet rs=hp.query(sql, menu.getMid());
			while(rs.next()){
				list.add(new SubMenu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
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
