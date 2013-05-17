package com.asal.projectmanager.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AssignCategoryDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.domain.AssignCategory;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AssignCategoryDaoJpaImp extends AbstractJpaDao<AssignCategory>
		implements AssignCategoryDao {
	@Autowired
	ProjectManagerSession projectManagerSession;

	public AssignCategoryDaoJpaImp() {
		setClazz(AssignCategory.class);
		setProjectManagerSession(projectManagerSession);
	}

	@Transactional
	public List<AssignCategory> findAll(Advert advert) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from AssignCategory assign WHERE (assign.advert = :advert) ORDER BY  id DESC ");// .getResultList();
		q.setParameter("advert", advert);
		return q.getResultList();
	}

	@Transactional
	public void removeById(Long Id) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from AssignCategory assign WHERE (id = :id) ");// .getResultList();
		q.setParameter("id", Id);
		q.executeUpdate();

	}

	@Transactional
	public List<Advert> findAll(AdvertCategory advertCategory) {
		EntityManager em = super.entityManager;

		// Query q =
		// entityManager.createQuery("SELECT p FROM Photo p WHERE p.name = :name");//
		// "SELECT p FROM Photo p WHERE p.name = :name";
		// q.setParameter("name", name);

		Query q = em
				.createQuery(" SELECT assign.advert from AssignCategory assign WHERE (assign.advertCategory = :advertCategory) ORDER BY  assign.advert.id DESC ");// .getResultList();
		q.setParameter("advertCategory", advertCategory);
		return q.getResultList();
	}

	@Transactional
	public List<Advert> findAllActive(AdvertCategory advertCategory) {
		EntityManager em = super.entityManager;

		// Query q =
		// entityManager.createQuery("SELECT p FROM Photo p WHERE p.name = :name");//
		// "SELECT p FROM Photo p WHERE p.name = :name";
		// q.setParameter("name", name);

		Query q = em
				.createQuery(" SELECT assign.advert from AssignCategory assign WHERE ((assign.advertCategory = :advertCategory) AND (DATE(assign.advert.deadLine) >= CURDATE() )) ORDER BY  assign.advert.deadLine ");// .getResultList();
		q.setParameter("advertCategory", advertCategory);
		return q.getResultList();
	}

}
