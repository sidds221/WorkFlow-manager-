package com.taskmgr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmgr.entities.Task;
import com.taskmgr.entities.User;
import com.taskmgr.repositories.TaskRepository;

@Service
public class TaskService {

	TaskRepository taskRepository;
	
	@Autowired
	private TaskService(TaskRepository taskRepository){
		this.taskRepository = taskRepository;
	}
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTask(User user){
		return taskRepository.findByUser(user);
	}

	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		taskRepository.delete(taskRepository.getOne(id));
		
		return;
	}
	
	 
	
}
