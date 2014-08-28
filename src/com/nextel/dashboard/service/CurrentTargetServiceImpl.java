package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.CurrentTargetBean;
import com.nextel.dashboard.dao.CurrentTargetDAO;

@Service
@Transactional(readOnly=true)
public class CurrentTargetServiceImpl implements CurrentTargetService {
	
	@Autowired
	private CurrentTargetDAO currentTargetDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
	private List<CurrentTargetBean> listCurrentTarget = null;
	/*
	 * 
	 * */
	public List<CurrentTargetBean> getCurrentTarget(){
		listCurrentTarget = new ArrayList<CurrentTargetBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listCurrentTarget = currentTargetDAO.getCurrentTarget();
		
		return listCurrentTarget;
	}
	
	
	
	/*
	 * 
	 * */
	public List<CurrentTargetBean> getCurrentTargetFilterByProject(String project){
		listCurrentTarget = new ArrayList<CurrentTargetBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		listCurrentTarget = currentTargetDAO.getCurrentTargetFilterByProject(project);
		
		return listCurrentTarget;
	}
	
}
