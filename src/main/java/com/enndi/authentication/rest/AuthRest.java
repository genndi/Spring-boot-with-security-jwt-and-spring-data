/**
 * 
 */
package com.enndi.authentication.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enndi.authentication.security.JWTUtil;
import com.enndi.authentication.security.UserSpringSecurity;
import com.enndi.authentication.services.UserService;

/**
 * @author gustavo
 *
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthRest {

	@Autowired
	private JWTUtil jWTUtil;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSpringSecurity userSpringSecurity = UserService.authenticated();
		String token = jWTUtil.generateToken(userSpringSecurity.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}

}
