package com.nextel.dashboard.bean;

public class ResponsabilityRolesBean extends MainBean {
	
	private Integer idRole;
	private String task;
	private String area;
	private String role;
	private String clasifica;

	/*
	 * 
	 * */
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getClasifica() {
		return clasifica;
	}
	public void setClasifica(String clasifica) {
		this.clasifica = clasifica;
	}
}
