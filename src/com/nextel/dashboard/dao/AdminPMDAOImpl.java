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

import com.nextel.dashboard.bean.PMBean;


@Repository
public class AdminPMDAOImpl implements AdminPMDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<PMBean> listPM = null;
    private List<PMBean> listPMData = null;
    
    private PMBean pmb = null;
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public List<PMBean> getDataPMByIdPM(String idPM){
		listPMData = new ArrayList<PMBean>();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idPM, pmName, radio, ext, celular, skype, email, enabled " +
				  "FROM pm WHERE idPM = ?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idPM);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				pmb = new PMBean();
				pmb.setIdPM(rs.getString(1));
				pmb.setPmName(rs.getString(2));
				pmb.setRadio(rs.getString(3));
				pmb.setExt(rs.getInt(4));
				pmb.setCelular(rs.getString(5));
				pmb.setSkype(rs.getString(6));
				pmb.setEmail(rs.getString(7));
				pmb.setEnabled(rs.getString(8));
				
				listPMData.add(pmb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listPMData;
	}
	
	
	
	/*
	 * 
	 * */
	public boolean createPM(PMBean pmb){
		boolean created = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO pm (idPM, pmName, radio, ext, celular, skype, email, enabled) " +
				  "VALUES(?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, pmb.getIdPM());
			pstm.setString(2, pmb.getPmName());
			pstm.setString(3, pmb.getRadio());
			pstm.setInt(4, pmb.getExt());
			pstm.setString(5, pmb.getCelular());
			pstm.setString(6, pmb.getSkype());
			pstm.setString(7, pmb.getEmail());
			pstm.setString(8, "Activo");
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL PM CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<PMBean> getListPM(){
		listPM = new ArrayList<PMBean>();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idPm, pmName, radio, ext, celular, skype, email, enabled FROM pm";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				pmb = new PMBean();
				pmb.setIdPM(rs.getString(1));
				pmb.setPmName(rs.getString(2));
				pmb.setRadio(rs.getString(3));
				pmb.setExt(rs.getInt(4));
				pmb.setCelular(rs.getString(5));
				pmb.setSkype(rs.getString(6));
				pmb.setEmail(rs.getString(7));
				pmb.setEnabled(rs.getString(8));
				
				listPM.add(pmb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listPM;
	}
	
	
	
	/*
	 * 
	 * */
	public List<PMBean> getListPMEnabled(){
		listPM = new ArrayList<PMBean>();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idPm, pmName, radio, ext, celular, skype, email, enabled FROM pm WHERE enabled='Activo'";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				pmb = new PMBean();
				pmb.setIdPM(rs.getString(1));
				pmb.setPmName(rs.getString(2));
				pmb.setRadio(rs.getString(3));
				pmb.setExt(rs.getInt(4));
				pmb.setCelular(rs.getString(5));
				pmb.setSkype(rs.getString(6));
				pmb.setEmail(rs.getString(7));
				pmb.setEnabled(rs.getString(8));
				
				listPM.add(pmb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listPM;
	}
	
	
	/*
	 * 
	 * */
	public boolean deletePM(String idPM){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE pm SET enabled='Baja' WHERE idPM=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idPM);
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
	public boolean updatePM(PMBean pmb){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			qry = "UPDATE pm SET pmName=?, radio=?, ext=?, celular=?, skype=?, email=?, enabled=? WHERE idPM=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, pmb.getPmName());
			pstm.setString(2, pmb.getRadio());
			pstm.setInt(3, pmb.getExt());
			pstm.setString(4, pmb.getCelular());
			pstm.setString(5, pmb.getSkype());
			pstm.setString(6, pmb.getEmail());	
			pstm.setString(7, pmb.getEnabled());
			pstm.setString(8, pmb.getIdPM());
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
	
}
