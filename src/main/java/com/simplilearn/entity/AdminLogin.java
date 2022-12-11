package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "admin",
		schema = "ecommerce",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "UC_admin_user",
						columnNames = "admin_user"
				)
		}
)
public class AdminLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int aid;
	
	@Column(name = "admin_user", nullable = false)
	private String username;
	
	@Column(name = "admin_pass", nullable = false)
	private String password;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
