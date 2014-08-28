package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.UsersBean;

public interface AdminUsersDAO {
	
	public int getLastIdUserRole();
	
	public boolean createUser(UsersBean fub);
	
	public boolean updateUser(UsersBean fub);
	
	public boolean deleteUser(String username);
	
	public List<UsersBean> getListUsers();
	
	public List<UsersBean> getUserData(String username);
	
}
