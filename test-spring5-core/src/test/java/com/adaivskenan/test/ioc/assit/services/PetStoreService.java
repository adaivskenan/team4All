package com.adaivskenan.test.ioc.assit.services;

import com.adaivskenan.test.ioc.assit.dao.jpa.JpaAccountDao;
import com.adaivskenan.test.ioc.assit.dao.jpa.JpaItemDao;

public interface PetStoreService {

	JpaAccountDao getAccountDao();

	JpaItemDao getItemDao();

}
