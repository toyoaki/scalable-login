package com.poc.scalablelogin.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.scalablelogin.data.LogonData;
import com.poc.scalablelogin.service.AuthenticationService;

@Controller
@RequestMapping("/logon")
public class LogonController {

    @Autowired
    private AuthenticationService logonService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> logon(@RequestBody LogonData logonData) {
	String securityToken = logonService.logon(logonData);
	return StringUtils.isEmpty(securityToken) ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
		: ResponseEntity.ok(String.format("{\"token\": \"%s\"}", securityToken));
    }

}
