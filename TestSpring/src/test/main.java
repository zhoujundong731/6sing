package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.service.AccountManager;


public class main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountManager manager=(AccountManager) ctx.getBean("userAccountManager");
		manager.saveUserAccount();

	}

}