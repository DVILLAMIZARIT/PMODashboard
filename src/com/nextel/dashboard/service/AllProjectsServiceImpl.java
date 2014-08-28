package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.AccomplishmentsBean;
import com.nextel.dashboard.bean.AllProjectsBean;
import com.nextel.dashboard.bean.MilestoneBean;
import com.nextel.dashboard.bean.NextStepsBean;
import com.nextel.dashboard.dao.AllProjectsDAO;
import com.nextel.dashboard.util.ExcelGeneratorImpl;

@Service
@Transactional(readOnly=true)
public class AllProjectsServiceImpl implements AllProjectsService {
	
	@Autowired
	private AllProjectsDAO allProjectsDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<AllProjectsBean> listAllProjects = null;
	private List<AccomplishmentsBean> listAccomplishments = null;
	private List<NextStepsBean> listNextSteps = null;
	
	private List<MilestoneBean> listMilestone = null;
	private List<AllProjectsBean> listSearchProject = null;
	
	
	/*
	 * 
	 * */
	public List<AllProjectsBean> getAllProjects(){
		listAllProjects = new ArrayList<AllProjectsBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listAllProjects = allProjectsDAO.getAllProjects();
				
		return listAllProjects;
	}
	
	
	/*
	 * 
	 * */
	public List<AccomplishmentsBean> getAccomplishments(String idAuth){
		listAccomplishments = new ArrayList<AccomplishmentsBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listAccomplishments = allProjectsDAO.getAccomplishments(idAuth);
		
		return listAccomplishments;
	}
	
	
	/*
	 * 
	 * */
	public List<NextStepsBean> getNextSteps(String idAuth){
		listNextSteps = new ArrayList<NextStepsBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listNextSteps = allProjectsDAO.getNextSteps(idAuth);
		
		return listNextSteps;
	}
	
	
	/*
	 * 
	 * */
	public List<MilestoneBean> getMilestones(String idAuth){
		listMilestone = new ArrayList<MilestoneBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listMilestone = allProjectsDAO.getMilestones(idAuth);
		
		return listMilestone;
	}
	
	
	/*
	 * 
	 * */
	public List<AllProjectsBean> searchProject(String projectName){
		listSearchProject = new ArrayList<AllProjectsBean>();
		
		listSearchProject = allProjectsDAO.searchProject(projectName);
		
		return listSearchProject;
	}
	
	
	/*
	 * 
	 * */
	public List<AllProjectsBean> getAllProjectsFilterByPM(String filterPM){
		listAllProjects = new ArrayList<AllProjectsBean>();
		
		listAllProjects = allProjectsDAO.getAllProjectsFilterByPM(filterPM);
				
		return listAllProjects;
	}
	
	
}
