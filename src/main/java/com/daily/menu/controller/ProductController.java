package com.daily.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.menu.api.ProductApi;
import com.daily.menu.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
    @Autowired 
    private ProductService productService;

    @ApiOperation(value = "Register a product")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Product registered successfully"),
    	    @ApiResponse(code = 403, message = "You don't have permission to access this resource."),
    	    @ApiResponse(code = 500, message = "An exception was thrown"),
    	})
    @PostMapping()
    @RequestMapping(method =  RequestMethod.POST) 
    public ProductApi Post(@Valid @RequestBody ProductApi api) {
        return productService.save(api);
    }
    
    @ApiOperation(value = "Returns a list of products")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "A product list was successfully returned"),
    	    @ApiResponse(code = 403, message = "You don't have permission to access this resource."),
    	    @ApiResponse(code = 500, message = "An exception was thrown"),
    	})
    @GetMapping()
    @RequestMapping(method = RequestMethod.GET)
    public List<ProductApi> Get() {
        return productService.getAllProducts();
    }

}
