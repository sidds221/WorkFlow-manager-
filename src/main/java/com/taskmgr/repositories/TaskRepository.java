package com.taskmgr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmgr.entities.Task;
import com.taskmgr.entities.User;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user); 
	
}
