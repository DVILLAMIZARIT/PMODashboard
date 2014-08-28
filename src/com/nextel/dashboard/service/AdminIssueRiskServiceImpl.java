package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.OnRiskProjectsBean;
import com.nextel.dashboard.dao.AdminIssueRiskDAO;


@Service
@Transactional(readOnly=true)
public class AdminIssueRiskServiceImpl implements AdminIssueRiskService {

	@Autowired
	private AdminIssueRiskDAO adminIssueRiskDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<OnRiskProjectsBean> listIRData = null;
		
	
	/*
	 * 
	 * */
	public int getLastIssueRisk(){
		int lastIR = 0;
		
		lastIR = adminIssueRiskDAO.getLastIdIssueRisk();
				
		return lastIR;
	}
	
	
	/*
	 * 
	 * */
	public boolean createIssueRisk(OnRiskProjectsBean orb){
		boolean created = false;
		
		created = adminIssueRiskDAO.createIssueRisk(orb);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateIssueRisk(OnRiskProjectsBean orb){
		boolean updated = false;
		
		updated = adminIssueRiskDAO.updateIssueRisk(orb);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteIssueRisk(String idIssueRisk){
		boolean deleted = false;
		
		deleted = adminIssueRiskDAO.deleteIssueRisk(idIssueRisk);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<OnRiskProjectsBean> getListDescriptions(String idAuth){
		listIRData = adminIssueRiskDAO.getListDescriptions(idAuth);
		
		return listIRData;
	}
	
	
	/*
	 * 
	 * */
	public List<OnRiskProjectsBean> getIssueRiskByDesc(OnRiskProjectsBean orb){
		listIRData = adminIssueRiskDAO.getIssueRiskByDesc(orb);
		
		return listIRData;
	}
	
}
