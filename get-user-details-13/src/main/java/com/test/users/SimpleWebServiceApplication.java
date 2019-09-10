package com.test.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.users.security.AppProperties;

@SpringBootApplication
public class SimpleWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebServiceApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bcrypt()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContent()
	{
		return new SpringApplicationContext();
	}
	
	@Bean(name="AppProperties")
	public AppProperties getAppProperties()
	{
		return new AppProperties();
	}
}
