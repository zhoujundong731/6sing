package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.ArtType;

public class ArtTypeDao {
	private DBHelp hp;
	
	
	
	public ArtTypeDao() {
		super();
	}
	//�鿴�Ƿ����(���ǰ)
		public int isHave(String atname){
			int temp=-1;
			hp=new DBHelp();
			String sql="select count(*) from arttype where atname=?";
			try {
				ResultSet rs=hp.query(sql, atname);
				if(rs.next()){
					temp=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return temp;
		}
	//���
	public int addArtType(ArtType arttype){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into arttype(atname) values(?)";
		System.out.println("���һ��!");
		System.out.println("������֣�"+arttype.getAtname());
		try {
			temp=hp.update(sql, arttype.getAtname());
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
	//�޸�
	public int updateArtType(ArtType arttype){
		int temp=-1;
		hp=new DBHelp();
		String sql="update arttype set atname=? where atid=?";
		try {
			temp=hp.update(sql,arttype.getAtname(),arttype.getAtid());
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
	//ɾ��
	public int delArtType(String atid){
		int temp=-1;
		hp=new DBHelp();
		String sql="delete from arttype where atid="+atid;
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
	//�鿴ȫ��
	public List<ArtType> showAll(){
		hp=new DBHelp();
		List<ArtType> list=new ArrayList<>();
		String sql="select * from arttype";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new ArtType(rs.getInt(1), rs.getString(2)));
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
	//�鿴һ��
	public ArtType showOne(String atid){
		hp=new DBHelp();
		ArtType arttype=null;
		String sql="select * from arttype where atid=?";
		try {
			ResultSet rs=hp.query(sql, atid);
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
		return arttype;
	}

}
