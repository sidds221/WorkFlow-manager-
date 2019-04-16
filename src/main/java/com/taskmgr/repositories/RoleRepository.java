package com.taskmgr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmgr.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, String>{
 
}
