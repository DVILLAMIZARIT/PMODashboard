package com.nextel.dashboard.bean;

import javax.xml.bind.annotation.XmlAttribute;

public class Category {
	
	private String label;

	@XmlAttribute
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
