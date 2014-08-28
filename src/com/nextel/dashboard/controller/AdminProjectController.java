package com.nextel.dashboard.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.UsersBean;
import com.nextel.dashboard.service.Admin4UPService;
import com.nextel.dashboard.service.AdminPMService;
import com.nextel.dashboard.service.AdminProjectService;
import com.nextel.dashboard.service.AdminUsersService;


@Controller
public class AdminProjectController {
	
	@Autowired
	AdminProjectService adminFormService;
	
	@Autowired
	Admin4UPService admin4UPService;
	
	@Autowired
	AdminPMService adminPMService;

	@Autowired
	AdminUsersService adminUsersService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin(@RequestParam(value = "admin", required = false) String admin, HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		
		ModelAndView model = new ModelAndView();
		
		boolean adminSelected = false; //One option selected
		boolean createProjectSelected = false; //Create Module selected
		boolean modifyProjectSelected = false; //Modify Module selected
		boolean deleteProjectSelected = false; //Modify Module selected
		
		boolean createProjectsDateSelected = false; //Create Module selected
		boolean modifyProjectsDateSelected = false; //Modify Module selected
		boolean deleteProjectsDateSelected = false; //Modify Module selected
		
		boolean create4upSelected = false; //Create Module selected
		boolean modify4upSelected = false; //Modify Module selected
		boolean delete4upSelected = false; //Modify Module selected
		
		boolean createIssueRiskSelected = false; //Create Module selected
		boolean modifyIssueRiskSelected = false; //Modify Module selected
		boolean deleteIssueRiskSelected = false; //Modify Module selected

		boolean createDashboardSelected = false; //Create Module selected
		boolean modifyDashboardSelected = false; //Modify Module selected
		boolean deleteDashboardSelected = false; //Modify Module selected
		
		boolean createMatrixSelected = false; //Create Module selected
		boolean modifyMatrixSelected = false; //Modify Module selected
		boolean deleteMatrixSelected = false; //Modify Module selected

		boolean createWMScheduleSelected = false; //Create Module selected
		boolean modifyWMScheduleSelected = false; //Modify Module selected
		boolean deleteWMScheduleSelected = false; //Modify Module selected
		
		boolean createResponsabilityRolesSelected = false; //Create Module selected
		boolean modifyResponsabilityRolesSelected = false; //Modify Module selected
		boolean deleteResponsabilityRolesSelected = false; //Modify Module selected
		
		boolean createCommunicationPlanSelected = false; //Create Module selected
		boolean modifyCommunicationPlanSelected = false; //Modify Module selected
		boolean deleteCommunicationPlanSelected = false; //Modify Module selected
		
		boolean createProjectManagerSelected = false; //Create Module selected
		boolean modifyProjectManagerSelected = false; //Modify Module selected
		boolean deleteProjectManagerSelected = false; //Modify Module selected
		
		boolean createUserSelected = false; //Create Module selected
		boolean modifyUserSelected = false; //Modify Module selected
		boolean deleteUserSelected = false; //Modify Module selected
		

		if(admin != null){
			
			//One Admin option is selected
			adminSelected = true;
			
			//Projects menu
			if(admin.equals("Create Project")){
				createProjectSelected = true;
				
				//Populate the lists of selects tags
				model = getListsOfDataProject(model); 
				
			}
			else if(admin.equals("Modify Project")){
				modifyProjectSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete Project")) {
				deleteProjectSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//ProjectsDate menu
			else if(admin.equals("Create ProjectsDate")){
				createProjectsDateSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify ProjectsDate")) {
				modifyProjectsDateSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete ProjectsDate")) {
				deleteProjectsDateSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//4ups menu
			else if(admin.equals("Create FourUp")){
				create4upSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify FourUp")) {
				modify4upSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete FourUp")) {
				delete4upSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			
			//IssueRisk menu
			else if(admin.equals("Create IssueRisk")){
				createIssueRiskSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify IssueRisk")) {
				modifyIssueRiskSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete IssueRisk")) {
				deleteIssueRiskSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//Dashboard menu
			else if(admin.equals("Create Dashboard")){
				createDashboardSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify Dashboard")) {
				modifyDashboardSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete Dashboard")) {
				deleteDashboardSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//Matrix menu
			else if(admin.equals("Create Matrix")){
				createMatrixSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify Matrix")) {
				modifyMatrixSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete Matrix")) {
				deleteMatrixSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//WMSchedule menu
			else if(admin.equals("Create WMSchedule")){
				createWMScheduleSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify WMSchedule")) {
				modifyWMScheduleSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete WMSchedule")) {
				deleteWMScheduleSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//CommunicationPlan menu
			else if(admin.equals("Create CommunicationPlan")){
				createCommunicationPlanSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify CommunicationPlan")) {
				modifyCommunicationPlanSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete CommunicationPlan")) {
				deleteCommunicationPlanSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//ResponsabilityRoles menu
			else if(admin.equals("Create ResponsabilityRoles")){
				createResponsabilityRolesSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Modify ResponsabilityRoles")) {
				modifyResponsabilityRolesSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			else if(admin.equals("Delete ResponsabilityRoles")) {
				deleteResponsabilityRolesSelected = true;
				List<ProjectBean> listProjects = adminFormService.getListProjects();
				session.setAttribute("listProjects", listProjects);
				
				model.addObject("listProjects", listProjects);
			}
			
			
			//PMs menu
			else if(admin.equals("Create Project Manager")){
				createProjectManagerSelected = true;
			}
			else if(admin.equals("Modify Project Manager")) {
				modifyProjectManagerSelected = true;
				List<PMBean> listPMs = adminPMService.getListPM();
				session.setAttribute("listPMs", listPMs);
				
				model.addObject("listPMs", listPMs);
			}
			else if(admin.equals("Delete Project Manager")) {
				deleteProjectManagerSelected = true;
				List<PMBean> listPMs = adminPMService.getListPMEnabled();
				session.setAttribute("listPMEnabled", listPMs);
				
				model.addObject("listPMEnabled", listPMs);
			}
			
			
			//Users menu
			else if(admin.equals("Create User")){
				createUserSelected = true;
			}
			else if(admin.equals("Modify User")) {
				modifyUserSelected = true;
				List<UsersBean> listUsers = adminUsersService.getListUsers();
				session.setAttribute("listUsers", listUsers);
				
				model.addObject("listUsers", listUsers);
			}
			else if(admin.equals("Delete User")) {
				deleteUserSelected = true;
				List<UsersBean> listUsers = adminUsersService.getListUsers();
				session.setAttribute("listUsers", listUsers);
				
				model.addObject("listUsers", listUsers);
			}
		}
		
		
		model.addObject("administrate", admin);
		model.addObject("adminSelected", adminSelected);
		model.addObject("createProjectSelected", createProjectSelected);
		model.addObject("modifyProjectSelected", modifyProjectSelected);
		model.addObject("deleteProjectSelected", deleteProjectSelected);
		
		model.addObject("createProjectsDateSelected", createProjectsDateSelected);
		model.addObject("modifyProjectsDateSelected", modifyProjectsDateSelected);
		model.addObject("deleteProjectsDateSelected", deleteProjectsDateSelected);
		
		model.addObject("create4upSelected", create4upSelected);
		model.addObject("modify4upSelected", modify4upSelected);
		model.addObject("delete4upSelected", delete4upSelected);
		
		model.addObject("createIssueRiskSelected", createIssueRiskSelected);
		model.addObject("modifyIssueRiskSelected", modifyIssueRiskSelected);
		model.addObject("deleteIssueRiskSelected", deleteIssueRiskSelected);
		
		model.addObject("createDashboardSelected", createDashboardSelected);
		model.addObject("modifyDashboardSelected", modifyDashboardSelected);
		model.addObject("deleteDashboardSelected", deleteDashboardSelected);

		model.addObject("createMatrixSelected", createMatrixSelected);
		model.addObject("modifyMatrixSelected", modifyMatrixSelected);
		model.addObject("deleteMatrixSelected", deleteMatrixSelected);

		model.addObject("createWMScheduleSelected", createWMScheduleSelected);
		model.addObject("modifyWMScheduleSelected", modifyWMScheduleSelected);
		model.addObject("deleteWMScheduleSelected", deleteWMScheduleSelected);
		
		model.addObject("createCommunicationPlanSelected", createCommunicationPlanSelected);
		model.addObject("modifyCommunicationPlanSelected", modifyCommunicationPlanSelected);
		model.addObject("deleteCommunicationPlanSelected", deleteCommunicationPlanSelected);
		
		model.addObject("createResponsabilityRolesSelected", createResponsabilityRolesSelected);
		model.addObject("modifyResponsabilityRolesSelected", modifyResponsabilityRolesSelected);
		model.addObject("deleteResponsabilityRolesSelected", deleteResponsabilityRolesSelected);
		
		model.addObject("createProjectManagerSelected", createProjectManagerSelected);
		model.addObject("modifyProjectManagerSelected", modifyProjectManagerSelected);
		model.addObject("deleteProjectManagerSelected", deleteProjectManagerSelected);
		
		model.addObject("createUserSelected", createUserSelected);
		model.addObject("modifyUserSelected", modifyUserSelected);
		model.addObject("deleteUserSelected", deleteUserSelected);
		
		model.setViewName("admin/admin");

		return model;
	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createProject", method = RequestMethod.GET)
	public ModelAndView createProject(@RequestParam(value = "projectName", required = false) String projectName,
									  @RequestParam(value = "idPM", required = false) String idPM,
									  @RequestParam(value = "owner", required = false) String owner,
									  @RequestParam(value = "poi", required = false) String poi,
									  @RequestParam(value = "sponsor", required = false) String sponsor,
									  @RequestParam(value = "manager", required = false) String manager,
									  @RequestParam(value = "stream", required = false) String stream,
									  @RequestParam(value = "topProject", required = false) String topProject,
									  HttpServletRequest request) {

		
		//Get the last IDAuth and create new one
		String lastIdAuth = adminFormService.getLastIdAuth();
		
		//Split the last IdAuth
		String[] idAuthSplit = lastIdAuth.split("-");
		
		//Get the last piece
		lastIdAuth = idAuthSplit[1];
		
		//Add one value to last piece
		Integer IlastIdAuth = new Integer(lastIdAuth) + 1;
		
		//Format to add the 00 to last piece
		String formattedIdAuth = String.format("%04d", IlastIdAuth);
		
		//Join all for creation of idAuth
		lastIdAuth = idAuthSplit[0].concat("-").concat(formattedIdAuth);
		System.out.println(lastIdAuth);
		
		ProjectBean pb = new ProjectBean();
		pb.setIdAuth(lastIdAuth);
		pb.setProjectName(projectName);
		pb.setIdPM(idPM);
		pb.setOwner(owner);
		pb.setPoi(poi);
		pb.setSponsor(sponsor);
		pb.setManager(manager);
		pb.setStream(stream);
		pb.setTopProject(new Integer(topProject));
		
		//Create Project
		//boolean projectCreated = adminFormService.createProject(pb);
		
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		//model.addObject("projectCreated", projectCreated);
		model.addObject("idAuth", lastIdAuth);
		model.addObject("projectName", projectName);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getProjectDataModify", method = RequestMethod.GET)
	public ModelAndView getProjectModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		//Status
		List<ProjectBean> listStatus = adminFormService.getListStatus();
		
		//Data from ID Auth
		List<ProjectBean> listProjectData = adminFormService.getDataProjecByIdAuth(idAuth);
		
		//Get PM Name
		String pmName = adminFormService.getPMname(listProjectData.get(0).getIdPM());
		
		
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listStatus", listStatus);
		model.addObject("datos", listProjectData);
	
		//Populate the lists of selects tags
		model = getListsOfDataProject(model); 
				
		model.addObject("pmName", pmName);
		model.addObject("modifyProjectSelected", true);
		model.addObject("projectSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getProjectDataDelete", method = RequestMethod.GET)
	public ModelAndView getProjectDataDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		
		//Data from ID Auth
		List<ProjectBean> listProjectData = adminFormService.getDataProjecByIdAuth(idAuth);
		
		//Get PM Name
		String pmName = adminFormService.getPMname(listProjectData.get(0).getIdPM());
		
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("datos", listProjectData);
				
		model.addObject("pmName", pmName);
		model.addObject("deleteProjectSelected", true);
		model.addObject("projectSelectedForDelete", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateProject", method = RequestMethod.GET)
	public ModelAndView updateProject(@RequestParam(value = "idAuth", required = false) String idAuth,
									  @RequestParam(value = "projectName", required = false) String projectName,
			  						  @RequestParam(value = "idPM", required = false) String idPM,
			  						  @RequestParam(value = "owner", required = false) String owner,
			  						  @RequestParam(value = "poi", required = false) String poi,
			  						  @RequestParam(value = "sponsor", required = false) String sponsor,
			  						  @RequestParam(value = "manager", required = false) String manager,
			  						  @RequestParam(value = "stream", required = false) String stream,
			  						  @RequestParam(value = "topProject", required = false) String topProject,
			  						  @RequestParam(value = "budgetKey", required = false) String budgetKey,
			  						  @RequestParam(value = "type", required = false) String type,
			  						  @RequestParam(value = "status", required = false) String status,
			  						  HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		ProjectBean pb = new ProjectBean();
		pb.setIdAuth(idAuth);
		pb.setProjectName(projectName);
		pb.setIdPM(idPM);
		pb.setOwner(owner);
		pb.setPoi(poi);
		pb.setSponsor(sponsor);
		pb.setManager(manager);
		pb.setStream(stream);
		pb.setTopProject(new Integer(topProject));
		pb.setBudgetKey(budgetKey);
		pb.setType(type);
		pb.setStatus(status);
		
		boolean projectUpdated = adminFormService.updateProject(pb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("projectUpdated", projectUpdated);
		model.addObject("idAuth",idAuth);
		model.addObject("projectName", projectName);
		model.setViewName("admin/admin");

		return model;

	}	
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	public ModelAndView deleteProject(@RequestParam(value = "idAuth", required = false) String idAuth,
									  @RequestParam(value = "projectName", required = false) String projectName,
			  						  HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		boolean projectDeleted = adminFormService.deleteProject(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("projectDeleted", projectDeleted);
		model.addObject("idAuth",idAuth);
		model.addObject("projectName", projectName);
		model.setViewName("admin/admin");

		return model;

	}	
	
	
	
	
	/*
	 * 
	 * */
	private ModelAndView getListsOfDataProject(ModelAndView model) {

		//List PM
		List<PMBean> listPM = adminFormService.getListPM();
		
		//List of POIs
		List<ProjectBean> listPOI = new ArrayList<ProjectBean>();
		ProjectBean pbPoi;
		
		pbPoi = new ProjectBean();
		pbPoi.setPoi("P");
		listPOI.add(pbPoi);
		
		pbPoi = new ProjectBean();
		pbPoi.setPoi("I");
		listPOI.add(pbPoi);
		
		//List Manager
		List<ProjectBean>listManager = new ArrayList<ProjectBean>();
		ProjectBean pbManager;
		
		pbManager = new ProjectBean();
		pbManager.setManager("OP");
		listManager.add(pbManager);
		
		pbManager = new ProjectBean();
		pbManager.setManager("IMP");
		listManager.add(pbManager);
		
		pbManager = new ProjectBean();
		pbManager.setManager("ING");
		listManager.add(pbManager);
		
		//List TopProject
		List<ProjectBean> listTopProject = new ArrayList<ProjectBean>();
		ProjectBean pbTopProject;
		
		pbTopProject = new ProjectBean();
		pbTopProject.setTopProject(0);
		listTopProject.add(pbTopProject);
		
		pbTopProject = new ProjectBean();
		pbTopProject.setTopProject(1);
		listTopProject.add(pbTopProject);
		
		//Return the Lists
		model.addObject("listPM", listPM);
		model.addObject("listPOI", listPOI);
		model.addObject("listManager", listManager);
		model.addObject("listTopProject", listTopProject);

		return model;

	}

}