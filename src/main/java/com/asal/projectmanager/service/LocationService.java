package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.LocationDao;
import com.asal.projectmanager.domain.Location;

/****
 *@author japheth
 *
 * Location Service
 **/
@Service
@Transactional
public class LocationService implements BaseService<Location> {
	
	protected static Logger logger = Logger.getLogger(LocationService.class);
	
	@Autowired
	public LocationDao locationDao;

	public List<Location> getAll() {
		return locationDao.findAll();
	}

	public void add(Location location) {
		locationDao.save(location);
	}

	public void delete(Location location) {
		 locationDao.delete(location);
	}

	public Location findOne(Long id) {
		return locationDao.findOne(id);
	}

}
