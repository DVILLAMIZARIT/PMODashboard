package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.dao.AdminPMDAO;


@Service
@Transactional(readOnly=true)
public class AdminPMServiceImpl implements AdminPMService {

	@Autowired
	private AdminPMDAO adminPMDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<PMBean> listPM = null;
	private List<PMBean> listPMData = null;
	
	
	/*
	 * 
	 * */
	public List<PMBean> getDataPMByIdPM(String idPM){
		listPMData = adminPMDAO.getDataPMByIdPM(idPM);
				
		return listPMData;
	}
		
	
	/*
	 * 
	 * */
	public boolean createPM(PMBean pmb){
		boolean created = false;
		
		created = adminPMDAO.createPM(pmb);
				
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<PMBean> getListPM(){
		listPM = adminPMDAO.getListPM();
				
		return listPM;
	}
	
	
	/*
	 * 
	 * */
	public List<PMBean> getListPMEnabled(){
		listPMData = adminPMDAO.getListPMEnabled();
			
		return listPMData;
	}

	/*
	 * 
	 * */
	public boolean updatePM(PMBean pmb){
		boolean pmUpdated = adminPMDAO.updatePM(pmb);
		
		return pmUpdated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deletePM(String idPM){
		boolean pmDeleted = adminPMDAO.deletePM(idPM);
		
		return pmDeleted;
	}
	
}
