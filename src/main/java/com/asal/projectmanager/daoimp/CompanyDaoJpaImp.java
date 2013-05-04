package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.CompanyDao;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.web.controller.ProjectManagerSession;


@Repository
public class CompanyDaoJpaImp extends AbstractJpaDao<Company> implements
		CompanyDao {

	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	

	public CompanyDaoJpaImp(){
		setClazz(Company.class);
		setProjectManagerSession(projectManagerSession);
	}

}
