package com.in28minutes.springboot;

import com.in28minutes.springboot.config.BasicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

	@Autowired
	private BasicConfiguration basicConfiguration;

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}

	@Profile("dev")
	@Bean
	public String dummy(){
		return "something";
	}

	@GetMapping("/dynamic-configuration")
	public Map<String, String> dynamicConfig(){
		HashMap<String, String> map = new HashMap<>();

		map.put("message", basicConfiguration.getMessage());
		map.put("value", String.valueOf(basicConfiguration.isValue()));
		map.put("number", String.valueOf(basicConfiguration.getNumber()));

		return map;
	}
}
