package com.nextel.dashboard.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlType(propOrder={"categories", "dataSet", "styles"})
public class Chart {
	
	/*Lista de Atributos*/
	@XmlAttribute
	private String legendPosition;
	@XmlAttribute
	private int exportEnabled;
	@XmlAttribute
	private int exportAtCliente;
	@XmlAttribute
	private String exportHandler;
	@XmlAttribute
	private String caption;
	@XmlAttribute
	private String xAxisName;
	@XmlAttribute
	private String bgColor;
	@XmlAttribute
	private int showBorder;
	@XmlAttribute
	private int canvasBorderThickness;
	@XmlAttribute
	private int showPlotBorder;
	@XmlAttribute
	private int useRoundEdges;
	
	
	@XmlElementWrapper(name="categories")
	@XmlElement(name="category")
	private List<Category> categories;
	

	private List<SetProjects> dataSet;
	
	@XmlElementWrapper(name="styles")
	@XmlElement(name="definition")
	private List<Definition> styles;
	
	
	public Chart(){
		categories = new ArrayList<Category>();
		dataSet = new ArrayList<SetProjects>();
		styles = new ArrayList<Definition>();
	}
	
	
	
	
	public String getLegendPosition() {
		return legendPosition;
	}
	public void setLegendPosition(String legendPosition) {
		this.legendPosition = legendPosition;
	}	
	
	
	public int getExportEnabled() {
		return exportEnabled;
	}
	public void setExportEnabled(int exportEnabled) {
		this.exportEnabled = exportEnabled;
	}
	
	
	public int getExportAtCliente() {
		return exportAtCliente;
	}
	public void setExportAtCliente(int exportAtCliente) {
		this.exportAtCliente = exportAtCliente;
	}
	
	
	public String getExportHandler() {
		return exportHandler;
	}
	public void setExportHandler(String exportHandler) {
		this.exportHandler = exportHandler;
	}
	
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	
	public String getxAxisName() {
		return xAxisName;
	}
	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}
	
	
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	
	
	public int getShowBorder() {
		return showBorder;
	}
	public void setShowBorder(int showBorder) {
		this.showBorder = showBorder;
	}
	
	
	public int getCanvasBorderThickness() {
		return canvasBorderThickness;
	}
	public void setCanvasBorderThickness(int canvasBorderThickness) {
		this.canvasBorderThickness = canvasBorderThickness;
	}
	
	
	public int getShowPlotBorder() {
		return showPlotBorder;
	}
	public void setShowPlotBorder(int showPlotBorder) {
		this.showPlotBorder = showPlotBorder;
	}
	
	
	public int getUseRoundEdges() {
		return useRoundEdges;
	}
	public void setUseRoundEdges(int useRoundEdges) {
		this.useRoundEdges = useRoundEdges;
	}


	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	public List<SetProjects> getDataSet() {
		return dataSet;
	}
	public void setDataSet(List<SetProjects> dataSet) {
		this.dataSet = dataSet;
	}

	
	public List<Definition> getStyles() {
		return styles;
	}
	public void setStyle(List<Definition> styles) {
		this.styles = styles;
	}	
	
	
	
}
