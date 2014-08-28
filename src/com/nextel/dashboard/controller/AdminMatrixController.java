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

import com.nextel.dashboard.bean.MatrixBean;
import com.nextel.dashboard.service.AdminMatrixService;

@Controller
public class AdminMatrixController {
	
	@Autowired
	AdminMatrixService adminMatrixService;
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createMatrixByProject", method = RequestMethod.GET)
	public ModelAndView createMatrixByProject(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("createMatrixSelected", true);
		model.addObject("matrixSelectedForCreate", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createMatrix", method = RequestMethod.GET)
	public ModelAndView createMatrix(@RequestParam(value = "idAuth", required = false) String idAuth,
										@RequestParam(value = "nameTeam", required = false) String nameTeam,
										@RequestParam(value = "nameTeamPuesto", required = false) String nameTeamPuesto,
								  		@RequestParam(value = "support", required = false) String support,
								  		@RequestParam(value = "supportPuesto", required = false) String supportPuesto,
								  		@RequestParam(value = "escalationLevel", required = false) String escalationLevel,
								  		@RequestParam(value = "escalationLevelPuesto", required = false) String escalationLevelPuesto,
								  		HttpServletRequest request) {

		
		
		int newIdScalingMatrix = adminMatrixService.getIdScalingMatrix();
		
		MatrixBean mb = new MatrixBean();
		mb.setIdAuth(idAuth);
		mb.setIdScalingMatrix(newIdScalingMatrix);
		mb.setNameTeam(nameTeam);
		mb.setNameTeamPuesto(nameTeamPuesto);
		mb.setSupport(support);
		mb.setSupportPuesto(supportPuesto);
		mb.setEscalationLevel(escalationLevel);
		mb.setEscalationLevelPuesto(escalationLevelPuesto);
	
		//Create Project Manager
		boolean fourUpCreated = adminMatrixService.createMatrix(mb);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("nameTeam", nameTeam);
		model.addObject("createMatrixSelected", true);
		model.addObject("matrixCreated", fourUpCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getMatrixModify", method = RequestMethod.GET)
	public ModelAndView getMatrixModify(@RequestParam(value = "idAuth", required = false) String idAuth,
			                       		HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<MatrixBean> getListNameTeam = adminMatrixService.getListNameTeam(idAuth);
		session.setAttribute("getListNameTeam", getListNameTeam);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("getListNameTeam", getListNameTeam);
		model.addObject("modifyMatrixSelected", true);
		model.addObject("matrixForModifySelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getMatrixDataByDesc", method = RequestMethod.GET)
	public ModelAndView getMatrixDataByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											   @RequestParam(value = "idScalingMatrix", required = false) String idScalingMatrix,
											   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		MatrixBean mb = new MatrixBean();
		mb.setIdAuth(idAuth);
		mb.setIdScalingMatrix(new Integer(idScalingMatrix));
		
		List<MatrixBean> listDataMatrix = adminMatrixService.getMatrixByID(mb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idScalingMatrix", idScalingMatrix);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listNameTeam", session.getAttribute("listNameTeam"));
		model.addObject("datos", listDataMatrix);		
		model.addObject("modifyMatrixSelected", true);
		model.addObject("matrixForModifySelected", true);
		model.addObject("matrixDescSelected", true);
		model.addObject("throwTimeline", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateMatrix", method = RequestMethod.GET)
	public ModelAndView updateMatrix(@RequestParam(value = "idAuth", required = false) String idAuth,
										@RequestParam(value = "idScalingMatrix", required = false) String idScalingMatrix,
										@RequestParam(value = "nameTeam", required = false) String nameTeam,
										@RequestParam(value = "nameTeamPuesto", required = false) String nameTeamPuesto,
										@RequestParam(value = "support", required = false) String support,
										@RequestParam(value = "supportPuesto", required = false) String supportPuesto,
										@RequestParam(value = "escalationLevel", required = false) String escalationLevel,
										@RequestParam(value = "escalationLevelPuesto", required = false) String escalationLevelPuesto,
									  	HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		MatrixBean mb = new MatrixBean();
		mb.setIdAuth(idAuth);
		mb.setIdScalingMatrix(new Integer(idScalingMatrix));
		mb.setNameTeam(nameTeam);
		mb.setNameTeamPuesto(nameTeamPuesto);
		mb.setSupport(support);
		mb.setSupportPuesto(supportPuesto);
		mb.setEscalationLevel(escalationLevelPuesto);
		mb.setEscalationLevelPuesto(escalationLevelPuesto);
		
		boolean matrixupdated = adminMatrixService.updateMatrix(mb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("matrixupdated", matrixupdated);
		model.addObject("nameTeam", nameTeam);
		model.addObject("modifyMatrixSelected", true);
		model.addObject("matrixForModifySelected", true);
		model.addObject("matrixDescSelected", true);
		model.addObject("throwTimeline", true);
		
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getMatrixDelete", method = RequestMethod.GET)
	public ModelAndView getMatrixDelete(@RequestParam(value = "idAuth", required = false) String idAuth,
            							   HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");

		List<MatrixBean> getListNameTeam = adminMatrixService.getListNameTeam(idAuth);
		session.setAttribute("getListNameTeam", getListNameTeam);

		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listNameTeam", getListNameTeam);
		model.addObject("deleteMatrixSelected", true);
		model.addObject("matrixDeleteSelected", true);
		model.addObject("matrixDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getMatrixDelByDesc", method = RequestMethod.GET)
	public ModelAndView getMatrixDelByDesc(@RequestParam(value = "idAuth", required = false) String idAuth,
											  @RequestParam(value = "idScalingMatrix", required = false) String idScalingMatrix,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		MatrixBean mb = new MatrixBean();
		mb.setIdAuth(idAuth);
		mb.setIdScalingMatrix(new Integer(idScalingMatrix));
		
		List<MatrixBean> listDataIR = adminMatrixService.getMatrixByID(mb);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuth", idAuth);
		model.addObject("idScalingMatrix", idScalingMatrix);
		model.addObject("listProjects", session.getAttribute("listProjects"));
		model.addObject("listNameTeam", session.getAttribute("listNameTeam"));
		model.addObject("datos", listDataIR);		
		model.addObject("deleteMatrixSelected", true);
		model.addObject("matrixDeleteSelected", true);
		model.addObject("matrixDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteMatrix", method = RequestMethod.GET)
	public ModelAndView deleteMatrix(@RequestParam(value = "idAuth", required = false) String idAuth,
								   		@RequestParam(value = "idScalingMatrix", required = false) String idScalingMatrix,
								   		@RequestParam(value = "nameTeam", required = false) String nameTeam,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR idScalingMatrix " + idScalingMatrix );
		
		boolean matrixDeleted = adminMatrixService.deleteMatrix(idScalingMatrix);
		
		ModelAndView model = new ModelAndView();
		model.addObject("matrixDeleted", matrixDeleted);
		model.addObject("nameTeam",nameTeam);
		model.addObject("idAuth",idAuth);
		model.addObject("deleteMatrixSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
}