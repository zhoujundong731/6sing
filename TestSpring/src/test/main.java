package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.account.bean.UserAccount;
import com.zhou.dao.MenuDaoImpl;
import com.zhou.dao.SubMenuDaoImpl;
import com.zhou.dao.UserAccountDaoImpl;
import com.zhou.manager.AccountManager;
import com.zhou.sing.execeptin.DaoException;
import com.zhou.song.bean.Menu;
import com.zhou.song.bean.SongType;
import com.zhou.song.bean.SubMenu;
import com.zhou.vo.PageBean;


public class main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountManager manager=(AccountManager) ctx.getBean("accountManager");
		UserAccountDaoImpl userDao=(UserAccountDaoImpl) ctx.getBean("userAccountDao");
		MenuDaoImpl menuDao=(MenuDaoImpl) ctx.getBean("menuDao");
		SubMenuDaoImpl submenuDao=(SubMenuDaoImpl) ctx.getBean("subMenuDao");
		
		List<Menu> menus=menuDao.find("from Menu");
		if(menus.size()==0){
			System.out.println("空");
		}
		for(Menu menu:menus){
			System.out.println(menu.toString());
			if(menu.getSubmenus().size()!=0){
				for (SubMenu submenu : menu.getSubmenus()) {
System.out.println(submenu.toString());
				}
			}
		}
/*		List<UserAccount> users=userDao.findAll();
		for (UserAccount userAccount : users) {
			System.out.println(userAccount.toString());
		}*/
		//UserAccount account=null;
		/*UserAccount account=new UserAccount();
		account.setEmail("测试邮箱2222!");
		account.setPassword("张三");
		account=userDao.login(account);
		System.out.println(account.toString());*/
		try {
			/*System.out.println(manager.findIsHaveName("张三"));*/
			/*System.out.println(manager.findIsHaveName2("ceshi"));*/
		}catch(Exception e){
			System.out.println("异常："+e.getMessage());
			e.printStackTrace();
		}
/*		PageBean page=new PageBean();
		System.out.println(page.getCurrentPage());*/
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
/*			Long l=manager.saveUserAccount(account);*/
/*			System.out.println(l);*/
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
