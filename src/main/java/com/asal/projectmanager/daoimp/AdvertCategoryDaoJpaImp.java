package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertCategoryDao;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertCategoryDaoJpaImp extends AbstractJpaDao<AdvertCategory>
		implements AdvertCategoryDao {
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	

	public AdvertCategoryDaoJpaImp(){
		setClazz(AdvertCategory.class);
		setProjectManagerSession(projectManagerSession);
	}

}
