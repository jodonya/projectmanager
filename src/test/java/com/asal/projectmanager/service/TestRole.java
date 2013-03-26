package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.RoleDao;
import com.asal.projectmanager.domain.Role;
import com.asal.projectmanager.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath*:applicationContext.xml"})
@Transactional
@ContextConfiguration("/applicationContext.xml")
public class TestRole {
	protected static Logger logger = Logger.getLogger(TestRole.class);
	
//	@Autowired
//	RoleService roleService;
	
	@Autowired
	RoleDao roleDao;
	
	@Test
	@Transactional
	public void testAdd(){
		Role role = new Role();
		role.setName("Technician");
		role.setDescription("Technician");
		
		
		//roleService.add(role);
		logger.info("&&&&&&&&&&&&&&&&&&&&&&About to save a role !");
		roleDao.save(role);
		logger.info("&&&&&&&&&&&&&&&&&&&&&Saved a role !");
		
		role = new Role();
		role.setName("Assistant");
		role.setDescription("Assistant");
		roleDao.save(role);

		role = new Role();
		role.setName("Clerk");
		role.setDescription("Clerk");
		
		roleDao.save(role);

		for (Role arole : roleDao.findAll()) {
			logger.info("&&&&&&&&&&&&&&&&&&&&&Name :: "+arole.getName());
			logger.info("&&&&&&&&&&&&&&&&&&&&&Description :: "+arole.getDescription());
			
			
		}
		
		logger.info("&&&&&&&&&&&&&&&&&&&&&The Number of Roles is "+roleDao.count());
		Assert.assertTrue(roleDao.count() > 0);
	}

}
