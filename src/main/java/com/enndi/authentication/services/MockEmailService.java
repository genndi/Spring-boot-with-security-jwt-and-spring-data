/**
 * 
 */
package com.enndi.authentication.services;

import org.springframework.mail.SimpleMailMessage;

import com.enndi.authentication.model.User;

/**
 * @author gustavo
 *
 */
public class MockEmailService extends AbstractEmailService{
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendNewPasswordEmail(User user, String newPassword) {
		// TODO Auto-generated method stub
		
	}

}
