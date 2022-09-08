package com.daily.menu.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.daily.menu.entity.User;

@EnableJpaRepositories
public interface UserRepository extends CrudRepository<User, Long>{
	
    User findByEmail(String email);
	
}
