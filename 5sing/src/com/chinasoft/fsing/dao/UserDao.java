package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.SubPage;
import com.chinasoft.fsing.vo.User;

public class UserDao {
	private DBHelp hp;

	public UserDao() {
		super();
	}
	//��ѯ��ߵ���
	public User getIndexOneUser(){
		hp=new DBHelp();
		User user=null;
		String sql="select uid,uname,uimage from `user` WHERE upower=0 ORDER BY rand() LIMIT 1";
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				user=new User(rs.getInt(1), rs.getString(2),rs.getString(3) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	//��ѯʮ���û�
	public List<User> getTenUser(User user){
		hp=new DBHelp();
		List<User> list=new ArrayList<>();
		String sql="select uid,uname,uimage from `user` WHERE upower=0 and uid!=? ORDER BY rand() LIMIT 10";
		try {
			ResultSet rs=hp.query(sql, user.getUid());
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3) ) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//��Ƭǽ
		public List<User> getPhoto(int num){
			hp=new DBHelp();
			List<User> list=new ArrayList<>();
			String sql="select uid,uname,usex,uimage,usign from `user` WHERE upower=0 ORDER BY rand() LIMIT "+num;
			try {
				ResultSet rs=hp.query(sql);
				while(rs.next()){
					list.add(new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)) );
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	//��ѯ�û�����
	public int getUserNum(){
		hp=new DBHelp();
		int temp=0;
		String sql="select count(*) from user";
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	//�û���ҳ�Ĳ�ѯͷ����id���˺�
	public User showUserInfoIndex(String uid){
		hp=new DBHelp();
		User user=null;
		String sql=" SELECT uimage,uaccount,uid FROM user WHERE uid="+uid;
		try {
			ResultSet rs=hp.query(sql,uid);
			if(rs.next()){
				user=new User(rs.getString(1), rs.getString(2), rs.getInt(3));
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
		return user;


	}








	//��½
	public User login(String uaccount,String upass){
		String sql="select * from user where uaccount=? and upass=? and upower=0";
		hp=new DBHelp();
		User user=null;
		try {
			ResultSet rs=hp.query(sql, uaccount,upass);
			if(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12));
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
		return user;
	}
	//��ѯ�Ƿ�����û�
	public int search(String uaccount){
		hp=new DBHelp();
		String sql="select count(*) from user where uaccount=?";
		int temp=0;
		try {
			ResultSet rs=hp.query(sql, uaccount);
			if(rs.next()){
				temp=rs.getInt(1);
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
		return  temp;

	}
	//�û�ע��
	public int userRegister(User user){
		String sql="insert into user(uaccount,upass,uemail,uphone,usex) values(?,?,?,?,?)";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql, user.getUaccount(),user.getUpass(),user.getUemail(),user.getUphone(),user.getUsex());
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

	//�������
	public int artRegister(User user){
		String sql="insert into user(uaccount,uname,upass,usex,uimage,usign,upower) values(?,?,?,?,?,?,?)";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql, user.getUname(),user.getUname(),user.getUpass(),user.getUsex(),user.getUimage(),user.getUsign(),user.getUpower());
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
	//ɾ�����ֻ��û�
	public int  del(String uid){
		String sql="delete user from user where uid=?";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql, uid);
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
	//ͨ��id��ȡuser
	public User getOneUserById(String uid){
		String sql="select * from user where uid="+uid;
		hp=new DBHelp();
		User user=null;
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12));
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
		return user;
	}

	//ͨ���û�����ȡID
	public User getOneUserByName(String uname){
		String sql="select * from user where uname=?";
		hp=new DBHelp();
		User user=null;
		try {
			ResultSet rs=hp.query(sql, uname);
			if(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12));
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
		return user;
	}
	//����or����
	public int  lock(String uflag,String uid){
		System.out.println(uflag);
		System.out.println(uid);
		String sql="update user set uflag="+uflag+" where uid="+uid;
		hp=new DBHelp();
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
	//�޸���Ϣ
	public int update(User user){
		String sql="update user set uname=?,uemail=?,uphone=?,uaddress=?,usex=?,uimage=?,usign=? where uid=?";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql,user.getUname(),user.getUemail(),user.getUphone(),user.getUaddress(),user.getUsex(),user.getUimage(),user.getUsign(),user.getUid());
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
	//
	public int updateArt(User user){
		String sql="update user set uname=?,uemail=?,uphone=?,uaddress=?,usex=?,uimage=?,usign=? where uid=?";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql,user.getUname(),user.getUphone(),user.getUaddress(),user.getUsex(),user.getUimage(),user.getUsign(),user.getUid());
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
	//�鿴���е��û���Ϣ
	public List<User> showAllUser(){
		List<User> users=new ArrayList<>();
		String sql="select * from user";
		hp=new DBHelp();
		User user=null;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				users.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12)));
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

		return users;
	}
	//��ҳ
	public List<User> showAllUser(SubPage sub){
		List<User> users=new ArrayList<>();
		String sql="select * from user limit ?,?";
		hp=new DBHelp();
		User user=null;
		try {
			ResultSet rs=hp.query(sql,sub.getStartIndex(),sub.getShowNumber());
			while(rs.next()){
				users.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12)));
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
		return users;
	}

}
