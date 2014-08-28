package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.ProjectsDateBean;

public interface AdminProjectsDateService {
	
	public int getLastIdDate();
	
	public boolean createProjectDate(ProjectsDateBean pdb);
	
	public List<ProjectBean> getListProjects();
	
	public boolean updateProjectDate(ProjectsDateBean pb);
	
	public boolean deleteProjectDate(ProjectsDateBean pdb);
	
	public List<ProjectsDateBean> getListDescriptions(String idAuth);
	
	public List<ProjectsDateBean> getProjectsDateByDesc(ProjectsDateBean pdb);
	
}
