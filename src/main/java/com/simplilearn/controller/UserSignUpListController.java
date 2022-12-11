package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.entity.AdminLogin;
import com.simplilearn.entity.UserSignUpList;
import com.simplilearn.service.AdminLoginService;
import com.simplilearn.service.UserSignUpListService;

@Controller
public class UserSignUpListController {
	
	@Autowired
	UserSignUpListService userSignUpListService;
	@Autowired
	AdminLoginService adminLoginService;
	
	// 1. Handle the Request
	@RequestMapping(value = "/userSignUp", method = RequestMethod.GET)
	public String userSignUp(Model model) {
		
		// 2. do Business Logic by invoking service
		List<UserSignUpList> usul = userSignUpListService.getUserSignUp();
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("usul", usul);
		model.addAttribute("aLogin", aLogin);
		
		// 4. Invoke View (return view)
		return "userSignUp";
	}

}
