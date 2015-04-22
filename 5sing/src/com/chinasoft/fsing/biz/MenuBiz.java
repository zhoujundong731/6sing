package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.MenuDao;
import com.chinasoft.fsing.dao.SubMenuDao;
import com.chinasoft.fsing.vo.Manager;
import com.chinasoft.fsing.vo.Menu;
import com.chinasoft.fsing.vo.User;

public class MenuBiz {
	private MenuDao mdao;
	private SubMenuDao smdao;
	public MenuBiz() {
		super();
		mdao=new MenuDao();
		smdao=new SubMenuDao();
	}
	//用户菜单
	public List<Menu> showMenu(User user){
		List<Menu> menus=mdao.showAll(user);
		for(Menu menu:menus){
			menu.setSubmenus(smdao.showAllSub(menu));
		}
		return menus;
	}
	
	//管理员菜单
	public List<Menu> showMenu(Manager manager){
		List<Menu> menus=mdao.showAll(manager);
		for(Menu menu:menus){
			menu.setSubmenus(smdao.showAllSub(menu));
		}
		return menus;
	}

}
