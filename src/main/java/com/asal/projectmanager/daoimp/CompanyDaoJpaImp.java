package com.asal.projectmanager.daoimp;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public Company findCompany(String name){
		Company company = null;
		Query q = super.entityManager.createQuery(" SELECT c from  Company c WHERE (c.name = :name) ");
		q.setParameter("name", name);
		
		if (!q.getResultList().isEmpty())
			company = (Company)q.getResultList().get(0);
		
		return company;
	}

}
