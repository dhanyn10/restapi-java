package com.test.users.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = -5453927472428408094L;
	private long id;
	private String userId;
	private String firstName;
	private String lastname;
	private String email;
	private String password;
	private String encryptedpassword;
	private String emailVerifycationToken;
	private Boolean emailVerificationStatus = false;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedpassword() {
		return encryptedpassword;
	}
	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}
	public String getEmailVerifycationToken() {
		return emailVerifycationToken;
	}
	public void setEmailVerifycationToken(String emailVerifycationToken) {
		this.emailVerifycationToken = emailVerifycationToken;
	}
	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	
}
