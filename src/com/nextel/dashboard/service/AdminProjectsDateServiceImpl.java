package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.ProjectsDateBean;
import com.nextel.dashboard.dao.AdminProjectDAO;
import com.nextel.dashboard.dao.AdminProjectsDateDAO;


@Service
@Transactional(readOnly=true)
public class AdminProjectsDateServiceImpl implements AdminProjectsDateService {
	
	@Autowired
	private AdminProjectsDateDAO adminProjectsDateDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<ProjectsDateBean> listDescriptions = null;
	private List<ProjectsDateBean> listDataProjectsDate = null;
	private List<ProjectBean> listProjects = null;
	
	
	
	
	/*
	 * 
	 * */
	public int getLastIdDate(){
		int lastIdDate = 0;
		
		lastIdDate = adminProjectsDateDAO.getLastIdDate();
				
		return lastIdDate;
	}
	
	
	
	/*
	 * 
	 * */
	public boolean createProjectDate(ProjectsDateBean pdb){
		boolean created = false;
		
		created = adminProjectsDateDAO.createProjectDate(pdb);
				
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getListProjects(){
		listProjects = adminProjectsDateDAO.getListProjects();
				
		return listProjects;
	}
	
	

	/*
	 * 
	 * */
	public boolean updateProjectDate(ProjectsDateBean pdb){
		boolean projectUpdated = adminProjectsDateDAO.updateProjectDate(pdb);
		
		return projectUpdated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteProjectDate(ProjectsDateBean pdb){
		boolean projectDeleted = adminProjectsDateDAO.deleteProjectDate(pdb);
		
		return projectDeleted;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectsDateBean> getListDescriptions(String idAuth){
		listDescriptions = adminProjectsDateDAO.getListDescriptions(idAuth);
		
		return listDescriptions;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectsDateBean> getProjectsDateByDesc(ProjectsDateBean pdb){
		listDataProjectsDate = adminProjectsDateDAO.getProjectsDateByDesc(pdb);
		
		return listDataProjectsDate;
	}
	
}
