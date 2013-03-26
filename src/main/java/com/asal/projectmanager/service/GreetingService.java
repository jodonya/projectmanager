package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.GreetingDao;
import com.asal.projectmanager.domain.Greeting;

@Service
@Transactional
public class GreetingService {
	protected static Logger logger = Logger.getLogger(GreetingService.class);	
	
	@Autowired
	public GreetingDao greetingDao;

	public List<Greeting> getAllGreetings(){
		return greetingDao.getAllGreetings();
	}
	
	public void addGreeting(Greeting greeting){
		greetingDao.addGreeting(greeting);
	}
}
