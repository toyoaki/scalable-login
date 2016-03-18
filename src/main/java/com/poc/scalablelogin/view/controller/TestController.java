package com.poc.scalablelogin.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.scalablelogin.repository.test.CachePopulator;

@Controller
@RequestMapping("/populate-cache")
public class TestController {

    @Autowired
    private CachePopulator cachePopulator;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String populate() {
	cachePopulator.populateUserCache();
	cachePopulator.populateProfileCache();
	return "success";
    }

}
