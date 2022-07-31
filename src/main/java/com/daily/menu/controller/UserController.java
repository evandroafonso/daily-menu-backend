package com.daily.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.menu.api.UserApi;
import com.daily.menu.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
    @Autowired 
    private UserService userService;
    
    @ApiOperation(value = "Register a user")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "User registered successfully"),
    	    @ApiResponse(code = 403, message = "You don't have permission to access this resource."),
    	    @ApiResponse(code = 500, message = "An exception was thrown"),
    	})
    @PostMapping()
    @RequestMapping(method =  RequestMethod.POST) 
    public UserApi Post(@Valid @RequestBody UserApi api) {
        return userService.save(api);
    }
    
    @ApiOperation(value = "Register a user")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "User listed successfully"),
    	    @ApiResponse(code = 403, message = "You don't have permission to access this resource."),
    	    @ApiResponse(code = 500, message = "An exception was thrown"),
    	})
	@GetMapping("/listAll")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserApi>> listAll(){
		return ResponseEntity.ok(userService.getAllUsers());
	}

}
