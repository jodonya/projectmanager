package com.asal.projectmanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asal.projectmanager.domain.ProjectUser;

@Controller
public class AdvertController {
	
	@RequestMapping(value="/advert", method=RequestMethod.GET)
	public String adverts(@ModelAttribute("projectUser") ProjectUser projectUser){
		return "advert";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String advertListing(@ModelAttribute("projectUser") ProjectUser projectUser)
	{
		return "home";
	}
	
	@RequestMapping(value="/addetails", method=RequestMethod.GET)
	public String adDetails(@ModelAttribute("projectUser") ProjectUser projectUser){
		return "addetails";
	}
}
