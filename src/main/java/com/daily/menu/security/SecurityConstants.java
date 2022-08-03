package com.daily.menu.security;

public class SecurityConstants {

	  public static final String TOKEN_PASSWORD = "d36ed990-6662-425e-acf6-f333b4d70bb4";
	  public static final long EXPIRATION_TIME = 900_000; // 15 mins
	  public static final String TOKEN_PREFIX = "Bearer ";
	  public static final String HEADER_ATTRIBUTE = "Authorization";
	  public static final String SIGN_UP_URL = "/api/services/controller/user";
	  
	}