package com.nextel.dashboard.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class DataSet {
	
	
	@XmlPath("dataset/@seriesName")
	private String seriesName;
	
	
	@XmlElementWrapper(name="dataset")
	@XmlElement(name="set")
	private List<SetProjects> dataSetSeriesBL;
	
	
	public List<SetProjects> getDataSetSeriesBL() {
		return dataSetSeriesBL;
	}
	public void setDataSetSeriesBL(List<SetProjects> dataSetSeriesBL) {
		this.dataSetSeriesBL = dataSetSeriesBL;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

}
