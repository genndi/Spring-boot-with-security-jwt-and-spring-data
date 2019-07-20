/**
 * 
 */
package com.enndi.authentication.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.enndi.authentication.exceptions.ObjectNotFoundException;
import com.enndi.authentication.model.User;
import com.enndi.authentication.repositories.UserRepository;

/**
 * @author gustavo
 *
 */
@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	private Random random = new Random();

	public void sendNewPassword(String email) {
		User user = this.userRepository.findByEmail(email);
		if (user == null) {
			throw new ObjectNotFoundException("Email not found.");
		}
		String newPassword = newPassword();
		String passEncoded = this.encoder.encode(newPassword);
		user.setPassword(passEncoded);
		this.userRepository.save(user);
//		emailService sendNewPasswordEmail(user, newPassword)
	}

	private String newPassword() {
		char[] vector = new char[16];
		for (int i = 0; i < 16; i++) {
			vector[i] = randomChar();
		}

		return new String(vector);
	}

	private char randomChar() {
		int option = random.nextInt(3);
		char randomChar = 0;
		if (option == 0) {
			randomChar = (char) (random.nextInt(10) + 48);
		} else if (option == 1) {
			randomChar = (char) (random.nextInt(26) + 65);
		} else {
			randomChar = (char) (random.nextInt(26) + 97);
		}

		return randomChar;
	}

}
