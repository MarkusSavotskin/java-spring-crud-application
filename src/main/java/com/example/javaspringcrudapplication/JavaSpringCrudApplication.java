package com.example.javaspringcrudapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCrudApplication.class, args);
		System.out.println("Application running on http://localhost:8080");
	}
}
