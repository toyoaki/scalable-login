package com.poc.scalablelogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.scalablelogin.data.Profile;
import com.poc.scalablelogin.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile getProfile(String username) {
	return profileRepository.getProfile(username);
    }

}
