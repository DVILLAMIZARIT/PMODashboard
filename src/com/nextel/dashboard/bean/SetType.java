package com.nextel.dashboard.bean;

import javax.xml.bind.annotation.XmlAttribute;


public class SetType {
	
	private Integer value;
	
	
	@XmlAttribute
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
