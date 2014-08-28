package com.nextel.dashboard.bean;


public class PMBean extends MainBean {
	
	private String idPM;
	private String pmName;
	private String radio;
	private Integer ext;
	private String celular;
	private String skype;
	private String email;
	private String enabled;
	
	
	
	/*
	 * 
	 * */
	public String getIdPM() {
		return idPM;
	}
	public void setIdPM(String idPM) {
		this.idPM = idPM;
	}
	
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	
	public Integer getExt() {
		return ext;
	}
	public void setExt(Integer ext) {
		this.ext = ext;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}
