package com.taskmgr.controllers;

import java.security.Principal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskmgr.entities.User;
import com.taskmgr.services.NotificationService;
import com.taskmgr.services.TaskService;
import com.taskmgr.services.UserService;

@Controller
public class ProfileController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		
		String email = principal.getName();
		User user = userService.findOne(email);
		
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		return "views/profile"; 
	}
	
	@RequestMapping("/done/{id}")
	public String doneProfile(@PathVariable(value="id") long id, Principal principal) {
				
		taskService.deleteTask(id);
						
		return "redirect:/profile";
	}
	
}
