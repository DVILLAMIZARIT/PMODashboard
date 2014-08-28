package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.DashboardBean;
import com.nextel.dashboard.dao.AdminDashboardDAO;


@Service
@Transactional(readOnly=true)
public class AdminDashboardServiceImpl implements AdminDashboardService {

	@Autowired
	private AdminDashboardDAO adminDashboardDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<DashboardBean> listDashboardData = null;
		
	
	/*
	 * 
	 * */
	public int getLastDashboard(){
		int lastDashboard = 0;
		
		lastDashboard = adminDashboardDAO.getLastIdDashboard();
				
		return lastDashboard;
	}
	
	
	/*
	 * 
	 * */
	public boolean createDashboard(DashboardBean db){
		boolean created = false;
		
		created = adminDashboardDAO.createDashboard(db);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateDashboard(DashboardBean db){
		boolean updated = false;
		
		updated = adminDashboardDAO.updateDashboard(db);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteDashboard(String idDashboard){
		boolean deleted = false;
		
		deleted = adminDashboardDAO.deleteDashboard(idDashboard);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<DashboardBean> getListSubProjects(String idAuth){
		listDashboardData = adminDashboardDAO.getListSubProjects(idAuth);
		
		return listDashboardData;
	}
	
	
	/*
	 * 
	 * */
	public List<DashboardBean> getDashboardByID(DashboardBean db){
		listDashboardData = adminDashboardDAO.getDashboardByID(db);
		
		return listDashboardData;
	}
	
}
