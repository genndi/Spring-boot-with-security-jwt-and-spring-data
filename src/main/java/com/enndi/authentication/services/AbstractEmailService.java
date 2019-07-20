/**
 * 
 */
package com.enndi.authentication.services;

import org.springframework.beans.factory.annotation.Value;

import com.enndi.authentication.interfaces.EmailServiceInterface;

/**
 * @author gustavo
 *
 */
public abstract class AbstractEmailService implements EmailServiceInterface {

	@Value("${default.sender}")
	private String sender;
	
	
	
}
