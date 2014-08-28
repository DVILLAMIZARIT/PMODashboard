package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.TimelineBean;

public interface TimelineDAO {

	public List<TimelineBean> getTimeline(String idAuth);
	
	public int getTotalTimelines(String idAuth);	
	
}
