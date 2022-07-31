package com.daily.menu.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daily.menu.api.UserApi;
import com.daily.menu.entity.User;

@Component
public class UserConverter {

	public User toEntity(UserApi api) {
		User entity = new User();
		
		entity.setId(api.getId());
		entity.setLogin(api.getLogin());
		entity.setPassword(api.getPassword());
		
		return entity;
	}
	
	public UserApi toApi(User entity) {
		UserApi api = new UserApi();
		
		api.setId(entity.getId());
		api.setLogin(entity.getLogin());
		api.setPassword(entity.getPassword());
		
		return api;
	}
	
	public List<UserApi> toListApi(List<User> entityList){
		
		List<UserApi> apiList = new ArrayList<UserApi>();
	
		entityList.stream().forEach(entity -> apiList.add(this.toApi(entity)));
		
		return apiList;
	        
	}
	
}
