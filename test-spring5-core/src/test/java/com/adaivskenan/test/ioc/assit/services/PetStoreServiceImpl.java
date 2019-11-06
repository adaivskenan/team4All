package com.adaivskenan.test.ioc.assit.services;

import com.adaivskenan.test.ioc.assit.dao.jpa.JpaAccountDao;
import com.adaivskenan.test.ioc.assit.dao.jpa.JpaItemDao;

public class PetStoreServiceImpl {

	private JpaAccountDao accountDao;
	
	private JpaItemDao itemDao;

	public JpaAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(JpaAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public JpaItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(JpaItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
}
