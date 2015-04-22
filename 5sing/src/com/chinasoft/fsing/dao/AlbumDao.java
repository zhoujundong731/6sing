package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.User;

public class AlbumDao {
	private DBHelp hp;
	//查询十个专辑
	public List<Album> getTenAlbums(int num){
		hp=new DBHelp();
		List<Album> list=new ArrayList<>();
		String sql="SELECT b.bid,b.bname,b.btext,b.btime,b.bimage,u.uid,u.uname,u.usex,u.uimage,u.usign FROM album AS b INNER JOIN `user` AS u ON b.uid=u.uid order by rand() limit "+num;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new User(rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//查看专辑（通过uid）
	public List<Album> showAlbumByUser(String uid){
		List<Album> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="select * from album where uid="+uid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//添加专辑
	public int addAlbum(Album album){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into album(bname,btext,btime,bimage,uid) values(?,?,?,?,?)";
		try {
			temp=hp.update(sql, album.getBname(),album.getBtext(),album.getBtime(),album.getBimage(),album.getUser().getUid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//删除专辑
	public int delAlbum(String bid){
		int temp=-1;
		hp=new DBHelp();
		String sql="delete from album where bid="+bid;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//修改专辑
	public int updateAlbum(Album album){
		int temp=-1;
		hp=new DBHelp();
		String sql="update album set bname=?,btext=?,bimage=? where bid=?";
		try {
			temp=hp.update(sql, album.getBname(),album.getBtext(),album.getBimage(),album.getBid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//查看是否存在此专辑
	public int isHave(String bname){
		int temp=-1;
		hp=new DBHelp();
		String sql="select count(*) from album where bname=?";
		try {
			ResultSet rs=hp.query(sql, bname);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//查看专辑
	public List<Album> showAll(){
		hp=new DBHelp();
		List<Album> list=new ArrayList<>();
		String sql="SELECT b.bid,b.bname,b.btext,b.btime,b.bimage,u.uid,u.uname,u.usex,u.uimage,u.usign FROM album AS b INNER JOIN `user` AS u ON b.uid=u.uid";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new User(rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//查看专辑详情
	public Album showOne(String bid){
		hp=new DBHelp();
		Album album=null;
		String sql="SELECT b.bid,b.bname,b.btext,b.btime,b.bimage,u.uid,u.uname,u.usex,u.uimage,u.usign FROM album AS b INNER JOIN `user` AS u ON b.uid=u.uid where b.bid="+bid;
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				album=new Album(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new User(rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return album;
	}
}
