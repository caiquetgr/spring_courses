package com.in28minutes.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		
		BinarySearchImpl binarySearchImpl = appContext.getBean(BinarySearchImpl.class);
		
		int number = binarySearchImpl.binarySearch(new int[] { 1,2,5 }, 3);
		System.out.println(number);
	}
}
