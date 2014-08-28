package com.nextel.dashboard.bean;

import java.util.List;

public class WMScheduleBean extends MainBean {
	
	private Integer idWM;
	private String projectName;
	private String scheduleDate;
	private String scheduleDesc;
	private Integer CR_Id;
	private String idPM;
	private String engineering;
	private String operations;
	private String deployment;
	private String security;
	private String noc;
	private String endDate;
	
	private List<WMScheduleBean> listOfEvents;
	
	
	/*
	 * 
	 * */
	public List<WMScheduleBean> getListOfEvents() {
		return listOfEvents;
	}
	public void setListOfEvents(List<WMScheduleBean> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	public Integer getIdWM() {
		return idWM;
	}
	public void setIdWM(Integer idWM) {
		this.idWM = idWM;
	}
	
	public String getScheduleDesc() {
		return scheduleDesc;
	}
	public void setScheduleDesc(String scheduleDesc) {
		this.scheduleDesc = scheduleDesc;
	}
	
	public Integer getCR_Id() {
		return CR_Id;
	}
	public void setCR_Id(Integer cR_Id) {
		CR_Id = cR_Id;
	}
	
	public String getIdPM() {
		return idPM;
	}
	public void setIdPM(String idPM) {
		this.idPM = idPM;
	}
	
	public String getEngineering() {
		return engineering;
	}
	public void setEngineering(String engineering) {
		this.engineering = engineering;
	}
	
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	
	public String getDeployment() {
		return deployment;
	}
	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}
	
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	
	public String getNoc() {
		return noc;
	}
	public void setNoc(String noc) {
		this.noc = noc;
	}	
}
