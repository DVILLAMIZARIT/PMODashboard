package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.OnRiskProjectsBean;

public interface AdminIssueRiskDAO {
	
	public int getLastIdIssueRisk();
	
	public boolean createIssueRisk(OnRiskProjectsBean orb);
	
	public boolean updateIssueRisk(OnRiskProjectsBean orb);
	
	public boolean deleteIssueRisk(String idIssueRisk);
	
	public List<OnRiskProjectsBean> getListDescriptions(String idAuth);
	
	public List<OnRiskProjectsBean> getIssueRiskByDesc(OnRiskProjectsBean orb);
	
}
