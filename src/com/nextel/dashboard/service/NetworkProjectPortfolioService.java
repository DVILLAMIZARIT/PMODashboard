package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.ProjectBean;

public interface NetworkProjectPortfolioService {
	public List<ProjectBean> getProjects();
	
	public List<ProjectBean> createAccumulate();
	
	public List<ProjectBean> getAccumulated();
	
	public List<ProjectBean> getMonthlyTarget();
}
