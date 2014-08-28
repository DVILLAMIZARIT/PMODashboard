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

import com.nextel.dashboard.bean.FourUpBean;
import com.nextel.dashboard.bean.DashboardBean;
import com.nextel.dashboard.bean.ProjectsDateBean;
import com.nextel.dashboard.service.AdminDashboardService;

@Controller
public class AdminDashboardController {
	
	@Autowired
	AdminDashboardService adminDashboardService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createDashboardByProject", method = RequestMethod.GET)
	public ModelAndView createDashboardByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("createDashboardSelected", true);
		model.addObject("dashboardSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createDashboard", method = RequestMethod.GET)
	public ModelAndView createDashboard(@RequestParam(value = "idAuth", required = false) String idAuth,
										@RequestParam(value = "idPriority", required = false) String idPriority,
										@RequestParam(value = "subProject", required = false) String subProject,
								  		@RequestParam(value = "item", required = false) String item,
								  		@RequestParam(value = "qtyTarget", required = false) String qtyTarget,
								  		@RequestParam(value = "qtyAoT", required = false) String qtyAoT,
								  		@RequestParam(value = "advance", required = false) String advance,
								  		@RequestParam(value = "status", required = false) String status,
								  		@RequestParam(value = "remarks", required = false) String remarks,
								  		@RequestParam(value = "historic", required = false) String historic,
								  		HttpServletRequest request) {

		
		
		int newIdDashboard = adminDashboardService.getLastDashboard();
		
		DashboardBean db = new DashboardBean();
		db.setIdAuth(idAuth);
		db.setIdDashboard(newIdDashboard);
		db.setIdPriority(new Integer(idPriority));
		db.setSubProject(subProject);
		db.setItem(item);
		db.setQtyTarget(new Double(qtyTarget));
		db.setQtyAoT(new Double(qtyAoT));
		db.setAdvance(new Integer(advance));
		db.setStatus(status);
		db.setRemarks(remarks);
		db.setHistoric(historic);
	
		
		//Create Project Manager
		boolean fourUpCreated = adminDashboardService.createDashboard(db);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("subProject", subProject);
		model.addObject("createDashboardSelected", true);
		model.addObject("dashboardCreated", fourUpCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getDashboardModify", method = RequestMethod.GET)
	public ModelAndView getDashboardModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       		   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<DashboardBean> listSubProjects = adminDashboardService.getListSubProjects(idAuth);
		session.setAttribute("listSubProjects", listSubProjects);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", listSubProjects);
		model.addObject("modifyDashboardSelected", true);
		model.addObject("dashboardForModifySelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getDashboardDataByDesc", method = RequestMethod.GET)
	public ModelAndView getDashboardDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											   @RequestParam(value = "idDashboard", required = false) String idDashboard,
											   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println(idAuth + ":::" + idDashboard);
		
		DashboardBean orb = new DashboardBean();
		orb.setIdAuth(idAuth);
		orb.setIdDashboard(new Integer(idDashboard));
		
		List<DashboardBean> listDataDashboard = adminDashboardService.getDashboardByID(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idDashboard", idDashboard);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", session.getAttribute("listSubProjects"));
		model.addObject("datos", listDataDashboard);		
		model.addObject("modifyDashboardSelected", true);
		model.addObject("dashboardForModifySelected", true);
		model.addObject("dashboardDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateDashboard", method = RequestMethod.GET)
	public ModelAndView updateDashboard(@RequestParam(value = "idAuth", required = false) String idAuth,
										@RequestParam(value = "idDashboard", required = false) String idDashboard,
										@RequestParam(value = "idPriority", required = false) String idPriority,
										@RequestParam(value = "subProject", required = false) String subProject,
										@RequestParam(value = "item", required = false) String item,
										@RequestParam(value = "qtyTarget", required = false) String qtyTarget,
										@RequestParam(value = "qtyAoT", required = false) String qtyAoT,
										@RequestParam(value = "advance", required = false) String advance,
										@RequestParam(value = "status", required = false) String status,
										@RequestParam(value = "remarks", required = false) String remarks,
										@RequestParam(value = "historic", required = false) String historic,
									  	HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		DashboardBean db = new DashboardBean();
		db.setIdAuth(idAuth);
		db.setIdDashboard(new Integer(idDashboard));
		db.setIdPriority(new Integer(idPriority));
		db.setSubProject(subProject);
		db.setItem(item);
		db.setQtyTarget(new Double(qtyTarget));
		db.setQtyAoT(new Double(qtyAoT));
		db.setAdvance(new Integer(advance));
		db.setStatus(status);
		db.setRemarks(remarks);
		db.setHistoric(historic);
		
		boolean dashboardupdated = adminDashboardService.updateDashboard(db);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("dashboardupdated", dashboardupdated);
		model.addObject("subProject", subProject);
		model.addObject("modifyDashboardSelected", true);
		model.addObject("dashboardForModifySelected", true);
		model.addObject("dashboardDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getDashboardDelete", method = RequestMethod.GET)
	public ModelAndView getDashboardDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            							   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<DashboardBean> listSubProjects = adminDashboardService.getListSubProjects(idAuth);
		session.setAttribute("listSubProjects", listSubProjects);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", listSubProjects);
		model.addObject("deleteDashboardSelected", true);
		model.addObject("dashboardDeleteSelected", true);
		model.addObject("dashboardDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getDashboardDelByDesc", method = RequestMethod.GET)
	public ModelAndView getDashboardDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											  @RequestParam(value = "idDashboard", required = false) String idDashboard,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		DashboardBean orb = new DashboardBean();
		orb.setIdAuth(idAuth);
		orb.setIdDashboard(new Integer(idDashboard));
		
		List<DashboardBean> listDataIR = adminDashboardService.getDashboardByID(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idDashboard", idDashboard);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", session.getAttribute("listSubProjects"));
		model.addObject("datos", listDataIR);		
		model.addObject("deleteDashboardSelected", true);
		model.addObject("dashboardDeleteSelected", true);
		model.addObject("dashboardDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteDashboard", method = RequestMethod.GET)
	public ModelAndView deleteDashboard(@RequestParam(value = "idAuth", required = false) String idAuth,
								   		@RequestParam(value = "idDashboard", required = false) String idDashboard,
								   		@RequestParam(value = "description", required = false) String description,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR idDashboard " + idDashboard );
		
		boolean dashboardDeleted = adminDashboardService.deleteDashboard(idDashboard);
		
		ModelAndView model = new ModelAndView();
		model.addObject("dashboardDeleted", dashboardDeleted);
		model.addObject("description",description);
		model.addObject("deleteDashboardSelected", true);
		model.addObject("idAuth",idAuth);
		model.setViewName("admin/admin");

		return model;

	}
}