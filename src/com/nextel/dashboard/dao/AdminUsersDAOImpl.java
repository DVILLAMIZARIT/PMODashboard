package com.nextel.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.UsersBean;


@Repository
public class AdminUsersDAOImpl implements AdminUsersDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<UsersBean> listUsers = null;
    
    private UsersBean ub = null;
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastIdUserRole(){
		int lastIdUserRole = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(user_role_id) FROM user_roles";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdUserRole = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastIdUserRole = lastIdUserRole + 1;
		return lastIdUserRole;
	}
	
	
	/*
	 * 
	 * */
	public boolean createUser(UsersBean ub){
		boolean created = false;
		int enabled = 1;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO users (username, password, enabled) " + 
				  "VALUES(?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, ub.getUsername());
			pstm.setString(2, ub.getPassword());
			pstm.setInt(3, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			//Insert the ROLES from the user
			insertRoles(ub);
			
			System.out.println("RESULT " + res);
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL USERS CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	private boolean insertRoles(UsersBean ub){
		boolean created = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO user_roles (user_role_id, username, ROLE) " + 
				  "VALUES(?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, ub.getUser_role_id());
			pstm.setString(2, ub.getUsername());
			pstm.setString(3, ub.getRole());
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL USERS CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteUser(String username){
		boolean deleted = false;
		int enabled = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE users SET enabled=? WHERE username=? ";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, enabled);
			pstm.setString(2, username);
			int res = pstm.executeUpdate();
			
			System.out.println("RESULT " + res);
			
			if(res == 1){
				deleted = true;
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return deleted;
	}
		
	
	
	/*
	 * 
	 * */
	public List<UsersBean> getUserData(String username){
		listUsers = new ArrayList<UsersBean>();
		int enabled = 1;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT u.username, u.password, r.ROLE FROM users u, user_roles r "
				  + "WHERE u.username = r.username AND u.username=? AND enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, username);
			pstm.setInt(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				ub = new UsersBean();
				ub.setUsername(rs.getString(1));
				ub.setPassword(rs.getString(2));
				ub.setRole(rs.getString(3));
				
				listUsers.add(ub);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listUsers;
	}

	
	/*
	 * 
	 * */
	public boolean updateUser(UsersBean ub){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE users SET password=? WHERE username=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, ub.getPassword());
			pstm.setString(2, ub.getUsername());
			
			int res = pstm.executeUpdate();
			
			System.out.println("RESULT " + res);
			
			if(res == 1){
				updated = true;
			}
			
			//Update the rol of the user
			updateUserRole(ub);
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	private boolean updateUserRole(UsersBean ub){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE user_roles SET ROLE=? WHERE username=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, ub.getRole());
			pstm.setString(2, ub.getUsername());
			
			int res = pstm.executeUpdate();
			
			System.out.println("RESULT " + res);
			
			if(res == 1){
				updated = true;
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public List<UsersBean> getListUsers(){
		listUsers = new ArrayList<UsersBean>();
		int enabled = 1;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT username FROM users WHERE enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				ub = new UsersBean();
				ub.setUsername(rs.getString(1));
				
				listUsers.add(ub);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listUsers;
		
	}
	
}
