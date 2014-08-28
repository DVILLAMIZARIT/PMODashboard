package com.nextel.dashboard.bean;

public class DashboardBean extends MainBean {
	
	private Integer idDashboard;
	private Integer idPriority;
	private String subProject;
	private String item;
	private Double qtyTarget;
	private Double qtyAoT;
	private Integer advance;
	private String status;
	private String remarks;
	private String historic;

	
	
	/*
	 * 
	 * */
	public Integer getIdDashboard() {
		return idDashboard;
	}
	public void setIdDashboard(Integer idDashboard) {
		this.idDashboard = idDashboard;
	}
	
	public Integer getIdPriority() {
		return idPriority;
	}
	public void setIdPriority(Integer idPriority) {
		this.idPriority = idPriority;
	}
	
	public String getSubProject() {
		return subProject;
	}
	public void setSubProject(String subProject) {
		this.subProject = subProject;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	public Double getQtyTarget() {
		return qtyTarget;
	}
	public void setQtyTarget(Double qtyTarget) {
		this.qtyTarget = qtyTarget;
	}
	
	public Double getQtyAoT() {
		return qtyAoT;
	}
	public void setQtyAoT(Double qtyAoT) {
		this.qtyAoT = qtyAoT;
	}
	
	public Integer getAdvance() {
		return advance;
	}
	public void setAdvance(Integer advance) {
		this.advance = advance;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getHistoric() {
		return historic;
	}
	public void setHistoric(String historic) {
		this.historic = historic;
	}
	
}
