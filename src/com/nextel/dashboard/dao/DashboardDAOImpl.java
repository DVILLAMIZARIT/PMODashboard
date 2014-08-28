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

import com.nextel.dashboard.bean.TopProjectsBean;


@Repository
public class DashboardDAOImpl implements DashboardDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<TopProjectsBean> listTopProjects = null;
	
	private TopProjectsBean tpb = null;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	//Used for filter query
	private static final String TYPE = "Project";
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjects(){
		listTopProjects = new ArrayList<TopProjectsBean>();
		Integer numberId = 0;
		Double advance = null;
		
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.stream, p.type, d.SubProject, d.qtyTarget, d.qtyAoT, d.Advance, p.status, a.endFC, p.idAuth, d.IdPrioridad "
					+ " FROM projects p, dashboard d, projectsdate a "
					+ " WHERE p.idAuth = d.idAuth AND p.idAuth = a.idAuth AND a.type= ?"
					+ " ORDER BY d.IdPrioridad";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, TYPE);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				numberId = numberId + 1;
				
				if(rs.getDate(8) != null ){
					endFC.setTime(rs.getDate(8));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				advance = rs.getDouble(5) / rs.getDouble(4);
				advance = advance * 100;
				
				tpb = new TopProjectsBean();
				tpb.setStream(rs.getString(1));
				tpb.setType(rs.getString(2));
				tpb.setSubProject(rs.getString(3));
				tpb.setQtyTarget(rs.getDouble(4));
				tpb.setQtyAoT(rs.getDouble(5));
				tpb.setAdvance(advance.intValue());
				tpb.setStatus(rs.getString(7));
				tpb.setEndFC(sEndFC);
				tpb.setIdAuth(rs.getString(9));
				tpb.setIdPrioridad((int)rs.getDouble(10));
				tpb.setNumberId(numberId);
				
				listTopProjects.add(tpb);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TopProjectDAO");
		}
		
		return listTopProjects;
	}
	
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getMonthTopProjects(){
		listTopProjects = new ArrayList<TopProjectsBean>();
		int topProject = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//Obten total de todos los proyectos
			qry = "SELECT p.idAuth, p.projectName, p.status "
				+ "FROM projects p "
				+ "WHERE topProject != ? "
				+ "ORDER BY p.topProject";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, topProject);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				//log.info(rs.getString(1) + rs.getString(2));
				
				tpb = new TopProjectsBean();
				tpb.setIdAuth(rs.getString(1));
				tpb.setProjectName(rs.getString(2));
				tpb.setStatus(rs.getString(3));
				
				listTopProjects.add(tpb);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TopProjectDAO");
		}
		
		return listTopProjects;
	}
	
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjectsFilterByPriority(String priority){
		listTopProjects = new ArrayList<TopProjectsBean>();
		Integer numberId = 0;
		Double advance = null;
		
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.stream, p.type, d.SubProject, d.qtyTarget, d.qtyAoT, d.Advance, p.status, a.endFC, p.idAuth, d.IdPrioridad "
					+ " FROM projects p, dashboard d, projectsdate a "
					+ " WHERE p.idAuth = d.idAuth AND p.idAuth = a.idAuth AND a.type= ? "
					+ " AND d.IdPrioridad= ? "
					+ " ORDER BY d.IdPrioridad";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, TYPE);
			pstm.setString(2, priority);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				numberId = numberId + 1;
				
				if(rs.getDate(8) != null ){
					endFC.setTime(rs.getDate(8));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				advance = rs.getDouble(5) / rs.getDouble(4);
				advance = advance * 100;
				
				tpb = new TopProjectsBean();
				tpb.setStream(rs.getString(1));
				tpb.setType(rs.getString(2));
				tpb.setSubProject(rs.getString(3));
				tpb.setQtyTarget(rs.getDouble(4));
				tpb.setQtyAoT(rs.getDouble(5));
				tpb.setAdvance(advance.intValue());
				tpb.setStatus(rs.getString(7));
				tpb.setEndFC(sEndFC);
				tpb.setIdAuth(rs.getString(9));
				tpb.setIdPrioridad((int)rs.getDouble(10));
				tpb.setNumberId(numberId);
				
				listTopProjects.add(tpb);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TopProjectDAO");
		}
		
		return listTopProjects;
	}
	
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjectsFilterByProject(String project){
		listTopProjects = new ArrayList<TopProjectsBean>();
		Integer numberId = 0;
		Double advance = null;
		
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.stream, p.type, d.SubProject, d.qtyTarget, d.qtyAoT, d.Advance, p.status, a.endFC, p.idAuth, d.IdPrioridad "
					+ " FROM projects p, dashboard d, projectsdate a "
					+ " WHERE p.idAuth = d.idAuth AND p.idAuth = a.idAuth AND a.type= ?"
					+ " AND p.type= ? "
					+ " ORDER BY d.IdPrioridad";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, TYPE);
			pstm.setString(2, project);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				numberId = numberId + 1;
				
				if(rs.getDate(8) != null ){
					endFC.setTime(rs.getDate(8));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				advance = rs.getDouble(5) / rs.getDouble(4);
				advance = advance * 100;
				
				tpb = new TopProjectsBean();
				tpb.setStream(rs.getString(1));
				tpb.setType(rs.getString(2));
				tpb.setSubProject(rs.getString(3));
				tpb.setQtyTarget(rs.getDouble(4));
				tpb.setQtyAoT(rs.getDouble(5));
				tpb.setAdvance(advance.intValue());
				tpb.setStatus(rs.getString(7));
				tpb.setEndFC(sEndFC);
				tpb.setIdAuth(rs.getString(9));
				tpb.setIdPrioridad((int)rs.getDouble(10));
				tpb.setNumberId(numberId);
				
				listTopProjects.add(tpb);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TopProjectDAO");
		}
		
		return listTopProjects;
	}
	
	
	
	
	/*
	 * 
	 * */
	public List<TopProjectsBean> getTopProjectsFilterByAll(String priority, String project){
		listTopProjects = new ArrayList<TopProjectsBean>();
		Integer numberId = 0;
		Double advance = null;
		
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.stream, p.type, d.SubProject, d.qtyTarget, d.qtyAoT, d.Advance, p.status, a.endFC, p.idAuth, d.IdPrioridad "
					+ " FROM projects p, dashboard d, projectsdate a "
					+ " WHERE p.idAuth = d.idAuth AND p.idAuth = a.idAuth AND a.type= ?"
					+ " AND d.IdPrioridad= ? "
					+ " AND p.type= ? "
					+ " ORDER BY d.IdPrioridad";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, TYPE);
			pstm.setString(2, priority);
			pstm.setString(3, project);
			rs = pstm.executeQuery();
			
			while(rs.next()){				

				numberId = numberId + 1;
				
				if(rs.getDate(8) != null ){
					endFC.setTime(rs.getDate(8));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				advance = rs.getDouble(5) / rs.getDouble(4);
				advance = advance * 100;
				
				tpb = new TopProjectsBean();
				tpb.setStream(rs.getString(1));
				tpb.setType(rs.getString(2));
				tpb.setSubProject(rs.getString(3));
				tpb.setQtyTarget(rs.getDouble(4));
				tpb.setQtyAoT(rs.getDouble(5));
				tpb.setAdvance(advance.intValue());
				tpb.setStatus(rs.getString(7));
				tpb.setEndFC(sEndFC);
				tpb.setIdAuth(rs.getString(9));
				tpb.setIdPrioridad((int)rs.getDouble(10));
				tpb.setNumberId(numberId);
				
				listTopProjects.add(tpb);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TopProjectDAO");
		}
		
		return listTopProjects;
	}
	
}
