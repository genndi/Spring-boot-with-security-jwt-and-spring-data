/**
 * 
 */
package com.enndi.authentication.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gustavo
 *
 */
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> list = new ArrayList<FieldMessage>();

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	/**
	 * @return the list
	 */
	public List<FieldMessage> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void addError(String fieldName, String message) {
		this.list.add(new FieldMessage(fieldName, message));
	}

}
