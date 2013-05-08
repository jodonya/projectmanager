package com.asal.projectmanager.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertDaoJpaImp extends AbstractJpaDao<Advert> implements
		AdvertDao {
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	

	public AdvertDaoJpaImp(){
		setClazz(Advert.class);
		setProjectManagerSession(projectManagerSession);
	}



	@Transactional
	public List<Advert> findAll(Company company) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE (advert.company = :company) ORDER BY  id DESC ");// .getResultList();
		q.setParameter("company", company);
		return q.getResultList();
	}

}