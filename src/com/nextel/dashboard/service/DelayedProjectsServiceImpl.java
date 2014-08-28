package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.DelayedProjectsBean;
import com.nextel.dashboard.dao.DelayedProjectsDAO;

@Service
@Transactional(readOnly=true)
public class DelayedProjectsServiceImpl implements DelayedProjectsService {
	
	@Autowired
	private DelayedProjectsDAO delayedProjectsDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
	private List<DelayedProjectsBean> listDelayedProjects = null;
	/*
	 * 
	 * */
	public List<DelayedProjectsBean> getDelayedProjects(){
		listDelayedProjects = new ArrayList<DelayedProjectsBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listDelayedProjects = delayedProjectsDAO.getDelayedProjects();
		
		return listDelayedProjects;
	}
	
}
