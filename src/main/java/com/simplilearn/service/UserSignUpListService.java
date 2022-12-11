package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.UserSignUpList;
import com.simplilearn.repository.UserSignUpListRepository;

@Service
public class UserSignUpListService {

	@Autowired
	UserSignUpListRepository userSignUpListRepository;
	
	public List<UserSignUpList> getUserSignUp() {
		return userSignUpListRepository.getUsers();
	}
}
