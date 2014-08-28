package com.nextel.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.CurrentTargetBean;


@Repository
public class CurrentTargetDAOImpl implements CurrentTargetDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<CurrentTargetBean> listCurrentTarget = null;
	
	private CurrentTargetBean ctb = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * 
	 * */
	public List<CurrentTargetBean> getCurrentTarget(){
		listCurrentTarget = new ArrayList<CurrentTargetBean>();
		Integer numberId = 0;
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		String typeProject = "";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.projectName, m.pmName, d.endBL, d.endFC, p.status, p.poi FROM projects p, pm m, projectsdate d "
				+ "WHERE p.idPM = m.idPM and p.idAuth = d.idAuth and d.Type='Project' "
				+ "AND p.status != 'Canceled' "
				+ "AND MONTH(d.endFC) = MONTH(NOW()) " 
				//+ "AND d.endFC between date_sub(now(),INTERVAL 1 MONTH) and now() "
				+ "ORDER BY d.endFC";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){		
				
				numberId = numberId + 1;
				
				if(rs.getDate(3) != null ){
					endBL.setTime(rs.getDate(3));
					sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
				}
				
				if(rs.getDate(4) != null ){
					endFC.setTime(rs.getDate(4));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				
				if(rs.getString(6).equals("P")){
					typeProject = "Project";
				}
				else{
					typeProject = "Initiative";
				}
				
				ctb = new CurrentTargetBean();
				ctb.setProjectName(rs.getString(1));
				ctb.setPmName(rs.getString(2));
				ctb.setEndBL(sEndBL);
				ctb.setEndFC(sEndFC);
				ctb.setStatus(rs.getString(5));
				ctb.setNumberId(numberId);
				ctb.setTypeProject(typeProject);
				
				listCurrentTarget.add(ctb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listCurrentTarget;
	}
	

	
	/*
	 * 
	 * */
	public List<CurrentTargetBean> getCurrentTargetFilterByProject(String project){
		listCurrentTarget = new ArrayList<CurrentTargetBean>();
		Integer numberId = 0;
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		String typeProject = "";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.projectName, m.pmName, d.endBL, d.endFC, p.status, p.poi FROM projects p, pm m, projectsdate d "
				+ "WHERE p.idPM = m.idPM and p.idAuth = d.idAuth and d.Type='Project' "
				+ "AND p.status != 'Canceled' "
				+ "AND MONTH(d.endFC) = MONTH(NOW()) " 
				+ "AND p.projectName = ? "
				//+ "AND d.endFC between date_sub(now(),INTERVAL 1 MONTH) and now() "
				+ "ORDER BY d.endFC";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, project);
			rs = pstm.executeQuery();
			
			while(rs.next()){		
				
				numberId = numberId + 1;
				
				if(rs.getDate(3) != null ){
					endBL.setTime(rs.getDate(3));
					sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
				}
				
				if(rs.getDate(4) != null ){
					endFC.setTime(rs.getDate(4));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				
				if(rs.getString(6).equals("P")){
					typeProject = "Project";
				}
				else{
					typeProject = "Initiative";
				}
				
				ctb = new CurrentTargetBean();
				ctb.setProjectName(rs.getString(1));
				ctb.setPmName(rs.getString(2));
				ctb.setEndBL(sEndBL);
				ctb.setEndFC(sEndFC);
				ctb.setStatus(rs.getString(5));
				ctb.setNumberId(numberId);
				ctb.setTypeProject(typeProject);
				
				listCurrentTarget.add(ctb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listCurrentTarget;
	}
	
}
