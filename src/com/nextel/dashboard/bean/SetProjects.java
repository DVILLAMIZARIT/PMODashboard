package com.nextel.dashboard.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class SetProjects {
	
	private List<SetType> set;
	private String seriesName;
	
	
	public SetProjects(){
		set = new ArrayList<SetType>();
	}

	
	
	public List<SetType> getSet() {
		return set;
	}
	public void setSet(List<SetType> set) {
		this.set = set;
	}

	@XmlAttribute
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public String getSeriesName() {
		return seriesName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

