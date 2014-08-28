package com.nextel.dashboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextel.dashboard.bean.UsersBean;
import com.nextel.dashboard.service.AdminUsersService;

@Controller
public class AdminUsersController {
	
	@Autowired
	AdminUsersService adminUsersService;
	
	

	
	/*
	 * 
	 * */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUser(@RequestParam(value = "username", required = false) String username,
										@RequestParam(value = "password", required = false) String password,
										@RequestParam(value = "role", required = false) String role,
								  		HttpServletRequest request) {
		
		
		int user_role_id = adminUsersService.getLastIdUserRole();
		
		UsersBean ub = new UsersBean();
		ub.setUser_role_id(user_role_id);
		ub.setUsername(username);
		ub.setPassword(password);
		ub.setRole(role);
	
		
		//Create Project Manager
		boolean userCreated = adminUsersService.createUser(ub);
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		ModelAndView model = new ModelAndView();
		model.addObject("username", username);
		model.addObject("createUserSelected", true);
		model.addObject("userCreated", userCreated);
		model.setViewName("admin/admin");

		return model;
	}
	
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getUserModify", method = RequestMethod.GET)
	public ModelAndView getUserModify(@RequestParam(value = "username", required = false) String username,
									  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		UsersBean ub = new UsersBean();
		ub.setUsername(username);
		
		List<UsersBean> listDataUser = adminUsersService.getUserData(username);
		
		ModelAndView model = new ModelAndView();
		model.addObject("username", username);
		model.addObject("listUsers", session.getAttribute("listUsers"));
		model.addObject("datos", listDataUser);		
		model.addObject("modifyUserSelected", true);
		model.addObject("userSelected", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam(value = "username", required = false) String username,
								   @RequestParam(value = "password", required = false) String password,
								   @RequestParam(value = "role", required = false) String role,
								   HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		
		UsersBean ub = new UsersBean();
		ub.setUsername(username);
		ub.setPassword(password);
		ub.setRole(role);
		
		boolean userupdated = adminUsersService.updateUser(ub);
		
		ModelAndView model = new ModelAndView();
		model.addObject("userupdated", userupdated);
		model.addObject("username", username);
		model.addObject("modifyUserSelected", true);
		model.addObject("userForModifySelected", true);
		model.addObject("userDescSelected", true);
		model.setViewName("admin/admin");

		return model;
	}	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/getUserDelete", method = RequestMethod.GET)
	public ModelAndView getUserDelete(@RequestParam(value = "username", required = false) String username,
											  HttpServletRequest request) {

		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		List<UsersBean> listDataUser = adminUsersService.getUserData(username);
		
		ModelAndView model = new ModelAndView();
		model.addObject("username", username);
		model.addObject("listUsers", session.getAttribute("listUsers"));
		model.addObject("datos", listDataUser);		
		model.addObject("deleteUserSelected", true);
		model.addObject("userDescSelectedDel", true);
		model.setViewName("admin/admin");

		return model;

	}
	
	
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam(value = "username", required = false) String username,
								   		HttpServletRequest request) {
		
		//Set the session to save the image of the header.jsp
		HttpSession session = request.getSession();
		session.setAttribute("headerImg", "formulario");
		
		System.out.println("PA BORRAR username " + username );
		
		boolean userDeleted = adminUsersService.deleteUser(username);
		
		ModelAndView model = new ModelAndView();
		model.addObject("userDeleted", userDeleted);
		model.addObject("username",username);
		model.setViewName("admin/admin");

		return model;

	}
}