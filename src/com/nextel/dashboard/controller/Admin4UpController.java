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

import com.nextel.dashboard.bean.AccomplishmentsBean;
import com.nextel.dashboard.bean.FourUpBean;
import com.nextel.dashboard.bean.NextStepsBean;
import com.nextel.dashboard.service.Admin4UPService;
import com.nextel.dashboard.service.AllProjectsService;

@Controller
public class Admin4UpController {
	
	@Autowired
	Admin4UPService admin4upService;
	
	@Autowired
	AllProjectsService allProjectsService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/create4upByProject", method = RequestMethod.GET)
	public ModelAndView create4upByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<FourUpBean>listTypes = admin4upService.getListTypes();
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listTypes", listTypes);
		model.addObject("create4upSelected", true);
		model.addObject("fourUpSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/create4up", method = RequestMethod.GET)
	public ModelAndView create4up(@RequestParam(value = "idAuth", required = false) String idAuth,
								  @RequestParam(value = "description", required = false) String description,
								  @RequestParam(value = "type", required = false) String type,
								  @RequestParam(value = "dateups", required = false) String dateups,
								  @RequestParam(value = "flag", required = false) String flag,
								  HttpServletRequest request) {
		
		
		int newId4up = admin4upService.getLastId4up();
		
		FourUpBean fub = new FourUpBean();
		fub.setIdAuth(idAuth);
		fub.setId4ups(newId4up);
		fub.setDescription(description);
		fub.setType(type);
		fub.setDateUps(dateups);
		fub.setFlag(flag);
	
		
		//Create Project Manager
		boolean fourUpCreated = admin4upService.create4up(fub);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("description", description);
		model.addObject("create4upSelected", true);
		model.addObject("fourUpCreated", fourUpCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/get4upModify", method = RequestMethod.GET)
	public ModelAndView get4upModify(@RequestParam(value = "idAuth", required = false) String idAuth, 
									 //@RequestParam(value = "nameProjectHead", required = false) String nameProjectHead,
									 HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<FourUpBean> list4upDescriptions = admin4upService.getListDescriptions(idAuth);
		session.setAttribute("list4upDescriptions", list4upDescriptions);
		//session.setAttribute("nameProjectHead", nameProjectHead);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("list4upDescriptions", list4upDescriptions);
		model.addObject("modify4upSelected", true);
		model.addObject("fourupForModifySelected", true);
		model.addObject("fourupDescSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/get4upDataByDesc", method = RequestMethod.GET)
	public ModelAndView get4upDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
												  @RequestParam(value = "id4ups", required = false) String id4ups,
												  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		FourUpBean fub = new FourUpBean();
		fub.setIdAuth(idAuth);
		fub.setId4ups(new Integer(id4ups));
		
		List<FourUpBean> listData4ups = admin4upService.get4upsByDesc(fub);
		List<FourUpBean>listTypes = admin4upService.getListTypes();
		
		List<AccomplishmentsBean> listAccomplishments = allProjectsService.getAccomplishments(idAuth);
		List<NextStepsBean> listNextSteps = allProjectsService.getNextSteps(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("id4ups", id4ups);
		model.addObject("listTypes", listTypes);
		model.addObject("datosA", listAccomplishments);
		model.addObject("datosN", listNextSteps);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("list4upDescriptions", session.getAttribute("list4upDescriptions"));
		model.addObject("datos", listData4ups);		
		model.addObject("fourupForModifySelected", true);
		model.addObject("modify4upSelected", true);
		model.addObject("fourupDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/update4up", method = RequestMethod.GET)
	public ModelAndView update4up(@RequestParam(value = "idAuth", required = false) String idAuth,
									  		 @RequestParam(value = "id4ups", required = false) String id4ups,
									  		 @RequestParam(value = "description", required = false) String description,
									  		 @RequestParam(value = "type", required = false) String type,
									  		 @RequestParam(value = "dateups", required = false) String dateups,
									  		 @RequestParam(value = "flag", required = false) String flag,
									  		 HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		FourUpBean fub = new FourUpBean();
		fub.setId4ups(new Integer(id4ups));
		fub.setIdAuth(idAuth);
		fub.setDescription(description);
		fub.setType(type);
		fub.setDateUps(dateups);
		fub.setFlag(flag);
		
		boolean fouruppdated = admin4upService.update4up(fub);
		
		List<AccomplishmentsBean> listAccomplishments = allProjectsService.getAccomplishments(idAuth);
		List<NextStepsBean> listNextSteps = allProjectsService.getNextSteps(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("id4ups", id4ups);
		model.addObject("datosA", listAccomplishments);
		model.addObject("datosN", listNextSteps);
		//model.addObject("list4upDescriptions", session.getAttribute("list4upDescriptions"));
		//model.addObject("nameProjectHead", session.getAttribute("nameProjectHead"));
		model.addObject("fouruppdated", fouruppdated);
		model.addObject("description", description);
		model.addObject("fourupForModifySelected", true);
		model.addObject("modify4upSelected", true);
		model.addObject("fourupDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/get4upsDelete", method = RequestMethod.GET)
	public ModelAndView get4upsDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<FourUpBean> list4upDescriptions = admin4upService.getListDescriptions(idAuth);
		session.setAttribute("list4upDescriptions", list4upDescriptions);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listDescriptions", list4upDescriptions);
		model.addObject("delete4upSelected", true);
		model.addObject("fourupForDeleteSelected", true);
		model.addObject("fourupDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/get4upsDelByDesc", method = RequestMethod.GET)
	public ModelAndView getProjectsDateDataDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
													 @RequestParam(value = "id4ups", required = false) String id4ups,
													 HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PRIMER id4ups " + id4ups );
		
		FourUpBean fub = new FourUpBean();
		fub.setIdAuth(idAuth);
		fub.setId4ups(new Integer(id4ups));
		
		List<FourUpBean> listData4ups = admin4upService.get4upsByDesc(fub);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("id4ups", id4ups);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listDescriptions", session.getAttribute("listDescriptions"));
		model.addObject("datos", listData4ups);		
		model.addObject("fourupForDeleteSelected", true);
		model.addObject("delete4upSelected", true);
		model.addObject("fourupDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/delete4ups", method = RequestMethod.GET)
	public ModelAndView delete4ups(@RequestParam(value = "idAuth", required = false) String idAuth,
								   @RequestParam(value = "id4ups", required = false) String id4ups,
								   @RequestParam(value = "description", required = false) String description,
								   HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		boolean fourupDeleted = admin4upService.delete4up(id4ups);
		
		ModelAndView model = new ModelAndView();
		model.addObject("fourupDeleted", fourupDeleted);
		model.addObject("description",description);
		model.addObject("idAuth",idAuth);
		model.setViewName("admin/admin");

		return model;

	}	
}