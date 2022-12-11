package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class PurchaseReports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private int id;
	
	@Column(name = "purchase_by", nullable = false)
	private String purchaseBy;
	
	@Column(name = "purchase_category", nullable = false)
	private String category;
	
	@Column(name = "purchase_date", nullable = false)
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchaseBy() {
		return purchaseBy;
	}

	public void setPurchaseBy(String purchaseBy) {
		this.purchaseBy = purchaseBy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
