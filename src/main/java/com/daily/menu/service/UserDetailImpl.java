package com.daily.menu.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.daily.menu.data.UserDataDetail;
import com.daily.menu.entity.User;
import com.daily.menu.repository.UserRepository;

@Component
public class UserDetailImpl implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	public UserDetailImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByLogin(username);
		
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("User ["+ username + "] not found!");
		}
		
		return new UserDataDetail(user);
	}

}
