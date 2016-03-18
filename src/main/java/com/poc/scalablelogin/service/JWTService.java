package com.poc.scalablelogin.service;

public interface JWTService {

    public String generateToken(String username);

    public String getTokenSubject(String token);

}
