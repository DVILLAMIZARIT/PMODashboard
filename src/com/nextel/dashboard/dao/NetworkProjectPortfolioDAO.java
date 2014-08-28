package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.ProjectBean;

public interface NetworkProjectPortfolioDAO {

	public List<ProjectBean> getProjects();
	
	public List<ProjectBean> getAccumulated();
	
	public List<ProjectBean> getMonthlyTarget();
	
}
