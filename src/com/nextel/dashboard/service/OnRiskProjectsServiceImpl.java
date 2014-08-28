package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.OnRiskProjectsBean;
import com.nextel.dashboard.dao.OnRiskProjectsDAO;

@Service
@Transactional(readOnly=true)
public class OnRiskProjectsServiceImpl implements OnRiskProjectsService {
	
	@Autowired
	private OnRiskProjectsDAO onRiskProjectsDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
	private List<OnRiskProjectsBean> listOnRiskProjects = null;
	private List<OnRiskProjectsBean> listIndividualOnRiskProject = null;
	
	/*
	 * 
	 * */
	public List<OnRiskProjectsBean> getOnRiskProjects(){
		listOnRiskProjects = new ArrayList<OnRiskProjectsBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listOnRiskProjects = onRiskProjectsDAO.getOnRiskProjects();
		
		return listOnRiskProjects;
	}
	
	
	
	/*
	 * 
	 * */
	public List<OnRiskProjectsBean> getIndividualOnRiskProject(String idAuth){
		listIndividualOnRiskProject = new ArrayList<OnRiskProjectsBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listIndividualOnRiskProject = onRiskProjectsDAO.getIndividualOnRiskProject(idAuth);
		
		return listIndividualOnRiskProject;
	}
	
}
