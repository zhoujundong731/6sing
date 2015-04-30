package com.zhou.dao;

import com.zhou.account.bean.ManagerAccount;

public class ManagerAccountDaoImpl extends GenericDAOImpl<ManagerAccount, Long> implements IManagerAccountDao {


	@Override
	public ManagerAccount login(ManagerAccount account) {
		ManagerAccount acc=null;
		acc=(ManagerAccount) this.findUnique("from ManagerAccount as ma where ma.name=? and ma.password=?", account.getName(),account.getPassword());
		return acc;
	}

	@Override
	public boolean isHaveName(String name) {
		// TODO Auto-generated method stub
		return this.findLong("select count(*) from Account user where user.name=?", name)!=0?true:false;
	}

	@Override
	public boolean isHaveEmail(String email) {
		Long count=this.findLong("select count(*) from UserAccount user where user.email=?", email);
		Long count3=this.findLong("select count(*) from ManagerAccount manager where manager.name=?", email);
		return (count+count3)!=0?true:false;
	}

}
