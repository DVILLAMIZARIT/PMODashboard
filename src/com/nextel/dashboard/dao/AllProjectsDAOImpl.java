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

import com.nextel.dashboard.bean.AccomplishmentsBean;
import com.nextel.dashboard.bean.AllProjectsBean;
import com.nextel.dashboard.bean.MilestoneBean;
import com.nextel.dashboard.bean.NextStepsBean;


@Repository
public class AllProjectsDAOImpl implements AllProjectsDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<AllProjectsBean> listAllProjects = null;
    private List<AccomplishmentsBean> listAccomplishments = null;
    private List<NextStepsBean> listNextSteps = null;
    private List<MilestoneBean> listMilestones = null;
    
	private AllProjectsBean apb = null;
	private AccomplishmentsBean acb = null;
	private NextStepsBean nsb = null;
	private MilestoneBean mb = null;
	
	public final static String ACCOMPLISHMENTS = "Accomplishment"; 
	public final static String NEXTSTEPS = "Next Steps";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * 
	 * */
	public List<AllProjectsBean> getAllProjects(){
		listAllProjects = new ArrayList<AllProjectsBean>();
		int numberId = 0;
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		Calendar endACT = Calendar.getInstance();
		String sEndACT = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.idAuth, p.projectName, p.status, m.pmName, d.endBL, d.endFC, d.endAct FROM projects p, pm m, projectsdate d "
				+ "WHERE p.idPM = m.idPM and p.idAuth = d.idAuth and d.Type='Project' ORDER BY p.projectName, m.pmName";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				numberId = numberId + 1;
				
				if(rs.getDate(5) != null ){
					endBL.setTime(rs.getDate(5));
					sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
				}
				
				if(rs.getDate(6) != null ){
					endFC.setTime(rs.getDate(6));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				if(rs.getDate(7) != null ){
					endACT.setTime(rs.getDate(7));
					sEndACT =  sdf.format(new Date(endACT.getTimeInMillis()));
				}
				

				apb = new AllProjectsBean();
				apb.setIdAuth(rs.getString(1));
				apb.setProjectName(rs.getString(2));
				apb.setStatus(rs.getString(3));
				apb.setPmName(rs.getString(4));
				apb.setEndBL(sEndBL);
				apb.setEndFC(sEndFC);
				apb.setEndACT(sEndACT);
				apb.setNumberId(numberId);
				
				listAllProjects.add(apb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listAllProjects;
	}
	
	
	
	/*
	 * 
	 * */
	public List<AllProjectsBean> getAllProjectsFilterByPM(String filterPM){
		listAllProjects = new ArrayList<AllProjectsBean>();
		int numberId = 0;
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		Calendar endACT = Calendar.getInstance();
		String sEndACT = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.idAuth, p.projectName, p.status, m.pmName, d.endBL, d.endFC, d.endAct FROM projects p, pm m, projectsdate d "
				+ "WHERE p.idPM = m.idPM and p.idAuth = d.idAuth and d.Type='Project' AND m.pmName = ? ORDER BY p.projectName, m.pmName";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, filterPM);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				numberId = numberId + 1;
				
				if(rs.getDate(5) != null ){
					endBL.setTime(rs.getDate(5));
					sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
				}
				
				if(rs.getDate(6) != null ){
					endFC.setTime(rs.getDate(6));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}
				
				if(rs.getDate(7) != null ){
					endACT.setTime(rs.getDate(7));
					sEndACT =  sdf.format(new Date(endACT.getTimeInMillis()));
				}
				

				apb = new AllProjectsBean();
				apb.setIdAuth(rs.getString(1));
				apb.setProjectName(rs.getString(2));
				apb.setStatus(rs.getString(3));
				apb.setPmName(rs.getString(4));
				apb.setEndBL(sEndBL);
				apb.setEndFC(sEndFC);
				apb.setEndACT(sEndACT);
				apb.setNumberId(numberId);
				
				listAllProjects.add(apb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listAllProjects;
	}
	

	
	/*
	 * 
	 * */
	public List<MilestoneBean> getMilestones(String idAuth){
		listMilestones = new ArrayList<MilestoneBean>();
		
		//log.info("Projecto Individual en DAO " + idAuth);
		Calendar startFC = Calendar.getInstance();
		String sStartFC = null;
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		
		Calendar startACT = Calendar.getInstance();
		String sStartACT = null;
		Calendar endACT = Calendar.getInstance();
		String sEndACT = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			
			//Obten total de todos los proyectos
			qry = "SELECT d.Description, d.startFC, d.startACT, d.endFC, d.endACT FROM projects p, projectsdate d "
				+ "WHERE p.idAuth = d.idAuth AND p.idAuth = ? and d.Principal = '1' and d.Type != 'Milestone' ORDER BY d.idTarea LIMIT 10";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			rs = pstm.executeQuery();
			
			while(rs.next()){	
				
				//System.out.println("FECHA ACT " + rs.getString(5));
				
				if(rs.getDate(2) != null ){
					startFC.setTime(rs.getDate(2));
					sStartFC =  sdf.format(new Date(startFC.getTimeInMillis()));
				}else{
					sStartFC = "";
				}
				
				if(rs.getDate(3) != null ){
					startACT.setTime(rs.getDate(3));
					sStartACT =  sdf.format(new Date(startACT.getTimeInMillis()));
				}else{
					sStartACT = "";
				}
				
				if(rs.getDate(4) != null ){
					endFC.setTime(rs.getDate(4));
					sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
				}else{
					sEndFC = "";
				}
				
				
				if(rs.getString(5) != null){
					System.out.println("CON DATOS " + rs.getString(1));
					endACT.setTime(rs.getDate(5));
					sEndACT =  sdf.format(new Date(endACT.getTimeInMillis()));
				}else{
					sEndACT = "";
				}
				
				mb = new MilestoneBean();
				mb.setProjectName(rs.getString(1));
				mb.setStartFC(sStartFC);
				mb.setStartACT(sStartACT);
				mb.setEndFC(sEndFC);
				mb.setEndACT(sEndACT);
				listMilestones.add(mb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listMilestones;
	}	
	
	
	
	/*
	 * 
	 * */
	public List<AccomplishmentsBean> getAccomplishments(String idAuth){
		listAccomplishments = new ArrayList<AccomplishmentsBean>();
		
		String status = "";
		int flag = 1;
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		
		Calendar creationDate = Calendar.getInstance();
		String sCreationDate = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.idAuth, a.Description, a.dateUps, p.status, a.creationDate FROM projects p, fourups a "
				+ "WHERE p.idAuth = a.idAuth AND p.idAuth = ? AND a.Type = ? and a.Flag = ? "
				+ "ORDER by a.dateUps DESC LIMIT 10";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, ACCOMPLISHMENTS);
			pstm.setInt(3, flag);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				if(rs.getDate(3) != null ){
					endBL.setTime(rs.getDate(3));
					sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
				}else{
					sEndBL = "";
				}
				
				if(rs.getDate(5) != null ){
					creationDate.setTime(rs.getDate(5));
					sCreationDate =  sdf.format(new Date(creationDate.getTimeInMillis()));
				}else{
					sCreationDate = "";
				}
				
				status = rs.getString(4);
				if(status.equals("Closed") || status.equals("Canceled")){
					status = "Close";
				}
				else{
					System.out.println(status);
					status = "Open";
				}

				//log.info(rs.getString(1) + rs.getString(2) + endBL);
				
				acb = new AccomplishmentsBean();
				acb.setDescription(rs.getString(2));
				acb.setDueDate(sEndBL);
				acb.setStatus(status);
				acb.setCreationDate(sCreationDate);
				
				listAccomplishments.add(acb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listAccomplishments;
	}	
	
	
	
	/*
	 * 
	 * */
	public List<NextStepsBean> getNextSteps(String idAuth){
		listNextSteps = new ArrayList<NextStepsBean>();
		
		String status = "";
		int flag = 1;
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		
		Calendar creationDate = Calendar.getInstance();
		String sCreationDate = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT p.idAuth, a.Description, a.dateUps, p.Status, a.creationDate FROM projects p, fourups a "
				+ "WHERE p.idAuth = a.idAuth AND p.idAuth = ? AND a.Type = ? AND a.Flag = ? "
				+ "ORDER BY a.dateUps DESC LIMIT 10";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, NEXTSTEPS);
			pstm.setInt(3, flag);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				if(rs.getDate(3) != null ){
					endBL.setTime(rs.getDate(3));
					sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
				}else{
					sEndBL = "";
				}
				
				if(rs.getDate(5) != null ){
					creationDate.setTime(rs.getDate(5));
					sCreationDate =  sdf.format(new Date(creationDate.getTimeInMillis()));
				}else{
					sCreationDate = "";
				}
				
				status = rs.getString(4);
				if(status.equals("Closed") || status.equals("Canceled")){
					status = "Close";
				}
				else{
					status = "Open";
				}

				//log.info(rs.getString(1) + rs.getString(2) + endBL);
				
				nsb = new NextStepsBean();
				nsb.setDescription(rs.getString(2));
				nsb.setDueDate(sEndBL);
				nsb.setStatus(status);
				nsb.setCreationDate(sCreationDate);
				
				listNextSteps.add(nsb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listNextSteps;
	}
	
	
	
	
	
	
	
	/*
	 * 
	 * */
	public List<AllProjectsBean> searchProject(String projectName){
		List<AllProjectsBean> listAllProjects = new ArrayList<AllProjectsBean>();
		
		int totalRows = 0;
		
		projectName = "%" + projectName + "%";
		//log.info("Buscar Proyecto " + projectName);
		
		Calendar endBL = Calendar.getInstance();
		String sEndBL = null;
		Calendar endFC = Calendar.getInstance();
		String sEndFC = null;
		Calendar endACT = Calendar.getInstance();
		String sEndACT = null;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten total de todos los proyectos
			qry = "SELECT count(*) as total FROM projects WHERE projectName like ?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, projectName);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				totalRows = rs.getInt(1);
			}
			
			if(totalRows >= 2){
				//log.info("SI SON MUCHAS");
				
				//Obten total de todos los proyectos
				qry = "SELECT p.idAuth, p.projectName, m.pmName, d.endBL, d.endFC, d.endAct FROM projects p, pm m, projectsdate d "
					+ "WHERE p.idPM = m.idPM and p.idAuth = d.idAuth and d.Type='Project' and p.projectName like ? ORDER BY p.projectName";
				pstm = con.prepareStatement(qry);
				pstm.setString(1, projectName);
				rs = pstm.executeQuery();
				
				while(rs.next()){				
					
					if(rs.getDate(4) != null ){
						endBL.setTime(rs.getDate(4));
						sEndBL =  sdf.format(new Date(endBL.getTimeInMillis()));
					}
					
					if(rs.getDate(5) != null ){
						endFC.setTime(rs.getDate(5));
						sEndFC =  sdf.format(new Date(endFC.getTimeInMillis()));
					}
					
					if(rs.getDate(6) != null ){
						endACT.setTime(rs.getDate(6));
						sEndACT =  sdf.format(new Date(endACT.getTimeInMillis()));
					}
					

					//log.info(rs.getString(1) + rs.getString(2) + endBL + endFC + endACT);
					
					apb = new AllProjectsBean();
					apb.setIdAuth(rs.getString(1));
					apb.setProjectName(rs.getString(2));
					apb.setPmName(rs.getString(3));
					apb.setEndBL(sEndBL);
					apb.setEndFC(sEndFC);
					apb.setEndACT(sEndACT);
					apb.setAllProjects(true);
					
					listAllProjects.add(apb);
				}
			}
			else if(totalRows == 1){
				//log.info("REGRESA el individual");
				
				
				//Obtiene el ID del proyecto encontrado
				qry = "SELECT idAuth, projectName FROM projects WHERE projectName like ?";
				pstm = con.prepareStatement(qry);
				pstm.setString(1, projectName);
				rs = pstm.executeQuery();
				
				while(rs.next()){				
					//log.info(rs.getString(1));
					
					apb = new AllProjectsBean();
					apb.setIdAuth(rs.getString(1));
					apb.setProjectName(rs.getString(2));
					apb.setIndividualProject(true);
					
					listAllProjects.add(apb);
				}
			}
			else{
				//log.info("NO EXISTE EL PROYECTO");
				
				apb = new AllProjectsBean();
				apb.setIdAuth("");
				apb.setProjectName("NO SE ENCONTRO NINGUN PROYECTO");
				apb.setPmName("");
				apb.setEndBL("");
				apb.setEndFC("");
				apb.setEndACT("");
				apb.setNoProject(true);
				
				listAllProjects.add(apb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listAllProjects;
	}	
	
}
