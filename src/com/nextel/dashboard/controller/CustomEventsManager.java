package com.nextel.dashboard.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.nextel.dashboard.bean.WMScheduleBean;
import com.nextel.dashboard.service.AllProjectsService;
import com.nextel.dashboard.service.WMScheduleService;
import com.nextel.dashboard.service.WMScheduleServiceImpl;

public class CustomEventsManager extends DHXEventsManager {

	WMScheduleService serviceSchedule = new WMScheduleServiceImpl();
	
	public CustomEventsManager(HttpServletRequest request){
		super(request);
	}
	
	public Iterable<DHXEv> getEvents(){
		ArrayList<DHXEv> events = new ArrayList<DHXEv>(); 
		
		String id = null;
		String projectName = null;
		String scheduleDate = null;
		String endDate = null;
		
		DHXEventsManager.date_format = "yyyy-MM-dd";
		
		try {	
			
			List<WMScheduleBean> listSchedule = serviceSchedule.getEvents();
			
			for(int i=0; i<listSchedule.size(); i++){
				
				id = listSchedule.get(i).getIdAuth();
				projectName = listSchedule.get(i).getProjectName();
				scheduleDate = listSchedule.get(i).getScheduleDate();
				endDate = listSchedule.get(i).getEndDate();
				
				
				DHXEvent ev1 = new DHXEvent();
	            ev1.setId(id);
	            ev1.setStart_date(scheduleDate);
	            ev1.setEnd_date(endDate);
	            ev1.setText(projectName);
	            
	            events.add(ev1);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//DHXEventsManager.date_format = "MM/dd/yyyy HH:mm";
		DHXEventsManager.date_format = "MM/dd/yyyy";
	 
		//return evs;
		return events;
	}
	
	
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		try {
			System.out.println("EVENTO A MOSTRAR " + status);
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	
	
}
