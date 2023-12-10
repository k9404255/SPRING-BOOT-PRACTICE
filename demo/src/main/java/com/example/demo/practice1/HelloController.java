package com.example.demo.practice1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@PostMapping(value = "/")
	public String spring() {
		return "Spring Boot!!";
	}

	@PostMapping(value = "/hello")
	public String hello() {
		return "Hello World!!";
	}
}
