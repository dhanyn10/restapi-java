package com.test.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.test.users.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto user);
	UserDto getUser(String email);
}
