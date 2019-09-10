package com.test.users.security;

public class SecurityConstants {

	public static final long expirationTime = 864000000; //10 days
	public static final String tokenPrefix	= "myprefix";
	public static final String headerString = "Authorization";
	public static final String signUpUrl	= "/users";
	public static final String tokenSecret	= "abc123";
}
