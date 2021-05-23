package com.ufps.grupo8.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

	public JwtTokenRequest() {
		super();
	}
//	{
//		"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTYyMjAwMDM3MywiaWF0IjoxNjIxMzk1NTczfQ.MRnb7r-pi_d7ndNVqQLTA7_i8Lyk2sFl-oZoWCe-U19zLbLNIUdyLfHQNwnFM84vsGyma3hwo2czAxXRJlZk6w"
//		}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
