package com.example.java_spring_mvc_laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptopshopApplication {

	public static void main(String[] args) {

		ApplicationContext quangduck = SpringApplication.run(LaptopshopApplication.class, args);
		for (String s : quangduck.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}

}
