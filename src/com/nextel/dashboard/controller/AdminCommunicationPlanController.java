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

import com.nextel.dashboard.bean.CommunicationPlanBean;
import com.nextel.dashboard.service.AdminCommunicationPlanService;

@Controller
public class AdminCommunicationPlanController {
	
	@Autowired
	AdminCommunicationPlanService adminCommunicationPlanService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createCommunicationPlanByProject", method = RequestMethod.GET)
	public ModelAndView createCommunicationPlanByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("createCommunicationPlanSelected", true);
		model.addObject("communicationPlanSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createCommunicationPlan", method = RequestMethod.GET)
	public ModelAndView createCommunicationPlan(@RequestParam(value = "idAuth", required = false) String idAuth,
												@RequestParam(value = "communication", required = false) String communication,
												@RequestParam(value = "frequency", required = false) String frequency,
												@RequestParam(value = "media", required = false) String media,
												@RequestParam(value = "audience", required = false) String audience,
												@RequestParam(value = "deliverable", required = false) String deliverable,
												HttpServletRequest request) {
		
		int newIdCommunicationPlan = adminCommunicationPlanService.getLastIdCommunicationPlan();
		
		CommunicationPlanBean cpb = new CommunicationPlanBean();
		cpb.setIdAuth(idAuth);
		cpb.setIdCommunicationPlan(newIdCommunicationPlan);
		cpb.setCommunication(communication);
		cpb.setFrequency(frequency);
		cpb.setMedia(media);
		cpb.setAudience(audience);
		cpb.setDeliverable(deliverable);
	
		//Create Project Manager
		boolean fourUpCreated = adminCommunicationPlanService.createCommunicationPlan(cpb);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("communication", communication);
		model.addObject("createCommunicationPlanSelected", true);
		model.addObject("communicationPlanCreated", fourUpCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getCommunicationPlanModify", method = RequestMethod.GET)
	public ModelAndView getCommunicationPlanModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       		   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<CommunicationPlanBean> listCommunications = adminCommunicationPlanService.getListCommunications(idAuth);
		session.setAttribute("listCommunications", listCommunications);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listCommunications", listCommunications);
		model.addObject("modifyCommunicationPlanSelected", true);
		model.addObject("communicationPlanForModifySelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getCommunicationPlanDataByDesc", method = RequestMethod.GET)
	public ModelAndView getCommunicationPlanDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											   @RequestParam(value = "idCommunicationPlan", required = false) String idCommunicationPlan,
											   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		CommunicationPlanBean orb = new CommunicationPlanBean();
		orb.setIdAuth(idAuth);
		orb.setIdCommunicationPlan(new Integer(idCommunicationPlan));
		
		List<CommunicationPlanBean> listDataCommunicationPlan = adminCommunicationPlanService.getCommunicationPlanByID(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idCommunicationPlan", idCommunicationPlan);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", session.getAttribute("listSubProjects"));
		model.addObject("datos", listDataCommunicationPlan);		
		model.addObject("modifyCommunicationPlanSelected", true);
		model.addObject("communicationPlanForModifySelected", true);
		model.addObject("communicationPlanDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateCommunicationPlan", method = RequestMethod.GET)
	public ModelAndView updateCommunicationPlan(@RequestParam(value = "idAuth", required = false) String idAuth,
												@RequestParam(value = "idCommunicationPlan", required = false) String idCommunicationPlan,
												@RequestParam(value = "communication", required = false) String communication,
												@RequestParam(value = "frequency", required = false) String frequency,
												@RequestParam(value = "media", required = false) String media,
												@RequestParam(value = "audience", required = false) String audience,
												@RequestParam(value = "deliverable", required = false) String deliverable,
												HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		CommunicationPlanBean cpb = new CommunicationPlanBean();
		cpb.setIdAuth(idAuth);
		cpb.setIdCommunicationPlan(new Integer(idCommunicationPlan));
		cpb.setCommunication(communication);
		cpb.setFrequency(frequency);
		cpb.setMedia(media);
		cpb.setAudience(audience);
		cpb.setDeliverable(deliverable);
		
		boolean communicationPlanupdated = adminCommunicationPlanService.updateCommunicationPlan(cpb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("communicationPlanupdated", communicationPlanupdated);
		model.addObject("communication", communication);
		model.addObject("modifyCommunicationPlanSelected", true);
		model.addObject("communicationPlanForModifySelected", true);
		model.addObject("communicationPlanDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getCommunicationPlanDelete", method = RequestMethod.GET)
	public ModelAndView getCommunicationPlanDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            							   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<CommunicationPlanBean> listCommunications = adminCommunicationPlanService.getListCommunications(idAuth);
		session.setAttribute("listCommunications", listCommunications);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listCommunications", listCommunications);
		model.addObject("deleteCommunicationPlanSelected", true);
		model.addObject("communicationPlanDeleteSelected", true);
		model.addObject("communicationPlanDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getCommunicationPlanDelByDesc", method = RequestMethod.GET)
	public ModelAndView getCommunicationPlanDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											  @RequestParam(value = "idCommunicationPlan", required = false) String idCommunicationPlan,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		CommunicationPlanBean orb = new CommunicationPlanBean();
		orb.setIdAuth(idAuth);
		orb.setIdCommunicationPlan(new Integer(idCommunicationPlan));
		
		List<CommunicationPlanBean> listDataIR = adminCommunicationPlanService.getCommunicationPlanByID(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idCommunicationPlan", idCommunicationPlan);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listSubProjects", session.getAttribute("listSubProjects"));
		model.addObject("datos", listDataIR);		
		model.addObject("deleteCommunicationPlanSelected", true);
		model.addObject("communicationPlanDeleteSelected", true);
		model.addObject("communicationPlanDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteCommunicationPlan", method = RequestMethod.GET)
	public ModelAndView deleteCommunicationPlan(@RequestParam(value = "idAuth", required = false) String idAuth,
								   		@RequestParam(value = "idCommunicationPlan", required = false) String idCommunicationPlan,
								   		@RequestParam(value = "description", required = false) String description,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR idCommunicationPlan " + idCommunicationPlan );
		
		boolean communicationPlanDeleted = adminCommunicationPlanService.deleteCommunicationPlan(idCommunicationPlan);
		
		ModelAndView model = new ModelAndView();
		model.addObject("communicationPlanDeleted", communicationPlanDeleted);
		model.addObject("description",description);
		model.addObject("deleteCommunicationPlanSelected", true);
		model.addObject("idAuth",idAuth);
		model.setViewName("admin/admin");

		return model;

	}
}