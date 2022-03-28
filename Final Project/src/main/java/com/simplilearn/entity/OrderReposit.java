package com.simplilearn.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposit extends JpaRepository<Order, Integer> {
	
	public List<Order> findByDateoforder(String dateoforder);

}
