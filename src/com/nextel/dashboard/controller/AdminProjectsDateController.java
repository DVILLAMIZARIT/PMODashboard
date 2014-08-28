package com.nextel.dashboard.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextel.dashboard.bean.ProjectsDateBean;
import com.nextel.dashboard.service.AdminProjectsDateService;

@Controller
public class AdminProjectsDateController {
	
	@Autowired
	AdminProjectsDateService adminProjectsDateService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createProjectsDateByProject", method = RequestMethod.GET)
	public ModelAndView createProjectsDateByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("projectDateSelectedForCreate", true);
		model.addObject("createProjectsDateSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createProjectsDate", method = RequestMethod.GET)
	public ModelAndView createProjectsDate(@RequestParam(value = "idAuth", required = false) String idAuth,
									  @RequestParam(value = "description", required = false) String description,
									  @RequestParam(value = "type", required = false) String type,
									  @RequestParam(value = "idTask", required = false) String idTask,
									  @RequestParam(value = "predecesor", required = false) String predecesor,
									  @RequestParam(value = "startBL", required = false) String startBL,
									  @RequestParam(value = "endBL", required = false) String endBL,
									  @RequestParam(value = "startFC", required = false) String startFC,
									  @RequestParam(value = "endFC", required = false) String endFC,
									  @RequestParam(value = "startACT", required = false) String startACT,
									  @RequestParam(value = "endACT", required = false) String endACT,
									  @RequestParam(value = "resourceName", required = false) String resourceName,
									  @RequestParam(value = "advance", required = false) String advance,
									  @RequestParam(value = "principal", required = false) String principal,
									  @RequestParam(value = "idGroup", required = false) String idGroup,
									  HttpServletRequest request) {
		
		
		//Get the last ID Date and create new one
		int lastIdDate = adminProjectsDateService.getLastIdDate();
		
		ProjectsDateBean pdb = new ProjectsDateBean();
		pdb.setIdDate(lastIdDate);
		pdb.setIdAuth(idAuth);
		pdb.setDescription(description);
		pdb.setType(type);
		pdb.setIdTask(new Integer(idTask));
		pdb.setPredecesor(new Integer(predecesor));
		pdb.setStartBL(startBL);
		pdb.setEndBL(endBL);
		pdb.setStartFC(startFC);
		pdb.setEndFC(endFC);
		pdb.setStartACT(startACT);
		pdb.setEndACT(endACT);
		pdb.setResourceName(resourceName);
		pdb.setAdvance(new Integer(advance));
		pdb.setPrincipal(new Integer(principal));
		pdb.setIdGroup(new Integer(idGroup));
		
		//Create ProjectDate
		adminProjectsDateService.createProjectDate(pdb);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		//model.addObject("projectDateCreated", projectDateCreated);
		model.addObject("description", description);
		model.addObject("idAuth", idAuth);
		model.addObject("createProjectsDateSelected", true);
		model.addObject("throwTimeline", true);

		model.setViewName("admin/admin");
		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getProjectsDateModify", method = RequestMethod.GET)
	public ModelAndView getProjectsDateModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<ProjectsDateBean> listDescriptions = adminProjectsDateService.getListDescriptions(idAuth);
		session.setAttribute("listDescriptions", listDescriptions);
		
		System.out.println("CANTIDAD " + listDescriptions.size());
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("totalTimelines", listDescriptions.size());
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listDescriptions", listDescriptions);
		model.addObject("modifyProjectsDateSelected", true);
		model.addObject("projectDateForModifySelected", true);
		model.addObject("projectDateDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getProjectsDateDataByDesc", method = RequestMethod.GET)
	public ModelAndView getProjectsDateDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
												  @RequestParam(value = "idDate", required = false) String idDate,
												  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ProjectsDateBean pdb = new ProjectsDateBean();
		pdb.setIdAuth(idAuth);
		pdb.setIdDate(new Integer(idDate));
		
		List<ProjectsDateBean> listDataProjectsDate = adminProjectsDateService.getProjectsDateByDesc(pdb);
		List<ProjectsDateBean> listDescriptions = adminProjectsDateService.getListDescriptions(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idDate", idDate);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		//model.addObject("listDescriptions", session.getAttribute("listDescriptions"));
		model.addObject("listDescriptions", listDescriptions);	
		model.addObject("datos", listDataProjectsDate);		
		model.addObject("projectDateForModifySelected", true);
		model.addObject("modifyProjectsDateSelected", true);
		model.addObject("projectDateDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateProjectsDate", method = RequestMethod.GET)
	public ModelAndView updateProjectsDate(@RequestParam(value = "idAuth", required = false) String idAuth, 
										   @RequestParam(value = "idDate", required = false) String idDate,
			  							   @RequestParam(value = "description", required = false) String description,
			  							   @RequestParam(value = "type", required = false) String type,
			  							   @RequestParam(value = "idTask", required = false) String idTask,
			  							   @RequestParam(value = "predecesor", required = false) String predecesor,
			  							   @RequestParam(value = "startBL", required = false) String startBL,
			  							   @RequestParam(value = "endBL", required = false) String endBL,
			  							   @RequestParam(value = "startFC", required = false) String startFC,
			  							   @RequestParam(value = "endFC", required = false) String endFC,
			  							   @RequestParam(value = "startACT", required = false) String startACT,
			  							   @RequestParam(value = "endACT", required = false) String endACT,
			  							   @RequestParam(value = "resourceName", required = false) String resourceName,
			  							   @RequestParam(value = "advance", required = false) String advance,
			  							   @RequestParam(value = "principal", required = false) String principal,
			  							   @RequestParam(value = "idGroup", required = false) String idGroup,
			  						  HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ProjectsDateBean pdb = new ProjectsDateBean();
		pdb.setIdAuth(idAuth);
		pdb.setIdDate(new Integer(idDate));
		pdb.setDescription(description);
		pdb.setType(type);
		pdb.setIdTask(new Integer(idTask));
		pdb.setPredecesor(new Integer(predecesor));
		pdb.setAdvance(new Integer(advance));
		pdb.setStartFC(startFC);
		pdb.setEndFC(endFC);
		pdb.setStartACT(startACT);
		pdb.setEndACT(endACT);
		pdb.setResourceName(resourceName);
		pdb.setPrincipal(new Integer(principal));
		pdb.setIdGroup(new Integer(idGroup));
		
		//Update data
		adminProjectsDateService.updateProjectDate(pdb);
		
		ModelAndView model = new ModelAndView();
		//model.addObject("projectDateUpdated", projectsDateUpdated);
		model.addObject("idAuth",idAuth);
		model.addObject("description", description);
		
		model.addObject("projectDateForModifySelected", true);
		model.addObject("modifyProjectsDateSelected", true);
		model.addObject("projectDateDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getProjectsDateDelete", method = RequestMethod.GET)
	public ModelAndView getProjectsDateDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<ProjectsDateBean> listDescriptions = adminProjectsDateService.getListDescriptions(idAuth);
		session.setAttribute("listDescriptions", listDescriptions);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listDescriptions", listDescriptions);		
		model.addObject("projectDateForDeleteSelected", true);
		model.addObject("deleteProjectsDateSelected", true);
		model.addObject("projectDateDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getProjectsDateDataDelByDesc", method = RequestMethod.GET)
	public ModelAndView getProjectsDateDataDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
													 @RequestParam(value = "idDate", required = false) String idDate,
													 HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PRIMER date " + idDate );
		
		ProjectsDateBean pdb = new ProjectsDateBean();
		pdb.setIdAuth(idAuth);
		pdb.setIdDate(new Integer(idDate));
		
		List<ProjectsDateBean> listDataProjectsDate = adminProjectsDateService.getProjectsDateByDesc(pdb);
		List<ProjectsDateBean> listDescriptions = adminProjectsDateService.getListDescriptions(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idDate", idDate);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		//model.addObject("listDescriptions", session.getAttribute("listDescriptions"));
		model.addObject("listDescriptions", listDescriptions);	
		model.addObject("datos", listDataProjectsDate);		
		model.addObject("projectDateForDeleteSelected", true);
		model.addObject("deleteProjectsDateSelected", true);
		model.addObject("projectDateDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteProjectsDate", method = RequestMethod.GET)
	public ModelAndView deleteProjectsDate(@RequestParam(value = "idAuth", required = false) String idAuth,
									  @RequestParam(value = "idDate", required = false) String idDate,
									  @RequestParam(value = "description", required = false) String description,
			  						  HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("Date para borrar " + idDate);
		
		ProjectsDateBean pdb = new ProjectsDateBean();
		pdb.setIdAuth(idAuth);
		pdb.setIdDate(new Integer(idDate));
		
		boolean projectDeleted = adminProjectsDateService.deleteProjectDate(pdb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("deleteProjectsDateSelected", true);
		//model.addObject("projectDateDeleted", projectDeleted);
		model.addObject("idAuth",idAuth);
		model.addObject("description", description);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}	

}