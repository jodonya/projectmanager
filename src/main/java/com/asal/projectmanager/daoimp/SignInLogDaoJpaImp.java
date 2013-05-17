package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.SignInLogDao;
import com.asal.projectmanager.domain.SignInLog;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class SignInLogDaoJpaImp extends AbstractJpaDao<SignInLog> implements
		SignInLogDao {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	

	public SignInLogDaoJpaImp(){
		setClazz(SignInLog.class);
		setProjectManagerSession(projectManagerSession);
	}

}
