package com.test.users.service.implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.users.UserRepository;
import com.test.users.io.entity.UserEntity;
import com.test.users.service.UserService;
import com.test.users.shared.dto.UserDto;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity finduserbyemail = userRepository.findByEmail(user.getEmail());
		
		if(finduserbyemail != null)
		{
			throw new RuntimeException("Record already exists");
		}
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testuserid");
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, userDto);
		
		return userDto;
	}

}
