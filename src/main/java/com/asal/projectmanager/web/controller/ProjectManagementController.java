package com.asal.projectmanager.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.asal.projectmanager.converter.DatePropertyEditor;
import com.asal.projectmanager.dao.LocationDao;
import com.asal.projectmanager.dao.ProjectDao;
import com.asal.projectmanager.dao.ProjectStatusDao;
import com.asal.projectmanager.dao.ProjectTypeDao;
import com.asal.projectmanager.dao.ProjectUserDao;
import com.asal.projectmanager.dao.RoleDao;
import com.asal.projectmanager.domain.Location;
import com.asal.projectmanager.domain.Project;
import com.asal.projectmanager.domain.ProjectStatus;
import com.asal.projectmanager.domain.ProjectType;
import com.asal.projectmanager.domain.ProjectUser;
import com.asal.projectmanager.domain.Role;

@Controller
@SessionAttributes({ "user" })
// @Secured("ROLE_USER")
public class ProjectManagementController {

	protected static Logger logger = Logger
			.getLogger(ProjectManagementController.class);

	@Autowired
	RoleDao roleDao;

	@Autowired
	ProjectTypeDao projectTypeDao;

	@Autowired
	LocationDao locationDao;

	@Autowired
	ProjectStatusDao projectStatusDao;

	@Autowired
	ProjectUserDao projectUserDao;

	@Autowired
	ProjectDao projectDao;
	
	protected Long id;

	// @InitBinder
	// private void dateBinder(WebDataBinder binder) {
	// //The date format to parse or output your dates
	// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	// //Create a new CustomDateEditor
	// CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	// //Register it as custom editor for the Date type
	// binder.registerCustomEditor(Date.class, editor);
	// }

	// @InitBinder
	// public void initBinder(WebDataBinder webDataBinder) {
	// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	// dateFormat.setLenient(false);
	// webDataBinder.registerCustomEditor(Date.class, new
	// CustomDateEditor(dateFormat, true));
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	protected void initBinder(HttpServletRequest request,
//			ServletRequestDataBinder binder) throws Exception {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
//		binder.registerCustomEditor(Date.class, editor);
//	}
	protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DatePropertyEditor());
		  }

	@RequestMapping(value = "/setup.html", method = RequestMethod.GET)
	@Transactional
	public String setUp(@ModelAttribute("role") Role role,
			@ModelAttribute ProjectUser logedInUser,
			@ModelAttribute("projectType") ProjectType projectType,
			@ModelAttribute ProjectUser user,
			@ModelAttribute("location") Location location,
			@ModelAttribute("projectStatus") ProjectStatus projectStatus,
			Map<String, Object> model) {

		// if (!logedInUser.getIsLoggedIn())
		// return "login";

		List<Role> roleList = roleDao.findAll();
		model.put("roleList", roleList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		return "setup";
	}

	@RequestMapping(value = "/role.html", method = RequestMethod.POST)
	@Transactional
	public String addRole(@ModelAttribute("role") Role role,
			@ModelAttribute("projectType") ProjectType projectType,
			@ModelAttribute("location") Location location,
			@ModelAttribute("projectStatus") ProjectStatus projectStatus,
			Map<String, Object> model) {
		logger.info(" Entering addRole");
		roleDao.save(role);

		List<Role> roleList = roleDao.findAll();
		model.put("roleList", roleList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		model.put("projectType", new ProjectType());
		model.put("role", new Role());
		model.put("location", new Location());
		model.put("projectStatus", new ProjectStatus());

		return "setup";
	}

	@RequestMapping(value = "/projecttype.html", method = RequestMethod.POST)
	@Transactional
	public String addProjectType(@ModelAttribute("role") Role role,
			@ModelAttribute("projectType") ProjectType projectType,
			@ModelAttribute("location") Location location,
			@ModelAttribute("projectStatus") ProjectStatus projectStatus,
			Map<String, Object> model) {
		logger.info(" Entering addProjectType");

		projectTypeDao.save(projectType);

		List<Role> roleList = roleDao.findAll();
		model.put("roleList", roleList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		model.put("projectType", new ProjectType());
		model.put("role", new Role());
		model.put("location", new Location());
		model.put("projectStatus", new ProjectStatus());

		return "setup";
	}

	@RequestMapping(value = "/location.html", method = RequestMethod.POST)
	@Transactional
	public String addLocation(@ModelAttribute("role") Role role,
			@ModelAttribute("projectType") ProjectType projectType,
			@ModelAttribute("location") Location location,
			@ModelAttribute("projectStatus") ProjectStatus projectStatus,
			Map<String, Object> model) {
		logger.info(" Entering addLocation");

		locationDao.save(location);
		List<Role> roleList = roleDao.findAll();
		model.put("roleList", roleList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		model.put("projectType", new ProjectType());
		model.put("role", new Role());
		model.put("location", new Location());
		model.put("projectStatus", new ProjectStatus());

		return "setup";
	}

	@RequestMapping(value = "/projectstatus.html", method = RequestMethod.POST)
	@Transactional
	public String addProjectStatus(@ModelAttribute("role") Role role,
			@ModelAttribute("projectType") ProjectType projectType,
			@ModelAttribute("location") Location location,
			@ModelAttribute("projectStatus") ProjectStatus projectStatus,
			Map<String, Object> model) {
		logger.info(" Entering addProjectStatus");

		projectStatusDao.save(projectStatus);

		List<Role> roleList = roleDao.findAll();
		model.put("roleList", roleList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		model.put("projectType", new ProjectType());
		model.put("role", new Role());
		model.put("location", new Location());
		model.put("projectStatus", new ProjectStatus());

		return "setup";
	}

	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.POST)
	@Transactional
	public String addUser(
			@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute Role role, BindingResult result,
			Map<String, Object> model) {

		projectUserDao.save(projectUser);

		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);

		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		// RedirectAttributes redirectAttributes,
		// redirectAttributes.addFlashAttribute("firstName",
		// projectUser.getFirstName());
		// redirectAttributes.addFlashAttribute("lastName",
		// projectUser.getLastName());

		projectUser = new ProjectUser();
		model.remove("projectUser");
		model.put("projectUser", projectUser);
		// if (result.hasErrors())
		return "redirect:index.html";
		// return "success";
	}

	@RequestMapping(value = "/success.html", method = RequestMethod.GET)
	public String successView() {
		return "success";
	}

	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	@Transactional
	public String index(@ModelAttribute("projectUser") ProjectUser projectUser,
			@ModelAttribute ProjectUser logedInUser, ModelMap model) {

		// ProjectUser myUser = (ProjectUser)model.get("user");
		// if (!logedInUser.getIsLoggedIn())
		// return "login";

		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);

		return "index";
	}

	@RequestMapping(value = {"/project.html"}, method = RequestMethod.GET)
	@Transactional
	public String project(@ModelAttribute("project") Project project,
			@ModelAttribute ProjectUser logedInUser,
			@ModelAttribute ProjectUser user,  ModelMap model) {
		
		logger.info("Displaying my projects !!!!!");
		logger.info("Name --- "+project.getName());
		
		// ProjectUser myUser = (ProjectUser)model.get("user");
		// if (!logedInUser.getIsLoggedIn())
		// return "login";
		if (model.get("id") != null){
			logger.info(" **************************** There must have been an id set");
			project = projectDao.findOne((Long)model.get("id"));
			model.addAttribute("project", project);
			
		}

		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);

		return "project";
	}

	@RequestMapping(value = "/project.html", method = RequestMethod.POST)
	@Transactional
	public String addProject(@ModelAttribute("project") Project project,
			Map<String, Object> model) {

		if (project.getId() == null){
			logger.info("XXXXXXXXXXXXX New Project |||||||||||| ");
		} else{
			logger.info("XXXXXXXXX Old Project Updating "+project.getId());
		}
		projectDao.save(project);

		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);

		project = new Project();
		model.remove("project");
		model.put("project", project);

		return "redirect:project.html";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String deleteProject(@PathVariable("id") Long id) {
		projectDao.deleteById(id);

		return "redirect:/index.html";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id) {
		// projectDao.deleteById(id);
		projectUserDao.deleteById(id);

		return "redirect:/index.html";
	}

	/****
	 * Delete Roles
	 * 
	 * **/
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
	public String deleteRole(@PathVariable("id") Long id) {
		roleDao.deleteById(id);

		return "redirect:/setup.html";
	}

	/***
	 * Delete Location
	 * */
	@RequestMapping(value = "/locations/{id}", method = RequestMethod.GET)
	public String deleteLocation(@PathVariable("id") Long id) {
		locationDao.deleteById(id);

		return "redirect:/setup.html";
	}

	/***
	 * Delete Project Type
	 * */
	/***
	 * Delete Location
	 * */
	@RequestMapping(value = "/projecttypes/{id}", method = RequestMethod.GET)
	public String deleteProjectType(@PathVariable("id") Long id) {
		projectTypeDao.deleteById(id);

		return "redirect:/setup.html";
	}

	/***
	 * Delete Project Status
	 * */
	/***
	 * Delete Location
	 * */
	@RequestMapping(value = "/projectstatuses/{id}", method = RequestMethod.GET)
	@Transactional
	public String deleteProjectStatus(@PathVariable("id") Long id) {
		projectStatusDao.deleteById(id);

		return "redirect:/setup.html";
	}

	/***
	 * Delete Projects from Projects Page
	 * 
	 * projectmainpage
	 * */
	@RequestMapping(value = "/projectmainpage/{id}", method = RequestMethod.GET)
	@Transactional
	public String deleteProjectPage(@PathVariable("id") Long id) {
		projectDao.deleteById(id);

		return "redirect:/project.html";
	}

	@RequestMapping(value = "projectedit/{id}", method = RequestMethod.GET)
	@Transactional
	public String projectEdit(@ModelAttribute("project") Project project, @PathVariable("id") Long id, 
			ModelMap model) {
		logger.info("XXXXXXXXXXX Editing Project ...");
		
		logger.info("XXXXXXXXXXX Project ID  ..."+id);
		
		List<ProjectUser> projectUserList = projectUserDao.findAll();
		model.put("projectUserList", projectUserList);

		List<ProjectType> projectTypeList = projectTypeDao.findAll();
		model.put("projectTypeList", projectTypeList);

		List<ProjectStatus> projectStatusList = projectStatusDao.findAll();
		model.put("projectStatusList", projectStatusList);

		List<Location> locationList = locationDao.findAll();
		model.put("locationList", locationList);

		List<Project> projectList = projectDao.findAll();
		model.put("projectList", projectList);
		
		//@PathVariable("id") Long id, 
		project = projectDao.findOne(id);
		// request.setAttribute("contact", contact);
		// Map<String, Object> model = new HashedMap();
		project.setId(id);
		model.put("project", project);
//		model.put("id", id);
		//model.addAttribute("project", project);
		model.addAttribute(project);
		
		//return new ModelAndView("project", "project", project);
		//return "redirect:/project.html";
//		model.addAttribute("id", project.getId());
//		model.addAttribute("name", project.getName());
//		model.addAttribute("code", project.getCode());
//		model.addAttribute("description", project.getDescription());
//		model.addAttribute("startDate", project.getStartDate().toString());
//		model.addAttribute("endDate", project.getEndDate().toString());
//		model.addAttribute("NoOfDays", project.getNoOfDays());
		//return "project";
		//return "redirect:/project.html/"+id;
		return "project";
	}

}
