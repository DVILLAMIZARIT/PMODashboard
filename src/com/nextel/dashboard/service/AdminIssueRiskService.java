package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.OnRiskProjectsBean;

public interface AdminIssueRiskService {
	
	public int getLastIssueRisk();
	
	public boolean createIssueRisk(OnRiskProjectsBean fub);
	
	public boolean updateIssueRisk(OnRiskProjectsBean fub);
	
	public boolean deleteIssueRisk(String idIssueRisk);
	
	public List<OnRiskProjectsBean> getListDescriptions(String idAuth);
	
	public List<OnRiskProjectsBean> getIssueRiskByDesc(OnRiskProjectsBean fub);
	
}
