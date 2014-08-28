package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.DashboardBean;

public interface AdminDashboardService {
	
	public int getLastDashboard();
	
	public boolean createDashboard(DashboardBean db);
	
	public boolean updateDashboard(DashboardBean db);
	
	public boolean deleteDashboard(String idDashboard);
	
	public List<DashboardBean> getListSubProjects(String idAuth);
	
	public List<DashboardBean> getDashboardByID(DashboardBean db);
	
}
