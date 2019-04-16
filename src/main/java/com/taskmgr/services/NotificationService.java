package com.taskmgr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.taskmgr.entities.Mailer;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotif(Mailer user) throws MailException {
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("sidkamailbox@gmail.com");
		mail.setSubject("New Task ");
		mail.setText("Hello, You have been assigned a task. Login to portal. ");
		
		javaMailSender.send(mail);
	}
	
}
