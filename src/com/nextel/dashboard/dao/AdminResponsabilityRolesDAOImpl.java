package com.nextel.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.ResponsabilityRolesBean;


@Repository
public class AdminResponsabilityRolesDAOImpl implements AdminResponsabilityRolesDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<ResponsabilityRolesBean> listResponsabilityRoles = null;
    
    private ResponsabilityRolesBean db = null;
    
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastIdResponsabilityRole(){
		int lastIdRole = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(idRole) FROM responsabilityroles";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdRole = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastIdRole = lastIdRole + 1;
		return lastIdRole;
	}
	
	
	/*
	 * 
	 * */
	public boolean createResponsabilityRoles(ResponsabilityRolesBean db){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO responsabilityroles (idRole, idAuth, task, area, role, clasifica, enabled) " + 
				  "VALUES(?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, db.getIdRole());
			pstm.setString(2, db.getIdAuth());
			pstm.setString(3, db.getTask());
			pstm.setString(4, db.getArea());
			pstm.setString(5, db.getRole());
			pstm.setString(6, db.getClasifica());
			pstm.setString(7, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL RESPONSROLE CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteResponsabilityRoles(String idRole){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE responsabilityroles SET enabled='Baja' WHERE idRole=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idRole);
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
	public boolean updateResponsabilityRoles(ResponsabilityRolesBean db){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE responsabilityroles SET task=?, area=?, role=?, clasifica=? "	
				  + "WHERE idRole=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, db.getTask());
			pstm.setString(2, db.getArea());
			pstm.setString(3, db.getRole());
			pstm.setString(4, db.getClasifica());
			pstm.setInt(5, db.getIdRole());
			
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
	public List<ResponsabilityRolesBean> getListTask(String idAuth){
		listResponsabilityRoles = new ArrayList<ResponsabilityRolesBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idRole, task FROM responsabilityroles WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				db = new ResponsabilityRolesBean();
				db.setIdRole(rs.getInt(1));
				db.setTask(rs.getString(2));
				
				listResponsabilityRoles.add(db);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listResponsabilityRoles;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<ResponsabilityRolesBean> getResponsabilityRolesByID(ResponsabilityRolesBean db){
		listResponsabilityRoles = new ArrayList<ResponsabilityRolesBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			qry = "SELECT idAuth, idRole, task, area, role, clasifica " +
				  "FROM responsabilityroles WHERE idAuth=? and idRole=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, db.getIdAuth());
			pstm.setInt(2,db.getIdRole());
			pstm.setString(3,enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				db = new ResponsabilityRolesBean();
				db.setIdAuth(rs.getString(1));
				db.setIdRole(rs.getInt(2));
				db.setTask(rs.getString(3));
				db.setArea(rs.getString(4));
				db.setRole(rs.getString(5));
				db.setClasifica(rs.getString(6));
				
				listResponsabilityRoles.add(db);

			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listResponsabilityRoles;
	}
	
}
