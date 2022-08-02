package com.daily.menu.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daily.menu.api.ProductApi;
import com.daily.menu.entity.Product;

@Component
public class ProductConverter {

	public Product toEntity(ProductApi api) {
		Product entity = new Product();
		
		entity.setId(api.getId());
		entity.setName(api.getName());
		entity.setFeature(api.getFeature());
		entity.setQuantity(api.getQuantity());
		
		return entity;
	}
	
	public ProductApi toApi(Product entity) {
		ProductApi api = new ProductApi();
		
		api.setId(entity.getId());
		api.setName(entity.getName());
		api.setFeature(entity.getFeature());
		api.setQuantity(entity.getQuantity());
		
		return api;
	}
	
	public List<ProductApi> toListApi(List<Product> entityList){
		
		List<ProductApi> apiList = new ArrayList<ProductApi>();
	
		entityList.stream().forEach(entity -> apiList.add(this.toApi(entity)));
		
		return apiList;       
	}
	
}
