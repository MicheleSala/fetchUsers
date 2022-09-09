package com.fetchusersapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fetchusersapp"})
public class FetchUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchUsersApplication.class, args);
	}

}
