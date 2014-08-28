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

import com.nextel.dashboard.bean.TimelineBean;


@Repository
public class TimelineDAOImpl implements TimelineDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<TimelineBean> listTimeline = null;

	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * 
	 * */
	public List<TimelineBean> getTimeline(String idAuth){
		listTimeline = new ArrayList<TimelineBean>();
		TimelineBean tlb = null;

		String description = ""; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		int actualYear = calendar.get(Calendar.YEAR);
		String sActualYear = null;
		
		String startFC = null;
		String endFC = null;
		Date today = new Date();
		
		String taskColor = "0";
		
		String enabled = "Activo";
	
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			sActualYear = new Integer(actualYear).toString() + "-%";
			
			//Obten total de todos los proyectos
			qry = "SELECT Description, StartFC, EndFC, EndACT, Type, IdTarea, Predecesor, Avance "
				+ "FROM projectsdate "
				+ "WHERE idAuth = ? "
				+ "AND (StartFC like ? OR EndFC like ?) "
				+ "AND enabled=? " 
				+ "ORDER by IdTarea ";	
			
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, sActualYear);
			pstm.setString(3, sActualYear);
			pstm.setString(4, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				
				//Replace apos
				description = rs.getString(1);
				description = description.replaceAll("'", "");
				description = description.replaceAll("\n", "");
				

				if(rs.getDate(3) == null){
					endFC = "12/31/2014";
				}
				else{
					endFC = sdf.format(rs.getDate(3));
				}
				
				
				if(rs.getDate(2) == null){
					startFC = endFC;
				}	
				else{
					startFC = sdf.format(rs.getDate(2));
				}
				
				
				
				//validate tasks colors
				
				if(rs.getDate(4) != null){
					System.out.println(rs.getDate(4));
					//taskColor = "0597D2";
					taskColor = "32CD32";
				}
				/*
				else if (today.after(rs.getDate(2))){
					taskColor = "#32CD32";
				}
				else{
					
				}
				*/
				
				//System.out.println(rs.getString(1)+"|||"+ description + "|||" + rs.getString(5)+ "|||" + rs.getInt(8));
				
				tlb = new TimelineBean();
				tlb.setDescription(description);
				tlb.setStartFC(startFC);
				tlb.setEndFC(endFC);
				tlb.setType(rs.getString(5));
				tlb.setIdTarea(rs.getInt(6));
				tlb.setPredecesor(rs.getInt(7));
				tlb.setAdvance(rs.getInt(8));
				tlb.setTaskColor(taskColor);
				
				listTimeline.add(tlb);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TimelinetDAOImpl");
		}
		
		return listTimeline;
	}
	

	/*
	 * 
	 * */
	public int getTotalTimelines(String idAuth){
		int totalTimelines = 0;

		Calendar calendar = Calendar.getInstance();
		int actualYear = calendar.get(Calendar.YEAR);
		String sActualYear = null;
		
		String enabled = "Activo";

	
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			sActualYear = new Integer(actualYear).toString() + "-%";
			
			//Obten total de todos los proyectos
			qry = "SELECT COUNT(*) "
				+ "FROM projectsdate "
				+ "WHERE idAuth = ? "
				+ "AND (StartFC like ? OR EndFC like ?) "
				+ "AND enabled = ?  "
				+ "and (Type = 'Task' or Type = 'Group') ";
			
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, sActualYear);
			pstm.setString(3, sActualYear);
			pstm.setString(4, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				totalTimelines = rs.getInt(1);
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TimelinetDAOImpl");
		}
		
		return totalTimelines;
	}
	
}
