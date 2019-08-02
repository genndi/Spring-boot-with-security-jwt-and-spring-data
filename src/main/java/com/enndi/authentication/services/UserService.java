/**
 * 
 */
package com.enndi.authentication.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.enndi.authentication.dto.UserDTO;
import com.enndi.authentication.model.User;
import com.enndi.authentication.repositories.UserRepository;
import com.enndi.authentication.security.UserSpringSecurity;

/**
 * @author gustavo
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public List<UserDTO> listUser() {
		List<User> users = userRepo.findAll();
		return users.stream().map(u -> new UserDTO(u.getName(), u.getEmail(), u.getPassword(), u.getLogin()))
				.collect(Collectors.toList());
	}

	public static UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
