package com.demo.service.impl;

import com.demo.dao.IAdminsDao;
import com.demo.po.Admins;
import com.demo.service.IAdminsService;

public class AdminsServiceImpl implements IAdminsService {

	// ×¢ÈëadminsDao
	private IAdminsDao adminsDao;
	
	public void setAdminsDao(IAdminsDao adminsDao) {
		this.adminsDao = adminsDao;
	}

	@Override
	public boolean addAdmin(Admins admin) {
		// TODO Auto-generated method stub		
		return adminsDao.createAdmin(admin);
	}

}
