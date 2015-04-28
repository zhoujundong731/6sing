package sessionfaction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import HibernateDao.UserAccountDaoImpl;

import com.zhou.account.bean.Account;
import com.zhou.account.bean.AccountStatus;
import com.zhou.account.bean.ManagerAccount;
import com.zhou.account.bean.SingerAccount;
import com.zhou.account.bean.UserAccount;
import com.zhou.song.bean.ArtType;
import com.zhou.song.bean.Song;

public class testMain {
	private testThread test;
	private testThread2 test2;
	
	public testMain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
	}
	public void testSession(){
		this.test=new testThread("测试线程1111");
		test2=new testThread2("测试线程2222");
		test2.start();
		test.start();
		
	}
	
	public void testUserTransaction(){
		try {
			UserTransaction tx=(UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			tx.begin();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void test(){
		
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
		account2.setName("张si");
		account2.setPhoneNumber("112356656");
		account2.setStatus(AccountStatus.REGISTER.name());
		account2.setSex('男');
		account2.setPower(4);
		
		account3.setCreateDate(new Date());
		account3.setImage("image");
		account3.setName("张wu");
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
		Query query=session.createQuery("from Account");
		List<Account> list=query.list();
		for (Account acc : list) {
			System.out.println(acc.toString());
		}
	}
	
	public List<Song> searchAccouint(){
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(" from Song s where s.singerId=(select sa.id from SingerAccount sa where sa.name='张wu')");
		return query.list();
	}
	public Long testSaveAccount(){
		SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
		UserAccountDaoImpl dao=new UserAccountDaoImpl(sessionFactory,UserAccount.class);
		return dao.saveForKey(getUserAccount());
	}
	public UserAccount getUserAccount(){
		UserAccount account=new UserAccount();
		account.setCreateDate(new Date());
		account.setEmail("1187131468@qq.com");
		account.setImage("image");
		account.setName("张三sss");
		account.setNikeName("doubi");
		account.setPassword("password");
		account.setPhoneNumber(112356656L);
		account.setStatus(AccountStatus.REGISTER.name());
		account.setPresentation("简介");
		account.setSex('男');
		return account;
	}
	public class testThread implements Runnable{
		private Thread currentThread;
		private String name;
		@Override
		public void run() {
			this.currentThread=Thread.currentThread();
			this.currentThread.setName(name);
			Session session=HibernateSessionFactory.getSession();
			System.out.println(name+"的 hash code"+session.hashCode());
			Transaction transaction=null;
			System.out.println(name+"线程开始！");
			try {
				transaction=session.beginTransaction();
				System.out.println(name+"beginTransaction");
				ArtType type=new ArtType();
				type.setAtId(11111L);
				type.setAtName("测试11111");
				session.save(type);
				transaction.commit();
				System.out.println(name+"transaction.commit");
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				transaction.rollback();
				System.out.println("transaction.rollback");
			} 
			
		}
		public void start(){
			new Thread(this).run();
			
		}
		public testThread(String name) {
			this.name=name;
		}
		
		
	}
	
	public class testThread2 implements Runnable{
		private Thread currentThread;
		private String name;
		@Override
		public void run() {
			this.currentThread=Thread.currentThread();
			this.currentThread.setName(name);
			Session session=HibernateSessionFactory.getSession();
			System.out.println(name+"的 hash code"+session.hashCode());
			Transaction transaction=null;
			System.out.println(name+"线程开始！");
			try {
				transaction=session.beginTransaction();
				System.out.println(name+"beginTransaction");
				Thread.sleep(10000);
				ArtType type=new ArtType();
				type.setAtId(2222L);
				type.setAtName("测试2222222");
				session.save(type);
				transaction.commit();
				System.out.println(name+"transaction.commit");
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				transaction.rollback();
				System.out.println("transaction.rollback");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void start(){
			new Thread(this).run();
			
		}
		public testThread2(String name) {
			this.name=name;
		}
		
		
	}
}
