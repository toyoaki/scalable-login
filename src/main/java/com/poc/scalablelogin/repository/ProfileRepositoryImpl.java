	package com.poc.scalablelogin.repository;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.scalablelogin.data.Profile;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private static final String KEY = "profiles";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOps;

    public Profile getProfile(String userName) {
	String json = hashOps.get(KEY, userName);
	return StringUtils.isEmpty(json) ? null : parseProfileJson(json);
    }

    private Profile parseProfileJson(String json) {
	ObjectMapper mapper = new ObjectMapper();
	try {
	    return mapper.readValue(json, Profile.class);
	} catch (IOException e) {
	    throw new IllegalStateException(e);
	}
    }

}
