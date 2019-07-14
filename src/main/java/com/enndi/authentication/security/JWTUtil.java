/**
 * 
 */
package com.enndi.authentication.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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

	public boolean validToken(String token) {
		Claims claims = getClaims(token);
		boolean valid = false;
		if (claims != null) {
			String userName = claims.getSubject();
			Date expiration = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (userName != null && expiration != null && now.before(expiration)) {
				valid = true;
			}
		}
		return valid;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	public String getUserName(String token) {
		Claims claims = getClaims(token);
		String userName = null;
		if (claims != null) {
			userName = claims.getSubject();
		}
		return userName;
	}
}
