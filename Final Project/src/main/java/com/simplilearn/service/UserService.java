package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.User;
import com.simplilearn.entity.UserReposit;

@Service
public class UserService {

	@Autowired
	UserReposit urepo;
	
	public User addUser(User user)
	{
		return urepo.save(user);
	}
	
	public List<User> getAllUser()
	{
		return urepo.findAll();
	}
	
	public User getUserById(int uid)
	{
		return urepo.getById(uid);
	}
}