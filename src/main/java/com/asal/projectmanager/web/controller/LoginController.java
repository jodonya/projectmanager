package com.asal.projectmanager.web.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.asal.projectmanager.dao.LocationDao;
import com.asal.projectmanager.dao.ProjectDao;
import com.asal.projectmanager.dao.ProjectStatusDao;
import com.asal.projectmanager.dao.ProjectUserDao;
import com.asal.projectmanager.domain.Location;
import com.asal.projectmanager.domain.Project;
import com.asal.projectmanager.domain.ProjectStatus;
import com.asal.projectmanager.domain.ProjectUser;

@Controller
@SessionAttributes({"logedInUser"})
public class LoginController {
	
	protected static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	ProjectUserDao projectUserDao;
	@Autowired
	ProjectStatusDao projectStatusDao;
	@Autowired
	LocationDao locationDao;
	@Autowired
	ProjectDao projectDao;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	@Transactional
	public String printWelcome(ModelMap model, Principal principal, @ModelAttribute("projectUser") ProjectUser projectUser) {
 
		logger.info("XXXXXXXXXXXXXXXXX Entering Welcome GET !");
		
		
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		
		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);
		
		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);
		
		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		
		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);
		
		ProjectUser logedInUser = projectUserDao.findUser(name);
		
//		if (logedInUser == null)
//			return "login";
//		
//		logedInUser.setIsLoggedIn(true);
		model.addAttribute("logedInUser", logedInUser);
		

		
		return "index";
 
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.POST)
	@Transactional
	public String WelcomePost(ModelMap model, Principal principal, @ModelAttribute("projectUser") ProjectUser projectUser) {

		logger.info("XXXXXXXXXXXXXXXXX Entering Welcome POST !");

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		
		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);
		
		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);
		
		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		
		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);
		
		ProjectUser logedInUser = projectUserDao.findUser(name);
		
		if (logedInUser == null)
			return "login";
		
		logedInUser.setIsLoggedIn(true);
		model.addAttribute("logedInUser", logedInUser);
		

		
		return "index";
 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.info("XXXXXXXXXXXXXXXXX Entering Login GET !");

		return "login";
 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginSuccess(ModelMap model) {
		logger.info("XXXXXXXXXXXXXXXXX Entering Login POST !");

		return "welcome";
 
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, @ModelAttribute ProjectUser user) {
		model.remove(user);
		//model.put("user", null);
		model.addAttribute("username", "");
		model.addAttribute("logedInUser", new ProjectUser());
		SecurityContextHolder.getContext().setAuthentication(null);
		return "login";
 
	}
}
