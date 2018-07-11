package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null)
			user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		return users.stream()
			.filter(Objects::nonNull)
			.filter(u -> Objects.nonNull(u.getName()))
			.filter(u -> u.getId() == id)
			.findFirst()
			.orElse(null);
	}
	
	public User deleteById(int id) {
		User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
		users.removeIf(u -> u.getId() == id);
		
		return user;
	}
}










