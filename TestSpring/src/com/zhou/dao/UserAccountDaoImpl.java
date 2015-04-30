package com.zhou.dao;
import com.zhou.account.bean.UserAccount;

public class UserAccountDaoImpl extends GenericDAOImpl<UserAccount, Long> implements IUserAccountDao{
	@Override
	public UserAccount login(UserAccount account) {
		UserAccount acc=null;
		acc=(UserAccount) this.findUnique("from UserAccount as ua where ua.name=? and ua.password=?", account.getName(),account.getPassword());
		if(acc==null){
			acc=(UserAccount) this.findUnique("from UserAccount as ua where ua.email=? and ua.password=?", account.getEmail(),account.getPassword());
		}
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
