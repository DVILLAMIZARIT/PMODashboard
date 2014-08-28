package com.nextel.dashboard.util;

import java.io.File;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nextel.dashboard.bean.Category;
import com.nextel.dashboard.bean.Cell;
import com.nextel.dashboard.bean.Chart;
import com.nextel.dashboard.bean.DataSet;
import com.nextel.dashboard.bean.ProjectBean;
import com.nextel.dashboard.bean.Row;
import com.nextel.dashboard.bean.Rows;
import com.nextel.dashboard.bean.SetProjects;
import com.nextel.dashboard.bean.TimelineBean;

public class JSONGeneratorImpl {
	
	
	/*
	 * 
	 * */
	public String generateDataChartAccumulated(List<ProjectBean> projects){
		String 	jsonToString = null;
		int contBL = 1;
		int contFC = 1;
		int contACT = 1;
		
		try{
			StringBuilder convertir = new StringBuilder("{\"chart\": {");
   			convertir.append("\"legendPosition\":\"RIGHT\","); 
			convertir.append("\"exportEnabled\":\"1\","); 
			convertir.append("\"exportAtClient\":\"1\","); 
			convertir.append("\"exportHandler\":\"fcExporter1\","); 
			convertir.append("\"caption\":\"Accumulated\","); 
			convertir.append("\"xAxisName\":\"Month\","); 
			convertir.append("\"bgColor\":\"ffffff\","); 
			convertir.append("\"showBorder\":\"0\","); 
			convertir.append("\"canvasBorderThickness\":\"1\",");
			convertir.append("\"showPlotBorder\":\"1\","); 
			convertir.append("\"useRoundEdges\":\"0\""); 
   			convertir.append("},");
   			convertir.append("\"categories\": [");
      		convertir.append("{\"category\": [");
            convertir.append("{\"label\": \"Jan\"},");
            convertir.append("{\"label\": \"Feb\"},");
            convertir.append("{\"label\": \"Mar\"},");
            convertir.append("{\"label\": \"Apr\"},");
            convertir.append("{\"label\": \"May\"},");
            convertir.append("{\"label\": \"Jun\"},");
            convertir.append("{\"label\": \"Jul\"},");
            convertir.append("{\"label\": \"Aug\"},");
            convertir.append("{\"label\": \"Sep\"},");
            convertir.append("{\"label\": \"Oct\"},");
            convertir.append("{\"label\": \"Nov\"},");
            convertir.append("{\"label\": \"Dec\"}");
         	convertir.append("]}");
   			convertir.append("],");
   			convertir.append("\"dataset\": [{");
   			
   			convertir.append("\"seriesName\": \"BL\",");
         	convertir.append("\"data\": [");
   			List<Integer> bl = projects.get(0).getListAccumulatedEndBL();
			for(Integer a : bl){
				
				convertir.append("{\"value\":\"" + a + "\"},");
				
				if(contBL == 12){
					convertir.append("{\"value\":\"" + a + "\"}");
				}
				contBL++;
			}
			convertir.append("]},");
         	
      		convertir.append("{");
         	convertir.append("\"seriesName\": \"FC\",");
         	convertir.append("\"data\": [");
         	List<Integer> fc = projects.get(0).getListAccumulatedEndFC();
			for(Integer a : fc){
				
				convertir.append("{\"value\":\"" + a + "\"},");
				
				if(contFC == 12){
					convertir.append("{\"value\":\"" + a + "\"}");
				}
				contFC++;
			}
			convertir.append("]},");

         	
			convertir.append("{");
         	convertir.append("\"seriesName\": \"ACT\",");
         	convertir.append("\"data\": [");
         	List<Integer> act = projects.get(0).getListAccumulatedEndACT();
			for(Integer a : act){
				
				if(a == 0){
					a = null;
				}
				
				convertir.append("{\"value\":\"" + a + "\"},");
				
				if(contACT == 12){
					convertir.append("{\"value\":\"" + a + "\"}");
				}
				contACT++;
			}
         	convertir.append("]}");
   			convertir.append("]}");
			
			jsonToString = convertir.toString();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		return jsonToString;
	}
	
	
	
	
	/*
	 * 
	 * */
	public String generateDataChartMonthly(List<ProjectBean> projects){
		String 	jsonToString = null;
		int contBL = 1;
		int contFC = 1;
		int contACT = 1;
		
		try{
			StringBuilder convertir = new StringBuilder("{\"chart\": {");
   			convertir.append("\"legendPosition\":\"RIGHT\","); 
			convertir.append("\"exportEnabled\":\"1\","); 
			convertir.append("\"exportAtClient\":\"1\","); 
			convertir.append("\"exportHandler\":\"fcExporter1\","); 
			convertir.append("\"caption\":\"Monthly Target\","); 
			convertir.append("\"xAxisName\":\"Month\","); 
			convertir.append("\"bgColor\":\"ffffff\","); 
			convertir.append("\"showBorder\":\"0\","); 
			convertir.append("\"canvasBorderThickness\":\"1\",");
			convertir.append("\"showPlotBorder\":\"1\","); 
			convertir.append("\"useRoundEdges\":\"0\""); 
   			convertir.append("},");
   			convertir.append("\"categories\": [");
      		convertir.append("{\"category\": [");
            convertir.append("{\"label\": \"Jan\"},");
            convertir.append("{\"label\": \"Feb\"},");
            convertir.append("{\"label\": \"Mar\"},");
            convertir.append("{\"label\": \"Apr\"},");
            convertir.append("{\"label\": \"May\"},");
            convertir.append("{\"label\": \"Jun\"},");
            convertir.append("{\"label\": \"Jul\"},");
            convertir.append("{\"label\": \"Aug\"},");
            convertir.append("{\"label\": \"Sep\"},");
            convertir.append("{\"label\": \"Oct\"},");
            convertir.append("{\"label\": \"Nov\"},");
            convertir.append("{\"label\": \"Dec\"}");
         	convertir.append("]}");
   			convertir.append("],");
   			convertir.append("\"dataset\": [{");
   			
   			convertir.append("\"seriesName\": \"BL\",");
   			//convertir.append("\"renderAs\": \"area\",");
         	convertir.append("\"data\": [");
   			List<Integer> bl = projects.get(0).getListEndBL();
			for(Integer a : bl){
				
				convertir.append("{\"value\":\"" + a + "\"},");
				
				if(contBL == 12){
					convertir.append("{\"value\":\"" + a + "\"}");
				}
				contBL++;
			}
			convertir.append("]},");
         	
      		convertir.append("{");
         	convertir.append("\"seriesName\": \"FC\",");
         	//convertir.append("\"renderAs\": \"area\",");
         	//convertir.append("\"renderAs\": \"line\",");
         	convertir.append("\"data\": [");
         	List<Integer> fc = projects.get(0).getListEndFC();
			for(Integer a : fc){
				
				convertir.append("{\"value\":\"" + a + "\"},");
				
				if(contFC == 12){
					convertir.append("{\"value\":\"" + a + "\"}");
				}
				contFC++;
			}
			convertir.append("]},");

         	
			convertir.append("{");
         	convertir.append("\"seriesName\": \"ACT\",");
         	//convertir.append("\"renderAs\": \"area\",");
         	convertir.append("\"data\": [");
         	List<Integer> act = projects.get(0).getListEndACT();
			for(Integer a : act){
				
				convertir.append("{\"value\":\"" + a + "\"},");
				
				if(contACT == 12){
					convertir.append("{\"value\":\"" + a + "\"}");
				}
				contACT++;
			}
         	convertir.append("]}");
   			convertir.append("]}");
			
			jsonToString = convertir.toString();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		return jsonToString;
	}
	
	
	
	
	
	/*
	 * 
	 * */
	public String generateTimeline(List<TimelineBean> projects){
		String 	jsonToString = null;
		int contLabel = 1;
		int contGroupsTasks = 1;
		int contMilestones = 1;
		
		int totLabels = 0;
		int totMilestones = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		String dateTradeLine = sdf.format(new Date(calendar.getTimeInMillis()));

		
		try{
   			//Get total of lables
   			for(TimelineBean a : projects){
   				if(a.getType().equals("Group") || a.getType().equals("Task")){
   					totLabels++;
   				}	
   				
   				if(a.getType().equals("Milestone")){
   					totMilestones++;
   				}
   			}
   			
   			
   			System.out.println("LABELS " + totLabels);
   			System.out.println("MILES " + totMilestones);
			
   			
   			//Build the timeline with data from DB
			StringBuilder convertir = new StringBuilder("{\"chart\": {");
   			convertir.append("\"dateFormat\":\"mm/dd/yyyy\","); 
   			convertir.append("\"slackfillcolor\":\"00CCFF\",");
			//convertir.append("\"showSlackAsFill\":\"0\","); 
			convertir.append("\"exportEnabled\":\"1\","); 
			convertir.append("\"exportAtClient\":\"1\","); 
			convertir.append("\"exportHandler\":\"fcExporter1\","); 
			convertir.append("\"showtasklabels\":\"1\"");
   			convertir.append("},");
   			
   			convertir.append("\"categories\": [");
      		convertir.append("{\"category\": [");
            convertir.append("{\"start\": \"01/01/2014\",\"end\": \"04/01/2014\", \"label\": \"Q1\"},");
            convertir.append("{\"start\": \"04/01/2014\",\"end\": \"07/01/2014\", \"label\": \"Q2\"},");
            convertir.append("{\"start\": \"07/01/2014\",\"end\": \"10/01/2014\", \"label\": \"Q3\"},");
            convertir.append("{\"start\": \"10/01/2014\",\"end\": \"12/01/2014\", \"label\": \"Q4\"}");
         	convertir.append("]},");
         	convertir.append("{\"category\": [");	
            convertir.append("{\"start\": \"01/01/2014\",\"end\": \"02/01/2014\", \"label\": \"Jan\"},");
            convertir.append("{\"start\": \"02/01/2014\",\"end\": \"03/01/2014\", \"label\": \"Feb\"},");
            convertir.append("{\"start\": \"03/01/2014\",\"end\": \"04/01/2014\", \"label\": \"Mar\"},");
            convertir.append("{\"start\": \"04/01/2014\",\"end\": \"05/01/2014\", \"label\": \"Apr\"},");
            convertir.append("{\"start\": \"05/01/2014\",\"end\": \"06/01/2014\", \"label\": \"May\"},");
            convertir.append("{\"start\": \"06/01/2014\",\"end\": \"07/01/2014\", \"label\": \"Jun\"},");
            convertir.append("{\"start\": \"07/01/2014\",\"end\": \"08/01/2014\", \"label\": \"Jul\"},");
            convertir.append("{\"start\": \"08/01/2014\",\"end\": \"09/01/2014\", \"label\": \"Aug\"},");
            convertir.append("{\"start\": \"09/01/2014\",\"end\": \"10/01/2014\", \"label\": \"Sep\"},");
            convertir.append("{\"start\": \"10/01/2014\",\"end\": \"11/01/2014\", \"label\": \"Oct\"},");
            convertir.append("{\"start\": \"11/01/2014\",\"end\": \"12/01/2014\", \"label\": \"Nov\"},");
            convertir.append("{\"start\": \"12/01/2014\",\"end\": \"12/31/2014\", \"label\": \"Dec\"}");
            convertir.append("]}");
   			convertir.append("],");
   			
   			convertir.append("\"processes\":{");
   			convertir.append("\"fontsize\": \"10\",");
   			convertir.append("\"isbold\": \"1\",");
   			convertir.append("\"align\": \"left\",");
   			convertir.append("\"process\": [");
   			
   			
   			for(TimelineBean a : projects){
   				if(a.getType().equals("Group") || a.getType().equals("Task")){
   					if(contLabel < totLabels){
   						convertir.append("{\"label\": \"" + a.getDescription() + "\"},");
   					}
   					
   					if(contLabel == totLabels){
   						convertir.append("{\"label\": \"" + a.getDescription() + "\"}");
   					}
   					contLabel++;
   				}	
   			}
   			convertir.append("]},");

   			
   			

   			convertir.append("\"tasks\":{");
   			convertir.append("\"hoverFillColor\": \"F4BEFF\",\"hoverFillAlpha\": \"30\",\"slackHoverFillColor\": \"CEFF1F\",\"slackHoverFillAlpha\": \"80\",");
   			convertir.append("\"task\":[");
   			for(TimelineBean a : projects){
   				if(a.getType().equals("Group")){
   					if(contGroupsTasks < totLabels){
   						//convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"percentComplete\": \""+ a.getAdvance() +"\", \"slackHoverFillColor\":\"" + a.getTaskColor() + "\", \"showAsGroup\": \"1\", \"id\": \"" + a.getIdTarea() + "\"},");
   						convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"showAsGroup\": \"1\", \"id\": \"" + a.getIdTarea() + "\"},");

   					}
   					
   					if(contGroupsTasks == totLabels){
   						//convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"percentComplete\": \"" + a.getAdvance() +"\", \"slackHoverFillColor\":\"" + a.getTaskColor() + "\", \"showAsGroup\": \"1\", \"id\": \"" + a.getIdTarea() + "\"}");
   						convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"showAsGroup\": \"1\", \"id\": \"" + a.getIdTarea() + "\"}");

   					}
   					
   					contGroupsTasks++;
   				}	
   				if(a.getType().equals("Task")){
   					if(contGroupsTasks < totLabels){
   						//convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"percentComplete\": \"" + a.getAdvance() + "\", \"slackHoverFillColor\":\"" + a.getTaskColor() + "\", \"id\": \"" + a.getIdTarea() + "\"},");
   						convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"percentComplete\": \"" + a.getAdvance() + "\", \"id\": \"" + a.getIdTarea() + "\"},");
   					}
   					
   					if(contGroupsTasks == totLabels){
   						//convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"percentComplete\": \"" + a.getAdvance() +  "\",\"slackHoverFillColor\":\"" + a.getTaskColor() + "\", \"id\": \"" + a.getIdTarea() + "\"}");
   						convertir.append("{\"start\": \"" + a.getStartFC() + "\", \"end\": \"" + a.getEndFC() + "\", \"percentComplete\": \"" + a.getAdvance() +  "\", \"id\": \"" + a.getIdTarea() + "\"}");

   					}
   					
   					contGroupsTasks++;
   				}	
   			}
   			convertir.append("]},");
   			

   			convertir.append("\"milestones\":{");
   			convertir.append("\"milestone\":[");
   			for(TimelineBean a : projects){
   				if(a.getType().equals("Milestone")){
   					
   					if(contMilestones < totMilestones){
   						convertir.append("{\"date\": \"" + a.getEndFC() + "\",\"taskid\": \"" + a.getPredecesor() + "\", \"toolText\":\"" + a.getDescription() + "\", " + "\"radius\": \"7\", \"shape\":\"polygon\", \"color\":\"08497C\", \"borderColor\":\"000000\", \"borderThickness\":\"1\"},");
   					}
   						
   					if(contMilestones == totMilestones){
   						convertir.append("{\"date\": \"" + a.getEndFC() + "\",\"taskid\": \"" + a.getPredecesor() + "\", \"toolText\":\"" + a.getDescription() + "\", \"radius\": \"7\", \"shape\":\"polygon\", \"color\":\"08497C\", \"borderColor\":\"000000\", \"borderThickness\":\"1\"}");
   					}
   					
   					contMilestones++;
   				}
   			}
   			convertir.append("]},");
   			
   			convertir.append("\"trendlines\":[{");
   			convertir.append("\"line\":[");
   			convertir.append("{\"start\": \""+ dateTradeLine +"\",\"displayValue\": \"Today\", \"color\":\"333333\", \"thickness\":\"2\", \"dashed\":\"1\"}");
   			convertir.append("]}]}");
   			
   			//Translate to String
   			jsonToString = convertir.toString();

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonToString;
	}	
}
