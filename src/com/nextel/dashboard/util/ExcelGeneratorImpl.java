package com.nextel.dashboard.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nextel.dashboard.bean.AllProjectsBean;

public class ExcelGeneratorImpl {

	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	SheetConditionalFormatting sheetFC = null;
	
	
	public XSSFWorkbook createExcelFile(List<AllProjectsBean> listAllProjects){
		//Create the Excel file data
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("All Projects");
		
		Map<Integer, Object[]> excelData = new TreeMap<Integer, Object[]>();
		
		Integer id = null;
		String project = null;
		String status = null;
		String pm = null;
		String dueDateBL = null;
		String dueDateFC = null;
		String dueDateACT = null;
		
		//First the column names and apply Bold font
		Header firstHeader = sheet.getFirstHeader();
		firstHeader.setCenter("&B");
		sheet.createRow(1).createCell(0).setCellValue("Project");
				
		excelData.put(0,new Object[]{"Project","Status","PM","DueDate BL","DueDate FC","DueDate ACT"});
		
		for(int a=0; a<listAllProjects.size(); a++){
			id = listAllProjects.get(a).getNumberId();
			project = listAllProjects.get(a).getProjectName();
			status = listAllProjects.get(a).getStatus();
			pm = listAllProjects.get(a).getPmName();
			dueDateBL = listAllProjects.get(a).getEndBL();
			dueDateFC = listAllProjects.get(a).getEndFC();
			dueDateACT = listAllProjects.get(a).getEndACT();
			
			excelData.put(id, new Object[]{project,status,pm,dueDateBL,dueDateFC,dueDateACT});
		}
		
		//Color alternate rows
		shadeRows();
		
		//Iterate over the data and write the Excel file
		Set<Integer> keyset = excelData.keySet();
		int rownum = 0;
		
		for(Integer key : keyset){
			Row row = sheet.createRow(rownum++);
			Object[] objArr = excelData.get(key);
			int cellnum = 0;
			
			for(Object obj : objArr){
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String){
					cell.setCellValue((String)obj);
				}
				else if(obj instanceof Integer){
					cell.setCellValue((Integer)obj);
				}
			}
		}
		
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		
		try{
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\rafaelmp\\AllProjectsExcel.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("ARCHIVO EXCEL ESCRITO CORRECTAMENTE");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return workbook;
	}
	
	
	/*
	 * 
	 * */
	private void shadeRows(){
		sheetFC = sheet.getSheetConditionalFormatting();
		
		ConditionalFormattingRule rule = sheetFC.createConditionalFormattingRule("MOD(ROW(),2)");
		PatternFormatting fill = rule.createPatternFormatting();
		fill.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.index);
		fill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		
		CellRangeAddress[] regions = {CellRangeAddress.valueOf("A1:Z200")};
		sheetFC.addConditionalFormatting(regions, rule);
	}
	
}
