package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.TimelineBean;
import com.nextel.dashboard.dao.TimelineDAO;
import com.nextel.dashboard.util.JSONGeneratorImpl;

@Service
@Transactional(readOnly=true)
public class TimelineServiceImpl implements TimelineService {
	
	@Autowired
	private TimelineDAO timelineDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private JSONGeneratorImpl jsonGenerator = null;
	private List<TimelineBean> listTimeline = null;
	
	/*
	 * 
	 * */
	public List<TimelineBean> getTimeline(String idAuth){
		listTimeline = new ArrayList<TimelineBean>();
		listTimeline = timelineDAO.getTimeline(idAuth);

		jsonGenerator = new JSONGeneratorImpl();
		String jsonTimeline = jsonGenerator.generateTimeline(listTimeline);
				
		//Insert the Json string in the first line of the List
		listTimeline.get(0).setJsonTimeline(jsonTimeline);
		
		return listTimeline;
	}
	
	/*
	 * 
	 * */
	public int getTotalTimelines(String idAuth){
		int totalTimelines = 0;
		totalTimelines = timelineDAO.getTotalTimelines(idAuth);
		
		return totalTimelines;
	}
	
}
