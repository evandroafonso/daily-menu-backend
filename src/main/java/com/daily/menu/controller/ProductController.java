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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Register a product")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Product registered successfully"),
	    @ApiResponse(responseCode = "403", description = "You don't have permission to access this resource."),
	    @ApiResponse(responseCode = "500", description = "An exception was thrown"), })
    @PostMapping()
    public ProductApi save(@Valid @RequestBody ProductApi api) {
	return productService.save(api);
    }

    @Operation(summary = "Returns a list of products")
    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "A product list was successfully returned"),
	    @ApiResponse(responseCode = "403", description = "You don't have permission to access this resource."),
	    @ApiResponse(responseCode = "500", description = "An exception was thrown"), })
    @GetMapping("/listAll")
    public List<ProductApi> listAll() {
	return productService.getAllProducts();
    }

}
