package com.poc.scalablelogin.service;

import com.poc.scalablelogin.data.LogonData;

public interface AuthenticationService {

    public String logon(LogonData logonData);

    public String validateToken(String token);

}
