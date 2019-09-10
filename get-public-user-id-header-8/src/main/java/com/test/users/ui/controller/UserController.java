package com.test.users.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.users.service.UserService;
import com.test.users.shared.dto.UserDto;
import com.test.users.ui.model.request.UserDetailsRequestModel;
import com.test.users.ui.model.response.UserResponse;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser()
	{
		return "get user";
	}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserDetailsRequestModel userdetails)
	{
		UserResponse userResponse = new UserResponse();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userdetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userResponse);
		return userResponse;
	}
	
	@PutMapping
	public String updateUser()
	{
		return "update user";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user";
	}
}
