package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class TaskManagerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerService1Application.class, args);
	}

}
