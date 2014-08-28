package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;

public interface AdminProjectService {
	
	public List<ProjectBean> getDataProjecByIdAuth(String idAuth);
	
	public String getLastIdAuth();
	
	public boolean createProject(ProjectBean pb);
	
	public List<PMBean> getListPM();
	
	public List<ProjectBean> getListProjects();
	
	public List<ProjectBean> getListStatus();
	
	public String getPMname(String idPM);
	
	public boolean updateProject(ProjectBean pb);
	
	public boolean deleteProject(String idAuth);
	
}
