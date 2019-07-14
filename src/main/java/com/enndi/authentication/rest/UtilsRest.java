/**
 * 
 */
package com.enndi.authentication.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gustavo
 *
 */
@RestController
@RequestMapping(value = "/util")
public class UtilsRest {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> encryptPassword(@RequestBody String pass) {
		String encode = passwordEncoder.encode(pass);
		return ResponseEntity.ok().body(encode);
	}

}