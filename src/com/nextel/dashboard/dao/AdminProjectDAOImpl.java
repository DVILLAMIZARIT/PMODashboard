package com.nextel.dashboard.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;


@Repository
public class AdminProjectDAOImpl implements AdminProjectDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    /* Propiedades */
	private static final String PROJECT_PROPERTIES = "project.properties";
	private static final String CLOSED = "closed";
	private static final String ONTRACK = "ontrack";
	private static final String DELAYED = "delayed";
	private static final String ONRISK = "onrisk";
	private static final String CANCELED = "canceled";
    
    private List<PMBean> listPM = null;
    private List<ProjectBean> listProjects = null;
    private List<ProjectBean> listStatus = null;
    private List<ProjectBean> listProjectData = null;
    
    private PMBean pmb = null;
    private ProjectBean pb = null;
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getDataProjecByIdAuth(String idAuth){
		listProjectData = new ArrayList<ProjectBean>();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT projectName, idPM, owner, poi, sponsor, manager, stream, " +
				  "topProject, budgetKey, type, status " +
				  "FROM projects WHERE idAuth = ?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				pb = new ProjectBean();
				pb.setProjectName(rs.getString(1));
				pb.setIdPM(rs.getString(2));
				pb.setOwner(rs.getString(3));
				pb.setPoi(rs.getString(4));
				pb.setSponsor(rs.getString(5));
				pb.setManager(rs.getString(6));
				pb.setStream(rs.getString(7));
				pb.setTopProject(rs.getInt(8));
				pb.setBudgetKey(rs.getString(9));
				pb.setType(rs.getString(10));
				pb.setStatus(rs.getString(11));
				
				listProjectData.add(pb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listProjectData;
	}	
	
	
	
	/*
	 * 
	 * */
	public String getPMname(String idPM){
		String pmName = "";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT pmName from pm WHERE idPM = ?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idPM);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				pmName = rs.getString(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return pmName;
	}
	
	
	/*
	 * 
	 * */
	public String getLastIdAuth(){
		String lastIdAuth = "";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "select idauth from projects order by idauth DESC LIMIT 1";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdAuth = rs.getString(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return lastIdAuth;
	}
	
	
	
	/*
	 * 
	 * */
	public boolean createProject(ProjectBean pb){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO projects (idAuth, projectName, idPM, poi, owner, sponsor, manager, topProject, stream, enabled) " +
				  "VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, pb.getIdAuth());
			pstm.setString(2, pb.getProjectName());
			pstm.setString(3, pb.getIdPM());
			pstm.setString(4, pb.getPoi());
			pstm.setString(5, pb.getOwner());
			pstm.setString(6, pb.getSponsor());
			pstm.setString(7, pb.getManager());
			pstm.setInt(8, pb.getTopProject());
			pstm.setString(9, pb.getStream());
			pstm.setString(10, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<PMBean> getListPM(){
		listPM = new ArrayList<PMBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idPm, pmName FROM pm WHERE enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				pmb = new PMBean();
				pmb.setIdPM(rs.getString(1));
				pmb.setPmName(rs.getString(2));
				
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
	public List<ProjectBean> getListProjects(){
		listProjects = new ArrayList<ProjectBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idAuth, projectName FROM projects WHERE enabled=? ORDER by projectName";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				pb = new ProjectBean();
				pb.setIdAuth(rs.getString(1));
				pb.setProjectName(rs.getString(2));
				
				listProjects.add(pb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listProjects;
	}
	
	
	
	
	/*
	 * 
	 * */
	public boolean deleteProject(String idAuth){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//DELETE
			 
			qry = "UPDATE projects SET enabled='Baja' WHERE idAuth=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
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
	public boolean updateProject(ProjectBean pb){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//INSERT
			System.out.println(pb.getIdAuth());
			System.out.println(pb.getProjectName());
			System.out.println(pb.getIdPM());
			System.out.println(pb.getOwner());
			System.out.println(pb.getPoi());
			System.out.println(pb.getSponsor());
			System.out.println(pb.getManager());
			System.out.println(pb.getStream());
			System.out.println(pb.getTopProject());
			
			
			qry = "UPDATE projects SET projectName=?, idPM=?, owner=?, poi=?, sponsor=?, manager=?, stream=?, topProject=?, " +
				  "budgetKey=?, type=?, status=? " +
				  "WHERE idAuth=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, pb.getProjectName());
			pstm.setString(2, pb.getIdPM());
			pstm.setString(3, pb.getOwner());
			pstm.setString(4, pb.getPoi());
			pstm.setString(5, pb.getSponsor());
			pstm.setString(6, pb.getManager());
			pstm.setString(7, pb.getStream());	
			pstm.setInt(8, pb.getTopProject());
			pstm.setString(9, pb.getBudgetKey());
			pstm.setString(10, pb.getType());
			pstm.setString(11, pb.getStatus());
			pstm.setString(12, pb.getIdAuth());
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
	public List<ProjectBean> getListStatus(){
		Properties props = new Properties();
		
		listStatus = new ArrayList<ProjectBean>();
		
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROJECT_PROPERTIES));
			
			pb = new ProjectBean();
			pb.setStatus(props.getProperty(CLOSED));
			listStatus.add(pb);
			
			pb = new ProjectBean();
			pb.setStatus(props.getProperty(ONTRACK));
			listStatus.add(pb);
			
			pb = new ProjectBean();
			pb.setStatus(props.getProperty(ONRISK));
			listStatus.add(pb);
			
			pb = new ProjectBean();
			pb.setStatus(props.getProperty(DELAYED));
			listStatus.add(pb);
			
			pb = new ProjectBean();
			pb.setStatus(props.getProperty(CANCELED));
			listStatus.add(pb);
			
		} catch (IOException e) {
			log.info(e.getMessage() + " NetworkProjectPortfoliosDAO");
		}
		
		return listStatus;
	}
	
	
}
