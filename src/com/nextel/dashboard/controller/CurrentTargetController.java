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

import com.nextel.dashboard.bean.CurrentTargetBean;
import com.nextel.dashboard.bean.TopProjectsBean;
import com.nextel.dashboard.service.CurrentTargetService;

@Controller
public class CurrentTargetController {
	
	@Autowired
	CurrentTargetService currentTargetService;


	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public ModelAndView currentTarget(HttpServletRequest request) {

		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		
		List<CurrentTargetBean> listCurrentTarget = currentTargetService.getCurrentTarget();
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listCurrentTarget);
		model.addObject("proSelected", "ALL");
		model.setViewName("currentTarget");

		return model;

	}
	
	
	@RequestMapping(value = "/currentTargetFilter", method = RequestMethod.GET)
	public ModelAndView currentTargetFilter(@RequestParam(value = "filterProject", required = false) String filterProject, HttpServletRequest request) {


		List<CurrentTargetBean> listCurrentTarget = null;
		
		System.out.println("FILTRANDO YA EL CURRENT " + filterProject);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "dashboard");
		
		if(filterProject.equals("ALL")){
			listCurrentTarget = currentTargetService.getCurrentTarget();
		}
		else{
			listCurrentTarget = currentTargetService.getCurrentTargetFilterByProject(filterProject);
		}
		
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listCurrentTarget);
		model.addObject("proSelected", filterProject);
		model.setViewName("currentTarget");

		return model;

	}

}