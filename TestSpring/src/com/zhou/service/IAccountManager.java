package com.zhou.service;

import com.zhou.account.bean.ManagerAccount;
import com.zhou.account.bean.SingerAccount;
import com.zhou.account.bean.UserAccount;

public interface IAccountManager {
	public void saveUserAccount(UserAccount account) throws Exception;
	public void saveManagerAccount(ManagerAccount account)throws Exception;
	public void saveSingerAccount(SingerAccount account)throws Exception;
}
