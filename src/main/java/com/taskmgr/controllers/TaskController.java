package com.taskmgr.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskmgr.entities.Mailer;
import com.taskmgr.entities.Task;
import com.taskmgr.services.NotificationService;
import com.taskmgr.services.TaskService;
import com.taskmgr.services.UserService;

@Controller
public class TaskController {

	@Autowired
	public TaskService taskService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private NotificationService notificationService;
	
	
	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session) {
		
		session.setAttribute("email",email);
		model.addAttribute("task", new Task());
		return "views/taskForm";
	}
	
	@PostMapping("/addTask")
	public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "views/taskForm";
		}
		String email = (String) session.getAttribute("email");
		taskService.addTask(task, userService.findOne(email));
		
		//setup mailing service.
		
		Mailer user = new Mailer();
		user.setFirstName("Using");
		user.setLastName("user");
		user.setEmail(email);
		
		//send notification
		try {
			notificationService.sendNotif(user);
		}catch(MailException exc){
			System.out.println("couldn't send yo ");
		}
		
		
		return "redirect:/users";
	}
	
}
