package com.tyss.assessment3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {

	 @Bean
	  public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
		  LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		  bean.setPersistenceUnitName("email-unit");
		  return bean;
	  }
	
}
