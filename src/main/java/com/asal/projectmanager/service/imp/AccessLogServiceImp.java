package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AccessLogDao;
import com.asal.projectmanager.domain.AccessLog;
import com.asal.projectmanager.service.AccessLogService;

@Service
public class AccessLogServiceImp implements AccessLogService {
	
	@Autowired
	AccessLogDao accessLogDao;

	@Transactional
	public void add(AccessLog accessLog) {
		accessLogDao.save(accessLog);
	}

	@Transactional
	public List<AccessLog> findAll() {
		return accessLogDao.findAll();
	}

	@Transactional
	public AccessLog findById(Long id) {
		return accessLogDao.findOne(id);
	}

	@Transactional
	public void remove(AccessLog accessLog) {
		accessLogDao.delete(accessLog);
	}

	@Transactional
	public void update(AccessLog accessLog) {
		accessLogDao.update(accessLog);
	}

	@Transactional
	public Long count() {
		return accessLogDao.count();
	}

}
