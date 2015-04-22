package com.chinasoft.fsing.biz;

import com.chinasoft.fsing.dao.ManagerDao;
import com.chinasoft.fsing.vo.Manager;

public class ManagerBiz {
	private ManagerDao mdao;
	
	public ManagerBiz() {
		mdao=new ManagerDao();
	}
	//��½
	public Manager login(String mname,String mpass){
		return mdao.login(mname, mpass);
	}
	//���
	public boolean addManager(Manager manager){
		boolean flag=false;
		if(mdao.isHave(manager.getMname())<1){
			if(mdao.addManager(manager)>0){
				flag=true;
			}
		}		
		return flag;
	}
	//�޸�
	public boolean updateManager(Manager manager){
		boolean flag=false;
		if(mdao.updateManager(manager)>0){
			flag=true;
		}
		return flag;
	}

}
