package com.nextel.dashboard.bean;

import java.util.List;

import javax.persistence.Column;


public class ProjectBean extends MainBean {
	
	private String idPM;
	private String poi;
	private String owner;
	private String budgetKey;
	private String sponsor;
	private String type;
	private String manager;
	private Integer topProject;
	private String stream;
	private String status;
	
	
	
	private Integer total;
	private Float percentage;
	private Integer totProject;
	private Float percentageProject;
	private Integer totInitiatives;
	private Float percentageInitiatives;
	private String jsonMonthlyData;
	private String jsonAccumulatedData;
	private Chart chart;
	
	private List<Integer> listEndBL;
	private List<Integer> listEndFC;
	private List<Integer> listEndACT;
	
	private List<Integer> listAccumulatedEndBL;
	private List<Integer> listAccumulatedEndFC;
	private List<Integer> listAccumulatedEndACT;

	/*
	 * 
	 * */	
	public String getIdPM() {
		return idPM;
	}
	public void setIdPM(String idPM) {
		this.idPM = idPM;
	}
	
	
	public String getPoi() {
		return poi;
	}
	public void setPoi(String poi) {
		this.poi = poi;
	}
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public String getBudgetKey() {
		return budgetKey;
	}
	public void setBudgetKey(String budgetKey) {
		this.budgetKey = budgetKey;
	}
	
	
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	public Integer getTopProject() {
		return topProject;
	}
	public void setTopProject(Integer topProject) {
		this.topProject = topProject;
	}
	
	
	public Integer getTotProject() {
		return totProject;
	}
	public void setTotProject(Integer totProject) {
		this.totProject = totProject;
	}
	
	
	public Float getPercentageProject() {
		return percentageProject;
	}
	public void setPercentageProject(Float percentageProject) {
		this.percentageProject = percentageProject;
	}
	
	
	public Integer getTotInitiatives() {
		return totInitiatives;
	}
	public void setTotInitiatives(Integer totInitiatives) {
		this.totInitiatives = totInitiatives;
	}
	
	
	public Float getPercentageInitiatives() {
		return percentageInitiatives;
	}
	public void setPercentageInitiatives(Float percentageInitiatives) {
		this.percentageInitiatives = percentageInitiatives;
	}
	
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	
	
	public String getJsonMonthlyData() {
		return jsonMonthlyData;
	}
	public void setJsonMonthlyData(String jsonMonthlyData) {
		this.jsonMonthlyData = jsonMonthlyData;
	}
	
	
	public String getJsonAccumulatedData() {
		return jsonAccumulatedData;
	}
	public void setJsonAccumulatedData(String jsonAccumulatedData) {
		this.jsonAccumulatedData = jsonAccumulatedData;
	}
	
	
	public Chart getChart() {
		return chart;
	}
	public void setChart(Chart chart) {
		this.chart = chart;
	}

	
	public List<Integer> getListEndBL() {
		return listEndBL;
	}
	public void setListEndBL(List<Integer> listEndBL) {
		this.listEndBL = listEndBL;
	}
	
	
	public List<Integer> getListEndFC() {
		return listEndFC;
	}
	public void setListEndFC(List<Integer> listEndFC) {
		this.listEndFC = listEndFC;
	}
	
	
	public List<Integer> getListEndACT() {
		return listEndACT;
	}
	public void setListEndACT(List<Integer> listEndACT) {
		this.listEndACT = listEndACT;
	}
	
	
	public List<Integer> getListAccumulatedEndBL() {
		return listAccumulatedEndBL;
	}
	public void setListAccumulatedEndBL(List<Integer> listAccumulatedEndBL) {
		this.listAccumulatedEndBL = listAccumulatedEndBL;
	}
	
	
	public List<Integer> getListAccumulatedEndFC() {
		return listAccumulatedEndFC;
	}
	public void setListAccumulatedEndFC(List<Integer> listAccumulatedEndFC) {
		this.listAccumulatedEndFC = listAccumulatedEndFC;
	}
	
	
	public List<Integer> getListAccumulatedEndACT() {
		return listAccumulatedEndACT;
	}
	public void setListAccumulatedEndACT(List<Integer> listAccumulatedEndACT) {
		this.listAccumulatedEndACT = listAccumulatedEndACT;
	}
	
	
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
