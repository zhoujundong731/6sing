package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class tsetLoader {
	public static void main(String[] args) {
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		//loader.loadClass(Class.f)
		try {
			Class bean = Class.forName("test.user");
			Object obj=bean.newInstance();
			Class clazz=loader.loadClass("test.user");
			Constructor con=clazz.getConstructor((Class[])null);
			Method[] method= clazz.getMethods();
			for (int i = 0; i < method.length; i++) {
				method[i].invoke(con, "aaa");
			}
			System.out.println(con.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
