
package Text;

import java.util.Random;

import entity.HibernateTest;

public class TestRandom {
	public static void main(String[] args) {
		//HibernateTest test=new HibernateTest();
		Random random=new Random(10);
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(30));
		}
		
	}
}
