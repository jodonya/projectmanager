package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Location;

/****
 * @author japheth
 * 
 * Location Dao for persisting locations
 * 
 * */

@Repository
public class LocationDao extends AbstractJpaDao<Location> {
	protected static Logger logger = Logger.getLogger(LocationDao.class);

	public LocationDao(){
		setClazz(Location.class);
	}
}
