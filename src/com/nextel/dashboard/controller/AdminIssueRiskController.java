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
import com.nextel.dashboard.bean.OnRiskProjectsBean;
import com.nextel.dashboard.bean.ProjectsDateBean;
import com.nextel.dashboard.service.AdminIssueRiskService;
import com.nextel.dashboard.service.OnRiskProjectsService;

@Controller
public class AdminIssueRiskController {
	
	@Autowired
	AdminIssueRiskService adminIssueRiskService;
	
	@Autowired
	OnRiskProjectsService onRiskProjectsService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createIssueRiskByProject", method = RequestMethod.GET)
	public ModelAndView createIssueRiskByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("createIssueRiskSelected", true);
		model.addObject("issueRiskSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createIssueRisk", method = RequestMethod.GET)
	public ModelAndView createIssueRisk(@RequestParam(value = "idAuth", required = false) String idAuth,
										@RequestParam(value = "description", required = false) String description,
										@RequestParam(value = "actionPlan", required = false) String actionPlan,
								  		@RequestParam(value = "dueDateBL", required = false) String dueDateBL,
								  		@RequestParam(value = "dueDateFC", required = false) String dueDateFC,
								  		@RequestParam(value = "dueDateACT", required = false) String dueDateACT,
								  		@RequestParam(value = "issueStatus", required = false) String issueStatus,
								  		@RequestParam(value = "priority", required = false) String priority,
								  		@RequestParam(value = "issueType", required = false) String issueType,
								  		HttpServletRequest request) {
		
		
		int newIdIssueRisk = adminIssueRiskService.getLastIssueRisk();
		
		OnRiskProjectsBean orb = new OnRiskProjectsBean();
		orb.setIdAuth(idAuth);
		orb.setIdIssueRisk(newIdIssueRisk);
		orb.setIssueRiskDescription(description);
		orb.setActionPlan(actionPlan);
		orb.setDueDateBL(dueDateBL);
		orb.setDueDateFC(dueDateFC);
		orb.setDueDateACT(dueDateACT);
		orb.setIssueStatus(issueStatus);
		orb.setIssueType(issueType);
		orb.setPriority(priority);
	
		
		//Create Project Manager
		boolean fourUpCreated = adminIssueRiskService.createIssueRisk(orb);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("description", description);
		model.addObject("createIssueRiskSelected", true);
		model.addObject("issueRiskCreated", fourUpCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getIssueRiskModify", method = RequestMethod.GET)
	public ModelAndView getIssueRiskModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       		   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<OnRiskProjectsBean> listIssueRiskDescriptions = adminIssueRiskService.getListDescriptions(idAuth);
		session.setAttribute("listIssueRiskDescriptions", listIssueRiskDescriptions);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listIssueRiskDescriptions", listIssueRiskDescriptions);
		model.addObject("modifyIssueRiskSelected", true);
		model.addObject("issueRiskForModifySelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getIssueRiskDataByDesc", method = RequestMethod.GET)
	public ModelAndView getIssueRiskDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											   @RequestParam(value = "idIssueRisk", required = false) String idIssueRisk,
											   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		OnRiskProjectsBean orb = new OnRiskProjectsBean();
		orb.setIdAuth(idAuth);
		orb.setIdIssueRisk(new Integer(idIssueRisk));
		
		List<OnRiskProjectsBean> listDataIR = adminIssueRiskService.getIssueRiskByDesc(orb);
		
		List<OnRiskProjectsBean> listOnRiskIndividualProject = onRiskProjectsService.getIndividualOnRiskProject(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idIssueRisk", idIssueRisk);
		model.addObject("datosO", listOnRiskIndividualProject);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listIssueRiskDescriptions", session.getAttribute("listIssueRiskDescriptions"));
		model.addObject("datos", listDataIR);		
		model.addObject("modifyIssueRiskSelected", true);
		model.addObject("issueRiskForModifySelected", true);
		model.addObject("issueRiskDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateIssueRisk", method = RequestMethod.GET)
	public ModelAndView updateIssueRisk(@RequestParam(value = "idAuth", required = false) String idAuth,
									  		 @RequestParam(value = "idIssueRisk", required = false) String idIssueRisk,
									  		 @RequestParam(value = "description", required = false) String description,
									  		 @RequestParam(value = "actionPlan", required = false) String actionPlan,
									  		 @RequestParam(value = "dueDateBL", required = false) String dueDateBL,
									  		 @RequestParam(value = "dueDateFC", required = false) String dueDateFC,
									  		 @RequestParam(value = "dueDateACT", required = false) String dueDateACT,
									  		 @RequestParam(value = "issueStatus", required = false) String issueStatus,
									  		 @RequestParam(value = "priority", required = false) String priority,
									  		 @RequestParam(value = "issueType", required = false) String issueType,
									  		 HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		if(dueDateBL.equals("")){
			dueDateBL = null;
		}
		if(dueDateFC.equals("")){
			dueDateFC = null;
		}
		if(dueDateACT.equals("")){
			dueDateACT = null;
		}
		
		OnRiskProjectsBean orb = new OnRiskProjectsBean();
		orb.setIdIssueRisk(new Integer(idIssueRisk));
		orb.setIdAuth(idAuth);
		orb.setIssueRiskDescription(description);;
		orb.setActionPlan(actionPlan);
		orb.setDueDateBL(dueDateBL);
		orb.setDueDateFC(dueDateFC);
		orb.setDueDateACT(dueDateACT);
		orb.setIssueStatus(issueStatus);
		orb.setPriority(priority);
		orb.setIssueType(issueType);
		
		boolean issueRiskupdated = adminIssueRiskService.updateIssueRisk(orb);
		List<OnRiskProjectsBean> listOnRiskIndividualProject = onRiskProjectsService.getIndividualOnRiskProject(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("datosO", listOnRiskIndividualProject);
		model.addObject("idAuth", idAuth);
		model.addObject("issueRiskupdated", issueRiskupdated);
		model.addObject("description", description);
		model.addObject("modifyIssueRiskSelected", true);
		model.addObject("issueRiskForModifySelected", true);
		model.addObject("issueRiskDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getIssueRiskDelete", method = RequestMethod.GET)
	public ModelAndView getIssueRiskDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<OnRiskProjectsBean> listIssueRiskDescriptions = adminIssueRiskService.getListDescriptions(idAuth);
		session.setAttribute("listIssueRiskDescriptions", listIssueRiskDescriptions);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listDescriptions", listIssueRiskDescriptions);
		model.addObject("deleteIssueRiskSelected", true);
		model.addObject("issueRiskDeleteSelected", true);
		model.addObject("issueRiskDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getIssueRiskDelByDesc", method = RequestMethod.GET)
	public ModelAndView getIssueRiskDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											  @RequestParam(value = "idIssueRisk", required = false) String idIssueRisk,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		OnRiskProjectsBean orb = new OnRiskProjectsBean();
		orb.setIdAuth(idAuth);
		orb.setIdIssueRisk(new Integer(idIssueRisk));
		
		List<OnRiskProjectsBean> listDataIR = adminIssueRiskService.getIssueRiskByDesc(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idIssueRisk", idIssueRisk);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listDescriptions", session.getAttribute("listDescriptions"));
		model.addObject("datos", listDataIR);		
		model.addObject("deleteIssueRiskSelected", true);
		model.addObject("issueRiskDeleteSelected", true);
		model.addObject("issueRiskDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteIssueRisk", method = RequestMethod.GET)
	public ModelAndView deleteIssueRisk(@RequestParam(value = "idAuth", required = false) String idAuth,
								   		@RequestParam(value = "idIssueRisk", required = false) String idIssueRisk,
								   		@RequestParam(value = "description", required = false) String description,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR idIssueRisk " + idIssueRisk );
		
		boolean issueRiskDeleted = adminIssueRiskService.deleteIssueRisk(idIssueRisk);
		
		ModelAndView model = new ModelAndView();
		model.addObject("issueRiskDeleted", issueRiskDeleted);
		model.addObject("description",description);
		model.addObject("idAuth",idAuth);
		model.setViewName("admin/admin");

		return model;

	}
}