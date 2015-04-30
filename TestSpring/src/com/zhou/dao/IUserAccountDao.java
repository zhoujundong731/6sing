package com.zhou.dao;

import com.zhou.account.bean.UserAccount;

public interface IUserAccountDao extends IGenericDAO<UserAccount, Long>{
	public boolean isHaveName(String name);
	public boolean isHaveEmail(String email);
	public UserAccount login(UserAccount account);
}
