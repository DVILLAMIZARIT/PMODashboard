package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.UsersBean;
import com.nextel.dashboard.dao.AdminUsersDAO;


@Service
@Transactional(readOnly=true)
public class AdminUsersServiceImpl implements AdminUsersService {

	@Autowired
	private AdminUsersDAO adminUsersDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<UsersBean> listUsers = null;
		
	
	/*
	 * 
	 * */
	public int getLastIdUserRole(){
		int listUsers = 0;
		
		listUsers = adminUsersDAO.getLastIdUserRole();
				
		return listUsers;
	}
	
	
	/*
	 * 
	 * */
	public boolean createUser(UsersBean ub){
		boolean created = false;
		
		created = adminUsersDAO.createUser(ub);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateUser(UsersBean ub){
		boolean updated = false;
		
		updated = adminUsersDAO.updateUser(ub);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteUser(String username){
		boolean deleted = false;
		
		deleted = adminUsersDAO.deleteUser(username);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<UsersBean> getListUsers(){
		listUsers = adminUsersDAO.getListUsers();
		
		return listUsers;
	}
	

	/*
	 * 
	 * */
	public List<UsersBean> getUserData(String username){
		listUsers = adminUsersDAO.getUserData(username);
		
		return listUsers;
	}
	
}
