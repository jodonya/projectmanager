package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.SignInLogDao;
import com.asal.projectmanager.domain.SignInLog;
import com.asal.projectmanager.service.SignInLogService;

@Service
public class SignInLogServiceImp implements SignInLogService {
	
	@Autowired
	SignInLogDao signInLogDao;

	@Transactional
	public void add(SignInLog signInLog) {
		signInLogDao.save(signInLog);
	}

	@Transactional
	public List<SignInLog> findAll() {
		return signInLogDao.findAll();
	}

	@Transactional
	public SignInLog findById(Long id) {
		return signInLogDao.findOne(id);
	}

	@Transactional
	public void remove(SignInLog signInLog) {
		signInLogDao.delete(signInLog);
	}

	@Transactional
	public void update(SignInLog signInLog) {
		signInLogDao.update(signInLog);
	}

	@Transactional
	public Long count() {
		return signInLogDao.count();
	}

}
