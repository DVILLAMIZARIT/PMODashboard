package com.nextel.dashboard.bean;


public class AccomplishmentsBean extends MainBean {

	private String pmName;
	private String endBL;
	private String endFC;
	private String endACT;
	
	private boolean allProjects;
	private boolean individualProject;
	private boolean noProject;
	
	//For individual Projects
	private String description;
	private String dueDate;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	
	public String getEndBL() {
		return endBL;
	}
	public void setEndBL(String endBL) {
		this.endBL = endBL;
	}
	
	public String getEndFC() {
		return endFC;
	}
	public void setEndFC(String endFC) {
		this.endFC = endFC;
	}
	
	public String getEndACT() {
		return endACT;
	}
	public void setEndACT(String endACT) {
		this.endACT = endACT;
	}
	
	
	public boolean isAllProjects() {
		return allProjects;
	}
	public void setAllProjects(boolean allProjects) {
		this.allProjects = allProjects;
	}
	
	
	public boolean isIndividualProject() {
		return individualProject;
	}
	public void setIndividualProject(boolean individualProject) {
		this.individualProject = individualProject;
	}
	
	
	public boolean isNoProject() {
		return noProject;
	}
	public void setNoProject(boolean noProject) {
		this.noProject = noProject;
	}

}
