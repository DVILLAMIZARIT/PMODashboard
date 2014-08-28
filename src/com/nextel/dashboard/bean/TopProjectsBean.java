package com.nextel.dashboard.bean;


public class TopProjectsBean extends MainBean {
	
	private String stream;
	private String type;
	private String subProject;
	private Double qtyTarget;
	private Double qtyAoT;
	private Integer advance;
	private String endFC;
	private int idPrioridad;
	
	
	
	/*
	 * 
	 * */
	public String getEndFC() {
		return endFC;
	}
	public void setEndFC(String endFC) {
		this.endFC = endFC;
	}
	
	
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getSubProject() {
		return subProject;
	}
	public void setSubProject(String subProject) {
		this.subProject = subProject;
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
	
	
	public int getIdPrioridad() {
		return idPrioridad;
	}
	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}
	
}
