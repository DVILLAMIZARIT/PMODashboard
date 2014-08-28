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

import com.nextel.dashboard.bean.CommunicationPlanBean;


@Repository
public class AdminCommunicationPlanDAOImpl implements AdminCommunicationPlanDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<CommunicationPlanBean> listCommunicationPlan = null;
    
    private CommunicationPlanBean cpb = null;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastIdCommunicationPlan(){
		int lastIdCommunicationPlan = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(idCommunicationPlan) FROM communicationplan";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdCommunicationPlan = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastIdCommunicationPlan = lastIdCommunicationPlan + 1;
		return lastIdCommunicationPlan;
	}
	
	
	/*
	 * 
	 * */
	public boolean createCommunicationPlan(CommunicationPlanBean cpb){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO communicationplan (idCommunicationPlan, idAuth, communication, frequency, media, audience, " +
				  " deliverable, enabled) " + 
				  "VALUES(?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, cpb.getIdCommunicationPlan());
			pstm.setString(2, cpb.getIdAuth());
			pstm.setString(3, cpb.getCommunication());
			pstm.setString(4, cpb.getFrequency());
			pstm.setString(5, cpb.getMedia());
			pstm.setString(6, cpb.getAudience());
			pstm.setString(7, cpb.getDeliverable());
			pstm.setString(8, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL COMMPLAN CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteCommunicationPlan(String idCommunicationPlan){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE communicationplan SET enabled='Baja' WHERE idCommunicationPlan=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idCommunicationPlan);
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
	public boolean updateCommunicationPlan(CommunicationPlanBean cpb){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE communicationplan SET communication=?, frequency=?, media=?, audience=?, deliverable=? "	
				  + " WHERE idCommunicationPlan=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, cpb.getCommunication());
			pstm.setString(2, cpb.getFrequency());
			pstm.setString(3, cpb.getMedia());
			pstm.setString(4, cpb.getAudience());
			pstm.setString(5, cpb.getDeliverable());
			pstm.setInt(6, cpb.getIdCommunicationPlan());
			
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
	public List<CommunicationPlanBean> getListCommunications(String idAuth){
		listCommunicationPlan = new ArrayList<CommunicationPlanBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idCommunicationPlan, communication FROM communicationplan WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				cpb = new CommunicationPlanBean();
				cpb.setIdCommunicationPlan(rs.getInt(1));
				cpb.setCommunication(rs.getString(2));
				
				listCommunicationPlan.add(cpb);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listCommunicationPlan;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<CommunicationPlanBean> getCommunicationPlanByID(CommunicationPlanBean db){
		listCommunicationPlan = new ArrayList<CommunicationPlanBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			qry = "SELECT idAuth, idCommunicationPlan, communication, frequency, media, audience, deliverable " +
				  "FROM communicationplan WHERE idAuth=? and idCommunicationPlan=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, db.getIdAuth());
			pstm.setInt(2,db.getIdCommunicationPlan());
			pstm.setString(3,enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				cpb = new CommunicationPlanBean();
				cpb.setIdAuth(rs.getString(1));
				cpb.setIdCommunicationPlan(rs.getInt(2));
				cpb.setCommunication(rs.getString(3));
				cpb.setFrequency(rs.getString(4));
				cpb.setMedia(rs.getString(5));
				cpb.setAudience(rs.getString(6));
				cpb.setDeliverable(rs.getString(7));
				
				listCommunicationPlan.add(cpb);

			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listCommunicationPlan;
	}
	
}
