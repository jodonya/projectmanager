package com.asal.projectmanager.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.domain.AdvertComment;
import com.asal.projectmanager.domain.AdvertPriority;
import com.asal.projectmanager.domain.AdvertRequirement;
import com.asal.projectmanager.domain.AdvertResponsibilty;
import com.asal.projectmanager.domain.AdvertType;
import com.asal.projectmanager.domain.AssignCategory;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.service.AdvertCategoryService;
import com.asal.projectmanager.service.AdvertCommentService;
import com.asal.projectmanager.service.AdvertRequirementService;
import com.asal.projectmanager.service.AdvertResponsibiltyService;
import com.asal.projectmanager.service.AdvertService;
import com.asal.projectmanager.service.AssignCategoryService;
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

	@Autowired
	AssignCategoryService assignCategoryService;
	
	@Autowired
	AdvertCommentService advertCommentService;
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	protected static Logger logger = Logger.getLogger(AdvertController.class);

	
	@RequestMapping(value = {"/advert"}, method = RequestMethod.GET)
	public String adverts(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("company") Company company, Model model) {

		List<AdvertCategory> listCategory = advertCategoryService.findAll();
		List<Company> listCompany = companyService.findAll();
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);
		return "advert";
	}
	
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String advertListing(
			@ModelAttribute("projectUser") ProjectUser projectUser, Model model) {
		
		List<Company> listCompany = companyService.findAll();
		List<AdvertCategory> listCategory = advertCategoryService.findAll();

		//List<Advert> listAdvert = advertService.findAll();
		List<Advert> listAdvert = advertService.findAllActive();
		model.addAttribute("listAdvert", listAdvert);
		
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);
		
		ProjectUser logedInUser = null;
		
		logedInUser = projectManagerSession.getUser();
		model.addAttribute("logedInUser", logedInUser);

		return "home";
	}
	
	@RequestMapping(value = {"/homeexpired"}, method = RequestMethod.GET)
	public String advertListingExpired(
			@ModelAttribute("projectUser") ProjectUser projectUser, Model model) {
		
		List<Company> listCompany = companyService.findAll();
		List<AdvertCategory> listCategory = advertCategoryService.findAll();

		//List<Advert> listAdvert = advertService.findAll();
		List<Advert> listAdvert = advertService.findAllExpired();
		model.addAttribute("listAdvert", listAdvert);
		
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);
		
		ProjectUser logedInUser = null;
		
		logedInUser = projectManagerSession.getUser();
		model.addAttribute("logedInUser", logedInUser);

		return "home";
	}
	
	//contactus
	@RequestMapping(value = {"/contactus"}, method = RequestMethod.GET)
	public String contactus(
			@ModelAttribute("projectUser") ProjectUser projectUser, Model model) {
		
		List<Company> listCompany = companyService.findAll();
		List<AdvertCategory> listCategory = advertCategoryService.findAll();

		List<Advert> listAdvert = advertService.findAll();
		model.addAttribute("listAdvert", listAdvert);
		
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);
		
		ProjectUser logedInUser = null;
		
		logedInUser = projectManagerSession.getUser();
		model.addAttribute("logedInUser", logedInUser);

		return "contactus";
	}
	
	@RequestMapping(value = "/home/category/{categoryId}", method = RequestMethod.GET)
	public String advertListingByCategory(
			@ModelAttribute("projectUser") ProjectUser projectUser, @PathVariable("categoryId") Long categoryId, Model model) {

		AdvertCategory advertCategory = advertCategoryService.findById(categoryId);
		//Get the Adverts By Category
		//List<Advert> listAdvert = assignCategoryService.findAll(advertCategory); //advertService.findAll();
		List<Advert> listAdvert = assignCategoryService.findAllActive(advertCategory);
		model.addAttribute("listAdvert", listAdvert);
		
		List<Company> listCompany = companyService.findAll();
		List<AdvertCategory> listCategory = advertCategoryService.findAll();

		
		model.addAttribute("advertCategory", advertCategory);
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);

		return "home";
	}
	
	@RequestMapping(value = "/home/company/{companyId}", method = RequestMethod.GET)
	public String advertListingByCompany(
			@ModelAttribute("projectUser") ProjectUser projectUser, @PathVariable("companyId") Long companyId, Model model) {

		//Get Adverts By Company
		Company company = companyService.findById(companyId);
		//List<Advert> listAdvert = advertService.findAll(company);
		List<Advert> listAdvert = advertService.findAllActive(company);
		model.addAttribute("listAdvert", listAdvert);
		
		List<Company> listCompany = companyService.findAll();
		List<AdvertCategory> listCategory = advertCategoryService.findAll();

		model.addAttribute("company", company);
		model.addAttribute("listCompany", listCompany);
		model.addAttribute("listCategory", listCategory);

		return "home";
	}
	

	@RequestMapping(value = "/addetails/{advertId}", method = RequestMethod.GET)
	public String adDetails(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("advertComment") AdvertComment advertComment,
			@PathVariable("advertId") Long advertId, Model model) {

		Advert advert = advertService.findById(advertId);
		List<AdvertRequirement> listRequirement = advertRequirementService
				.findAll(advert);
		List<AdvertResponsibilty> listResponsibility = advertResponsibiltyService
				.findAll(advert);

		model.addAttribute("advert", advert);
		model.addAttribute("listRequirement", listRequirement);
		model.addAttribute("listResponsibility", listResponsibility);
		
		ProjectUser logedInUser = null;
		
		logedInUser = projectManagerSession.getUser();
		model.addAttribute("logedInUser", logedInUser);


		return "addetails";
	}
	
	
	@RequestMapping(value = "/advertcomments/{advertId}", method = RequestMethod.POST)
	public String advertComments(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute("advertComment") AdvertComment advertComment,
			@PathVariable("advertId") Long advertId, Model model
			){
		Advert advert = advertService.findById(advertId);
		
		advertComment.setAdvert(advert);
		advertCommentService.add(advertComment);
		return "redirect:/addetails/"+advertId;
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

		//Get Advert with this advert name
		
		String tweetmessage = "";
		Advert savedAdvert = advertService.findAdvert(advert.getName());
		tweetmessage = "Opening for "+savedAdvert.getName()+" in "+savedAdvert.getCompany()+" \n  check \n ";
		tweetmessage = tweetmessage+" http://tujulishe.com/addetails/"+savedAdvert.getId();
	
		/***
		logger.info("############## SAVED ##### "+savedAdvert.getName());
		logger.info(" ############ Tweet Message "+tweetmessage); ***/
		
		//tweet the message
		tweetTheAdvert(tweetmessage);
		
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
			@ModelAttribute("assignCategory") AssignCategory assignCategory,
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
		assignCategory = new AssignCategory();
		List<AssignCategory> listAssignedCategories = assignCategoryService
				.findAll(advert);

		List<AdvertCategory> advertCategoryList = advertCategoryService
				.findAll();
		model.addAttribute("listResponsibilities", listResponsibilities);
		model.addAttribute("listRequirements", listRequirements);
		model.addAttribute("advertCategoryList", advertCategoryList);
		model.addAttribute("advert", advert);
		model.addAttribute("assignCategory", assignCategory);
		model.addAttribute("listAssignedCategories", listAssignedCategories);

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
		return "redirect:/newdetails/" + advertId;
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
		return "redirect:/newdetails/" + advertId;
	}

	@RequestMapping(value = "/assigncategory/{advertId}", method = RequestMethod.POST)
	public String assigncategory(
			@ModelAttribute("assignCategory") AssignCategory assignCategory,
			@PathVariable("advertId") Long advertId, Model model) {

		Advert advert = advertService.findById(advertId);
		assignCategory.setAdvert(advert);
		
		if (!advert.getCategoryList().equals(null)){
			advert.getCategoryList().add(assignCategory.getAdvertCategory());
		} else{
			List<AdvertCategory> categoryList = new ArrayList<AdvertCategory>();
			categoryList.add(assignCategory.getAdvertCategory());
		}
		advertService.update(advert);

		assignCategoryService.add(assignCategory);

		return "redirect:/newdetails/" + advertId;
	}

	@RequestMapping(value = "/deleteAssignedCategory/{assignedCategoryId}", method = RequestMethod.GET)
	public String assignedCategory(
			
			@ModelAttribute("advertRequirement") AdvertRequirement advertRequirement,
			@ModelAttribute("advertResponsibility") AdvertResponsibilty advertResponsibilty,
			@PathVariable("advertId") Long advertId, 
			@ModelAttribute("assignCategory") AssignCategory assignCategory,
			@PathVariable("assignedCategoryId") Long assignedCategoryId,
			Model model, HttpServletResponse response) {

		assignCategory = assignCategoryService.findById(assignedCategoryId);
		advertId = assignCategory.getAdvert().getId();
		assignCategoryService.removeById(assignedCategoryId);
		
//		Advert advert = advertService.findById(advertId);
//
//		List<AdvertResponsibilty> listResponsibilities = advertResponsibiltyService
//				.findAll(advert);
//		List<AdvertRequirement> listRequirements = advertRequirementService
//				.findAll(advert);
//
//		advertRequirement = new AdvertRequirement();
//		advertResponsibilty = new AdvertResponsibilty();
//		assignCategory = new AssignCategory();
//		List<AssignCategory> listAssignedCategories = assignCategoryService
//				.findAll(advert);
//
//		List<AdvertCategory> advertCategoryList = advertCategoryService
//				.findAll();
//		model.addAttribute("listResponsibilities", listResponsibilities);
//		model.addAttribute("listRequirements", listRequirements);
//		model.addAttribute("advertCategoryList", advertCategoryList);
//		model.addAttribute("advert", advert);
//		model.addAttribute("assignCategory", assignCategory);
//		model.addAttribute("listAssignedCategories", listAssignedCategories);

		return "redirect:/newdetails/" + advertId;
	}
	// assignedCategory/${assignedCategory.id}
	
	private void tweetTheAdvert(String admessage){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("a1pwYTwmfHt9cPE4w8CUg")
		.setOAuthConsumerSecret("op8j3YtE2OTlcyFVQiBiAOckBrki1tnQZN2yfVU0JIY")
		.setOAuthAccessToken("1414712892-Esw3qnEDMaaVdwrJJiQhnMFX3gBRwfbK2CV3LR5")
		.setOAuthAccessTokenSecret("Ty3D8gFHyAbAzymBmR2Npvxo5zaq8k2J0GbWPDQQk");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		try {
			twitter.updateStatus(admessage);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
