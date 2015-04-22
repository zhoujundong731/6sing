package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Notic;

public class NoticDao {
	private DBHelp hp;

	public NoticDao() {
		super();
	}
	
	//添加公告
	public int addNotic(Notic notic){
		hp=new DBHelp();
		int temp=-1;
		String sql="insert into notic values(?,?,?,?,?,?,?)";
		try {
			temp=hp.update(sql, notic.getNid(),notic.getNtitle(),notic.getNtext(),notic.getNimage(),notic.getNtime(),notic.getNflag(),notic.getManager().getMid());
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
	//查看公告(所有)
	public List<Notic> showAll(){
		hp=new DBHelp();
		List<Notic> list=new ArrayList<>();
		String sql="select * from notic where nflag=1";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Notic(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
