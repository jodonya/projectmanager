package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ForumPost;

@Repository
public class ForumPostDao extends AbstractJpaDao<ForumPost> {

	protected static Logger logger = Logger.getLogger(ForumPostDao.class);
	
	public ForumPostDao(){
		setClazz(ForumPost.class);
	}
}
