/**
 * 
 */
package com.enndi.authentication.exceptions;

/**
 * @author gustavo
 *
 */
public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
