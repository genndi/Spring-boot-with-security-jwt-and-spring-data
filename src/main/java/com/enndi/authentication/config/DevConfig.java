package com.enndi.authentication.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.enndi.authentication.interfaces.EmailServiceInterface;
import com.enndi.authentication.services.DataBaseService;
import com.enndi.authentication.services.SmtpEmailService;

/**
 * @author gustavo
 *
 */
@Configuration
@Profile("dev")
public class DevConfig {
	

	@Autowired
	private DataBaseService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(strategy)) {
			return false;
		}
		this.dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailServiceInterface emailService() {
		return new SmtpEmailService();
	}

}
