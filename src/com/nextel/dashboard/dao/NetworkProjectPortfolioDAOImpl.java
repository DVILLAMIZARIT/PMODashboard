package com.nextel.dashboard.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.TopProjectsBean;


@Repository
public class NetworkProjectPortfolioDAOImpl implements NetworkProjectPortfolioDAO {
	
	/* Propiedades */
	private static final String PROJECT_PROPERTIES = "project.properties";
	private static final String CLOSED = "closed";
	private static final String ONTRACK = "ontrack";
	private static final String DELAYED = "delayed";
	private static final String ONRISK = "onrisk";
	private static final String CANCELED = "canceled";
	
	/* Projects or Initiatives */
	private static final String PROJECT = "P";
	private static final String INITIATIVE = "I";
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private List<ProjectBean> listProjects = null;
	private List<ProjectBean> listAccumulated = null;
	private List<ProjectBean> listMonthlyTarget = null;

	
	private ProjectBean pb = null;
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * Get the total of projects for the poi 
	 * */
	public List<ProjectBean> getProjects(){
		
		List<ProjectBean> listProjectsStatusPoi = null;
		List<ProjectBean> listInitiativesStatusPoi = null;
		
		listProjects = new ArrayList<ProjectBean>();
		
		//Obtiene la lista de Status de los proyectos
		//List<String> statusList = getStatusProjects();
		
		int totalProjectsPoi = 0;
		int totalInitiativesPoi = 0;
		

		
		try{
			//Get the total of projects and Initiatives by POI
			totalProjectsPoi = getTotalProjectsPoi(PROJECT);
			totalInitiativesPoi = getTotalProjectsPoi(INITIATIVE);
			
			//Get the total of projects by POI and Initiatives with Status and the percentage
			listProjectsStatusPoi = getProjectsByStatusPoi(PROJECT, totalProjectsPoi);
			listInitiativesStatusPoi = getProjectsByStatusPoi(INITIATIVE, totalInitiativesPoi);
			
			for(int a=0; a<5; a++){
				pb = new ProjectBean();
				pb.setStatus(listProjectsStatusPoi.get(a).getStatus());
				pb.setTotProject(listProjectsStatusPoi.get(a).getTotal());
				pb.setPercentageProject(listProjectsStatusPoi.get(a).getPercentage());
				pb.setTotInitiatives(listInitiativesStatusPoi.get(a).getTotal());
				pb.setPercentageInitiatives(listInitiativesStatusPoi.get(a).getPercentage());
				
				listProjects.add(pb);
				
				//log.info("STATUS P " + listProjectsStatusPoi.get(a).getStatus());
				//log.info("TOTAL P " + listProjectsStatusPoi.get(a).getTotal());
				//log.info("PERCENTAGE P " + listProjectsStatusPoi.get(a).getPercentage());
				
				//log.info("STATUS I " + listInitiativesStatusPoi.get(a).getStatus());
				//log.info("TOTAL I " + listInitiativesStatusPoi.get(a).getTotal());
				//log.info("PERCENTAGE I " + listInitiativesStatusPoi.get(a).getPercentage());
			}
				
		} catch(Exception sqle){
			log.error("ERROR NetworkProjectPortfolioDAOIMPL" + sqle.getMessage());
		}
		
		
		return listProjects;
		
	}
	
	
	
	
	/*
	 * Get the total of projects for the poi 
	 * */
	private int getTotalProjectsPoi(String poi){
		int total = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
		
			//Obten total de todos los proyectos
			qry = "SELECT COUNT(projectName) AS total FROM projects WHERE poi=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, poi);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				total = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR NetworkProjectPortfolioDAOIMPL" + sqle.getMessage());
		}
		
		
		return total;
		
	}
	
	
	
	/*
	 * Get the total of projects for the poi and the status
	 * */
	private List<ProjectBean> getProjectsByStatusPoi(String poi, int totalByPoi){
		List<ProjectBean> list = new ArrayList<ProjectBean>();
		String enabled = "Activo";
		
		//Obtiene la lista de Status de los proyectos
		List<String> statusList = getStatusProjects();
		
		float percentage;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//Obten totales por proyecto
			for(int a=0; a<statusList.size(); a++){
				
				qry = "SELECT count(projectName) as total, status FROM dashboard.projects WHERE status=? AND poi=? AND enabled=?";
				
				pstm = con.prepareStatement(qry);
				pstm.setString(1, statusList.get(a));
				pstm.setString(2, poi);
				pstm.setString(3, enabled);
				rs = pstm.executeQuery();
				
				while(rs.next()){
					
					percentage = (rs.getInt(1) * 100) / totalByPoi;
					
					pb = new ProjectBean();
					pb.setTotal(rs.getInt(1));
					pb.setStatus(rs.getString(2));
					pb.setPercentage(percentage);
				}
				list.add(pb);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR NetworkProjectPortfolioDAOIMPL" + sqle.getMessage());
		}
		
		return list;
		
	}	
	
	
	
	/*
	 * 
	 * */
	private List<String> getStatusProjects() {
		Properties props = new Properties();
		List<String> listStatusProject = new ArrayList<String>();
		
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROJECT_PROPERTIES));
			listStatusProject.add(props.getProperty(CLOSED));
			listStatusProject.add(props.getProperty(ONTRACK));
			listStatusProject.add(props.getProperty(ONRISK));
			listStatusProject.add(props.getProperty(DELAYED));
			listStatusProject.add(props.getProperty(CANCELED));
		} catch (IOException e) {
			log.info(e.getMessage() + " NetworkProjectPortfoliosDAO");
		}
		return listStatusProject;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getAccumulated(){
		listAccumulated = new ArrayList<ProjectBean>();
		
		//Temp lists to get the data to build the Charts
		List<List<Integer>> listTempBL = null;
		List<List<Integer>> listTempFC = null;
		List<List<Integer>> listTempACT = null;
		
		try{
			 
			listTempBL = getTotalProjectsByMonth("EndBL");
			listTempFC = getTotalProjectsByMonth("EndFC");
			listTempACT = getTotalProjectsByMonth("EndACT");
			
			pb = new ProjectBean();			
			pb.setListAccumulatedEndBL(listTempBL.get(1));
			pb.setListAccumulatedEndFC(listTempFC.get(1));
			pb.setListAccumulatedEndACT(listTempACT.get(1));
			
			listAccumulated.add(pb);
			
		} catch(Exception sqle){
			log.error("ERROR NETWORK PROJECT DAOIMPL" + sqle.getMessage() + " getAccumulated");
			log.error(sqle.getLocalizedMessage());
			log.error(sqle.getStackTrace());
		}
		
		return listAccumulated;
	}
	
	
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getMonthlyTarget(){
		//Temp lists to get the data to build the Charts
		List<List<Integer>> listTempBL = null;
		List<List<Integer>> listTempFC = null;
		List<List<Integer>> listTempACT = null;
		
		listMonthlyTarget = new ArrayList<ProjectBean>();
		
		try{
			 
			listTempBL = getTotalProjectsByMonth("EndBL");
			listTempFC = getTotalProjectsByMonth("EndFC");
			listTempACT = getTotalProjectsByMonth("EndACT");
			
			pb = new ProjectBean();
			pb.setListEndBL(listTempBL.get(0));
			pb.setListEndFC(listTempFC.get(0));
			pb.setListEndACT(listTempACT.get(0));
			
			listMonthlyTarget.add(pb);
			
			
		} catch(Exception sqle){
			log.error("ERROR NETWORK PROJECT DAOIMPL" + sqle.getMessage() + " getMonthlyTarget");
			log.error(sqle.getLocalizedMessage());
			log.error(sqle.getStackTrace());
		}
		
		return listMonthlyTarget;
	}
	
	
	/*
	 * 
	 * */
	private List<List<Integer>> getTotalProjectsByMonth(String typeProject){
		List<List<Integer>> listAll = new LinkedList<List<Integer>>(); 
		List<Integer> listTotalProjectsByMonth = new LinkedList<Integer>(); 
		List<Integer> listTotalAccumulated = new LinkedList<Integer>(); 
		String formatted = null;
		int monthly = 0;
		int accumulated = 0;
		
		Calendar calendar = Calendar.getInstance();
		int actualYear = calendar.get(Calendar.YEAR);
		int actualMonth = calendar.get(Calendar.MONTH) + 1;
		String yearAndMonth = null;		
		
		Calendar calendar13 = Calendar.getInstance();
		int lastYear = calendar13.get(Calendar.YEAR) - 1;
		String yearAndMonth13 = null;
		
		String enabled = "Activo";
		
		//Properties props = new Properties();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			//props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROJECT_PROPERTIES));
			
			for(int a=1; a<=12; a++){
				
				formatted = String.format("%02d", a);
				yearAndMonth = new Integer(actualYear).toString() + "-" + formatted + "-%";
				yearAndMonth13 = new Integer(lastYear).toString() + "-" + formatted + "-%";
				
				//Obten total de todos los proyectos
				if(typeProject.equals("EndBL")){
					qry = "SELECT COUNT(*) FROM projects p, projectsdate d "
						+ "WHERE p.idAuth = d.idAuth AND d.Type='Project' "
						+ "AND (d.EndBL like ? OR d.EndBL like ?) "
						+ "AND p.enabled=? "
						+ "ORDER by d.EndBL"; 
				}
				else if(typeProject.equals("EndFC")){
					qry = "SELECT COUNT(*) FROM projects p, projectsdate d "
							+ "WHERE p.idAuth = d.idAuth AND d.Type='Project' "
							+ "AND (d.EndFC like ? OR d.EndFC like ?) "
							+ "AND p.enabled=? "
							+ "ORDER by d.EndFC"; 
				}
				else if(typeProject.equals("EndACT")){
					qry = "SELECT COUNT(*) FROM projects p, projectsdate d "
						+ "WHERE p.idAuth = d.idAuth AND d.Type='Project' "
						+ "AND (d.EndACT like ? OR d.EndACT like ?) "
						+ "AND (p.status = 'Closed' OR p.status='Canceled') "
						+ "AND p.enabled=? "
						+ "ORDER by d.EndACT";
				}
				
				pstm = con.prepareStatement(qry);
				pstm.setString(1, yearAndMonth13);
				pstm.setString(2, yearAndMonth);
				pstm.setString(3, enabled);
				rs = pstm.executeQuery();
			
				while(rs.next()){		
					monthly = rs.getInt(1);
					accumulated = accumulated + monthly;
					
					/*
					if(typeProject.equals("EndBL")){
						System.out.println("SUMANDO ACUMULADOS " + accumulated + " + " + monthly);
					}
					*/	
						
					if(typeProject.equals("EndACT")){
						if(a >= actualMonth){
							accumulated = 0;
						}
					}
					
					//log.info(typeProject + ":" + a +  ":" + monthly + ":Acunmulados:" + accumulated);
					
					listTotalProjectsByMonth.add(monthly);
					listTotalAccumulated.add(accumulated);
					
					System.out.println("TOTAL ACCU" + listTotalAccumulated.size());
					System.out.println("TOTAL MONTHLY" + listTotalProjectsByMonth.size());
				}
				
				listAll.add(listTotalProjectsByMonth);
				listAll.add(listTotalAccumulated);
				
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage() + " getTotalProjectsByMonth");
			log.error(sqle.getLocalizedMessage());
			log.error(sqle.getStackTrace());
		}	
		/*
		}catch(IOException e){
			e.printStackTrace();
		}
		*/
		
		return listAll;
	}
	
}
