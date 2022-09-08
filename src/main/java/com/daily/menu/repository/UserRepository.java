package com.daily.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.daily.menu.entity.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);
	
}
