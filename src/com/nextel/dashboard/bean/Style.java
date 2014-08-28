package com.nextel.dashboard.bean;

import javax.xml.bind.annotation.XmlAttribute;


public class Style {
	
	private String name;
	private String type;
	private Integer size;
	private String font;
	
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlAttribute
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	@XmlAttribute
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	
}
