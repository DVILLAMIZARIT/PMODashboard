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

import com.nextel.dashboard.bean.TopProjectsBean;
import com.nextel.dashboard.service.DashboardService;

@Controller
public class DashboardController {
	
	@Autowired
	DashboardService topProjectsService;


	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public ModelAndView topProjects(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "dashboard");
		
		List<TopProjectsBean> listTopProjects = topProjectsService.getTopProjects();
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listTopProjects);
		model.addObject("priSelected", "ALL");
		model.addObject("proSelected", "ALL");
		model.setViewName("dashboard");

		return model;

	}

	
	@RequestMapping(value = "/dashboardFilter", method = RequestMethod.GET)
	public ModelAndView dashboardFilter(@RequestParam(value = "filterPriority", required = false) String filterPriority, 
			                            @RequestParam(value = "filterProject", required = false) String filterProject, 
			                            HttpServletRequest request) {


		List<TopProjectsBean> listTopProjects = null;
		
		System.out.println("FILTRANDO YA EL DASHBOARD " + filterPriority + "---" + filterProject);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "dashboard");
		
		if(filterPriority.equals("ALL") && filterProject.equals("ALL")){
			listTopProjects = topProjectsService.getTopProjects();
		}
		else if(!filterPriority.equals("ALL") && filterProject.equals("ALL")){
			listTopProjects = topProjectsService.getTopProjectsFilterByPriority(filterPriority);
		}
		else if(!filterProject.equals("ALL") && filterPriority.equals("ALL")){
			listTopProjects = topProjectsService.getTopProjectsFilterByProject(filterProject);
		}
		else{
			listTopProjects = topProjectsService.getTopProjectsFilterByAll(filterPriority, filterProject);
		}
		
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listTopProjects);
		model.addObject("priSelected", filterPriority);
		model.addObject("proSelected", filterProject);
		model.setViewName("dashboard");

		return model;

	}
}