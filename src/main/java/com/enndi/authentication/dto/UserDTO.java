/**
 * 
 */
package com.enndi.authentication.dto;

/**
 * @author gustavo
 *
 */
public class UserDTO {

	private String name;

	private String email;

	private String password;

	private String login;

	public UserDTO() {
	}

	public UserDTO(String name, String email, String password, String login) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.login = login;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
