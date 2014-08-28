package com.nextel.dashboard.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;


public class Row {
	
	private Integer id;
	private List<Cell> cell;
	
	
	public Row(){
		cell = new ArrayList<Cell>();
	}
	
	
	@XmlAttribute
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public List<Cell> getCell() {
		return cell;
	}
	public void setCell(List<Cell> cell) {
		this.cell = cell;
	}
	

	
		
	
}
