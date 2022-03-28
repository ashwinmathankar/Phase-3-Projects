package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Category;
import com.simplilearn.entity.CategoryReposit;

@Service
public class CategoryService {

	@Autowired
	CategoryReposit crepo;
	
	public Category addCategory(Category category)
	{
		return crepo.save(category);		
	}
	
	public List<String> getAllCategory()
	{
		return crepo.findCategory();
	}
	
	public List<String> CategoryByCid(int cid)
	{
		return crepo.findCid(cid);
	}
}