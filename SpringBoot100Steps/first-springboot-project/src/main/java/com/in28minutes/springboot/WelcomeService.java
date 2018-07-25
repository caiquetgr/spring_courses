
package com.in28minutes.springboot;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService{
	public String retrieveWelcomeMessage() {
		return "Good morning";
	}
}