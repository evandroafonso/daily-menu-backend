package com.daily.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daily.menu.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);
	
}
