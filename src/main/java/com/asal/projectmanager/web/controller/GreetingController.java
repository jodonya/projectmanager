package com.asal.projectmanager.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asal.projectmanager.domain.Color;
import com.asal.projectmanager.domain.Greeting;
import com.asal.projectmanager.service.GreetingService;
import com.asal.projectmanager.web.form.GreetingForm;

@Controller
public class GreetingController {
	protected static Logger logger = Logger.getLogger(GreetingController.class);	
	private GreetingService greetingService;
	
	@Autowired
	public GreetingController(GreetingService greetingService){
		this.greetingService = greetingService;
	}

	// define the same url with GET so users can skip to the greetings page
	// note there is no actual greetings.html file!!
	@RequestMapping(value = { "/addgreeting.html" }, method = RequestMethod.GET)
	public String showAddGreetingPage(
			@ModelAttribute("greetingForm") GreetingForm greetingForm,
			Map<String, Object> model) {

		logger.info(" Entering showAllGreetings ! ");

		// model.put("greetingText", greetingText);
		// This will resolve to /WEB-INF/jsp/greetings.jsp
		return "addgreeting";
	}

	@ModelAttribute("colorList")
	public List<Color> populateColorList() {
		// color list is hardcoded for now...
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(new Color("Indian Red", "F75D59"));
		colorList.add(new Color("Red", "FF0000"));
		colorList.add(new Color("Salmon", "F9966B"));
		colorList.add(new Color("Lemon Chiffon", "FFF8C6"));
		colorList.add(new Color("Olive Green", "BCE954"));
		colorList.add(new Color("Steel Blue", "C6DEFF"));
		colorList.add(new Color("Medium Purple", "9E7BFF"));
		return colorList;
	}

	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String addGreetingAndShowAll(
			@ModelAttribute("greetingForm") GreetingForm greetingForm,
			Map<String, Object> model) {
		logger.info(" Entering addGreetingAndShowAll");

		Greeting greeting = greetingForm.getGreeting();
		greeting.setGreetingDate(new Date());
		greetingService.addGreeting(greeting);
		
		List<Greeting> greetings = greetingService.getAllGreetings();
		model.put("greetingList", greetings);
		
		
		model.put("greeting", greeting);
		String selectedColorCode = greetingForm.getColor().getColorCode();
		if (selectedColorCode.equals(""))
			selectedColorCode = "FFFFFF";
		model.put("colorcode", selectedColorCode);
		// This will resolve to /WEB-INF/jsp/addgreeting.jsp
		return "greetings";
	}

	// define the same url with GET so users can skip to the greetings page
	@RequestMapping(value = "/greetings.html", method = RequestMethod.GET)
	public String showAllGreetings(Map<String, Object> model) {

		logger.info("entering showAllGreetings");

		List<Greeting> greetings = greetingService.getAllGreetings();
		model.put("greetingList", greetings);
		model.put("colorcode", "FFFFFF");

		// This will resolve to /WEB-INF/jsp/greetings.jsp
		return "greetings";
	}

	


}
