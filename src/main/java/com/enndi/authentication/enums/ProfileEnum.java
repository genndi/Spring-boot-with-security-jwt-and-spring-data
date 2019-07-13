/**
 * 
 */
package com.enndi.authentication.enums;

/**
 * @author gustavo
 *
 */
public enum ProfileEnum {

	ADMIN(1, "ROLE_ADMIN"), 
	USER(2, "ROLE_USER");

	private int code;
	private String description;

	private ProfileEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public static ProfileEnum toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (ProfileEnum p : ProfileEnum.values()) {
			if (code.equals(p.getCode())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Codigo de perfil invalido.");
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
