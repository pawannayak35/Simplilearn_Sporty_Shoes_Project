package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.UserSignUpList;

@Repository
public interface UserSignUpListRepository extends JpaRepository<UserSignUpList, Integer> {

	@Query(value = "select * from users", nativeQuery = true)
	public List<UserSignUpList> getUsers();
}
