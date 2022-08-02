package com.daily.menu.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTValidateFilter extends BasicAuthenticationFilter{

	public static final String HEADER_ATTRIBUTE = "Authorization";
	public static final String ATTRIBUTO_PREFIX = "Bearer ";
	
	public JWTValidateFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String attribute = request.getHeader(HEADER_ATTRIBUTE);
		
		if(attribute.isEmpty()) {
			chain.doFilter(request, response);
			return;
		}
	
		if(!attribute.startsWith(ATTRIBUTO_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = attribute.replace(ATTRIBUTO_PREFIX, "");
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				getUsernamePasswordAuthenticationToken(token);
		
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
		String user = JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.TOKEN_PASSWORD))
				.build()
				.verify(token)
				.getSubject();
		
		if (user.isEmpty()) {
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
	}
	
}
