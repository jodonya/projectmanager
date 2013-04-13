package com.asal.projectmanager.service;

import java.util.Set;

import com.asal.projectmanager.domain.Notification;
import com.asal.projectmanager.domain.PostComment;

public interface NotifierService {
	
	public void sendNotification(PostComment postComment);
	public Set<Notification> getNotificationList(PostComment postComment);
	public void sendNotification(Notification notification);

}
