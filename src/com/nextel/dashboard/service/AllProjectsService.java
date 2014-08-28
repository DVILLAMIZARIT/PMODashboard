package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.AccomplishmentsBean;
import com.nextel.dashboard.bean.AllProjectsBean;
import com.nextel.dashboard.bean.MilestoneBean;
import com.nextel.dashboard.bean.NextStepsBean;

public interface AllProjectsService {
	public List<AllProjectsBean> getAllProjects();
	
	public List<AccomplishmentsBean> getAccomplishments(String idAuth);
	
	public List<NextStepsBean> getNextSteps(String idAuth);
	
	public List<MilestoneBean> getMilestones(String idAuth);
	
	public List<AllProjectsBean> searchProject(String projectName);
	
	public List<AllProjectsBean> getAllProjectsFilterByPM(String filterPM);
	
}
