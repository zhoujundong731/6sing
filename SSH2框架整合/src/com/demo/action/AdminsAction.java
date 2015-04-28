package com.demo.action;

import com.demo.po.Admins;
import com.demo.service.IAdminsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings("serial")
public class AdminsAction extends ActionSupport implements ModelDriven<Admins>{

	private Admins admin = new Admins();
	// ×¢ÈëadminsSercie
	private IAdminsService adminsService;
	
	public void setAdmin(Admins admin) {
		this.admin = admin;
	}

	public void setAdminsService(IAdminsService adminsService) {
		this.adminsService = adminsService;
	}

	@Override
	public Admins getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(adminsService.addAdmin(admin)){
			return "addok";
		}else{
			return "adderror";
		}
	}	
}
