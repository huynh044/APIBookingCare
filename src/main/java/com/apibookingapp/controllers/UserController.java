package com.apibookingapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")

public class UserController {
	@GetMapping
	String test() {
		return "test";
	}
}
