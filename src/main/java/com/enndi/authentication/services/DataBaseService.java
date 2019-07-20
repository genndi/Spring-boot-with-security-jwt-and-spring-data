/**
 * 
 */
package com.enndi.authentication.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author gustavo
 *
 */
@Service
public class DataBaseService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instantiateTestDatabase() throws ParseException {
		
	}

}
