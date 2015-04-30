package com.zhou.dao;

import com.zhou.account.bean.ManagerAccount;
import com.zhou.account.bean.SingerAccount;

public interface ISingerAccountDao extends IGenericDAO<SingerAccount, Long> {
	public boolean isHaveName(String name);
}
