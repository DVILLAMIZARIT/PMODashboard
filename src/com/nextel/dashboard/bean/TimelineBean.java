package com.nextel.dashboard.bean;

import java.util.List;


public class TimelineBean extends MainBean {
	
	private String jsonTimeline;
	
	private String description;
	private String startFC;
	private String endFC;
	private String type;
	private Integer idTarea; 
	private Integer predecesor;
	private Integer advance;
	private String taskColor;

	
	/*
	 * 
	 * */
	public String getJsonTimeline() {
		return jsonTimeline;
	}
	public void setJsonTimeline(String jsonTimeline) {
		this.jsonTimeline = jsonTimeline;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getStartFC() {
		return startFC;
	}
	public void setStartFC(String startFC) {
		this.startFC = startFC;
	}
	
	
	public String getEndFC() {
		return endFC;
	}
	public void setEndFC(String endFC) {
		this.endFC = endFC;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Integer getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}
	
	
	public Integer getPredecesor() {
		return predecesor;
	}
	public void setPredecesor(Integer predecesor) {
		this.predecesor = predecesor;
	}
	
	
	public Integer getAdvance() {
		return advance;
	}
	public void setAdvance(Integer advance) {
		this.advance = advance;
	}
	
	
	public String getTaskColor() {
		return taskColor;
	}
	public void setTaskColor(String taskColor) {
		this.taskColor = taskColor;
	}	

}
