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

import com.nextel.dashboard.bean.OnRiskProjectsBean;


@Repository
public class AdminIssueRiskDAOImpl implements AdminIssueRiskDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<OnRiskProjectsBean> listIR = null;
    
    private OnRiskProjectsBean orb = null;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastIdIssueRisk(){
		int lastIdIssueRisk = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(idissueRisk) FROM issuerisk";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdIssueRisk = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastIdIssueRisk = lastIdIssueRisk + 1;
		return lastIdIssueRisk;
	}
	
	
	/*
	 * 
	 * */
	public boolean createIssueRisk(OnRiskProjectsBean orb){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			Calendar creationDate = Calendar.getInstance();
			String sCreationDate = sdf.format(new Date(creationDate.getTimeInMillis()));
			
			qry = "INSERT INTO issuerisk (idissueRisk, idAuth, issueRiskDescription, actionPlan, dueDateBL, dueDateFC, dueDateACT, " +
				  "issueStatus, issueType, creationDate, prioridad, enabled) " + 
				  "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, orb.getIdIssueRisk());
			pstm.setString(2, orb.getIdAuth());
			pstm.setString(3, orb.getIssueRiskDescription());
			pstm.setString(4, orb.getActionPlan());
			pstm.setString(5, orb.getDueDateBL());
			pstm.setString(6, orb.getDueDateFC());
			pstm.setString(7, orb.getDueDateACT());
			pstm.setString(8, orb.getIssueStatus());
			pstm.setString(9, orb.getIssueType());
			pstm.setString(10, sCreationDate);
			pstm.setString(11, orb.getPriority());
			pstm.setString(12, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL 4UP CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteIssueRisk(String idIssueRisk){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE issuerisk SET enabled='Baja' WHERE idissueRisk=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idIssueRisk);
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
	public boolean updateIssueRisk(OnRiskProjectsBean orb){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE issuerisk SET issueRiskDescription=?, actionPlan=?, dueDateBL=?, dueDateFC=?, dueDateACT=?, "
				  + "issueStatus=?, prioridad=?, issueType=? "	
				  + "WHERE idissueRisk=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, orb.getIssueRiskDescription());
			pstm.setString(2, orb.getActionPlan());
			pstm.setString(3, orb.getDueDateBL());
			pstm.setString(4, orb.getDueDateFC());
			pstm.setString(5, orb.getDueDateACT());
			pstm.setString(6, orb.getIssueStatus());
			pstm.setString(7, orb.getPriority());
			pstm.setString(8, orb.getIssueType());
			pstm.setInt(9, orb.getIdIssueRisk());
			
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
	public List<OnRiskProjectsBean> getListDescriptions(String idAuth){
		listIR = new ArrayList<OnRiskProjectsBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idissueRisk, issueRiskDescription FROM issuerisk WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				orb = new OnRiskProjectsBean();
				orb.setIdIssueRisk(rs.getInt(1));
				orb.setIssueRiskDescription(rs.getString(2));
				
				listIR.add(orb);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listIR;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<OnRiskProjectsBean> getIssueRiskByDesc(OnRiskProjectsBean orb){
		listIR = new ArrayList<OnRiskProjectsBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			qry = "SELECT idAuth, idissueRisk, issueRiskDescription, actionPlan, dueDateBL, dueDateFC, dueDateACT, issueStatus, prioridad, issueType " +
				  "FROM issuerisk WHERE idAuth=? and idissueRisk=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, orb.getIdAuth());
			pstm.setInt(2,orb.getIdIssueRisk());
			pstm.setString(3,enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				orb = new OnRiskProjectsBean();
				orb.setIdAuth(rs.getString(1));
				orb.setIdIssueRisk(rs.getInt(2));
				orb.setIssueRiskDescription(rs.getString(3));
				orb.setActionPlan(rs.getString(4));
				orb.setDueDateBL(rs.getString(5));
				orb.setDueDateFC(rs.getString(6));
				orb.setDueDateACT(rs.getString(7));
				orb.setIssueStatus(rs.getString(8));
				orb.setPriority(rs.getString(9));
				orb.setIssueType(rs.getString(10));
				
				listIR.add(orb);

			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listIR;
	}
	
}
