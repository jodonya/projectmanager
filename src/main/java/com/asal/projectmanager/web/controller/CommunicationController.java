package com.asal.projectmanager.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@Scope("session")
public class CommunicationController {

	@Autowired
	ProjectManagerSession projectManagerSession;

	@Autowired
	ForumPostDao forumPostDao;
	
	@Autowired
	PostCommentDao postCommentDao;
	
	@Autowired
	NotifierService notifierService;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	@Transactional
	public String showPosts(@ModelAttribute("forumPost") ForumPost forumPost, @ModelAttribute("postComment") PostComment postComment,
			Map<String, Object> model) {

		List<ForumPost> forumPostList = forumPostDao.findAll();
		model.put("forumPostList", forumPostList);
		return "posts";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
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
		
		//Sending notifications - this will have to be made asynchronous
		notifierService.sendNotification(commentId);
		
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
}
