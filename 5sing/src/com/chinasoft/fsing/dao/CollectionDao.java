package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Collection;
import com.chinasoft.fsing.vo.Song;

public class CollectionDao {
	private DBHelp hp;
	//获取用户的收藏
	public List<Collection> showAllCollByUid(String uid){
		hp=new DBHelp();
		List<Collection> list=new ArrayList<>();
		String sql="SELECT c.ctid,c.cttime,s.sid,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM collection AS c INNER JOIN song AS s ON c.sid = s.sid where c.uid="+uid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Collection(rs.getLong(1), rs.getString(2), null, new Song(rs.getLong(3),null, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//删除收藏
	public int delColl(String ctid){
		int temp=-1;
		hp=new DBHelp();
		String sql="delete from collection where ctid="+ctid;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//是否收藏
	public int isColl(String uid,String sid){
		int temp=-1;
		hp=new DBHelp();
		String sql="select count(*) from collection where uid=? and sid=?";
		try {
			ResultSet rs=hp.query(sql, uid,sid);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	//收藏歌曲
	public int addColl(Collection co){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into collection values(?,?,?,?)";
		try {
			temp=hp.update(sql, co.getCtid(),co.getCttime(),co.getUser().getUid(),co.getSong().getSid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
