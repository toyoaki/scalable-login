package com.poc.scalablelogin.repository;

public interface TokenRepository {
    
    public void storeToken(String token, String username);

    public String getUsername(String token);
    
}
