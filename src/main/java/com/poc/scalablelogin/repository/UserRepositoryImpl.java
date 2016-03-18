package com.poc.scalablelogin.repository;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String KEY = "users";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOps;

    public String getPassword(String userName) {
	return hashOps.get(KEY, userName);
    }

}
