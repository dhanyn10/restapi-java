package com.test.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.users.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
}
