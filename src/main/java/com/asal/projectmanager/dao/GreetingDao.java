package com.asal.projectmanager.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.Greeting;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
@Transactional
public class GreetingDao extends AbstractJpaDao<Greeting> {
	//protected static Logger logger = Logger.getLogger("GreetingDao");
	protected static Logger logger = Logger.getLogger(GreetingDao.class);
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	
	public GreetingDao(){
		setClazz(Greeting.class);
		setProjectManagerSession(projectManagerSession);
	}
	
	

	@Transactional
	public List<Greeting> getAllGreetings(){
		//Session session = sessionFactory.getCurrentSession();
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//Query q = entityManager.createQuery("select g from Greeting g order by id desc");
		//Query q = session.createQuery("select g from Greeting g order by id desc");
		//List<Greeting> greetingList = q.list();
		
//		
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Query q = em.createQuery("select g from Greeting g order by id desc");
//		List<Greeting> greetingList = q.getResultList();
		
		return findAll();
	}
	
	
	@Transactional
	public void addGreeting(Greeting greeting){
////		JpaTemplate template = getJpaTemplate();
//		EntityManager em = entityManagerFactory.createEntityManager();
////		template.merge(greeting);
//		em.merge(greeting);
////		template.flush();
		save(greeting);
	}
}
