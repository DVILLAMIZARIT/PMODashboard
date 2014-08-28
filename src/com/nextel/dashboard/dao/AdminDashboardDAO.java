package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.DashboardBean;

public interface AdminDashboardDAO {
	
	public int getLastIdDashboard();
	
	public boolean createDashboard(DashboardBean db);
	
	public boolean updateDashboard(DashboardBean db);
	
	public boolean deleteDashboard(String idDashboard);
	
	public List<DashboardBean> getListSubProjects(String idAuth);
	
	public List<DashboardBean> getDashboardByID(DashboardBean db);
	
}
