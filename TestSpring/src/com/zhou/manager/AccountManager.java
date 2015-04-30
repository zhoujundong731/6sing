package com.zhou.manager;

import com.zhou.account.bean.UserAccount;
import com.zhou.dao.IManagerAccountDao;
import com.zhou.dao.ISingerAccountDao;
import com.zhou.dao.IUserAccountDao;
import com.zhou.vo.PageBean;

public class AccountManager {
	private IUserAccountDao userAccountDao;
	private ISingerAccountDao singerAccountDao;
	private IManagerAccountDao managerAccountDao;
	public void setUserAccountDao(IUserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}
	
	public void setSingerAccountDao(ISingerAccountDao singerAccountDao) {
		this.singerAccountDao = singerAccountDao;
	}

	public void setManagerAccountDao(IManagerAccountDao managerAccountDao) {
		this.managerAccountDao = managerAccountDao;
	}

	public Long saveUserAccountForKey(UserAccount account) throws Exception{
				return this.userAccountDao.saveForKey(account);
	}
	public void saveUserAccount(UserAccount account) throws Exception{
			 userAccountDao.save(account);

	}
	public void update(UserAccount account)throws Exception{
		userAccountDao.update(account);
	}
	public UserAccount find(Long id)throws Exception{
		return userAccountDao.get(id);
	}
	public boolean findIsHaveMail(String mail){
		Long count=userAccountDao.findLong("select count(*) from UserAccount user where user.email=?", mail);
		return count!=0?true:false;
	}
	public boolean findIsHaveName(String name){
		Long count=userAccountDao.findLong("select count(*) from UserAccount user where user.name=?", name);
		Long count2=singerAccountDao.findLong("select count(*) from SingerAccount singer where singer.name=?", name);
		Long count3=managerAccountDao.findLong("select count(*) from ManagerAccount manager where manager.name=?", name);
		return (count+count2+count3)!=0?true:false;
	}
	public PageBean findAllUser(PageBean page){
		return userAccountDao.findAll(page);
	}
	public boolean findIsHaveName2(String name){
		Long count=userAccountDao.findLong("select count(*) from Account user where user.name=?", name);
		return count!=0?true:false;
	}
}
