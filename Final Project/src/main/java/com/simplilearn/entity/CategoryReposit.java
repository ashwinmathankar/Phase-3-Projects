package com.simplilearn.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryReposit extends JpaRepository<Category, Integer> {
	
	@Query(value=("select * from category"), nativeQuery = true)
	public List<String> findCategory();
	
	@Query(value=("select category.cid,category.cname,product.pid,product.pname,product.color,product.price from category inner join product on category.cid=product.cid where category.cid= ?"), nativeQuery=true)
	public List<String> findCid(int cid);

}
