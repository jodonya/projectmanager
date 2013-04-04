package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Forum;

@Repository
public class ForumDao extends AbstractJpaDao<Forum> {
	
	protected static Logger logger = Logger.getLogger(ForumDao.class);
	
	
	public ForumDao(){
		setClazz(Forum.class);
	}

}
