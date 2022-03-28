package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.AdminReposit;
import com.simplilearn.entity.Product;

@Service
public class AdminService {

	@Autowired
	AdminReposit arepo;

	public Admin addAdmin(Admin admin)
	{
		return arepo.save(admin);
	}
	
	public List<Admin> getAllAdmin() {
		return arepo.findAll();
	}
	
	public Admin updateAdmin(int aid, Admin admin)
	{
		Admin a=arepo.getById(aid);
		a.setApassword(admin.getApassword());
		arepo.save(a);
		return a;
	}
}