package com.nextel.dashboard.bean;

public class OnRiskProjectsBean extends MainBean {
	
	private Integer idIssueRisk;
	private String issueRiskDescription;
	private String actionPlan;
	private String dueDateBL;
	private String dueDateFC;
	private String dueDateACT;
	private String issueStatus;
	private String issueType;
	private String priority;
	private String owner;
	
	

	/*
	 * 
	 * */
	public String getIssueRiskDescription() {
		return issueRiskDescription;
	}
	public void setIssueRiskDescription(String issueRiskDescription) {
		this.issueRiskDescription = issueRiskDescription;
	}
	
	public String getActionPlan() {
		return actionPlan;
	}
	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}
	
	public String getDueDateFC() {
		return dueDateFC;
	}
	public void setDueDateFC(String dueDateFC) {
		this.dueDateFC = dueDateFC;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	public Integer getIdIssueRisk() {
		return idIssueRisk;
	}
	public void setIdIssueRisk(Integer idIssueRisk) {
		this.idIssueRisk = idIssueRisk;
	}
	
	public String getDueDateBL() {
		return dueDateBL;
	}
	public void setDueDateBL(String dueDateBL) {
		this.dueDateBL = dueDateBL;
	}
	
	public String getDueDateACT() {
		return dueDateACT;
	}
	public void setDueDateACT(String dueDateACT) {
		this.dueDateACT = dueDateACT;
	}
	
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
