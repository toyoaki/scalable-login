package com.poc.scalablelogin.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Profile {

    private String userDescription;
    private String favoriteSong;
    private String backgroundColor;

    public Profile() {

    }

    public Profile(String userDescription, String favoriteSong, String backgroundColor) {
	super();
	this.userDescription = userDescription;
	this.favoriteSong = favoriteSong;
	this.backgroundColor = backgroundColor;
    }

    public String toJson() {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(this);
	} catch (JsonProcessingException e) {
	    throw new IllegalStateException(e);
	}
    }

    public String getUserDescription() {
	return userDescription;
    }

    public void setUserDescription(String userDescription) {
	this.userDescription = userDescription;
    }

    public String getFavoriteSong() {
	return favoriteSong;
    }

    public void setFavoriteSong(String favoriteSong) {
	this.favoriteSong = favoriteSong;
    }

    public String getBackgroundColor() {
	return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
	this.backgroundColor = backgroundColor;
    }

}
