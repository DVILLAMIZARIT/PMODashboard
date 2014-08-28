package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.dao.AdminProjectDAO;


@Service
@Transactional(readOnly=true)
public class AdminProjectServiceImpl implements AdminProjectService {
	
	@Autowired
	private AdminProjectDAO adminFormDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<ProjectBean> listProjectData = null;
	private List<PMBean> listPM = null;
	private List<ProjectBean> listProjects = null;
	private List<ProjectBean> listStatus = null;
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getDataProjecByIdAuth(String idAuth){
		listProjectData = adminFormDAO.getDataProjecByIdAuth(idAuth);
				
		return listProjectData;
	}
	
	
	/*
	 * 
	 * */
	public String getLastIdAuth(){
		String idAuth = "";
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		idAuth = adminFormDAO.getLastIdAuth();
				
		return idAuth;
	}
	
	
	/*
	 * 
	 * */
	public boolean createProject(ProjectBean pb){
		boolean created = false;
		
		created = adminFormDAO.createProject(pb);
				
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<PMBean> getListPM(){
		listPM = adminFormDAO.getListPM();
				
		return listPM;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getListProjects(){
		listProjects = adminFormDAO.getListProjects();
				
		return listProjects;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getListStatus(){
		listStatus = adminFormDAO.getListStatus();
		
		return listStatus;
	}
	
	
	/*
	 * 
	 * */
	public String getPMname(String idPM){
		String pmName = adminFormDAO.getPMname(idPM);
		
		return pmName;
	}
	

	/*
	 * 
	 * */
	public boolean updateProject(ProjectBean pb){
		boolean projectUpdated = adminFormDAO.updateProject(pb);
		
		return projectUpdated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteProject(String idAuth){
		boolean projectDeleted = adminFormDAO.deleteProject(idAuth);
		
		return projectDeleted;
	}
	
}
