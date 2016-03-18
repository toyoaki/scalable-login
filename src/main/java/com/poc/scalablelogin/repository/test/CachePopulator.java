package com.poc.scalablelogin.repository.test;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import com.poc.scalablelogin.data.Profile;

@Component
public class CachePopulator {

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOps;

    public void populateUserCache() {
	hashOps.put("users", "toyo", "123");
	hashOps.put("users", "carol", "456");
	hashOps.put("users", "marina", "789");
    }

    public void populateProfileCache() {
	hashOps.put("profiles", "toyo", new Profile("father", "Listen to the Man - George Ezra", "#66CEF5").toJson());
	hashOps.put("profiles", "carol",
		new Profile("mother", "You're Still the One - Shania Twain", "#E08585").toJson());
	hashOps.put("profiles", "marina",
		new Profile("daughter", "Upa Cavalinho - Galinha Pintadinha", "#FE3981").toJson());
    }

}
