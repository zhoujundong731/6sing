package test;

import java.util.concurrent.atomic.AtomicLong;

public class test {
	public static void main(String[] args) {
		/*AtomicLong ids=new AtomicLong(100000);
		for (int i = 0; i < 100; i++) {
			System.out.println(ids.getAndIncrement());
		}*/
		int[] ints=new int[10];
		//add aaaa
		try {
			for (int i = 0; i < 11; i++) {
				ints[i]=i;
				System.out.println(ints[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
