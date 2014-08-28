package com.nextel.dashboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nextel.dashboard.bean.OnRiskProjectsBean;
import com.nextel.dashboard.service.OnRiskProjectsService;

@Controller
public class OnRiskProjectsController {
	
	@Autowired
	OnRiskProjectsService onRiskProjectsService;


	@RequestMapping(value = "/onRisk", method = RequestMethod.GET)
	public ModelAndView onRiskProjects(HttpServletRequest request) {

		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "onRisk");
		
		List<OnRiskProjectsBean> listOnRiskProjects = onRiskProjectsService.getOnRiskProjects();
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listOnRiskProjects);
		model.setViewName("onRiskProjects");

		return model;

	}

}