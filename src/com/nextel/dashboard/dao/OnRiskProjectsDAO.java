package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.OnRiskProjectsBean;

public interface OnRiskProjectsDAO {

	public List<OnRiskProjectsBean> getOnRiskProjects();
	
	public List<OnRiskProjectsBean> getIndividualOnRiskProject(String idAuth);
	
}
