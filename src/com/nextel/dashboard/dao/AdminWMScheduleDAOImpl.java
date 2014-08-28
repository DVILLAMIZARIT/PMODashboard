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

import com.nextel.dashboard.bean.WMScheduleBean;


@Repository
public class AdminWMScheduleDAOImpl implements AdminWMScheduleDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<WMScheduleBean> listWM = null;
    
    private WMScheduleBean wmb = null;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastIdWM(){
		int lastIdWM = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(idWM) FROM wmschedule";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdWM = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastIdWM = lastIdWM + 1;
		return lastIdWM;
	}
	
	
	/*
	 * 
	 * */
	public boolean createWMSchedule(WMScheduleBean wmb){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			Calendar creationDate = Calendar.getInstance();
			String sCreationDate = sdf.format(new Date(creationDate.getTimeInMillis()));
			
			qry = "INSERT INTO wmschedule (idWM, idAuth, scheduleDate, scheduleDesc, CR_Id, idPM, engineering, operations, " +
				  "deployment, security, noc, enabled) " + 
				  "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, wmb.getIdWM());
			pstm.setString(2, wmb.getIdAuth());
			pstm.setString(3, wmb.getScheduleDate());
			pstm.setString(4, wmb.getScheduleDesc());
			pstm.setInt(5, wmb.getCR_Id());
			pstm.setString(6, wmb.getIdPM());
			pstm.setString(7, wmb.getEngineering());
			pstm.setString(8, wmb.getOperations());
			pstm.setString(9, wmb.getDeployment());
			pstm.setString(10, wmb.getSecurity());
			pstm.setString(11, wmb.getNoc());
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
	public boolean deleteWMSchedule(String idWM){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE wmschedule SET enabled='Baja' WHERE idWM=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idWM);
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
	public boolean updateWMSchedule(WMScheduleBean wmb){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE wmschedule SET scheduleDate=?, scheduleDesc=?, CR_Id=?, idPM=?, engineering=?, operations=?, "
				  + "deployment=?, security=?, noc=? "	
				  + "WHERE idWM=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, wmb.getScheduleDate());
			pstm.setString(2, wmb.getScheduleDesc());
			pstm.setInt(3, wmb.getCR_Id());
			pstm.setString(4, wmb.getIdPM());
			pstm.setString(5, wmb.getEngineering());
			pstm.setString(6, wmb.getOperations());
			pstm.setString(7, wmb.getDeployment());
			pstm.setString(8, wmb.getSecurity());
			pstm.setString(9, wmb.getNoc());
			pstm.setInt(10, wmb.getIdWM());

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
	public List<WMScheduleBean> getListDescriptions(String idAuth){
		listWM = new ArrayList<WMScheduleBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idWM, scheduleDesc FROM wmschedule WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				wmb = new WMScheduleBean();
				wmb.setIdWM(rs.getInt(1));
				wmb.setScheduleDesc(rs.getString(2));
				
				listWM.add(wmb);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listWM;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<WMScheduleBean> getWMScheduleByDesc(WMScheduleBean wmb){
		listWM = new ArrayList<WMScheduleBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			qry = "SELECT idAuth, idWM, scheduleDate, scheduleDesc, CR_Id, idPM, engineering, operations, deployment, security, noc " +
				  "FROM wmschedule WHERE idAuth=? and idWM=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, wmb.getIdAuth());
			pstm.setInt(2,wmb.getIdWM());
			pstm.setString(3,enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				wmb = new WMScheduleBean();
				wmb.setIdAuth(rs.getString(1));
				wmb.setIdWM(rs.getInt(2));
				wmb.setScheduleDate(rs.getString(3));
				wmb.setScheduleDesc(rs.getString(4));
				wmb.setCR_Id(rs.getInt(5));
				wmb.setIdPM(rs.getString(6));
				wmb.setEngineering(rs.getString(7));
				wmb.setOperations(rs.getString(8));
				wmb.setDeployment(rs.getString(9));
				wmb.setSecurity(rs.getString(10));
				wmb.setNoc(rs.getString(11));
				
				listWM.add(wmb);

			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listWM;
	}
	
}
