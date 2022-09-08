package com.daily.menu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.menu.api.UserApi;
import com.daily.menu.converter.UserConverter;
import com.daily.menu.entity.User;
import com.daily.menu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserApi save(UserApi api) {

	User entity = userConverter.toEntity(api);

	return userConverter.toApi(userRepository.save(entity));
    }

    public List<UserApi> getAllUsers() {

	List<User> entity = userRepository.findAll();

	return userConverter.toListApi(entity);
    }

    public UserApi getUserByEmail(String email) {

	User entity = userRepository.findByEmail(email);

	return userConverter.toApi(entity);
    }

}
