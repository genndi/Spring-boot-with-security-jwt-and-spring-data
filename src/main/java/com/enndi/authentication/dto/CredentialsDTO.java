/**
 * 
 */
package com.enndi.authentication.dto;

import java.io.Serializable;

/**
 * @author gustavo
 *
 */
public class CredentialsDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	public CredentialsDTO() {
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
