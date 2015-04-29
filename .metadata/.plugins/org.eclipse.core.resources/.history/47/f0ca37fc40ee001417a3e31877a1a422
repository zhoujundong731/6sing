package test;

import com.zhou.account.bean.UserAccount;
import com.zhou.dao.IUserAccountDao;

public class Persion {
	
	private IHelloMessage message;
	private IUserAccountDao userAccountDao;
	
	public void setUserAccountDao(IUserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}
	public void setMessage(IHelloMessage message) {
		this.message = message;
	}
	public String say(){
		return this.message.sayMessage();
	}
	public void testAdd(){
		UserAccount account=new UserAccount();
		account.setName("spring test");
		Long id=userAccountDao.saveForKey(account);
		System.out.println("ID:"+id);
	}
	
}
