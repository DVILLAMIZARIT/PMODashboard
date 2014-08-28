package com.nextel.dashboard.service;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.Chart;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.dao.NetworkProjectPortfolioDAO;
import com.nextel.dashboard.util.JSONGeneratorImpl;
import com.nextel.dashboard.util.XMLGeneratorImpl;

@Service
@Transactional(readOnly=true)
public class NetworkProjectPortfolioServiceImpl implements NetworkProjectPortfolioService {
	
	@Autowired
	private NetworkProjectPortfolioDAO nppDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	
    private XMLGeneratorImpl xmlGenerator = null;
    private JSONGeneratorImpl jsonGenerator = null;
	private List<ProjectBean> projects = null;
	private List<ProjectBean> accumulate = null;

	/*
	 * 
	 * */
	public List<ProjectBean> getProjects(){
		projects = new ArrayList<ProjectBean>();
		
		log.info("LLEGO AL SERVICE NETWORK PERFECTAMENTE");
		projects = nppDAO.getProjects();
		
		//xmlGenerator = new XMLGeneratorImpl();
		//String xmlString = xmlGenerator.generateTableProject(projects);
		//Chart chart = xmlGenerator.generateCharts(projects);
		//projects.get(0).setChart(chart);
		
		//Insert the XML string in the first line of the List
		//projects.get(0).setXmlString(xmlString);
		
		return projects;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> createAccumulate(){
		accumulate = new ArrayList<ProjectBean>();
		//accumulate = nppDAO.createAccumulate();
		xmlGenerator = new XMLGeneratorImpl();
		xmlGenerator.generateCharts(accumulate);
		
		
		return accumulate;
	}
	
	
	/*
	 * 
	 * */
	public List<ProjectBean> getAccumulated(){
		//projects = new ArrayList<ProjectBean>();
		
		projects = nppDAO.getAccumulated();
		
		jsonGenerator = new JSONGeneratorImpl();
		String jsonAccumulatedString = jsonGenerator.generateDataChartAccumulated(projects);
		
		//Insert the XML string in the first line of the List
		projects.get(0).setJsonAccumulatedData(jsonAccumulatedString);
		
		return projects;
	}
	
	/*
	 * 
	 * */
	public List<ProjectBean> getMonthlyTarget(){
		//projects = new ArrayList<ProjectBean>();
		projects = nppDAO.getMonthlyTarget();

		jsonGenerator = new JSONGeneratorImpl();
		String jsonMonthlyString = jsonGenerator.generateDataChartMonthly(projects);
				
		//Insert the XML string in the first line of the List
		projects.get(0).setJsonMonthlyData(jsonMonthlyString);
		
		return projects;
	}
	
}
