package com.simplilearn.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.OrderReposit;
import com.simplilearn.entity.Order;

@Service
public class OrderService {

	@Autowired
	OrderReposit orepo;
	
	public List<Order> getAllOrders()
	{
		return orepo.findAll();
	}
	
	public List<Order> findByDate(String dateoforder)
	{
		return orepo.findByDateoforder(dateoforder);
	}
	
	public Order update(int oid, Order order)
	{
		Order o=orepo.getById(oid);
		o.setDateoforder(order.getDateoforder());
		o.setPid(order.getPid());
		o.setUid(order.getUid());
		orepo.save(o);
		return o;
	}
}
