package com.nextel.dashboard.bean;

import java.util.List;

import javax.persistence.Column;


public class FourUpBean extends MainBean {
	
	private int id4ups;
	private String description;
	private String type;
	private String dateUps;
	private String flag;
	private String creationDate;
	
	
	/*
	 * 
	 * */	
	public int getId4ups() {
		return id4ups;
	}
	public void setId4ups(int id4ups) {
		this.id4ups = id4ups;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getDateUps() {
		return dateUps;
	}
	public void setDateUps(String dateUps) {
		this.dateUps = dateUps;
	}
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
}
