/**
 * 
 */
package com.enndi.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author gustavo
 *
 */
@Configuration
public class JacksonConfig {
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
//				objectMapper.registerSubtypes(SubTypeClassName1.class);
//				objectMapper.registerSubtypes(SubTypeClassName1.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
