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

import com.nextel.dashboard.bean.DelayedProjectsBean;
import com.nextel.dashboard.service.DelayedProjectsService;

@Controller
public class DelayedProjectsController {
	
	@Autowired
	DelayedProjectsService delayedProjectsService;


	@RequestMapping(value = "/delayed", method = RequestMethod.GET)
	public ModelAndView delayedProjects(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "delayed");
		
		List<DelayedProjectsBean> listDelayedProjects = delayedProjectsService.getDelayedProjects();
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listDelayedProjects);
		model.setViewName("delayedProjects");

		return model;

	}

}