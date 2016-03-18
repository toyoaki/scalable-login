package com.poc.scalablelogin.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Service;

@Service
public class JWTServiceImpl implements JWTService {

    private static final String JWT_KEY = "scalable_app_11";

    public String generateToken(String username) {
	// TODO: configurar token com expiração
	return Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, JWT_KEY).compact();
    }

    public String getTokenSubject(String token) {
	return Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(token).getBody().getSubject();
    }

}
