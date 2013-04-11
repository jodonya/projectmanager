package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.NotificationDao;
import com.asal.projectmanager.domain.Notification;

@Service
@Transactional
public class NotificationService implements BaseService<Notification> {
	
	@Autowired
	private NotificationDao notificationDao;

	public List<Notification> getAll() {
		return notificationDao.findAll();
	}

	public void add(Notification notification) {
		notificationDao.save(notification);
	}

	public void delete(Notification notification) {
		notificationDao.delete(notification);
	}

	public Notification findOne(Long id) {
		return notificationDao.findOne(id);
	}

}
