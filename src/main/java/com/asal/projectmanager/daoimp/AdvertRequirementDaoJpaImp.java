package com.asal.projectmanager.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertRequirementDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertRequirement;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertRequirementDaoJpaImp extends
		AbstractJpaDao<AdvertRequirement> implements AdvertRequirementDao {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertRequirementDaoJpaImp(){
		setClazz(AdvertRequirement.class);
		setProjectManagerSession(projectManagerSession);
	}

	@Transactional
	public List<AdvertRequirement> findAll(Advert advert) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from AdvertRequirement req WHERE (req.advert = :advert) ORDER BY  id DESC ");// .getResultList();
		q.setParameter("advert", advert);
		return q.getResultList();
	}

}
