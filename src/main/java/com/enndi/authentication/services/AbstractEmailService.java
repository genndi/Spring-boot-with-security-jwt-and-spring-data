/**
 * 
 */
package com.enndi.authentication.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import com.enndi.authentication.interfaces.EmailServiceInterface;
import com.enndi.authentication.model.User;

/**
 * @author gustavo
 *
 */
public abstract class AbstractEmailService implements EmailServiceInterface {

	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendNewPasswordEmail(User user, String newPassword) {
		SimpleMailMessage sm = prepareNewPasswordEmail(user, newPassword);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(User user, String newPassword) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(user.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPassword);
		return sm;
	}
}
