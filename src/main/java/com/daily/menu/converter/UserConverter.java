package com.daily.menu.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.daily.menu.api.UserApi;
import com.daily.menu.entity.User;

@Component
public class UserConverter {

    public User toEntity(UserApi api) {
	User entity = new User();

	entity.setId(api.getId());
	entity.setUsername(api.getEmail());
	entity.setPassword(api.getPassword());

	return entity;
    }

    public UserApi toApi(User entity) {
	UserApi api = new UserApi();

	api.setEmail(entity.getUsername());
	api.setPassword(entity.getPassword());

	return api;
    }

    public List<UserApi> toListApi(List<User> entityList) {

	List<UserApi> apiList = new ArrayList<UserApi>();

	entityList.stream().forEach(entity -> apiList.add(this.toApi(entity)));

	return apiList;

    }

}
