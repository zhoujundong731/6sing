package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Comment;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.User;

public class CommentDao {
	private DBHelp hp;
	//添加评论
	public int addComm(Comment comm){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into comment values(?,?,?,?,?)";
		try {
			temp=hp.update(sql, comm.getCid(),comm.getCtext(),comm.getCtime(),comm.getUser().getUid(),comm.getSong().getSid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//查看评论
	public List<Comment> showCommByUid(String uid){
		hp=new DBHelp();
		List<Comment> list=new ArrayList<>();
		String sql="SELECT c.cid,c.ctext, c.ctime,s.sid,s.sname FROM `comment` AS c INNER JOIN song AS s ON c.sid = s.sid where c.uid="+uid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Comment(rs.getLong(1), rs.getString(2), rs.getString(3), null, new Song(rs.getLong(4), rs.getString(5))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	//查看歌曲的评论
	public List<Comment> showCommBySid(String sid){
		hp=new DBHelp();
		List<Comment> list=new ArrayList<>();
		String sql="SELECT c.cid,c.ctext,c.ctime,u.uid,u.uname,s.sid, s.sname FROM `comment` AS c INNER JOIN song AS s ON c.sid = s.sid INNER JOIN `user` AS u ON c.uid = u.uid where c.sid="+sid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Comment(rs.getLong(1), rs.getString(2), rs.getString(3),new User(rs.getInt(4), rs.getString(5)), new Song(rs.getLong(6), rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
