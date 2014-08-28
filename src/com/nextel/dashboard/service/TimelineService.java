package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.TimelineBean;

public interface TimelineService {	
	public List<TimelineBean> getTimeline(String idAuth);
	
	public int getTotalTimelines(String idAuth);
}
