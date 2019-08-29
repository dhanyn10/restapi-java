package com.test.users.io.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users") //the table name
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 2756088752725409484L;
	
	@Id //set the variable as an id with persistence
	@GeneratedValue //set the variable auto incremented
	private long id;
}
