package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import SessionFactory.HibernateSessionFactory;
import SessionFactory.basesession;

import com.zhou.account.bean.Account;
import com.zhou.account.bean.AccountStatus;
import com.zhou.account.bean.AccountTypes;
import com.zhou.account.bean.ManagerAccount;
import com.zhou.account.bean.SingerAccount;
import com.zhou.account.bean.UserAccount;

public class TestMain {
	public static void main(String[] args) {
		
		//hibernate 创建表测试
		Configuration configuration=new Configuration();
		configuration.configure();
		//configuration.addClass(HibernateTest.class);
		SchemaExport export=new SchemaExport(configuration);
		export.create(true, true);
		UserAccount account=new UserAccount();
		ManagerAccount account2=new ManagerAccount();
		SingerAccount account3=new SingerAccount();
		account.setCreateDate(new Date());
		account.setEmail("1187131468@qq.com");
		account.setImage("image");
		account.setName("张三");
		account.setNikeName("doubi");
		account.setPassword("password");
		account.setPhoneNumber(112356656L);
		account.setStatus(AccountStatus.REGISTER.name());
		account.setPresentation("简介");
		account.setSex('男');
		
		account2.setCreateDate(new Date());
		account2.setEmail("1187131468@qq.com");
		account2.setImage("image");
		account2.setName("张三");
		account2.setPhoneNumber("112356656");
		account2.setStatus(AccountStatus.REGISTER.name());
		account2.setSex('男');
		account2.setPower(4);
		
		account3.setCreateDate(new Date());
		account3.setImage("image");
		account3.setName("张三");
		account3.setStatus(AccountStatus.REGISTER.name());
		account3.setSex('男');
		account3.setHeat(0);
		Session session=HibernateSessionFactory.getSession();
		Transaction tra=session.beginTransaction();
		Serializable id= basesession.add(session, account);
		Serializable id2= basesession.add(session, account2);
		Serializable id3= basesession.add(session, account3);
		tra.commit();
		
		System.out.println("userAccount插入主键："+id);
		System.out.println("managerAccount插入主键："+id2);
		System.out.println("SingerAccount插入主键："+id3);
		Query query=session.createQuery("from SingerAccount");
		List<Account> list=query.list();
		for (Account acc : list) {
			System.out.println(acc.toString());
		}
		/*Account acc=new Account("zhangsan", '男', null, AccountTypes.MANAGER.name(), new Date(), AccountStatus.REGISTER.name());
		
		//log4j测试
		Logger logger=Logger.getLogger(TestMain.class);
		for (int i = 0; i < 1000; i++) {
			logger.info("INFO :tset start!!");
			logger.debug("DEBUG :TEST start");
			logger.error("ERROR 信息");
			
		}
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tra=session.beginTransaction();
		Serializable id= basesession.add(session, acc);
		tra.commit();
		System.out.println("插入主键："+id);
		Query query=session.createQuery("from Account");
		List<Account> list=query.list();
		for (Account account : list) {
			System.out.println(account.toString());
		}*/
	}
	public void test(){
		Logger logger=Logger.getLogger(TestMain.class);
		for (int i = 0; i < 1000; i++) {
			logger.info("INFO :tset start!!");
			logger.debug("DEBUG :TEST start");
			logger.error("ERROR 信息");
		}
	}
}
