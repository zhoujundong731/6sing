package com.zhou.service;
import com.zhou.account.bean.UserAccount;
import com.zhou.dao.ISongTypeDao;
import com.zhou.dao.IUserAccountDao;
import com.zhou.song.bean.SongType;

public class AccountManager {
	private IUserAccountDao userAccountDao;
	private ISongTypeDao songTypeDao;
	public void setSongTypeDao(ISongTypeDao songTypeDao) {
		this.songTypeDao = songTypeDao;
	}
	public void setUserAccountDao(IUserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}
	public void saveUserAccount(){
		try {
			SongType songType=new SongType();
			songType.setStName("测试歌曲类型4");
			UserAccount account=new UserAccount();
			account.setName("测试用户4");
			Long sid=this.songTypeDao.saveForKey(songType);
			System.out.println("歌曲类型ID："+sid);
			Long uId=this.userAccountDao.saveForKey(account);
			System.out.println("歌手ID："+uId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败");
		}

	}
}
