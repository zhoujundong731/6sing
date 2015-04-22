package SessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import entity.HibernateTest;

public class MySession {
	
	public boolean test(HibernateTest test){
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=null;
		Transaction transaction = null;
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			session.save(test);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			return false;
		}finally{
			session.close();
		}
		
	}
}
