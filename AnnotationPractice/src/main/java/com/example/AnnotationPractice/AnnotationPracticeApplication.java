package com.example.AnnotationPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")

public class AnnotationPracticeApplication {

	public static void main(String[] args) {
        SpringApplication.run(AnnotationPracticeApplication.class, args);
        System.out.println("Application Started");
	}

}
