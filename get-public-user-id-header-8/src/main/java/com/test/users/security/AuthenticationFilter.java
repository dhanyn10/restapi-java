package com.test.users.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.users.SpringApplicationContext;
import com.test.users.service.UserService;
import com.test.users.shared.dto.UserDto;
import com.test.users.ui.model.request.UserLoginRequestModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager)
	{
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(
				HttpServletRequest req,
				HttpServletResponse res
			)
	throws AuthenticationException
	{
		try
		{
			UserLoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequestModel.class);
			
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getEmail(),
							creds.getPassword(),
							new ArrayList<>()
							)
					);
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth
			) throws IOException, ServletException
	{
		String username = ((User)auth.getPrincipal()).getUsername();
		
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.expirationTime))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.tokenSecret)
				.compact();
		
		UserService userService = (UserService)SpringApplicationContext.getBean("userServiceImplementation");
		UserDto userDto = userService.getUser(username);
		
		res.addHeader(SecurityConstants.headerString, SecurityConstants.tokenPrefix + token);
		res.addHeader("UserID", userDto.getUserId());
	}
}
