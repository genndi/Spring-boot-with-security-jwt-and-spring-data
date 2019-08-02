/**
 * 
 */
package com.enndi.authentication.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enndi.authentication.dto.UserDTO;
import com.enndi.authentication.services.UserService;

/**
 * @author gustavo
 *
 */
@RestController
@RequestMapping(value = "/util")
public class UtilsRest {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> encryptPassword(@RequestBody String pass) {
		String encode = passwordEncoder.encode(pass);
		return ResponseEntity.ok().body(encode);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok().body("Hello Util");
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> users() {
		List<UserDTO> usersDTO = this.userService.listUser();
		return ResponseEntity.ok().body(usersDTO);
	}
}
