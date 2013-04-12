package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asal.projectmanager.dao.NotificationLogDao;
import com.asal.projectmanager.domain.NotificationLog;

@Service
public class NotificationLogServiceImp implements NotificationLogService {

	
	@Autowired
	private NotificationLogDao notificationLogDao;
	
	
	public List<NotificationLog> getAll() {
		return notificationLogDao.findAll();
	}

	public void add(NotificationLog notificationLog) {
		notificationLogDao.save(notificationLog);
	}

	public void delete(NotificationLog notificationLog) {
		notificationLogDao.delete(notificationLog);

	}

	public NotificationLog findOne(Long id) {
		return notificationLogDao.findOne(id);
	}

}
