package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.TopProjectsBean;
import com.nextel.dashboard.dao.DashboardDAO;

@Service
@Transactional(readOnly=true)
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	private DashboardDAO dashboardDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
	private List<TopProjectsBean> listTopProjects = null;
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjects(){
		listTopProjects = new ArrayList<TopProjectsBean>();
		
		listTopProjects = dashboardDAO.getTopProjects();
		
		return listTopProjects;
	}
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getMonthTopProjects(){
		listTopProjects = new ArrayList<TopProjectsBean>();
		
		listTopProjects = dashboardDAO.getMonthTopProjects();
		
		return listTopProjects;
	}
	
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjectsFilterByPriority(String priority){
		listTopProjects = new ArrayList<TopProjectsBean>();
		
		listTopProjects = dashboardDAO.getTopProjectsFilterByPriority(priority);
		
		return listTopProjects;
	}

	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjectsFilterByProject(String project){
		listTopProjects = new ArrayList<TopProjectsBean>();
		
		listTopProjects = dashboardDAO.getTopProjectsFilterByProject(project);
		
		return listTopProjects;
	}
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjectsFilterByAll(String priority, String project){
		listTopProjects = new ArrayList<TopProjectsBean>();
		
		listTopProjects = dashboardDAO.getTopProjectsFilterByAll(priority, project);
		
		return listTopProjects;
	}
	
	
}
