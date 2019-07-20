/**
 * 
 */
package com.enndi.authentication.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.enndi.authentication.interfaces.EmailServiceInterface;
import com.enndi.authentication.services.DataBaseService;
import com.enndi.authentication.services.MockEmailService;

/**
 * @author gustavo
 *
 */
@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DataBaseService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailServiceInterface emailService() {
		return new MockEmailService();
	}

}
