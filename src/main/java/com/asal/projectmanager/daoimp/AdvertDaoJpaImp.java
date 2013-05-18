package com.asal.projectmanager.daoimp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
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
	
	protected static Logger logger = Logger.getLogger(AdvertDaoJpaImp.class);
	
	

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


	/***
	 * Grouping Live Adverts by date
	 * **/

	@Transactional
	public List<Advert> getTodayAdverts() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) = DATE(:today) )) ORDER BY  advert.created ");// .getResultList();
		Calendar calToday = Calendar.getInstance();
		Timestamp today = new Timestamp(calToday.getTimeInMillis());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			logger.info("TTTTTTTTTTTTTT Today : " + dateFormat.format(today.getTime()));
		
		
		q.setParameter("today", today);
		//CURDATE()
		return q.getResultList();
	}



	@Transactional
	public List<Advert> getYesterdayAdverts() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) = DATE(:yesterday))) ORDER BY  advert.created ");// .getResultList();
		
		//DATE_ADD(now(), INTERVAL -1 day )
		Calendar calTargetDate = Calendar.getInstance();
		calTargetDate.add(Calendar.DATE, -1);
		Timestamp targetDate = new Timestamp(calTargetDate.getTimeInMillis());
		q.setParameter("yesterday", targetDate);
		
		return q.getResultList();
	}



	@Transactional
	public List<Advert> getPastWeekAdvert() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate)) AND (DATE(advert.created) >= DATE(:endDate))) ORDER BY  advert.created ");// .getResultList();
		
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -1);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
		
		//DATE_ADD(now(), INTERVAL -1 week )
		Calendar calTargetEndDate = Calendar.getInstance();
		calTargetEndDate.add(Calendar.DATE, -7);
		Timestamp targetEndDate = new Timestamp(calTargetEndDate.getTimeInMillis());
		q.setParameter("endDate", targetEndDate);
		return q.getResultList();
	}



	@Transactional
	public List<Advert> getPast2WeeksAdverts() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate)) AND (DATE(advert.created) >= DATE(:endDate))) ORDER BY  advert.created ");// .getResultList();
		
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -7);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
		
		//DATE_ADD(now(), INTERVAL -1 week )
		Calendar calTargetEndDate = Calendar.getInstance();
		calTargetEndDate.add(Calendar.DATE, -14);
		Timestamp targetEndDate = new Timestamp(calTargetEndDate.getTimeInMillis());
		q.setParameter("endDate", targetEndDate);

		return q.getResultList();
	}



	@Transactional
	public List<Advert> getOneMonthOldAdverts() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate)) AND (DATE(advert.created) >= DATE(:endDate))) ORDER BY  advert.created ");// .getResultList();

		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -14);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
		
		//DATE_ADD(now(), INTERVAL -1 week )
		Calendar calTargetEndDate = Calendar.getInstance();
		calTargetEndDate.add(Calendar.MONTH, -1);
		Timestamp targetEndDate = new Timestamp(calTargetEndDate.getTimeInMillis());
		q.setParameter("endDate", targetEndDate);

		return q.getResultList();
	}



	@Transactional
	public List<Advert> getOlderThanOneMonthAdverts() {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate))) ORDER BY  advert.created ");// .getResultList();
		
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.MONTH, -1);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
	
		
		return q.getResultList();
	}



	@Transactional
	public Long getTodayAdvertsCount() {
		Long totalcount = 0L;

		EntityManager em = super.entityManager;
		Query q = em
				.createQuery("SELECT COALESCE(COUNT(advert), 0) as totalcount from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) = CURDATE() )) ORDER BY  advert.created ");// .getResultList();
				
		if (!q.getResultList().isEmpty())
			totalcount = (Long)q.getResultList().get(0);
		
		return totalcount;	
	}


	@Transactional
	public Long getYesterdayAdvertsCount() {
		Long totalcount = 0L;

		EntityManager em = super.entityManager;
		Query q = em
				.createQuery("SELECT COALESCE(COUNT(advert), 0) as totalcount from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) = DATE(:startDate))) ORDER BY  advert.created ");// .getResultList();
				
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -1);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
				
		if (!q.getResultList().isEmpty())
			totalcount = (Long)q.getResultList().get(0);
		
		return totalcount;	
	}


	@Transactional
	public Long getPastWeekAdvertCount() {
		Long totalcount = 0L;

		EntityManager em = super.entityManager;
		Query q = em
				.createQuery("SELECT COALESCE(COUNT(advert), 0) as totalcount from Advert advert  WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate)) AND (DATE(advert.created) >= DATE(:endDate))) ORDER BY  advert.created ");// .getResultList();
		
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -1);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
		
		//DATE_ADD(now(), INTERVAL -1 week )
		Calendar calTargetEndDate = Calendar.getInstance();
		calTargetEndDate.add(Calendar.DATE, -7);
		Timestamp targetEndDate = new Timestamp(calTargetEndDate.getTimeInMillis());
		q.setParameter("endDate", targetEndDate);

		
		if (!q.getResultList().isEmpty())
			totalcount = (Long)q.getResultList().get(0);
		
		return totalcount;	
	}



	@Transactional
	public Long getPast2WeeksAdvertsCount() {
		Long totalcount = 0L;

		EntityManager em = super.entityManager;
		Query q = em
				.createQuery("SELECT COALESCE(COUNT(advert), 0) as totalcount from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate)) AND (DATE(advert.created) >= DATE(:endDate))) ORDER BY  advert.created ");// .getResultList();
			
		
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -7);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
		
		//DATE_ADD(now(), INTERVAL -1 week )
		Calendar calTargetEndDate = Calendar.getInstance();
		calTargetEndDate.add(Calendar.DATE, -14);
		Timestamp targetEndDate = new Timestamp(calTargetEndDate.getTimeInMillis());
		q.setParameter("endDate", targetEndDate);
		
		if (!q.getResultList().isEmpty())
			totalcount = (Long)q.getResultList().get(0);
		
		return totalcount;	
	}



	@Transactional
	public Long getOneMonthOldAdvertsCount() {
		Long totalcount = 0L;

		EntityManager em = super.entityManager;
		Query q = em
				.createQuery("SELECT COALESCE(COUNT(advert), 0) as totalcount from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate)) AND (DATE(advert.created) >= DATE(:endDate))) ORDER BY  advert.created ");// .getResultList();
		
		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.DATE, -14);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);
		
		//DATE_ADD(now(), INTERVAL -1 week )
		Calendar calTargetEndDate = Calendar.getInstance();
		calTargetEndDate.add(Calendar.MONTH, -1);
		Timestamp targetEndDate = new Timestamp(calTargetEndDate.getTimeInMillis());
		q.setParameter("endDate", targetEndDate);

		
		if (!q.getResultList().isEmpty())
			totalcount = (Long)q.getResultList().get(0);
		
		return totalcount;	
	}



	@Transactional
	public Long getOlderThanOneMonthAdvertsCount() {
		Long totalcount = 0L;

		EntityManager em = super.entityManager;
		Query q = em
				.createQuery("SELECT COALESCE(COUNT(advert), 0) as totalcount from Advert advert WHERE ((DATE(advert.deadLine)  >= CURDATE()) AND (DATE(advert.created) < DATE(:startDate))) ORDER BY  advert.created ");// .getResultList();

		Calendar calTargetStartDate = Calendar.getInstance();
		calTargetStartDate.add(Calendar.MONTH, -1);
		Timestamp targetStartDate = new Timestamp(calTargetStartDate.getTimeInMillis());
		q.setParameter("startDate", targetStartDate);

		
		if (!q.getResultList().isEmpty())
			totalcount = (Long)q.getResultList().get(0);
		
		return totalcount;	
	}
	
	

}