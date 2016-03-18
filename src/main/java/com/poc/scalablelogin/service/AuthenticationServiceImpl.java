package com.poc.scalablelogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.poc.scalablelogin.data.LogonData;
import com.poc.scalablelogin.repository.TokenRepository;
import com.poc.scalablelogin.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JWTService jwtService;

    public String logon(LogonData logonData) {
	String username = logonData.getUsername();
	String databasePassword = userRepository.getPassword(username);

	String token = null;
	if (isValidPassword(databasePassword, logonData.getPassword())) {
	    token = generateToken(username);
	    storeToken(token, username);
	}

	return token;
    }

    // TODO: implementar esquema de senha mais robusto com uso de criptografia,
    // SALT, ...
    private boolean isValidPassword(String databasePassword, String suppliedPassword) {
	if (StringUtils.isEmpty(databasePassword) || StringUtils.isEmpty(suppliedPassword)) {
	    return false;
	}
	return databasePassword.equals(suppliedPassword);
    }

    private String generateToken(String username) {
	return jwtService.generateToken(username);
    }

    private void storeToken(String token, String username) {
	tokenRepository.storeToken(token, username);
    }

    public String validateToken(String token) {
	String username = null;
	if (!StringUtils.isEmpty(token)) {
	    String tokenUsername = tokenRepository.getUsername(token);
	    String extractedUsername = jwtService.getTokenSubject(token);
	    if (!StringUtils.isEmpty(tokenUsername) && !StringUtils.isEmpty(extractedUsername)) {
		username = tokenUsername.equals(extractedUsername) ? extractedUsername : null;
	    }
	}
	return username;
    }
    
}
