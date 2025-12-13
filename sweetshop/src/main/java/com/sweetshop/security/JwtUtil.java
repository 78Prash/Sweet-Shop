package com.sweetshop.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${app.jwt.secret}")
	private String secret;
	
	@Value("${app.jwt.expiration-ms}")
	private long expirationMs;
	
	public String generateToken(String username, String role) {
		return Jwts.builder().setSubject(username).claim("role", role).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+expirationMs)).signWith(SignatureAlgorithm.HS256, secret).compact();
	}
	
	public Jws<Claims> validateToken(String token){
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	}
	
	public String getUsername(String token) {
		return validateToken(token).getBody().getSubject();
	}
	
	public String getRole(String token) {
		return (String) validateToken(token).getBody().get("role");
	}

}
