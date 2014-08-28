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

import com.nextel.dashboard.bean.DelayedProjectsBean;


@Repository
public class DelayedProjectsDAOImpl implements DelayedProjectsDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<DelayedProjectsBean> listDelayedProjects = null;
	
	private DelayedProjectsBean dpb = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*Propiedades*/
	private static final String PROJECT_PROPERTIES = "project.properties";
	private static final String DELAYED_ISSUE_TYPE = "delayedIssueType";
	private static final String OPEN_ISSUE_STATUS = "openIssueStatus";
	
	/*
	 * 
	 * */
	public List<DelayedProjectsBean> getDelayedProjects(){
		listDelayedProjects = new ArrayList<DelayedProjectsBean>();
		Integer numberId = 0;
		
		Properties props = new Properties();
		
		try{
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROJECT_PROPERTIES));
			
			String issueType = props.getProperty(DELAYED_ISSUE_TYPE);
			String issueStatus = props.getProperty(OPEN_ISSUE_STATUS);
		
			Calendar dueDateBL = Calendar.getInstance();
			String sDueDateBL = null;
		
		
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//Obten total de todos los proyectos
			qry = "SELECT p.projectName, i.issueRiskDescription, i.actionPlan, i.dueDateBL, p.status, p.owner FROM projects p, issuerisk i "
				+ "WHERE p.idAuth = i.idAuth and i.issueType = ? and i.issueStatus = ? ORDER BY p.projectName";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, issueType);
			pstm.setString(2, issueStatus);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				numberId = numberId + 1;
				
				if(rs.getDate(4) != null ){
					dueDateBL.setTime(rs.getDate(4));
					sDueDateBL =  sdf.format(new Date(dueDateBL.getTimeInMillis()));
				}
				

				log.info(rs.getString(1) + rs.getString(2) + rs.getString(3) + sDueDateBL);
				
				dpb = new DelayedProjectsBean();
				dpb.setProjectName(rs.getString(1));
				dpb.setIssueRiskDescription(rs.getString(2));
				dpb.setActionPlan(rs.getString(3));
				dpb.setDueDateBL(sDueDateBL);
				dpb.setStatus(rs.getString(5));
				dpb.setOwner(rs.getString(6));
				dpb.setNumberId(numberId);
				
				listDelayedProjects.add(dpb);
			}
		} catch(IOException e){	
			log.error("ERROR PROPERTIES " + e.getMessage() + " DelayedDAO");
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL " + sqle.getMessage() + " DelayedDAO");
		}
		
		return listDelayedProjects;
	}
	

	
}
