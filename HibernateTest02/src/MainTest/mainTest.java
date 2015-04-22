package MainTest;
import java.io.Serializable;

import SessionFactory.HibernateSessionFactory;
import SessionFactory.basesession;
import entity.HibernateTest;
public class mainTest {
	public mainTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		HibernateTest test=new HibernateTest();
		test.sethAge(100);
		test.sethName("lisi");
		test.sethNum(100000D);
		Serializable a= basesession.add(HibernateSessionFactory.getSession(), test);
		System.out.println(a);
	}
}
