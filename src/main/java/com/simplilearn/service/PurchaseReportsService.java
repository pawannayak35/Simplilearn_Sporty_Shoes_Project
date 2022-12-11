package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.PurchaseReports;
import com.simplilearn.repository.PurchaseReportsRepository;

@Service
public class PurchaseReportsService {

	@Autowired
	PurchaseReportsRepository purchaseReportsRepository;
	
	public List<PurchaseReports> getPurchaseReport() {
		return purchaseReportsRepository.getPurchase();
	}
	
	public List<PurchaseReports> getPurchaseReportByCategoryAndDate (String category, String pDateNew) {
		return purchaseReportsRepository.getPurchaseReportByCategoryAndDate(category, pDateNew);
	}
}
