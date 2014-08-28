package com.nextel.dashboard.bean;

import javax.xml.bind.annotation.XmlValue;


public class Cell {

	private String cell;

	
	@XmlValue
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
}