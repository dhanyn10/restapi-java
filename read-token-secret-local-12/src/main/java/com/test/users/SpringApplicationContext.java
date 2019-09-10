package com.test.users;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware{

	private static ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		appContext = context;
	}
	
	public static Object getBean(String beanName)
	{
		return appContext.getBean(beanName);
	}
}
