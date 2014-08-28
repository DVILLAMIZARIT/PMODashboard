package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.CommunicationPlanBean;
import com.nextel.dashboard.dao.AdminCommunicationPlanDAO;


@Service
@Transactional(readOnly=true)
public class AdminCommunicationPlanServiceImpl implements AdminCommunicationPlanService {

	@Autowired
	private AdminCommunicationPlanDAO adminCommunicationPlanDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<CommunicationPlanBean> listCommunicationPlanData = null;
		
	
	/*
	 * 
	 * */
	public int getLastIdCommunicationPlan(){
		int lastCommunicationPlan = 0;
		
		lastCommunicationPlan = adminCommunicationPlanDAO.getLastIdCommunicationPlan();
				
		return lastCommunicationPlan;
	}
	
	
	/*
	 * 
	 * */
	public boolean createCommunicationPlan(CommunicationPlanBean db){
		boolean created = false;
		
		created = adminCommunicationPlanDAO.createCommunicationPlan(db);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateCommunicationPlan(CommunicationPlanBean db){
		boolean updated = false;
		
		updated = adminCommunicationPlanDAO.updateCommunicationPlan(db);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteCommunicationPlan(String idCommunicationPlan){
		boolean deleted = false;
		
		deleted = adminCommunicationPlanDAO.deleteCommunicationPlan(idCommunicationPlan);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<CommunicationPlanBean> getListCommunications(String idAuth){
		listCommunicationPlanData = adminCommunicationPlanDAO.getListCommunications(idAuth);
		
		return listCommunicationPlanData;
	}
	
	
	/*
	 * 
	 * */
	public List<CommunicationPlanBean> getCommunicationPlanByID(CommunicationPlanBean db){
		listCommunicationPlanData = adminCommunicationPlanDAO.getCommunicationPlanByID(db);
		
		return listCommunicationPlanData;
	}
	
}
