package com.demo.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.dao.IAdminsDao;
import com.demo.po.Admins;

public class AdminsDaoImpl extends HibernateDaoSupport implements IAdminsDao {

	@Override
	public boolean createAdmin(Admins admin) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(admin);
			return true;
		} catch (RuntimeException ex){
			return false;
		}
	}

}
