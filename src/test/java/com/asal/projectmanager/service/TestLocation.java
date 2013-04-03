package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.LocationDao;
import com.asal.projectmanager.domain.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class TestLocation {
	
	@Autowired
	LocationDao locationDao;
	
	@Test
	@Transactional
	public void testAdd(){
		Location location = new Location();
		location.setName("iHub Offices");
		location.setDescription("iHub Offices in Nairobi");
		
		locationDao.save(location);
		
		Assert.assertTrue(locationDao.count() > 0);
	}

}
