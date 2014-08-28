package com.nextel.dashboard.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"row"})
public class Rows {
	
	private List<Row> row;

	public Rows(){
		row = new ArrayList<Row>();
	}	
	
	
	
	public List<Row> getRow() {
		return row;
	}
	public void setRow(List<Row> row) {
		this.row = row;
	}
	
}
