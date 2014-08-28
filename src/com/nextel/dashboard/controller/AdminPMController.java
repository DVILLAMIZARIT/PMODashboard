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

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.service.AdminPMService;

@Controller
public class AdminPMController {
	
	@Autowired
	AdminPMService adminPMService;
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createPM", method = RequestMethod.GET)
	public ModelAndView createProjectManager(@RequestParam(value = "idPM", required = false) String idPM,
											 @RequestParam(value = "pmName", required = false) String pmName,
									  		 @RequestParam(value = "radio", required = false) String radio,
									  		 @RequestParam(value = "ext", required = false) String ext,
									  		 @RequestParam(value = "celular", required = false) String celular,
									  		 @RequestParam(value = "skype", required = false) String skype,
									  		 @RequestParam(value = "email", required = false) String email,
									  		 HttpServletRequest request) {
		
		
		PMBean pmb = new PMBean();
		pmb.setIdPM(idPM);
		pmb.setPmName(pmName);
		pmb.setRadio(radio);
		pmb.setExt(new Integer(ext));
		pmb.setCelular(celular);
		pmb.setSkype(skype);
		pmb.setEmail(email);
		
		//Create Project Manager
		boolean pmCreated = adminPMService.createPM(pmb);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("pmCreated", pmCreated);
		model.addObject("pmName", pmName);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getPMModify", method = RequestMethod.GET)
	public ModelAndView getPMModify(@RequestParam(value = "idPM", required = false) String idPM,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<PMBean> listPMData = adminPMService.getDataPMByIdPM(idPM);		
		
		ModelAndView model = new ModelAndView();
		model.addObject("idPM", idPM);
		model.addObject("listPMs", session.getAttribute("listPMs"));
		model.addObject("datos", listPMData);
		model.addObject("modifyProjectManagerSelected", true);
		model.addObject("pmSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getPMDataDelete", method = RequestMethod.GET)
	public ModelAndView getProjectManagerDelete(@RequestParam(value = "idPM", required = false) String idPM,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("DELETE "+ idPM);
		
		//Data from ID Auth
		List<PMBean> listPMData = adminPMService.getDataPMByIdPM(idPM);	
		
		ModelAndView model = new ModelAndView();
		model.addObject("idPM", idPM);
		model.addObject("listPMEnabled", session.getAttribute("listPMEnabled"));
		model.addObject("datos", listPMData);
		model.addObject("deleteProjectManagerSelected", true);
		model.addObject("pmSelectedForDelete", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updatePM", method = RequestMethod.GET)
	public ModelAndView updateProjectManager(@RequestParam(value = "idPM", required = false) String idPM,
									  		 @RequestParam(value = "pmName", required = false) String pmName,
									  		 @RequestParam(value = "radio", required = false) String radio,
									  		 @RequestParam(value = "ext", required = false) String ext,
									  		 @RequestParam(value = "celular", required = false) String celular,
									  		 @RequestParam(value = "skype", required = false) String skype,
									  		 @RequestParam(value = "email", required = false) String email,
									  		 @RequestParam(value = "pmenabled", required = false) String pmenabled,
									  		 HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		PMBean pmb = new PMBean();
		pmb.setIdPM(idPM);
		pmb.setPmName(pmName);
		pmb.setRadio(radio);
		pmb.setExt(new Integer(ext));
		pmb.setCelular(celular);
		pmb.setSkype(skype);
		pmb.setEmail(email);
		pmb.setEnabled(pmenabled);
		
		boolean pmUpdated = adminPMService.updatePM(pmb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("pmUpdated", pmUpdated);
		model.addObject("idPM",idPM);
		model.addObject("pmName", pmName);
		model.setViewName("admin/admin");

		return model;

	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deletePM", method = RequestMethod.GET)
	public ModelAndView deleteProjectManager(@RequestParam(value = "idPM", required = false) String idPM,
											 @RequestParam(value = "pmName", required = false) String pmName,
			  						  HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		boolean pmDeleted = adminPMService.deletePM(idPM);
		
		ModelAndView model = new ModelAndView();
		model.addObject("projectDeleted", pmDeleted);
		model.addObject("pmName",pmName);
		model.addObject("idAuth",idPM);
		model.setViewName("admin/admin");

		return model;

	}	
}