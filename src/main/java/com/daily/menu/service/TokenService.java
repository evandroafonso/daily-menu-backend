package com.daily.menu.service;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.daily.menu.entity.User;
import com.daily.menu.security.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	public String generateToken(Authentication authentication) {

		User usuario = (User) authentication.getPrincipal();

		return Jwts.builder().setIssuer("dailymenu")
                             .setSubject(usuario.getId().toString())
                             .setIssuedAt(new Date())
                             .signWith(SignatureAlgorithm.HS256, SecurityConstants.TOKEN_PASSWORD).compact();
	}
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(SecurityConstants.TOKEN_PASSWORD).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getTokenId(String token) {
		Claims body = Jwts.parser().setSigningKey(SecurityConstants.TOKEN_PASSWORD).parseClaimsJws(token).getBody();
		return Long.valueOf(body.getSubject());
	}
	
}