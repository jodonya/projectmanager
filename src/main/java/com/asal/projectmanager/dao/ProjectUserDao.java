package com.asal.projectmanager.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ProjectUserDao extends AbstractJpaDao<ProjectUser> {
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	public ProjectUserDao(){
		setClazz(ProjectUser.class);
		setProjectManagerSession(projectManagerSession);
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
