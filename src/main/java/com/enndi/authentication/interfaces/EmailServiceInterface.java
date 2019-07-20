/**
 * 
 */
package com.enndi.authentication.interfaces;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.enndi.authentication.model.User;

/**
 * @author gustavo
 *
 */
public interface EmailServiceInterface {

	void sendEmail(SimpleMailMessage msg);

	void sendNewPasswordEmail(User user, String newPassword);

	void sendHtmlEmail(MimeMessage msg);
}
