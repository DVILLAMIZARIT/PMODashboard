package com.nextel.dashboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 



import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.nextel.dashboard.bean.WMScheduleBean;
import com.nextel.dashboard.service.WMScheduleService;
 	
@Controller
public class WMScheduleController {
 
	@Autowired
	WMScheduleService serviceSchedule;
	
		int music = 12;
	
		/*
		 * 
		 * */
        @RequestMapping("/myplanner")
        public ModelAndView planner(HttpServletRequest request) throws Exception {
        	
        	//Set the session to save the image of the header.jsp
    		HttpSession session = request.getSession();
    		session.setAttribute("headerImg", "wmschedule");
        	
        	DHXPlanner p = new DHXPlanner("./codebase/", DHXSkin.CLASSIC);
        	p.setInitialDate(2014, 5, 01);
        	p.setInitialView("month");
        	p.setWidth(900);
        	p.load("events", DHXDataFormat.JSON);
 
        	ModelAndView mnv = new ModelAndView("events");
        	mnv.addObject("body", p.render());
        	return mnv;
        }
 
        
        
        /*
         * 
         * */
        @RequestMapping("/events**")
        @ResponseBody public String events(HttpServletRequest request) {
        		System.out.println("EJECUTANDO EL EVENTO");
        	
                CustomEventsManager evs = new CustomEventsManager(request);
                return evs.run();
        }
        
        
        /*
         * 
         * */
        @RequestMapping("/timeline")
        public ModelAndView scheduler(HttpServletRequest request) throws Exception {
        	DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
        	s.setWidth(1000);
        	s.setHeight(126);
        	s.setInitialDate(2013, 3, 11);
        	s.setInitialView("timeline");
        	
        	// creating required view
        	ModelAndView mnv = new ModelAndView("layout");
        	mnv.addObject("body","schedulers place");
        	return mnv;
        }
         
        
        @RequestMapping("/timelineEvents")
        @ResponseBody public String timelineEvents (HttpServletRequest request) {
        	return "events list";
        }
}
