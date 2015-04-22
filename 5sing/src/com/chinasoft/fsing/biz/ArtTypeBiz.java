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
	//添加歌手类型
	public boolean addArtType(ArtType arttype){
		boolean flag=false;
		if(adao.isHave(arttype.getAtname())<1){
			if(adao.addArtType(arttype)>0){
				flag=true;
			}
		}
		return flag;
	}
	//修改歌手类型
	public boolean updateArtType(ArtType arttype){
		boolean flag=false;
		if(adao.updateArtType(arttype)>0){
			flag=true;
		}
		return flag;
	}
	//删除歌手类型
	public boolean delArtType(String atid){
		boolean flag=false;
		if(adao.delArtType(atid)>0){
			flag=true;
		}
		return flag;
	}
	//查看全部
	public List<ArtType> showAll(){
		return adao.showAll();
	}
	//查看一个（通过ID）
	public ArtType showOne(String atid){
		return adao.showOne(atid);
	}
}
