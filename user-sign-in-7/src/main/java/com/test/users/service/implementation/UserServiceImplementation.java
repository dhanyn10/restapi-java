package com.test.users.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.users.UserRepository;
import com.test.users.io.entity.UserEntity;
import com.test.users.service.UserService;
import com.test.users.shared.Utils;
import com.test.users.shared.dto.UserDto;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity finduserbyemail = userRepository.findByEmail(user.getEmail());
		
		if(finduserbyemail != null)
		{
			throw new RuntimeException("Record already exists");
		}
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30);
		//set public user id
		userEntity.setUserId(publicUserId);
		//encrypted password
		userEntity.setEncryptedPassword(bcrypt.encode(user.getPassword()));
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, userDto);
		
		return userDto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null)
		{
			throw new UsernameNotFoundException(email);
		}
		return new User(
					userEntity.getEmail(),
					userEntity.getEncryptedPassword(),
					new ArrayList<>()
				);
	}

}
