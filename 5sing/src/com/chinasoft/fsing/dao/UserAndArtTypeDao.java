package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.ArtType;
import com.chinasoft.fsing.vo.User;

public class UserAndArtTypeDao {
	private DBHelp hp;

	public UserAndArtTypeDao() {
		super();
	}
	
	//���
	public int add(User user,ArtType at){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into userandarrtype(uid,atid) values(?,?)";
		try {
			temp=hp.update(sql, user.getUid()+"",at.getAtid()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//�鿴�û���������
	public List<ArtType> getArtTypesByUser(String uid){
		List<ArtType> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="SELECT `at`.atid,`at`.atname FROM userandarrtype AS ua INNER JOIN arttype AS `at` ON ua.atid = `at`.atid WHERE ua.uid="+uid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new ArtType(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//ɾ��
	public int delArtTypeByUid(int uid){
		int temp=-1;
		hp=new DBHelp();
		String sql="DELETE from userandarrtype WHERE uid=?";
		try {
			temp=hp.update(sql,uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

}
