package com.zhou.dao;

import com.zhou.account.bean.ManagerAccount;

public interface IManagerAccountDao extends IGenericDAO<ManagerAccount, Long>{
	public boolean isHaveName(String name);
	public boolean isHaveEmail(String email);
	public ManagerAccount login(ManagerAccount account);
}
