package com.poc.scalablelogin.repository;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

//TODO: implementar expiração e renovação do token
@Repository
public class TokenRepositoryImpl implements TokenRepository {

    private static final String KEY = "tokens";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOps;

    public void storeToken(String token, String username) {
	hashOps.put(KEY, token, username);
    }

    public String getUsername(String token) {
	return StringUtils.isEmpty(token) ? null : hashOps.get(KEY, token);
    }

}
