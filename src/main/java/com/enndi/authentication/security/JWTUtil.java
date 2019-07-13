/**
 * 
 */
package com.enndi.authentication.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author gustavo
 *
 */
@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiretion}")
	private Long expiretion;

	public String generateToken(String login) {
		return Jwts.builder().setSubject(login).setExpiration(new Date(System.currentTimeMillis() + expiretion))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}
}
