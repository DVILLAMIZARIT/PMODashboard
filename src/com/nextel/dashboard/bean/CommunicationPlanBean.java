package com.nextel.dashboard.bean;

public class CommunicationPlanBean extends MainBean {
	
	private Integer idCommunicationPlan;
	private String communication;
	private String frequency;
	private String media;
	private String audience;
	private String deliverable;
	
	/*
	 * 
	 * */
	public Integer getIdCommunicationPlan() {
		return idCommunicationPlan;
	}
	public void setIdCommunicationPlan(Integer idCommunicationPlan) {
		this.idCommunicationPlan = idCommunicationPlan;
	}
	
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	
	public String getDeliverable() {
		return deliverable;
	}
	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}
	
}
