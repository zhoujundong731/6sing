package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.CollectionDao;
import com.chinasoft.fsing.vo.Collection;

public class CollectionBiz {
	private CollectionDao cdao;
	
	public CollectionBiz() {
		cdao=new CollectionDao();
	}

	//��ȡ�û����ղ���Ϣ
	public List<Collection> showAllCollByUid(String uid){
		return cdao.showAllCollByUid(uid);			
	}
	public boolean delColl(String ctid){
		boolean flag=false;
		if(cdao.delColl(ctid)>0){
			flag=true;
		}
		return flag;
	}
	//�Ƿ��ղ�
	public boolean isColl(String uid,String sid){
		boolean flag=false;
		if(cdao.isColl(uid, sid)>0){
			flag=true;
		}
		return flag;
	}
	//�ղظ���
	public boolean addColl(Collection co){
		boolean flag=false;
		if(cdao.addColl(co)>0){
			flag=true;
		}
		return flag;
	}

}
