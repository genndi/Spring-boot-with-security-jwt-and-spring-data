/**
 * 
 */
package com.enndi.authentication.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.enndi.authentication.security.UserSpringSecurity;

/**
 * @author gustavo
 *
 */
@Service
public class UserService {

	public static UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
