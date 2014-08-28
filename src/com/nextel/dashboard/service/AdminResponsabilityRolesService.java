package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.ResponsabilityRolesBean;

public interface AdminResponsabilityRolesService {
	
	public int getLastIdResponsabilityRole();
	
	public boolean createResponsabilityRoles(ResponsabilityRolesBean db);
	
	public boolean updateResponsabilityRoles(ResponsabilityRolesBean db);
	
	public boolean deleteResponsabilityRoles(String idRole);
	
	public List<ResponsabilityRolesBean> getListTask(String idAuth);
	
	public List<ResponsabilityRolesBean> getResponsabilityRolesByID(ResponsabilityRolesBean db);
	
}
