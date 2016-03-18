package com.poc.scalablelogin.repository;

import com.poc.scalablelogin.data.Profile;

public interface ProfileRepository {

    public Profile getProfile(String userName);

}
