package com.asal.projectmanager.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertResponsibiltyDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertResponsibilty;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertResponsibiltyDaoJpaImp extends
		AbstractJpaDao<AdvertResponsibilty> implements AdvertResponsibiltyDao {

	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertResponsibiltyDaoJpaImp(){
		setClazz(AdvertResponsibilty.class);
		setProjectManagerSession(projectManagerSession);
	}

	@Transactional
	public List<AdvertResponsibilty> findAll(Advert advert) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from AdvertResponsibilty resp WHERE (resp.advert = :advert) ORDER BY  id DESC ");// .getResultList();
		q.setParameter("advert", advert);
		return q.getResultList();
	}
	
	
	
}
