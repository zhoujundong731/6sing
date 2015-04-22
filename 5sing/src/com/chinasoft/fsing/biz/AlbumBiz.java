package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.AlbumDao;
import com.chinasoft.fsing.dao.SongDao;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.Song;

public class AlbumBiz {
	private AlbumDao adao;
	private SongDao sdao;

	public AlbumBiz() {
		adao=new AlbumDao();
		sdao=new SongDao();
	}
	//查询十个专辑
	public List<Album> getTenAlbums(int num){
		return adao.getTenAlbums(num);
	}
	//查看专辑
	public List<Album> showAlbumsByUser(String uid){
		return adao.showAlbumByUser(uid);
	}
	//显示全部专辑
	public List<Album> showAll(){
		return adao.showAll();
	}
	//添加专辑
	public boolean addAlbum(Album album){
		boolean flag=false;
		if(adao.isHave(album.getBname())<1){
			if(adao.addAlbum(album)>0){
				flag=true;
			}
		}
		return flag;
	}
	//删除专辑
	public boolean delAlbum(String bid){
		boolean flag=false;
		if(adao.delAlbum(bid)>0){
			flag=true;
		}
		return flag;
	}
	//查看单个专辑信息
	public Album showOne(String bid){
		Album album= adao.showOne(bid);
		List<Song> songs=sdao.showSongByBid(bid);
		if(songs!=null){
			album.setSongs(songs);
		}
		return album;
	}
	//修改
	public boolean updateAlbum(Album album){
		boolean flag=false;
		if(adao.updateAlbum(album)>0){
			flag=true;
		}
		return flag;
	}


}
