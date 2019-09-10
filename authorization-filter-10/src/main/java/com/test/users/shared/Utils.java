package com.test.users.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random generateRandom = new SecureRandom();
	private final String alfabet		= "0123abcde";
	
	private String generateRandomString(int length)
	{
		StringBuilder stringBuilder = new StringBuilder(length);
		
		for(int i = 0; i < length; i++)
		{
			stringBuilder.append(alfabet.charAt(generateRandom.nextInt(alfabet.length())));
		}
		
		return new String(stringBuilder);
	}
	
	public String generateUserId(int length)
	{
		return generateRandomString(length);
	}
}
