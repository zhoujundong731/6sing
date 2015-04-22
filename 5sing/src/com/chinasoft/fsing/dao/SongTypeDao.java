package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.SongType;
public class SongTypeDao {
	private DBHelp hp;
	
	public SongTypeDao() {
		super();
	}
	//查看是否存在(添加前)
			public int isHave(String stname){
				int temp=-1;
				hp=new DBHelp();
				String sql="SELECT COUNT(*) FROM songtype WHERE stname=?";
				try {
					ResultSet rs=hp.query(sql, stname);
					if(rs.next()){
						temp=rs.getInt(1);
						System.out.println(temp);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return temp;
			}
	
	//添加
	public int addSongType(SongType st){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into songtype(stname) values(?)";
		try {
			temp=hp.update(sql,st.getStname());
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

	//删除
	public int delSongType(String stid){
		int temp=-1;
		hp=new DBHelp();
		String sql="DELETE FROM songtype WHERE stid="+stid;
		try {
			temp=hp.update(sql);
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
	//修改
	public int updateSongType(SongType st){
		int temp=-1;
		hp=new DBHelp();
		String sql="update songtype set stname=? where stid=?";
		try {
			temp=hp.update(sql,st.getStname(),st.getStid());
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
	/*查看全部*/
	public List<SongType> showAll(){
		hp=new DBHelp();
		List<SongType> list=new ArrayList<>();
		String sql="select * from songtype";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new SongType(rs.getInt(1), rs.getString(2)));
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
	//查看一个
	public SongType showOne(String stid){
		SongType st=null;
		hp=new DBHelp();
		String sql="select * from songtype where stid=?";
		try {
			ResultSet rs=hp.query(sql, stid);
			if(rs.next()){
				st=new SongType(rs.getInt(1), rs.getString(2));
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
		return st;
	}
	

}
