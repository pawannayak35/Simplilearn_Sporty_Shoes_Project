package com.simplilearn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.AdminLogin;
import com.simplilearn.entity.PurchaseReports;
import com.simplilearn.service.AdminLoginService;
import com.simplilearn.service.PurchaseReportsService;

@Controller
public class PurchaseReportsController {
	
	@Autowired
	PurchaseReportsService purchaseReportsService;
	@Autowired
	AdminLoginService adminLoginService;
	
	// 1. Handle the Request
	@RequestMapping(value = "/purchaseReport", method = RequestMethod.GET)
	public String purchaseReport(Model model) {
		
		// 2. do Business Logic by invoking service
		List<PurchaseReports> pr = purchaseReportsService.getPurchaseReport();
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("msg", "Purchase Report Details");
		model.addAttribute("pr", pr);
		model.addAttribute("aLogin", aLogin);
		
		// 4. Invoke View (return view)
		return "purchaseReport";
	}
	
	// 1. Handle the Request
	@RequestMapping(value = "/filterPurchaseReport", method = RequestMethod.GET)
	public String filterPurchaseReport(Model model, @RequestParam("category") String category, @RequestParam("date") String date) {
		
		SimpleDateFormat dateIn = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat dateOut = new SimpleDateFormat("dd-mm-yyyy");
		
		String pDateNew = null;
		try {
			Date nDate = dateIn.parse(date);
			pDateNew =  dateOut.format(nDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 2. do Business Logic by invoking service
		List<PurchaseReports> pr = purchaseReportsService.getPurchaseReportByCategoryAndDate(category, pDateNew);
		
		List<AdminLogin> aLogin = adminLoginService.getAdminLogin();
		
		// 3. Populate Model
		model.addAttribute("msg", "Purchase Reports filtered by Date and Category"); 
		model.addAttribute("pr", pr);
		model.addAttribute("aLogin", aLogin);
		
		// 4. Invoke View (return view)
		return "purchaseReport";
	}

}
