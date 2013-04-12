package com.asal.projectmanager.service;

import java.util.List;

import com.asal.projectmanager.domain.Notification;


public interface NotificationService extends BaseService<Notification> {
	
	public List<Notification> getAll() ;

	public void add(Notification notification) ;
	
	public Long addSaveReturn(Notification notification) ;

	public void delete(Notification notification) ;

	public Notification findOne(Long id) ;
	

}
