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
import com.asal.projectmanager.domain.ProjectUser;
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
				.createQuery(" from Advert advert WHERE (advert.company = :company) ORDER BY  advert.deadLine ");// .getResultList();
		q.setParameter("company", company);
		return q.getResultList();
	}



	@Transactional
	/****
	 * Get unexpired adverts and for a given company
	 * */
	public List<Advert> findAllActive(Company company) {
		
		//deadLine
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((advert.company = :company) AND (DATE(advert.deadLine) >= CURDATE())) ORDER BY  advert.deadLine ");// .getResultList();
		q.setParameter("company", company);
		return q.getResultList();
	}



	@Transactional
	/****
	 * Get unexpired adverts
	 * */
	public List<Advert> findAllActive() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine) >= CURDATE())) ORDER BY  advert.deadLine ");// .getResultList();
		return q.getResultList();
	}



	@Transactional
	public List<Advert> findAllExpired(Company company) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((advert.company = :company) AND (DATE(advert.deadLine) < CURDATE())) ORDER BY  advert.deadLine ");// .getResultList();
		q.setParameter("company", company);
		return q.getResultList();
	}



	@Transactional
	public List<Advert> findAllExpired() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine) < CURDATE())) ORDER BY  advert.deadLine ");// .getResultList();
		return q.getResultList();
	}



	@Transactional
	public Advert findAdvert(String name) {
		Advert advert = null;
		Query q = super.entityManager.createQuery(" SELECT ad from  Advert ad WHERE (ad.name = :name) ");
		q.setParameter("name", name);
		
		if (!q.getResultList().isEmpty())
			advert = (Advert)q.getResultList().get(0);
		
		return advert;
	}
	
	

}