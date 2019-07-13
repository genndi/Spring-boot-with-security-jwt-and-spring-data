/**
 * 
 */
package com.enndi.authentication.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.enndi.authentication.enums.ProfileEnum;

/**
 * @author gustavo
 *
 */
public class UserSpringSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSpringSecurity() {
	}

	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param authorities
	 */
	public UserSpringSecurity(Integer id, String login, String password, Set<ProfileEnum> profiles) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.authorities = profiles.stream().map(p -> new SimpleGrantedAuthority(p.getDescription()))
				.collect(Collectors.toSet());
	}

	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
