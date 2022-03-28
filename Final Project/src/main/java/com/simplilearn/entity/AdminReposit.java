package com.simplilearn.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminReposit extends JpaRepository<Admin, Integer> {

}
