package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ListView;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SongType;

public class SongAndSongtypeDao {
	private DBHelp hp;

	public SongAndSongtypeDao() {
		super();
	}
	//添加歌曲的歌曲类型的详情
	public int add(Song song,SongType st){
		hp=new DBHelp();
		String sql="insert into songandsongtype(sid,stid) values(?,?)";
		int temp=-1;
		try {
			temp=hp.update(sql,song.getSid(),st.getStid());
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
	//通过sid获得歌曲类型
	public List<SongType> searchSTBySid(String sid){
		List<SongType> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="SELECT st.stid,st.stname FROM songtype AS st INNER JOIN songandsongtype AS sst ON sst.stid = st.stid where sst.sid="+sid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new SongType(rs.getInt(1),rs.getString(2) ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//删除全部（通过songID）
	public int delById(String sid){
		hp=new DBHelp();
		String sql="delete from songandsongtype where sid="+sid;
		int temp=-1;
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

}
