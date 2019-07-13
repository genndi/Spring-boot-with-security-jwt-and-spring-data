/**
 * 
 */
package com.enndi.authentication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.enndi.authentication.enums.ProfileEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gustavo
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> profiles = new HashSet<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void addProfile(ProfileEnum profile) {
		this.profiles.add(profile.getCode());
	}

	/**
	 * @return the profiles
	 */
	public Set<ProfileEnum> getProfiles() {
		return profiles.stream().map(p -> ProfileEnum.toEnum(p)).collect(Collectors.toSet());
	}

	/**
	 * @param profiles the profiles to set
	 */
	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
