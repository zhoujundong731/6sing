package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.ArtTypeDao;
import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.ArtType;

public class ArtTypeBiz {
	private ArtTypeDao adao;

	public ArtTypeBiz() {
		adao=new ArtTypeDao();
	}
	//��Ӹ�������
	public boolean addArtType(ArtType arttype){
		boolean flag=false;
		if(adao.isHave(arttype.getAtname())<1){
			if(adao.addArtType(arttype)>0){
				flag=true;
			}
		}
		return flag;
	}
	//�޸ĸ�������
	public boolean updateArtType(ArtType arttype){
		boolean flag=false;
		if(adao.updateArtType(arttype)>0){
			flag=true;
		}
		return flag;
	}
	//ɾ����������
	public boolean delArtType(String atid){
		boolean flag=false;
		if(adao.delArtType(atid)>0){
			flag=true;
		}
		return flag;
	}
	//�鿴ȫ��
	public List<ArtType> showAll(){
		return adao.showAll();
	}
	//�鿴һ����ͨ��ID��
	public ArtType showOne(String atid){
		return adao.showOne(atid);
	}
}
