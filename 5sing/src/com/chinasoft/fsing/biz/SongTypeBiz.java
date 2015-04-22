package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.SongTypeDao;
import com.chinasoft.fsing.vo.SongType;

public class SongTypeBiz {
	private SongTypeDao stdao;

	public SongTypeBiz() {
		stdao=new SongTypeDao();
	}
	//添加歌曲类型
	public boolean addSongType(SongType st){
		boolean flag=false;
		if(stdao.isHave(st.getStname())<1){
			if((stdao.addSongType(st))>0){
				flag=true;
			}
		}
		return flag;
	}
	//删除歌曲类型
	public boolean delSongType(String stid ){
		boolean flag=false;
		if((stdao.delSongType(stid))>0){
			flag=true;
		}
		return flag;
	}
	//修改
	public boolean updateSongType(SongType st){
		boolean flag=false;
		if((stdao.updateSongType(st))>0){
			flag=true;
		}
		return flag;
	}
	//查看全部
	public List<SongType> showAll(){
		return stdao.showAll();
	}
	//查看一个
	public SongType showOne(String stid){
		return stdao.showOne(stid);
	}
	//
}
