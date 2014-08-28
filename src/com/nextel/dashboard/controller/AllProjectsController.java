package com.nextel.dashboard.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextel.dashboard.bean.AllProjectsBean;
import com.nextel.dashboard.bean.AccomplishmentsBean;
import com.nextel.dashboard.bean.MilestoneBean;
import com.nextel.dashboard.bean.NextStepsBean;
import com.nextel.dashboard.bean.OnRiskProjectsBean;
import com.nextel.dashboard.bean.TopProjectsBean;
import com.nextel.dashboard.service.AllProjectsService;
import com.nextel.dashboard.service.OnRiskProjectsService;
import com.nextel.dashboard.util.ExcelGeneratorImpl;

@Controller
public class AllProjectsController {
	
	@Autowired
	AllProjectsService allProjectsService;
	
	@Autowired
	OnRiskProjectsService onRiskProjectsService;


	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allProjects(HttpServletRequest request) {

		List<AllProjectsBean> listAllProjects = allProjectsService.getAllProjects();
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listAllProjects);
		model.setViewName("allProjects");

		return model;

	}
	
	@RequestMapping(value = "/individual", method = RequestMethod.GET)
	public ModelAndView individualProject(@RequestParam(value = "idAuth", required = false) String idAuth, 
										  @RequestParam(value = "projectName", required = false) String projectName, 
										  HttpServletRequest request) {
		
		
		System.out.println("NOM projecto " + projectName);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		
		List<AccomplishmentsBean> listAccomplishments = allProjectsService.getAccomplishments(idAuth);
		List<NextStepsBean> listNextSteps = allProjectsService.getNextSteps(idAuth);
		List<OnRiskProjectsBean> listOnRiskIndividualProject = onRiskProjectsService.getIndividualOnRiskProject(idAuth);
		List<MilestoneBean> listMilestone = allProjectsService.getMilestones(idAuth);
		
		ModelAndView model = new ModelAndView();
		model.addObject("idAuthProject", idAuth);
		model.addObject("nameProjectHead", projectName);
		model.addObject("datosA", listAccomplishments);
		model.addObject("datosN", listNextSteps);
		model.addObject("datosO", listOnRiskIndividualProject);
		model.addObject("datosM", listMilestone);
		model.setViewName("individualProject");

		return model;

	}
	
	
	
	@RequestMapping(value = "/searchProject", method = RequestMethod.GET)
	public ModelAndView searchProject(@RequestParam(value = "searchingProject", required = false) String projectName, HttpServletRequest request) {
		
		List<AllProjectsBean> listAllProjects = allProjectsService.searchProject(projectName);
		
		ModelAndView model = new ModelAndView();
		
		if(listAllProjects.size() > 0){
		
			if(listAllProjects.get(0).isAllProjects()){
				model.addObject("datos", listAllProjects);
				model.setViewName("allProjects");
			}	
			else if(listAllProjects.get(0).isIndividualProject()){
				model = individualProject(listAllProjects.get(0).getIdAuth(), listAllProjects.get(0).getProjectName() ,request);
				
				model.setViewName("individualProject");
			}
			else if(listAllProjects.get(0).isNoProject()){
				model.addObject("datos", listAllProjects);
				model.setViewName("allProjects");
			}
		}
		else{
			model.setViewName("allProjects");
		}
		
		return model;

	}
	
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + "AllProjectsExcel.xlsx");
		
		List<AllProjectsBean> listAllProjects = allProjectsService.getAllProjects();
		
		//Generate the Excel File
		ExcelGeneratorImpl excelGenerator = new ExcelGeneratorImpl();
		XSSFWorkbook workbook = excelGenerator.createExcelFile(listAllProjects);
		
		try {
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping(value = "/allProjectsFilter", method = RequestMethod.GET)
	public ModelAndView allProjectsFilter(@RequestParam(value = "filterPM", required = false) String filterPM, 
			                            HttpServletRequest request) {
		
		List<AllProjectsBean> listAllProjects = null;
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "none");
		
		if(filterPM.equals("ALL")){
			listAllProjects = allProjectsService.getAllProjects();
		}
		else{
			listAllProjects = allProjectsService.getAllProjectsFilterByPM(filterPM);
		}
		
		ModelAndView model = new ModelAndView();
		model.addObject("datos", listAllProjects);
		model.addObject("pmSelected", filterPM);
		model.setViewName("allProjects");

		return model;

	}

}