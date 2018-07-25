package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@GetMapping(value = "/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1l,"Test","Whoa"));
	}
	
}
