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
		name = "users",
		schema = "ecommerce",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "UC_user_email",
						columnNames = "user_email"
				)
		}
)
public class UserSignUpList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int uid;
	
	@Column(name = "user_name", nullable = false)
	private String username;
	
	@Column(name = "user_email", nullable = false)
	private String email;
	
	@Column(name = "user_mob", nullable = false)
	private String mob;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}
}
