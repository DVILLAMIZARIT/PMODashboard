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

import com.nextel.dashboard.bean.DashboardBean;


@Repository
public class AdminDashboardDAOImpl implements AdminDashboardDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<DashboardBean> listDashboard = null;
    
    private DashboardBean db = null;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastIdDashboard(){
		int lastIdDashboard = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(idDashboard) FROM dashboard";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdDashboard = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastIdDashboard = lastIdDashboard + 1;
		return lastIdDashboard;
	}
	
	
	/*
	 * 
	 * */
	public boolean createDashboard(DashboardBean db){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO dashboard (idDashboard, idAuth, IdPrioridad, SubProject, Item, qtyTarget, qtyAoT, " +
				  "Advance, Status, Remarks, Historico, enabled) " + 
				  "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, db.getIdDashboard());
			pstm.setString(2, db.getIdAuth());
			pstm.setInt(3, db.getIdPriority());
			pstm.setString(4, db.getSubProject());
			pstm.setString(5, db.getItem());
			pstm.setDouble(6, db.getQtyTarget());
			pstm.setDouble(7, db.getQtyAoT());
			pstm.setInt(8, db.getAdvance());
			pstm.setString(9, db.getStatus());
			pstm.setString(10, db.getRemarks());
			pstm.setString(11, db.getHistoric());
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
	public boolean deleteDashboard(String idDashboard){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE dashboard SET enabled='Baja' WHERE idDashboard=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idDashboard);
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
	public boolean updateDashboard(DashboardBean db){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE dashboard SET IdPrioridad=?, SubProject=?, Item=?, qtyTarget=?, qtyAoT=?, "
				  + "Advance=?, Status=?, Remarks=?, Historico=? "	
				  + "WHERE idDashboard=? ";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, db.getIdPriority());
			pstm.setString(2, db.getSubProject());
			pstm.setString(3, db.getItem());
			pstm.setDouble(4, db.getQtyTarget());
			pstm.setDouble(5, db.getQtyAoT());
			pstm.setInt(6, db.getAdvance());
			pstm.setString(7, db.getStatus());
			pstm.setString(8, db.getRemarks());
			pstm.setString(9, db.getHistoric());
			pstm.setInt(10, db.getIdDashboard());
			
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
	public List<DashboardBean> getListSubProjects(String idAuth){
		listDashboard = new ArrayList<DashboardBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idDashboard, SubProject FROM dashboard WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				db = new DashboardBean();
				db.setIdDashboard(rs.getInt(1));
				db.setSubProject(rs.getString(2));
				
				listDashboard.add(db);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listDashboard;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<DashboardBean> getDashboardByID(DashboardBean db){
		listDashboard = new ArrayList<DashboardBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			qry = "SELECT idAuth, idDashboard, IdPrioridad, SubProject, Item, qtyTarget, qtyAoT, Advance, Status, Remarks, Historico " +
				  "FROM dashboard WHERE idAuth=? and idDashboard=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, db.getIdAuth());
			pstm.setInt(2,db.getIdDashboard());
			pstm.setString(3,enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				db = new DashboardBean();
				db.setIdAuth(rs.getString(1));
				db.setIdDashboard(rs.getInt(2));
				db.setIdPriority(rs.getInt(3));
				db.setSubProject(rs.getString(4));
				db.setItem(rs.getString(5));
				db.setQtyTarget(rs.getDouble(6));
				db.setQtyAoT(rs.getDouble(7));
				db.setAdvance(rs.getInt(8));
				db.setStatus(rs.getString(9));
				db.setRemarks(rs.getString(10));
				db.setHistoric(rs.getString(11));
				
				listDashboard.add(db);

			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listDashboard;
	}
	
}
