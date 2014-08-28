package com.nextel.dashboard.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.context.support.ServletContextResource;

import com.nextel.dashboard.bean.Category;
import com.nextel.dashboard.bean.Cell;
import com.nextel.dashboard.bean.Chart;
import com.nextel.dashboard.bean.Definition;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.Row;
import com.nextel.dashboard.bean.Rows;
import com.nextel.dashboard.bean.SetProjects;
import com.nextel.dashboard.bean.SetType;
import com.nextel.dashboard.bean.Style;

public class XMLGeneratorImpl {
	
	@Autowired
	ServletContext servletContext;

	public Chart generateCharts(List obj){
		
		//Class<?> clazz = Class.forName(className);
		//System.out.println("Metodos " + clazz.getMethods());
		//clazz.getMethod("setProjectName", parameterTypes);
		
		String xmlToString = null;
		
		
		List<String> listOfMonths = new ArrayList<String>();
		listOfMonths.add("Jan");
		listOfMonths.add("Feb");
		listOfMonths.add("Mar");
		listOfMonths.add("Apr");
		listOfMonths.add("May");
		listOfMonths.add("Jun");
		listOfMonths.add("Jul");
		listOfMonths.add("Aug");
		listOfMonths.add("Sep");
		listOfMonths.add("Oct");
		listOfMonths.add("Nov");
		listOfMonths.add("Dec");
		
		Chart chart = new Chart();
		chart.setLegendPosition("RIGHT");
		chart.setExportEnabled(1);
		chart.setExportAtCliente(1);
		chart.setExportHandler("fcExporter1");
		chart.setCaption("Monthly Target");
		chart.setxAxisName("Month");
		chart.setBgColor("ffffff");
		chart.setShowBorder(0);
		chart.setCanvasBorderThickness(1);
		chart.setShowPlotBorder(1);
		chart.setUseRoundEdges(0);
		
		for(int i=0; i<listOfMonths.size(); i++){
			Category category = new Category();
			category.setLabel(listOfMonths.get(i));
			chart.getCategories().add(category);
		}
		
		
		//DATASET
		SetProjects set = new SetProjects();
		set.setSeriesName("BL");
		SetType setType = new SetType();
		setType.setValue(9);
		set.getSet().add(setType);
		chart.getDataSet().add(set);
		
		
		SetProjects set2 = new SetProjects();
		set2.setSeriesName("FC");
		SetType setType2 = new SetType();
		setType2.setValue(5);
		set2.getSet().add(setType2);
		chart.getDataSet().add(set2);
		
		SetProjects set3 = new SetProjects();
		set3.setSeriesName("ACT");
		SetType setType3 = new SetType();
		setType3.setValue(7);
		set3.getSet().add(setType3);
		chart.getDataSet().add(set3);
		
		//STYLES
		Definition def = new Definition();
		Style style = new Style();
		style.setName("myValuesFont");
		style.setType("font");
		style.setSize(2);
		style.setFont("Verdana");
		def.getStyle().add(style);
		chart.getStyles().add(def);
				
		try{
			//File file = new File("C:\\Users\\rafaelmp\\workspace\\PMODashboard\\WebContent\\resources\\Data\\pruebas.xml");
			File file = new File("C:\\Users\\rafaelmp\\pruebas.xml");
			
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Chart.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			//Salida bien formada
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(chart, file);
			//jaxbMarshaller.marshal(chart, System.out);
			
			//Pass the XML to String
			jaxbMarshaller.marshal(chart, sw);
			xmlToString = sw.toString();
			
			System.out.println(xmlToString);
			
		} catch(JAXBException e){
			e.printStackTrace();
		}
		
		return chart;
	}
	
	
	/*
	 * 
	 * */
	public String generateTableProject(List<ProjectBean> list){
		Rows rows = new Rows();
		String xmlToString = null;
		
		try{
			for(int i=0; i<list.size(); i++){
				Row row = new Row();
				row.setId(i);
				Cell cell = new Cell();
				cell.setCell(list.get(i).getStatus());
				Cell cell1 = new Cell();
				cell1.setCell("algo");
				Cell cell2 = new Cell();
				cell2.setCell(list.get(i).getTotProject().toString());
				Cell cell3 = new Cell();
				cell3.setCell(list.get(i).getPercentage().toString());
				Cell cell4 = new Cell();
				cell4.setCell(list.get(i).getTotProject().toString());
				Cell cell5 = new Cell();
				cell5.setCell(list.get(i).getPercentage().toString());
				
				row.getCell().add(cell);
				row.getCell().add(cell1);
				row.getCell().add(cell2);
				row.getCell().add(cell3);
				row.getCell().add(cell4);
				row.getCell().add(cell5);
				
				rows.getRow().add(row);
			}			
			
			File file = new File("C:\\Users\\rmorales\\workspace\\PMODashboard\\src\\main\\webapp\\resources\\Data\\tableProject.xml");
			StringWriter sw = new StringWriter();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Rows.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			//Salida bien formada
			//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			//jaxbMarshaller.marshal(rows, file);
			//jaxbMarshaller.marshal(rows, System.out);
			jaxbMarshaller.marshal(rows, sw);
			
			xmlToString = sw.toString();
			
		} catch(JAXBException e){
			e.printStackTrace();
		}
		return xmlToString;
	}
	
	
	//num proyectos date endproyFC caen en enero
}
