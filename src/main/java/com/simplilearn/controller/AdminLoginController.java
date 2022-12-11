package com.simplilearn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.AdminLogin;
import com.simplilearn.service.AdminLoginService;

@Controller
public class AdminLoginController {
	
	@Autowired
	AdminLoginService adminLoginService;
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(Model model) {	
		
		// 2. do Business Logic by invoking service
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		model.addAttribute("aLogin", aLogin);
		
		return "changePassword";
	}
	
	// 1. Handle the Request
	@RequestMapping(value = "/adminUpdatePassword", method = RequestMethod.GET)
	public String adminUpdatePassword(Model model, @RequestParam("oldPassword") String oldPassword) {
		
		// 2. do Business Logic by invoking service
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("oldPassword", oldPassword);
		model.addAttribute("aLogin", aLogin);
		
		// 4. Invoke View (return view)
		return "updateNewPassword";
	}
	
	// 1. Handle the Request
	@RequestMapping(value = "/setNewPassword", method = RequestMethod.POST)
	public String setNewPassword(Model model, @RequestParam("aid") int aid, @ModelAttribute AdminLogin adminlogin) {
		
		// 2. do Business Logic by invoking service
		adminlogin.setAid(aid);
		adminLoginService.setNewPassword(adminlogin);
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("aLogin", aLogin);
		
		// 4. Invoke View (return view)
		return "setNewPassword";
	}
	
	

}
