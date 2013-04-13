package com.asal.projectmanager.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.PostCommentDao;
import com.asal.projectmanager.domain.ForumPost;
import com.asal.projectmanager.domain.Notification;
import com.asal.projectmanager.domain.NotificationLog;
import com.asal.projectmanager.domain.NotificationType;
import com.asal.projectmanager.domain.NotifieeType;
import com.asal.projectmanager.domain.PostComment;

@Service
@Transactional
public class NotifierServiceImp implements NotifierService {

	protected static Logger logger = Logger.getLogger(NotifierServiceImp.class);

	@Autowired
	private NotificationService notificationService;

	// @Autowired
	// private NotifierService notifierService;

	@Autowired
	PostCommentDao postCommentDao;

	@Autowired
	NotificationLogService notificationLogService;

	@Autowired
	SendMail sendMail;

	public void sendNotification(PostComment postComment) {

		logger.info(" DDDDDDDDDD Just Started !!!!");
		Set<Notification> listOfNotifications = null;
		// listOfNotifications = new ArrayList<Notification>();

		logger.info(" Passed in ID is  !!!!" + postComment);
		listOfNotifications = this.getNotificationList(postComment);

		// Make this concurrent
		for (Notification notification : listOfNotifications) {
			logger.info(" ZZZZZZ Sending now to "
					+ notification.getReceipient());
			sendNotification(notification);
			logger.info(" ZZZZZZ Sent to  " + notification.getReceipient());

		}
	}

	/****
	 * 
	 * Send Notification means , take a notification - fill the message, fill
	 * the subject, the source and send the mail
	 * 
	 * */
	public synchronized void sendNotification(Notification notification) {
		// SendMail sendMail = new SendMail();
		logger.info("BBBBBBBZZZZZZZZZZZZZZZ sending for "
				+ notification.getReceipient());
		String mailMessage;
		String mailSubject;
		NotificationLog notificationLog;

		if (notification.getNotifieeType().equals(NotifieeType.POSTER)) {
			mailMessage = notification.getSource() + " commented on your post ";
			mailSubject = mailMessage;
		} else {

			if (notification.getSource().equals(notification.getPostedBy())) {
				mailMessage = notification.getSource() + " also commented on "
						+ " his post";
			} else {
				mailMessage = notification.getSource() + " also commented on "
						+ notification.getPostedBy() + " \'s post";
			}

			mailSubject = mailMessage;
		}

		notification.setMessage(mailMessage);
		notification.setIsSent(true);
		notification.setWhenSent(new Timestamp(Calendar.getInstance()
				.getTimeInMillis()));

		sendMail.send(notification.getReceipient().getEmail(), mailSubject,
				mailMessage);

		// I will be returning the notification as the result
		// notificationService.add(notification);
		// ////notification =
		// notificationService.addSaveReturnEntity(notification);

		// notificationService.add(notification);
		// notification = notificationService.findOne(notificationId);
		// Log what has happened

		// notificationLog = new NotificationLog();
		// notificationLog.setMessage(mailMessage);
		// notificationLog.setTo(notification.getReceipient());
		// notificationLog.setNotification(notification);

		logger.info("LOGLOG --- Before add long !!!!!!!1");
		// notificationL
		// notificationLogService.add(notificationLog);

		logger.info("BBBBBBBZZZZZZZZZZZZZZZ sent for "
				+ notification.getReceipient());

	}

	public synchronized Set<Notification> getNotificationList(
			PostComment postComment) {

		logger.info("LLLLLLLLLL getting notification list  !!!!!!");

		// Set<ProjectUser> usersSet = new HashSet<ProjectUser>();
		Set<Notification> notificationList = new HashSet<Notification>(); // new
																			// ArrayList<Notification>();
		Notification notification;
		logger.info("CID comment ID is   " + postComment);

		// PostComment postComment = null;
		// postComment = postCommentDao.findOne(commentId);
		logger.info("Have a comment now  " + postComment);

		// Get comments for a given post
		List<PostComment> comments = null;
		ForumPost forumPost = null;
		forumPost = postComment.getForumPost();
		logger.info("PPPPPPPPP CCCCCC to comments given post now ");

		comments = postCommentDao.findAll(forumPost);

		logger.info("CCCCCCCCC comments ngapi???  !!!!!!" + comments.size());

		// Collections.

		// Collections.c

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
				logger.info("XXXXXXXX Added Notify plan for "
						+ oldComment.getCreatedBy());
				notificationList.add(notification);
			}
			// else{
			//
			// logger.info("OOOOOOOOOOOOOO out here !!! ");
			// }

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
			logger.info("XXXXXXXX Added Notify plan for "
					+ forumPost.getCreatedBy());

			notificationList.add(notification);
		}

		return notificationList;
	}
}
