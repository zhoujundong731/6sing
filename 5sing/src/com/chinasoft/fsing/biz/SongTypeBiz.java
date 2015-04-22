package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.SongTypeDao;
import com.chinasoft.fsing.vo.SongType;

public class SongTypeBiz {
	private SongTypeDao stdao;

	public SongTypeBiz() {
		stdao=new SongTypeDao();
	}
	//��Ӹ�������
	public boolean addSongType(SongType st){
		boolean flag=false;
		if(stdao.isHave(st.getStname())<1){
			if((stdao.addSongType(st))>0){
				flag=true;
			}
		}
		return flag;
	}
	//ɾ����������
	public boolean delSongType(String stid ){
		boolean flag=false;
		if((stdao.delSongType(stid))>0){
			flag=true;
		}
		return flag;
	}
	//�޸�
	public boolean updateSongType(SongType st){
		boolean flag=false;
		if((stdao.updateSongType(st))>0){
			flag=true;
		}
		return flag;
	}
	//�鿴ȫ��
	public List<SongType> showAll(){
		return stdao.showAll();
	}
	//�鿴һ��
	public SongType showOne(String stid){
		return stdao.showOne(stid);
	}
	//
}
