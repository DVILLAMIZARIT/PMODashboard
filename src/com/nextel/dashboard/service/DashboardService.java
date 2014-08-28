package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.TopProjectsBean;

public interface DashboardService {
	public List<TopProjectsBean> getTopProjects();

	public List<TopProjectsBean> getMonthTopProjects();
	
	public List<TopProjectsBean> getTopProjectsFilterByPriority(String priority);
	
	public List<TopProjectsBean> getTopProjectsFilterByProject(String project);
	
	public List<TopProjectsBean> getTopProjectsFilterByAll(String priority, String project);
	
}
