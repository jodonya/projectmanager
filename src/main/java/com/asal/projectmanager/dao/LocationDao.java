package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Location;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

/****
 * @author japheth
 * 
 * Location Dao for persisting locations
 * 
 * */

@Repository
public class LocationDao extends AbstractJpaDao<Location> {
	protected static Logger logger = Logger.getLogger(LocationDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;


	public LocationDao(){
		setClazz(Location.class);
		setProjectManagerSession(projectManagerSession);
	}
}
