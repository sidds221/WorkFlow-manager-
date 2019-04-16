package com.taskmgr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmgr.entities.Mailer;
import com.taskmgr.services.NotificationService;

@RestController
public class EmailController {

	@Autowired
	private NotificationService notificationService;
	
	
	@RequestMapping("/signupSuccess")
	public String SignupSuccess() {
		
		//create user
		Mailer user = new Mailer();
		user.setFirstName("Sidd");
		user.setLastName("Sharma");
		user.setEmail("sidds221@gmail.com");
		
		//send notification
		try {
			notificationService.sendNotif(user);
		}catch(MailException exc){
			System.out.println("couldn't send yo ");
		}
		
		
		return "Thank you for signing up";
	}
	
	
}
