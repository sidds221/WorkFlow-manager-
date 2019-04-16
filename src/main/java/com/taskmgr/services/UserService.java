package com.taskmgr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskmgr.entities.Role;
import com.taskmgr.entities.User;
import com.taskmgr.repositories.UserRepository;


@Service
public class UserService {

	UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void createUser(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public void createAdmin(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public User findOne(String email) {
	
//		Optional<User> user = userRepository.findById(email);
//		
//		//if doesnt work try this: 
//		 
//		
//		if(user.isPresent()) {
//			User u = user.get();
//			return u;
//		}
//		return null;
		
//	Optional<User> u = userRepository.findById(email);
//		
//			User user = null;
//		
//		if(u.isPresent()) {
//			return user = u.get();
//		}
//		return user;
		
		return userRepository.findById(email).orElse(null);
		
	}

	public boolean isUserPresent(String email) {
		
//		Optional<User> u = userRepository.findById(email);
//		
//		User user = null;
//	
//		if(u.isPresent()) {
//			user = u.get();
//			if(user!=null) {
//				return true;
//			}
//		}
//		return false;
		
		User user =  userRepository.findById(email).orElse(null);
		
		if(user!=null) {
			return true;
		}
		return false;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		
		return userRepository.findByNameLike("%"+name+"%");
	}
}
