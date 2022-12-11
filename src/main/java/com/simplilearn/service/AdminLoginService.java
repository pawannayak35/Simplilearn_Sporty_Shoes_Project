package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.AdminLogin;
import com.simplilearn.repository.AdminLoginRepository;

@Service
public class AdminLoginService {

	@Autowired
	AdminLoginRepository adminLoginRepository;
	
	public List<AdminLogin> getAdminLogin() {
		return adminLoginRepository.getAdmin();
	}
	
	public AdminLogin setNewPassword(AdminLogin adminlogin) {
		return adminLoginRepository.save(adminlogin);
		
	}
}
