package com.daily.menu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.daily.menu.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {

	User usuario = (User) authentication.getPrincipal();

	return Jwts.builder().setIssuer("IRS").setSubject(usuario.getId().toString()).setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isTokenValid(String token) {
	try {
	    Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    public Long getTokenId(String token) {
	Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	return Long.valueOf(body.getSubject());
    }

}