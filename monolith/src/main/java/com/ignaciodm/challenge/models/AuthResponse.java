package com.ignaciodm.challenge.models;

public class AuthResponse {

	String token;

	public AuthResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
