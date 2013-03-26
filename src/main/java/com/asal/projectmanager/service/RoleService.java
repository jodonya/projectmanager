package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.RoleDao;
import com.asal.projectmanager.domain.Role;

@Service
@Transactional
public class RoleService implements BaseService<Role> {
	
	protected static Logger logger = Logger.getLogger(RoleService.class);
	
	@Autowired
	public RoleDao roleDao;
	
	public List<Role> getAll() {
		return roleDao.findAll();
	}

	public void add(Role role) {
		roleDao.save(role);
	}

	public void delete(Role role) {
		 roleDao.delete(role);
	}

	public Role findOne(Long id) {
		return roleDao.findOne(id);
	}

}
