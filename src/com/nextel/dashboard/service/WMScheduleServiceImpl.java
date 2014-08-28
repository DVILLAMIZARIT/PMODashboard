package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.WMScheduleBean;
import com.nextel.dashboard.dao.WMScheduleDAO;
import com.nextel.dashboard.dao.WMScheduleDAOImpl;

@Service
@Transactional(readOnly=true)
public class WMScheduleServiceImpl implements WMScheduleService {
	
	
	@Autowired
	private WMScheduleDAO wmscheduleDAO;
	
	WMScheduleDAO schedulerDAO = new WMScheduleDAOImpl();
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
	private List<WMScheduleBean> listWMSchedule = null;
	/*
	 * 
	 * */
	public List<WMScheduleBean> getEvents(){
		listWMSchedule = new ArrayList<WMScheduleBean>();
		
		//Extract the data from the DB
		listWMSchedule = schedulerDAO.getEvents();
		//listWMSchedule = wmscheduleDAO.getEvents();
		return listWMSchedule;
	}
	
}
