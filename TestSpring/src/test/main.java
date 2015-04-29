package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.account.bean.UserAccount;
import com.zhou.service.AccountManager;
import com.zhou.sing.execeptin.DaoException;


public class main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountManager manager=(AccountManager) ctx.getBean("accountManager");
		UserAccount account=null;
		try {
			account=manager.find(4L);
			account.setId(7L);
			account.setEmail("测试邮箱2222!");
			account.setName("ceshi22222222");
			manager.update(account);
		}catch(Exception e){
			System.out.println("异常："+e.getMessage());
			e.printStackTrace();
		}
		System.out.println(account.toString());
		
		/*main main=new main();
		boolean flag=true;
		try {
			flag=main.add();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(flag);*/
		/*UserAccount account=new UserAccount();
		account.setName("ceshi");
		boolean flag = true;
		try {

			flag = manager.saveUserAccount(account);
		} catch (Exception e) {
			System.out.println("just for exception!"+flag);
		}

		if(manager.saveUserAccount(account)){
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}
		System.out.println("结束");*/
	}
	public boolean add(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountManager manager=(AccountManager) ctx.getBean("accountManager");
		
		try {
			/*manager.saveUserAccount();*/
			UserAccount account=new UserAccount();
			account.setName("ceshi");
			Long l=manager.saveUserAccount(account);
			System.out.println(l);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
