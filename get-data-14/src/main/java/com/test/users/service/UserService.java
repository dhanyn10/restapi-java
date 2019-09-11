package com.test.users.service;

import com.test.users.shared.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto getUserByUserId(String userId);
}
