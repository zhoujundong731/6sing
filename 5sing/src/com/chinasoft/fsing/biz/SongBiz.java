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
	//���
	public void addClick(String sid){
		sdao.addClick(sid);
	}
	//����
	public void addDown(String sid){
		sdao.addDown(sid);
	}
	//�ղ�
	public void addCnum(String sid){
		sdao.addCnum(sid);
	}
	//�������
	public List<Song> getTopDown(int num){
		return sdao.getTopDown(num);
	}
	/*�ղ����*/
	public List<Song> getTopCnum(int num){
		return sdao.getTopCnum(num);
	}
	//ԭ������
	public List<Song> getTenSongYuanPai(){
		return sdao.getTenSongYuanPai();
	}
	//ԭ����ѡ
	public List<Song> getTenSongYuanHou(){
		return sdao.getTenSongYuanHou();
	}
	//��������
	public List<Song> getTenSongFanPai(){
		return sdao.getTenSongFanPai();
	}
	//ʮ��ԭ��
	public List<Song> getTenSongYuan(){
		return sdao.getTenSongYuan();
	}
	//ʮ�׷���
	public List<Song> getTenSongFan(){
		return sdao.getTenSongFan();
	}
	//ʮ�����
	public List<Song> getTenSongSui(){
		return sdao.getTenSongSui();
	}
	//ɾ��ר���и���
	public boolean delFromAlbum(String sid){
		boolean flag=false;
		if(sdao.delFromAlbum(sid)>0){
			flag=true;
		}
		return flag;
	}
	
	//��Ӹ������и������ͣ�
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
	//�޸ĸ�����Ϣ
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
	//ɾ������
	public boolean delSong(Song song){
		boolean flag=false;
		//ɾ��song
		if(sdao.delSong(song.getSid()+"")>0){
			flag=true;
		}
		return flag;
	}
	//��ѯ����
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
	//��ѯ����
	public int getAllSongNum(){
		return sdao.getAllSongNum();
	}
	//�鿴���и�����Ϣ
	public List<Song> showAllSong(){
		return sdao.showAllSong();
	}
	//�鿴���и�����Ϣ
		public List<Song> showAllSong(SubPage sub){
			return sdao.showAllSong(sub);
		}
	//�û���ѯ�Լ��ĸ���
	public List<Song> showAllSongByUid(String uid){
		return sdao.showAllSongByUid(uid);
	}

}
