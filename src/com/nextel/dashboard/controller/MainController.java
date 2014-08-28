package com.nextel.dashboard.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.google.gson.Gson;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.TopProjectsBean;
import com.nextel.dashboard.service.NetworkProjectPortfolioService;
import com.nextel.dashboard.service.DashboardService;

@Controller
public class MainController {
	
	@Autowired
	NetworkProjectPortfolioService nppService;
	
	@Autowired
	DashboardService dashboardService;
	
	@Autowired
	ServletContext servletContext;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(HttpServletRequest request) {
		
		
		int totalProjects = 0;
		float totalPercentageProjects = 0;
		
		int totalInitiatives = 0;
		float totalPercentageInitiatives = 0;
		
		//Projects and Initiatives Table1
		List<ProjectBean> projects = nppService.getProjects();
		
		//Obtiene los totales para la tabla
		for(int a=0; a<projects.size(); a++){
			totalProjects = totalProjects + projects.get(a).getTotProject();
			totalPercentageProjects = totalPercentageProjects + projects.get(a).getPercentageProject();
			
			totalInitiatives = totalInitiatives + projects.get(a).getTotInitiatives();
			totalPercentageInitiatives = totalPercentageInitiatives + projects.get(a).getPercentageInitiatives();
		}	
			
		//Table3
		List<TopProjectsBean> listTopProjects = dashboardService.getMonthTopProjects();
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "portfolio");
		
		ModelAndView model = new ModelAndView();
		//model.addObject("data", json);
		model.addObject("datos", projects);
		model.addObject("topProject", listTopProjects);
		model.addObject("totalProjects", totalProjects);
		model.addObject("totalPercentageProjects", totalPercentageProjects);
		model.addObject("totalInitiatives", totalInitiatives);
		model.addObject("totalPercentageInitiatives", totalPercentageInitiatives);
		model.setViewName("projectPortfolio");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/monthlyTarget")
	public @ResponseBody String getMonthlyTarget() {
		
		
		System.out.println("ENTRANDO POR MONTHLY TARGET");
		
		//Table2
		List<ProjectBean> projects = nppService.getMonthlyTarget();
		String jsonData = projects.get(0).getJsonMonthlyData();
		//System.out.println(jsonData);
		
		Gson gson = new Gson();
		String json = gson.toJson(jsonData);
        System.out.println(json);
        
        return json;
	}
	
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/accumulated")
	public @ResponseBody String getAccumulated() {
		
		System.out.println("ENTRANDO POR ACCUMULATED");
		
		//Table4
		List<ProjectBean> projects = nppService.getAccumulated();
		String jsonData = projects.get(0).getJsonAccumulatedData();
		//System.out.println(jsonData);
		
		Gson gson = new Gson();
		String json = gson.toJson(jsonData);
        //System.out.println(json);
        
        return json;
	}

}