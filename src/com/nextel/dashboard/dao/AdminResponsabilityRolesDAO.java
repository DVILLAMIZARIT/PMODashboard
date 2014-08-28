package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.ResponsabilityRolesBean;

public interface AdminResponsabilityRolesDAO {
	
	public int getLastIdResponsabilityRole();
	
	public boolean createResponsabilityRoles(ResponsabilityRolesBean db);
	
	public boolean updateResponsabilityRoles(ResponsabilityRolesBean db);
	
	public boolean deleteResponsabilityRoles(String idResponsabilityRoles);
	
	public List<ResponsabilityRolesBean> getListTask(String idAuth);
	
	public List<ResponsabilityRolesBean> getResponsabilityRolesByID(ResponsabilityRolesBean db);
	
}
