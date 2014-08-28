package com.nextel.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.PMBean;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.ProjectsDateBean;


@Repository
public class AdminProjectsDateDAOImpl implements AdminProjectsDateDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<ProjectsDateBean> listDataProjectsDate = null;
    private List<ProjectsDateBean> listDescriptions = null;
    private List<ProjectBean> listProjects = null;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private ProjectBean pb = null;
    private ProjectsDateBean pdb = null;
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	
	/*
	 * 
	 * */
	public int getLastIdDate(){
		int lastIdDate = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idDate FROM projectsdate ORDER by idDate DESC LIMIT 1";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastIdDate = rs.getInt(1) + 1;
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return lastIdDate;
	}
	
	
	/*
	 * 
	 * */
	public boolean createProjectDate(ProjectsDateBean pdb){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			qry = "INSERT INTO projectsdate (idDate, idAuth, Description, Type, IdTarea, Predecesor, StartBL, EndBL, StartFC, EndFC, "
				  + "StartACT, EndACT, ResourceName, Avance, Principal, IdGroup, enabled) " +
				  "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, pdb.getIdDate());
			pstm.setString(2, pdb.getIdAuth());
			pstm.setString(3, pdb.getDescription());
			pstm.setString(4, pdb.getType());
			pstm.setInt(5, pdb.getIdTask());
			pstm.setInt(6, pdb.getPredecesor());
			pstm.setString(7, pdb.getStartBL());
			pstm.setString(8,  pdb.getEndBL());
			pstm.setString(9, pdb.getStartFC());
			pstm.setString(10, pdb.getEndFC());
			pstm.setString(11, pdb.getStartACT());
			pstm.setString(12, pdb.getEndACT());
			pstm.setString(13, pdb.getResourceName());
			pstm.setInt(14, pdb.getAdvance());
			pstm.setInt(15, pdb.getPrincipal());
			pstm.setInt(16, pdb.getIdGroup());
			pstm.setString(17, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return created;
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
			
			qry = "SELECT idAuth, projectName FROM projects ORDER by projectName where enabled=?";
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
	public boolean deleteProjectDate(ProjectsDateBean pdb){
		boolean deleted = false;
		String enabled = "Baja";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//DELETE

			qry = "UPDATE projectsdate SET enabled=? WHERE idAuth=? AND idDate=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, enabled);
			pstm.setString(2, pdb.getIdAuth());
			pstm.setInt(3, pdb.getIdDate());
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
	public List<ProjectsDateBean> getListDescriptions(String idAuth){
		listDescriptions = new ArrayList<ProjectsDateBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idDate, Description FROM projectsdate WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				pdb = new ProjectsDateBean();
				pdb.setIdDate(rs.getInt(1));
				pdb.setDescription(rs.getString(2));
				
				listDescriptions.add(pdb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listDescriptions;
		
	}
	
	
	/*
	 *
	 * */
	public List<ProjectsDateBean> getProjectsDateByDesc(ProjectsDateBean pdb){
		listDataProjectsDate = new ArrayList<ProjectsDateBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idAuth, Description, Type, IdTarea, Predecesor,StartBL, EndBL, StartFC, EndFC, StartACT, EndACT, "
				  + "ResourceName, Avance, Principal, IdGroup " +
				  "FROM projectsdate " +
				  "WHERE idAuth=? and idDate=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, pdb.getIdAuth());
			pstm.setInt(2,pdb.getIdDate());
			pstm.setString(3, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				pdb = new ProjectsDateBean();
				pdb.setIdAuth(rs.getString(1));
				pdb.setDescription(rs.getString(2));
				pdb.setType(rs.getString(3));
				pdb.setIdTask(rs.getInt(4));
				pdb.setPredecesor(rs.getInt(5));
				pdb.setStartBL(rs.getString(6));
				pdb.setEndBL(rs.getString(7));
				pdb.setStartFC(rs.getString(8));
				pdb.setEndFC(rs.getString(9));
				pdb.setStartACT(rs.getString(10));
				pdb.setEndACT(rs.getString(11));
				pdb.setResourceName(rs.getString(12));
				pdb.setAdvance(rs.getInt(13));
				pdb.setPrincipal(rs.getInt(14));
				pdb.setIdGroup(rs.getInt(15));
				
				listDataProjectsDate.add(pdb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listDataProjectsDate;
	}
	
	
	/*
	 * 
	 * */
	public boolean updateProjectDate(ProjectsDateBean pdb){
		boolean updated = false;
		int contUpdates = 9;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			
			qry = "UPDATE projectsdate SET Description=?, Type=?, IdTarea=?, Predecesor=?, Avance=?, ResourceName=?, Principal=?, idGroup=?  ";
			
			if(!pdb.getStartFC().equals("")){
				qry = qry.concat(",StartFC=? ");
			}
			
			if(!pdb.getEndFC().equals("") ){
				qry = qry.concat(",EndFC=? ");
			}
			
			if(!pdb.getStartACT().equals("") ){
				qry = qry.concat(",StartACT=? ");
			}
			
			if(!pdb.getEndACT().equals("")){
				qry = qry.concat(",EndACT=? ");
			}
			
		    qry = qry.concat(" WHERE idAuth=? AND idDate =? ");
		    
		    
			pstm = con.prepareStatement(qry);
			pstm.setString(1, pdb.getDescription());
			pstm.setString(2, pdb.getType());
			pstm.setInt(3, pdb.getIdTask());	
			pstm.setInt(4, pdb.getPredecesor());
			pstm.setInt(5, pdb.getAdvance());
			pstm.setString(6, pdb.getResourceName());
			pstm.setInt(7, pdb.getPrincipal());
			pstm.setInt(8, pdb.getIdGroup());
			
			if(!pdb.getStartFC().equals("")){
				pstm.setString(contUpdates, pdb.getStartFC());
				contUpdates++;
			}
			
			if(!pdb.getEndFC().equals("")){
				pstm.setString(contUpdates, pdb.getEndFC());
				contUpdates++;
				
			}
			
			if(!pdb.getStartACT().equals("")){
				pstm.setString(contUpdates, pdb.getStartACT());
				contUpdates++;
			}
			
			if(!pdb.getEndACT().equals("")){
				pstm.setString(contUpdates, pdb.getEndACT());
				contUpdates++;
			}
			
			pstm.setString(contUpdates, pdb.getIdAuth());
			contUpdates++;
			pstm.setInt(contUpdates, pdb.getIdDate());
			
			//Execute Update
			int res = pstm.executeUpdate();
			
			System.out.println("RESULT " + res);
			
			if(res != 0){
				updated = true;
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return updated;
	}
	
	
}
