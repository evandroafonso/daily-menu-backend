package com.daily.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.menu.api.ProductApi;
import com.daily.menu.converter.ProductConverter;
import com.daily.menu.entity.Product;
import com.daily.menu.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private TokenService tokenService;

    @Transactional
    public ProductApi save(ProductApi api) {
        Product entity = productConverter.toEntity(api);
        entity.setIdUser(tokenService.getLoggedUser());
        return productConverter.toApi(productRepository.save(entity));
    }

    public List<ProductApi> getAllProducts() {
        List<Product> entity = productRepository.findAll();
        return productConverter.toListApi(entity);
    }

}
