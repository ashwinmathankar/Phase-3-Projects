package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Category;
import com.simplilearn.entity.Product;
import com.simplilearn.entity.ProductReposit;

@Service
public class ProductService {

	@Autowired
	ProductReposit prepo;
	
	public Product addProduct(Product product)
	{
		Product p = prepo.save(product);
		return p;
	}
	
	public List<String> getAllProducts()
	{
		return prepo.findProduct();
	}
	
	public List<String> ProductById(int pid)
	{
		return prepo.findPid(pid);
	}
	
	public Product updateProduct(int pid, Product product)
	{
		Product p=prepo.getById(pid);
		p.setColor(product.getColor());
		p.setPname(product.getPname());
		p.setPrice(product.getPrice());
		p.setCategory(product.getCategory());
		prepo.save(p);
		return p;
	}
	
	public void deleteProduct(int pid)
	{
		prepo.deleteById(pid);
	}
}