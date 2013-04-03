package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.UserRoleDao;
import com.asal.projectmanager.domain.UserRole;

@Service
@Transactional
public class UserRoleService implements BaseService<UserRole> {

	
	@Autowired
	public UserRoleDao userRoleDao;
	
	public List<UserRole> getAll() {
		return userRoleDao.findAll();
	}

	public void add(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	public void delete(UserRole userRole) {
		userRoleDao.delete(userRole);
	}

	public UserRole findOne(Long id) {
		return userRoleDao.findOne(id);
	}

}
