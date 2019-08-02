/**
 * 
 */
package com.enndi.authentication.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enndi.authentication.model.User;
import com.enndi.authentication.repositories.UserRepository;
import com.enndi.authentication.security.UserSpringSecurity;

/**
 * @author gustavo
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepo.findByLogin(login);
		if (user == null) {
			LOG.error("Nao encontrou o usuario.");
			throw new UsernameNotFoundException(login);
		}
		LOG.debug(user.toString());
		return new UserSpringSecurity(user.getId(), user.getLogin(), user.getPassword(), user.getProfiles());
	}

}
