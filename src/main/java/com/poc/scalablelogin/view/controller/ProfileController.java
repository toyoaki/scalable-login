package com.poc.scalablelogin.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.scalablelogin.data.Profile;
import com.poc.scalablelogin.service.AuthenticationService;
import com.poc.scalablelogin.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Profile> getProfile(
	    @RequestHeader(value = "Authority", required = false) String securityToken) {
	String username = isAuthenticated(securityToken);
	if (StringUtils.isEmpty(username)) {
	    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
	}

	return ResponseEntity.ok(profileService.getProfile(username));
    }

    // TODO: colocar verificação de segurança em um filtro
    /**
     * @return Usuário autenticado se token é valido, null caso contrário.
     */
    private String isAuthenticated(String securityToken) {
	securityToken = StringUtils.isEmpty(securityToken) ? null : securityToken.replace("Bearer ", "");
	return authenticationService.validateToken(securityToken);
    }

}
