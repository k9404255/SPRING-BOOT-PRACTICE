package com.example.demo.practice8;

import org.springframework.stereotype.Service;

@Service("MyService")
public class MyService {
	public boolean isChild(Person person) {
		return !person.getAdult();
	}

	public void action(Person person) {
		System.out.println("Hello World!");
		System.out.println(person);
	}
}
