package com.simplilearn.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.AdminLogin;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Integer> {
	
	@Query(value = "select * from admin", nativeQuery = true)
	public List<AdminLogin> getAdmin();
	
//	@Modifying
//	@Query(value = "update admin u set u.admin_pass = :newPassword where u.admin_pass = :oldPassword", nativeQuery = true)
//	public List<AdminLogin> getUpdate(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);
	
	//@Transactional
	//@Modifying
	//@Query("update AdminLogin set password = :newPassword where password = :oldPassword")
	//public List<AdminLogin> getUpdate(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);
}
