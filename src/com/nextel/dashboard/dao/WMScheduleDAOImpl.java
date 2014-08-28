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

import com.nextel.dashboard.bean.WMScheduleBean;


@Repository
public class WMScheduleDAOImpl implements WMScheduleDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<WMScheduleBean> listOfEvents = null;
	
	private WMScheduleBean wmsb = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * 
	 * */
	public List<WMScheduleBean> getEvents(){
		listOfEvents = new ArrayList<WMScheduleBean>();
		Calendar schedule = Calendar.getInstance();
		String scheduleDate = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			} 
			
			//Obten total de todos los proyectos
			qry = "SELECT p.idAuth, p.projectName, w.scheduleDate FROM projects p, wmschedule w WHERE p.idAuth = w.idAuth";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			Integer i = 0;
			while(rs.next()){
				if(rs.getDate(3) != null ){
					schedule.setTime(rs.getDate(3));
					scheduleDate =  sdf.format(new Date(schedule.getTimeInMillis()));
				}

				log.info(rs.getString(1) + " - " + rs.getString(2) + " - " + scheduleDate);
				
				wmsb = new WMScheduleBean();
				//wmsb.setIdAuth(rs.getString(1));
				wmsb.setIdAuth(i.toString());
				wmsb.setProjectName(rs.getString(2));
				wmsb.setScheduleDate(scheduleDate);
				wmsb.setEndDate(scheduleDate);
				
				listOfEvents.add(wmsb);
				i++;
			}
			
			//Create another instance of the bean to save the list of all Events
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " TopProjectDAO");
		}
		
		return listOfEvents;
	}
	

	
}
