/**
 * 
 */
package com.enndi.authentication.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author gustavo
 *
 */
public class EmailDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Required field")
	@Email(message = "Invalid email")
	private String email;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
