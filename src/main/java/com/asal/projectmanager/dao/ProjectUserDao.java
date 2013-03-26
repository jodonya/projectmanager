package com.asal.projectmanager.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.ProjectUser;

@Repository
public class ProjectUserDao extends AbstractJpaDao<ProjectUser> {

	public ProjectUserDao(){
		setClazz(ProjectUser.class);
	}
	
	@Transactional
	public ProjectUser findUser(String email){
		ProjectUser user = null;
		Query q = super.entityManager.createQuery(" SELECT pu from  ProjectUser pu WHERE (pu.email = :userEmail) ");
		q.setParameter("userEmail", email);
		
		if (!q.getResultList().isEmpty())
			user = (ProjectUser)q.getResultList().get(0);
		
		return user;
	}
	

}
