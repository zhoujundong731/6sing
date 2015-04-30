package com.zhou.dao;

import com.zhou.account.bean.SingerAccount;

public class SingerAccountDaoImpl extends GenericDAOImpl<SingerAccount,Long> implements
		ISingerAccountDao {
	@Override
	public boolean isHaveName(String name) {
		// TODO Auto-generated method stub
		return this.findLong("select count(*) from Account user where user.name=?", name)!=0?true:false;
	}

}
