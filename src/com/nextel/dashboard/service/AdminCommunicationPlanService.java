package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.CommunicationPlanBean;

public interface AdminCommunicationPlanService {
	
	public int getLastIdCommunicationPlan();
	
	public boolean createCommunicationPlan(CommunicationPlanBean db);
	
	public boolean updateCommunicationPlan(CommunicationPlanBean db);
	
	public boolean deleteCommunicationPlan(String idCommunicationPlan);
	
	public List<CommunicationPlanBean> getListCommunications(String idAuth);
	
	public List<CommunicationPlanBean> getCommunicationPlanByID(CommunicationPlanBean db);
	
}
