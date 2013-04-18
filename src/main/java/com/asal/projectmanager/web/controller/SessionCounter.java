package com.asal.projectmanager.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asal.projectmanager.domain.ProjectUser;
@Service
public class SessionCounter implements HttpSessionListener {

	List<String> sessions = new ArrayList<String>();
	private Set<ProjectUser> usersOnline = new HashSet<ProjectUser>();
	
	protected Logger logger = Logger.getLogger(SessionCounter.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public SessionCounter(){
		
	}
	
	public void sessionCreated(HttpSessionEvent event) {
		
		HttpSession session = event.getSession();
		sessions.add(session.getId());
		
		//ProjectUser loggedInUser = (ProjectUser) session.getAttribute("loggedInUser");
		//usersOnline.add(projectManagerSession.getUser());
		//logger.info(" TTTTTTTTTTTTTTT New User will be ::::XXXXXXXXX "+projectManagerSession.getUser());
		
		session.setAttribute("counter", this);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		sessions.remove(session.getId());
		session.setAttribute("counter", this);

	}
	
	public int getActiveSessionNumber(){
		return sessions.size();
	}

	public Set<ProjectUser> getUsersOnline() {
		return usersOnline;
	}

	public void setUsersOnline(Set<ProjectUser> usersOnline) {
		this.usersOnline = usersOnline;
	}
	
	


}
