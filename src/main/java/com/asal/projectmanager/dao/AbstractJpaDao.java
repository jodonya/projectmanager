package com.asal.projectmanager.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.DomainObject;
import com.asal.projectmanager.domain.ForumPost;
import com.asal.projectmanager.web.controller.ProjectManagerSession;


public abstract class AbstractJpaDao <T extends DomainObject> {
	private Class<T> clazz;
	
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	
	public void setProjectManagerSession(ProjectManagerSession projectManagerSession){
		this.projectManagerSession = projectManagerSession;
	}
	
	
	public void setClazz(final Class<T> classToSet){
		this.clazz = classToSet;
	}

	@Transactional
	public T findOne(final Long id){
		
		T entity = entityManager.find(clazz, id);
		entityManager.flush();
		entityManager.refresh(entity);
		return entity;//entityManager.find(clazz, id);
	}
	
	@Transactional
	public List<T> findAll(){
		return entityManager.createQuery(" from "+clazz.getName()+" ORDER BY id DESC ").getResultList();
	}
	
	
	@Transactional
	public void save(final T entity){
		//entityManager.persist(entity);
		entity.setCreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		entity.setIsactive("Y");
		entity.setCreatedBy(projectManagerSession.getUser());
		//entity.setCreatedBy(ProjectManagerSession.getUser());
		entityManager.merge(entity);
		entityManager.flush();
	}
	
	//@Transactional
	public Long saveReturnId(final T entity){
		//entityManager.persist(entity);
		entity.setCreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		entity.setIsactive("Y");
		entity.setCreatedBy(projectManagerSession.getUser());
		//entity.setCreatedBy(ProjectManagerSession.getUser());
		
		entityManager.persist(entity);
		entityManager.flush();
//		entityManager.getTransaction().commit();
		//entityManager.
		return entity.getId();
	}
	
	public T saveReturnEntity(final T entity){
		//entityManager.persist(entity);
		entity.setCreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		entity.setIsactive("Y");
		entity.setCreatedBy(projectManagerSession.getUser());
		//entity.setCreatedBy(ProjectManagerSession.getUser());
		
		entityManager.persist(entity);
		entityManager.flush();
//		entityManager.getTransaction().commit();
		//entityManager.
		return entity;
	}
	
	@Transactional
	public void update(final T entity){
		entity.setUpdated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		entity.setUpdatedBy(projectManagerSession.getUser());
		//entity.setUpdatedBy(ProjectManagerSession.getUser());
		entityManager.merge(entity);
	}
	
	
	
	@Transactional
	public void delete(final T entity){
		entityManager.remove(entity);
	}
	
	@Transactional
	public void deleteById(final Long entityId){
		final T entity = findOne(entityId);
		delete(entity);
	}
	
	@Transactional
	public Long count(){
		//return entityManager.
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(clazz)));
		//cq.where(/*your stuff*/);
		return entityManager.createQuery(cq).getSingleResult();
	}
	
	 protected List<T> listByPage(ForumPost forumPost, Class<T> clazz, int firstResult, int maxResult) {
	        String strQry = "from " + clazz.getName() + " c WHERE c.forumPost = :forumPost order by c.id desc";

	        Query query = entityManager.createQuery(strQry);
	        		//this.sessionFactory.getCurrentSession().createQuery(strQry);
			query.setParameter("forumPost", forumPost);
	        query.setFirstResult(firstResult);
	        query.setMaxResults(maxResult);

	        return query.getResultList();
	    }

	    protected Long countAll(ForumPost forumPost, Class<T> clazz) {
	       // Long entity = null;
	        List<Long> entityList = null;
	        String strQry = "select count(id) from " + clazz.getName()+ " c WHERE c.forumPost = :forumPost ";
	       
	        Query query = entityManager.createQuery(strQry);
	        query.setParameter("forumPost", forumPost);
	        
	        entityList = query.getResultList();

	        Long count = 0L;
	        
	        if (entityList != null)
	        	count = entityList.get(0);
	        return count;
	    }
}
