package com.taskmgr;

/*this file keeps spring security from popping its annoying notification about UserId and Password*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NhSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(NhSystemApplication.class, args);
	}

}


