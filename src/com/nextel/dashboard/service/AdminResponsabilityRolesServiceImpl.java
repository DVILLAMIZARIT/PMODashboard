package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.ResponsabilityRolesBean;
import com.nextel.dashboard.dao.AdminResponsabilityRolesDAO;


@Service
@Transactional(readOnly=true)
public class AdminResponsabilityRolesServiceImpl implements AdminResponsabilityRolesService {

	@Autowired
	private AdminResponsabilityRolesDAO adminResponsabilityRolesDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<ResponsabilityRolesBean> listResponsabilityRolesData = null;
		
	
	/*
	 * 
	 * */
	public int getLastIdResponsabilityRole(){
		int lastResponsabilityRole = 0;
		
		lastResponsabilityRole = adminResponsabilityRolesDAO.getLastIdResponsabilityRole();
				
		return lastResponsabilityRole;
	}
	
	
	/*
	 * 
	 * */
	public boolean createResponsabilityRoles(ResponsabilityRolesBean db){
		boolean created = false;
		
		created = adminResponsabilityRolesDAO.createResponsabilityRoles(db);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateResponsabilityRoles(ResponsabilityRolesBean db){
		boolean updated = false;
		
		updated = adminResponsabilityRolesDAO.updateResponsabilityRoles(db);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteResponsabilityRoles(String idRole){
		boolean deleted = false;
		
		deleted = adminResponsabilityRolesDAO.deleteResponsabilityRoles(idRole);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<ResponsabilityRolesBean> getListTask(String idAuth){
		listResponsabilityRolesData = adminResponsabilityRolesDAO.getListTask(idAuth);
		
		return listResponsabilityRolesData;
	}
	
	
	/*
	 * 
	 * */
	public List<ResponsabilityRolesBean> getResponsabilityRolesByID(ResponsabilityRolesBean db){
		listResponsabilityRolesData = adminResponsabilityRolesDAO.getResponsabilityRolesByID(db);
		
		return listResponsabilityRolesData;
	}
	
}
