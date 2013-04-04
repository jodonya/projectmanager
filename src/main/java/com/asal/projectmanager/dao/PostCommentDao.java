package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.PostComment;

@Repository
public class PostCommentDao extends AbstractJpaDao<PostComment> {
	
	protected static Logger logger = Logger.getLogger(PostCommentDao.class);
	
	public PostCommentDao(){
		setClazz(PostComment.class);
	}

}
