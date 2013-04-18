package com.asal.projectmanager.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.validator.internal.metadata.provider.ProgrammaticMetaDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asal.projectmanager.dao.ForumPostDao;
import com.asal.projectmanager.dao.PostCommentDao;
import com.asal.projectmanager.domain.ForumPost;
import com.asal.projectmanager.domain.PostComment;
import com.asal.projectmanager.service.NotifierService;
import com.asal.projectmanager.service.async.CalledBack;
import com.asal.projectmanager.web.paging.PageNavigator;

@Controller
@Scope("session")
public class CommunicationController {

	protected static Logger logger = Logger.getLogger(CommunicationController.class);
	@Autowired
	ProjectManagerSession projectManagerSession;

	@Autowired
	ForumPostDao forumPostDao;
	
	@Autowired
	PostCommentDao postCommentDao;
	
	   @Value("5")
	    private int pageSize;

	    @Value("2")
	    private int pageNavTrail;

	  
	 @Autowired
	 private PageNavigator pageNavigator;
	
	@Autowired
	NotifierService notifierService;
	@Autowired
	CalledBack calledBack;
	
	@Autowired
	SessionCounter sessionCounter;

	@RequestMapping(value = {"/","/posts"}, method = RequestMethod.GET)
	//@RequestMapping(value = {"/posts"}, method = RequestMethod.GET)
	@Transactional
	public String showPosts(@ModelAttribute("forumPost") ForumPost forumPost, @ModelAttribute("postComment") PostComment postComment,
			Map<String, Object> model, HttpSession session) {
		
//		PagedListHolder<ForumPost> forumPostList = new PagedListHolder<ForumPost>(forumPostDao.findAll());
//		forumPostList.setPage(5);
		
		SessionCounter counter = (SessionCounter) session.getAttribute("counter");
		
		
		Integer totalUsers = counter.getActiveSessionNumber();
		
		totalUsers = totalUsers - 1;
		List<ForumPost> forumPostList = forumPostDao.findAll();
		model.put("forumPostList", forumPostList);
		model.put("totalUsers", totalUsers);
		model.put("usersonline", sessionCounter.getUsersOnline());
		model.put("myself", projectManagerSession.getUser());
		
		logger.info(" PPPPPPPPPPPPPPPPPPPPPPP The number of users is PPPPPPPPPPPPPPPPPPPPP  "+sessionCounter.getUsersOnline().size());
		
		return "posts";
	}

	@RequestMapping(value = {"/","/posts"}, method = RequestMethod.POST)
	//@RequestMapping(value = {"/posts"}, method = RequestMethod.POST)
	@Transactional
	public String addPost(@ModelAttribute("forumPost") ForumPost forumPost, @ModelAttribute("postComment") PostComment postComment,
			Map<String, Object> model) {
		forumPostDao.save(forumPost);
		
		forumPost = new ForumPost();
		postComment = new PostComment();

		List<ForumPost> forumPostList = forumPostDao.findAll();
		model.put("forumPostList", forumPostList);
		model.put("forumPost", forumPost);
		model.put("postComment", postComment);
		return "posts";
	}
	
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.POST)
	@Transactional
	public String addPostComment(@ModelAttribute("forumPost") ForumPost forumPost, @ModelAttribute("postComment") PostComment postComment,
			 @PathVariable("postId") Long postId, Map<String, Object> model) {
		
		ForumPost post = forumPostDao.findOne(postId);
		postComment.setForumPost(post);
		
		//postCommentDao.save(postComment);
		Long commentId = postCommentDao.saveReturnId(postComment);
		postComment = postCommentDao.findOne(commentId);
		
		logger.info(" DRAMA - AND COMMENT IS BEFORE WE START "+postComment);
		
		//Sending notifications - this will have to be made asynchronous
		//notifierService.sendNotification(commentId);
		calledBack.setPostComment(postComment);
		calledBack.setUser(postComment.getCreatedBy());
		calledBack.setNotifierService(notifierService);
		calledBack.andAction();
		
		//Left the notifications to deal with themselves
		
		forumPost = new ForumPost();
		postComment = new PostComment();
		List<ForumPost> forumPostList = forumPostDao.findAll();
		model.put("forumPostList", forumPostList);
		
		List<PostComment> postCommentList = postCommentDao.findAll();
		model.put("postCommentList", postCommentList);
		model.put("postComment", postComment);
		model.put("forumPost", forumPost);
		
		return "redirect:/posts";
	}
	
	
	//@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	//@Transactional
	public String chat(Map<String, Object> model) {
		return "mychat";
	}

}
