package com.chinasoft.fsing.biz;

import java.io.File;
import java.util.List;

import com.chinasoft.fsing.dao.SongAndSongtypeDao;
import com.chinasoft.fsing.dao.SongDao;
import com.chinasoft.fsing.util.DelUtil;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SongType;
import com.chinasoft.fsing.vo.SubPage;

public class SongBiz {
	private SongDao sdao;
	private SongAndSongtypeDao ssdao;

	public SongBiz() {
		sdao=new SongDao();
		ssdao=new SongAndSongtypeDao();
	}
	//
	public List<Song> searchFrom(String stype,String sname){
		return sdao.searchFrom(stype, sname);
	}
	//点击
	public void addClick(String sid){
		sdao.addClick(sid);
	}
	//下载
	public void addDown(String sid){
		sdao.addDown(sid);
	}
	//收藏
	public void addCnum(String sid){
		sdao.addCnum(sid);
	}
	//下载最多
	public List<Song> getTopDown(int num){
		return sdao.getTopDown(num);
	}
	/*收藏最多*/
	public List<Song> getTopCnum(int num){
		return sdao.getTopCnum(num);
	}
	//原创排行
	public List<Song> getTenSongYuanPai(){
		return sdao.getTenSongYuanPai();
	}
	//原创候选
	public List<Song> getTenSongYuanHou(){
		return sdao.getTenSongYuanHou();
	}
	//翻唱排行
	public List<Song> getTenSongFanPai(){
		return sdao.getTenSongFanPai();
	}
	//十首原创
	public List<Song> getTenSongYuan(){
		return sdao.getTenSongYuan();
	}
	//十首翻唱
	public List<Song> getTenSongFan(){
		return sdao.getTenSongFan();
	}
	//十首随机
	public List<Song> getTenSongSui(){
		return sdao.getTenSongSui();
	}
	//删除专辑中歌曲
	public boolean delFromAlbum(String sid){
		boolean flag=false;
		if(sdao.delFromAlbum(sid)>0){
			flag=true;
		}
		return flag;
	}
	
	//添加歌曲（有歌曲类型）
	public boolean addSong(Song song){
		boolean flag=false;
		if(sdao.isHave(song.getSname())<1){
			if(sdao.addSong(song)>0){
				if(song.getSongtypes()!=null){
					for(SongType st:song.getSongtypes()){
						boolean ff=true;
						if(ssdao.add(song, st)>0){
						}else{
							ff=false;
						}
						if(ff){
							flag=true;
						}else{
							sdao.delSong(song.getSid()+"");
						}
					}
				}
			}
		}

		return flag;
	}
	//修改歌曲信息
	public boolean updateSong(Song song){
		boolean flag=false;
		if(sdao.updateSong(song)>0){
			if(song.getSongtypes()!=null){
				ssdao.delById(song.getSid()+"");
				for(SongType st:song.getSongtypes()){
					ssdao.add(song, st);
				}
				flag=true;
			}else{
				flag=true;
			}
		}
		return flag;
	}
	//删除歌曲
	public boolean delSong(Song song){
		boolean flag=false;
		//删除song
		if(sdao.delSong(song.getSid()+"")>0){
			flag=true;
		}
		return flag;
	}
	//查询歌曲
	public Song showOneSong(String sid){
		List<SongType> songtypes=ssdao.searchSTBySid(sid);
		Song song=null;
		if(sdao.isAlbum(sid)>0){
			song=sdao.showOneAlbum(sid);
			song.setSongtypes(songtypes);
		}else{
			song=sdao.showOneNotAlbum(sid);
			song.setSongtypes(songtypes);
		}
		return song;
	}
	//查询数量
	public int getAllSongNum(){
		return sdao.getAllSongNum();
	}
	//查看所有歌曲信息
	public List<Song> showAllSong(){
		return sdao.showAllSong();
	}
	//查看所有歌曲信息
		public List<Song> showAllSong(SubPage sub){
			return sdao.showAllSong(sub);
		}
	//用户查询自己的歌曲
	public List<Song> showAllSongByUid(String uid){
		return sdao.showAllSongByUid(uid);
	}

}
