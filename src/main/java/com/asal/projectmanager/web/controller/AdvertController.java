package com.asal.projectmanager.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.domain.AdvertPriority;
import com.asal.projectmanager.domain.AdvertRequirement;
import com.asal.projectmanager.domain.AdvertResponsibilty;
import com.asal.projectmanager.domain.AdvertType;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.service.AdvertCategoryService;
import com.asal.projectmanager.service.AdvertRequirementService;
import com.asal.projectmanager.service.AdvertResponsibiltyService;
import com.asal.projectmanager.service.AdvertService;
import com.asal.projectmanager.service.CompanyService;

@Controller
public class AdvertController {

	@Autowired
	CompanyService companyService;

	@Autowired
	AdvertCategoryService advertCategoryService;

	@Autowired
	AdvertService advertService;

	@Autowired
	AdvertResponsibiltyService advertResponsibiltyService;
	@Autowired
	AdvertRequirementService advertRequirementService;

	protected static Logger logger = Logger.getLogger(AdvertController.class);

	@RequestMapping(value = "/advert", method = RequestMethod.GET)
	public String adverts(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("company") Company company, Model model) {

		List<AdvertCategory> listCategory = advertCategoryService.findAll();
		List<Company> listCompany = companyService.findAll();
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);
		return "advert";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String advertListing(
			@ModelAttribute("projectUser") ProjectUser projectUser, Model model) {
		
		List<Advert> listAdvert = advertService.findAll();
		model.addAttribute("listAdvert", listAdvert);
		return "home";
	}

	@RequestMapping(value = "/addetails/{advertId}", method = RequestMethod.GET)
	public String adDetails(
			@ModelAttribute("projectUser") ProjectUser projectUser, @PathVariable("advertId") Long advertId, Model model) {
		
		Advert advert = advertService.findById(advertId);
		List<AdvertRequirement> listRequirement = advertRequirementService.findAll(advert);
		List<AdvertResponsibilty> listResponsibility = advertResponsibiltyService.findAll(advert);
		
		model.addAttribute("advert", advert);
		model.addAttribute("listRequirement", listRequirement);
		model.addAttribute("listResponsibility", listResponsibility);
		
		return "addetails";
	}

	@RequestMapping(value = "/advert", method = RequestMethod.POST)
	public String addCompany(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("company") Company company) {
		companyService.add(company);
		return "redirect:/advert";
	}

	@RequestMapping(value = "/addadvert", method = RequestMethod.GET)
	public String addAdvert(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("company") Company company,
			@ModelAttribute("advert") Advert advert,
			@ModelAttribute("category") AdvertCategory category, Model model) {
		// companyService.add(company);
		model.addAttribute("category", category);
		return "addadvert";
	}

	@RequestMapping(value = "/advert/{companyId}", method = RequestMethod.GET)
	public String advert(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("company") Company company,
			@ModelAttribute("advert") Advert advert,
			@PathVariable("companyId") Long companyId,
			@ModelAttribute("category") AdvertCategory category, Model model) {
		// companyService.add(company);
		// @PathVariable("photoId") Long id
		// photoService.removePhoto(id);
		// Get Company Given Id
		List<AdvertCategory> listCategory = advertCategoryService.findAll();
		company = companyService.findById(companyId);
		model.addAttribute("company", company);
		model.addAttribute("category", category);
		model.addAttribute("listCategory", listCategory);

		List<Advert> listAdvert = advertService.findAll(company);
		model.addAttribute("listAdvert", listAdvert);

		return "addadvert";
	}

	@RequestMapping(value = "/advert/{companyId}", method = RequestMethod.POST)
	public String newAdvert(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("company") Company company,
			@ModelAttribute("advert") Advert advert,
			@PathVariable("companyId") Long companyId,
			@ModelAttribute("category") AdvertCategory category, Model model) {
		// companyService.add(company);
		// @PathVariable("photoId") Long id
		// photoService.removePhoto(id);
		// Get Company Given Id
		company = companyService.findById(companyId);
		advert.setAdvertType(AdvertType.JOB);
		advert.setAdvertPriority(AdvertPriority.MEDIUM);
		advert.setCompany(company);

		// Convert Date String to Date
		// String string = "January 2, 2010";
		logger.info(" Original date is " + advert.getTempDeadLine());
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(advert
					.getTempDeadLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(" The Deadline is " + date);
		advert.setDeadLine(date);
		advertService.add(advert);

		List<AdvertCategory> listCategory = advertCategoryService.findAll();
		company = companyService.findById(companyId);

		List<Advert> listAdvert = advertService.findAll(company);

		advert = new Advert();

		model.addAttribute("company", company);
		model.addAttribute("category", category);
		model.addAttribute("advert", advert);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("listAdvert", listAdvert);

		return "redirect:/advert/" + companyId;
	}

	@RequestMapping(value = "/addcategory/{companyId}", method = RequestMethod.POST)
	public String addCategory(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("category") AdvertCategory category,
			@PathVariable("companyId") Long companyId, Model model) {
		// companyService.add(company);

		// , @ModelAttribute("category") AdvertCategory category

		advertCategoryService.add(category);
		Company company = companyService.findById(companyId);

		model.addAttribute("category", category);
		model.addAttribute("company", company);
		return "redirect:/advert/" + companyId;
	}

	@RequestMapping(value = "/newdetails/{advertId}", method = RequestMethod.GET)
	public String newdetails(
			@ModelAttribute("advertRequirement") AdvertRequirement advertRequirement,
			@ModelAttribute("advertResponsibility") AdvertResponsibilty advertResponsibilty,
			@PathVariable("advertId") Long advertId, Model model) {

		Advert advert = advertService.findById(advertId);

		List<AdvertResponsibilty> listResponsibilities = advertResponsibiltyService
				.findAll(advert);
		List<AdvertRequirement> listRequirements = advertRequirementService
				.findAll(advert);

		advertRequirement = new AdvertRequirement();
		advertResponsibilty = new AdvertResponsibilty();

		model.addAttribute("listResponsibilities", listResponsibilities);
		model.addAttribute("listRequirements", listRequirements);
		model.addAttribute("advert", advert);

		return "newdetails";
	}

	@RequestMapping(value = "/addresponsibility/{advertId}", method = RequestMethod.POST)
	public String addresponsibility(
			@ModelAttribute("advertResponsibility") AdvertResponsibilty advertResponsibilty,
			@PathVariable("advertId") Long advertId, Model model) {

		Advert advert = advertService.findById(advertId);
		advertResponsibilty.setAdvert(advert);
		advertResponsibiltyService.add(advertResponsibilty);
		advertResponsibilty = new AdvertResponsibilty();
		model.addAttribute("advertResponsibilty", advertResponsibilty);
		return "redirect:/newdetails/"+advertId;
	}

	@RequestMapping(value = "/addrequirement/{advertId}", method = RequestMethod.POST)
	public String addrequirement(
			@ModelAttribute("advertRequirement") AdvertRequirement advertRequirement,
			@PathVariable("advertId") Long advertId, Model model) {

		Advert advert = advertService.findById(advertId);
		advertRequirement.setAdvert(advert);
		advertRequirementService.add(advertRequirement);
		advertRequirement = new AdvertRequirement();
		model.addAttribute("advertRequirement", advertRequirement);
		return "redirect:/newdetails/"+advertId;
	}

}
