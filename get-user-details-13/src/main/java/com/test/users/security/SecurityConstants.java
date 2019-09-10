package com.test.users.security;

import com.test.users.SpringApplicationContext;

public class SecurityConstants {

	public static final long expirationTime = 864000000; //10 days
	public static final String tokenPrefix	= "myprefix";
	public static final String headerString = "Authorization";
	public static final String signUpUrl	= "/users";
	
	public static String getTokenSecret()
	{
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
		return appProperties.getTokenSecret();
	}
}
