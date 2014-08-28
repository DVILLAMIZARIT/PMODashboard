package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.OnRiskProjectsBean;

public interface OnRiskProjectsService {
	public List<OnRiskProjectsBean> getOnRiskProjects();
	
	public List<OnRiskProjectsBean> getIndividualOnRiskProject(String idAuth);
	
}
