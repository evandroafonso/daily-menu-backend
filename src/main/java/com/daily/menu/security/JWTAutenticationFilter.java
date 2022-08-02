package com.daily.menu.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.daily.menu.data.UserDataDetail;
import com.daily.menu.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAutenticationFilter extends UsernamePasswordAuthenticationFilter {

	public static final int TOKEN_EXPIRATION = 900_000;
	
	private final AuthenticationManager authenticationManager;
	
	public JWTAutenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					user.getLogin(),
					user.getPassword(),
					new ArrayList<>()
					));
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to authenticate user", e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UserDataDetail userDataDetail = (UserDataDetail) authResult.getPrincipal();
		
		String token = JWT.create()
				.withSubject(userDataDetail.getUsername());
	}
	
	
}
