package com.taskmgr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskmgr.entities.Task;
import com.taskmgr.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String listUsers(Model theModel, @RequestParam(defaultValue="") String name) {
		theModel.addAttribute("users", userService.findByName(name));
		return "views/list";
	}
	
	
	
}
