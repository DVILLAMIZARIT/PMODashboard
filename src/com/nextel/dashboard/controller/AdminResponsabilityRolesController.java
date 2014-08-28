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

import com.nextel.dashboard.bean.ResponsabilityRolesBean;
import com.nextel.dashboard.service.AdminResponsabilityRolesService;

@Controller
public class AdminResponsabilityRolesController {
	
	@Autowired
	AdminResponsabilityRolesService adminResponsabilityRolesService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createResponsabilityRolesByProject", method = RequestMethod.GET)
	public ModelAndView createResponsabilityRolesByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("createResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createResponsabilityRoles", method = RequestMethod.GET)
	public ModelAndView createResponsabilityRoles(@RequestParam(value = "idAuth", required = false) String idAuth,
												  @RequestParam(value = "task", required = false) String task,
												  @RequestParam(value = "area", required = false) String area,
												  @RequestParam(value = "role", required = false) String role,
												  @RequestParam(value = "clasifica", required = false) String clasifica,
												  HttpServletRequest request) {

		
		
		int newIdRole = adminResponsabilityRolesService.getLastIdResponsabilityRole();
		
		ResponsabilityRolesBean db = new ResponsabilityRolesBean();
		db.setIdAuth(idAuth);
		db.setIdRole(newIdRole);
		db.setTask(task);
		db.setArea(area);
		db.setRole(role);
		db.setClasifica(clasifica);
		
		//Create Project Manager
		boolean fourUpCreated = adminResponsabilityRolesService.createResponsabilityRoles(db);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("task", task);
		model.addObject("createResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesCreated", fourUpCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getResponsabilityRolesModify", method = RequestMethod.GET)
	public ModelAndView getResponsabilityRolesModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       		   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<ResponsabilityRolesBean> listTask = adminResponsabilityRolesService.getListTask(idAuth);
		session.setAttribute("listTask", listTask);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listTask", listTask);
		model.addObject("modifyResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesForModifySelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getResponsabilityRolesDataByDesc", method = RequestMethod.GET)
	public ModelAndView getResponsabilityRolesDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											   			 @RequestParam(value = "idRole", required = false) String idRole,
											   			 HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ResponsabilityRolesBean orb = new ResponsabilityRolesBean();
		orb.setIdAuth(idAuth);
		orb.setIdRole(new Integer(idRole));
		
		List<ResponsabilityRolesBean> listDataResponsabilityRoles = adminResponsabilityRolesService.getResponsabilityRolesByID(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idRole", idRole);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listTask", session.getAttribute("listTask"));
		model.addObject("datos", listDataResponsabilityRoles);		
		model.addObject("modifyResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesForModifySelected", true);
		model.addObject("responsabilityRolesDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateResponsabilityRoles", method = RequestMethod.GET)
	public ModelAndView updateResponsabilityRoles(@RequestParam(value = "idAuth", required = false) String idAuth,
												  @RequestParam(value = "idRole", required = false) String idRole,
												  @RequestParam(value = "task", required = false) String task,
												  @RequestParam(value = "area", required = false) String area,
												  @RequestParam(value = "role", required = false) String role,
												  @RequestParam(value = "clasifica", required = false) String clasifica,
									  	HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ResponsabilityRolesBean db = new ResponsabilityRolesBean();		
		db.setIdAuth(idAuth);
		db.setIdRole(new Integer(idRole));
		db.setTask(task);
		db.setArea(area);
		db.setRole(role);
		db.setClasifica(clasifica);
		
		boolean responsabilityRolesupdated = adminResponsabilityRolesService.updateResponsabilityRoles(db);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("responsabilityRolesupdated", responsabilityRolesupdated);
		model.addObject("task", task);
		model.addObject("modifyResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesForModifySelected", true);
		model.addObject("responsabilityRolesDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getResponsabilityRolesDelete", method = RequestMethod.GET)
	public ModelAndView getResponsabilityRolesDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            							   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<ResponsabilityRolesBean> listTask = adminResponsabilityRolesService.getListTask(idAuth);
		session.setAttribute("listTask", listTask);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listTask", listTask);
		model.addObject("deleteResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesDeleteSelected", true);
		model.addObject("responsabilityRolesDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getResponsabilityRolesDelByDesc", method = RequestMethod.GET)
	public ModelAndView getResponsabilityRolesDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											  @RequestParam(value = "idRole", required = false) String idRole,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ResponsabilityRolesBean orb = new ResponsabilityRolesBean();
		orb.setIdAuth(idAuth);
		orb.setIdRole(new Integer(idRole));
		
		List<ResponsabilityRolesBean> listDataIR = adminResponsabilityRolesService.getResponsabilityRolesByID(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idRole", idRole);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", session.getAttribute("listSubProjects"));
		model.addObject("datos", listDataIR);		
		model.addObject("deleteResponsabilityRolesSelected", true);
		model.addObject("responsabilityRolesDeleteSelected", true);
		model.addObject("responsabilityRolesDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteResponsabilityRoles", method = RequestMethod.GET)
	public ModelAndView deleteResponsabilityRoles(@RequestParam(value = "idAuth", required = false) String idAuth,
								   		@RequestParam(value = "idRole", required = false) String idRole,
								   		@RequestParam(value = "description", required = false) String description,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR idRole " + idRole );
		
		boolean responsabilityRolesDeleted = adminResponsabilityRolesService.deleteResponsabilityRoles(idRole);
		
		ModelAndView model = new ModelAndView();
		model.addObject("responsabilityRolesDeleted", responsabilityRolesDeleted);
		model.addObject("description",description);
		model.addObject("deleteResponsabilityRolesSelected", true);
		model.addObject("idAuth",idAuth);
		model.setViewName("admin/admin");

		return model;

	}
}