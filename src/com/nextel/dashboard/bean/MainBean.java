package com.nextel.dashboard.bean;

public class MainBean {

	private String idAuth;
	private String projectName;
	private String status;
	private Integer numberId;
	private String creationDate;
	private String enabled;
	
	

	/*
	 * 
	 * */
	public Integer getNumberId() {
		return numberId;
	}
	public void setNumberId(Integer numberId) {
		this.numberId = numberId;
	}
	
	
	public String getIdAuth() {
		return idAuth;
	}
	public void setIdAuth(String idAuth) {
		this.idAuth = idAuth;
	}
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}	

}
