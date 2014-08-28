package com.nextel.dashboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nextel.dashboard.bean.TimelineBean;
import com.nextel.dashboard.service.TimelineService;

@Controller
public class TimeLineController {
	
	@Autowired
	TimelineService timelineService;


	@RequestMapping(value = "/timeLine", method = RequestMethod.GET)
	public ModelAndView timeLine(@RequestParam(value = "idAuth", required = false) String idAuth, 
			   					 @RequestParam(value = "projectName", required = false) String projectName, 
			   					 HttpServletRequest request) {
		
		int totalTimelines = timelineService.getTotalTimelines(idAuth);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "timeline");
		
		System.out.println("LLEGO AL TIMELINE " + idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuthProject", idAuth);
		model.addObject("projectNameTitle", projectName);
		model.addObject("totalTimelines", totalTimelines);
		model.setViewName("timeline");

		return model;
	}
	
	
	
	@RequestMapping(value = "/getTimeline")
	public @ResponseBody String getTimeline(@RequestParam(value = "idAuth", required = false) String idAuth) {
		
		List<TimelineBean> listTimeline = timelineService.getTimeline(idAuth);
		String jsonData = listTimeline.get(0).getJsonTimeline();
		//System.out.println(jsonData);
		
		Gson gson = new Gson();
		String json = gson.toJson(jsonData);
        //System.out.println(json);
        
        return json;
	}

}