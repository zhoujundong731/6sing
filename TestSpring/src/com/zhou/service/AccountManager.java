package com.zhou.service;
import org.hibernate.AssertionFailure;

import com.zhou.account.bean.ManagerAccount;
import com.zhou.account.bean.UserAccount;
import com.zhou.dao.ISongTypeDao;
import com.zhou.dao.IUserAccountDao;
import com.zhou.sing.execeptin.DaoException;
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
	public void saveUserAccount() throws Exception{
				SongType songType=new SongType();
				songType.setStName("测试歌曲类型4");
				UserAccount account=new UserAccount();
				account.setName("测试用户4"); 
				Long sid=this.songTypeDao.saveForKey(songType);
				System.out.println("歌曲类型ID："+sid);
				Long uId=this.userAccountDao.saveForKey(account);
				System.out.println("歌手ID："+uId);
	}
	public Long saveUserAccount(UserAccount account) throws Exception{
			return userAccountDao.saveForKey(account);

	}
	public void update(UserAccount account)throws Exception{
		userAccountDao.save(account);
	}
	public UserAccount find(Long id)throws Exception{
		return userAccountDao.get(id);
	}
}
