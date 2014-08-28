package com.nextel.dashboard.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.OnRiskProjectsBean;


@Repository
public class OnRiskProjectsDAOImpl implements OnRiskProjectsDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<OnRiskProjectsBean> listOnRiskProjects = null;
	
	private OnRiskProjectsBean orpb = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*Propiedades*/
	private static final String PROJECT_PROPERTIES = "project.properties";
	private static final String ONRISK_ISSUE_TYPE = "onRiskIssueType";
	private static final String OPEN_ISSUE_STATUS = "openIssueStatus";
	
	/*
	 * 
	 * */
	public List<OnRiskProjectsBean> getOnRiskProjects(){
		listOnRiskProjects = new ArrayList<OnRiskProjectsBean>();
		Integer numberId = 0;
		
		Properties props = new Properties();
		
		try{
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROJECT_PROPERTIES));
			
			String issueType = props.getProperty(ONRISK_ISSUE_TYPE);
			String issueStatus = props.getProperty(OPEN_ISSUE_STATUS);
		
			Calendar dueDateFC = Calendar.getInstance();
			String sDueDateFC = null;

			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//Obten total de todos los proyectos
			qry = "SELECT p.projectName, i.issueRiskDescription, i.actionPlan, i.dueDateFC, p.status, p.owner FROM projects p, issuerisk i "
					+ "WHERE p.idAuth = i.idAuth and i.issueType = ? and i.issueStatus = ? ORDER BY p.projectName, i.dueDateFC DESC LIMIT 10";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, issueType);
			pstm.setString(2, issueStatus);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				numberId = numberId + 1;
				
				if(rs.getDate(4) != null ){
					dueDateFC.setTime(rs.getDate(4));
					sDueDateFC =  sdf.format(new Date(dueDateFC.getTimeInMillis()));
				}
				

				log.info(rs.getString(1) + rs.getString(2) + rs.getString(3) + sDueDateFC);
				
				orpb = new OnRiskProjectsBean();
				orpb.setProjectName(rs.getString(1));
				orpb.setIssueRiskDescription(rs.getString(2));
				orpb.setActionPlan(rs.getString(3));
				orpb.setDueDateFC(sDueDateFC);
				orpb.setStatus(rs.getString(5));
				orpb.setOwner(rs.getString(6));
				orpb.setNumberId(numberId);
				
				listOnRiskProjects.add(orpb);
			}
		} catch(IOException e){	
			log.error("ERROR PROPERTIES " + e.getMessage() + " OnRiskDAO");	
		} catch(SQLException sqle){
			log.error("ERROR OnRisKDAOIMPL" + sqle.getMessage());
		}
		
		return listOnRiskProjects;
	}
	

	
	
	
	/*
	 * 
	 * */
	public List<OnRiskProjectsBean> getIndividualOnRiskProject(String idAuth){
		listOnRiskProjects = new ArrayList<OnRiskProjectsBean>();
		
		Properties props = new Properties();
		
		try{
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROJECT_PROPERTIES));
			
			int prioridad = 1;
			String issueType = props.getProperty(ONRISK_ISSUE_TYPE);
			String issueStatus = props.getProperty(OPEN_ISSUE_STATUS);
			
			System.out.println(issueStatus + "--" + issueType);
		
			Calendar dueDateFC = Calendar.getInstance();
			String sDueDateFC = null;
			
			Calendar creationDate = Calendar.getInstance();
			String sCreationDate = null;

			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//Obten total de todos los proyectos
			/*
			qry = "SELECT p.projectName, i.issueRiskDescription, i.actionPlan, i.dueDateFC, i.creationDate FROM projects p, issuerisk i "
				+ "WHERE p.idAuth = i.idAuth and p.idAuth = ? and i.issueType = ? and i.issueStatus= ? and i.prioridad = ? "
				+ "AND i.dueDateFC between date_sub(now(),INTERVAL 1 WEEK) and now() ORDER BY p.projectName, i.dueDateFC DESC LIMIT 10";
			*/
			
			qry = "SELECT i.issueRiskDescription, i.actionPlan, i.dueDateFC, i.issueType, i.issueStatus, i.creationDate FROM issuerisk i "
					+ "WHERE i.idAuth = ? and i.issueType = ? and i.issueStatus= ? and i.prioridad = ? "
					+ "ORDER BY i.creationDate, i.dueDateFC DESC LIMIT 10";
			
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, issueType);
			pstm.setString(3, issueStatus);
			pstm.setInt(4, prioridad);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				if(rs.getDate(3) != null ){
					dueDateFC.setTime(rs.getDate(3));
					sDueDateFC =  sdf.format(new Date(dueDateFC.getTimeInMillis()));
				}else{
					sDueDateFC = "";
				}
				
				if(rs.getDate(6) != null ){
					creationDate.setTime(rs.getDate(6));
					sCreationDate =  sdf.format(new Date(creationDate.getTimeInMillis()));
				}else{
					sCreationDate = "";
				}
				
				orpb = new OnRiskProjectsBean();
				orpb.setIssueRiskDescription(rs.getString(1));
				orpb.setActionPlan(rs.getString(2));
				orpb.setDueDateFC(sDueDateFC);
				orpb.setIssueType(rs.getString(4));
				orpb.setStatus(rs.getString(5));
				orpb.setCreationDate(sCreationDate);
				
				listOnRiskProjects.add(orpb);
			}
		} catch(IOException e){	
			log.error("ERROR PROPERTIES " + e.getMessage() + " OnRiskDAO");	
		} catch(SQLException sqle){
			log.error("ERROR OnRisKDAOIMPL" + sqle.getMessage());
		}
		
		return listOnRiskProjects;
	}
	
}
