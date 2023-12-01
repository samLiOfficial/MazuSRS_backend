package com.samli.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation indicates that this class is a Spring Boot application
@SpringBootApplication
public class DemoApplication {

    // The main entry point of the application
    public static void main(String[] args) {
        // This line starts the Spring Boot application
        SpringApplication.run(DemoApplication.class, args);

        // This line prints "Hello World" to the console
        System.out.println("Hello World");
    }
}
