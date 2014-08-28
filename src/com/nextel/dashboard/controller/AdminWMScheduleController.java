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
import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.WMScheduleBean;
import com.nextel.dashboard.service.AdminProjectService;
import com.nextel.dashboard.service.AdminWMScheduleService;

@Controller
public class AdminWMScheduleController {
	
	@Autowired
	AdminWMScheduleService adminWMScheduleService;
	
	@Autowired
	AdminProjectService adminFormService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createWMScheduleByProject", method = RequestMethod.GET)
	public ModelAndView createWMScheduleByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		//List PM
		List<PMBean> listPM = adminFormService.getListPM();
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listPM", listPM);
		model.addObject("createWMScheduleSelected", true);
		model.addObject("wmscheduleSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createWMSchedule", method = RequestMethod.GET)
	public ModelAndView createWMSchedule(@RequestParam(value = "idAuth", required = false) String idAuth,
										@RequestParam(value = "scheduleDesc", required = false) String scheduleDesc,
										@RequestParam(value = "scheduleDate", required = false) String scheduleDate,
								  		@RequestParam(value = "cR_Id", required = false) String cR_Id,
								  		@RequestParam(value = "idPM", required = false) String idPM,
								  		@RequestParam(value = "engineering", required = false) String engineering,
								  		@RequestParam(value = "operations", required = false) String operations,
								  		@RequestParam(value = "deployment", required = false) String deployment,
								  		@RequestParam(value = "security", required = false) String security,
								  		HttpServletRequest request) {
		
		int newIdWM = adminWMScheduleService.getLastIdWM();
		
		WMScheduleBean wmb = new WMScheduleBean();
		wmb.setIdAuth(idAuth);
		wmb.setIdWM(newIdWM);
		wmb.setScheduleDesc(scheduleDesc);
		wmb.setScheduleDate(scheduleDate);
		wmb.setCR_Id(new Integer(cR_Id));
		wmb.setIdPM(idPM);
		wmb.setEngineering(engineering);
		wmb.setOperations(operations);
		wmb.setDeployment(deployment);
		wmb.setSecurity(security);
	
		
		//Create Project Manager
		boolean wmscheduleCreated = adminWMScheduleService.createWMSchedule(wmb);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("scheduleDesc", scheduleDesc);
		model.addObject("createWMScheduleSelected", true);
		model.addObject("wmscheduleCreated", wmscheduleCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getWMScheduleModify", method = RequestMethod.GET)
	public ModelAndView getWMScheduleModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       		   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<WMScheduleBean> listWMScheduleDesc = adminWMScheduleService.getListDescriptions(idAuth);
		session.setAttribute("listWMScheduleDesc", listWMScheduleDesc);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listWMScheduleDesc", listWMScheduleDesc);
		model.addObject("modifyWMScheduleSelected", true);
		model.addObject("wmscheduleForModifySelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getWMScheduleDataByDesc", method = RequestMethod.GET)
	public ModelAndView getWMScheduleDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											   @RequestParam(value = "idWM", required = false) String idWM,
											   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		WMScheduleBean wmb = new WMScheduleBean();
		wmb.setIdAuth(idAuth);
		wmb.setIdWM(new Integer(idWM));
		
		List<WMScheduleBean> listDataWM = adminWMScheduleService.getWMScheduleByDesc(wmb);
		//List PM
		List<PMBean> listPM = adminFormService.getListPM();
		//Get PM Name
		String pmName = adminFormService.getPMname(listDataWM.get(0).getIdPM());
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idWM", idWM);
		model.addObject("pmName", pmName);
		model.addObject("listPM", listPM);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listWMScheduleDescriptions", session.getAttribute("listWMScheduleDescriptions"));
		model.addObject("datos", listDataWM);		
		model.addObject("modifyWMScheduleSelected", true);
		model.addObject("wmscheduleForModifySelected", true);
		model.addObject("wmscheduleDescSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateWMSchedule", method = RequestMethod.GET)
	public ModelAndView updateWMSchedule(@RequestParam(value = "idAuth", required = false) String idAuth,
									  	 @RequestParam(value = "idWM", required = false) String idWM,
									  	 @RequestParam(value = "scheduleDesc", required = false) String scheduleDesc,
										 @RequestParam(value = "scheduleDate", required = false) String scheduleDate,
									  	 @RequestParam(value = "cR_Id", required = false) String cR_Id,
									  	 @RequestParam(value = "idPM", required = false) String idPM,
									  	 @RequestParam(value = "engineering", required = false) String engineering,
									  	 @RequestParam(value = "operations", required = false) String operations,
									  	 @RequestParam(value = "deployment", required = false) String deployment,
									  	 @RequestParam(value = "security", required = false) String security,
									  	 HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		if(scheduleDate.equals("")){
			scheduleDate = null;
		}
		
		WMScheduleBean orb = new WMScheduleBean();
		orb.setIdWM(new Integer(idWM));
		orb.setIdAuth(idAuth);
		orb.setScheduleDesc(scheduleDesc);
		orb.setScheduleDate(scheduleDate);
		orb.setCR_Id(new Integer(cR_Id));
		orb.setIdPM(idPM);
		orb.setEngineering(engineering);
		orb.setOperations(operations);
		orb.setDeployment(deployment);
		orb.setSecurity(security);
		
		boolean wmScheduleupdated = adminWMScheduleService.updateWMSchedule(orb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("wmScheduleupdated", wmScheduleupdated);
		model.addObject("scheduleDesc", scheduleDesc);
		model.addObject("modifyWMScheduleSelected", true);
		model.addObject("wmscheduleForModifySelected", true);
		model.addObject("wmscheduleDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getWMScheduleDelete", method = RequestMethod.GET)
	public ModelAndView getWMScheduleDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<WMScheduleBean> listWMScheduleDescriptions = adminWMScheduleService.getListDescriptions(idAuth);
		session.setAttribute("listWMScheduleDescriptions", listWMScheduleDescriptions);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listWMScheduleDescriptions", listWMScheduleDescriptions);
		model.addObject("deleteWMScheduleSelected", true);
		model.addObject("wmscheduleDeleteSelected", true);
		model.addObject("wmscheduleDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getWMScheduleDelByDesc", method = RequestMethod.GET)
	public ModelAndView getWMScheduleDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											  @RequestParam(value = "idWM", required = false) String idWM,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		WMScheduleBean wmb = new WMScheduleBean();
		wmb.setIdAuth(idAuth);
		wmb.setIdWM(new Integer(idWM));
		
		List<WMScheduleBean> listDataWM = adminWMScheduleService.getWMScheduleByDesc(wmb);
		
		//Get PM Name
		String pmName = adminFormService.getPMname(listDataWM.get(0).getIdPM());
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idWM", idWM);
		model.addObject("pmName", pmName);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listWMScheduleDescriptions", session.getAttribute("listWMScheduleDescriptions"));
		model.addObject("datos", listDataWM);		
		model.addObject("deleteWMScheduleSelected", true);
		model.addObject("wmscheduleDeleteSelected", true);
		model.addObject("wmscheduleDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteWMSchedule", method = RequestMethod.GET)
	public ModelAndView deleteWMSchedule(@RequestParam(value = "idAuth", required = false) String idAuth,
								   		 @RequestParam(value = "idWM", required = false) String idWM,
								   		 @RequestParam(value = "scheduleDesc", required = false) String scheduleDesc,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR IdWM " + idWM );
		
		boolean wmScheduleDeleted = adminWMScheduleService.deleteWMSchedule(idWM);
		
		ModelAndView model = new ModelAndView();
		model.addObject("wmscheduleDeleted", wmScheduleDeleted);
		model.addObject("scheduleDesc",scheduleDesc);
		model.addObject("idAuth",idAuth);
		model.addObject("deleteWMScheduleSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
}