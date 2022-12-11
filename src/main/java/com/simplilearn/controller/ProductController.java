package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.AdminLogin;
import com.simplilearn.entity.Products;
import com.simplilearn.service.AdminLoginService;
import com.simplilearn.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	AdminLoginService adminLoginService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.GET)
	public String adminLogin() {
		return "adminLogin";
	}
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "adminDashboard";
	}
	
	// 1. Handle the Request
	@RequestMapping(value="/adminDashboard", method = RequestMethod.POST) 
	public String adminDash(Model model, @RequestParam("uname") String uName, @RequestParam("upass") String uPass) {
		
		// 2. do Business Logic by invoking service
		List<Products> pro = productService.getProduct();
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("uName", uName);
		model.addAttribute("uPass", uPass);
		model.addAttribute("productsData", pro);
		model.addAttribute("aLogin", aLogin);
		
		
		// 4. Invoke View (return view)
		return "adminDashboard";
	}
	
	// 1. Handle the Request
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model, @ModelAttribute Products product) {
			
		// 2. do Business Logic by invoking service
		productService.insertProducts(product);
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
			
		// 3. Populate Model
		model.addAttribute("aLogin", aLogin);	
			
		// 4. Invoke View (return view)
		return "addProduct";
	}
	
	// 1. Handle the Request
	@RequestMapping(value="/updateProduct", method = RequestMethod.GET)
	public String updateProduct(Model model, @RequestParam("pid") int pid, @ModelAttribute Products product) {
			
		// 2. do Business Logic by invoking service
		product.setPid(pid);
		productService.updateProduct(product);
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("aLogin", aLogin);	
			
		// 4. Invoke View (return view)
		return "updateProduct";
	}
	
	@RequestMapping(value="/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(Model model, @RequestParam("pid") int pid) {
			
		// 2. do Business Logic by invoking service
		productService.deleteProduct(pid);
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("aLogin", aLogin);	
			
		// 4. Invoke View (return view)
		return "deleteProduct";
	}
	
	
}
