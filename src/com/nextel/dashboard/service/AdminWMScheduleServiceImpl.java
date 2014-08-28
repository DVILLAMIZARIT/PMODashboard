package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.WMScheduleBean;
import com.nextel.dashboard.dao.AdminWMScheduleDAO;


@Service
@Transactional(readOnly=true)
public class AdminWMScheduleServiceImpl implements AdminWMScheduleService {

	@Autowired
	private AdminWMScheduleDAO adminWMScheduleDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<WMScheduleBean> listIRData = null;
		
	
	/*
	 * 
	 * */
	public int getLastIdWM(){
		int lastIR = 0;
		
		lastIR = adminWMScheduleDAO.getLastIdWM();
				
		return lastIR;
	}
	
	
	/*
	 * 
	 * */
	public boolean createWMSchedule(WMScheduleBean orb){
		boolean created = false;
		
		created = adminWMScheduleDAO.createWMSchedule(orb);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateWMSchedule(WMScheduleBean orb){
		boolean updated = false;
		
		updated = adminWMScheduleDAO.updateWMSchedule(orb);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteWMSchedule(String idWMSchedule){
		boolean deleted = false;
		
		deleted = adminWMScheduleDAO.deleteWMSchedule(idWMSchedule);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<WMScheduleBean> getListDescriptions(String idAuth){
		listIRData = adminWMScheduleDAO.getListDescriptions(idAuth);
		
		return listIRData;
	}
	
	
	/*
	 * 
	 * */
	public List<WMScheduleBean> getWMScheduleByDesc(WMScheduleBean orb){
		listIRData = adminWMScheduleDAO.getWMScheduleByDesc(orb);
		
		return listIRData;
	}
	
}
