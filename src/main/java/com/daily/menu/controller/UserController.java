package com.daily.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.menu.api.UserApi;
import com.daily.menu.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Operation(summary = "Register a user")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User registered successfully"),
	    @ApiResponse(responseCode = "403", description = "You don't have permission to access this resource."),
	    @ApiResponse(responseCode = "500", description = "An exception was thrown"), })
    @PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    public UserApi Post(@Valid @RequestBody UserApi api) {
	api.setPassword(passwordEncoder.encode(api.getPassword()));
	return userService.save(api);
    }

    @Operation(summary = "List all users")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User listed successfully"),
	    @ApiResponse(responseCode = "403", description = "You don't have permission to access this resource."),
	    @ApiResponse(responseCode = "500", description = "An exception was thrown"), })
    @GetMapping("/listAll")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserApi>> listAll() {
	return ResponseEntity.ok(userService.getAllUsers());
    }

}
