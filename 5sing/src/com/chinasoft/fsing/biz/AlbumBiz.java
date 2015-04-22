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
	//��ѯʮ��ר��
	public List<Album> getTenAlbums(int num){
		return adao.getTenAlbums(num);
	}
	//�鿴ר��
	public List<Album> showAlbumsByUser(String uid){
		return adao.showAlbumByUser(uid);
	}
	//��ʾȫ��ר��
	public List<Album> showAll(){
		return adao.showAll();
	}
	//���ר��
	public boolean addAlbum(Album album){
		boolean flag=false;
		if(adao.isHave(album.getBname())<1){
			if(adao.addAlbum(album)>0){
				flag=true;
			}
		}
		return flag;
	}
	//ɾ��ר��
	public boolean delAlbum(String bid){
		boolean flag=false;
		if(adao.delAlbum(bid)>0){
			flag=true;
		}
		return flag;
	}
	//�鿴����ר����Ϣ
	public Album showOne(String bid){
		Album album= adao.showOne(bid);
		List<Song> songs=sdao.showSongByBid(bid);
		if(songs!=null){
			album.setSongs(songs);
		}
		return album;
	}
	//�޸�
	public boolean updateAlbum(Album album){
		boolean flag=false;
		if(adao.updateAlbum(album)>0){
			flag=true;
		}
		return flag;
	}


}
