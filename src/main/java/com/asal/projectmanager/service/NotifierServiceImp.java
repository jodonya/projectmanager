package com.asal.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asal.projectmanager.dao.PostCommentDao;
import com.asal.projectmanager.domain.ForumPost;
import com.asal.projectmanager.domain.Notification;
import com.asal.projectmanager.domain.NotificationLog;
import com.asal.projectmanager.domain.NotificationType;
import com.asal.projectmanager.domain.NotifieeType;
import com.asal.projectmanager.domain.PostComment;
import com.asal.projectmanager.web.controller.SendMail;

@Service
public class NotifierServiceImp implements NotifierService {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	PostCommentDao postCommentDao;
	
	@Autowired
	NotificationLogService notificationLogService;

	public void sendNotification(Long commentId) {

		List<Notification> listOfNotifications = null;
		listOfNotifications = getNotificationList(commentId);


		// Make this concurrent
		for (Notification notification : listOfNotifications) {
			sendNotification(notification);

		}

	}

	/****
	 * 
	 * Send Notification means , take a notification - fill the message, fill
	 * the subject, the source and send the mail
	 * 
	 * */
	public void sendNotification(Notification notification) {
		SendMail sendMail = new SendMail();

		String mailMessage;
		String mailSubject;
		NotificationLog notificationLog;

		if (notification.getNotifieeType().equals(NotifieeType.POSTER)) {
			mailMessage = notification.getSource() + " commented on your post ";
			mailSubject = mailMessage;
		} else {
			mailMessage = notification.getSource() + " also commented on "
					+ notification.getPostedBy() + " \'s post";
			mailSubject = mailMessage;
		}

		
		sendMail.send(notification.getReceipient().getEmail(), mailSubject,
				mailMessage);
		Long notificationId = notificationService.addSaveReturn(notification);
		//notificationService.add(notification);
		notification = notificationService.findOne(notificationId);
		//Log what has happened
		
		notificationLog = new NotificationLog();
		notificationLog.setMessage(mailMessage);
		notificationLog.setTo(notification.getReceipient());
		notificationLog.setNotification(notification);
		
		//notificationL
		notificationLogService.add(notificationLog);

	}

	public List<Notification> getNotificationList(Long commentId) {

		// Set<ProjectUser> usersSet = new HashSet<ProjectUser>();
		List<Notification> notificationList = new ArrayList<Notification>();
		Notification notification;

		PostComment postComment = null;
		postComment = postCommentDao.findOne(commentId);

		// Get comments for a given post
		List<PostComment> comments = null;
		ForumPost forumPost = null;
		forumPost = postComment.getForumPost();
		comments = postCommentDao.findAll(forumPost);

		// Collections.

		for (PostComment oldComment : comments) {

			// The commenting guy should not again receive a notification
			if ((!oldComment.getCreatedBy().equals(postComment.getCreatedBy()))
			// The commenter is not the poster of the forum
					&& (!oldComment.getCreatedBy().equals(
							forumPost.getCreatedBy()))) {

				// usersSet.add(oldComment.getCreatedBy());

				notification = new Notification();

				/***
				 * What to set
				 * 
				 * Receipient Source - who is sending the notification
				 * 
				 * Notifiee Type - PEERCOMMENTER or POSTER NotificationType -
				 * Email for now
				 * 
				 * N
				 * */
				notification.setReceipient(oldComment.getCreatedBy());
				notification.setSource(postComment.getCreatedBy());
				notification.setNotifieeType(NotifieeType.PEERCOMMENTER);
				notification.setNotificationType(NotificationType.MAIL);
				notification.setPostedBy(forumPost.getCreatedBy());
				// notification.set
				notificationList.add(notification);
			}

		}

		// If the commenter is not the poster, then add notification for poster
		if (!postComment.getCreatedBy().equals(forumPost.getCreatedBy())) {
			notification = new Notification();

			/***
			 * What to set
			 * 
			 * Receipient Source - who is sending the notification
			 * 
			 * Notifiee Type - PEERCOMMENTER or POSTER NotificationType - Email
			 * for now
			 * 
			 * N
			 * */
			notification.setReceipient(forumPost.getCreatedBy());
			notification.setSource(postComment.getCreatedBy());
			notification.setNotifieeType(NotifieeType.POSTER);
			notification.setNotificationType(NotificationType.MAIL);
			notification.setPostedBy(forumPost.getCreatedBy());
			// notification.set
			notificationList.add(notification);
		}

		return notificationList;
	}
}
